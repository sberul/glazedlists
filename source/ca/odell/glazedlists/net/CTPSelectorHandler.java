/**
 * Glazed Lists
 * http://glazedlists.dev.java.net/
 *
 * COPYRIGHT 2003 O'DELL ENGINEERING LTD.
 */
package ca.odell.glazedlists.net;

// NIO is used for CTP
import java.util.*;
import java.nio.*;
import java.nio.channels.*;
import java.net.*;
import java.io.*;
// logging
import java.util.logging.*;

/**
 * The SelectorHandler walks through the list of ready keys and handles them.
 */
class CTPSelectorHandler implements CTPRunnable {
     
    /** logging */
    private static Logger logger = Logger.getLogger(CTPSelectorHandler.class.toString());

    /**
     * Handle each selection key.
     */
    public void run(Selector selector, CTPConnectionManager manager) {
        // This may block for a long time. Upon returning, the
        // selected set contains keys of the ready channels
        try {
            selector.select();
        } catch(IOException e) {
            logger.log(Level.WARNING, e.getMessage(), e);
        }
        
        // handle what's ready
        handleSelectedKeys(selector, manager);
    }
    
    /**
     * Handles all keys which are ready to be processed.
     */
    static void handleSelectedKeys(Selector selector, CTPConnectionManager manager) {
        // Iterate over the selected keys
        for(Iterator i = selector.selectedKeys().iterator(); i.hasNext(); ) {
            SelectionKey key = (SelectionKey)i.next();
            i.remove();
            
            // Is a new connection coming in?
            if(key.isAcceptable()) {
                handleAccept(key, selector, manager);
            }
            
            if(key.isConnectable()) {
                CTPConnection connection = (CTPConnection)key.attachment();
                connection.handleConnect();
                if(!key.isValid()) continue;
            }

            if(key.isReadable()) {
                CTPConnection connection = (CTPConnection)key.attachment();
                connection.handleRead();
                if(!key.isValid()) continue;
            }
            
            if(key.isWritable()) {
                CTPConnection connection = (CTPConnection)key.attachment();
                connection.handleWrite();
                if(!key.isValid()) continue;
            }
        }
    }

    /**
     * Handle an incoming connection.
     *
     * <p>This creates a CTPServerProtocol to handle the connection.
     *
     * @return the SelectionKey that is attached to the created connection.
     */
    static SelectionKey handleAccept(SelectionKey key, Selector selector, CTPConnectionManager manager) {
        // construct the channels and selectors
        SocketChannel channel = null;
        SelectionKey channelKey = null;
        try {
            // peel the connection from the SocketChannel
            ServerSocketChannel server = (ServerSocketChannel)key.channel();
            channel = server.accept();

            // configure the channel for no-blocking and selection
            if(channel == null) return null;
            channel.configureBlocking(false);
            channelKey = channel.register(selector, 0);
        } catch(IOException e) {
            // the accept failed, there's nothing to clean up
            return null;
        }

        // construct handlers for this connection
        CTPHandler handler = manager.handlerFactory.constructHandler();
        CTPConnection server = CTPConnection.server(channelKey, handler, manager);
        channelKey.attach(server);
        server.handleConnect();
        return channelKey;
    }
}
