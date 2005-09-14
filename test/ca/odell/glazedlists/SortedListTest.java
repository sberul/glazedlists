/* Glazed Lists                                                 (c) 2003-2005 */
/* http://publicobject.com/glazedlists/                      publicobject.com,*/
/*                                                     O'Dell Engineering Ltd.*/
package ca.odell.glazedlists;

// for being a JUnit test case
import junit.framework.*;
// standard collections
import java.util.*;

/**
 * This test verifies that the SortedList works.
 *
 * @author <a href="mailto:jesse@odel.on.ca">Jesse Wilson</a>
 */
public class SortedListTest extends TestCase {

    /** the source list */
    private BasicEventList unsortedList = null;

    /** the sorted list */
    private SortedList sortedList = null;

    /** for randomly choosing list indicies */
    private Random random = new Random(2);

    /**
     * Prepare for the test.
     */
    public void setUp() {
        unsortedList = new BasicEventList();
        sortedList = new SortedList(unsortedList);
    }

    /**
     * Clean up after the test.
     */
    public void tearDown() {
        unsortedList = null;
        sortedList = null;
    }

    /**
     * Test that the indexOf() and lastIndexOf() methods work if the SortedList
     * is not actually sorted.
     *
     * @see <a href="https://glazedlists.dev.java.net/issues/show_bug.cgi?id=170">Bug 170</a>
     */
    public void testIndexOfUnsorted() {
        sortedList.setComparator(null);
        sortedList.add("Riders");
        sortedList.add("Stampeders");
        sortedList.add("Bombers");
        sortedList.add("Eskimos");
        sortedList.add("Argos");
        sortedList.add("Ti-Cats");
        sortedList.add("Riders");
        sortedList.add("Als");

        assertEquals(0, sortedList.indexOf("Riders"));
        assertEquals(6, sortedList.lastIndexOf("Riders"));
        assertEquals(8, sortedList.indexOfSimulated("Riders"));
    }

    /**
     * Test to verify that the sorted list is working correctly when it is
     * applied to a list that already has values.
     */
    public void testSortBeforeAndAfter() {
        // populate a list with strings
        for(int i = 0; i < 4000; i++) {
            unsortedList.add(new Integer(random.nextInt()));
        }

        // build a control list of the desired results
        ArrayList controlList = new ArrayList();
        controlList.addAll(unsortedList);
        Collections.sort(controlList);

        // verify the lists are equal
        assertEquals(controlList, sortedList);

        // re-sort the list
        sortedList = new SortedList(unsortedList);

        // verify the lists are equal
        assertEquals(controlList, sortedList);
    }

    /**
     * Test to verify that the SortedList is working correctly when the
     * list is changing by adds, removes and deletes.
     */
    public void testSortDynamic() {
        // apply various operations to the list of Integers
        for(int i = 0; i < 4000; i++) {
            int operation = random.nextInt(4);
            int index = unsortedList.isEmpty() ? 0 : random.nextInt(unsortedList.size());

            if(operation <= 1 || unsortedList.isEmpty()) {
                unsortedList.add(index, new Integer(random.nextInt()));
            } else if(operation == 2) {
                unsortedList.remove(index);
            } else if(operation == 3) {
                unsortedList.set(index, new Integer(random.nextInt()));
            }
        }

        // build a control list of the desired results
        ArrayList controlList = new ArrayList();
        controlList.addAll(unsortedList);
        Collections.sort(controlList);

        // verify the lists are equal
        assertEquals(controlList, sortedList);
    }

    /**
     * Tests to verify that the SortedList correctly handles modification.
     *
     * This performs a sequence of operations. Each operation is performed on
     * either the sorted list or the unsorted list. The list where the operation
     * is performed is selected at random.
     */
    public void testSortedListWritable() {
        // apply various operations to the either list
        for(int i = 0; i < 4000; i++) {
            List list;
            if(random.nextBoolean()) list = sortedList;
            else list = unsortedList;
            int operation = random.nextInt(4);
            int index = list.isEmpty() ? 0 : random.nextInt(list.size());

            if(operation <= 1 || list.isEmpty()) {
                list.add(index, new Integer(random.nextInt()));
            } else if(operation == 2) {
                list.remove(index);
            } else if(operation == 3) {
                list.set(index, new Integer(random.nextInt()));
            }
        }

        // build a control list of the desired results
        ArrayList controlList = new ArrayList();
        controlList.addAll(unsortedList);
        Collections.sort(controlList);

        // verify the lists are equal
        assertEquals(controlList, sortedList);
    }


    /**
     * Tests that sorting works on a large set of filter changes.
     */
    public void testAgressiveFiltering() {
        BasicEventList source = new BasicEventList();
        IntegerArrayMatcherEditor matcherEditor = new IntegerArrayMatcherEditor(0, 0);
        FilterList filterList = new FilterList(source);
        SortedList sorted = new SortedList(filterList, new IntArrayComparator(0));

        // populate a list with 1000 random arrays between 0 and 1000
        for(int i = 0; i < 1000; i++) {
            int value = random.nextInt(1000);
            int[] array = new int[] { value, random.nextInt(2), random.nextInt(2), random.nextInt(2) };
            source.add(array);
        }

        // try ten different filters
        for(int i = 0; i < 10; i++) {
            // apply the filter
            int filterColumn = random.nextInt(3);
            matcherEditor.setFilter(filterColumn + 1, 1);

            // construct the control list
            ArrayList controlList = new ArrayList();
            controlList.addAll(filterList);
            Collections.sort(controlList, new IntArrayComparator(0));

            // verify that the control and sorted list are the same
            assertEquals(sorted.size(), controlList.size());
            for(int j = 0; j < sorted.size(); j++) {
                assertEquals(((int[])sorted.get(j))[0], ((int[])controlList.get(j))[0]);
            }
        }
    }

    /**
     * Test indexOf() consistency
     */
    public void testIndexOf() {
        BasicEventList source = new BasicEventList();
        SortedList sorted = new SortedList(source, new IntegerComparator());

        // Test containment of a 10 on an empty list
        Integer ten = new Integer(10);
        int emptyTest = sorted.indexOf(ten);
        assertEquals(-1, emptyTest);

        // Add 12 leading 1's
        Integer one = new Integer(1);
        for(int i = 0; i < 12; i++) {
            source.add(one);
        }

        // Add 13 5's in the middle
        Integer five = new Integer(5);
        for(int i = 0; i < 13; i++) {
            source.add(five);
        }

        // Add 10 trailing 9's
        Integer nine = new Integer(9);
        for(int i = 0; i < 10; i++) {
            source.add(nine);
        }

        // Look for the index of a 1
        int firstTestIndex = sorted.indexOf(one);
        assertEquals(0, firstTestIndex);

        // Look for the index of a 5
        int secondTestIndex = sorted.indexOf(five);
        assertEquals(12, secondTestIndex);

        // Look for the index of a 9
        int thirdTestIndex = sorted.indexOf(nine);
        assertEquals(25, thirdTestIndex);

        // Test containment of a 10
        int fourthTest = sorted.indexOf(ten);
        assertEquals(-1, fourthTest);
    }

    /**
     * Test indexOf() consistency with a "weak" Comparator. A weak Comparator
     * is one that returns 0 to indicate two object compare as equal even when
     * .equals() would return false.
     */
    public void testIndexOfWithWeakComparator() {
        BasicEventList source = new BasicEventList();
        SortedList sorted = new SortedList(source, GlazedLists.comparableComparator());

        final Song enterSandman = new Song("Metallica", "Enter Sandman");
        final Song masterOfPuppets = new Song("Metallica", "Master of Puppets");
        final Song battery = new Song("Metallica", "Battery");

        sorted.add(enterSandman);
        sorted.add(masterOfPuppets);

        assertEquals(0, sorted.indexOf(enterSandman));
        assertEquals(1, sorted.indexOf(masterOfPuppets));

        assertEquals(-1, sorted.indexOf(battery));
        sorted.add(battery);
        assertEquals(2, sorted.indexOf(battery));

        assertEquals(-1, sorted.indexOf(null));
        sorted.add(null);
        assertEquals(0, sorted.indexOf(null));
    }

    /**
     * Test lastIndexOf() consistency
     */
    public void testLastIndexOf() {
        BasicEventList source = new BasicEventList();
        SortedList sorted = new SortedList(source, new IntegerComparator());

        // Test containment of a 10 on an empty list
        Integer ten = new Integer(10);
        int emptyTest = sorted.lastIndexOf(ten);
        assertEquals(-1, emptyTest);

        // Add 12 leading 1's
        Integer one = new Integer(1);
        for(int i = 0; i < 12; i++) {
            source.add(one);
        }

        // Add 13 5's in the middle
        Integer five = new Integer(5);
        for(int i = 0; i < 13; i++) {
            source.add(five);
        }

        // Add 10 trailing 9's
        Integer nine = new Integer(9);
        for(int i = 0; i < 10; i++) {
            source.add(nine);
        }

        // Look for the index of a 1
        int firstTestIndex = sorted.lastIndexOf(one);
        assertEquals(11, firstTestIndex);

        // Look for the index of a 5
        int secondTestIndex = sorted.lastIndexOf(five);
        assertEquals(24, secondTestIndex);

        // Look for the index of a 9
        int thirdTestIndex = sorted.lastIndexOf(nine);
        assertEquals(34, thirdTestIndex);

        // Test containment of a 10
        int fourthTest = sorted.lastIndexOf(ten);
        assertEquals(-1, fourthTest);
    }

     /**
      * Test lastIndexOf() consistency with a "weak" Comparator. A weak Comparator
      * is one that returns 0 to indicate two object compare as equal even when
      * .equals() would return false.
      */
    public void testLastIndexOfWithWeakComparator() {
        BasicEventList source = new BasicEventList();
        SortedList sorted = new SortedList(source, GlazedLists.comparableComparator());

        final Song enterSandman = new Song("Metallica", "Enter Sandman");
        final Song masterOfPuppets = new Song("Metallica", "Master of Puppets");
        final Song battery = new Song("Metallica", "Battery");

        sorted.add(enterSandman);
        sorted.add(masterOfPuppets);
        sorted.add(battery);

        assertEquals(2, sorted.lastIndexOf(battery));
        assertEquals(1, sorted.lastIndexOf(masterOfPuppets));
        assertEquals(0, sorted.lastIndexOf(enterSandman));

        sorted.add(enterSandman);
        sorted.add(masterOfPuppets);
        sorted.add(battery);

        assertEquals(5, sorted.lastIndexOf(battery));
        assertEquals(4, sorted.lastIndexOf(masterOfPuppets));
        assertEquals(3, sorted.lastIndexOf(enterSandman));

        assertEquals(-1, sorted.lastIndexOf(null));
        sorted.add(null);
        assertEquals(0, sorted.lastIndexOf(null));
        sorted.add(null);
        assertEquals(1, sorted.lastIndexOf(null));
    }

    /**
     * Test containment accuracy
     */
    public void testContains() {
        BasicEventList source = new BasicEventList();
        SortedList sorted = new SortedList(source, new IntegerComparator());

        // Test containment of a 10 on an empty list
        Integer ten = new Integer(10);
        boolean emptyTest = sorted.contains(ten);
        assertEquals(false, emptyTest);

        // Add 12 leading 1's
        Integer one = new Integer(1);
        for(int i = 0; i < 12; i++) {
            source.add(one);
        }

        // Add 13 5's in the middle
        Integer five = new Integer(5);
        for(int i = 0; i < 13; i++) {
            source.add(five);
        }

        // Add 10 trailing 9's
        Integer nine = new Integer(9);
        for(int i = 0; i < 10; i++) {
            source.add(nine);
        }

        // Test containment of a 1
        boolean firstTest = sorted.contains(one);
        assertEquals(true, firstTest);

        // Test containment of a 5
        boolean secondTest = sorted.contains(five);
        assertEquals(true, secondTest);

        // Test containment of a 9
        boolean thirdTest = sorted.contains(nine);
        assertEquals(true, thirdTest);

        // Test containment of a 10
        boolean fourthTest = sorted.contains(ten);
        assertEquals(false, fourthTest);
    }


    /**
     * Test contains() consistency with a "weak" Comparator. A weak Comparator
     * is one that returns 0 to indicate two object compare as equal even when
     * .equals() would return false.
     */
    public void testContainsWithWeakComparator() {
        BasicEventList source = new BasicEventList();
        SortedList sorted = new SortedList(source, GlazedLists.comparableComparator());

        final Song enterSandman = new Song("Metallica", "Enter Sandman");
        final Song masterOfPuppets = new Song("Metallica", "Master of Puppets");
        final Song battery = new Song("Metallica", "Battery");

        sorted.add(enterSandman);
        sorted.add(masterOfPuppets);
        sorted.add(battery);

        assertTrue(sorted.contains(enterSandman));
        assertTrue(sorted.contains(masterOfPuppets));
        assertTrue(sorted.contains(battery));
        assertFalse(sorted.contains(new Song("Metallica", "One")));

        assertFalse(sorted.contains(null));
        sorted.add(null);
        assertTrue(sorted.contains(null));
    }


    /**
     * Test if the SortedList fires update events rather than delete/insert
     * pairs.
     */
    public void testUpdateEventsFired() {
        // prepare a unique list with simple data
        UniqueList uniqueSource = new UniqueList(unsortedList, GlazedLists.reverseComparator());
        sortedList = new SortedList(uniqueSource);
        SortedSet data = new TreeSet(GlazedLists.reverseComparator());
        data.add("A");
        data.add("B");
        data.add("C");
        data.add("D");
        uniqueSource.replaceAll(data);

        // listen to changes on the sorted list
        ListEventCounter counter = new ListEventCounter();
        sortedList.addListEventListener(counter);

        // replace the data with an identical copy
        uniqueSource.replaceAll(data);

        // verify that only one event has occured
        assertEquals(1, counter.getEventCount());
        assertEquals(4, counter.getChangeCount(0));
    }


    /**
     * Test if the SortedList fires update events rather than delete/insert
     * pairs, even if there are duplicate copies of the same value.
     */
    public void testUpdateEventsFiredWithDuplicates() {
        // create comparators for zero and one
        Comparator intCompareAt0 = new IntArrayComparator(0);
        Comparator intCompareAt1 = new IntArrayComparator(1);

        // prepare a unique list with simple data
        UniqueList uniqueSource = new UniqueList(new BasicEventList(), intCompareAt0);
        sortedList = new SortedList(uniqueSource, intCompareAt1);
        SortedSet data = new TreeSet(intCompareAt0);
        data.add(new int[] { 0, 0 });
        data.add(new int[] { 1, 0 });
        data.add(new int[] { 2, 0 });
        data.add(new int[] { 3, 0 });
        uniqueSource.replaceAll(data);

        // listen to changes on the sorted list
        ListEventCounter counter = new ListEventCounter();
        sortedList.addListEventListener(counter);

        // replace the data with an identical copy
        uniqueSource.replaceAll(data);

        // verify that only one event has occured
        assertEquals(1, counter.getEventCount());
        assertEquals(4, counter.getChangeCount(0));
    }

    /**
     * Tests that remove() works, removing the first instance of an element that
     * equals() the specified element.
     */
    public void testRemoveWithNoComparator() {
        EventList basic = new BasicEventList();
        SortedList sorted = new SortedList(basic, null);
        basic.addAll(charsToList("JamesLemieux"));
        sorted.remove("e");
        assertEquals(charsToList("JamsLemieux"), sorted);
        assertEquals(charsToList("JamsLemieux"), basic);
        sorted.remove("e");
        assertEquals(charsToList("JamsLmieux"), sorted);
        assertEquals(charsToList("JamsLmieux"), basic);
        sorted.remove("e");
        assertEquals(charsToList("JamsLmiux"), sorted);
        assertEquals(charsToList("JamsLmiux"), basic);
        sorted.remove("e");
        assertEquals(charsToList("JamsLmiux"), sorted);
        assertEquals(charsToList("JamsLmiux"), basic);
        sorted.remove("m");
        assertEquals(charsToList("JasLmiux"), sorted);
        assertEquals(charsToList("JasLmiux"), basic);
        sorted.remove("m");
        assertEquals(charsToList("JasLiux"), sorted);
        assertEquals(charsToList("JasLiux"), basic);
        sorted.remove("m");
        assertEquals(charsToList("JasLiux"), sorted);
        assertEquals(charsToList("JasLiux"), basic);
    }

    /**
     * Tests that remove() works, removing the first instance of an element that
     * equals() the specified element.
     */
    public void testRemoveWithWeakComparator() {
        EventList basic = new BasicEventList();
        SortedList sorted = new SortedList(basic, GlazedLists.caseInsensitiveComparator());
        basic.addAll(charsToList("aAaBbBcCC"));
        sorted.remove("A");
        assertEquals(charsToList("aaBbBcCC"), sorted);
        assertEquals(charsToList("aaBbBcCC"), basic);
        sorted.remove("B");
        assertEquals(charsToList("aabBcCC"), sorted);
        assertEquals(charsToList("aabBcCC"), basic);
        sorted.remove("C");
        assertEquals(charsToList("aabBcC"), sorted);
        assertEquals(charsToList("aabBcC"), basic);
        sorted.remove("C");
        assertEquals(charsToList("aabBc"), sorted);
        assertEquals(charsToList("aabBc"), basic);
        sorted.remove("a");
        assertEquals(charsToList("abBc"), sorted);
        assertEquals(charsToList("abBc"), basic);
        sorted.remove("d");
        assertEquals(charsToList("abBc"), sorted);
        assertEquals(charsToList("abBc"), basic);
        sorted.remove("B");
        assertEquals(charsToList("abc"), sorted);
        assertEquals(charsToList("abc"), basic);
        sorted.remove("B");
        assertEquals(charsToList("abc"), sorted);
        assertEquals(charsToList("abc"), basic);
        sorted.remove("A");
        assertEquals(charsToList("abc"), sorted);
        assertEquals(charsToList("abc"), basic);
        sorted.remove("C");
        assertEquals(charsToList("abc"), sorted);
        assertEquals(charsToList("abc"), basic);
        sorted.remove("a");
        assertEquals(charsToList("bc"), sorted);
        assertEquals(charsToList("bc"), basic);
        sorted.remove("c");
        assertEquals(charsToList("b"), sorted);
        assertEquals(charsToList("b"), basic);
        sorted.remove("c");
        assertEquals(charsToList("b"), sorted);
        assertEquals(charsToList("b"), basic);
        sorted.remove("B");
        assertEquals(charsToList("b"), sorted);
        assertEquals(charsToList("b"), basic);
        sorted.remove("b");
        assertEquals(charsToList(""), sorted);
        assertEquals(charsToList(""), basic);
        sorted.remove("b");
        assertEquals(charsToList(""), sorted);
        assertEquals(charsToList(""), basic);
    }

    /**
     * Tests that remove() works, removing the first instance of an element that
     * equals() the specified element.
     */
    public void testRemoveWithComparator() {
        EventList basic = new BasicEventList();
        SortedList sorted = new SortedList(basic, GlazedLists.comparableComparator());
        basic.addAll(charsToList("ABBCaabcc"));
        sorted.remove("a");
        assertEquals(charsToList("ABBCabcc"), basic);
        assertEquals(charsToList("ABBCabcc"), sorted);
        sorted.remove("B");
        assertEquals(charsToList("ABCabcc"), basic);
        assertEquals(charsToList("ABCabcc"), sorted);
        sorted.remove("c");
        assertEquals(charsToList("ABCabc"), basic);
        assertEquals(charsToList("ABCabc"), sorted);
        sorted.remove("d");
        assertEquals(charsToList("ABCabc"), basic);
        assertEquals(charsToList("ABCabc"), sorted);
        sorted.remove("C");
        assertEquals(charsToList("ABabc"), basic);
        assertEquals(charsToList("ABabc"), sorted);
        sorted.remove("B");
        assertEquals(charsToList("Aabc"), basic);
        assertEquals(charsToList("Aabc"), sorted);
        sorted.remove("b");
        assertEquals(charsToList("Aac"), basic);
        assertEquals(charsToList("Aac"), sorted);
        sorted.remove("A");
        assertEquals(charsToList("ac"), basic);
        assertEquals(charsToList("ac"), sorted);
        sorted.remove("a");
        assertEquals(charsToList("c"), basic);
        assertEquals(charsToList("c"), sorted);
        sorted.remove("a");
        assertEquals(charsToList("c"), basic);
        assertEquals(charsToList("c"), sorted);
        sorted.remove("c");
        assertEquals(charsToList(""), basic);
        assertEquals(charsToList(""), sorted);
    }


    /**
     * Convert a String into a List of characters. For example, "Cat" becomes
     * [ 'C', 'a', 't' ].
     */
    private List charsToList(String string) {
        char[] characters = string.toCharArray();
        List result = new ArrayList(characters.length);
        for(int c = 0; c < characters.length; c++) result.add("" + characters[c]);
        return result;
    }

    /**
     * Test if the SortedList fires update events rather than delete/insert
     * pairs, when using a ReverseComparator.
     *
     * <p>The source list uses a totally different comparator than the sorted list
     * in order to guarantee the indicies have no pattern.
     */
    public void testUpdateEventsFiredRigorous() {
        // prepare a unique list with simple data
        Comparator uniqueComparator = new ReverseStringComparator();
        UniqueList uniqueSource = new UniqueList(unsortedList, uniqueComparator);
        sortedList = new SortedList(uniqueSource);

        // populate a unique source with some random elements
        for(int i = 0; i < 500; i++) {
            uniqueSource.add("" + random.nextInt(200));
        }

        // populate a replacement set with some more random elements
        SortedSet data = new TreeSet(uniqueComparator);
        for(int i = 0; i < 500; i++) {
            data.add("" + random.nextInt(200));
        }

        // calculate the number of changes expected
        List intersection = new ArrayList();
        intersection.addAll(uniqueSource);
        intersection.retainAll(data);
        int expectedUpdateCount = intersection.size();
        int expectedDeleteCount = uniqueSource.size() - expectedUpdateCount;
        int expectedInsertCount = data.size() - expectedUpdateCount;
        int expectedChangeCount = expectedUpdateCount + expectedDeleteCount + expectedInsertCount;

        // count the number of changes performed
        ListEventCounter uniqueCounter = new ListEventCounter();
        uniqueSource.addListEventListener(uniqueCounter);
        ListEventCounter sortedCounter = new ListEventCounter();
        sortedList.addListEventListener(sortedCounter);
        //sortedList.debug = true;

        // perform the change
        uniqueSource.addListEventListener(new ConsistencyTestList(uniqueSource, "unique", false));
        sortedList.addListEventListener(new ConsistencyTestList(sortedList, "sorted", false));
        uniqueSource.replaceAll(data);

        // verify our guess on the change count is correct
        assertEquals(1, uniqueCounter.getEventCount());
        assertEquals(1, sortedCounter.getEventCount());
        assertEquals(expectedChangeCount, uniqueCounter.getChangeCount(0));
        assertEquals(expectedChangeCount, sortedCounter.getChangeCount(0));
    }


    /**
     * Tests that the SortedList can handle reordering events.
     */
    public void testReorder() {
        // prepare a source list
        SortedList source = new SortedList(new BasicEventList());
        source.add("CB");
        source.add("BC");
        source.add("DD");
        source.add("AA");

        // create a sorted view of that list
        SortedList sorted = new SortedList(source, GlazedLists.reverseComparator());

        // create a consistency test
        List consistencyTestList = new ArrayList();
        consistencyTestList.addAll(sorted);

        // change the source, this should not impact its listener
        source.setComparator(new ReverseStringComparator());
        assertEquals(consistencyTestList, sorted);

        // change the source, this should not impact its listener
        source.setComparator(null);
        assertEquals(consistencyTestList, sorted);
    }

    /**
     * Verify that the sorted list works with no compatator.
     */
    public void testNoComparator() {
        List consistencyTestList = new ArrayList();
        consistencyTestList.add("A");
        consistencyTestList.add("C");
        consistencyTestList.add("B");

        SortedList sorted = new SortedList(new BasicEventList(), null);
        sorted.addAll(consistencyTestList);
        assertEquals(consistencyTestList, sorted);

        sorted.set(2, "A");
        sorted.clear();
        assertEquals(Collections.EMPTY_LIST, sorted);
    }

    /**
     * Test that values that are indistinguishable by the SortedList are ordered
     * by their index.
     */
    public void testEqualValuesOrderedByIndex() {
        // create a sorted list that cannot distinguish between the data items
        Comparator intCompareAt0 = new StringLengthComparator();
        sortedList.dispose();
        sortedList = new SortedList(unsortedList, intCompareAt0);

        // populate the unsorted list
        unsortedList.add(0, "chaos"); // c
        unsortedList.add(1, "fiery"); // c f
        unsortedList.add(2, "gecko"); // c f g
        unsortedList.add(0, "banjo"); // b c f g
        unsortedList.add(2, "dingo"); // b c d f g
        unsortedList.add(5, "hippo"); // b c d f g h
        unsortedList.add(0, "album"); // a b c d f g h
        unsortedList.add(4, "eerie"); // a b c d e f g h
        assertEquals(unsortedList, sortedList);
    }

    /**
     * Test that the SortedList doesn't get grumpy if everything is always equal.
     */
    public void testAlwaysEqualComparator() {
        Comparator alwaysEqualComparator = new AlwaysEqualComparator();
        sortedList.dispose();
        unsortedList.add(new Integer(4));
        unsortedList.add(new Integer(3));
        unsortedList.add(new Integer(1));

        sortedList = new SortedList(unsortedList, alwaysEqualComparator);
        unsortedList.add(new Integer(5));
        unsortedList.add(new Integer(3));
        unsortedList.add(new Integer(0));
        unsortedList.add(new Integer(9));
        assertEquals(unsortedList, sortedList);
    }

    /**
     * Test that the SortedList doesn't get grumpy if half the elements are null.
     */
    public void testHalfNullComparator() {
        Comparator halfNullComparator = new HalfNullComparator();
        sortedList.dispose();
        Position p = new Position(4);
        unsortedList.add(p);
        unsortedList.add(new Position(3));
        unsortedList.add(new Position(1));

        sortedList = new SortedList(unsortedList, halfNullComparator);

        p.setPosition(2);
        sortedList.set(2, p);
        assertEquals(unsortedList, sortedList);
    }

    /**
     * Tests an empty sorted list's iterator
     */
    public void testIteratorOnEmptySortedList() {
        Iterator i = sortedList.iterator();

        // validate hasNext()
        assertEquals(false, i.hasNext());

        // validate next() fires the correct exception
        try {
            i.next();
            fail("An expected Exception was not thrown.");

        } catch(NoSuchElementException e) {
            // test passes

        } catch(Exception e) {
            fail("The following Exception was not expected:\n" + e);
        }

        // validate remove() fires the correct exception
        i = sortedList.iterator();
        try {
            i.next();
            fail("An expected Exception was not thrown.");

        } catch(NoSuchElementException e) {
            // test passes

        } catch(Exception e) {
            fail("The following Exception was not expected:\n" + e);
        }
    }

    /**
     * Tests a SortedList's iterator, read-only
     */
    public void testIteratorReadOnly() {
        sortedList.add("Riders");
        sortedList.add("Stampeders");
        sortedList.add("Bombers");
        sortedList.add("Eskimos");
        sortedList.add("Argos");
        sortedList.add("Ti-Cats");
        sortedList.add("Renegades");
        sortedList.add("Als");

        String[] expected = {"Als", "Argos", "Bombers", "Eskimos", "Renegades", "Riders", "Stampeders", "Ti-Cats"};

        int counter = 0;
        for(Iterator i = sortedList.iterator(); i.hasNext(); counter++) {
            assertEquals(expected[counter], i.next());
        }

        assertEquals(expected.length, counter);
    }

    /**
     * Tests a SortedList's iterator while removing
     */
    public void testIteratorRemoves() {
        sortedList.add("Riders");
        sortedList.add("Stampeders");
        sortedList.add("Bombers");
        sortedList.add("Eskimos");
        sortedList.add("Argos");
        sortedList.add("Ti-Cats");
        sortedList.add("Renegades");
        sortedList.add("Als");

        String[] expected = {"Als", "Argos", "Bombers", "Eskimos", "Renegades", "Riders", "Stampeders", "Ti-Cats"};

        // validate remove() fires the correct exception before iteration starts
        Iterator i = sortedList.iterator();
        try {
            i.remove();
            fail("An expected Exception was not thrown.");

        } catch(NoSuchElementException e) {
            // test passes

        } catch(Exception e) {
            fail("The following Exception was not expected:\n" + e);
        }


        int counter = 0;
        for(i = sortedList.iterator(); i.hasNext(); counter++) {
            assertEquals(expected[counter], i.next());
            i.remove();
            try {
                i.remove();
                fail("An expected Exception was not thrown.");

            } catch(NoSuchElementException e) {
                // test passes

            } catch(Exception e) {
                fail("The following Exception was not expected:\n" + e);
            }
        }

        assertEquals(expected.length, counter);
        assertEquals(0, sortedList.size());

        // validate remove() fires the correct exception after all values are removed
        try {
            i.remove();
            fail("An expected Exception was not thrown.");

        } catch(NoSuchElementException e) {
            // test passes

        } catch(Exception e) {
            fail("The following Exception was not expected:\n" + e);
        }
    }

    public static void main(String[] args) {

        SortedListTest test = new SortedListTest();
        test.setUp();
        test.testHalfNullComparator();
        test.tearDown();
    }

    /**
     * Compares two objects to be equal.
     */
    class AlwaysEqualComparator implements Comparator {
        public int compare(Object a, Object b) {
            return 0;
        }
    }

    /**
     * Compares two objects with the second one always null.
     */
    class HalfNullComparator implements Comparator {
        Comparator target = GlazedLists.comparableComparator();
        public int compare(Object a, Object b) {
            return target.compare(b, null);
        }
    }

    /**
     * Simple class that sorts in the same order as its position value.
     */
    static class Position implements Comparable {
        private int position;
        public Position(int position) {
            this.position = position;
        }
        public int getPosition() { return position; }
        public void setPosition(int position) { this.position = position; }
        public String toString() {
            return "P:" + position;
        }
        public int compareTo(Object o) {
            return position - ((Position)o).position;
        }
    }

    /**
     * Compares Strings by their length.
     */
    class StringLengthComparator implements Comparator {
        public int compare(Object a, Object b) {
            String stringA = (String)a;
            String stringB = (String)b;
            return stringA.length() - stringB.length();
        }
    }

    /**
     * Explicit comparator for Kevin's sanity!
     */
    class IntegerComparator implements Comparator {
        public int compare(Object a, Object b) {
            int number1 = ((Integer)a).intValue();
            int number2 = ((Integer)b).intValue();

            return number1 - number2;
        }
    }

    /**
     * A Comparator that compares strings from end to beginning rather than
     * normally.
     */
    private static class ReverseStringComparator implements Comparator {
        public Comparator delegate = GlazedLists.comparableComparator();

        public int compare(Object a, Object b) {
            String aString = (String)a;
            String bString = (String)b;
            return delegate.compare(flip(aString), flip(bString));
        }

        public String flip(String original) {
            char[] originalAsChars = original.toCharArray();
            int length = originalAsChars.length;
            for(int i = 0; i < (length / 2); i++) {
                char temp = originalAsChars[i];
                originalAsChars[i] = originalAsChars[length - i - 1];
                originalAsChars[length - i - 1] = temp;
            }
            return new String(originalAsChars);
        }
    }

    private static class Song implements Comparable {
        String artist;
        String song;

        public Song(String artist, String song) {
            this.artist = artist;
            this.song = song;
        }

        public String getArtist() {
            return artist;
        }

        public String getSong() {
            return song;
        }

        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            final Song song1 = (Song) o;

            if (!artist.equals(song1.artist)) return false;
            if (!song.equals(song1.song)) return false;

            return true;
        }

        public int hashCode() {
            int result;
            result = artist.hashCode();
            result = 29 * result + song.hashCode();
            return result;
        }

        public int compareTo(Object o) {
            final Song song = (Song) o;
            return this.getArtist().compareTo(song.getArtist());
        }

        public String toString() {
            return this.getArtist() + " - " + this.getSong();
        }
    }
}
