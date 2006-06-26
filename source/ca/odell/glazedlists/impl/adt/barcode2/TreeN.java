/* Glazed Lists                                                 (c) 2003-2005 */
/* http://publicobject.com/glazedlists/                      publicobject.com,*/
/*                                                     O'Dell Engineering Ltd.*/
package ca.odell.glazedlists.impl.adt.barcode2;

import ca.odell.glazedlists.GlazedLists;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

/*
 M4 Macros

STANDARD M4 LOOP ---------------------------------------------------------------

m4_divert(-1)
# forloop(i, from, to, stmt)

m4_define(`forloop', `m4_pushdef(`$1', `$2')_forloop(`$1', `$2', `$3', `$4')m4_popdef(`$1')')
m4_define(`_forloop',
       `$4`'m4_ifelse($1, `$3', ,
             `m4_define(`$1', m4_incr($1))_forloop(`$1', `$2', `$3', `$4')')')
m4_divert

MACRO CODE WITH A JAVA ALTERNATIVE ---------------------------------------------
m4_define(`BEGIN_M4_MACRO', ` BEGIN M4 MACRO GENERATED CODE *'`/')
m4_define(`END_M4_MACRO', `/'`* END M4 MACRO GENERATED CODE ')
m4_define(`BEGIN_M4_ALTERNATE', `BEGIN M4 ALTERNATE CODE
/'`* ')
m4_define(`END_M4_ALTERNATE', `END ALTERNATE CODE *'`/')

NODE SPECIFIC VARIABLES & FUNCTIONS--- -----------------------------------------
m4_define(`VAR_LAST_COLOR_INDEX', `m4_eval(VAR_COLOUR_COUNT-1)')
m4_define(`originalCounti', ``originalCount'indexToBit($1)')
m4_define(`indexToBit', `m4_eval(`2 ** $1')')
m4_define(`NodeN', ``Node'VAR_COLOUR_COUNT')
m4_define(`TreeN', ``Tree'VAR_COLOUR_COUNT')
m4_define(`TreeNAsList', ``Tree'VAR_COLOUR_COUNT`AsList'')
m4_define(`TreeNIterator', ``Tree'VAR_COLOUR_COUNT`Iterator'')
m4_define(`counti', ``count'indexToBit($1)')

USE ALTERNATE CODE WHEN WE ONLY HAVE ONE COLOR ---------------------------------
m4_define(`SINGLE_ALTERNATE', m4_ifelse(VAR_COLOUR_COUNT,`1',`USE SINGLE ALTERNATE *'`/ '$1`
// IGNORE DEFAULT:',`USE DEFAULT'))
m4_define(`END_SINGLE_ALTERNATE', m4_ifelse(VAR_COLOUR_COUNT,`1',`
/'`* END SINGLE ALTERNATE',`END DEFAULT'))

SKIP SECTIONS OF CODE WHEN WE ONLY HAVE ONE COLOR ------------------------------
m4_define(`BEGIN_SINGLE_SKIP', m4_ifelse(VAR_COLOUR_COUNT,`1',`
/'`* BEGIN SINGLE SKIPPED CODE '))
m4_define(`END_SINGLE_SKIP', m4_ifelse(VAR_COLOUR_COUNT,`1',`END SINGLE SKIPPED CODE *'`/'))

*/

/**
 * Our second generation tree class.
 *
 * <p>Currently the API for this class is fairly low-level, particularly the
 * use of <code>byte</code>s as color values. This is an implementation detail,
 * exposed to maximize performance. Wherever necessary, consider creating a
 * facade around this <code>Tree</code> class that provides methods more appropriate
 * for your particular application.
 *
 * <p>This is a prototype replacement for the <code>Barcode</code> class that adds support
 * for up to seven different colors. As well, this supports values in the node.
 * It will hopefully also replace our <code>IndexedTree</code> class. This class
 * is designed after those two classes and hopefully improves upon them in
 * a few interesting ways:
 * <li>Avoid recursion wherever possible to increase performance
 * <li>Be generic to simplify handling of black/white values. These can be
 *     handled in one case rather than one case for each.
 * <li>Make the node class a dataholder only and put most of the logic in
 *     the tree class. This allows us to share different Node classes with
 *     different memory requirements, while using the same logic class
 *
 * <p>This class came into being so we could use a tree to replace
 * <code>ListEventBlock</code>s, which has only mediocre performance, particularly
 * due to having to sort elements. As well, we might be able to keep a moved
 * value in the tree, to support moved elements in <code>ListEvent</code>s.
 *
 * @author <a href="mailto:jesse@swank.ca">Jesse Wilson</a>
 */
public class TreeN<V> {

    /** the colors in the tree, used for printing purposes only */
    private final ListToByteCoder<V> coder;

    /** the tree's root, or <code>null</code> for an empty tree */
    private NodeN<V> root = null;

    /**
     * a list to add all nodes to that must be removed from
     * the tree. The nodes are removed only after the tree has been modified,
     * which allows us a chance to do rotations without losing our position
     * in the tree.
     */
    private final List<NodeN<V>> zeroQueue = new ArrayList<NodeN<V>>();

    /**
     * The comparator to use when performing ordering operations on the tree.
     * Sometimes this tree will not be sorted, so in such situations this
     * comparator will not be used.
     */
    private final Comparator<V> comparator;

    /**
     * @param coder specifies the node colors
     * @param comparator the comparator to use when ordering values within the
     *      tree. If this tree is unsorted, use the one-argument constructor.
     */
    public TreeN/**/(ListToByteCoder<V> coder, Comparator<V> comparator) {
        if(coder == null) throw new NullPointerException("Coder cannot be null.");
        if(comparator == null) throw new NullPointerException("Comparator cannot be null.");

        this.coder = coder;
        this.comparator = comparator;
    }

    /**
     * @param coder specifies the node colors
     */
    public TreeN/**/(ListToByteCoder<V> coder) {
        this(coder, (Comparator)GlazedLists.comparableComparator());
    }


    public ListToByteCoder<V> getCoder() {
        return coder;
    }

    public Comparator<V> getComparator() {
        return comparator;
    }

    /**
     * Get the tree element at the specified index relative to the specified index
     * colors.
     *
     * <p>This method is an hotspot, so its crucial that it run as efficiently
     * as possible.
     */
    public Element<V> get(int index /* SINGLE_ALTERNATE */, byte indexColors /* END_SINGLE_ALTERNATE */) {
        if(root == null) throw new IndexOutOfBoundsException();

        // go deep, looking for our node of interest
        NodeN<V> node = root;
        while(true) {
            assert(node != null);
            assert(index >= 0);

            // recurse on the left
            NodeN<V> nodeLeft = node.left;
            int leftSize = nodeLeft != null ? nodeLeft./* SINGLE_ALTERNATE(`count1') */ size(indexColors) /* END_SINGLE_ALTERNATE */ : 0;
            if(index < leftSize) {
                node = nodeLeft;
                continue;
            } else {
                index -= leftSize;
            }

            // the result is in the centre
            int size = node./* SINGLE_ALTERNATE(`size') */ nodeSize(indexColors) /* END_SINGLE_ALTERNATE */;
            if(index < size) {
                return node;
            } else {
                index -= size;
            }

            // the result is on the right
            node = node.right;
        }
    }

    /**
     * Add a tree node at the specified index relative to the specified index
     * colors. The inserted nodes' color, value and size are specified.
     *
     * <p><strong>Note that nodes with <code>null</code> values will never be
     * merged together to allow those nodes to be assigned other values later.
     *
     * @param size the size of the node to insert.
     * @param index the location into this tree to insert at
     * @param indexColors the colors that index is relative to. This should be
     *      all colors in the tree ORed together for the entire tree.
     * @param value the node value. If non-<code>null</code>, the node may be
     *      combined with other nodes of the same color and value. <code>null</code>
     *      valued nodes will never be combined with each other.
     * @return the element the specified value was inserted into. This is non-null
     *      unless the size parameter is 0, in which case the result is always
     *      <code>null</code>.
     */
    public Element<V> add(int index, /* SINGLE_ALTERNATE */ byte indexColors, byte color, /* END_SINGLE_ALTERNATE */ V value, int size) {
        assert(index >= 0);
        assert(index <= size(/* SINGLE_ALTERNATE */ indexColors /* END_SINGLE_ALTERNATE */));
        assert(size >= 0);

        if(this.root == null) {
            if(index != 0) throw new IndexOutOfBoundsException();

            this.root = new NodeN<V>(/* SINGLE_ALTERNATE */ color, /* END_SINGLE_ALTERNATE */ size, value, null);
            assert(valid());
            return this.root;
        } else {
            NodeN<V> inserted = insertIntoSubtree(root, index, /* SINGLE_ALTERNATE */ indexColors, color, /* END_SINGLE_ALTERNATE */ value, size);
            assert(valid());
            return inserted;
        }
    }

    /**
     * @param parent the subtree to insert into, must not be null.
     * @param index the color index to insert at
     * @param indexColors a bitmask of all colors that the index is defined in
     *      terms of. For example, if this is determined in terms of colors 4, 8
     *      and 32, then the value here should be 44 (32 + 8 + 4).
     * @param color a bitmask value such as 1, 2, 4, 8, 16, 32, 64 or 128.
     * @param value the object to hold in the inserted node.
     * @param size the size of the inserted node, with respect to indices.
     * @return the inserted node, or the modified node if this insert simply
     *      increased the size of an existing node.
     */
    private NodeN<V> insertIntoSubtree(NodeN<V> parent, int index, /* SINGLE_ALTERNATE */ byte indexColors, byte color, /* END_SINGLE_ALTERNATE */ V value, int size) {
        while(true) {
            assert(parent != null);
            assert(index >= 0);

            // figure out the layout of this node
            NodeN<V> parentLeft = parent.left;
            int parentLeftSize = parentLeft != null ? parentLeft./* SINGLE_ALTERNATE(`count1') */ size(indexColors) /* END_SINGLE_ALTERNATE */ : 0;
            int parentRightStartIndex = parentLeftSize + parent./* SINGLE_ALTERNATE(`size') */ nodeSize(indexColors) /* END_SINGLE_ALTERNATE */;

            // the first thing we want to try is to merge this value into the
            // current node, since that's the cheapest thing to do:
            if(/* SINGLE_ALTERNATE */ color == parent.color &&  /* END_SINGLE_ALTERNATE */ value == parent.value && value != null) {
                if(index >= parentLeftSize && index <= parentRightStartIndex) {
                    parent.size += size;
                    fixCountsThruRoot(parent, /* SINGLE_ALTERNATE */ color, /* END_SINGLE_ALTERNATE */ size);
                    return parent;
                }
            }

            // we can insert on the left
            if(index <= parentLeftSize) {
                // as a new left child
                if(parentLeft == null) {
                    NodeN<V> inserted = new NodeN<V>(/* SINGLE_ALTERNATE */ color, /* END_SINGLE_ALTERNATE */ size, value, parent);
                    parent.left = inserted;
                    fixCountsThruRoot(parent, /* SINGLE_ALTERNATE */ color, /* END_SINGLE_ALTERNATE */ size);
                    fixHeightPostChange(parent, false);
                    return inserted;

                // recurse on the left
                } else {
                    parent = parentLeft;
                    continue;
                }
            }

            // we need to insert in the centre. This works by splitting in the
            // centre, and inserting the value
            if(index < parentRightStartIndex) {
                int parentRightHalfSize = parentRightStartIndex - index;
                parent.size -= parentRightHalfSize;
                fixCountsThruRoot(parent, /* SINGLE_ALTERNATE */ parent.color, /* END_SINGLE_ALTERNATE */ -parentRightHalfSize);
                // insert as null first to make sure this doesn't get merged back
                Element<V> inserted = insertIntoSubtree(parent, index, /* SINGLE_ALTERNATE */ indexColors, parent.color, /* END_SINGLE_ALTERNATE */ null, parentRightHalfSize);
                inserted.set(parent.value);

                // recalculate parentRightStartIndex, since that should have
                // changed by now. this will then go on to insert on the right
                parentRightStartIndex = parentLeftSize + parent./* SINGLE_ALTERNATE(`size') */ nodeSize(indexColors) /* END_SINGLE_ALTERNATE */;
            }

            // on the right
            right: {
                int parentSize = parent./* SINGLE_ALTERNATE(`count1') */ size(indexColors) /* END_SINGLE_ALTERNATE */;
                assert(index <= parentSize);
                NodeN<V> parentRight = parent.right;

                // as a right child
                if(parentRight == null) {
                    NodeN<V> inserted = new NodeN<V>(/* SINGLE_ALTERNATE */ color, /* END_SINGLE_ALTERNATE */ size, value, parent);
                    parent.right = inserted;
                    fixCountsThruRoot(parent, /* SINGLE_ALTERNATE */ color, /* END_SINGLE_ALTERNATE */ size);
                    fixHeightPostChange(parent, false);
                    return inserted;

                // recurse on the right
                } else {
                    parent = parentRight;
                    index -= parentRightStartIndex;
                }
            }
        }
    }

    /**
     * Add a tree node in sorted order.
     *
     * @param size the size of the node to insert.
     * @param value the node value. If non-<code>null</code>, the node may be
     *      combined with other nodes of the same color and value. <code>null</code>
     *      valued nodes will never be combined with each other.
     * @return the element the specified value was inserted into. This is non-null
     *      unless the size parameter is 0, in which case the result is always
     *      <code>null</code>.
     */
    public Element<V> addInSortedOrder(byte color, V value, int size) {
        assert(size >= 0);

        if(this.root == null) {
            this.root = new NodeN<V>(/* SINGLE_ALTERNATE */ color, /* END_SINGLE_ALTERNATE */ size, value, null);
            assert(valid());
            return this.root;
        } else {
            NodeN<V> inserted = insertIntoSubtreeInSortedOrder(root, /* SINGLE_ALTERNATE */ color, /* END_SINGLE_ALTERNATE */ value, size);
            assert(valid());
            return inserted;
        }
    }

    /**
     * @param parent the subtree to insert into, must not be null.
     * @param color a bitmask value such as 1, 2, 4, 8, 16, 32, 64 or 128.
     * @param value the object to hold in the inserted node.
     * @param size the size of the inserted node, with respect to indices.
     * @return the inserted node, or the modified node if this insert simply
     *      increased the size of an existing node.
     */
    private NodeN<V> insertIntoSubtreeInSortedOrder(NodeN<V> parent, /* SINGLE_ALTERNATE */ byte color, /* END_SINGLE_ALTERNATE */ V value, int size) {
        while(true) {
            assert(parent != null);

            // calculating the sort side is a little tricky since we can have
            // unsorted nodes in the tree. we just look for a neighbour (ie next)
            // that is sorted, and compare with that
            int sortSide;
            for(NodeN<V> currentFollower = parent; true; currentFollower = next(currentFollower)) {
                // we've hit the end of the list, assume the element is on the left side
                if(currentFollower == null) {
                    sortSide = -1;
                    break;
                // we've found a comparable node, use it
                } else if(currentFollower.sorted) {
                    sortSide = comparator.compare(value, currentFollower.value);
                    break;
                }
            }
            //int sortSide = comparator.compare(value, parent.value);

            // the first thing we want to try is to merge this value into the
            // current node, since that's the cheapest thing to do:
            if(sortSide == 0 && /* SINGLE_ALTERNATE */ color == parent.color && /* END_SINGLE_ALTERNATE */ value == parent.value && value != null) {
                parent.size += size;
                fixCountsThruRoot(parent, /* SINGLE_ALTERNATE */ color, /* END_SINGLE_ALTERNATE */ size);
                return parent;
            }

            // insert on the left...
            boolean insertOnLeft = false;
            insertOnLeft = insertOnLeft || sortSide < 0;
            insertOnLeft = insertOnLeft || sortSide == 0 && parent.left == null;
            insertOnLeft = insertOnLeft || sortSide == 0 && parent.right != null && parent.left.height < parent.right.height;
            if(insertOnLeft) {
                NodeN<V> parentLeft = parent.left;

                // as a new left child
                if(parentLeft == null) {
                    NodeN<V> inserted = new NodeN<V>(/* SINGLE_ALTERNATE */ color, /* END_SINGLE_ALTERNATE */ size, value, parent);
                    parent.left = inserted;
                    fixCountsThruRoot(parent, /* SINGLE_ALTERNATE */ color, /* END_SINGLE_ALTERNATE */ size);
                    fixHeightPostChange(parent, false);
                    return inserted;

                // recurse on the left
                } else {
                    parent = parentLeft;
                    continue;
                }

            // ...or on the right
            } else {
                NodeN<V> parentRight = parent.right;

                // as a right child
                if(parentRight == null) {
                    NodeN<V> inserted = new NodeN<V>(/* SINGLE_ALTERNATE */ color, /* END_SINGLE_ALTERNATE */ size, value, parent);
                    parent.right = inserted;
                    fixCountsThruRoot(parent, /* SINGLE_ALTERNATE */ color, /* END_SINGLE_ALTERNATE */ size);
                    fixHeightPostChange(parent, false);
                    return inserted;

                // recurse on the right
                } else {
                    parent = parentRight;
                }
            }
        }
    }

    /**
     * Adjust counts for all nodes (including the specified node) up the tree
     * to the root. The counts of the specified color are adjusted by delta
     * (which may be positive or negative).
     */
    private final void fixCountsThruRoot(NodeN<V> node, /* SINGLE_ALTERNATE */ byte color, /* END_SINGLE_ALTERNATE */ int delta) {
        /* BEGIN_M4_MACRO
        forloop(`i', 0, VAR_LAST_COLOR_INDEX, `m4_ifelse(VAR_COLOUR_COUNT,`1',`for( ; node != null; node = node.parent) node.'counti(i)` += delta;
        ', `if(color == 'indexToBit(i)`) {
            for( ; node != null; node = node.parent) node.'counti(i)` += delta;
        }
        ')')
        END_M4_MACRO */ // BEGIN_M4_ALTERNATE
        if(color == 1) {
            for( ; node != null; node = node.parent) node.count1 += delta;
        }
        if(color == 2) {
            for( ; node != null; node = node.parent) node.count2 += delta;
        }
        if(color == 4) {
            for( ; node != null; node = node.parent) node.count4 += delta;
        }
        // END_M4_ALTERNATE
    }

    /**
     * Fix the height of the specified ancestor after inserting a child node.
     * This method short circuits when it finds the first node where the size
     * has not changed.
     *
     * @param node the root of a changed subtree. This shouldn't be called
     *      on inserted nodes, but rather their parent nodes, since only
     *      the parent nodes sizes will be changing.
     * @param allTheWayToRoot <code>true</code> to walk up the tree all the way
     *      to the tree's root, or <code>false</code> to walk up until the height
     *      is unchanged. We go to the root on a delete, since the rotate is on
     *      the opposite side of the tree, whereas on an insert we only delete
     *      as far as necessary.
     */
    private final void fixHeightPostChange(NodeN<V> node, boolean allTheWayToRoot) {

        // update the height
        for(; node != null; node = node.parent) {
            byte leftHeight = node.left != null ? node.left.height : 0;
            byte rightHeight = node.right != null ? node.right.height : 0;

            // rotate left?
            if(leftHeight > rightHeight && (leftHeight - rightHeight == 2)) {
                // do we need to rotate the left child first?
                int leftLeftHeight = node.left.left != null ? node.left.left.height : 0;
                int leftRightHeight = node.left.right != null ? node.left.right.height : 0;
                if(leftRightHeight > leftLeftHeight) {
                    rotateRight(node.left);
                }

                // finally rotate right
                node = rotateLeft(node);
            // rotate right?
            } else if(rightHeight > leftHeight && (rightHeight - leftHeight == 2)) {
                // do we need to rotate the right child first?
                int rightLeftHeight = node.right.left != null ? node.right.left.height : 0;
                int rightRightHeight = node.right.right != null ? node.right.right.height : 0;
                if(rightLeftHeight > rightRightHeight) {
                    rotateLeft(node.right);
                }

                // finally rotate left
                node = rotateRight(node);
            }

            // update the node height
            leftHeight = node.left != null ? node.left.height : 0;
            rightHeight = node.right != null ? node.right.height : 0;
            byte newNodeHeight = (byte) (Math.max(leftHeight, rightHeight) + 1);
            // if the height doesn't need updating, we might just be done!
            if(!allTheWayToRoot && node.height == newNodeHeight) return;
            // otherwise change the height and keep rotating
            node.height = newNodeHeight;
        }
    }

    /**
     * Perform an AVL rotation of the tree.
     *
     *     D               B
     *    / \   ROTATE    / \
     *   B   E  LEFT AT  A   D
     *  / \     NODE D      / \
     * A   C               C   E
     *
     * @return the new root of the subtree
     */
    private final NodeN<V> rotateLeft(NodeN<V> subtreeRoot) {
        assert(subtreeRoot.left != null);
        // subtreeRoot is D
        // newSubtreeRoot is B
        NodeN<V> newSubtreeRoot = subtreeRoot.left;

        // modify the links between nodes
        // attach C as a child of to D
        subtreeRoot.left = newSubtreeRoot.right;
        if(newSubtreeRoot.right != null) newSubtreeRoot.right.parent = subtreeRoot;
        // link b as the new root node for this subtree
        newSubtreeRoot.parent = subtreeRoot.parent;
        if(newSubtreeRoot.parent != null) {
            if(newSubtreeRoot.parent.left == subtreeRoot) newSubtreeRoot.parent.left = newSubtreeRoot;
            else if(newSubtreeRoot.parent.right == subtreeRoot) newSubtreeRoot.parent.right = newSubtreeRoot;
            else throw new IllegalStateException();
        } else {
            root = newSubtreeRoot;
        }
        // attach D as a child of B
        newSubtreeRoot.right = subtreeRoot;
        subtreeRoot.parent = newSubtreeRoot;

        // update height and counts of the old subtree root
        byte subtreeRootLeftHeight = subtreeRoot.left != null ? subtreeRoot.left.height : 0;
        byte subtreeRootRightHeight = subtreeRoot.right != null ? subtreeRoot.right.height : 0;
        subtreeRoot.height = (byte)(Math.max(subtreeRootLeftHeight, subtreeRootRightHeight) + 1);
        subtreeRoot.refreshCounts();
        // update height and counts of the new subtree root
        byte newSubtreeRootLeftHeight = newSubtreeRoot.left != null ? newSubtreeRoot.left.height : 0;
        byte newSubtreeRootRightHeight = newSubtreeRoot.right != null ? newSubtreeRoot.right.height : 0;
        newSubtreeRoot.height = (byte)(Math.max(newSubtreeRootLeftHeight, newSubtreeRootRightHeight) + 1);
        newSubtreeRoot.refreshCounts();

        return newSubtreeRoot;
    }
    private final NodeN<V> rotateRight(NodeN<V> subtreeRoot) {
        assert(subtreeRoot.right != null);
        // subtreeRoot is D
        // newSubtreeRoot is B
        NodeN<V> newSubtreeRoot = subtreeRoot.right;

        // modify the links between nodes
        // attach C as a child of to D
        subtreeRoot.right = newSubtreeRoot.left;
        if(newSubtreeRoot.left != null) newSubtreeRoot.left.parent = subtreeRoot;
        // link b as the new root node for this subtree
        newSubtreeRoot.parent = subtreeRoot.parent;
        if(newSubtreeRoot.parent != null) {
            if(newSubtreeRoot.parent.left == subtreeRoot) newSubtreeRoot.parent.left = newSubtreeRoot;
            else if(newSubtreeRoot.parent.right == subtreeRoot) newSubtreeRoot.parent.right = newSubtreeRoot;
            else throw new IllegalStateException();
        } else {
            root = newSubtreeRoot;
        }
        // attach D as a child of B
        newSubtreeRoot.left = subtreeRoot;
        subtreeRoot.parent = newSubtreeRoot;

        // update height and counts of the old subtree root
        byte subtreeRootLeftHeight = subtreeRoot.left != null ? subtreeRoot.left.height : 0;
        byte subtreeRootRightHeight = subtreeRoot.right != null ? subtreeRoot.right.height : 0;
        subtreeRoot.height = (byte)(Math.max(subtreeRootLeftHeight, subtreeRootRightHeight) + 1);
        subtreeRoot.refreshCounts();
        // update height and counts of the new subtree root
        byte newSubtreeRootLeftHeight = newSubtreeRoot.left != null ? newSubtreeRoot.left.height : 0;
        byte newSubtreeRootRightHeight = newSubtreeRoot.right != null ? newSubtreeRoot.right.height : 0;
        newSubtreeRoot.height = (byte)(Math.max(newSubtreeRootLeftHeight, newSubtreeRootRightHeight) + 1);
        newSubtreeRoot.refreshCounts();

        return newSubtreeRoot;
    }

    /**
     * Remove the specified element from the tree outright.
     */
    public void remove(Element<V> element) {
        NodeN<V> node = (NodeN<V>)element;
        assert(node.size > 0);
        assert(root != null);

        // delete the node by adding to the zero queue
        fixCountsThruRoot(node, /* SINGLE_ALTERNATE */ node.color, /* END_SINGLE_ALTERNATE */ -node.size);
        node.size = 0;
        zeroQueue.add(node);
        drainZeroQueue();

        assert(valid());
    }

    /**
     * Remove size values at the specified index. Only values of the type
     * specified in indexColors will be removed.
     *
     * <p>Note that if the two nodes on either side of the removed node could
     * be merged, they probably will not be merged by this implementation. This
     * is to simplify the implementation, but it means that when iterating a
     * tree, sometimes multiple nodes of the same color and value will be
     * encountered in sequence.
     */
    public void remove(int index, /* SINGLE_ALTERNATE */ byte indexColors, /* END_SINGLE_ALTERNATE */ int size) {
        if(size == 0) return;
        assert(index >= 0);
        assert(index + size <= size(/* SINGLE_ALTERNATE */ indexColors /* END_SINGLE_ALTERNATE */));
        assert(root != null);

        // remove values from the tree
        removeFromSubtree(root, index, /* SINGLE_ALTERNATE */ indexColors, /* END_SINGLE_ALTERNATE */ size);

        // clean up any nodes that got deleted
        drainZeroQueue();

        assert(valid());
    }

    /**
     * Prune all nodes scheduled for deletion.
     */
    private void drainZeroQueue() {
        for(int i = 0, size = zeroQueue.size(); i < size; i++) {
            NodeN<V> node = zeroQueue.get(i);
            assert(node.size == 0);

            if(node.right == null) {
                replaceChild(node, node.left);
            } else if(node.left == null) {
                replaceChild(node, node.right);
            } else {
                node = replaceEmptyNodeWithChild(node);
            }
        }
        zeroQueue.clear();
    }

    /**
     * Remove at the specified index in the specified subtree. This doesn't ever
     * remove any nodes of size zero, that's up to the caller to do after by
     * removing all nodes in the zeroQueue from the tree.
     */
    private void removeFromSubtree(NodeN<V> node, int index, /* SINGLE_ALTERNATE */ byte indexColors, /* END_SINGLE_ALTERNATE */ int size) {
        while(size > 0) {
            assert(node != null);
            assert(index >= 0);

            // figure out the layout of this node
            NodeN<V> nodeLeft = node.left;
            int leftSize = nodeLeft != null ? nodeLeft./* SINGLE_ALTERNATE(`count1') */ size(indexColors) /* END_SINGLE_ALTERNATE */ : 0;

            // delete on the left first
            if(index < leftSize) {
                // we can only remove part of our requirement on the left, so do
                // that part recursively
                if(index + size > leftSize) {
                    int toRemove = leftSize - index;
                    removeFromSubtree(nodeLeft, index, /* SINGLE_ALTERNATE */ indexColors, /* END_SINGLE_ALTERNATE */ toRemove);
                    size -= toRemove;
                    leftSize -= toRemove;
                // we can do our full delete on the left side
                } else {
                    node = nodeLeft;
                    continue;
                }
            }
            assert(index >= leftSize);

            // delete in the centre
            int rightStartIndex = leftSize + node./* SINGLE_ALTERNATE(`size') */ nodeSize(indexColors) /* END_SINGLE_ALTERNATE */;
            if(index < rightStartIndex) {
                int toRemove = Math.min(rightStartIndex - index, size);
                // decrement the appropriate counts all the way up
                node.size -= toRemove;
                size -= toRemove;
                rightStartIndex -= toRemove;
                fixCountsThruRoot(node, /* SINGLE_ALTERNATE */ node.color, /* END_SINGLE_ALTERNATE */ -toRemove);
                if(node.size == 0) zeroQueue.add(node);
                if(size == 0) return;
            }
            assert(index >= rightStartIndex);

            // delete on the right last
            index -= rightStartIndex;
            node = node.right;
        }
    }
    /**
     * Replace the specified node with the specified replacement. This does the
     * replacement, then walks up the tree to ensure heights are correct, so
     * the replacement node should have its height set first before this method
     * is called.
     */
    private void replaceChild(NodeN<V> node, NodeN<V> replacement) {
        NodeN<V> nodeParent = node.parent;

        // replace the root
        if(nodeParent == null) {
            assert(node == root);
            root = replacement;

        // replace on the left
        } else if(nodeParent.left == node) {
            nodeParent.left = replacement;

        // replace on the right
        } else if(nodeParent.right == node) {
            nodeParent.right = replacement;
        }

        // update the replacement's parent
        if(replacement != null) {
            replacement.parent = nodeParent;
        }

        // the height has changed, update that up the tree
        fixHeightPostChange(nodeParent, true);
    }
    /**
     * Replace the specified node with another node deeper in the tree. This
     * is necessary to maintain treeness through deletes.
     *
     * <p>This implementation finds the largest node in the left subtree,
     * removes it, and puts it in the specified node's place.
     *
     * @return the replacement node
     */
    private NodeN<V> replaceEmptyNodeWithChild(NodeN<V> toReplace) {
        assert(toReplace.size == 0);
        assert(toReplace.left != null);
        assert(toReplace.right != null);

        // find the rightmost child on the leftside
        NodeN<V> replacement = toReplace.left;
        while(replacement.right != null) {
            replacement = replacement.right;
        }
        assert(replacement.right == null);

        // remove that node from the tree
        fixCountsThruRoot(replacement, /* SINGLE_ALTERNATE */ replacement.color, /* END_SINGLE_ALTERNATE */ -replacement.size);
        replaceChild(replacement, replacement.left);

        // update the tree structure to point to the replacement
        replacement.left = toReplace.left;
        if(replacement.left != null) replacement.left.parent = replacement;
        replacement.right = toReplace.right;
        if(replacement.right != null) replacement.right.parent = replacement;
        replacement.height = toReplace.height;
        replacement.refreshCounts();
        replaceChild(toReplace, replacement);
        fixCountsThruRoot(replacement.parent, /* SINGLE_ALTERNATE */ replacement.color, /* END_SINGLE_ALTERNATE */ replacement.size);

        return replacement;
    }


    /**
     * Replace all values at the specified index with the specified new value.
     *
     * <p>Currently this uses a naive implementation of remove then add. If
     * it proves desirable, it may be worthwhile to optimize this implementation
     * with one that performs the remove and insert simultaneously, to save
     * on tree navigation.
     */
    public void set(int index, /* SINGLE_ALTERNATE */ byte indexColors, byte color, /* END_SINGLE_ALTERNATE */ V value, int size) {
        remove(index, /* SINGLE_ALTERNATE */ indexColors, /* END_SINGLE_ALTERNATE */ size);
        add(index, /* SINGLE_ALTERNATE */ indexColors, color, /* END_SINGLE_ALTERNATE */ value, size);
    }


    /**
     * Remove all nodes from the tree. Note that this is much faster than calling
     * remove on all elements, since the structure can be discarded instead of
     * managed during the removal.
     */
    public void clear() {
        root = null;
    }

    /**
     * Get the index of the specified element, counting only the colors
     * specified.
     *
     * <p>This method is an hotspot, so its crucial that it run as efficiently
     * as possible.
     */
    public int indexOfNode(Element<V> element, byte colorsOut) {
        NodeN<V> node = (NodeN<V>)element;

        // count all elements left of this node
        int index = node.left != null ? node.left./* SINGLE_ALTERNATE(`count1') */ size(colorsOut) /* END_SINGLE_ALTERNATE */ : 0;

        // add all elements on the left, all the way to the root
        for( ; node.parent != null; node = node.parent) {
            if(node.parent.right == node) {
                index += node.parent.left != null ? node.parent.left./* SINGLE_ALTERNATE(`count1') */ size(colorsOut) /* END_SINGLE_ALTERNATE */ : 0;
                index += node.parent./* SINGLE_ALTERNATE(`size') */ nodeSize(colorsOut) /* END_SINGLE_ALTERNATE */;
            }
        }

        return index;
    }


    /**
     * Find the index of the specified element
     *
     * @param firstIndex true to return the index of the first occurrence of the
     *     specified element,  or false for the last index.
     * @param simulated true to return an index value even if the element is not
     *     found. Otherwise -1 is returned.
     * @return an index, or -1 if simulated is false and there exists no
     *     element x in this tree such that
     *     <code>TreeN.getComparator().compare(x, element) == 0</code>.
     */
    public int indexOfValue(V element, boolean firstIndex, boolean simulated, byte colorsOut) {
        int result = 0;
        boolean found = false;

        // go deep, looking for our node of interest
        NodeN<V> node = root;
        while(true) {
            if(node == null) {
                if(found && !firstIndex) result--;
                if(found || simulated) return result;
                else return -1;
            }

            // figure out if the value is left, center or right
            int comparison = comparator.compare(element, node.get());

            // recurse on the left
            if(comparison < 0) {
                node = node.left;
                continue;
            }
            NodeN<V> nodeLeft = node.left;

            // the result is in the centre
            if(comparison == 0) {
                found = true;

                // recurse deeper on the left, looking for the first left match
                if(firstIndex) {
                    node = nodeLeft;
                    continue;
                }
            }

            // recurse on the right, increment result by left size and center size
            result += nodeLeft != null ? nodeLeft./* SINGLE_ALTERNATE(`count1') */ size(colorsOut) /* END_SINGLE_ALTERNATE */ : 0;
            result += node./* SINGLE_ALTERNATE(`size') */ nodeSize(colorsOut) /* END_SINGLE_ALTERNATE */;
            node = node.right;
        }
    }

    /**
     * Convert one index into another.
     */
    public int convertIndexColor(int index, byte indexColors, byte colorsOut) {
        if(root == null) {
            if(index == 0) return 0;
            else throw new IndexOutOfBoundsException();
        }

        int result = 0;

        // go deep, looking for our node of interest
        NodeN<V> node = root;
        while(true) {
            assert(node != null);
            assert(index >= 0);

            // figure out the layout of this node
            NodeN<V> nodeLeft = node.left;
            int leftSize = nodeLeft != null ? nodeLeft./* SINGLE_ALTERNATE(`count1') */ size(indexColors) /* END_SINGLE_ALTERNATE */ : 0;

            // recurse on the left
            if(index < leftSize) {
                node = nodeLeft;
                continue;
            // increment by the count on the left
            } else {
                if(nodeLeft != null) result += nodeLeft./* SINGLE_ALTERNATE(`count1') */ size(colorsOut) /* END_SINGLE_ALTERNATE */;
                index -= leftSize;
            }

            // the result is in the centre
            int size = node./* SINGLE_ALTERNATE(`size') */ nodeSize(indexColors) /* END_SINGLE_ALTERNATE */;
            if(index < size) {
                // we're on a node of the same color, return the adjusted index

                if(/* SINGLE_ALTERNATE(`true') */ (colorsOut & node.color) > 0 /* END_SINGLE_ALTERNATE */) {
                    result += index;
                // we're on a node of a different color, return the previous node of the requested color
                } else {
                    result -= 1;
                }
                return result;

            // increment by the count in the centre
            } else {
                result += node./* SINGLE_ALTERNATE(`size') */ nodeSize(colorsOut) /* END_SINGLE_ALTERNATE */;
                index -= size;
            }

            // the result is on the right
            node = node.right;
        }
    }

    /**
     * The size of the tree for the specified colors.
     */
    public int size(/* SINGLE_ALTERNATE */ byte colors /* END_SINGLE_ALTERNATE */) {
        if(root == null) return 0;
        else return root./* SINGLE_ALTERNATE(`count1') */ size(colors) /* END_SINGLE_ALTERNATE */;
    }

    /**
     * Print this tree as a list of values.
     */
    public String toString() {
        if(root == null) return "";
        return root.toString(coder.getColors());
    }

    /**
     * Print this tree as a list of colors, removing all hierarchy.
     */
    // BEGIN_SINGLE_SKIP
    public String asSequenceOfColors() {
        if(root == null) return "";

        // print it flattened, like a list of colors
        StringBuffer result = new StringBuffer();
        for(NodeN<V> n = firstNode(); n != null; n = next(n)) {
            Object color = coder.getColors().get(colorAsIndex(n.color));
            for(int i = 0; i < n.size; i++) {
                result.append(color);
            }
        }
        return result.toString();
    }
    // END_SINGLE_SKIP


    /**
     * Find the next node in the tree, working from left to right.
     */
    public static <V> NodeN<V> next(NodeN<V> node) {
        // if this node has a right subtree, it's the leftmost node in that subtree
        if(node.right != null) {
            NodeN<V> child = node.right;
            while(child.left != null) {
                child = child.left;
            }
            return child;

        // otherwise its the nearest ancestor where I'm in the left subtree
        } else {
            NodeN<V> ancestor = node;
            while(ancestor.parent != null && ancestor.parent.right == ancestor) {
                ancestor = ancestor.parent;
            }
            return ancestor.parent;
        }
    }


    /**
     * Find the previous node in the tree, working from right to left.
     */
    public static <V> NodeN<V> previous(NodeN<V> node) {
        // if this node has a left subtree, it's the rightmost node in that subtree
        if(node.left != null) {
            NodeN<V> child = node.left;
            while(child.right != null) {
                child = child.right;
            }
            return child;

        // otherwise its the nearest ancestor where I'm in the right subtree
        } else {
            NodeN<V> ancestor = node;
            while(ancestor.parent != null && ancestor.parent.left == ancestor) {
                ancestor = ancestor.parent;
            }
            return ancestor.parent;
        }
    }

    /**
     * Find the leftmost child in this subtree.
     */
    NodeN<V> firstNode() {
        if(root == null) return null;

        NodeN<V> result = root;
        while(result.left != null) {
            result = result.left;
        }
        return result;
    }

    /**
     * @return true if this tree is structurally valid
     */
    private boolean valid() {
        // walk through all nodes in the tree, looking for something invalid
        for(NodeN<V> node = firstNode(); node != null; node = next(node)) {
            // sizes (counts) are valid

            /* BEGIN_M4_MACRO
            forloop(`i', 0, VAR_LAST_COLOR_INDEX, `int originalCounti(i) = node.counti(i);
            ')
            END_M4_MACRO */ // BEGIN_M4_ALTERNATE
            int originalCount1 = node.count1;
            int originalCount2 = node.count2;
            int originalCount4 = node.count4;
            // END_M4_ALTERNATE
            node.refreshCounts();
            /* BEGIN_M4_MACRO
            forloop(`i', 0, VAR_LAST_COLOR_INDEX, `assert(originalCounti(i) == node.counti(i)) : "Incorrect count i on node: \n" + node  + "\n Expected " + node.counti(i) + " but was " + originalCounti(i);
            ')
            END_M4_MACRO */ // BEGIN_M4_ALTERNATE
            assert(originalCount1 == node.count1) : "Incorrect count 1 on node: \n" + node  + "\n Expected " + node.count1 + " but was " + originalCount1;
            assert(originalCount2 == node.count2) : "Incorrect count 2 on node: \n" + node  + "\n Expected " + node.count2 + " but was " + originalCount2;
            assert(originalCount4 == node.count4) : "Incorrect count 4 on node: \n" + node  + "\n Expected " + node.count4 + " but was " + originalCount4;
            // END_M4_ALTERNATE

            // heights are valid
            int leftHeight = node.left != null ? node.left.height : 0;
            int rightHeight = node.right != null ? node.right.height : 0;
            assert(Math.max(leftHeight, rightHeight) + 1 == node.height);

            // left child's parent is this
            assert(node.left == null || node.left.parent == node);

            // right child's parent is this
            assert(node.right == null || node.right.parent == node);

            // tree is AVL
            assert(Math.abs(leftHeight - rightHeight) < 2) : "Subtree is not AVL: \n" + node;
        }

        // we're valid
        return true;
    }

    /**
     * Convert the specified color value (such as 1, 2, 4, 8, 16 etc.) into an
     * index value (such as 0, 1, 2, 3, 4 etc. ).
     */
    static final int colorAsIndex(byte color) {
        switch(color) {
            case 1: return 0;
            case 2: return 1;
            case 4: return 2;
            case 8: return 3;
            case 16: return 4;
            case 32: return 5;
            case 64: return 6;
        }
        throw new IllegalArgumentException();
    }
}