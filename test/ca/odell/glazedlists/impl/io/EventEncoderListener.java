/* Glazed Lists                                                 (c) 2003-2005 */
/* http://publicobject.com/glazedlists/                      publicboject.com,*/
/*                                                     O'Dell Engineering Ltd.*/
package ca.odell.glazedlists.impl.io;

import java.util.*;
import ca.odell.glazedlists.*;
import ca.odell.glazedlists.io.*;
import ca.odell.glazedlists.event.*;
// NIO
import java.nio.*;
import java.nio.channels.*;
import java.io.*;
// for being a JUnit test case
import junit.framework.*;
import ca.odell.glazedlists.*;
// regular expressions
import java.util.regex.*;
import java.text.ParseException;
// logging
import java.util.logging.*;
import java.text.ParseException;

/**
 * Encodes List events as they arrive.
 *
 * @author <a href="mailto:jesse@swank.ca">Jesse Wilson</a>
 */
public class EventEncoderListener implements ListEventListener {
    
    /** the Bufferlo encodings */
    public List encodings = new ArrayList();
    
    /** the delegate coder for elements */
    public ByteCoder byteCoder = null;
    
    /**
     * Create a new EventEncoderListener.
     */
    public EventEncoderListener(ByteCoder byteCoder) {
        this.byteCoder = byteCoder;
    }
    
    /**
     * Handles a change by adding the encoding of the change.
     */
    public void listChanged(ListEvent listChanges) {
        try {
            Bufferlo encoding = ListEventToBytes.toBytes(listChanges, byteCoder);
            encodings.add(encoding);
        } catch(IOException e) {
            throw new IllegalStateException(e.getMessage());
        }
    }

    /**
     * Get the list of encodings, one per event received.
     */
    public List getEncodings() {
        return encodings;
    }
}
