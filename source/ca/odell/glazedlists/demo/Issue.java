/**
 * Glazed Lists
 * http://glazedlists.dev.java.net/
 *
 * COPYRIGHT 2003 O'DELL ENGINEERING LTD.
 */
package ca.odell.glazedlists.demo;

import java.util.*;
// glazed lists
import ca.odell.glazedlists.*;
import ca.odell.glazedlists.swing.*;

/**
 * An issue models a work effort either due to an existing problem or a desired
 * enhancement.
 * 
 * @author <a href="mailto:jesse@odel.on.ca">Jesse Wilson</a>
 */
public class Issue implements TextFilterable, Comparable {
    
    // mandatory issue fields
    private Integer id = null;
    private String status = null;
    private Priority priority = null;
    private String resolution = null;
    private String component = null;
    private String version = null;
    private String repPlatform = null;
    private String assignedTo = null;
    private Date deltaTimestamp = null;
    private String subcomponent = null;
    private String reporter = null;
    private String targetMilestone = null;
    private String issueType = null;
    private Date creationTimestamp = null;
    private String qaContact = null;
    private String statusWhiteboard = null;
    private String votes = null;
    private String operatingSystem = null;
    private String shortDescription = null;
    // optional fields
    private List keywords = new ArrayList();
    private List blocks = new ArrayList();
    private List dependsOn = new ArrayList();
    private List cc = new ArrayList();
    // issue lifecycle fields
    private List descriptions = new ArrayList();
    private List attachments = new ArrayList();
    private List activities = new ArrayList();

    /**
     * Creates a new empty issue.
     */
    public Issue() {
        // do nothing
    }
    
    /**
     * Creates a new issue that uses the specified issue as a template.
     */
    public Issue(Issue template) {
        id = template.id;
        status = template.status;
        priority = template.priority;
        resolution = template.resolution;
        component = template.component;
        version = template.version;
        repPlatform = template.repPlatform;
        assignedTo = template.assignedTo;
        deltaTimestamp = template.deltaTimestamp;
        subcomponent = template.subcomponent;
        reporter = template.reporter;
        targetMilestone = template.targetMilestone;
        issueType = template.issueType;
        creationTimestamp = template.creationTimestamp;
        qaContact = template.qaContact;
        statusWhiteboard = template.statusWhiteboard;
        votes = template.votes;
        operatingSystem = template.operatingSystem;
        shortDescription = template.shortDescription;
        keywords.addAll(template.keywords);
        blocks.addAll(template.blocks);
        dependsOn.addAll(template.dependsOn);
        cc.addAll(template.cc);
        descriptions.addAll(template.descriptions);
        attachments.addAll(template.attachments);
        activities.addAll(template.activities);
    }
    
    /**
     * ID of this issue (unique key).
     */
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    /**
     * Current status of this issue.
     */
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    /**
     * Priority (severity) assigned to issue.
     */
    public Priority getPriority() {
        return priority;
    }
    public void setPriority(Priority priority) {
        this.priority = priority;
    }
    /**
     * The issue's resolution, if any
     */
    public String getResolution() {
        return resolution;
    }
    public void setResolution(String resolution) {
        this.resolution = resolution;
    }
    /**
     * Product against which issue is reported.
     */
    public String getComponent() {
        return component;
    }
    public void setComponent(String component) {
        this.component = component;
    }
    /**
     * Version associated with component.
     */
    public String getVersion() {
        return version;
    }
    public void setVersion(String version) {
        this.version = version;
    }
    /**
     * Platform issue reported against (e.g. linux, etc.).
     */
    public String getRepPlatform() {
        return repPlatform;
    }
    public void setRepPlatform(String repPlatform) {
        this.repPlatform = repPlatform;
    }
    /**
     * Email of person issue currently assigned to.
     */
    public String getAssignedTo() {
        return assignedTo;
    }
    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }
    /**
     * Last modified timestamp ('yyyy-mm-dd hh:mm:ss').
     */
    public Date getDeltaTimestamp() {
        return deltaTimestamp;
    }
    public void setDeltaTimestamp(Date deltaTimestamp) {
        this.deltaTimestamp = deltaTimestamp;
    }
    /**
     * Component of component issue reported against.
     */
    public String getSubcomponent() {
        return subcomponent;
    }
    public void setSubcomponent(String subcomponent) {
        this.subcomponent = subcomponent;
    }
    /**
     * Email of initial issue reporter.
     */
    public String getReporter() {
        return reporter;
    }
    public void setReporter(String reporter) {
        this.reporter = reporter;
    }
    /**
     * Milestone for this issue's resolution.
     */
    public String getTargetMilestone() {
        return targetMilestone;
    }
    public void setTargetMilestone(String targetMilestone) {
        this.targetMilestone = targetMilestone;
    }
    /**
     * Nature of issue, e.g. defect, task, etc.
     */
    public String getIssueType() {
        return issueType;
    }
    public void setIssueType(String issueType) {
        this.issueType = issueType;
    }
    /**
     * Issue creation timestamp ('yyyy-mm-dd hh:mm:ss').
     */
    public Date getCreationTimestamp() {
        return creationTimestamp;
    }
    public void setCreationTimestamp(Date creationTimestamp) {
        this.creationTimestamp = creationTimestamp;
    }
    /**
     * Email of the QA contact for this issue.
     */
    public String getQAContact() {
        return qaContact;
    }
    public void setQAContact(String qaContact) {
        this.qaContact = qaContact;
    }
    /**
     * Free text 'whiteboard' for issue comments.
     */
    public String getStatusWhiteboard() {
        return statusWhiteboard;
    }
    public void setStatusWhiteboard(String statusWhiteboard) {
        this.statusWhiteboard = statusWhiteboard;
    }
    /**
     * current votes for issue.
     */
    public String getVotes() {
        return votes;
    }
    public void setVotes(String votes) {
        this.votes = votes;
    }
    /**
     * Operating system issue reported against.
     */
    public String getOperatingSystem() {
        return operatingSystem;
    }
    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }
    /**
     * Short description of issue.
     */
    public String getShortDescription() {
        return shortDescription;
    }
    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }
    /**
     * List of keywords for this issue. 
     */
    public List getKeywords() {
        return keywords;
    }
    /**
     * List of local issue IDs blocked by this one.
     */
    public List getBlocks() {
        return blocks;
    }
    /**
     * List of local issue IDs that depend on this one.
     */
    public List getDependsOn() {
        return dependsOn;
    }
    /**
     * List of email addresses of interested parties.s
     */
    public List getCC() {
        return cc;
    }
    /**
     * Data from the longdescs table for this issue id.  Essentially
     * the log of additional comments.       
     */
    public List getDescriptions() {
        return descriptions;
    }
    /**
     * Set the attachments to this issue.
     */
    public List getAttachments() {
        return attachments;
    }
    /**
     * Set the activity upon this issue.
     */
    public List getActivities() {
        return activities;
    }
    /**
     * Write this issue for debugging.
     */
    public String toString() {
        return "Issue " + id + ": " + shortDescription;
    }
    
    /**
     * Compares two issues by ID. 
     */
    public int compareTo(Object other) {
        if(other == null) return -1;
        Issue otherIssue = (Issue)other;
        return id.compareTo(otherIssue.id);
    }
    
    /**
     * Gets the strings to filter this issue by.
     */
    public void getFilterStrings(List baseList) {
        // the displayed strings
        baseList.add(id);
        baseList.add(issueType);
        baseList.add(priority.toString());
        baseList.add(status);
        baseList.add(resolution);
        baseList.add(shortDescription);
        
        // extra strings
        baseList.add(component);
        baseList.add(subcomponent);
        
        // recursively get filter strings from the descriptions
        for(int d = 0; d < getDescriptions().size(); d++) {
            Description description = (Description)getDescriptions().get(d);
            description.getFilterStrings(baseList);
        }
    }

    /**
     * Return a list of issues. This list is generated in an interesting way.
     * First, an XML file is paresed into a list of Issue objects. Those Issue 
     * Objects then write out the Java code necessary to create them. Finally
     * that Java code is pasted here. 
     *
     * <p>This removes the need to include an XML file and reduces parse time.
     */
    public static List loadIssues() {
        List issues = new ArrayList();
        Issue currentIssue = null;
        Description description = null;
        currentIssue = new Issue();
        currentIssue.setId(new Integer(1));
        currentIssue.setStatus("CLOSED");
        currentIssue.setPriority(Priority.P3);
        currentIssue.setResolution("FIXED");
        currentIssue.setComponent("glazedlists");
        currentIssue.setVersion("current");
        currentIssue.setAssignedTo("jessewilson");
        currentIssue.setSubcomponent("www");
        currentIssue.setIssueType("TASK");
        currentIssue.setQAContact("issues@glazedlists");
        currentIssue.setShortDescription("Improve filter performance upon list change");
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("The current implementation of filtering uses a N*N*M algorithm to re-filter when the list \nchanges, for M changes on a list of size N.\n\nIt is necessary to improve this runtime by using more appropriate data structures inside \nthe AbstractFilterList.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("Created an attachment (id=1)\nscreenshot from profiler\n");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("In creating a test case I found that the filter performance can be really bad in certain situations.\n\nI think this case can be justification for updating the AbstractFilterList to use a SparseList instead of the \ncurrent arraylist hack.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("I have changed the AbstractFilterList to use SparseList instead of the hack array data structure. The \nresults are impressive in some cases only and not noticable in other cases. This change will cause \nchange events to be orders of magnitude faster, while get() events will be slightly slower.\n\nHere is the results in elapsed time from two tests I ran, before and after the fix:\nCaseInsensitiveFilterListTest\nbefore: 3.9s\nafter: 2.8s\n\nMultipleListenersTest\nbefore: 162.9s\nafter: 19.2s");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("This bug has been fixed for two weeks with no problems. I am marking it closed.");
        currentIssue.getDescriptions().add(description);
        description = null;
        issues.add(currentIssue);
        currentIssue = null;
        currentIssue = new Issue();
        currentIssue.setId(new Integer(2));
        currentIssue.setStatus("CLOSED");
        currentIssue.setPriority(Priority.P2);
        currentIssue.setResolution("FIXED");
        currentIssue.setComponent("glazedlists");
        currentIssue.setVersion("current");
        currentIssue.setAssignedTo("jessewilson");
        currentIssue.setSubcomponent("www");
        currentIssue.setIssueType("DEFECT");
        currentIssue.setQAContact("issues@glazedlists");
        currentIssue.setShortDescription("Filter regex fails with special characters");
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("The current filter code for CaseInsensitiveFilterList fails to work when the filter text \ncontains regular-expression characters such as dot.\n\nFix this to handle special characters as they should be.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("Fixed in CVS. Added a method getMatcher() that constructs a matcher using the source \nstring");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("This bug has been fixed for two weeks with no problems. I am marking it closed.");
        currentIssue.getDescriptions().add(description);
        description = null;
        issues.add(currentIssue);
        currentIssue = null;
        currentIssue = new Issue();
        currentIssue.setId(new Integer(3));
        currentIssue.setStatus("CLOSED");
        currentIssue.setPriority(Priority.P3);
        currentIssue.setResolution("FIXED");
        currentIssue.setComponent("glazedlists");
        currentIssue.setVersion("current");
        currentIssue.setAssignedTo("issues@glazedlists");
        currentIssue.setSubcomponent("www");
        currentIssue.setIssueType("DEFECT");
        currentIssue.setQAContact("issues@glazedlists");
        currentIssue.setShortDescription("EventListIterator problem with remove() method");
        description = new Description();
        description.setWho("ildella");
        description.setWhen(null);
        description.setText("This code doesn't seem to work properly: \n(variable \"songs\" is a BasicEventList)\n\n	public int cleanFromMissingFiles() {\n		Iterator it = songs.iterator();\n		while (it.hasNext()) {\n			MP3Song song = (MP3Song) it.next();\n			File f = new File(song.getPath());\n			if (!f.exists())\n				it.remove();	\n		}\n	}\n\nif there are 2 items to remove, after removing the first, the iterator return\nfalse at the next call to hasNext()\nif, for example, there are 8 items to remove, the hasNext() return false after\nthe 4th remove() calls. \nAnd so on...\n\nthe rest of the code is right, in fact, with this code:\n\n	public int cleanFromMissingFiles() {\n		List list = new LinkedList();\n		list.addAll(songs);\n		Iterator it = list.iterator();\n		while (it.hasNext()) {\n			MP3Song song = (MP3Song) it.next();\n			File f = new File(song.getPath());\n			if (!f.exists())\n				it.remove();\n		}\n		songs.clear();\n		songs.addAll(list);\n	}\n\neverything is all right.\n\nhope this can help.\nbye.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("This was a defect in my iterator code.\n\nThe iterator contains two indexes - the index of the last item viewed and the index of the \nnext item to view. When a remove occurred, only the last item viewed index was updated. \n\nThe next item to view index needed to be shifted down by one whenever a remove would \ncause the list's indicies to shift down by one.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("This bug has been fixed for two weeks with no problems. I am marking it closed.");
        currentIssue.getDescriptions().add(description);
        description = null;
        issues.add(currentIssue);
        currentIssue = null;
        currentIssue = new Issue();
        currentIssue.setId(new Integer(4));
        currentIssue.setStatus("CLOSED");
        currentIssue.setPriority(Priority.P3);
        currentIssue.setResolution("FIXED");
        currentIssue.setComponent("glazedlists");
        currentIssue.setVersion("current");
        currentIssue.setAssignedTo("jessewilson");
        currentIssue.setSubcomponent("www");
        currentIssue.setIssueType("DEFECT");
        currentIssue.setQAContact("issues@glazedlists");
        currentIssue.setShortDescription("Error in setting header value in TableComparatorSelector");
        description = new Description();
        description.setWho("ildella");
        description.setWhen(null);
        description.setText("Maybe there is a problem in TableComparatorSelector.\n\nI set tableHeader.setReorderingAllowed(true) on a table which has its own\nTableComparatorSelector. \nI move a column. After moving, the index of the column is changed, but the\nmodelIndex remains unchanged. \nThis is wel handled in method mouseClicked with trhis code \n\n        int viewColumn = columnModel.getColumnIndexAtX(e.getX()); \n        int column = table.convertColumnIndexToModel(viewColumn); \n\nthe last method, which rewrite the table header of all the columns, has the\nfollowing code:\n\n        // and set the name of the table header to the current comparator\n        for(int c = 0; c < table.getColumnCount(); c++) {\n            if(c == column) {                                                       \n              table.getColumnModel().getColumn(column).setHeaderValue(sortedHeader);\n            } else {\n                String header = listTable.getTableFormat().getFieldName(c);\n                table.getColumnModel().getColumn(c).setHeaderValue(header);\n            }\n        }\n\nthis method doesn't seem to handle difference between column index and model index.\nIn my app, when I move a column and then click on the header for resorting the\ntable, all the header value happen to move from their position. And this seems\nto be caused by that portion of code wich, I guess, has to use the view index\nand not the model index of the column. \n\nIf I am right, that code has to handle difference between index and model index.\nIf I am wrong, there are different way to handle this thing?");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("The problem looks legit. In most of my use of ListTable I use only a single column so \nmultiple columns is not well exercised!\n\nI'll try to reproduce the problem and look into a fix.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("I've fixed the bug and done preliminary testing to verify that the fix worked.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("This bug has been fixed for two weeks with no problems. I am marking it closed.");
        currentIssue.getDescriptions().add(description);
        description = null;
        issues.add(currentIssue);
        currentIssue = null;
        currentIssue = new Issue();
        currentIssue.setId(new Integer(5));
        currentIssue.setStatus("CLOSED");
        currentIssue.setPriority(Priority.P3);
        currentIssue.setResolution("FIXED");
        currentIssue.setComponent("glazedlists");
        currentIssue.setVersion("current");
        currentIssue.setAssignedTo("jessewilson");
        currentIssue.setSubcomponent("www");
        currentIssue.setIssueType("DEFECT");
        currentIssue.setQAContact("issues@glazedlists");
        currentIssue.setShortDescription("Speed up SparseLists");
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("The SparseListNode's height() method slow. More formally, this method is potentially O(n) \nand it should be optimized to be O(1).\n\nThis is insignificant in small lists but huge in large lists. In my brief profiling I discovered \nthat height() can consume 75% of the access time for large lists.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("I have tuned SparseLists to use a better height() method. The height is now stored \nin the node and recalculated whenever it may have changed (as a consequence of \ninsert or remove).\n\nThe performance gains are fantastic.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("This bug has been fixed for two weeks with no problems. I am marking it closed.");
        currentIssue.getDescriptions().add(description);
        description = null;
        issues.add(currentIssue);
        currentIssue = null;
        currentIssue = new Issue();
        currentIssue.setId(new Integer(6));
        currentIssue.setStatus("CLOSED");
        currentIssue.setPriority(Priority.P3);
        currentIssue.setResolution("INVALID");
        currentIssue.setComponent("glazedlists");
        currentIssue.setVersion("current");
        currentIssue.setAssignedTo("issues@glazedlists");
        currentIssue.setSubcomponent("www");
        currentIssue.setIssueType("DEFECT");
        currentIssue.setQAContact("issues@glazedlists");
        currentIssue.setShortDescription("MutationList return \"parent\" source instead of its own");
        description = new Description();
        description.setWho("ildella");
        description.setWhen(null);
        description.setText("MutationList getRootList was\n    \n    public EventList getRootList() {\n    	return source;\n    }\n\nas of revision 1.3 on CVS.\n\nIn revision 1.4, it is:\n\n    /**\n     * For implementing the EventList interface. This returns the root of the\n     * source list, or <code>this</code> if this list has no source.\n     */\n    /*\n    public EventList getRootList() {\n        if(source == this) return this;\n        return source.getRootList();\n    }\n\nand this broke all my code and my coomprehension of Glazed Lists.\n\nIs this correct?");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("Forgive me for breaking your code. The newest revision in CVS is correct and the previous \nrevision was a bug.\n\nIn your own code when you need the source list, you are supposed to use 'source', which \nis a protected member of the MutationList class. If you change your calls to 'getRootList()' \nwith 'source', your code should continue to work as it is supposed to.\n\n\nHere's why I made the change:\n\nGlazed Lists needs to be thread-safe. Currently I have made every effort to make it totally \nthread-safe. To accomplish thread safety I need to synchronize threads while they are \nperforming updates to the lists. In my original implementation, each list would be coded \nlike this:\n    public synchronized void notifyListUpdated()\n    public synchronized void get()\nUnfortunately this strategy can fail for thread safety in deadlock because the Swing thread \ncan be doing a get() while the query thread is doing an update. The get() call propagates \nfrom the table to the filter to the sorted list and eventually to the source list, holding all \nthe locks as it works. The notifyListUpdated does the opposite, starting at the source list \nand propagating through the sorted list, the filter and finally the table, attempting to \nacquire locks as it goes also. A deadlock is the inevitable result because the Swing thread \nis waiting for the query thread to release its lock on the source list while the query thread \nwaits on the Swing thread to release its lock on the table.\n\nSo my naive solution failed and I realized that I needed to synchronize all lists with the \nsame lock. The obvious lock to choose is the root list - the absolute source list in the tree. \nThis is the list that all of the other lists depend on.\n\nAs you walk through the code, you will see that I protect against thread problems with\n    synchronized(getRootList()) {\n    }\n\nBut I still access the parent list with 'source'. For example, the following is cut-and-pasted \nfrom SortedList:\n\n    public void setComparator(Comparator comparator) {\n        synchronized(getRootList()) {\n            // create the sorted list with a simple comparator\n            sorted = new IndexedTree(new IndexedTreeNodeComparator(comparator));\n            // create a list which knows the offsets of the indexes\n            unsorted = new IndexedTree();\n\n            // we're done if there's no elements in the source list\n            if(source.size() == 0) return;\n\n            // add all elements in the source list, in order\n            for(int i = 0; i < source.size(); i++) {\n                IndexedTreeNode unsortedNode = unsorted.addByNode(i, this);\n                insertByUnsortedNode(unsortedNode);\n            }\n\n            // notification about the big change\n            updates.beginAtomicChange();\n            updates.appendChange(0, size() - 1, ListChangeBlock.DELETE);\n            updates.appendChange(0, size() - 1, ListChangeBlock.INSERT);\n            updates.commitAtomicChange();\n        }\n    }\n\nThe second line is synchronized on getRootList(), but all of the calls to size() are directly \non source.\n\nIn summary\n\nWhenever you are synchronizing, use\n    synchronized(getRootList())\nbut for everything else use\n    source");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("This bug has been fixed for two weeks with no problems. I am marking it closed.");
        currentIssue.getDescriptions().add(description);
        description = null;
        issues.add(currentIssue);
        currentIssue = null;
        currentIssue = new Issue();
        currentIssue.setId(new Integer(7));
        currentIssue.setStatus("CLOSED");
        currentIssue.setPriority(Priority.P3);
        currentIssue.setResolution("FIXED");
        currentIssue.setComponent("glazedlists");
        currentIssue.setVersion("current");
        currentIssue.setAssignedTo("jessewilson");
        currentIssue.setSubcomponent("www");
        currentIssue.setIssueType("ENHANCEMENT");
        currentIssue.setQAContact("issues@glazedlists");
        currentIssue.setShortDescription("CaseInsensitiveFilterList non-\"live\" mode");
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("If you have a CaseInsensitiveFilterList with many entries and you filter for \"foo\", then the \nlist will be filtered three times! Because the list is \"live\" it filters once after the user types \n\"f\", another time after they have typed \"fo\" and finally a third time after they have \ncompleted \"foo\".\n\nThis is great when filtering is very fast and the list is short but it leads to unnecessary \nperformance lags when the list is large and filtering isn't as fast.\n\nThe CaseInsensitiveFilterList should have a non-\"live\" mode where the list is only filtered \nafter the user presses the Enter key in the search box. There could also be a \"filter\" \nbutton to activate the filter after the filter text has been entered.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("I've added some new methods to CaseInsensitiveFilterList:\n\ngetActionListener()\nsetLive(boolean)\n\nThe ActionListener can be used to trigger a refilter on a button press. \nThe list also will always refilter when ENTER is pressed in the filter edit field, whether in live mode or \nnot.\n\nFinally the DocumentListener has been moved to an inner class which is a 'safer' place for it.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("This bug has been fixed for two weeks with no problems. I am marking it closed.");
        currentIssue.getDescriptions().add(description);
        description = null;
        issues.add(currentIssue);
        currentIssue = null;
        currentIssue = new Issue();
        currentIssue.setId(new Integer(8));
        currentIssue.setStatus("CLOSED");
        currentIssue.setPriority(Priority.P3);
        currentIssue.setResolution("FIXED");
        currentIssue.setComponent("glazedlists");
        currentIssue.setVersion("current");
        currentIssue.setAssignedTo("issues@glazedlists");
        currentIssue.setSubcomponent("www");
        currentIssue.setIssueType("DEFECT");
        currentIssue.setQAContact("issues@glazedlists");
        currentIssue.setShortDescription("ListChangeSequence hasNext() fails when there's no next");
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("There are two things that happen when a list changes:\n  - the ListChangeEvent is populated with the change information\n  - the notifyListChanges() method is called on all listeners\n\nSometimes as a consequence of multi-threading, multiple change events are processed in \na single notifyListChanges() methods. When the notifyListChanges() is called on a different \nthread than where the changes were created, that method is required to verify that there \nare changes left to be processed using:\n    listChanges.hasNext()\n\nThis is performed by the ListTable because it receives all events on the SwingThread via \nListChangeListenerEventThreadProxy:\n    public void notifyListChanges(ListChangeEvent listChanges) {\n        ...\n        // when all events hae already been processed by clearing the event queue\n        if(!listChanges.hasNext()) {\n            return;\n        ...\n\nUnfortunately the listChanges.hasNext() method is broken, and throws an \nIndexOutOfBoundsException when there are no more changes:\njava.lang.IndexOutOfBoundsException: Index: 43, Size: 43\n	at java.util.ArrayList.RangeCheck(ArrayList.java:507)\n	at java.util.ArrayList.get(ArrayList.java:324)\n	at \ncom.odellengineeringltd.glazedlists.event.ListChangeSequence.getBlockCount(ListChangeSe\nquence.java:181)\n	at \ncom.odellengineeringltd.glazedlists.event.ListChangeEvent.hasNext(ListChangeEvent.java:\n124)\n	at com.odellengineeringltd.glazedlists.jtable.ListTable.notifyListChanges(ListTable.java:\n158)\n	at \ncom.odellengineeringltd.glazedlists.event.ListChangeListenerEventThreadProxy.run(ListCha\nngeListenerEventThreadProxy.java:54)\n	at java.awt.event.InvocationEvent.dispatch(InvocationEvent.java:178)\n	at java.awt.EventQueue.dispatchEvent(EventQueue.java:454)\n	at \njava.awt.EventDispatchThread.pumpOneEventForHierarchy(EventDispatchThread.java:201)\n	at java.awt.EventDispatchThread.pumpEventsForHierarchy(EventDispatchThread.java:\n151)\n	at java.awt.EventDispatchThread.pumpEvents(EventDispatchThread.java:145)\n	at java.awt.EventDispatchThread.pumpEvents(EventDispatchThread.java:137)\n	at java.awt.EventDispatchThread.run(EventDispatchThread.java:100)");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("The ListChangeEvent now checks with the target ListChangeSequence to verify that it has \nnot already reached the last atomic change in the set.\n\nThis should fix the problem as it has in my preliminary tests.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("This bug has been fixed for two weeks with no problems. I am marking it closed.");
        currentIssue.getDescriptions().add(description);
        description = null;
        issues.add(currentIssue);
        currentIssue = null;
        currentIssue = new Issue();
        currentIssue.setId(new Integer(9));
        currentIssue.setStatus("CLOSED");
        currentIssue.setPriority(Priority.P3);
        currentIssue.setResolution("FIXED");
        currentIssue.setComponent("glazedlists");
        currentIssue.setVersion("current");
        currentIssue.setAssignedTo("issues@glazedlists");
        currentIssue.setSubcomponent("www");
        currentIssue.setIssueType("DEFECT");
        currentIssue.setQAContact("issues@glazedlists");
        currentIssue.setShortDescription("fails to report selection event");
        description = new Description();
        description.setWho("ildella");
        description.setWhen(null);
        description.setText("The problem is in this code:\n\nclass ListTable \n...\n\n    public void notifyListChanges(ListChangeEvent listChanges) {\n        // for avoiding extra selection events\n        ignoreSelectionEvents = true;\n        // when all events hae already been processed by clearing the event queue\n        if(!listChanges.hasNext()) {\n            return;\n        // notify all changes simultaneously\n        }\n\nit is needed to add this line\n\n     	ignoreSelectionEvents = false;\n\nbefore that return. Without that line, it could happen that\nignoreSelectionEvents remains false and selection event are no more propagated.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("The bug has been fixed.\n\nThe bug report was very useful in helping me fix this bug quickly!");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("This bug has been fixed for two weeks with no problems. I am marking it closed.");
        currentIssue.getDescriptions().add(description);
        description = null;
        issues.add(currentIssue);
        currentIssue = null;
        currentIssue = new Issue();
        currentIssue.setId(new Integer(10));
        currentIssue.setStatus("CLOSED");
        currentIssue.setPriority(Priority.P3);
        currentIssue.setResolution("FIXED");
        currentIssue.setComponent("glazedlists");
        currentIssue.setVersion("current");
        currentIssue.setAssignedTo("issues@glazedlists");
        currentIssue.setSubcomponent("www");
        currentIssue.setIssueType("DEFECT");
        currentIssue.setQAContact("issues@glazedlists");
        currentIssue.setShortDescription("IndexedTree insert and remove are too slow");
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("The height() method on the IndexedTreeNode is not optimized and prevents the \nIndexedTreeNode from functioning efficiently. The method has O(n) runtime while proper \noptimization should yield O(log n) runtime.\n\nThis is because the height() method does not cache the height of the values at the nodes.\n\nFix the height as done for issue #5 with SparseListNode and the IndexedTree will perform \nmuch more efficiently.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("I have resolved the speed issue with the IndexedTreeNode.\n\nThis will impact the SortedList and cause it to perform faster sorts!");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("This bug has been fixed for two weeks with no problems. I am marking it closed.");
        currentIssue.getDescriptions().add(description);
        description = null;
        issues.add(currentIssue);
        currentIssue = null;
        currentIssue = new Issue();
        currentIssue.setId(new Integer(11));
        currentIssue.setStatus("CLOSED");
        currentIssue.setPriority(Priority.P3);
        currentIssue.setResolution("FIXED");
        currentIssue.setComponent("glazedlists");
        currentIssue.setVersion("current");
        currentIssue.setAssignedTo("issues@glazedlists");
        currentIssue.setSubcomponent("www");
        currentIssue.setIssueType("ENHANCEMENT");
        currentIssue.setQAContact("issues@glazedlists");
        currentIssue.setShortDescription("Expose prepareRenderer from JTable into ListTable class");
        description = new Description();
        description.setWho("philblais");
        description.setWhen(null);
        description.setText("I like having the ability to alternate colors on each of the rows of my tables so \nthat they look more like a ledger.  Since ListTable creates the JTable object it \nmakes it impossible to use this approach to render this.\n\nI propose to expose this method into ListTable so that it can be overriden if \nnecessary.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("philblais - Glazed Lists already has a place where you can configure your table and \nprepare your renderers as necessary.\n\nYou will have implemented the interface TableFormat which contains a method \nconfigureTable(). This method is called after the JTable has been created and its purpose is \nto allow you to modify the table's renderers to your liking:\n\n    /**\n     * Allow the record model to customize the table to its liking\n     * This method is called after the table is created so that the\n     * record can ensure the table behaves appropriately. This may\n     * include setting the editors and renderers for the table.\n     */\n    public void configureTable(JTable table);\n\nPlease call prepareRenderer() from this configureTable method and I hope you will get \nyour desired results.\n\nIf my understanding of your problem is incorrect please explain why calling \nprepareRenderer() from your configureTable() is insufficient and I will make quick \nprogress at getting it working for you.\n\nGood luck with your project!");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("On 30-Jan-04, at 10:54 AM, Philippe Blais wrote:\n\nHi,\n\nThe way it now it won't work.  The JTable's prepareRenderer method is called\ndynamically with the cell's renderer, the row index and the column index.\nIn my project I use the row index to decide what kind of background I want\nfor all the renderers on the row.\n\nI made a quick and dirty mod to ListTable for now since I couldn't simply\nsubclass it, my mod looks as follows in the constructWidgets method:\n\n--\ntable = new JTable(this)\n{\n	public Component prepareRenderer(TableCellRenderer renderer, int\nrowIndex,int colIndex)\n	{\n		Component c = super.prepareRenderer(renderer, \n				rowIndex, colIndex);\n		if (rowIndex % 2 == 0 && !isCellSelected(rowIndex,\ncolIndex)){\n		if (alternateShadingColor!=null) {\n			c.setBackground(alternateShadingColor);\n		} else {\n			c.setBackground(getBackground());\n		}\n	} else {\n		c.setBackground(getBackground());\n	}\n	\n	return c;\n}\n--\n\nOn simple way to allow extending ListTable for this functionality would be\nto delegate the creation of the table to a protected method of ListTable\nthat can be overridden by whoever wants to extend ListTable.\n\nMy suggestion is to change the \"new JTable(this)\" call to\n\"createTable(this)\" where the method would look like:\n\nprotected JTable createTable(TableModel model) {\n	return new JTable(model);\n}\n\nThis way I would have the ability to use my own extended JTable.\n\nThanks,\n\nPhil Blais\n");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("Phil Blais - \n\nI have written a fix for your problem and I hope that you find it sufficient! \n\nBut first, an explanation as to why I have not fixed your problem the way you have \nsuggested. The problem with allowing the user to extend JTable is that it prevents me \nfrom extending JTable in the future.\n\nMy solution involves a custom renderer called StripedTableCellRenderer which I have \nadded to the com.odellengineeringltd.glazedlists.jtable package. In your TableCell class \nyou will need to set each column's renderer to use this StripedTableCellRenderer:\n\npublic void configureTable(JTable table) {\n    Color oddColor = new java.awt.Color(234, 234, 234);\n    Color evenColor = table.getBackground();\n    StripedTableCellRenderer renderer = new StripedTableCellRenderer(oddColor, \nevenColor);\n    for(int i = 0; i < getFieldCount(); i++) {\n        table.getColumnModel().getColumn(i).setCellRenderer(renderer);\n    }\n}\n\nThe StripedTableCellRenderer uses the default renderer from the table so classes like \nBoolean and Number should render correctly.\n\nIt is also possible to specify a base renderer to use. In this case the StripedRenderer will \nuse that renderer to do the initial drawing and then paint its own stripe onto the row.\n\nLet me know if this solution is still insufficient and I will work with you to resolve any \noutstanding problems.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("This bug has been fixed for two weeks with no problems. I am marking it closed.");
        currentIssue.getDescriptions().add(description);
        description = null;
        issues.add(currentIssue);
        currentIssue = null;
        currentIssue = new Issue();
        currentIssue.setId(new Integer(12));
        currentIssue.setStatus("CLOSED");
        currentIssue.setPriority(Priority.P3);
        currentIssue.setResolution("FIXED");
        currentIssue.setComponent("glazedlists");
        currentIssue.setVersion("current");
        currentIssue.setAssignedTo("issues@glazedlists");
        currentIssue.setSubcomponent("www");
        currentIssue.setIssueType("DEFECT");
        currentIssue.setQAContact("issues@glazedlists");
        currentIssue.setShortDescription("Problem with ListTable.getSelected() ?");
        description = new Description();
        description.setWho("ildella");
        description.setWhen(null);
        description.setText("Sometimes I receive this exception that seems to be connected to a problem in\ngetSelected() methods in ListTable.\n\njava.lang.IndexOutOfBoundsException: cannot get from tree of size 14 at 47\n	at\ncom.odellengineeringltd.glazedlists.util.IndexedTreeNode.getNodeWithIndex(IndexedTreeNode.java:81)\n	at\ncom.odellengineeringltd.glazedlists.util.IndexedTree.getNode(IndexedTree.java:55)\n	at com.odellengineeringltd.glazedlists.SortedList.get(SortedList.java:228)\n	at\ncom.odellengineeringltd.glazedlists.jtable.ListTable.getSelected(ListTable.java:227)\n	at\nnet.della.mcube.outliner.OutlinersBuilder$2.filterMatches(OutlinersBuilder.java:77)\n	at\nnet.della.mcube.util.CustomFilteredList.filterMatches(CustomFilteredList.java:38)\n	at\ncom.odellengineeringltd.glazedlists.AbstractFilterList.notifyListChanges(AbstractFilterList.java:93)\n	at\ncom.odellengineeringltd.glazedlists.event.ListChangeSequence.commitAtomicChange(ListChangeSequence.java:154)\n	at net.della.mcube.util.QueryList.refresh(QueryList.java:110)\n	at net.della.mcube.util.QueryList$RefreshTask.run(QueryList.java:127)\n	at java.util.TimerThread.mainLoop(Timer.java:432)\n	at java.util.TimerThread.run(Timer.java:382)");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("This problem arises when the table selection is being accessed by a thread which is not \nthe event dispatch thread. When the table selection is being modified by the event \ndispatch thread and a second thread attempts to access the selection, it is natural for the \nsecond thread to see an inconsistent view of the selection. This inconsistent view can \ncause unrelated exceptions to show up in other parts of the system. \n\n\nI have come up with three potential solutions to this problem:\n\n1. Synchronize access to the table selection. The problem with this approach is that typical \naccess to the table selection is done by the event dispatch thread which does not require \nsynchronization. Therefore the synchronization will cause an unnecessary performance hit \nto typical use.\n\n2. Require that all access to the table selection be performed on the event dispatch \nthread. This is how things work currently. But as is demonstrated there are cases where \nother threads such as timer threads need to access the table selection. The work around \nfor this case is to use the SwingUtilities.invokeAndWait() method to schedule the selection \naccess on the event dispatch thread. The biggest problem with this approach is that it adds \ncomplexity to the ListTable class.\n\n3. Attempt to detect if the selection is currently being modified. This can be tested by \nwhether or not the selection has a consistent state. If the state is inconsistent simply \nreturn null as if there was no selection.\n\n\nI am trying to decide between solution two and solution three. Solution 2 will always \nreturn the correct value but it will also always take a long time when called by a thread \nwhich is not the event dispatch thread. Solution 3 will always return immediately but has \nthe potential for returning the wrong value when the selection is being modified.\n\nI will look through and continue to weight the pros and cons of each solution. Please let \nme know if you have any input which may help me make my decision.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("I have made the getSelected() method safe to call from threads which are not the event \ndispatch thread. To do this I have made the getSelected() method use a helper class which \nwill do the actual selection lookup on the event dispatch thread.\n\nIn implementing this solution I have been thinking that the ListTable class should not be \nconcerned with selection.  Unfortunately I cannot remove selection from ListTable without \nbreaking existing code.\n\nIn the interim I am considering making the getSelected() method deprecated with clients \naccessing the SelectionList as an alternative. The problem with this solution is that like \ngetSelected(), the SelectionList is not safe to be used any thread but the event dispatch \nthread.\n\nI will continue to think about this problem. If anyone has any suggestions I am open for \ncomment.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("This bug has been fixed for two weeks with no problems. I am marking it closed.");
        currentIssue.getDescriptions().add(description);
        description = null;
        issues.add(currentIssue);
        currentIssue = null;
        currentIssue = new Issue();
        currentIssue.setId(new Integer(13));
        currentIssue.setStatus("CLOSED");
        currentIssue.setPriority(Priority.P3);
        currentIssue.setResolution("INVALID");
        currentIssue.setComponent("glazedlists");
        currentIssue.setVersion("current");
        currentIssue.setAssignedTo("issues@glazedlists");
        currentIssue.setSubcomponent("www");
        currentIssue.setIssueType("DEFECT");
        currentIssue.setQAContact("issues@glazedlists");
        currentIssue.setShortDescription("ListChangeSequence grows unbounded");
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("The ListChangeSequence grows as more and more atomic changes are created. For a long-\nrunning Glazed Lists application the memory usage may become a serious performance \nproblem.\n\nThe ListChangeSequence should null out atomic changes when they are no longer in use \nand shift the array list when it grows too large.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("I performed a thorough examination of the memory usage of Glazed Lists and the \napplication does not grow unbounded.\n\nThis can be verified in the code from the following lines that were cut-and-paste from \nListChangeSequence:\n\n        // attempt to reclaim some changes for the change pool\n        int oldestRequiredChange = atomicChanges.size(); \n        for(int e = 0; e < listenerEvents.size(); e++) {\n            ListChangeEvent listChangeEvent = (ListChangeEvent)listenerEvents.get(e);\n            int eventOldestChange = listChangeEvent.getAtomicChangeCount();\n            if(eventOldestChange < oldestRequiredChange) {\n                oldestRequiredChange = eventOldestChange;\n            }\n        }\n        // recycle every change that is no longer used\n        for(int i = oldestChange; i < oldestRequiredChange; i++) {\n            List recycledChanges = (List)atomicChanges.get(i);\n            changePool.addAll(recycledChanges);\n            atomicChanges.set(i, null);\n        }\n        // now we have reclaimed all these change objects\n        oldestChange = oldestRequiredChange;\n\nI guess that when I was initially entering this bug I had forgotten that I had gotten around \nto adding this optimization. Nevertheless it is good to verify that there are no memory \nleaks when using Glazed Lists. In my simple test, Glazed Lists consumed less than 1000k \nof memory during the first 100,000 changes but consumed no additional memory for the \nfollowing 1,000,000 changes. Therefore I conclude that memory usage does not grow \nunbounded.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("This bug has been fixed for two weeks with no problems. I am marking it closed.");
        currentIssue.getDescriptions().add(description);
        description = null;
        issues.add(currentIssue);
        currentIssue = null;
        currentIssue = new Issue();
        currentIssue.setId(new Integer(14));
        currentIssue.setStatus("CLOSED");
        currentIssue.setPriority(Priority.P3);
        currentIssue.setResolution("FIXED");
        currentIssue.setComponent("glazedlists");
        currentIssue.setVersion("current");
        currentIssue.setAssignedTo("jessewilson");
        currentIssue.setSubcomponent("www");
        currentIssue.setIssueType("FEATURE");
        currentIssue.setQAContact("issues@glazedlists");
        currentIssue.setShortDescription("JList support");
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("Glazed Lists needs to support JList alongside JTable and JComboBox.\n\nIt should be very straightforward to change between JList and JTable in an application:\n * The selection interfaces should be the same\n * The renderers should be the same\n\nFrom Fred at l2fprod.com:\n> I was looking at an equivalent of \"ListTable\"\n> but which would encapsulates a JList. Do you \n> have this on your todo list? I guess it could\n> share code with the ListTable\n\n\nThis functionality should get its own package,\n    com.odellengineeringltd.glazedlists.jlist\nPerhaps the class name could be EventJList.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("I've done some preliminary work on this and I've run into a few snags.\n\nMy first problem is with rendering. I cannot get the preferred width in order to render the cells \nnicely, because the getSize() methods depend on the results of the rendered cells! It also seems \nto be a lot slower than JTable when scrolling through a long list of rendered cells.\n\nOne thing that this has brought me to think about is better naming for some classes. ListTable is \nfine for an event list JTable, but the matching \"ListList\" does not make much sense. My working \nname is \"EventJList\" which I think is a decent naming convention. I am pondering what the \nconsequences would be if I renamed everything in Glazed Lists to make more sense. If I were to \ndo that I would probably also want to change the package names. O'Dell Engineering is now using \na better package prefix of \"ca.odell\" which might in and of itself be worth the costs of migration.\n\nStill I have users and CVS is unfriendly to directory deletes. I'll worry about that later. For now I \nget to think about how to do JLists right.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("I have implemented EventJList. The class shares the following with ListTable:\n - SelectionListener interface\n - SelectionList / Selection Model\n\nThis class never batches groups of changes like ListTable does. It also does not use a Mutable change \nevent. It may be necessary to create a mutable ListDataEvent if change event creation proves to be a \nbottleneck.\n\nThis class still does not have any extra renderer support. For now if styled rendering is necessary, the \nuse of ListTable is a sufficient work around.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("This bug has been fixed for two weeks with no problems. I am marking it closed.");
        currentIssue.getDescriptions().add(description);
        description = null;
        issues.add(currentIssue);
        currentIssue = null;
        currentIssue = new Issue();
        currentIssue.setId(new Integer(15));
        currentIssue.setStatus("CLOSED");
        currentIssue.setPriority(Priority.P3);
        currentIssue.setResolution("FIXED");
        currentIssue.setComponent("glazedlists");
        currentIssue.setVersion("current");
        currentIssue.setAssignedTo("jessewilson");
        currentIssue.setSubcomponent("www");
        currentIssue.setIssueType("DEFECT");
        currentIssue.setQAContact("issues@glazedlists");
        currentIssue.setShortDescription("Inserted items become selected");
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("I am delighted with the performance, flexibility and ease of use of your platform, which I am \ncurrently evaluating for use in a table intensive application for my employer.\n\nOur application needs to display tabular data which gets notified through JMS. That means, \nultimately, that data arrives via a callback method in out code. I am therefore using a \nBasicEventList as base list, encapsulated in a SortedList and a subclass of AbstractFilterList as a \nmeans of providing the functionality (sorting & filtering by various criteria) that we need.\n\nThe only problem so far arises with keeping selected rows between data insertions.�I set the \nunderlying table selection model to ListSelectionModel.MULTIPLE_INTERVAL_SELECTION (anyway, \nas it is the default value). A thread keeps adding rows to the table, at a rate of 10 per second (to \ntest performance). I have noticed that whenever I select a row, further row insertions may \nmodify the number of selected rows. In particular, if a new row has the same internal index as \nthe currently selected one, it is guaranteed I will end up with two selected rows.\n\nThat seems to be your intended behaviour as per the documentation of the class SelectionList; \nhowever, I tried to modify it in order to suppress this behaviour to no avail. In particular, I \nsuppressed the lines marked inside SelectionList.notifyListChanges():\n// when an element is inserted, it is selected if its index was selected\n} else if(changeType == ListChangeBlock.INSERT) {\n��� // when selected, add the flag and fire a selection event\n��� if(previouslySelected) {\n��� ��� flagList.add(index, Boolean.TRUE); // <--- SUPRESS\n��� ��� updates.appendChange(previousSelectionIndex, ListChangeBlock.INSERT); // <--- SUPRESS\n��� // when not selected, just add the space\n��� } else {\n��� ��� flagList.add(index, null);\n��� }\n\nI tried other changes, including the method SelectionList.valueChanged(). Do you have any \nsuggestion to solve this problem? Is it a bug in your code? In that case, I'd be willing to help and \ncontribute back to your project any bugfixes I develop.�I can also provide you with my testing \ncode, but at this stage it's really simple: the thread inserting fake data rows does so in an \ninvokeLater() block, and uses a java.util.Timer for scheduling data feed.\n\nThe problem does not manifest when I set the table selection model to \nListSelectionModel.SINGLE_SELECTION, by the way.\n\nThank you for your time and for providing the Java Community with such a promising piece of \nwork.\n\nYours\nIv�n Rivera Rodr�guez");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("Iv�n -\n\nThe current behaviour is \"as designed\" but I agree that there may be a better way to solve this \nproblem.\n\nThis behaviour is the same as the behaviour of a simple JTable (ie. no Glazed Lists). When JTable \nreceives in insert at some index, say i, then the newly inserted row will be selected only if row i \nwas selected before the insertion. This behaviour has some nice properties: values inserted \nwithin a range of selected values will themselves become selected.\n\nBut I also agree that this behaviour can be problematic. I think the solution is to add an extra \n\"mode\" to the SelectionList. The new mode will be as you describe. Inserted values will never be \nselected until done so explicitly by the user.\n\nDue to constraints at school and at work I will be unable to add this functionality until at least \nFebruary 14th, 2004. In the worst case it will take until February 21st to complete. Hopefully then \nI will get something working that solves this problem!");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("According to the J2SE 1.4.1 API for DefaultListSelectionModel:\n\"If the value at index is itself selected and the selection mode is not SINGLE_SELECTION, set all of \nthe newly inserted items as selected.  Otherwise leave them unselected. \"\nhttp://java.sun.com/j2se/1.4.1/docs/api/javax/swing/\nDefaultListSelectionModel.html#insertIndexInterval(int,%20int,%20boolean)\n\nI have tested some of the simple ways to solve this problem and I do not think that they will work \nelegantly. The problem is that I need to undo the selection which is added by \nDefaultListSelectionModel. This would be trivial except that the ListSelectionModel fires events that \nalso need to be done and undone.\n\nI am considering changing the Interface of SelectionList, to become a ListSelectionModel and \nEventList simultaneously. This approach is complex but appropriate as the SelectionList already \ntracks the table selection.\n\nI will continue to review my options but for now it looks like implementing ListSelectionModel is my \nbest bet.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("I have solved the problem by implementing ListSelectionModel. Implementing this class was \ndifficult as the interface specification was not explicit enough for the behaviour in certain cases. I \nthink that the behaviour of my ListSelectionModel should be the same as the J2SE 1.4 \nDefaultListSelectionModel. If you discover a descrepancy, let me know.\n\nThis new ListSelectionModel has a new mode for solving this problem \n\"MULTIPLE_INTERVAL_SELECTION_DEFENSIVE\". The new mode is the default list selection mode. \n\nMy ListSelectionModel is fully capable of switching between different modes and retains the \nappropriate selection when the mode changes. To test this, there is a commented out block of \ncode in ProgrammingLanguageBrowser.java that provides a JComboBox to switch between \ndifferent ListSelectionModel modes.\n\nI hope this fix helps, it took quite a bit of code to make it work - 653 lines!");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("From Iv�n Rivera:\n\nThank you very much. I had also some time to work on the issue last Friday and came up with a \nsubclass of javax.swing.DefaultListSelectionModel which undoes the selection, without caring for \nevents generated. I append a copy to this mail for you to examine, as it seems to correct the \n(Swing-default) behaviour.\n\nYou are right about the event handling problem, but it doesn't seem to be causing troubles in my \ntest benchmark. Perhaps it's just a matter of performance. Anyway, your solution is surely more \nelegant. I won't be able to see your code until this night at home, since at work I'm behind an \nextremely restrictive firewall which doesn't even allow SSH tunneling for CVS checkout.\n\nI'm working in some components to enable automatic width adjustment for columns based on \ncontent and column hiding. I hope to be able to contribute the code once I'm done (this week, \nmost likely).\n\nOnce again, thanks for your interest.\n\nYours,\n\nIv�n Rivera");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("This bug has been fixed for two weeks with no problems. I am marking it closed.");
        currentIssue.getDescriptions().add(description);
        description = null;
        issues.add(currentIssue);
        currentIssue = null;
        currentIssue = new Issue();
        currentIssue.setId(new Integer(16));
        currentIssue.setStatus("CLOSED");
        currentIssue.setPriority(Priority.P3);
        currentIssue.setResolution("FIXED");
        currentIssue.setComponent("glazedlists");
        currentIssue.setVersion("current");
        currentIssue.setAssignedTo("issues@glazedlists");
        currentIssue.setSubcomponent("www");
        currentIssue.setIssueType("DEFECT");
        currentIssue.setQAContact("issues@glazedlists");
        currentIssue.setShortDescription("No removeSelectionListener() method in ListTable");
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("Hi,\n\nat minimum the ListTable has no removeSelectionListener(SelectionListener)\nmethod ...\n\nAny plans to correct this?\n\nCheers,\n\nJoern");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("The method had been omitted in error.\n\nI have added it to the latest revision in CVS.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("This bug has been fixed for two weeks with no problems. I am marking it closed.");
        currentIssue.getDescriptions().add(description);
        description = null;
        issues.add(currentIssue);
        currentIssue = null;
        currentIssue = new Issue();
        currentIssue.setId(new Integer(17));
        currentIssue.setStatus("CLOSED");
        currentIssue.setPriority(Priority.P1);
        currentIssue.setResolution("FIXED");
        currentIssue.setComponent("glazedlists");
        currentIssue.setVersion("current");
        currentIssue.setAssignedTo("jessewilson");
        currentIssue.setSubcomponent("www");
        currentIssue.setIssueType("DEFECT");
        currentIssue.setQAContact("issues@glazedlists");
        currentIssue.setShortDescription("Selection concurrency ArrayIndexOutOfBoundsException");
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("I got the following exception:\n\n[tasks] Interrupting worker thread to run Adding Article\napple.awt.EventQueueExceptionHandler Caught Throwable : \njava.lang.ArrayIndexOutOfBoundsException: Cannot get selection index 0, list size 0\n        at \ncom.odellengineeringltd.glazedlists.listselectionmodel.SelectionModelEventList$EventListSelectionMode\nl.isSelectedIndex(SelectionModelEventList.java:505)\n        at javax.swing.JTable.isRowSelected(JTable.java:1451)\n        at javax.swing.JTable.isCellSelected(JTable.java:1481)\n        at javax.swing.JTable.prepareRenderer(JTable.java:3725)\n        at javax.swing.plaf.basic.BasicTableUI.paintCell(BasicTableUI.java:1149)\n        at javax.swing.plaf.basic.BasicTableUI.paintCells(BasicTableUI.java:1051)\n        at javax.swing.plaf.basic.BasicTableUI.paint(BasicTableUI.java:974)\n        at javax.swing.plaf.ComponentUI.update(ComponentUI.java:142)\n        at javax.swing.JComponent.paintComponent(JComponent.java:541)\n        at javax.swing.JComponent.paint(JComponent.java:808)\n        at javax.swing.JComponent._paintImmediately(JComponent.java:4695)\n        at javax.swing.JComponent.paintImmediately(JComponent.java:4488)\n        at javax.swing.RepaintManager.paintDirtyRegions(RepaintManager.java:410)\n        at \njavax.swing.SystemEventQueueUtilities$ComponentWorkRequest.run(SystemEventQueueUtilities.java:\n117)\n        at java.awt.event.InvocationEvent.dispatch(InvocationEvent.java:178)\n        at java.awt.EventQueue.dispatchEvent(EventQueue.java:454)\n        at java.awt.EventDispatchThread.pumpOneEventForHierarchy(EventDispatchThread.java:234)\n        at java.awt.EventDispatchThread.pumpEventsForHierarchy(EventDispatchThread.java:184)\n        at java.awt.EventDispatchThread.pumpEvents(EventDispatchThread.java:178)\n        at java.awt.EventDispatchThread.pumpEvents(EventDispatchThread.java:170)\n        at java.awt.EventDispatchThread.run(EventDispatchThread.java:100)\napple.awt.EventQueueExceptionHandler Caught Throwable : \njava.lang.ArrayIndexOutOfBoundsException: Cannot get selection index 0, list size 0\n        at \ncom.odellengineeringltd.glazedlists.listselectionmodel.SelectionModelEventList$EventListSelectionMode\nl.isSelectedIndex(SelectionModelEventList.java:505)\n        at javax.swing.JTable.isRowSelected(JTable.java:1451)\n        at javax.swing.JTable.isCellSelected(JTable.java:1481)\n        at javax.swing.JTable.prepareRenderer(JTable.java:3725)\n        at javax.swing.plaf.basic.BasicTableUI.paintCell(BasicTableUI.java:1149)\n        at javax.swing.plaf.basic.BasicTableUI.paintCells(BasicTableUI.java:1051)\n        at javax.swing.plaf.basic.BasicTableUI.paint(BasicTableUI.java:974)\n        at javax.swing.plaf.ComponentUI.update(ComponentUI.java:142)\n        at javax.swing.JComponent.paintComponent(JComponent.java:541)\n        at javax.swing.JComponent.paint(JComponent.java:808)\n        at javax.swing.JComponent.paintChildren(JComponent.java:647)\n        at javax.swing.JComponent.paint(JComponent.java:817)\n        at javax.swing.JViewport.paint(JViewport.java:774)\n        at javax.swing.JComponent.paintChildren(JComponent.java:647)\n        at javax.swing.JComponent.paint(JComponent.java:817)\n        at javax.swing.JComponent._paintImmediately(JComponent.java:4695)\n        at javax.swing.JComponent.paintImmediately(JComponent.java:4488)\n        at javax.swing.RepaintManager.paintDirtyRegions(RepaintManager.java:410)\n        at \njavax.swing.SystemEventQueueUtilities$ComponentWorkRequest.run(SystemEventQueueUtilities.java:\n117)\n        at java.awt.event.InvocationEvent.dispatch(InvocationEvent.java:178)\n        at java.awt.EventQueue.dispatchEvent(EventQueue.java:454)\n        at java.awt.EventDispatchThread.pumpOneEventForHierarchy(EventDispatchThread.java:234)\n        at java.awt.EventDispatchThread.pumpEventsForHierarchy(EventDispatchThread.java:184)\n        at java.awt.EventDispatchThread.pumpEvents(EventDispatchThread.java:178)\n        at java.awt.EventDispatchThread.pumpEvents(EventDispatchThread.java:170)\n        at java.awt.EventDispatchThread.run(EventDispatchThread.java:100)");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("The lists can get out of sync while changes are pending in the event queue. The ListSelectionModel \nmust not throw an exception because it is possible that the lists are simply out of sync and that when \nthe event queue is processed they will come back into sync.\n\nThis has been fixed so that the SelectionModel does not throw an exception in the possiblility that the \nlists are simply out of sync.\n\nOne unfortunate side effect is that the ListSelectionModel now cannot provide warning as to whether \nthis method is actually being called in error.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("This bug has been fixed for two weeks with no problems. I am marking it closed.");
        currentIssue.getDescriptions().add(description);
        description = null;
        issues.add(currentIssue);
        currentIssue = null;
        currentIssue = new Issue();
        currentIssue.setId(new Integer(18));
        currentIssue.setStatus("CLOSED");
        currentIssue.setPriority(Priority.P3);
        currentIssue.setResolution("FIXED");
        currentIssue.setComponent("glazedlists");
        currentIssue.setVersion("current");
        currentIssue.setAssignedTo("jessewilson");
        currentIssue.setSubcomponent("www");
        currentIssue.setIssueType("DEFECT");
        currentIssue.setQAContact("issues@glazedlists");
        currentIssue.setShortDescription("set(), add(), remove() etc. not implemented");
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("Glazed Lists does not support remove() on FilterLists. It simply throws an Exception.\n\nGlazed Lists should support remove(). It should also support set().\n\nTo provide protection, there should be a MutationList called ReadOnlyList that throws an exception \nupon a remove() or a set.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("The following methods that modify lists should be implemented: set(), add(), remove() and clear().\n\nImplementing these is not straightforward because we want to modify the model indirectly by calling \nthese methods upon the view. Here are some observations:\n\nBasicEventList:\nAlready supports modifying methods.\n\nQueryList:\nNot directly modifyable. Objects created or modified externally can currently be updated via \nnotifyObjectUpdated(). This is appropriate.\n\nSortedList:\nMethods called with an index such as set(index, value) and add(index, value) will have unpredictable \nresults. This is because the modified/inserted objects may be sorted into a different index than that \nspecified. This is acceptable but should be documented.\n\nFilteredList:\nThe add(index, value) method is ambiguous. This is because there may be several filtered-out indicies \nin the source list that will have the same filtered index. I think the best approach is to insert at the \nhighest index that will satisfy the specified index.\nThe add() and set() methods may cause an object to become filtered. This is acceptable but should be \ndocumented.\n\nFreezableList:\nChanges may do different things in different states. This is nonintuitive and could be \ntroublesome. For example, when a list is frozen changes can only applied to a local copy. When the list \nis not frozen changes should propagate to parente lists. Therefore I recommend that changes are only \nallowed in the not frozen state. Otherwise an IllegalStateException should be thrown.\n\nSelectionList:\nThis is not clearly defined. It may be intuitive that remove() either removes the selection or that \nremove() actually removes an element from the source list. But add() can only add an element to the \nsource list because it is unnatural to use add() to perform selection by value and not index. Therefore \nadd() and remove() will modify the source list.\n\nMutationList:\nThis should continue to throw MethodNotSupportedException for mutator methods. It may be desirable \nto make some methods use others such as clear() calling remove() in sequence in order to simplify \nwriting extending classes.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("Daniel Bonin and I were discussing modifyable views and we came up with some observations. When \nusing FilterList, SortedList or the like, you can have inconsistent behaviour. For example, the following \ncode wil fail.\n\nlist x = ...\nx.add(0, \"Jesse\");\nassert(\"Jesse\".equals(x.get(0));\n\nThis can fail because the inserted value \"Jesse\" gets filtered out or sorted to a different location.\n\nOur solution: a happy list. The happy list \"fakes\" success as the method directed. It basically keeps \ntrack of local changes to make the changes appear consistent. This can be used with GUIs to allow the \nuser to verify their modifications without losing the filtering and sorting. \n\nThe happy list will be called \"DeltaList\" and it will keep track of both the source list and a set of deltas \nthat have been performed. When an insert at x occurs, the delta list simulates that the insert occured at \nx, even if the insert was sorted or filtered to a different location.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("I have created a new class \"WritableMutationList\" that provides these services to lists that extend it. It \nrequires that lists implement two additional methods:\n - isWritable() returns true if the list is accepting changes at this time\n - getSourceIndex() gets the index from the source list for the corresponding index in the mutated list\n\nThis requires that there is a 1:1 correspondence between indicies in the mutated list and the indicies in \nthe source list. This will not work for lists that combine source values in the mutated view.\n\nTo complete the fix, I must implement a ReadOnlyList mutated list and a DeltaList. I will also need to do \na bunch of testing to verify that this works.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("I've added a ReadOnlyList - now all that's left is DeltaList.\n\n...And LOTS of testing!");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("I added test methods to SortedList and CaseInsensitiveFilterList and have gained confidence in my \nimplementation of the set(), add(), remove(), clear() etc. methods.\n\nThe DeltaList has been moved to a separate issue, issue 24.\nhttps://glazedlists.dev.java.net/issues/show_bug.cgi?id=24");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("This bug has been fixed for two weeks with no problems. I am marking it closed.");
        currentIssue.getDescriptions().add(description);
        description = null;
        issues.add(currentIssue);
        currentIssue = null;
        currentIssue = new Issue();
        currentIssue.setId(new Integer(19));
        currentIssue.setStatus("NEW");
        currentIssue.setPriority(Priority.P3);
        currentIssue.setResolution("");
        currentIssue.setComponent("glazedlists");
        currentIssue.setVersion("current");
        currentIssue.setAssignedTo("jessewilson");
        currentIssue.setSubcomponent("www");
        currentIssue.setIssueType("FEATURE");
        currentIssue.setQAContact("issues@glazedlists");
        currentIssue.setShortDescription("Glazed lists on the network");
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("As documented in the developer newsgroup, I want to build a model that allows list changes to be \ndistributed across the network.\n\nhttps://glazedlists.dev.java.net/servlets/ReadMsg?list=dev&msgNo=11\nhttps://glazedlists.dev.java.net/servlets/ReadMsg?list=dev&msgNo=12\n\nI will create a descrete event simulation model in order to test out what network strategies are most \neffective. Also I think that this package should be implemented exclusively using the buffered java.nio \npackage if possible.");
        currentIssue.getDescriptions().add(description);
        description = null;
        issues.add(currentIssue);
        currentIssue = null;
        currentIssue = new Issue();
        currentIssue.setId(new Integer(20));
        currentIssue.setStatus("CLOSED");
        currentIssue.setPriority(Priority.P5);
        currentIssue.setResolution("FIXED");
        currentIssue.setComponent("glazedlists");
        currentIssue.setVersion("current");
        currentIssue.setAssignedTo("jessewilson");
        currentIssue.setSubcomponent("www");
        currentIssue.setIssueType("DEFECT");
        currentIssue.setQAContact("issues@glazedlists");
        currentIssue.setShortDescription("Refactor package and class names");
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("These changes make the code easier for new users at the expense of requiring existing users to change \ntheir imports. Therefore the changes should be made very carefully. If possible a tool should be \nreferenced to automatically convert .java files for existing users.\n\nFirst off, com.odellengineeringltd.glazedlists is a mouthful. This should be changed to O'Dell \nEngineering's new standard package, ca.odell.glazedlists.\n\n...glazedlists.listselectionmodel should be renamed to ...glazedlists.selection.\n\nIn ...glazedlists.jtable:\n  ListTable should be EventJTable\n  SelectionListener should be moved to ...glazedlists.selection\n  BasicSelectionListener should be moved to ...glazedlists.selection\n\nFinally the following classes should be verified working or removed:\n...glazedlists.jtextfield.ArrayStringCompleter\n...glazedlists.jtextfield.CompletedField\n...glazedlists.jtextfield.ComponentCaution\n...glazedlists.jtextfield.ListStringCompleter\n...glazedlists.jtextfield.StringCompleter\n...glazedlists.jtextfield.ValidatedField\n...glazedlists.jtable.StyledDocumentEditor\n...glazedlists.jtable.WritableListTable\n...glazedlists.jtable.WritableTableFormat\n...glazedlists.query.QueryListManager\n\nAs I have already said, these changes will ruin Glazed Lists programs. Therefore all Glazed Lists users \nshould be notified before making any changes and copies of the Glazed Lists jar file and source should \nbe permanently archived for users with these packages.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("When I fix this bug I will be breaking compatibility. Other compatibility-breaking changes should all be \nperformed at the exact same time.\n\nAnother compatibility-breaking change is changing the concurrency strategy. The current strategy uses \nsimple global synchronization, where a better solution will use Reader/Writer locks. This will be \nnecessary to resolve Issue 25.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("Here's my current ideas on what to do with each class. My goal is to simplify Glazed Lists by removing \neverything that is not essential. \n\nAbstractFilterList - ok\nArrayStringCompleter - remove, this class is not within the scope of the project\nBasicEventList - ok\nBasicSelectionListener - remove, this class is simple in implementation and limited in use\nBoundedMap - remove, this class is no longer used\nCachingList - ok\nCaseInsensitiveFilterList - SubstringFilterList, have case toggle options\nCharacteristicList - rename ?\nComparableComparator - ok\nComparatorChain - ok\nCompletedField - remove, not within scope\nComponentCaution - remove, not within scope\nCompositeList - ok\nDynamicQueryList - replace with a different 'query' list that does not use the Query class, just a \nsetCollection() method\nEmptyQuery - remove\nEventJList - replace with a EventListModel\nEventList - ok\nEventListIterator - ok\nExitOnCloseHandler - remove, not in scope\nFilterable - remove? Filterator only may be a better approach\nFilterator - rename TextFilterator\nFreezableList - ok\nIconComboBoxRenderer - remove, not within scope\nIndexedTree - ok\nIndexedTreeNode - ok\nListChangeBlock - make package-scope, move constants DELETE, INSERT to ListChangeEvent class\nListChangeEvent - ok, add methods to get the source list and target listener\nListChangeListener - ok, change notifyListChanges to listChanged\nListChangeListenerEventThreadProxy - ok\nListChangeListenerWeakReferenceProxy - ok\nListChangeSequence - ok, maybe rename to ListChangeEventHelper or something\nListComboBoxModel - ok\nListStringCompleter - remove, out of scope\nListTable - replace with EventListTableModel\nMutableListDataEvent - ok, make package-scope\nMutableTableModelEvent - ok, make package-scope\nMutationList - rename. the renamed list could be \"DecoratorList\" or something else\nPeriodicQueryList - remove, see DynamicQueryList\nProgrammingLanguageBrowser - ok\nProgrammingLanguageNameComparator  - ok\nProgrammingLanguageTableCell  - ok\nProgrammingLanguageYearComparator  - ok\nQuery - remove, see DynamicQueryList\nQueryList - replace as per DynamicQueryList\nQueryListManager - remove\nReadOnlyList - ok\nReverseComparator - ok\nSelectionList - remove\nSelectionListener - ok? maybe remove due to models, consider more flexible selection events\nSelectionModelEventList - ok\nSelectionNotifier - package private\nSortedList - ok\nSparseList - ok\nStringCompleter - remove\nStripedTableCellRenderer - not really in scope, but keep it anyway\nStyledDocumentEditor - remove\nStyledDocumentRenderer - not really in scope, but keep it anyway, adjust built-in forms\nSubEventList - ok\nTableComparatorChooser - ok\nTableComparatorSelector - remove\nTableFormat - rename um TableColumnFormat maybe? remove configureTable for new model-\napproach\nTaskQueryList - remove, see DynamicQueryList\nUniqueList - ok\nValidatedField - remove\nWritableListTable - replace with methods in TableFormat\nWritableMutationList - remove, replace with more powerful MutationList\nWritableTableFormat - remove\n");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("Some other things I think we should go over for this issue:\n - verify standard copyright header\n - classes should be final\n\nTo reduce the number of visible classes and therefore simplify Glazed Lists:\n - all *List classes should be in the main package\n - no support classes should be public\n - Swing classes in swing package\n");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("Two other things I thought of to verify:\n - imports are clean & straightforward & necessary\n - there is a thread-safety warning in Javadoc for all thread-unsafe classes");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("NEVER AGAIN");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("This bug has been fixed for two weeks with no problems. I am marking it closed.");
        currentIssue.getDescriptions().add(description);
        description = null;
        issues.add(currentIssue);
        currentIssue = null;
        currentIssue = new Issue();
        currentIssue.setId(new Integer(21));
        currentIssue.setStatus("CLOSED");
        currentIssue.setPriority(Priority.P3);
        currentIssue.setResolution("FIXED");
        currentIssue.setComponent("glazedlists");
        currentIssue.setVersion("current");
        currentIssue.setAssignedTo("jessewilson");
        currentIssue.setSubcomponent("www");
        currentIssue.setIssueType("DEFECT");
        currentIssue.setQAContact("issues@glazedlists");
        currentIssue.setShortDescription("SubList not implemented");
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("SubList should be implemented. This should be an MutationList on its own, that starts with the initial \nsize and accepts add() and remove() from source list.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("Implementing SubList as an EventList in its own right will introduce a subtle problem:\n\nThe SubList should listen to events from its source list and change itself accordingly. But if the SubList \nis to listen for such events, it must be registered as a ListChangeListener of the source list.\n\nBecause the SubList is a ListChangeListener, the source list will always maintain a reference to the \nSubList and the SubList will never go out of scope. Therefore the SubList will never be garbage collected \nand waste memory space.\n\nThe work around is to require EventLists to accept two classes of ListChangeListeners - those that \nshould be garbage collected once they go out of the scope from the caller and those that should not be \ngarbage collected. In effect there should be ListChangeListeners that are stored with weak references \nand those that have regular references.\n\nI would prefer not to change the interface for EventList or ListChangeListener, so it will be tricky to \ndetermine whether to reference a listener with a weak reference or a regular reference. One solution \ncreate a proxy class called \"WeakReferenceListChangeListenerProxy\" that sends changes using a weak \nreference only. This is similar to the SwingThreadProxy already in use in Glazed Lists.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("SubList is added and appears to be working.\n\nI still need to perform a test to ensure it is being garbage collected.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("Fixed!\n\nThe SubList and Iterator now respond to events. Therefore they can be used even if the underlying list \nchanges.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("This bug has been fixed for two weeks with no problems. I am marking it closed.");
        currentIssue.getDescriptions().add(description);
        description = null;
        issues.add(currentIssue);
        currentIssue = null;
        currentIssue = new Issue();
        currentIssue.setId(new Integer(22));
        currentIssue.setStatus("CLOSED");
        currentIssue.setPriority(Priority.P3);
        currentIssue.setResolution("FIXED");
        currentIssue.setComponent("glazedlists");
        currentIssue.setVersion("current");
        currentIssue.setAssignedTo("kevinmaltby");
        currentIssue.setSubcomponent("www");
        currentIssue.setIssueType("DEFECT");
        currentIssue.setQAContact("issues@glazedlists");
        currentIssue.setShortDescription("CachingList dumps all values whenever the list is changed");
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("The CachingList will be of growing importance as Glazed Lists are used on the network.\n\nThe current implementation of CachingList dumps the entire cache whenever any changes to the list \noccur. The CachingList should only dump values which have been invalidated.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("The current CachingList keeps track of what is in its cache by its list index. When the list is modified, \nthese list indicies may change and therefore it is necessary to invalidate the entire cache.\n\nIn order to fix the CachingList, it will be necessary to change the data structures that support it. This fix \nwill be difficult to build!\n\nI am considering allowing this defect to exist in the 1.0 release as it is only a performance problem and \nnot a behavioural problem.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("I'm assigning this to Kevin Maltby - the best coder I know when caching is concerned. Let's hope my \nflattery and his talent are enough to get this bug fixed!");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("Kevin has pretty much conquered this one. He's going to CVS commit and close this issue real soon.\n\nI have peer-reviewed his code and it's pretty decent. The peer review session was very helpful and \nhopefully we can get a lot of the Glazed Lists code peer reviewed in the future!");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("kevinmaltby");
        description.setWhen(null);
        description.setText("The fix is in.  The CachingList now behaves as you would expect.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("This bug has been fixed for two weeks with no problems. I am marking it closed.");
        currentIssue.getDescriptions().add(description);
        description = null;
        issues.add(currentIssue);
        currentIssue = null;
        currentIssue = new Issue();
        currentIssue.setId(new Integer(23));
        currentIssue.setStatus("CLOSED");
        currentIssue.setPriority(Priority.P3);
        currentIssue.setResolution("FIXED");
        currentIssue.setComponent("glazedlists");
        currentIssue.setVersion("current");
        currentIssue.setAssignedTo("issues@glazedlists");
        currentIssue.setSubcomponent("www");
        currentIssue.setIssueType("TASK");
        currentIssue.setQAContact("issues@glazedlists");
        currentIssue.setShortDescription("Add JUnit Support");
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("As Glazed Lists gets bigger in scope it is becoming very urgent to create a set of unit tests.\n\nThere should be a package such as .glazedlists.test that is only compiled if the JUnit libraries are \ndetected on the classpath. If they are, then these test files can be built. They can then be tested with a \n\"test\" target in the project buildfile.\n\nFinally these test classes shall not be included in the library distribution.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("I have added the framework for JUnit tests within the Glazed Lists package and build file.\n\nNow all I have to do is write the tests!");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("I've gone through the code to select which classes are good candidates for unit tests. Unit tests require \nprogrammatic access so testing Swing stuff will be of marginal value.\n\npackage: .glazedlists\nAbstractFilterList\nBasicEventList\nCaseInsensitiveFilterList\nSortedList\nWritableMutationList\n\npackage: .glazedlists.listselectionmodel\nSelectionModelEventList\n\npackage: .glazedlists.util\nBoundedMap\nCachingList\nEventListIterator\nFreezableList\nIndexedTree\nReadOnlyList\nSparseList\n\nAs of March 18, 2004 I have created tests for the CaseInsensitiveFilterList and the SortedList.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("The most basic classes now have tests for them.\n\nSome tests are not appropriate for JUnit, for example, concurrency tests.\n\nRegardless, JUnit support is now in the Glazed Lists project. It is possible to add new tests by simply \ncreating a class that ends with Test.java. In fact, Glazed Lists now requires that classes ending in \nTest.java must be JUnit tests as such classes are NOT included in the distribution jar.\n\nAnyone interested in getting their hands dirty with Glazed Lists should consider adding more tests to \nour test library!");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("This bug has been fixed for two weeks with no problems. I am marking it closed.");
        currentIssue.getDescriptions().add(description);
        description = null;
        issues.add(currentIssue);
        currentIssue = null;
        currentIssue = new Issue();
        currentIssue.setId(new Integer(24));
        currentIssue.setStatus("NEW");
        currentIssue.setPriority(Priority.P5);
        currentIssue.setResolution("");
        currentIssue.setComponent("glazedlists");
        currentIssue.setVersion("current");
        currentIssue.setAssignedTo("jessewilson");
        currentIssue.setSubcomponent("www");
        currentIssue.setIssueType("FEATURE");
        currentIssue.setQAContact("issues@glazedlists");
        currentIssue.setShortDescription("Add DeltaList for consistency with derivatives of WritableMutationList");
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("WritableMutationLists allow modifications to be made to the list that may behave differently than \nexpected. The solution is to implement a DeltaList, which is a mutation list that provides as-expected \nresults when they would not otherwise be possible.\n\nFrom issue 18:\n\nDaniel Bonin and I were discussing modifyable views and we came up with some observations. When \nusing FilterList, SortedList or the like, you can have inconsistent behaviour. For example, the following \ncode wil fail.\n\nlist x = ...\nx.add(0, \"Jesse\");\nassert(\"Jesse\".equals(x.get(0));\n\nThis can fail because the inserted value \"Jesse\" gets filtered out or sorted to a different location.\n\nOur solution: a happy list. The happy list \"fakes\" success as the method directed. It basically keeps \ntrack of local changes to make the changes appear consistent. This can be used with GUIs to allow the \nuser to verify their modifications without losing the filtering and sorting. \n\nThe happy list will be called \"DeltaList\" and it will keep track of both the source list and a set of deltas \nthat have been performed. When an insert at x occurs, the delta list simulates that the insert occured at \nx, even if the insert was sorted or filtered to a different location.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("priority reduced as there is no 'customers' waiting for this feature.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("This may be an excellent candidate as something to extend AbstractFilterList.");
        currentIssue.getDescriptions().add(description);
        description = null;
        issues.add(currentIssue);
        currentIssue = null;
        currentIssue = new Issue();
        currentIssue.setId(new Integer(25));
        currentIssue.setStatus("CLOSED");
        currentIssue.setPriority(Priority.P3);
        currentIssue.setResolution("FIXED");
        currentIssue.setComponent("glazedlists");
        currentIssue.setVersion("current");
        currentIssue.setAssignedTo("issues@glazedlists");
        currentIssue.setSubcomponent("www");
        currentIssue.setIssueType("DEFECT");
        currentIssue.setQAContact("issues@glazedlists");
        currentIssue.setShortDescription("CompositeList not thread-safe");
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("Glazed Lists' new CompositeList combines multiple event lists into one.\n\nThis class is not thread-safe. In particular, it may be possible to cause a deadlock when one thread is \nreading the CompositeList while another thread is writing a list that the CompositeList is composed of.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("This bug depends on fixing Issue 26. That issue is for adding beefier concurrency constructs to Glazed \nLists.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("After much thought, I have decided my approach to solving this bug.\n\nHere are the things that all solutions must consider:\n1. When one of the source lists change, they call notifyListChanges() while holding the writer lock to \nthat source list.\n2. When a user needs read access to any list including CompositeList, the user acquires a reader lock \nand performs their access. The list must not change during access.\n3. If a thread obtains two locks, it must always obtain the locks in the same order as any other thread \nthat may hold those two locks. Otherwise deadlock is possible as threads may compete for each other's \nlocks.\n\nMy initial idea was as follows:\n - Eliminate the need for locking all source lists for each access\n - When a read is performed, lock the local read lock and the read lock on the source list\n - When a write is performed, lock the local write lock and the write lock of the source list\n - When a source list calls notifyListChanges, use the tryLock() method to attempt to obtain the local \nwrite lock. If it can be obtained propogate the change. If it cannot, return without propogating the \nchange. The thread that currently holds a lock is now responsible for propogating that change.\n\nThis strategy has many advantages. It has a constant time to acquire locks, and it takes advantage of \nthe listEvent's abilities to be read at a later time. Although this avoids deadlock, the problem this \nstrategy is that this does not fulfill requirement 2.\n\nTherefore, I will implement a much simpler and potentially slower strategy:\n - for each lock, present a decorator lock that locks all corresponding locks from the source list\n - obtain the locks in a constant order: by the System.hashCode() value of their source list\n\nThis solution looks good! The only problem I have with it is that the System.hashCode() value could \nchange for an Object over time if it gets moved within memory. I doubt that this will be a problem but it \nis a good thing to keep an eye on.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("My initial implementation is complete, but I still need to add a test class to verify that it is thread safe.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("After implementing my proposed solution, I tested it and discovered that it was\nfailing miserably! The solution has a problem that prevents it from being\nacceptable. The notifying thread must have a write lock on the entire list to\nprevent changes from being made while the listChanged() method is being handled\nby listeners. This is requirement #2 and it is not satisfied by that proposal.\nTherefore the proposal is insufficient.\n\nTherefore I propose a new solution, somewhat of a hybrid between the two.\ni. Read lock on composite list obtains the read locks of all source lists in\narbitrary order\nii. Write lock on composite list is a special ReadWriteLock called\n\"PropagateLock\" plus the read locks of all source lists.\niii. Upon a change notification in the composite list, that thread tests if the\npropagateLock is locked. If it is, it leaves its changes to be propogated by the\nthread that currently owns the propogate lock. If that lock is unlocked, the\nthread takes the propogate lock and then all read locks in arbitrary order. It\nthen concatenates its own changes with any changes left while it was collecting\nlocks. Finally it propagates the concatenated change while holding the propogate\nlock, read locks to all source lists, and the original write lock for one source\nlist.\n\nThis combined lock includes the \"writer lock\" for this list, satisfying\nrequirement #1. \nThe reader lock is a hybrid lock that holds all other read locks, preventing\nchanges while reading. This satisfies requirement #2.\nThe reader locks need not be mutex with one another so that solves part of #3.\nFor writer locks, a thread's 2nd lock is always the propogate lock, and it fails\nif that lock is not available immediately, solving another part of #3. Finally,\nno thread acquires write locks after owning a first read lock, finishing up the\nfinal area of concern for requirement #3.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("Yet again, I have presented a solution that failed in practice. Here is the problem with my most recent \nsolution:\n\nSuppose you have two writer threads, A and B that write to source lists Apples and Bananas. There is \nalso a reader thread C that reads the composite list of A and B called \"FruitSalad\".\n\n1. A creates an event in Apples and acquires the write lock to Apples. A = { WL(Apples) }\n2. C wants to read the fruit salad and requests a read lock. By the provided implementation, this causes \nC to obtain read locks to each of the two lists Apples and Bananas in arbitrary order. C aquires the read \nlock to Bananas and requests the read lock to Apples, which blocks because A currently holds that lock. \nC = { RL(Bananas), REQUEST(RL(Apples)) }\n3. B wants to create an event in Bananas and requests the write lock to Bananas. This blocks because C \ncurrently holds that lock. B = { REQUEST(WL(Bananas)) }\n4. A forwards its event to FruitSalad, regarding its change to Apples. A attempts to acquire the read \nlocks to all lists in FruitSalad in order to forward this event. When attempting to acquire the read lock to \nBananas, this request is blocked because there is a waiting request for the write lock to Bananas by B. \nTherefore A = { WL(Apples), REQUEST(RL(Bananas)) }\n\nAs you can see, all of the lists are awaiting requests held by each other and we have a deadlock. This \nsucks! I do not think it is appropriate to change the preferences on the lock orders because doing so \nmay severely limit the original concurrency goals of Glazed Lists.\n\nFor now, I will continue to ponder a better solution. ");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("Created an attachment (id=2)\nMy request for help on Usenet\n");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("I was thinking about this problem and I came to a solution. Supporting arbitrary\nsources for CompositeList is not only difficult, it is impossible!\n\nThis is because allowing arbitrary numbers of threads and sources for each list\ncan always lead to potential deadloch situations. For example, suppose we have\nthe following.\nlist A\nlist B\nthread C reading the composite list (A, B) called \"Fruit Salad\"\nthread D reading the composite list (B, A) called \"Fruit Punch\"\nThen C can hold RL(A) while waiting for RL(B) while D is holding RL(B) while\nwaiting for RL(A). You guessed it, deadlock.\n\nIt may be worthwhile to investigate using a lock-aquiring-order to solve this\nproblem partially, but I still think that arbitrary graphs are impossible to\nsupport. I must also note that it is always possible to support arbitrary graphs\nwhen using a global lock. I would very much like to avoid that solution however.\n\nAnyway given my new requirements I have drafted up a new solution! Set writers\nto write change events to a queue, then attempt to obtain the composite list\nlock. Overload the composite list lock to first obtain a base lock, then to\nforward queued changes after all reader lock has been acquired.\n\nOr better, pseudocode:\n\n    lock() {\n       starlock.lock()\n       lock all read locks\n       process queue\n    }\n    unlock() {\n       starlock.unlock()\n       release all read locks\n    }\n    tryLock() {\n       boolean success = starlock.trylock() \n       if(!success) return false;\n       lock all read locks\n       process queue\n    }\n    listChanged(list event) {\n       add event to queue\n       cl.tryLock()\n       cl.unlock();\n    }\n\nDoes anybody have any comments on this strategy? The biggest new idea is that\nreaders may sometimes be called upon to forward changes when they are acquiring\nthe read lock.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("My solution worked and this issue has been resolved!\n\nHow satisfying!!\n");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("This bug has been fixed for two weeks with no problems. I am marking it closed.");
        currentIssue.getDescriptions().add(description);
        description = null;
        issues.add(currentIssue);
        currentIssue = null;
        currentIssue = new Issue();
        currentIssue.setId(new Integer(26));
        currentIssue.setStatus("CLOSED");
        currentIssue.setPriority(Priority.P3);
        currentIssue.setResolution("FIXED");
        currentIssue.setComponent("glazedlists");
        currentIssue.setVersion("current");
        currentIssue.setAssignedTo("jessewilson");
        currentIssue.setSubcomponent("www");
        currentIssue.setIssueType("DEFECT");
        currentIssue.setQAContact("issues@glazedlists");
        currentIssue.setShortDescription("Replace global lock with reader/writer locks");
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("The current Glazed Lists uses global locks for all reads and writes. It would higher performance to use a \nreader/writer lock instead.\n\nThe reader/writer lock could be either requested via eventList.getLock().aquireRead() or via \neventList.aquireReadLock(). I think I prefer using getLock(), which returns an object implementing a \nReaderWriterLock interface. That way I can easily swap out the lock implementation.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("We've swapped the global synchronized on root list to global reader writer locks.\n\nWe can now replace that with local locks.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("I am marking this problem as \"fixed\" and creating a new issue which covers concurrent mutationlist \nmodifications.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("This bug has been fixed for two weeks with no problems. I am marking it closed.");
        currentIssue.getDescriptions().add(description);
        description = null;
        issues.add(currentIssue);
        currentIssue = null;
        currentIssue = new Issue();
        currentIssue.setId(new Integer(27));
        currentIssue.setStatus("CLOSED");
        currentIssue.setPriority(Priority.P3);
        currentIssue.setResolution("FIXED");
        currentIssue.setComponent("glazedlists");
        currentIssue.setVersion("current");
        currentIssue.setAssignedTo("kevinmaltby");
        currentIssue.setSubcomponent("www");
        currentIssue.setIssueType("FEATURE");
        currentIssue.setQAContact("issues@glazedlists");
        currentIssue.setShortDescription("UniqueList not implemented");
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("Glazed Lists needs a UniqueList that can take two lists and show only the unique values.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("Kevin Maltby has got a working implementation! What a stallion!");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("kevinmaltby");
        description.setWhen(null);
        description.setText("UniqueLists are now implemented to provide a unique view of a given list.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("kevinmaltby");
        description.setWhen(null);
        description.setText("Jesse Wilson broke it with the addition of the testUpdateDeleteCollide test \ncase.\n\nThe result of this test was the following Exception...\n\n    [junit] Testcase: testUpdateDeleteCollide(com.odellengineeringltd.glazedlist\ns.util.UniqueListTest): Caused an ERROR\n    [junit] cannot get from tree of size 1 at 1\n    [junit] java.lang.IndexOutOfBoundsException: cannot get from tree of size 1\nat 1\n    [junit]     at com.odellengineeringltd.glazedlists.util.IndexedTreeNode.getN\nodeWithIndex(IndexedTreeNode.java:81)\n    [junit]     at com.odellengineeringltd.glazedlists.util.IndexedTree.getNode(\nIndexedTree.java:64)\n    [junit]     at com.odellengineeringltd.glazedlists.SortedList.get(SortedList\n.java:239)\n    [junit]     at com.odellengineeringltd.glazedlists.util.UniqueList.get(Uniqu\neList.java:167)\n    [junit]     at com.odellengineeringltd.glazedlists.util.UniqueList.processIn\nsertEvent(UniqueList.java:259)\n    [junit]     at com.odellengineeringltd.glazedlists.util.UniqueList.notifyLis\ntChanges(UniqueList.java:209)\n    [junit]     at com.odellengineeringltd.glazedlists.event.ListChangeSequence.\ncommitAtomicChange(ListChangeSequence.java:134)\n    [junit]     at com.odellengineeringltd.glazedlists.SortedList.notifyListChan\nges(SortedList.java:146)\n    [junit]     at com.odellengineeringltd.glazedlists.event.ListChangeSequence.\ncommitAtomicChange(ListChangeSequence.java:134)\n    [junit]     at com.odellengineeringltd.glazedlists.AbstractFilterList.handle\nFilterChanged(AbstractFilterList.java:187)\n    [junit]     at com.odellengineeringltd.glazedlists.util.UniqueListTest$IntAr\nrayFilterList.setFilter(UniqueListTest.java:526)\n    [junit]     at com.odellengineeringltd.glazedlists.util.UniqueListTest.testU\npdateDeleteCollide(UniqueListTest.java:542)");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("This is broken because some naive programmer guy didn't do a very good job at implementing \nSortedList. ");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("This bug has been fixed as a consequence of bug 37 being fixed.\n\nI performed the Unit Tests and all worked perfectly, for 1000 elements filtered 10 times.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("This bug has been fixed for two weeks with no problems. I am marking it closed.");
        currentIssue.getDescriptions().add(description);
        description = null;
        issues.add(currentIssue);
        currentIssue = null;
        currentIssue = new Issue();
        currentIssue.setId(new Integer(28));
        currentIssue.setStatus("CLOSED");
        currentIssue.setPriority(Priority.P1);
        currentIssue.setResolution("FIXED");
        currentIssue.setComponent("glazedlists");
        currentIssue.setVersion("current");
        currentIssue.setAssignedTo("issues@glazedlists");
        currentIssue.setSubcomponent("www");
        currentIssue.setIssueType("DEFECT");
        currentIssue.setQAContact("issues@glazedlists");
        currentIssue.setShortDescription("Lists may fail if the change event indicies are out of order");
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("Lists that evaluate the values such as SortedList and FilteredList may break if the change event has \nindicies that arrive out of order.\n\nThere should be a test for this added to the unit tests and a fix should be made if the problem is \nlegitimate.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("I have created a JUnit test that confirms the presense of this bug. That test has been added to CVS.\n\nThe solution as I see it is to add a method in the ListChangeSequence that is called from \ncommitAtomicChanges(). Such a method would examine the list change events and re-order them into \norder of increasing index.\n\nThe reordering could potentially also merge adjacent list change blocks but this is not totally necessary.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("The ListChangeSequence now bubble-sorts change blocks when the change is commited.\n\nBubbleSort was used because it only swaps adjacent entries. When two change blocks are swapped, \ntheir indicies must be modified relative to one another. Therefore bubble sort is the simplest sort to \nimplement.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("This bug appears to remain broken:\n\n    [junit] Testcase: testIndexOutOfOrder(com.odellengineeringltd.glazedlists.test.IndexOrderTest):     \nFAILED\n    [junit] expected:<[[I@c05d3b, [I@28f6ee, [I@6bade9, [I@66afb3, [I@9945ce, [I@b5dac4, [I@2d96f2, \n[I@110003, [I@17e4ca, [I@adb1d4, [I@75d6ab, [I@60a26f, [I@484a05, [I@f39b3a, [I@542a75, \n[I@af993e, [I@75e4fc, [I@c62c8, [I@2940b3, [I@56b6b9, [I@f66cff, [I@6de49c, [I@bbf1ca, [I@ff0dde, \n[I@e78fc6, [I@901437, [I@1f6226, [I@64ea66, [I@58f9d3, [I@79a2e7, [I@b60280, [I@5e55ab, \n[I@4a55f2, [I@5093f1, [I@20bf2c, [I@e6f7d2, [I@9836ed, [I@3e0ebb, [I@39443f, [I@afae45, [I@da4b71, \n[I@8f1d7e, [I@d9660d, [I@bb0d0d, [I@55e55f, [I@45c859, [I@64883c, [I@2c1e6b, [I@811c88, \n[I@785d65, [I@3bc257, [I@53f67e, [I@5bdc50, [I@dd3812, [I@8c436b, [I@9e5c73, [I@c791b9, \n[I@3020ad, [I@b15692, [I@aa9f99, [I@d42d08, [I@d86fd3, [I@958bb8, [I@7f4ec, [I@60e128, \n[I@5e1077, [I@8b3364, [I@db05b2, [I@530cf2, [I@76fba0, [I@81ed9e, [I@175422, [I@949f69, \n[I@6dadf9, [I@b8d6f7, [I@290fbc, [I@c80b01, [I@4aa0ce, [I@833eca, [I@8f5824, [I@e3cd51, [I@bc8e1e, \n[I@1671b2, [I@82764b, [I@2452e8, [I@bf3d87, [I@60991f, [I@e4f7c2, [I@45f0e3, [I@c9d92c, [I@d0fafc, \n[I@dc6b5, [I@70bea5, [I@f47396, [I@d0af9b, [I@b8f8eb, [I@de17f4, [I@f6ba0f, [I@313906, [I@96cf11, \n[I@f47bf5, [I@f6438d, [I@cd0888]> but was:<[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, \n18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, \n44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, \n70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, \n96, 97, 98, 99, 100, 101]>\n    [junit] junit.framework.AssertionFailedError: expected:<[[I@c05d3b, [I@28f6ee, [I@6bade9, \n[I@66afb3, [I@9945ce, [I@b5dac4, [I@2d96f2, [I@110003, [I@17e4ca, [I@adb1d4, [I@75d6ab, \n[I@60a26f, [I@484a05, [I@f39b3a, [I@542a75, [I@af993e, [I@75e4fc, [I@c62c8, [I@2940b3, [I@56b6b9, \n[I@f66cff, [I@6de49c, [I@bbf1ca, [I@ff0dde, [I@e78fc6, [I@901437, [I@1f6226, [I@64ea66, [I@58f9d3, \n[I@79a2e7, [I@b60280, [I@5e55ab, [I@4a55f2, [I@5093f1, [I@20bf2c, [I@e6f7d2, [I@9836ed, \n[I@3e0ebb, [I@39443f, [I@afae45, [I@da4b71, [I@8f1d7e, [I@d9660d, [I@bb0d0d, [I@55e55f, \n[I@45c859, [I@64883c, [I@2c1e6b, [I@811c88, [I@785d65, [I@3bc257, [I@53f67e, [I@5bdc50, \n[I@dd3812, [I@8c436b, [I@9e5c73, [I@c791b9, [I@3020ad, [I@b15692, [I@aa9f99, [I@d42d08, \n[I@d86fd3, [I@958bb8, [I@7f4ec, [I@60e128, [I@5e1077, [I@8b3364, [I@db05b2, [I@530cf2, [I@76fba0, \n[I@81ed9e, [I@175422, [I@949f69, [I@6dadf9, [I@b8d6f7, [I@290fbc, [I@c80b01, [I@4aa0ce, [I@833eca, \n[I@8f5824, [I@e3cd51, [I@bc8e1e, [I@1671b2, [I@82764b, [I@2452e8, [I@bf3d87, [I@60991f, \n[I@e4f7c2, [I@45f0e3, [I@c9d92c, [I@d0fafc, [I@dc6b5, [I@70bea5, [I@f47396, [I@d0af9b, [I@b8f8eb, \n[I@de17f4, [I@f6ba0f, [I@313906, [I@96cf11, [I@f47bf5, [I@f6438d, [I@cd0888]> but was:<[0, 1, 2, 3, \n4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, \n32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, \n58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, \n84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101]>\n    [junit]     at \ncom.odellengineeringltd.glazedlists.test.IndexOrderTest.testIndexOutOfOrder(IndexOrderTest.java:85)\n    [junit]     at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\n    [junit]     at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:39)\n    [junit]     at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:\n25)\n");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("kevinmaltby");
        description.setWhen(null);
        description.setText("The current ordering of events appears to be inverted and thus events appear in \ndecreasing order.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("Fixed! Again! This bug has haunted me all day. \n\nThe solution sorts and combines properly, but not necessarily too efficiently. If this proves to be a \nproblem, I'll send the optimization police onto it!\n\nHere's an example of the (poor) runtime. Changes are measured in loop executions.\n    [junit] Changed! blocks before: 142, after: 142, changes: 141\n    [junit] Changed! blocks before: 204, after: 1, changes: 405\n    [junit] Changed! blocks before: 203, after: 88, changes: 9890\n    [junit] Changed! blocks before: 306, after: 253, changes: 647\n    [junit] Changed! blocks before: 541, after: 40, changes: 5257\n    [junit] Changed! blocks before: 514, after: 73, changes: 27433\n    [junit] Changed! blocks before: 212, after: 158, changes: 439\n    [junit] Changed! blocks before: 626, after: 9, changes: 46633\n    [junit] Changed! blocks before: 548, after: 67, changes: 22004\n    [junit] Changed! blocks before: 141, after: 141, changes: 140\n    [junit] Changed! blocks before: 411, after: 91, changes: 20767\n    [junit] Changed! blocks before: 119, after: 119, changes: 118\n    [junit] Changed! blocks before: 490, after: 2, changes: 32108\n    [junit] Changed! blocks before: 460, after: 81, changes: 24387\n    [junit] Changed! blocks before: 121, after: 121, changes: 120\n    [junit] Changed! blocks before: 551, after: 81, changes: 24285\n    [junit] Changed! blocks before: 219, after: 176, changes: 447\n    [junit] Changed! blocks before: 623, after: 68, changes: 53634\n    [junit] Changed! blocks before: 572, after: 23, changes: 23838\n    [junit] Changed! blocks before: 34, after: 34, changes: 33\n    [junit] Changed! blocks before: 41, after: 29, changes: 919\n    [junit] Changed! blocks before: 55, after: 55, changes: 54\n    [junit] Changed! blocks before: 77, after: 50, changes: 2964\n    [junit] Changed! blocks before: 65, after: 1, changes: 127\n    [junit] Changed! blocks before: 46, after: 46, changes: 45\n");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("This bug has been fixed for two weeks with no problems. I am marking it closed.");
        currentIssue.getDescriptions().add(description);
        description = null;
        issues.add(currentIssue);
        currentIssue = null;
        currentIssue = new Issue();
        currentIssue.setId(new Integer(29));
        currentIssue.setStatus("CLOSED");
        currentIssue.setPriority(Priority.P4);
        currentIssue.setResolution("FIXED");
        currentIssue.setComponent("glazedlists");
        currentIssue.setVersion("current");
        currentIssue.setAssignedTo("jessewilson");
        currentIssue.setSubcomponent("www");
        currentIssue.setIssueType("DEFECT");
        currentIssue.setQAContact("issues@glazedlists");
        currentIssue.setShortDescription("ToString on BasicEventList, MutationList no good");
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("The toString value on Java Lists is like \"[lemon, orange, apple, banana]\"\nbut on Glazed Lists it is like \"com.odellengineeringltd.glazedlists.BasicEventList@f4d448ce\"");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("kevinmaltby");
        description.setWhen(null);
        description.setText("The toString value on Glazed Lists is the same as the toString value on Java \nLists now.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("This bug has been fixed for two weeks with no problems. I am marking it closed.");
        currentIssue.getDescriptions().add(description);
        description = null;
        issues.add(currentIssue);
        currentIssue = null;
        currentIssue = new Issue();
        currentIssue.setId(new Integer(30));
        currentIssue.setStatus("CLOSED");
        currentIssue.setPriority(Priority.P4);
        currentIssue.setResolution("FIXED");
        currentIssue.setComponent("glazedlists");
        currentIssue.setVersion("current");
        currentIssue.setAssignedTo("issues@glazedlists");
        currentIssue.setSubcomponent("www");
        currentIssue.setIssueType("TASK");
        currentIssue.setQAContact("issues@glazedlists");
        currentIssue.setShortDescription("Verify ListTable changeSizeRepaintAllThreshhold works");
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("Some users have had problems with the behaviour of Glazed Lists when the \nchangeSizeRepaintAllThreshhold is low.\n\nVerify that the behaviour is:\n - correct\n - faster than using single changes");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("I've done some research and learned a lot about the behaviour of JTable.\n\nWhen you give JTable a large set of small changes, it has different behaviour depending on what its \nrenderer is doing. If the table rows all have a uniform height, then the JTable is very fast at handling \nsuch a set of changes. If the table rows have nonuniform height, however, the JTable is very slow.\n\nTherefore I am going to make a few small changes:\n - I am going to further document the changeSizeRepaintAllThreshhold and its relationship with the \ntable speed in both the ListTable class and in the performance section of the tutorial\n - I am going to change the default value of changeSizeRepaintAllThreshhold to 250, and add proper \ngetter and setter values. The table performance was intolerable with variable row sizes when there were \nmroe than 250 changes, but may be acceptable below that.\n\nNote that the changeSizeRepaintAllThreshhold is an unwanted hack to work around the poor behaviour \nof JTable in such situations. It has major problems because it forces the table to lose its selection and \nits scrolling.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("I have changed the behaviour of repaintAllThreshhold to default to Integer.MAX_VALUE. Therefore new \nrepaintAllThreshhold must be set manually to be enabled. This is good because the whole thing is kind \nof an ugly hack to get around the poor behaviour of the JTable's ability to track row height. \n\nI believe the whole problem stems from a poor implementation of SizeSequence in the JVM. I think a \ntree-based structure similar to the one used for SparseList may be more appropriate.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("This bug has been fixed for two weeks with no problems. I am marking it closed.");
        currentIssue.getDescriptions().add(description);
        description = null;
        issues.add(currentIssue);
        currentIssue = null;
        currentIssue = new Issue();
        currentIssue.setId(new Integer(31));
        currentIssue.setStatus("CLOSED");
        currentIssue.setPriority(Priority.P2);
        currentIssue.setResolution("FIXED");
        currentIssue.setComponent("glazedlists");
        currentIssue.setVersion("current");
        currentIssue.setAssignedTo("issues@glazedlists");
        currentIssue.setSubcomponent("www");
        currentIssue.setIssueType("ENHANCEMENT");
        currentIssue.setQAContact("issues@glazedlists");
        currentIssue.setShortDescription("More powerful TableComparatorSelector");
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("Glazed Lists' TableComparatorSelector does not:\n - have chevrons or arrows to indicate sort order\n - allow sorting by multiple columns simultaneously\n\nThese should be implemented by \"beefing-up\" TableComparatorSelector.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("I've moved this from priority 4 to priority 2 due to demand!\n\nI also got some additional info from the users mailing list.\n\nSource for a tool that does table header stuff well:\nhttp://www.fawcette.com/javapro/2002_08/magazine/columns/visualcomponents/\n\nAlso - the table should support raw-order sort.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("I have started preliminary work on this.\n\nI have yet to do the header arrows and multiple-column sort, but the new TableComparatorSelector is \nalready much, much better.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("I've added support for multiple column sort, and arrow icons.\n\nHeader/table sorting is now a FIRST CLASS feature in Glazed Lists.\n\nAll that's left is support for raw sort order. I will enter a new bug for that as the support should be done \nin SortedList.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("This bug has been fixed for two weeks with no problems. I am marking it closed.");
        currentIssue.getDescriptions().add(description);
        description = null;
        issues.add(currentIssue);
        currentIssue = null;
        currentIssue = new Issue();
        currentIssue.setId(new Integer(32));
        currentIssue.setStatus("NEW");
        currentIssue.setPriority(Priority.P5);
        currentIssue.setResolution("");
        currentIssue.setComponent("glazedlists");
        currentIssue.setVersion("current");
        currentIssue.setAssignedTo("kevinmaltby");
        currentIssue.setSubcomponent("www");
        currentIssue.setIssueType("ENHANCEMENT");
        currentIssue.setQAContact("issues@glazedlists");
        currentIssue.setShortDescription("CachingList could be more powerful");
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("As Kevin and I were working on the CachingList problems today, we came up with some clever new \nideas for a powerful replacement for CachingList:\n\n - background loading. Calls to get() return a default value immediately, then load the actual value in \nthe background. Finally fire a updated() event when the actual value is loaded.\n\n - bulk loading via an API. Create a Caching API for performing BulkLoading. This is not really a \nMutationList because it would require more than an EventList as a source. Bulk loading could be faster \nbut it is definitely a big fat ugly pig to implement.\n\n - footprint that is bounded by max cache size and NOT by the size of the source list. This will be \nnecessary for arbitrarily large source lists on finitely powerful computers.\n\nRegardless of where we go forward with Caching, it will be necessary to find some real-world cases that \nrequire caching before we commit serious time to the problem. Such cases will enable us to have a \nuser's perspective on caching.");
        currentIssue.getDescriptions().add(description);
        description = null;
        issues.add(currentIssue);
        currentIssue = null;
        currentIssue = new Issue();
        currentIssue.setId(new Integer(33));
        currentIssue.setStatus("CLOSED");
        currentIssue.setPriority(Priority.P2);
        currentIssue.setResolution("FIXED");
        currentIssue.setComponent("glazedlists");
        currentIssue.setVersion("current");
        currentIssue.setAssignedTo("jessewilson");
        currentIssue.setSubcomponent("www");
        currentIssue.setIssueType("ENHANCEMENT");
        currentIssue.setQAContact("issues@glazedlists");
        currentIssue.setShortDescription("SortedList raw order support");
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("SortedList should support raw order when the current comparator is NULL.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("This is now high priority as it is needed for making TableComparatorChooser work better.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("Done!\n\nAlthough the SortedList now supports raw-order sort, this is not supported by \nTableComparatorChooser.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("This bug has been fixed for two weeks with no problems. I am marking it closed.");
        currentIssue.getDescriptions().add(description);
        description = null;
        issues.add(currentIssue);
        currentIssue = null;
        currentIssue = new Issue();
        currentIssue.setId(new Integer(34));
        currentIssue.setStatus("CLOSED");
        currentIssue.setPriority(Priority.P3);
        currentIssue.setResolution("FIXED");
        currentIssue.setComponent("glazedlists");
        currentIssue.setVersion("current");
        currentIssue.setAssignedTo("issues@glazedlists");
        currentIssue.setSubcomponent("www");
        currentIssue.setIssueType("DEFECT");
        currentIssue.setQAContact("issues@glazedlists");
        currentIssue.setShortDescription("UniqueList sometimes does not forward events on a DELETE");
        description = new Description();
        description.setWho("kevinmaltby");
        description.setWhen(null);
        description.setText("UniqueList currently does not forward events on when a DELETE is encountered in \nthe following instance:\n\nThe element being removed is modelled in the unique view and has at least one \nduplicate.  This should result in the duplicate being modelled in the unique \nview and an update event being forwarded.\n\nIn some circumstances, such as on a call to clear() on the source list, \nforwarding this event causes the following exception:\n\nChange blocks U.0 and D.0-1 intersect\njava.lang.IllegalStateException: Change blocks U.0 and D.0-1 intersect\nat com.odellengineeringltd.glazedlists.event.ListChangeBlock.requiresSwap\n(ListChangeBlock.java:185)...\n\nThis fix will require altering the current strategy for dealing with change \ncollisions in ListChangeBlock.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("kevinmaltby");
        description.setWhen(null);
        description.setText("UniqueList now forwards events correctly in all cases when handling DELETE \nevents.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("This bug has been fixed for two weeks with no problems. I am marking it closed.");
        currentIssue.getDescriptions().add(description);
        description = null;
        issues.add(currentIssue);
        currentIssue = null;
        currentIssue = new Issue();
        currentIssue.setId(new Integer(35));
        currentIssue.setStatus("CLOSED");
        currentIssue.setPriority(Priority.P5);
        currentIssue.setResolution("FIXED");
        currentIssue.setComponent("glazedlists");
        currentIssue.setVersion("current");
        currentIssue.setAssignedTo("issues@glazedlists");
        currentIssue.setSubcomponent("www");
        currentIssue.setIssueType("ENHANCEMENT");
        currentIssue.setQAContact("issues@glazedlists");
        currentIssue.setShortDescription("UniqueList needs a means of forwarding non-mandatory change events");
        description = new Description();
        description.setWho("kevinmaltby");
        description.setWhen(null);
        description.setText("UniqueList needs to provide access to non-mandatory change events for \noverlaying lists which want to listen to them.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("This non-critical issue is being marked low-priority until Glazed Lists 1.0 has\nbeen released.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("The solution is for UniqueList to use multiple ListEventAssemblers and to allow\nlisteners to choose which ListEventAssembler they subscribe to by overloading\nthe addListEventListener() method.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("This bug has been fixed for two weeks with no problems. I am marking it closed.");
        currentIssue.getDescriptions().add(description);
        description = null;
        issues.add(currentIssue);
        currentIssue = null;
        currentIssue = new Issue();
        currentIssue.setId(new Integer(36));
        currentIssue.setStatus("CLOSED");
        currentIssue.setPriority(Priority.P5);
        currentIssue.setResolution("FIXED");
        currentIssue.setComponent("glazedlists");
        currentIssue.setVersion("current");
        currentIssue.setAssignedTo("issues@glazedlists");
        currentIssue.setSubcomponent("www");
        currentIssue.setIssueType("FEATURE");
        currentIssue.setQAContact("issues@glazedlists");
        currentIssue.setShortDescription("GlazedLists requires a counted, unique view of a given list.");
        description = new Description();
        description.setWho("kevinmaltby");
        description.setWhen(null);
        description.setText("This list type is based on the Bag ADT and is currently unnamed.\n\nThis class will sit on top of a UniqueList, and listen to all change events \nfrom the UniqueList to correctly provide access to not only a view which is \nguaranteed to be unique, but also the number of duplicate values for each \nunique value.\n\nAn example usage would be a list of votes for favourite pop.\n\nSource         Unique View         Unique, Counted\n------------------------------------------------------\nPepsi        | Coke              | Coke x 3\nCoke         | MountainDew       | Mountain Dew\nSprite       | Pepsi             | Pepsi x 2\nPepsi        | Sprite            | Sprite\nMountain Dew |                   |\nCoke         |                   |\nCoke         |                   |\n------------------------------------------------------\n\nClearly this could provide a valuable list view.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("kevinmaltby");
        description.setWhen(null);
        description.setText("Specified an explicit dependency upon Issue 35.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("This non-critical issue is being marked low-priority until Glazed Lists 1.0 has\nbeen released.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("This non-critical issue is being marked low-priority until Glazed Lists 1.0 has\nbeen released.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("I've added the getCount() method which works well and was very easy to\nimplement. Like all reading methods, this method is not thread safe. I think it\nwould be a good idea to comb through the Javadocs before 1.0 and add a standard\nthread safe warning to methods like these.\n\nAlso I attempted to implement listeners for the bag events but I failed because\nsometimes updates are thrown that collide with deletes or inserts. For example,\nif I have a change that deletes multiple instances of a value, the first few\ndeletes will throw updates and the last delete will throw a delete. These\nintersect and the ListEventAssembler complains. So this is on hold for now.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("Fixed for now! We may add listeners for change counts later, but that will require some work on \nListEventAssembler.\n");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("This bug has been fixed for two weeks with no problems. I am marking it closed.");
        currentIssue.getDescriptions().add(description);
        description = null;
        issues.add(currentIssue);
        currentIssue = null;
        currentIssue = new Issue();
        currentIssue.setId(new Integer(37));
        currentIssue.setStatus("CLOSED");
        currentIssue.setPriority(Priority.P3);
        currentIssue.setResolution("FIXED");
        currentIssue.setComponent("glazedlists");
        currentIssue.setVersion("current");
        currentIssue.setAssignedTo("issues@glazedlists");
        currentIssue.setSubcomponent("www");
        currentIssue.setIssueType("TASK");
        currentIssue.setQAContact("issues@glazedlists");
        currentIssue.setShortDescription("Glazed Lists version 0.8 release");
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("Glazed Lists version 0.8 is the last release before Glazed Lists undergoes the major API change.\n\nGlazed Lists 0.8 will be a release that should be permanently available on the Glazed Lists webpage for \nexisting users, but such users should be encouraged to migrate to Glazed Lists 0.9.\n\nGlazed Lists v0.8 does not inlcude:\n - the renaming of APIs and classes\n - the new concurrency model\n\nIt depents upon the following issues:\n 33 - SortedList raw order support\n 34 - UniqueList sometimes does not forward events on a DELETE\n 29 - ToString on BasicEventList, MutationList no good\n 30 - Verify ListTable changeSizeRepaintAllThreshhold works");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("This issue depends on the outstanding bugs in the 0.8 release. It does not require new features or \nenhancements.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("The 0.8 release can't be done until the SortedList is fixed and the UniqueList is finished (and verified)");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("Version 0.8 was released on April 15, 2004.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("This bug has been fixed for two weeks with no problems. I am marking it closed.");
        currentIssue.getDescriptions().add(description);
        description = null;
        issues.add(currentIssue);
        currentIssue = null;
        currentIssue = new Issue();
        currentIssue.setId(new Integer(38));
        currentIssue.setStatus("CLOSED");
        currentIssue.setPriority(Priority.P4);
        currentIssue.setResolution("FIXED");
        currentIssue.setComponent("glazedlists");
        currentIssue.setVersion("current");
        currentIssue.setAssignedTo("issues@glazedlists");
        currentIssue.setSubcomponent("www");
        currentIssue.setIssueType("DEFECT");
        currentIssue.setQAContact("issues@glazedlists");
        currentIssue.setShortDescription("TableComparatorChooser icon can get out of sync");
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("When the sorting of a list changes, the TableComparatorChooser fails to respond to this change \nappropriately. The TableComparatorChooser should show the proper icon, even if the sorted list's \ncomparator was selected elsewhere.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("kevinmaltby");
        description.setWhen(null);
        description.setText("TableComparatorChooser now responds to sorting criteria changing externally.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("This bug has been fixed for two weeks with no problems. I am marking it closed.");
        currentIssue.getDescriptions().add(description);
        description = null;
        issues.add(currentIssue);
        currentIssue = null;
        currentIssue = new Issue();
        currentIssue.setId(new Integer(39));
        currentIssue.setStatus("CLOSED");
        currentIssue.setPriority(Priority.P2);
        currentIssue.setResolution("FIXED");
        currentIssue.setComponent("glazedlists");
        currentIssue.setVersion("current");
        currentIssue.setAssignedTo("issues@glazedlists");
        currentIssue.setSubcomponent("www");
        currentIssue.setIssueType("DEFECT");
        currentIssue.setQAContact("issues@glazedlists");
        currentIssue.setShortDescription("Sorting clears selection");
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("This problem will be very difficult to solve using the current Glazed Lists framework, but it is a valid \nproblem. Sorting clears the selection. \n\nThe only fix I can think of is to add a new type of event alongside INSERT, UPDATE and DELETE which is \ncalled MOVE. I think it is kind of an ugly hack on principal because it will impact all other lists if it is \nimplemented. \n\nI will have to give this one some more thought. Saving selection by value may be one option but that is \nalso rather a big ugly hack.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("The \"ideal\" solution looks like it will cause major headaches to the rest of the\nGlazed Lists code. I think we should consider implementing a simpler solution\nthat keeps the selection by value rather than by index. This solution is\nstraightforward to implement and will be immediately useful to Glazed Lists' users.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("After a bunch of thinking I have come to the conclusion that this solution can\nbe implemented without compromising the rest of Glazed Lists.\n\nHere is my idea:\nAdd an extra property to each change event called \"is reorder\". Such events will\nalways contain remove all and insert all events so that they can be processed as\nthey are currently by regular lists. But lists that are reorder-aware can view\nthe reorder property and get an array of reorder indicies. \n\nHaving reorder supported in lists like filter list will improve performance!\nSuppose a sorted list is filtered. Then if that list is resorted, each element\nis currently tested to see if it shall still be filtered. But if the filter list\nsupports reordering, it can use the reorder and not need to refilter.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("This solution is mostly implemented! The only thing left is to add support for \nmultiple sorted lists in sequence. This will be necessary for UniqueList \nsupport!\n\nOh boy!");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("I have added support to major classes: SortedList (and UniqueList), AbstractFilterList, & \nEventSelectionModel.\n\nI will also need to add support for minor classes: CachingList, FreezableList, CompositeList. I am \nconsidering adding a method forwardEvent(ListChanges c) to speed up lists like FreezableList that \nsimply propagate changes.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("This bug has been fixed for two weeks with no problems. I am marking it closed.");
        currentIssue.getDescriptions().add(description);
        description = null;
        issues.add(currentIssue);
        currentIssue = null;
        currentIssue = new Issue();
        currentIssue.setId(new Integer(40));
        currentIssue.setStatus("CLOSED");
        currentIssue.setPriority(Priority.P2);
        currentIssue.setResolution("FIXED");
        currentIssue.setComponent("glazedlists");
        currentIssue.setVersion("current");
        currentIssue.setAssignedTo("jessewilson");
        currentIssue.setSubcomponent("www");
        currentIssue.setIssueType("DEFECT");
        currentIssue.setQAContact("issues@glazedlists");
        currentIssue.setShortDescription("Sorted List fails upon intensive filtering");
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("SortedList fails upon an intensive amount of filtering. The SortedListTest must be updated to catch this \nfailure and the SortedList should also be fixed to remedy the problem.\n\n    [junit] FILTER: 4, 5, 1, 6, 2, 3, 2, 8, 1, 3, \n    [junit] SORTED: 1, 1, 2, 3, 2, 3, 4, 8, 5, 6,");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("I was processing the events in the ListChangeEvent in a manner that was unsafe when there were \ninserts mixed with deletes.\n\nThe SortedList now fires all delete events first, and then goes on to handle the inserts and updates \nlater.\n");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("This bug has been fixed for two weeks with no problems. I am marking it closed.");
        currentIssue.getDescriptions().add(description);
        description = null;
        issues.add(currentIssue);
        currentIssue = null;
        currentIssue = new Issue();
        currentIssue.setId(new Integer(41));
        currentIssue.setStatus("CLOSED");
        currentIssue.setPriority(Priority.P3);
        currentIssue.setResolution("FIXED");
        currentIssue.setComponent("glazedlists");
        currentIssue.setVersion("current");
        currentIssue.setAssignedTo("issues@glazedlists");
        currentIssue.setSubcomponent("www");
        currentIssue.setIssueType("TASK");
        currentIssue.setQAContact("issues@glazedlists");
        currentIssue.setShortDescription("Glazed Lists version 0.9 release");
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("This issue depends upon all issues to be resolved for the 0.9 release.\n\nThese issues include the name refactoring and API stability.\n\nGlazed Lists 0.9 is a release intended to have 100% compatibility with 1.0. This includes:\n - class & package names\n - concurrency strategy\n - event sequence strategy");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("This release depends upon the 0.9 issues.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("TO DO, left in this release, off the top of my head:\n* make final classes final\n* determine where EventList iterator/sublist goes\n* tutorial? may defer to 1.0\n* rename main package (ca.odell.glazedlists)\n* port Query stuff to use UniqueList, move package to migrationkit\n* move DEMO out of Javadocs (new demo for 1.0 definitely needed)\n* change TableFormat to not include configureTable() method");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("Released!");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("This bug has been fixed for two weeks with no problems. I am marking it closed.");
        currentIssue.getDescriptions().add(description);
        description = null;
        issues.add(currentIssue);
        currentIssue = null;
        currentIssue = new Issue();
        currentIssue.setId(new Integer(42));
        currentIssue.setStatus("CLOSED");
        currentIssue.setPriority(Priority.P3);
        currentIssue.setResolution("FIXED");
        currentIssue.setComponent("glazedlists");
        currentIssue.setVersion("current");
        currentIssue.setAssignedTo("issues@glazedlists");
        currentIssue.setSubcomponent("www");
        currentIssue.setIssueType("DEFECT");
        currentIssue.setQAContact("issues@glazedlists");
        currentIssue.setShortDescription("Enable concurrent mutation list modifications");
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("Currently the reader/writer locks lock ALL lists when any mutation list is being modified (ie. re-sorted).\n\nThe reader/writer locks should be changed to only lock dependent lists when such a modification takes \nplace.\n\nThis applies to:\n - AbstractFilterList\n - SortedList\n - UniqueList\n - CachingList\n - and potentially others");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("Fixed . . . now the SortedList and AbstractFilterList can sort or filter multiple lists with the same source \nsimultaneously. This uses the new InternalReadWriteLock which delegates locking to a pair of \nReadWriteLocks.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("This bug has been fixed for two weeks with no problems. I am marking it closed.");
        currentIssue.getDescriptions().add(description);
        description = null;
        issues.add(currentIssue);
        currentIssue = null;
        currentIssue = new Issue();
        currentIssue.setId(new Integer(43));
        currentIssue.setStatus("NEW");
        currentIssue.setPriority(Priority.P5);
        currentIssue.setResolution("");
        currentIssue.setComponent("glazedlists");
        currentIssue.setVersion("current");
        currentIssue.setAssignedTo("issues@glazedlists");
        currentIssue.setSubcomponent("www");
        currentIssue.setIssueType("DEFECT");
        currentIssue.setQAContact("issues@glazedlists");
        currentIssue.setShortDescription("Potential deadlock in CachingList");
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("The CachingList acquires a WriteLock when it may already have a ReadLock.\n\nThis is DANGEROUS! It is possible that two CachingLists may each have readlocks, and contest over a \nwrite lock to their doom!");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("Simple solution: make CachingList.getReadLock() return the write lock.");
        currentIssue.getDescriptions().add(description);
        description = null;
        issues.add(currentIssue);
        currentIssue = null;
        currentIssue = new Issue();
        currentIssue.setId(new Integer(44));
        currentIssue.setStatus("CLOSED");
        currentIssue.setPriority(Priority.P2);
        currentIssue.setResolution("FIXED");
        currentIssue.setComponent("glazedlists");
        currentIssue.setVersion("current");
        currentIssue.setAssignedTo("issues@glazedlists");
        currentIssue.setSubcomponent("www");
        currentIssue.setIssueType("DEFECT");
        currentIssue.setQAContact("issues@glazedlists");
        currentIssue.setShortDescription("remove(object), clear() can have unwanted side effects");
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("Suppose we have a List \"alphabet\" containing \"A\", \"B\", \"C\", \"D\", \"E\", \"F\".\nIf we call alphabet.subList(1, 3).clear(), then the list alphabet should change to \"A\", \"D\", \"E\", \"F\".\nBut Glazed Lists clears the entire list alphabet.\n\nSimilar problems exist upon clearing filtered lists, etc.\n\nThis problem exists in the following List methods:\nclear()\nremove(Object)\nremoveAll(Collection)\nretainAll(Collection)");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("Fixed! Hopefully, this doesn't ruin any code in place because the behaviour of SubList etc.\nare now correct. Existing code could possibly depend on the incorrect implementations!\nHopefully that does not prove to be a problem.\n\nThis fix allows us to do cool things, as I will demonstrate:\n\nSuppose we have a list, alphabet composed of { A, B, C, D, E, F, G, H, I, J, K }\nAnd we constructed a transformed list vowels, which filtered alphabet to { A, E, I }\nThen if we do vowels.clear(), we get the following result:\nalphabet becomes: B, C, D, F, G, H, J, K\n\nCool, no? This would be made more powerful with a better example. Perhaps a list of email addresses, \nand a filter list that picks the SPAM or whatever.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("This bug has been fixed for two weeks with no problems. I am marking it closed.");
        currentIssue.getDescriptions().add(description);
        description = null;
        issues.add(currentIssue);
        currentIssue = null;
        currentIssue = new Issue();
        currentIssue.setId(new Integer(45));
        currentIssue.setStatus("CLOSED");
        currentIssue.setPriority(Priority.P2);
        currentIssue.setResolution("FIXED");
        currentIssue.setComponent("glazedlists");
        currentIssue.setVersion("current");
        currentIssue.setAssignedTo("issues@glazedlists");
        currentIssue.setSubcomponent("www");
        currentIssue.setIssueType("ENHANCEMENT");
        currentIssue.setQAContact("issues@glazedlists");
        currentIssue.setShortDescription("Add write functionality to UniqueList");
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("The UniqueList should be writable. Some write methods to include:\n\nadd(), remove(), set() . . .\n\nThe most interesting ones to implement will be the remove() methods as they may require removing \nmultiple duplicates from the source list.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("I have added write support to UniqueList.\n\nThere is an interesting problem posed by supporting writing in UniqueList, as well as writing in other \ncode already implemented via bug 44.\n\nMethods such as clear() on a filter list may call several remove() methods on the underlying source list. \nThese remove() methods fire the event listeners and other lists receive notification for each of many \nremoves within a clear. Such listeners will likely read from their source list to respond to the change, \nand it is possible that this source list is still in the process of changing due to the clear() method. \nTherefore:\n - such methods that call multiple changing methods on their source list must be in a consistent state \nfor each such method call\n - such methods must be implemented in a way that safely handles receiving a change event after each \nsource list modification.\n\nThese multiple source method calling lists are troublesome and it may be worthwhile to find a way to \nbundle a set of methods to invoke on a source list as a group. This is a sophisticated problem and will \nrequire some research. For the time being, guaranteeing consistency and event safety should be \nsufficient.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("This bug has been fixed for two weeks with no problems. I am marking it closed.");
        currentIssue.getDescriptions().add(description);
        description = null;
        issues.add(currentIssue);
        currentIssue = null;
        currentIssue = new Issue();
        currentIssue.setId(new Integer(46));
        currentIssue.setStatus("CLOSED");
        currentIssue.setPriority(Priority.P4);
        currentIssue.setResolution("FIXED");
        currentIssue.setComponent("glazedlists");
        currentIssue.setVersion("current");
        currentIssue.setAssignedTo("issues@glazedlists");
        currentIssue.setSubcomponent("www");
        currentIssue.setIssueType("DEFECT");
        currentIssue.setQAContact("issues@glazedlists");
        currentIssue.setShortDescription("UniqueList, FilterList fire multiple events for some operations");
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("UniqueList.clear(), FilterList.clear(), SubList.clear() all can fire multiple ListEvents when only a single \noperation is performed upon them.\n\nThis can be fixed by causing such lists to not propogate changes until they are all done.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("These lists now only fire one event for the said operations. A new test class\nhas also been added to verify this behaviour.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("This bug has been fixed for two weeks with no problems. I am marking it closed.");
        currentIssue.getDescriptions().add(description);
        description = null;
        issues.add(currentIssue);
        currentIssue = null;
        currentIssue = new Issue();
        currentIssue.setId(new Integer(47));
        currentIssue.setStatus("STARTED");
        currentIssue.setPriority(Priority.P5);
        currentIssue.setResolution("");
        currentIssue.setComponent("glazedlists");
        currentIssue.setVersion("current");
        currentIssue.setAssignedTo("kevinmaltby");
        currentIssue.setSubcomponent("www");
        currentIssue.setIssueType("ENHANCEMENT");
        currentIssue.setQAContact("issues@glazedlists");
        currentIssue.setShortDescription("Threshhold List");
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("Suppose we have a list of Objects, each of which has a date created.\n\nIt should be possible to create a filter that filters for where the date created is less than or greater than \na specified threshhold. This should be possible for any criteria that can take a range of values - in \neffect anything that is Comparable.\n\nCurrently this is possible using the AbstractFilterList, but it is not 'smart' enough to know how \nadjustments in the criteria require only a subset of the values to be readjusted. A clever implementation \nof this would use a sorted set, and binary search to find the seperator between those that meet the \ncriteria and those that do not.\n\nI was thinking a \"Date Slider\" Swing widget would be a good prototype of this!");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("This non-critical issue is being marked low-priority until Glazed Lists 1.0 has\nbeen released.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("kevinmaltby");
        description.setWhen(null);
        description.setText("assigned issue to myself");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("kevinmaltby");
        description.setWhen(null);
        description.setText("I've hammered out some code towards the creation of this list that is yet to be \nin cvs, but hopefully by the end of the month this list should be available to \nthe world.  My initial implementaion followed the design of UniqueList which \nprovides explicit sorting by wrapping a SortedList.\n\nHowever, during construction it occurred to me that the explicit sorting might \nnot be desirable.  My second implementation sorts the list internally to keeps \ncalls to setThreshold() super fast, but does not enforce a particular sort \norder.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("kevinmaltby");
        description.setWhen(null);
        description.setText("Well after roughly a month out of town, and 4 different versions of the code \nfor this feature, ThresholdList is nearing public release.\n\nWhile keeping the underlying sort order might offer some business value to this \ntransformation, doing so comes with a significant performance penalty.  As \nsuch, I have returned to the earlier requirement for this transformation to \nexplicitly sort the list.  The sorting is performed internally for performance \nreasons over simply wrapping a SortedList as UniqueList does.\n\nCurrently I am working to clean up the implementation a bit after having Jesse \ncode-review my classes.  With any luck this code should be available within 2 \nweeks at the latest.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("Kevin's code was 1000x better today than two weeks ago. He's modest, but today's code is really good.\n\nWe have added 3 public classes to the codebase:\n   - ThresholdEvaluator interface gets an int from a given Object\n   - ThresholdList, sorts and limits a list by a ThresholdEvaluator value\n   - ThresholdRangeModelFactory - creates range models for use in a Slider\n\nThis stuff also lends itself to use with ComboBoxes and such!\n\nTo Do:\n - test the heck out of it\n - add Kev's tutorial page to website, revise tutorial\n - integrate into demo\n\nWe're almost done!");
        currentIssue.getDescriptions().add(description);
        description = null;
        issues.add(currentIssue);
        currentIssue = null;
        currentIssue = new Issue();
        currentIssue.setId(new Integer(48));
        currentIssue.setStatus("CLOSED");
        currentIssue.setPriority(Priority.P3);
        currentIssue.setResolution("FIXED");
        currentIssue.setComponent("glazedlists");
        currentIssue.setVersion("current");
        currentIssue.setAssignedTo("issues@glazedlists");
        currentIssue.setSubcomponent("www");
        currentIssue.setIssueType("DEFECT");
        currentIssue.setQAContact("issues@glazedlists");
        currentIssue.setShortDescription("Migrationkit's DynamicQueryList fails to forward events");
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("The Migrationkit's DynamicQueryList class is not forwarding events.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("This bug has already been fixed.\n\nThe fix is NOT in the Glazed Lists 0.9 release, but it will be in the next Glazed Lists release. The fix is \nalso available via CVS.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("This bug has been fixed for two weeks with no problems. I am marking it closed.");
        currentIssue.getDescriptions().add(description);
        description = null;
        issues.add(currentIssue);
        currentIssue = null;
        currentIssue = new Issue();
        currentIssue.setId(new Integer(49));
        currentIssue.setStatus("CLOSED");
        currentIssue.setPriority(Priority.P3);
        currentIssue.setResolution("FIXED");
        currentIssue.setComponent("glazedlists");
        currentIssue.setVersion("current");
        currentIssue.setAssignedTo("issues@glazedlists");
        currentIssue.setSubcomponent("www");
        currentIssue.setIssueType("TASK");
        currentIssue.setQAContact("issues@glazedlists");
        currentIssue.setShortDescription("Tutorial v. 0.9");
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("Glazed Lists needs a new tutorial. It would be great if this tutorial involved a newer, more exciting and \nmore powerful demo app.\n\nMy current two ideas are:\n - a bugzilla XML browser\n - a Pop3 client\n\nSuch involve lots of lists and could take good advantage of Glazed Lists' ability to transform lists.\n\nThe demo should involve:\n - Multiple-criterea sorting\n - Text Filtering & Custom Filtering\n - UniqueList, UniqueList on a derived list\n - Transformed List\n - JTable, JComboBox & JList\n\nThe demo should not rely on third-party libraries or tools for simplicity.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("progress on this is going very well! I already have a preview of the tutorial\nonline, and a few more steps and it will be done.\n\nTodo: \n1. Concurrency\n2. CompositeList (?)\n3. Performance");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("I've added Concurrency. \n\nThis tutorial needs to be revamped and sexed up, but I don't feel like doing it! I wonder if we can \nconvince one of our users to do it! ha ha ha.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("This bug has been fixed for two weeks with no problems. I am marking it closed.");
        currentIssue.getDescriptions().add(description);
        description = null;
        issues.add(currentIssue);
        currentIssue = null;
        currentIssue = new Issue();
        currentIssue.setId(new Integer(50));
        currentIssue.setStatus("STARTED");
        currentIssue.setPriority(Priority.P5);
        currentIssue.setResolution("");
        currentIssue.setComponent("glazedlists");
        currentIssue.setVersion("current");
        currentIssue.setAssignedTo("issues@glazedlists");
        currentIssue.setSubcomponent("www");
        currentIssue.setIssueType("ENHANCEMENT");
        currentIssue.setQAContact("issues@glazedlists");
        currentIssue.setShortDescription("SWT Support");
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("Glazed Lists does not support SWT. This toolkit is growing in importance and Glazed Lists is well suited \nfor this platform.\n\nSome things to consider:\n - I need an SWT 'expert', either by becoming one or by finding a volunteer\n - SWT compilation into the .jar file must be conditional. SWT support should be in source-form only \nand compiled only if SWT classes are available on the user's class path.\n - From my initial research, SWT is not as model-driven as Swing. Although this does not pose a \nproblem it may require a change in approach\n - We need to choose an SWT version to support. 3.0 is coming out soon but I have no idea what the \nactual SWT users in the field are using.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("This non-critical issue is being marked low-priority until Glazed Lists 1.0 has\nbeen released.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("I've added some SWT support to Glazed Lists!\n\nI ported the following classes from Swing to SWT:\n    * EventTableModel (now EventTableViewer)\n    * TableFormat\n    * TextFilterList\n\nYet I still have some issues to resolve:\n    * concurrency support in EventTableViewer\n    * hitting ENTER in the TextFilterList\n    * EventTableViewer handling column widths\n    * EventTableViewer handling column alignment\n    * EventTableViewer handling Images as cell contents\n    * EventTableViewer sorting via clicking on the table's header\n\nSo I have my work cut out for me. SWT is not that tricky to hack on, but it is kind of a pain to get up \nand running.\n");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("Today I added support for EventTableViewer keeping the Selection between ListChanges. The \nimplemented algorithm is simple and reliable but slow. It will be desirable to speed this up to support \nreally big tables!\n\nSWT is becoming a high priority at O'Dell Engineering so I think this bug will receive some well deserved \nattention.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("Today I added some support for SWT's checked tables.\n\nThe classes are \"Checkable\" and \"TableCheckFilterList\". There are some limitations, however.\n* TableCheckFilterList inspects the table's check items so there may not be any TransformationLists \nbetween the TableCheckFilterList and the EventTableViewer.\n* Checkable objects may not be shared between tables.\n\nIf I can think of work-arounds or fixes for these limitations, I'll post another update.\n");
        currentIssue.getDescriptions().add(description);
        description = null;
        issues.add(currentIssue);
        currentIssue = null;
        currentIssue = new Issue();
        currentIssue.setId(new Integer(51));
        currentIssue.setStatus("STARTED");
        currentIssue.setPriority(Priority.P3);
        currentIssue.setResolution("");
        currentIssue.setComponent("glazedlists");
        currentIssue.setVersion("current");
        currentIssue.setAssignedTo("issues@glazedlists");
        currentIssue.setSubcomponent("www");
        currentIssue.setIssueType("TASK");
        currentIssue.setQAContact("issues@glazedlists");
        currentIssue.setShortDescription("Implement Chunk Transfer Protocol client & servers");
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("We have hacked out a basic plan for the initial network protocol for Glazed Lists.\n\nWe are going to use a layered protocol to isolate concerns:\n - \"Chunk Transfer Protocol\" is our base protocol. This is a simplification of HTTP/1.1 with chunked \nencoding. We would like Glazed Lists to work through HTTP proxies and HTTP-aware firewalls so this \nprotocol shall be a subset of HTTP/1.1.\n - \"Update Subscription Protocol\" is an update-push protocol that sits on top of CTP and adds some \napplication-specific features. This will initially consist of update sequencing. Eventual features for this \nare digitally signed updates, peer-to-peer support and NAT evasion.\n - Glazed Lists on the network will specify an encoding for list updates that can be transferred via USP. \n\nAll encodings must have the following properties:\n - well documented to allow for alternative implementations\n - extendible without breaking clients using previous versions\n - language and platform neutral\n - simple!\n\nAll that said, we need to implement the first step, Chunk Transfer Protocol. Here are the interfaces for \nthe initial version of CTP:\n\nCTPServerProtocol\nvoid sendResponse(int code, Map headers) throws CTPException;\nvoid sendChunk(byte[] data) throws CTPException;\nvoid close();\nCTPServerHandler\nvoid receiveGet(CTPServerProtocol source, String uri, Map headers);\nvoid connectionClosed(CTPServerProtocol source, Exception reason);\n\nCTPClientProtocol\nvoid sendGet(String uri, Map headers) throws CTPException;\nvoid close();\nCTPClientHandler\nvoid receiveResponse(CTPClientProtocol source, int code, Map headers);\nvoid receiveChunk(CTPClientProtocol source, byte[] data);\nvoid connectionClosed(CTPClientProtocol source, Exception reason);\n\nIt should be straightforward to create a simple implementation that uses sockets. This design should \nalso hopefully be extendable for use with Java's buffered IO, java.nio.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("About 90% of ChunkedTransferProtocol is implemented.\n\nLeft to do:\n - Buffer sizing, including setting the initial size & max size\n - Handling method calls from other threads\n - Listen port selection\n - Stop() method\n\nMy ChunkedTransferProtocol implementation has the following notes:\n - it starts its own thread that does all the networking via NIO\n - it uses a subset of HTTP that should slip nicely through proxy servers\n - it handles the case where the proxy removes chunking (although no Content-Length)\n - Server and client share the same connection class\n\nHaving come this far, I will leave the remaining four tasks until I have built more of USP on top of CTP. \nUSP is \"Update Subscription Protocol\", I will be creating an issue for tracking its development.");
        currentIssue.getDescriptions().add(description);
        description = null;
        issues.add(currentIssue);
        currentIssue = null;
        currentIssue = new Issue();
        currentIssue.setId(new Integer(52));
        currentIssue.setStatus("CLOSED");
        currentIssue.setPriority(Priority.P3);
        currentIssue.setResolution("FIXED");
        currentIssue.setComponent("glazedlists");
        currentIssue.setVersion("current");
        currentIssue.setAssignedTo("issues@glazedlists");
        currentIssue.setSubcomponent("www");
        currentIssue.setIssueType("DEFECT");
        currentIssue.setQAContact("issues@glazedlists");
        currentIssue.setShortDescription("Support 'nested' change events");
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("Adding support for nested change events may simplify the code and may even make it more powerful.\n\nCurrently, some classes such as TransformationList implement clear(), removeAll() etc. as a series of \nremove() calls. This fires a series of events when only one event should be fired.\n\nThe solution is to create 'nested' change events such as\nbeginNestedChange()\ncommitNestedChange()\n\nwhich can contain within it many calls to beginChange() / commitChange(), where such commits do not \nactually send the events.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("I've added support for nested changes.\n\nThe new method is:\nbeginEvent(true), which means \"Begin an event with support for nested changes\"\nas an alternative to \"beginEvent(false) and beginEvent(), which mean \"Begin an\nevent that throws an exception when creating a nested change\".\n\nThis is already in use by clear(), removeAll() and retainAll() in\nTransformationList and replaceAll() in UniqueList. If implementing this in your\ncode, remember that Iterators behaviour will change if they stop receiving\nchange event notification.\n");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("This bug has been fixed for two weeks with no problems. I am marking it closed.");
        currentIssue.getDescriptions().add(description);
        description = null;
        issues.add(currentIssue);
        currentIssue = null;
        currentIssue = new Issue();
        currentIssue.setId(new Integer(53));
        currentIssue.setStatus("CLOSED");
        currentIssue.setPriority(Priority.P3);
        currentIssue.setResolution("FIXED");
        currentIssue.setComponent("glazedlists");
        currentIssue.setVersion("current");
        currentIssue.setAssignedTo("issues@glazedlists");
        currentIssue.setSubcomponent("www");
        currentIssue.setIssueType("DEFECT");
        currentIssue.setQAContact("issues@glazedlists");
        currentIssue.setShortDescription("Protected constructors on final classes");
        description = new Description();
        description.setWho("kevinmaltby");
        description.setWhen(null);
        description.setText("Both ReadOnlyList and ThreadSafeList have protected constructors.  This is most \nlikely in error, particularly because both classes are final.  These should be \nmade public (I would do it but my CVS still doesn't want to work at my new \nplace).");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("This was an easy fix. We have to get Kevin some CVS access!");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("This bug has been fixed for two weeks with no problems. I am marking it closed.");
        currentIssue.getDescriptions().add(description);
        description = null;
        issues.add(currentIssue);
        currentIssue = null;
        currentIssue = new Issue();
        currentIssue.setId(new Integer(54));
        currentIssue.setStatus("CLOSED");
        currentIssue.setPriority(Priority.P2);
        currentIssue.setResolution("FIXED");
        currentIssue.setComponent("glazedlists");
        currentIssue.setVersion("current");
        currentIssue.setAssignedTo("issues@glazedlists");
        currentIssue.setSubcomponent("www");
        currentIssue.setIssueType("DEFECT");
        currentIssue.setQAContact("issues@glazedlists");
        currentIssue.setShortDescription("EventSelectionModel does not support concurrency");
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("In implementing EventSelectionModel we made some incorrect assumptions about\nmultithreading. The problem is that although the accessing thead will usually be\nthe event dispatch thread, we must be able to read the model while another\nthread is modifying the source list.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("I have added concurrency support with an Internal lock.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("This bug has been fixed for two weeks with no problems. I am marking it closed.");
        currentIssue.getDescriptions().add(description);
        description = null;
        issues.add(currentIssue);
        currentIssue = null;
        currentIssue = new Issue();
        currentIssue.setId(new Integer(55));
        currentIssue.setStatus("CLOSED");
        currentIssue.setPriority(Priority.P3);
        currentIssue.setResolution("FIXED");
        currentIssue.setComponent("glazedlists");
        currentIssue.setVersion("current");
        currentIssue.setAssignedTo("issues@glazedlists");
        currentIssue.setSubcomponent("www");
        currentIssue.setIssueType("DEFECT");
        currentIssue.setQAContact("issues@glazedlists");
        currentIssue.setShortDescription("UniqueList events delete indicies that do not exist");
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("I ran into a problem when coupling EventSelectionModel\nand UniqueList, so I decided to enhance the ConsistencyTestList\nto verify that UniqueList is well behaved.\n\nFrom my tests, the UniqueList can sometimes delete indicies\nthat have not yet been created! For example, on a list of\nsize 5, it might delete at 6 and later on insert at 6 to\nretain size consistency.\n\nI am going to dive into the UniqueList code to attempt to\nfind the problem. Hopefully it is either a mis-reported\nproblem or an easy fix!\n\nTo reproduce, add the following line to the end of the\nUniqueList constructor, and run the JUnit tests.\n addListEventListener(new ca.odell.glazedlists.test.ConsistencyTestList(this,\n\"unique\"));\n\nThe (first of many) exception I received was:\n\n    [junit] java.lang.Exception: unique/1 cannot delete at 2, size is: 2\n    [junit] 	at\nca.odell.glazedlists.test.ConsistencyTestList.listChanged(ConsistencyTestList.java:63)\n    [junit] 	at\nca.odell.glazedlists.event.ListEventAssembler.fireEvent(ListEventAssembler.java:248)\n    [junit] 	at\nca.odell.glazedlists.event.ListEventAssembler.commitEvent(ListEventAssembler.java:221)\n    [junit] 	at ca.odell.glazedlists.UniqueList.listChanged(UniqueList.java:152)\n    [junit] 	at\nca.odell.glazedlists.event.ListEventAssembler.fireEvent(ListEventAssembler.java:248)\n    [junit] 	at\nca.odell.glazedlists.event.ListEventAssembler.commitEvent(ListEventAssembler.java:221)\n    [junit] 	at ca.odell.glazedlists.SortedList.listChanged(SortedList.java:174)\n    [junit] 	at\nca.odell.glazedlists.event.ListEventAssembler.fireEvent(ListEventAssembler.java:248)\n    [junit] 	at\nca.odell.glazedlists.event.ListEventAssembler.commitEvent(ListEventAssembler.java:221)\n    [junit] 	at\nca.odell.glazedlists.AbstractFilterList.handleFilterChanged(AbstractFilterList.java:196)\n    [junit] 	at\nca.odell.glazedlists.test.IntArrayFilterList.setFilter(IntArrayFilterList.java:33)\n    [junit] 	at\nca.odell.glazedlists.test.UniqueListTest.testUpdateDeleteCollide(UniqueListTest.java:514)\n    [junit] 	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\n    [junit] 	at\nsun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:39)\n    [junit] 	at\nsun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:25)\n    [junit] 	at java.lang.reflect.Method.invoke(Method.java:582)\n    [junit] 	at junit.framework.TestCase.runTest(TestCase.java:154)\n    [junit] 	at junit.framework.TestCase.runBare(TestCase.java:127)\n    [junit] 	at junit.framework.TestResult$1.protect(TestResult.java:106)\n    [junit] 	at junit.framework.TestResult.runProtected(TestResult.java:124)\n    [junit] 	at junit.framework.TestResult.run(TestResult.java:109)\n    [junit] 	at junit.framework.TestCase.run(TestCase.java:118)\n    [junit] 	at junit.framework.TestSuite.runTest(TestSuite.java:208)\n    [junit] 	at junit.framework.TestSuite.run(TestSuite.java:203)\n    [junit] 	at\norg.apache.tools.ant.taskdefs.optional.junit.JUnitTestRunner.run(JUnitTestRunner.java:325)\n    [junit] 	at\norg.apache.tools.ant.taskdefs.optional.junit.JUnitTestRunner.main(JUnitTestRunner.java:524)");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("I have found the cause of this problem!\n\nThe problem is that UniqueList uses \"delayed inserts\". This means it does not\nadd into to the event list any insert events until all delete and update events\nhave been inserted.\n\nThe problem is that the delete indicies are all offset the insert indicies, and\nthe insert indicies are missing.\n\nHere is a simple example.\nI have a list \"A B\" that I change to \"C\".\n\nThe change event should be \"delete 0-1, insert 0\"\n\nBefore re-ordering, it is currently \"delete 1-2, insert 0\", which is wrong and\nillegal.\n\nThe solution is to keep an offset index that increments with every index, and\nthis value is subtracted from every delete.\n\nNow, all's left is implementation!");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("fixed! I would like Kevin to look over my fix to verify that I did the right thing!\n\nPerhaps we could add some more tests to verify that this kind of thing doesn't\nhappen again!");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("This bug has been fixed for two weeks with no problems. I am marking it closed.");
        currentIssue.getDescriptions().add(description);
        description = null;
        issues.add(currentIssue);
        currentIssue = null;
        currentIssue = new Issue();
        currentIssue.setId(new Integer(56));
        currentIssue.setStatus("CLOSED");
        currentIssue.setPriority(Priority.P2);
        currentIssue.setResolution("FIXED");
        currentIssue.setComponent("glazedlists");
        currentIssue.setVersion("current");
        currentIssue.setAssignedTo("issues@glazedlists");
        currentIssue.setSubcomponent("www");
        currentIssue.setIssueType("DEFECT");
        currentIssue.setQAContact("issues@glazedlists");
        currentIssue.setShortDescription("UniqueList replaceAll() can clear selection");
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("The replaceAll() method should use UPDATE events whenever possible.\nCurrently it forwards DELETE/INSERT events that can clear selection.\n\nIn order for UniqueList to completely replace query lists, this functionality is\nabsolutely mandatory.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("After a bunch of thinking I have come to the conclusion that this solution can\nbe implemented without compromising the rest of Glazed Lists.\n\nHere is my idea:\nAdd an extra property to each change event called \"is reorder\". Such events will\nalways contain remove all and insert all events so that they can be processed as\nthey are currently by regular lists. But lists that are reorder-aware can view\nthe reorder property and get an array of reorder indicies. \n\nHaving reorder supported in lists like filter list will improve performance!\nSuppose a sorted list is filtered. Then if that list is resorted, each element\nis currently tested to see if it shall still be filtered. But if the filter list\nsupports reordering, it can use the reorder and not need to refilter.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("Whoops! My bad. \n\nThe previous comment is supposed to be on Issue 39.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("From my analysis, this problem may require changing the way the UniqueList\nlistChanged() method is handled. I think that a 2-pass algorithm may remove all\nthe events that are currently not optimized.\n\nPass 1: Update the duplicatesList by inserting a non-duplicate for every\ninserted and updated value, remove all deleted values. Create a working array\ncontaining the previous values for each updated index: either DUPLICATE or\nNON-DUPLICATE\n\nPass 2: Iterate simultaneously through the update event and the previous value\narray. For each index, determine if it is now a DUPLICATE or NON-DUPLICATE and\ncompare that to the previous value. Forward events as necessary.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("As a consequence of much thought on Friday afternoon, this bug is very fixed and \nthe solution is awesome. Much thanks to Kevin for being my brain-storming buddy \non this solution.\n\nHorray!");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("This bug has been fixed for two weeks with no problems. I am marking it closed.");
        currentIssue.getDescriptions().add(description);
        description = null;
        issues.add(currentIssue);
        currentIssue = null;
        currentIssue = new Issue();
        currentIssue.setId(new Integer(57));
        currentIssue.setStatus("NEW");
        currentIssue.setPriority(Priority.P3);
        currentIssue.setResolution("");
        currentIssue.setComponent("glazedlists");
        currentIssue.setVersion("current");
        currentIssue.setAssignedTo("issues@glazedlists");
        currentIssue.setSubcomponent("www");
        currentIssue.setIssueType("TASK");
        currentIssue.setQAContact("issues@glazedlists");
        currentIssue.setShortDescription("Glazed Lists version 1.0 release");
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("This issue depends upon all issues to be resolved for the 1.0 release.\n\nGlazed Lists 1.0 is the production-quality and feature-complete release of\nGlazed Lists. There are many issues that must be resolved for this release.\n\n - UniqueList replaceAll() can clear selection\n - CompositeList not thread-safe\n - Glazed lists on the network\n - Tutorial v. 0.9\n\nSome issues would also be 'nice-to-have' for 1.0. In particular:\n - Sorting clears selection (this may require a work-around implementation)\n\nAs of June 25 I am marking all non-1.0 issues as lowest priority. Such issues\nmay be removed at a later date if it is determined that they shall not be\nimplemented.");
        currentIssue.getDescriptions().add(description);
        description = null;
        issues.add(currentIssue);
        currentIssue = null;
        currentIssue = new Issue();
        currentIssue.setId(new Integer(58));
        currentIssue.setStatus("CLOSED");
        currentIssue.setPriority(Priority.P3);
        currentIssue.setResolution("FIXED");
        currentIssue.setComponent("glazedlists");
        currentIssue.setVersion("current");
        currentIssue.setAssignedTo("issues@glazedlists");
        currentIssue.setSubcomponent("www");
        currentIssue.setIssueType("ENHANCEMENT");
        currentIssue.setQAContact("issues@glazedlists");
        currentIssue.setShortDescription("UniqueList and SortedList not optimized for contains and containsAll methods");
        description = new Description();
        description.setWho("kevinmaltby");
        description.setWhen(null);
        description.setText("Current implementations of both SortedList and UniqueList do not take advantage \nof optimizations available since the lists are in sorted order.  Namely, the \ncontains and containsAll methods could boast significant performance \nimprovements if they are optimized.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("kevinmaltby");
        description.setWhen(null);
        description.setText("Adding this optimization to SortedList is simple.  Overload contains with a one \nline method which returns true iff sorted.getNode returns non-null.  For \ncontainsAll, simply iterate through the collection and call contains for each \nelement.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("kevinmaltby");
        description.setWhen(null);
        description.setText("The enhancement for UniqueList must be a little more complex.  For a simple and \nreasonably fast implementation, the underlying SortedList's contains and \ncontainsAll methods could be called.  However, this produces very odd and \ncounter-intuitive best and worst cases.  The best case is to have no duplicates \nin the UniqueList, since no duplicates would be repeatedly compared.  This \nimplementation would yield a worst case of having n identical items in the \nUniqueList, or just one element in the compressed view.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("kevinmaltby");
        description.setWhen(null);
        description.setText("However, these best and worst cases SHOULD be the exact opposite for a \nUniqueList.  The above worst case SHOULD require only a single comparison for a \ncall to contains and SHOULD be the best case for searching a UniqueList.  \nLikewise, the above best case should be the worst case as it would be the \nlargest possible set to search on.\n\nDue to the fact that the SparseList ADT isn't inherently a sorted set, further \noptimization is a little more tricky.  I'm trying to come up with a good way to \ntake advantage of searching only the unique view.  Any clever ideas?");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("Implementation of this should simply use the public API method \"get(index)\" and\na binary search.\n\nThe following methods should also be implemented:\n  indexOf()\n  lastIndexOf()\n");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("Fixed! Kevin added binary search methods to both these classes. 50% faster*.\n\n\n*based on 1 test.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("This bug has been fixed for two weeks with no problems. I am marking it closed.");
        currentIssue.getDescriptions().add(description);
        description = null;
        issues.add(currentIssue);
        currentIssue = null;
        currentIssue = new Issue();
        currentIssue.setId(new Integer(59));
        currentIssue.setStatus("CLOSED");
        currentIssue.setPriority(Priority.P3);
        currentIssue.setResolution("WORKSFORME");
        currentIssue.setComponent("glazedlists");
        currentIssue.setVersion("current");
        currentIssue.setAssignedTo("issues@glazedlists");
        currentIssue.setSubcomponent("www");
        currentIssue.setIssueType("DEFECT");
        currentIssue.setQAContact("issues@glazedlists");
        currentIssue.setShortDescription("read-only access is broken once a ReadOnlyList is decorated by a writable list.");
        description = new Description();
        description.setWho("kevinmaltby");
        description.setWhen(null);
        description.setText("The error is not to be found in ReadOnlyList but as a consequence of layering \nwith ReadOnlyList.\n\nConsider the following:\n\nA BasicEventList containing aribitrary data.\n\nA ReadOnlyList wrapping that data to prevent changes.\n\nA SortedList wrapping the ReadOnlyList to provide a sorted view of that read-\nonly data.\n\nThis will scenario will allow a write operation on the SortedList.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("kevinmaltby");
        description.setWhen(null);
        description.setText("This problem cannot be replicated with a fresh checkout of the source.  I \nimagine my local copy of ReadOnlyList was out of sync due to some testing and \namidst my recent CVS troubles I had forgotten about the change.  This issue \nshould be closed.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("This bug has been fixed for two weeks with no problems. I am marking it closed.");
        currentIssue.getDescriptions().add(description);
        description = null;
        issues.add(currentIssue);
        currentIssue = null;
        currentIssue = new Issue();
        currentIssue.setId(new Integer(60));
        currentIssue.setStatus("CLOSED");
        currentIssue.setPriority(Priority.P3);
        currentIssue.setResolution("FIXED");
        currentIssue.setComponent("glazedlists");
        currentIssue.setVersion("current");
        currentIssue.setAssignedTo("issues@glazedlists");
        currentIssue.setSubcomponent("www");
        currentIssue.setIssueType("DEFECT");
        currentIssue.setQAContact("issues@glazedlists");
        currentIssue.setShortDescription("SortedList fires insert & delete instead of updates");
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("When updating a range of values in a sorted list, the sorted list sends a \nsequence of delete and insert events instead of update evetns, even if the order \ndoes not change.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("I am very close to having a complete solution to this.\n\nThe current potential problems - \n   - multiple updates co-existing with non-updated indices\n   - updates with multiple copies of the same source value\n   - high-performance (the current implementation has some O(n^2) methods)\n\nBut the solution is good and it seems to work. Oh boy!");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("Upon further research, some discoveries:\n - multiple copies of the same value breaks because of the non-deterministic insert order in \nIndexedTree. I will try to fix this.\n");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("The \"non-deterministic\" insert order from before is a lie - it is actually just \"insert at head\" instead of \nthe preferred \"insert at tail\". This has been changed and now SortedList works with multiple values \nquite well!\n");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("This fix for this issue was very involved and required the addition of two helper classes to SortedList, \nIndicesPendingDeletion, a wrapper around a TreeSet, and IndexNodePair, a union of a node and the \nindex from which it came.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("This bug has been fixed for two weeks with no problems. I am marking it closed.");
        currentIssue.getDescriptions().add(description);
        description = null;
        issues.add(currentIssue);
        currentIssue = null;
        currentIssue = new Issue();
        currentIssue.setId(new Integer(61));
        currentIssue.setStatus("CLOSED");
        currentIssue.setPriority(Priority.P5);
        currentIssue.setResolution("FIXED");
        currentIssue.setComponent("glazedlists");
        currentIssue.setVersion("current");
        currentIssue.setAssignedTo("issues@glazedlists");
        currentIssue.setSubcomponent("www");
        currentIssue.setIssueType("ENHANCEMENT");
        currentIssue.setQAContact("issues@glazedlists");
        currentIssue.setShortDescription("SetEnabled(boolean) on EventSelectionModel");
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("It would be great if we could disable changing of the table selection via a\nsetEnabled() method on EventSelectionModel.\n\nI'm not 100% sure this will work well with JTable & JList, but if possible, it\nwould make for a great addition to the JTable's existing functionality.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("EventSelectionModel.setEnabled(false) will now prevent the user from changing the selection.\n\nThe selection can still be changed however. If the list changes, the selection may change. For example, \nif a selected item is deleted, it will no longer be selected!");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("This bug has been fixed for two weeks with no problems. I am marking it closed.");
        currentIssue.getDescriptions().add(description);
        description = null;
        issues.add(currentIssue);
        currentIssue = null;
        currentIssue = new Issue();
        currentIssue.setId(new Integer(62));
        currentIssue.setStatus("CLOSED");
        currentIssue.setPriority(Priority.P4);
        currentIssue.setResolution("FIXED");
        currentIssue.setComponent("glazedlists");
        currentIssue.setVersion("current");
        currentIssue.setAssignedTo("issues@glazedlists");
        currentIssue.setSubcomponent("www");
        currentIssue.setIssueType("ENHANCEMENT");
        currentIssue.setQAContact("issues@glazedlists");
        currentIssue.setShortDescription("SortedList indexOf() etc. make multiple tree calls");
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("The current implementation of SortedList has a faster version of the methods indexOf, lastIndexOf and \ncontains. These methods perform binary searches of the list using the sorted ordering. These \noperations make O(log n) tree calls, each of which as an O(log n) cost. Total cost is O(log n * log n). For \nexample, on a tree of size 1000, this cost is O(100).\n\nThese methods can be made faster by using calls on the sorted tree. Such an implementation will have \na total cost of O(log n). For example, on a tree of size 1000, this cost is O(10).\n\nThe IndexedTree classes may need to be modified for new indexOf methods.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("Revised priority, etc. of bug which were wrong.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("Kevin implemented the fix, I am merely the reporter. Here is what Kevin had to say:\n\n\nSortedList Changes:\n\n- Fixed flawed comment for lastIndexOf()\n- Changed indexOf(), lastIndexOf(), and contains() so that they now call\n  the corresponding method on the sorted tree to cut the cost down to\n  one tree call from SortedList giving O(log(n)) runtime.\n- Removed now redundant binary search methods\n- Improved the IndexedTreeNodeComparator inner class to compare both\n  standard Objects and IndexedTreeNodes to make this bug fix possible\n  \nSortedListTest Changes:\n- Added an additional test to each of the indexOf() lastIndexOf() and contains()\n  testcases to test on an empty list.\n  \nIndexedTree Changes:\n\n- Added support for indexOf(), lastIndexOf() and contains()\n    \nIndexedTreeNode Changes:\n- Implemented support for each of the new methods on the IndexedTree interface.\n\n");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("This bug has been fixed for two weeks with no problems. I am marking it closed.");
        currentIssue.getDescriptions().add(description);
        description = null;
        issues.add(currentIssue);
        currentIssue = null;
        currentIssue = new Issue();
        currentIssue.setId(new Integer(63));
        currentIssue.setStatus("CLOSED");
        currentIssue.setPriority(Priority.P5);
        currentIssue.setResolution("FIXED");
        currentIssue.setComponent("glazedlists");
        currentIssue.setVersion("current");
        currentIssue.setAssignedTo("issues@glazedlists");
        currentIssue.setSubcomponent("www");
        currentIssue.setIssueType("DEFECT");
        currentIssue.setQAContact("issues@glazedlists");
        currentIssue.setShortDescription("EventLists don't get garbage collected unless source list is garbage collected..");
        description = new Description();
        description.setWho("kevinmaltby");
        description.setWhen(null);
        description.setText("With the current system, once an EventList is created it lives until the app \nterminates, or the source list is garbage collected.  EventLists need to have \ndefined lifecycle methods, such as dispose() for example, to allow them to be \npicked up by gc() when you no longer need them.\n\nFor most applications the EventLists used to transform a source list will live \nfor the entire lifespan of the source list.  However, it is concievable that an \napplication might destroy and create lists on a particular source over time and \nthose should be garbage collected when possible.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("kevinmaltby");
        description.setWhen(null);
        description.setText("changed priority.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("I've added a dispose() method to TransformedList.\n\nThe UniqueList overrides this method to manually dispose the SortedList, other chained lists should do \nthis too!");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("This bug has been fixed for two weeks with no problems. I am marking it closed.");
        currentIssue.getDescriptions().add(description);
        description = null;
        issues.add(currentIssue);
        currentIssue = null;
        currentIssue = new Issue();
        currentIssue.setId(new Integer(64));
        currentIssue.setStatus("CLOSED");
        currentIssue.setPriority(Priority.P3);
        currentIssue.setResolution("WORKSFORME");
        currentIssue.setComponent("glazedlists");
        currentIssue.setVersion("current");
        currentIssue.setAssignedTo("issues@glazedlists");
        currentIssue.setSubcomponent("www");
        currentIssue.setIssueType("DEFECT");
        currentIssue.setQAContact("issues@glazedlists");
        currentIssue.setShortDescription("Multithreading problem in demo app & tutorial part 6.");
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("I get the following exception, I am assuming it is due to the issues being loaded before the GUI is \ncompletely constructed.\n\njava.lang.NullPointerException\n        at IssuesUserFilter.filterMatches(IssuesUserFilter.java:74)\n        at ca.odell.glazedlists.AbstractFilterList.listChanged(AbstractFilterList.java:138)\n        at ca.odell.glazedlists.event.ListEventAssembler.fireEvent(ListEventAssembler.java:289)\n        at ca.odell.glazedlists.event.ListEventAssembler.commitEvent(ListEventAssembler.java:256)\n        at IssuesList.listChanged(IssuesList.java:82)\n        at ca.odell.glazedlists.event.ListEventAssembler.fireEvent(ListEventAssembler.java:289)\n        at ca.odell.glazedlists.event.ListEventAssembler.commitEvent(ListEventAssembler.java:256)\n        at ca.odell.glazedlists.UniqueList.replaceAll(UniqueList.java:514)\n        at IssuesList$IssuesRefreshTask.run(IssuesList.java:67)\n        at java.util.TimerThread.mainLoop(Timer.java:432)\n        at java.util.TimerThread.run(Timer.java:382)\nException in thread \"main\" java.util.ConcurrentModificationException: Cannot begin a new event while \nanother event is in progress\n        at ca.odell.glazedlists.event.ListEventAssembler.beginEvent(ListEventAssembler.java:94)\n        at ca.odell.glazedlists.event.ListEventAssembler.beginEvent(ListEventAssembler.java:72)\n        at ca.odell.glazedlists.AbstractFilterList.handleFilterChanged(AbstractFilterList.java:199)\n        at IssuesUserFilter.<init>(IssuesUserFilter.java:52)\n        at IssuesBrowser.display(IssuesBrowser.java:43)\n        at IssuesBrowser.main(IssuesBrowser.java:81)");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("I tried to reproduce this problem and I can't. If anybody else can, could you please send a stack trace? \nThe stack trace provided is from an old revision as IssueUserFilter cannot throw a null pointer exception \non line 74 (as there are no dereferences on 74).");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("I couldn't reproduce this problem. It is possible that another bug that has since been fixed was \nconfounding with this one?");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("This bug has been fixed for two weeks with no problems. I am marking it closed.");
        currentIssue.getDescriptions().add(description);
        description = null;
        issues.add(currentIssue);
        currentIssue = null;
        currentIssue = new Issue();
        currentIssue.setId(new Integer(65));
        currentIssue.setStatus("CLOSED");
        currentIssue.setPriority(Priority.P1);
        currentIssue.setResolution("FIXED");
        currentIssue.setComponent("glazedlists");
        currentIssue.setVersion("current");
        currentIssue.setAssignedTo("issues@glazedlists");
        currentIssue.setSubcomponent("www");
        currentIssue.setIssueType("DEFECT");
        currentIssue.setQAContact("issues@glazedlists");
        currentIssue.setShortDescription("Tutorial part 3 references outdated API");
        description = new Description();
        description.setWho("kevinmaltby");
        description.setWhen(null);
        description.setText("Part 3 of the Tutorial references the old API for getFilterStrings() on \nTextFilterable.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("I have added a new branch of tutorial, tutorial-0.9.1\nhttp://publicobject.com/glazedlists/tutorial-0.9.1/\n\nNote that although tutorial numbers equal Glazed Lists numbers, there may be some Glazed Lists \nreleases that skip a tutorial release. Also, the tutorial could be rewritten by someone a little less \nexperienced who can point out the finer details of Glazed Lists development! As an experienced user I \nthink I glossed over some things too much since they are too familiar to me!\n\nAlso the tutorial has been moved out of CVS and onto the website only. I have added a tutorial zip to \nthe java.net file archives.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("This bug has been fixed for two weeks with no problems. I am marking it closed.");
        currentIssue.getDescriptions().add(description);
        description = null;
        issues.add(currentIssue);
        currentIssue = null;
        currentIssue = new Issue();
        currentIssue.setId(new Integer(66));
        currentIssue.setStatus("CLOSED");
        currentIssue.setPriority(Priority.P1);
        currentIssue.setResolution("FIXED");
        currentIssue.setComponent("glazedlists");
        currentIssue.setVersion("current");
        currentIssue.setAssignedTo("issues@glazedlists");
        currentIssue.setSubcomponent("www");
        currentIssue.setIssueType("DEFECT");
        currentIssue.setQAContact("issues@glazedlists");
        currentIssue.setShortDescription("SortedList fires empty events on setComparator");
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("SortedList fires empty update events on setComparator(). This can throw off the EventTableModel etc.\n\napple.awt.EventQueueExceptionHandler Caught Throwable : \njava.lang.IndexOutOfBoundsException: bitIndex < 0: -1\n        at java.util.BitSet.get(BitSet.java:459)\n        at javax.swing.DefaultListSelectionModel.clear(DefaultListSelectionModel.java:277)\n        at javax.swing.DefaultListSelectionModel.setState(DefaultListSelectionModel.java:489)\n        at javax.swing.DefaultListSelectionModel.removeIndexInterval(DefaultListSelectionModel.java:544)\n        at javax.swing.JTable.tableRowsDeleted(JTable.java:2971)\n        at javax.swing.JTable.tableChanged(JTable.java:2874)\n        at javax.swing.table.AbstractTableModel.fireTableChanged(AbstractTableModel.java:280)\n        at ca.odell.glazedlists.swing.EventTableModel.listChanged(EventTableModel.java:118)\n        at ca.odell.glazedlists.event.EventThreadProxy.listChanged(EventThreadProxy.java:44)\n        at ca.odell.glazedlists.event.ListEventAssembler.fireEvent(ListEventAssembler.java:289)\n        at ca.odell.glazedlists.event.ListEventAssembler.commitEvent(ListEventAssembler.java:256)\n        at ca.odell.glazedlists.SortedList.setComparator(SortedList.java:321)\n        at \nca.odell.glazedlists.swing.TableComparatorChooser.columnClicked(TableComparatorChooser.java:306)\n        at \nca.odell.glazedlists.swing.TableComparatorChooser.mouseClicked(TableComparatorChooser.java:179)\n        at java.awt.AWTEventMulticaster.mouseClicked(AWTEventMulticaster.java:212)\n        at java.awt.Component.processMouseEvent(Component.java:5103)\n        at java.awt.Component.processEvent(Component.java:4897)\n        at java.awt.Container.processEvent(Container.java:1569)\n        at java.awt.Component.dispatchEventImpl(Component.java:3615)\n        at java.awt.Container.dispatchEventImpl(Container.java:1627)\n        at java.awt.Component.dispatchEvent(Component.java:3477)\n        at java.awt.LightweightDispatcher.retargetMouseEvent(Container.java:3483)\n        at java.awt.LightweightDispatcher.processMouseEvent(Container.java:3207)\n        at java.awt.LightweightDispatcher.dispatchEvent(Container.java:3128)\n        at java.awt.Container.dispatchEventImpl(Container.java:1613)\n        at java.awt.Window.dispatchEventImpl(Window.java:1606)\n        at java.awt.Component.dispatchEvent(Component.java:3477)\n        at java.awt.EventQueue.dispatchEvent(EventQueue.java:456)\n        at java.awt.EventDispatchThread.pumpOneEventForHierarchy(EventDispatchThread.java:234)\n        at java.awt.EventDispatchThread.pumpEventsForHierarchy(EventDispatchThread.java:184)\n        at java.awt.EventDispatchThread.pumpEvents(EventDispatchThread.java:178)\n        at java.awt.EventDispatchThread.pumpEvents(EventDispatchThread.java:170)\n        at java.awt.EventDispatchThread.run(EventDispatchThread.java:100)");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("This was an easy fix. The problem stems from when we added support to retain selection through a \nsort as we forgot to support 0-element lists in that case.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("This bug has been fixed for two weeks with no problems. I am marking it closed.");
        currentIssue.getDescriptions().add(description);
        description = null;
        issues.add(currentIssue);
        currentIssue = null;
        currentIssue = new Issue();
        currentIssue.setId(new Integer(67));
        currentIssue.setStatus("CLOSED");
        currentIssue.setPriority(Priority.P4);
        currentIssue.setResolution("FIXED");
        currentIssue.setComponent("glazedlists");
        currentIssue.setVersion("0.9.1");
        currentIssue.setAssignedTo("jessewilson");
        currentIssue.setSubcomponent("core");
        currentIssue.setIssueType("ENHANCEMENT");
        currentIssue.setQAContact("jessewilson");
        currentIssue.setShortDescription("SparseList makes 2 tree calls when 1 will suffice");
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("SparseList models a list with some elements filtered out. This is accomplished using a tree whose nodes \ncontain two indices: relative to all elements and relative only to unfiltered elements.\n\nThe getIndex and getCompressedIndex methods are performed in two stages:\n - get the corresponding node\n - get the appropriate index for that node\n\nThis two-stage process can be condensed into one by adding a method to SparseList's nodes to \nperform this operation in one step.\n\nImplementing this performance enhancement will have the following Big-O impact:\n - Currently a getIndex() on a list of size 1000 takes O(10 + 10)\n - After the optimization, on a list of size 1000 this takes O(10)\n\nAlthough this is a very lowlevel optimization, it occurs in a frequently called method. The implementor \nshould record real-world times on getIndex and getCompressedIndex before and after the fix to see if \nthe real-world results compare to the theoretical ones.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("Now speedier!\n\nI created a sample program that does repeated gets() from a FilterList.\nOriginally this program took 14 seconds to run.\nAfter the optimization, it takes 8.9 seconds!\n\nAlright! Only problem is that there aren't very many obvious optimizations left!");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("This bug has been fixed for two weeks with no problems. I am marking it closed.");
        currentIssue.getDescriptions().add(description);
        description = null;
        issues.add(currentIssue);
        currentIssue = null;
        currentIssue = new Issue();
        currentIssue.setId(new Integer(68));
        currentIssue.setStatus("NEW");
        currentIssue.setPriority(Priority.P3);
        currentIssue.setResolution("");
        currentIssue.setComponent("glazedlists");
        currentIssue.setVersion("0.9.1");
        currentIssue.setAssignedTo("jessewilson");
        currentIssue.setSubcomponent("file");
        currentIssue.setIssueType("ENHANCEMENT");
        currentIssue.setQAContact("jessewilson");
        currentIssue.setShortDescription("Glazed lists on the filesystem");
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("Glazed Lists should store and retrieve list data using the filesystem.\n\nThe uses for this are numerous:\n - data caching\n - database style persistence\n\nIt would be desirable for such an implementation to be:\n - really, really easy to use\n - transactionable (preferrably using a supported API such as JTA)\n - very fault tolerant\n\nSee prevalayer for a more general-purpose implementation of this functionality.\n\nJava programmers would love to use an List API to persist data. This could be awesome.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("kevinmaltby");
        description.setWhen(null);
        description.setText("I was pondering the implementation of this feature and I suddenly remembered an \narticle from an old JDJ.  After making use of my JDJ Resource CD, I tracked it \ndown in Volume 8, Issue 11.  The article is entitled \"Enabling a File System as \na Transactional Resource\".  Some the work we will need to do to implement this \nfeature may have been partially solved in the article.  Is it exactly what we \nneed?  Probably not, but it's still worth a read.\n\nThe web version for any of you with digital subscriptions to the JDJ or access \nvia the Resource CD is:\n\nhttp://sys-con.com/story/?storyid=37798&DE=1");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("*** Issue 74 has been marked as a duplicate of this issue. ***");
        currentIssue.getDescriptions().add(description);
        description = null;
        issues.add(currentIssue);
        currentIssue = null;
        currentIssue = new Issue();
        currentIssue.setId(new Integer(69));
        currentIssue.setStatus("CLOSED");
        currentIssue.setPriority(Priority.P3);
        currentIssue.setResolution("FIXED");
        currentIssue.setComponent("glazedlists");
        currentIssue.setVersion("0.9.1");
        currentIssue.setAssignedTo("jessewilson");
        currentIssue.setSubcomponent("core");
        currentIssue.setIssueType("DEFECT");
        currentIssue.setQAContact("jessewilson");
        currentIssue.setShortDescription("Build fails on junit");
        description = new Description();
        description.setWho("pkuzel");
        description.setWhen(null);
        description.setText("Default target excludes *Test classes by there is one not folowing the pattren.\n\ncompile:\n    [mkdir] Created dir: /data/cvs/javanet/glazedlists/classes\n    [javac] Compiling 82 source files to /data/cvs/javanet/glazedlists/classes\n    [javac]\n/data/cvs/javanet/glazedlists/source/ca/odell/glazedlists/test/ThreadedCompositeRunner.java:10:\npackage junit.framework does not exist\n    [javac] import junit.framework.*;\n    [javac] ^\n    [javac] Note: Some input files use or override a deprecated API.\n    [javac] Note: Recompile with -deprecation for details.\n    [javac] 1 error");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("pkuzel");
        description.setWhen(null);
        description.setText("Created an attachment (id=3)\nA simple patch\n");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("This was a total oversight on my behalf and has now been resolved.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("This bug has been fixed for two weeks with no problems. I am marking it closed.");
        currentIssue.getDescriptions().add(description);
        description = null;
        issues.add(currentIssue);
        currentIssue = null;
        currentIssue = new Issue();
        currentIssue.setId(new Integer(70));
        currentIssue.setStatus("CLOSED");
        currentIssue.setPriority(Priority.P2);
        currentIssue.setResolution("INVALID");
        currentIssue.setComponent("glazedlists");
        currentIssue.setVersion("0.9.1");
        currentIssue.setAssignedTo("jessewilson");
        currentIssue.setSubcomponent("swing");
        currentIssue.setIssueType("DEFECT");
        currentIssue.setQAContact("jessewilson");
        currentIssue.setShortDescription("UI does not allow to remove sorting order");
        description = new Description();
        description.setWho("pkuzel");
        description.setWhen(null);
        description.setText("TableComparatorChooser instals header UI that allow to select sort by mouse\nclicks order but it *cannot* be removed.\n\nExpected behaviour: on third click remove sorting by selected column.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("This is the problem that I have not yet solved. The fix is\nfairly straightforward yet I do not know if it is natural.\nYou suggest the expected behavior of a 3rd click removing\nsorting. Although practical, this is not the behavior found\nin native Windows or Mac OS X tables. Mind you, I have\nnot yet seen another implementation of multiple-column\nsorting, so my experience is constrained to single column\nsorting.\n\nDo you think that this would be a worthwhile option to\nbe set on the TableComparatorChooser? I just think that\nbeing the same as Mac and Windows is preferable only\nbecause that will be the behavior that users will be most\nfamiliar with.\n\nLet me know what you think about this, and I will consider\nadding a method or changing the behavior.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("Currently we have no compelling reason to change the behaviour. If I am presented with such, this bug \nmay be reopened!");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("This bug has been fixed for two weeks with no problems. I am marking it closed.");
        currentIssue.getDescriptions().add(description);
        description = null;
        issues.add(currentIssue);
        currentIssue = null;
        currentIssue = new Issue();
        currentIssue.setId(new Integer(71));
        currentIssue.setStatus("CLOSED");
        currentIssue.setPriority(Priority.P2);
        currentIssue.setResolution("FIXED");
        currentIssue.setComponent("glazedlists");
        currentIssue.setVersion("0.9.1");
        currentIssue.setAssignedTo("jessewilson");
        currentIssue.setSubcomponent("core");
        currentIssue.setIssueType("DEFECT");
        currentIssue.setQAContact("jessewilson");
        currentIssue.setShortDescription("Event API antipatterns");
        description = new Description();
        description.setWho("pkuzel");
        description.setWhen(null);
        description.setText("ListEventListener:\n\n * <p>It is mandatory that the calling thread has obtained the write lock\n * on the source list. This guarantees the listener can read and write the\n * source list without obtaining any further locks.\n\nAFAIK it's pure antipattern. Commonly any event listener must not alter event\nsource synchronously to avoid:\n  - dispatching out of date events to other listeners\n  - infinite event loops\n\nListEvent & ListEventAssembler\n\nMy undertanding is that all clients get the same ListEvent object.\nUnfortunatelly ListEvent is mutable and therefore \"consumed\" by the first\nlistener. May be it should be cloned before firing it.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("This was a documentation error. Fortunately we do not follow the terrible\npractices as suggested by our own documentation. The documentation has\nbeen corrected and we have made note that the source list shall not be changed\nin the handling of an event.\n\nThe documentation error has been corrected:\n     * <p>It is mandatory that the calling thread has obtained the write lock\n     * on the source list. This is because the calling thread will have written\n     * to the source list to cause this event. This condition guarantees that\n     * no writes can occur while the listener is handling this event.\n     * It is an error to write to the source list while processing an event.\n");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("This bug has been fixed for two weeks with no problems. I am marking it closed.");
        currentIssue.getDescriptions().add(description);
        description = null;
        issues.add(currentIssue);
        currentIssue = null;
        currentIssue = new Issue();
        currentIssue.setId(new Integer(72));
        currentIssue.setStatus("CLOSED");
        currentIssue.setPriority(Priority.P3);
        currentIssue.setResolution("FIXED");
        currentIssue.setComponent("glazedlists");
        currentIssue.setVersion("0.9.1");
        currentIssue.setAssignedTo("jessewilson");
        currentIssue.setSubcomponent("core");
        currentIssue.setIssueType("TASK");
        currentIssue.setQAContact("jessewilson");
        currentIssue.setShortDescription("Note on issue 71");
        description = new Description();
        description.setWho("pkuzel");
        description.setWhen(null);
        description.setText("I cannot edit issues. I had to fill next one. This one represents additional\nnote issue #71.\n\nRegarding event source mutability and event firing I can see that your solution\ncould work if EventAssembler fires updated events. I.e. if a listener changes a\nsource list then:\n - all already notified listeners get the event decribing the additional change\n - listener itself gets no event \n - all not yet notified listeners get an event desribing both original change\n   and new change (blocks)\n\nIt could be hard to implement. Hopefully unit test could be simple.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("Fortunately we do not have to worry about this problem.\n\nListeners are strictly not allowed to modify their source lists in the processing of list events, and that's \nfinal!\n\nFortunately if a listener does not like the contents of a source list, it is free to present and alternate \nview of that list that it likes better. We call these \"TransformationLists\" and they are the basis of this \nproject. \n\nFinally, for good measure:\nDO NOT MODIFY A LIST WHILE PROCESSING AN EVENT THAT IT SENT YOU! IT WILL MEAN BIG TROUBLE \nFOR YOU! PROBABLY A CONCURRENTMODIFICATIONEXCEPTION!");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("This bug has been fixed for two weeks with no problems. I am marking it closed.");
        currentIssue.getDescriptions().add(description);
        description = null;
        issues.add(currentIssue);
        currentIssue = null;
        currentIssue = new Issue();
        currentIssue.setId(new Integer(73));
        currentIssue.setStatus("CLOSED");
        currentIssue.setPriority(Priority.P2);
        currentIssue.setResolution("FIXED");
        currentIssue.setComponent("glazedlists");
        currentIssue.setVersion("current");
        currentIssue.setAssignedTo("jessewilson");
        currentIssue.setSubcomponent("core");
        currentIssue.setIssueType("DEFECT");
        currentIssue.setQAContact("jessewilson");
        currentIssue.setShortDescription("ArrayIndexOutOfBoundsException on J2SE 5.0 beta 2");
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("I got the following Exception upon starting the demo app.\n\ndeathstar:glazedlists$ java -jar glazedlists.jar \nException in thread \"AWT-EventQueue-0\" java.lang.ArrayIndexOutOfBoundsException:\nInvalid range for selection: 0-0, list size is 0\n	at\nca.odell.glazedlists.swing.EventSelectionModel$EventListSelectionModel.setSubRangeOfRange(EventSelectionModel.java:420)\n	at\nca.odell.glazedlists.swing.EventSelectionModel$EventListSelectionModel.removeSelectionInterval(EventSelectionModel.java:587)\n	at javax.swing.JTable.checkLeadAnchor(JTable.java:2963)\n	at javax.swing.JTable.tableRowsInserted(JTable.java:3079)\n	at javax.swing.JTable.tableChanged(JTable.java:3013)\n	at\njavax.swing.table.AbstractTableModel.fireTableChanged(AbstractTableModel.java:280)\n	at ca.odell.glazedlists.swing.EventTableModel.listChanged(EventTableModel.java:118)\n	at ca.odell.glazedlists.event.EventThreadProxy.run(EventThreadProxy.java:54)\n	at java.awt.event.InvocationEvent.dispatch(InvocationEvent.java:209)\n	at java.awt.EventQueue.dispatchEvent(EventQueue.java:461)\n	at\njava.awt.EventDispatchThread.pumpOneEventForHierarchy(EventDispatchThread.java:234)\n	at\njava.awt.EventDispatchThread.pumpEventsForHierarchy(EventDispatchThread.java:163)\n	at java.awt.EventDispatchThread.pumpEvents(EventDispatchThread.java:157)	at\njava.awt.EventDispatchThread.pumpEvents(EventDispatchThread.java:149)	at\njava.awt.EventDispatchThread.run(EventDispatchThread.java:110)");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("Easy fix! I hope they fix the Java 5.0 though as this is lame. Currently the lameness is that if -1 is \npassed as an argument to any method, it is either a no-op or a selection clear.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("This bug has been fixed for two weeks with no problems. I am marking it closed.");
        currentIssue.getDescriptions().add(description);
        description = null;
        issues.add(currentIssue);
        currentIssue = null;
        currentIssue = new Issue();
        currentIssue.setId(new Integer(74));
        currentIssue.setStatus("RESOLVED");
        currentIssue.setPriority(Priority.P3);
        currentIssue.setResolution("DUPLICATE");
        currentIssue.setComponent("glazedlists");
        currentIssue.setVersion("1.1");
        currentIssue.setAssignedTo("jessewilson");
        currentIssue.setSubcomponent("file");
        currentIssue.setIssueType("ENHANCEMENT");
        currentIssue.setQAContact("jessewilson");
        currentIssue.setShortDescription("File based list");
        description = new Description();
        description.setWho("pkuzel");
        description.setWhen(null);
        description.setText("Attached prototype implementation of file bases lists. It can be used as data\nholder (warpped by EventList) for huge lists. Implementation is not effecient on\nlist.remove().");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("pkuzel");
        description.setWhen(null);
        description.setText("Created an attachment (id=4)\nSources\n");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("See bug #68.\n\nThat implementation will support all that is here, plus persisting a List so that it can be opened up later \nwhen the application is next started. The only problem with that implementation is that it is currently \nvaporware. This will do great for now!\n\n*** This issue has been marked as a duplicate of 68 ***");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("pkuzel");
        description.setWhen(null);
        description.setText("Here I primarily addressed huge lists that does not fit into memory. I planned\nto wrap it into CachedFileList that would keep few last entries in memory and\ninteligently implements iterators to do not flush the cached entries.\n\nIt can be reused for long term persistence but with the same warning as Swing\nused - it's not designed for it and the serialization format can change. I was\ntempting to add a File parametrized contructor but I have resisted because long\nterm persistence introduces data format backward compatability issues (well with\nwrong clients, but it's too easy to code such client if everything seems to\nimplicitly work today). In my applications clients must explicitly iterate over\nlist and store its content.\n");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("The argument to avoid serializing a list for long-term use is compelling.\n\nWhen I get around to implementing issue 68, I will keep this in mind. \nI think a useful approach will be to create a \"Serialator\" class with a method such as \n    byte[] toBytes(Object o)\nI could then create a default Serialiator that simply Serializes the Object.\n\nThis will allow users to use the Serializable interface or perhaps something with more longevity. The \nproblem with Serializable and Externalizable is that neither of them interoperate outside of Java very \neasily. By using a Serialator, we enable the user to spend the extra time to create binary representations \nof their data that interop either via files or even via the network. This way we get the best of both \nworlds. \n\nI will be sure to include options such as \"temporary\" for the eventual implementation of #68. And of \ncourse a \"Serialization Warning\" in the Javadoc.");
        currentIssue.getDescriptions().add(description);
        description = null;
        issues.add(currentIssue);
        currentIssue = null;
        currentIssue = new Issue();
        currentIssue.setId(new Integer(75));
        currentIssue.setStatus("NEW");
        currentIssue.setPriority(Priority.P2);
        currentIssue.setResolution("");
        currentIssue.setComponent("glazedlists");
        currentIssue.setVersion("0.9.1");
        currentIssue.setAssignedTo("jessewilson");
        currentIssue.setSubcomponent("net");
        currentIssue.setIssueType("TASK");
        currentIssue.setQAContact("jessewilson");
        currentIssue.setShortDescription("Implement Resource Block Peer");
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("Originally I planned to create \"Update Subscription Protocol\" which was a publish/subscribe protocol for \nupdate events. This approach is nice because it is generic, yet I have realized that it is not flexible \nenough for any generic use!\n\nTherefore I suggest \"Block Resource Peer\", which is similar to the proposed Update Subscription \nProtocol, but with a few important differences:\n - clients can query upstream, for methods like get(i)\n - packet interpretation is left up to another class\n\nBlock Resource Peer must perform the following:\n - Crypto. Public key exchange and block signing\n - Blocking. Like chunking, but not at the mercy of proxy servers. Most of the time, 1 packet will \ncontain 1 HTTP chunk, and 1 HTTP chunk will contain 1 block\n\nEventually, I would like to add P2P to Block Resource Peer. This has the following implications:\n - A block from connection X may have been signed from Y which is upstream of X\n - Connections to a resource, rather than a particular host. Resources are replicated\n - Databases of hosts and resources\n\nTo simplify this:\n - Resources are named by their source host, but not available exclusively at that site\n - I shall design a URI for resources, \"glazedlists://host:port/resourcename\" may be a good start\n - Resource handlers should have methods to publish blocks and handle queries\n - Multiple resource publishers and subscribers per Block Resource Peer\n\nI have my work cut out for me. For starters I will design some interfaces and perhaps even draw some \ndiagrams!");
        currentIssue.getDescriptions().add(description);
        description = null;
        issues.add(currentIssue);
        currentIssue = null;
        currentIssue = new Issue();
        currentIssue.setId(new Integer(76));
        currentIssue.setStatus("CLOSED");
        currentIssue.setPriority(Priority.P3);
        currentIssue.setResolution("WORKSFORME");
        currentIssue.setComponent("glazedlists");
        currentIssue.setVersion("current");
        currentIssue.setAssignedTo("jessewilson");
        currentIssue.setSubcomponent("core");
        currentIssue.setIssueType("DEFECT");
        currentIssue.setQAContact("jessewilson");
        currentIssue.setShortDescription("problem in EventListSelectionModel under Java 5");
        description = new Description();
        description.setWho("ildella");
        description.setWhen(null);
        description.setText("I have another problem with Java5\nThis exception raises up. The same code works perfectly under 1.4.2\nI am testing the CVS version of glazedlists.\n\nException in thread \"AWT-EventQueue-0\" java.lang.ArrayIndexOutOfBoundsException:\nInvalid range for selection: 0-0, list size is 0\n	at\nca.odell.glazedlists.swing.EventSelectionModel$EventListSelectionModel.setSubRangeOfRange(EventSelectionModel.java:387)\n	at\nca.odell.glazedlists.swing.EventSelectionModel$EventListSelectionModel.removeSelectionInterval(EventSelectionModel.java:548)\n	at javax.swing.JTable.checkLeadAnchor(JTable.java:2965)\n	at javax.swing.JTable.tableRowsInserted(JTable.java:3081)\n	at javax.swing.JTable.tableChanged(JTable.java:3015)\n	at\njavax.swing.table.AbstractTableModel.fireTableChanged(AbstractTableModel.java:280)\n	at ca.odell.glazedlists.swing.EventTableModel.listChanged(EventTableModel.java:118)\n	at ca.odell.glazedlists.event.EventThreadProxy.run(EventThreadProxy.java:54)\n	at java.awt.event.InvocationEvent.dispatch(InvocationEvent.java:209)\n	at java.awt.EventQueue.dispatchEvent(EventQueue.java:461)\n	at\njava.awt.EventDispatchThread.pumpOneEventForHierarchy(EventDispatchThread.java:234)\n	at\njava.awt.EventDispatchThread.pumpEventsForHierarchy(EventDispatchThread.java:163)\n	at java.awt.EventDispatchThread.pumpEvents(EventDispatchThread.java:157)\n	at java.awt.EventDispatchThread.pumpEvents(EventDispatchThread.java:149)\n	at java.awt.EventDispatchThread.run(EventDispatchThread.java:110)");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("I could not reproduce this bug. I think it is a duplicate of an earlier bug that has since been fixed.\n\nIn the included exception, the method removeSelectionInterval() calls setSubRangeOfRange() on \nline 548. But in my code from CVS, there is no such method call on line 548. Note that it is very \npossible that the tested system has different newline characters: \"\\n\" or \"\\r\\n\" which can \ncause a discrepancy in line numbers.\n\nI request that the bug's reporter, idella, please update to the latest version from CVS by doing a clean \ncheckout and verify that this bug still exists. Please include steps to reproduce!");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("This bug has been fixed for two weeks with no problems. I am marking it closed.");
        currentIssue.getDescriptions().add(description);
        description = null;
        issues.add(currentIssue);
        currentIssue = null;
        currentIssue = new Issue();
        currentIssue.setId(new Integer(77));
        currentIssue.setStatus("CLOSED");
        currentIssue.setPriority(Priority.P2);
        currentIssue.setResolution("FIXED");
        currentIssue.setComponent("glazedlists");
        currentIssue.setVersion("0.9.1");
        currentIssue.setAssignedTo("jessewilson");
        currentIssue.setSubcomponent("swing");
        currentIssue.setIssueType("DEFECT");
        currentIssue.setQAContact("jessewilson");
        currentIssue.setShortDescription("TableHeader indicator arrows point the wrong way");
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("Compare table header indicator arrows between Glazed Lists' TableComparatorChooser and native \napps. Glazed Lists' arrows point up when down and vice-versa. This should be verified on other \nplatforms!");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("This was just a silly missing exclamation mark, as in if(isReverse()) should have been if(!isReverse())\n\nAn embarassing mistake to say the least. How come nobody caught this earlier!");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("This bug has been fixed for two weeks with no problems. I am marking it closed.");
        currentIssue.getDescriptions().add(description);
        description = null;
        issues.add(currentIssue);
        currentIssue = null;
        currentIssue = new Issue();
        currentIssue.setId(new Integer(78));
        currentIssue.setStatus("CLOSED");
        currentIssue.setPriority(Priority.P2);
        currentIssue.setResolution("FIXED");
        currentIssue.setComponent("glazedlists");
        currentIssue.setVersion("0.9.1");
        currentIssue.setAssignedTo("jessewilson");
        currentIssue.setSubcomponent("swing");
        currentIssue.setIssueType("DEFECT");
        currentIssue.setQAContact("jessewilson");
        currentIssue.setShortDescription("EventThreadProxy in wrong package");
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("The EventThreadProxy class depends on Java Swing. But that class is not in the swing package, rather it \nis in the event package.\n\nThis is a problem for building on VMs that do not support Swing such as GCJ.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("All fixed up, moved to the other package. It should have never been there in the first place.\n\nThis fix is more significant than you might expect for at least one project:\n - For a project at work, we are using Glazed Lists with SWT\n - We are compiling with GCJ\n - GCJ does not support Swing\n - Our project grabs the Glazed Lists source and then dumps the swing/ folder\n - The EventThreadProxy breaks our build, until now we had to delete it explicitly");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("This bug has been fixed for two weeks with no problems. I am marking it closed.");
        currentIssue.getDescriptions().add(description);
        description = null;
        issues.add(currentIssue);
        currentIssue = null;
        currentIssue = new Issue();
        currentIssue.setId(new Integer(79));
        currentIssue.setStatus("RESOLVED");
        currentIssue.setPriority(Priority.P3);
        currentIssue.setResolution("WONTFIX");
        currentIssue.setComponent("glazedlists");
        currentIssue.setVersion("0.9.1");
        currentIssue.setAssignedTo("jessewilson");
        currentIssue.setSubcomponent("core");
        currentIssue.setIssueType("ENHANCEMENT");
        currentIssue.setQAContact("jessewilson");
        currentIssue.setShortDescription("TransformedList with a virtual entry");
        description = new Description();
        description.setWho("pkuzel");
        description.setWhen(null);
        description.setText("I found usefull to code a list that adds a virtual entry to own end. This list\nis then used as source for UI component models.\n\nBackground: I have impelemented the logic in list rather than in models bacause\nI share the list source by multiple models and their respective views (form vs\ntable view).");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("pkuzel");
        description.setWhen(null);
        description.setText("Created an attachment (id=5)\nThe source\n");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("I think that this is a good idea and the submitted code is good.\n\nBut there already exists a more general solution in the code called \"CompositeList\".\n\nCompositeList allows you to concatenate EventLists and view them as one. For this problem, this would \nuse CompositeList in the following way:\n  - CompositeList of 2 lists A and B\n  - A is the EventList of interest\n  - B is a BasicEventList with one entry, the 'virtual' entry\nAny action to de-virtualize the last entry would simply be to do A.addAll(B), B.set(0, new VirtualEntry());\n\nAgain, the provided code is good. But I don't see a very compelling reason to include it in the main \nGlazed Lists distribution simply because the provided code solves a rather specific problem. If it were \nmy application code I would keep the VirtualList, perhaps in a util/ package of my project.");
        currentIssue.getDescriptions().add(description);
        description = null;
        issues.add(currentIssue);
        currentIssue = null;
        currentIssue = new Issue();
        currentIssue.setId(new Integer(80));
        currentIssue.setStatus("NEW");
        currentIssue.setPriority(Priority.P2);
        currentIssue.setResolution("");
        currentIssue.setComponent("glazedlists");
        currentIssue.setVersion("0.9.2");
        currentIssue.setAssignedTo("jessewilson");
        currentIssue.setSubcomponent("core");
        currentIssue.setIssueType("ENHANCEMENT");
        currentIssue.setQAContact("jessewilson");
        currentIssue.setShortDescription("AbstractFilterList.notifyFilterChanged() should have \"tighter\" and \"looser\"");
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("Suppose I have a TextFilterList where I have filtered out 9000 of 10,000 items.\nIf I edit the filter text to add a new word, it is impossible that any of the hiddne elements will appear \nbecause the filter is getting \"tighter\". By adding a new word, I can only filter-out and not filter-in.\n\nUnfortunately AbstractFilterList does not support the idea of \"tigher\" and \"looser\" and therefore in this \ncase all 10,000 elements will be re-examined when only 1000 will do.\n\nSimilarly if I remove a filter word, it is not possible that existing entries will filter-out, only filter in. This \nis a 'looser' refinement. The AbstractFilterList should only examine the 9000 hidden elements and not \nthe 1000 visible ones.\n\nThis will increase the performance of AbstractFilterList without much additional complexity. It should \nstill support overall changes where the new filter and old filter have no relationship.");
        currentIssue.getDescriptions().add(description);
        description = null;
        issues.add(currentIssue);
        currentIssue = null;
        currentIssue = new Issue();
        currentIssue.setId(new Integer(81));
        currentIssue.setStatus("NEW");
        currentIssue.setPriority(Priority.P4);
        currentIssue.setResolution("");
        currentIssue.setComponent("glazedlists");
        currentIssue.setVersion("0.9.2");
        currentIssue.setAssignedTo("jessewilson");
        currentIssue.setSubcomponent("core");
        currentIssue.setIssueType("ENHANCEMENT");
        currentIssue.setQAContact("jessewilson");
        currentIssue.setShortDescription("JDBC support in Glazed Lists");
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("I think that people are using Glazed Lists as an alternative to a traditional database grids.\n\nI have been wondering whether or not it is possible to create a JDBCList that is backed by a SQL query. \nThere's a whole bunch of different problems that this could introduce, but if done right then Glazed \nLists would make a killer database grid.\n\nIt will require some thought and some tweaking to existing classes if we want to build this.");
        currentIssue.getDescriptions().add(description);
        description = null;
        issues.add(currentIssue);
        currentIssue = null;
        currentIssue = new Issue();
        currentIssue.setId(new Integer(82));
        currentIssue.setStatus("NEW");
        currentIssue.setPriority(Priority.P5);
        currentIssue.setResolution("");
        currentIssue.setComponent("glazedlists");
        currentIssue.setVersion("0.9.2");
        currentIssue.setAssignedTo("jessewilson");
        currentIssue.setSubcomponent("swing");
        currentIssue.setIssueType("DEFECT");
        currentIssue.setQAContact("jessewilson");
        currentIssue.setShortDescription("TableComparatorChooser sort arrow indicators not right aligned");
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("This is the nit-pickiest issue yet. The TableComparatorChooser arrows don't look EXACTLY like the \nnative operating system, but they could.\nhttp://publicobject.com/glazedlists/sortedjtables/\n\nA summary of differences:\n  label alignment is not LEFT on Windows\n  label alignment is not context-sensitive on Windows or Mac OS X\n  arrow alignment is not RIGHT on Mac OS X\n  header is not blue for primary column on Mac OS X\n\nThis issue is low priority and should only be done if there's nothing better to do! Don't work on this \nbug!");
        currentIssue.getDescriptions().add(description);
        description = null;
        issues.add(currentIssue);
        currentIssue = null;
        currentIssue = new Issue();
        currentIssue.setId(new Integer(83));
        currentIssue.setStatus("RESOLVED");
        currentIssue.setPriority(Priority.P5);
        currentIssue.setResolution("FIXED");
        currentIssue.setComponent("glazedlists");
        currentIssue.setVersion("0.9.2");
        currentIssue.setAssignedTo("jessewilson");
        currentIssue.setSubcomponent("swing");
        currentIssue.setIssueType("DEFECT");
        currentIssue.setQAContact("jessewilson");
        currentIssue.setShortDescription("TableComparatorChooser needs icons for new Java l&fs");
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("Java is getting better Look&Feel support and Glazed Lists should keep up with appropriate icons for the \nTableComparatorChooser.\n\nLook and feels currently supported by TableComparatorChooser:\n - Aqua\n - Metal\n - Windows\n\nLook and feels that need support\n - Ocean (J2SE 1.5+)\n - GTK\n - Windows XP\n\nHere's some screenshots to get started:\nhttp://java.sun.com/developer/technicalArticles/releases/j2se15/");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("Created an attachment (id=6)\nSwingSet demo, this is what OCEAN looks like\n");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("Created an attachment (id=7)\nAnother SwingSet demo picture for what OCEAN looks like\n");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("I've attached some Ocean screenshots so that I can draw up some triangles for\nthat theme.\n\nAs for XP, I need to find a friend who will lend me their XP box for a few hours\nso I can get some screenshots of its icons.\n\nAs for GTK, the GTK theme does not make this task very easy. The GTK theme is\nskinnable itself, so an icon that looks good for one GTK user might look\nterrible for another GTK user. There might be a standard icon included in such\nskins, but I have no idea how to get at it. Also I would like to note that my\nSun box has the ugliest GTK theme known to man and it would be a crime against\nhumanity to make an icon that matches its theme. I think the \"Blue Curve\" theme\nis where all the GTK kids are at with their Redhat boxes and if I can get a hold\nof that, I'd be able to do a decent enough icon.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("I've completed the Ocean triangles, you can view them right now at:\nhttp://publicobject.com/glazedlists/sortedjtables/\n\nAs for the others:\n  Windows XP - I'm installing XP on a box tomorrow, so I should be able to do icons for it soon.\n  GTK - I think my best bet is to copy the set from Evolution 2.0, if I can get that on a machine\n  Synth - Not before mentioned skinnable L&F. Obviously I will need code support for this via setIcons() \nor perhaps inspecting the synth XML file or something? I don't know if it supports extensions but that \nwould be really slick. Programmable access will be necessary regardless for canned skins.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("The XP skin is now complete.\n\nAll that is left is GTK & Synth. GTK will be deferred until requested, or I get bored and want to draw 'em \nup. Synth will require me to look into how to make synth skins. I haven't yet seen any, so I'm going to \nput that on hold also. When the Synth skins first start popping up, then I'll do some investigation!\n\n");
        currentIssue.getDescriptions().add(description);
        description = null;
        issues.add(currentIssue);
        currentIssue = null;
        currentIssue = new Issue();
        currentIssue.setId(new Integer(84));
        currentIssue.setStatus("NEW");
        currentIssue.setPriority(Priority.P4);
        currentIssue.setResolution("");
        currentIssue.setComponent("glazedlists");
        currentIssue.setVersion("0.9.2");
        currentIssue.setAssignedTo("jessewilson");
        currentIssue.setSubcomponent("swing");
        currentIssue.setIssueType("ENHANCEMENT");
        currentIssue.setQAContact("jessewilson");
        currentIssue.setShortDescription("TextFilterList optimization via caching results");
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("Currently TextFilterList does a full-text search on ALL of the Strings returned from getFilterStrings() for \nALL Objects in the list. In many cases this will contain a lot of redundant searches. Suppose we have a \nprogram like mCube where the data is songs. Each song has an album and and an artist and there is a \nlot of duplication among album and artists for names. Currently if I have 25 items all with the artist \n\"Limp Bizkit\", then that string will be searched 25 times on a Glazed Lists filter.\n\nMy idea is to cache the result of a String matching a pattern, so that if that exact same String is found \nagain, then the result can be returned faster than normal.\n\nOf course there are some requirements. Finding a cached String has to be an order of magnitude faster \nthan searching the string itself. \n    - the normal hashCode() method on String might not be fast. I think it examines every character. It \nmay cache the result however, in which case a HashSet would be a useful datastructure to start\n    - using a Collection of successes and a Collection of failures. For each filter string, we could first \ncheck for its presence in either set before attempting to perform the actual match. After finding a \nmatch or not, the String could be placed in one of the Collections.\n    - Collections could be limited in size to only the most popular entries to keep searches fast! This \nwould allow for an O(1)-style filtering in best cases\n\nThis will require experimentation. But it is a FUN problem!");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("It is important to note that the chance of collision is much higher when the string is smaller.\nSmaller strings tend to have \"token\" values, wheras long strings will more likely be unique descriptions.\n\nExample: \"P3\", \"jessewilson\", \"ENHANCEMENT\" and \"0.9.2\" are more likely to be repeated than say, this \ndescription. It might be worthwhile to determine a cut-off like 32-characters to differentiate between \nStrings that would be worth caching or not.");
        currentIssue.getDescriptions().add(description);
        description = null;
        issues.add(currentIssue);
        currentIssue = null;
        currentIssue = new Issue();
        currentIssue.setId(new Integer(85));
        currentIssue.setStatus("RESOLVED");
        currentIssue.setPriority(Priority.P4);
        currentIssue.setResolution("FIXED");
        currentIssue.setComponent("glazedlists");
        currentIssue.setVersion("0.9.2");
        currentIssue.setAssignedTo("jessewilson");
        currentIssue.setSubcomponent("swing");
        currentIssue.setIssueType("ENHANCEMENT");
        currentIssue.setQAContact("jessewilson");
        currentIssue.setShortDescription("Convenience constructors for automatic TableFormats");
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("Writing a TableFormat is quite a dry experience. It seems like every TableFormat I write is nearly \nidentical and creating them is very mechanical.\n\nTherefore I propose some convenience constructors for EventTableModel that do not require me to \ncreate a boring TableFormat, rather I should be able to specify using Strings how my TableFormat shall \nlook.\n\nFor example, to create an EventTableModel to display Issue objects, this would be a decent constructor:\nList columns = Arrays.asList(new String[] { \"ID\", \"Priority\", \"Description\" });\nList fields = Arrays.asList(new String[] { \"id\", \"priority\", \"shortDescription\" });\nEventTableModel etm = new EventTableModel(myIssuesList, columns, fields);\n\nThe EventTableModel could then use reflection to create a custom TableFormat that fits my needs. In \nthis case, \"ID\" would correspond to a \"getId()\" method in the list objects and \"shortDescription\" would \ncorrespond to a \"getShortDescription()\" method in the list objects. All with simple JavaBeans and \nreflection.\n\nFinally, it might also be desirable to create a TableModel that takes a ResultSet as a parameter and \nexpects objects as either database rows or Lists of row columns.\n\nThe whole idea here is to make it so that we can create applications with less code. Note that if \nimplemented, this would be a very bad thing to feature in a tutorial since it is runtime checked and \nerrors cannot be caught by Mr. Javac.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("Done. I sent out a survey to the mailing list on this to see what the best way to expose this functionality \nwould be.\n\nMost users said it would be best simply to provide an alternate constructor to EventTableModel that did \nthe construction of by BeanTableFormat automatcally. So this is how it now works!\n\nThere is a brief caution on the use of this with respect to reflection. It is also dangerous because typos \nin method names will not be checked until runtime.");
        currentIssue.getDescriptions().add(description);
        description = null;
        issues.add(currentIssue);
        currentIssue = null;
        currentIssue = new Issue();
        currentIssue.setId(new Integer(86));
        currentIssue.setStatus("RESOLVED");
        currentIssue.setPriority(Priority.P3);
        currentIssue.setResolution("FIXED");
        currentIssue.setComponent("glazedlists");
        currentIssue.setVersion("0.9.2");
        currentIssue.setAssignedTo("jessewilson");
        currentIssue.setSubcomponent("core");
        currentIssue.setIssueType("ENHANCEMENT");
        currentIssue.setQAContact("jessewilson");
        currentIssue.setShortDescription("Convenience constructor for automatic Filterators");
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("Bug 85 is \"Convenience constructors for automatic TableFormats\". The fix for this was to use reflection \nto do automatic construction of TableFormat objects. \n\nWe could do something very similar for automatic Filterators. Simply inspect the class in use and use all \nof its methods that return a String. This might not have great performance due to some classes which \ndo lookups in such methods, but it would be a great helper for most simple filter classes.\n\nThis is a convenience-type of enhancement. It must be noted in its Javadocs that use of this method \nmay cause a performance hit in some cases.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("Fixed. See the new constructor for TextFilterList.");
        currentIssue.getDescriptions().add(description);
        description = null;
        issues.add(currentIssue);
        currentIssue = null;
        currentIssue = new Issue();
        currentIssue.setId(new Integer(87));
        currentIssue.setStatus("RESOLVED");
        currentIssue.setPriority(Priority.P5);
        currentIssue.setResolution("FIXED");
        currentIssue.setComponent("glazedlists");
        currentIssue.setVersion("0.9.2");
        currentIssue.setAssignedTo("jessewilson");
        currentIssue.setSubcomponent("core");
        currentIssue.setIssueType("DEFECT");
        currentIssue.setQAContact("jessewilson");
        currentIssue.setShortDescription("GlazedLists is inconsistent in what exception is thrown on bounds checking");
        description = new Description();
        description.setWho("kevinmaltby");
        description.setWhen(null);
        description.setText("Our volatile implementation classes follow suit with ArrayList and other \nmembers of the Collections framework by throwing IndexOutOfBoundsExceptions \nwhen range checking fails.  The TransformedList throws \nArrayIndexOutOfBoundsExceptions on range checking failures.  As a result any \nlist which overrides a method that takes an index may throw different exception \ntypes depending on its implementation details.  A minor inconsistency but worth \nmentioning nonetheless.  I haven't checked yet how many classes are affected by \nthis.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("kevinmaltby");
        description.setWhen(null);
        description.setText("A related inconsistency can be found in the volatile IndexedTree ADT (and I \nassume the SparseList ADT) which throws a NullPointerException when a get() is \ncalled on an empty list.  ArrayList throws an IndexOutOfBoundsException in that \ncase.\n\nI would agree with anyone who says that this issue is almost a tad on the \nexcessive, but it's still worth mentioning, even at priority 5.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("Well I fixed bug 87, albeit perhaps not in the most 'agreeable' way.\n\nHeres the problem with fixing the bug in the IndexedTree class:\n - its used only internally\n - many classes (ie. SortedList) call get() hundreds of times, none of those are ever out-of-bounds\n - high performance is going to be a very important issue for SortedList, so we are going to avoid at all \ncosts slowing that down\n\nSo I fixed it in CachingList instead. The new rule is that IndexedTree will blow up violently if you violate \nits preconditions, so classes that use it should be careful to verify that they are not violating its \npreconditions.\n\nPretty much my strategy is this:\n  - create a user-friendly front end (ie. SortedList, CachingList) that does all the necessary due-process \nand range checks\n  - create high performance backend (ie. IndexedTree, SparseList) that have strict requirements on \nparameters etc., but do no unnecessary checks or whatever. \n  - in that high performance backend, use the assert() keyword to enable appropriate checking when \nnecessary to verify that the code is in fact correct\n\n");
        currentIssue.getDescriptions().add(description);
        description = null;
        issues.add(currentIssue);
        currentIssue = null;
        currentIssue = new Issue();
        currentIssue.setId(new Integer(88));
        currentIssue.setStatus("RESOLVED");
        currentIssue.setPriority(Priority.P3);
        currentIssue.setResolution("INVALID");
        currentIssue.setComponent("glazedlists");
        currentIssue.setVersion("0.9.2");
        currentIssue.setAssignedTo("jessewilson");
        currentIssue.setSubcomponent("swing");
        currentIssue.setIssueType("DEFECT");
        currentIssue.setQAContact("jessewilson");
        currentIssue.setShortDescription("TableFormat may receive null Object");
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("TableFormat may be passed a null Object for a list that never contains nulls.\n\nThis happens when an element is deleted on a worker thread, but the EventTableModel has not yet \nbeen notified on the event dispatch thread, and the event dispatch thread is now asking to paint the \ndeleted element.\n\nThe null should simply be rendered as null. The renderers should be tolerable, that is much more \nappropriate than the TableFormat.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("I must have forgotten.\n\nThis bug is already fixed. It is NOT necessary to check for null in your TableFormat class.");
        currentIssue.getDescriptions().add(description);
        description = null;
        issues.add(currentIssue);
        currentIssue = null;
        currentIssue = new Issue();
        currentIssue.setId(new Integer(89));
        currentIssue.setStatus("STARTED");
        currentIssue.setPriority(Priority.P3);
        currentIssue.setResolution("");
        currentIssue.setComponent("glazedlists");
        currentIssue.setVersion("0.9.2");
        currentIssue.setAssignedTo("jessewilson");
        currentIssue.setSubcomponent("swing");
        currentIssue.setIssueType("TASK");
        currentIssue.setQAContact("jessewilson");
        currentIssue.setShortDescription("Validate performance of TextFilterList");
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("TextFilterList uses regular expressions to do searching. Is this really faster? This claim must be \nvalidated.\n\nIf regex is not faster, TextFilterList should use an alternative text searching system.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("I've been doing some thinking on how to speed this stuff up....\n\nRegex uses a DFA to walk through the strings, one character of input at a time. It may not be \nridiculously fast for my purposes.\n\nindexOf works, but it requires a call to toUpperCase(), which is already slower than regex.\n\nA custom solution may be the ultimate solution to this problem. We learned about fast searching \ntechniques in CS 240 at U of W, this might be the best way to go.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("I've given this some further thought. What we really need is a test program that tests the performance \nof TextFilterList with meaningful real-world data. Therefore I have come up with a strategy.\n\nI will develop a test program that reads test files, runs them through the TextFilterList and times its \nperformance. It will then write the total time to the console. The test program can verify speed AND \ncorrectness.\n\nThe test file is made up of a series of serialized objects.\n  1. A List of Strings, each String a the 'query String' for a separate test\n  2. A List of Integers, each corresponding to the number of results expected from String #1.\n  3. The test data. This is a List of \"test data objects\". For simplicity, a test data object itself is simply an \nArrayList full of Strings.\n\nNow here are some test data that I think would be reasonable:\n - The ID3 data from my entire MP3 collection. Each MP3's gets one ArrayList full of Strings. These \nstrings are short and there's lots of duplication.\n - The entire Mozilla issue database. This is a mix of short and longs strings with lots of duplication.\n - Some articles from a website. This is a single really long String.\n\nBuilding this will take some time, but it will make it possible to implement competing algorithms and to \nsee how they actually will perform in practice.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("I've run some simple performance tests and the performance is GOOD, but not GREAT.\nFiltering a quarter-million medium elements takes about 7 seconds on my PowerBook 1.3GHz\nFiltering 2500 medium elements takes about 0.2 seconds on my PowerBook\n\nThis sounds good, but the smart people at Google.com filter a hell of a lot more faster. Mind you they \nhave more hardware, but I think we can significantly improve this.\n\nOne new idea - is there a benefit to doing lookups on filter strings upon loading the data to build an \nindex?\n\nHere's the before-mentioned results:\n--- 2 filters of Mozilla.org's bug database of 260,836 takes 14.2s ---\nslackette:glazedlists$ java -Xmx1000000000 -classpath classes/ \nca.odell.glazedlists.swing.test.TextFilterPerformance mozillabugs.tfpt \nReading input\nRead input, 260836 elements\n\nFilter 0: frameset, expect: 327\nFilter 1: java PC @sun.com, expect: 320\n\nRunning... done. Time: 14187ms\n\n--- and 4 filters with my MP3 collection of 2569 takes 0.8s ---\nslackette:glazedlists$ java -classpath classes/ ca.odell.glazedlists.swing.test.TextFilterPerformance \nmp3collection.tfpt \nReading input\nRead input, 5138 elements\n\nFilter 0: Limp, expect: 79\nFilter 1: Bizkit, expect: 79\nFilter 2: file 128 44100, expect: 508\nFilter 3: iTunes Music jessewilson, expect: 2568\n\nRunning... done. Time: 768ms\n");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("I've looked at this and apparently regex was NOT a genius idea. It's performance was okay but I have \nalready built a simpler better replacement. The new method \"caseInsensitiveIndexOf()\" is just as fast (in \nmy tests).\n\nFrom here, I think it is time to implement something faster.\nI think I will try the Boyer-Moore algorithm as the next step in my performance quest.");
        currentIssue.getDescriptions().add(description);
        description = null;
        issues.add(currentIssue);
        currentIssue = null;
        currentIssue = new Issue();
        currentIssue.setId(new Integer(90));
        currentIssue.setStatus("NEW");
        currentIssue.setPriority(Priority.P5);
        currentIssue.setResolution("");
        currentIssue.setComponent("glazedlists");
        currentIssue.setVersion("0.9.2");
        currentIssue.setAssignedTo("jessewilson");
        currentIssue.setSubcomponent("core");
        currentIssue.setIssueType("ENHANCEMENT");
        currentIssue.setQAContact("jessewilson");
        currentIssue.setShortDescription("SparseList uses multiple nodes when one will do");
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("The innovation of SparseList is that null values do not require a node Object.\n\nThis means that in a list of 10,000, if 3000 elements are null, then only 7000 nodes are required.\n\nIt should also be possible to create a SparseList where sequential non-null values are collapsed into one \n'supernode'. This means that a list of 10,000 where all elements are the same, then only one node will \nbe needed.\n\nThis would be useful to make AbstractFilterList scale better! Currently it uses O(N) to provide filtering \nservices to a list of size N, even if its filtering services are not used. With this strategy, it only requires \nnodes when its filter is in use.\n\nThis will add complexity but should yeild a measurable performance benefit.");
        currentIssue.getDescriptions().add(description);
        description = null;
        issues.add(currentIssue);
        currentIssue = null;
        currentIssue = new Issue();
        currentIssue.setId(new Integer(91));
        currentIssue.setStatus("RESOLVED");
        currentIssue.setPriority(Priority.P3);
        currentIssue.setResolution("FIXED");
        currentIssue.setComponent("glazedlists");
        currentIssue.setVersion("current");
        currentIssue.setAssignedTo("jessewilson");
        currentIssue.setSubcomponent("core");
        currentIssue.setIssueType("DEFECT");
        currentIssue.setQAContact("jessewilson");
        currentIssue.setShortDescription("EventListIterator falls in a loop");
        description = new Description();
        description.setWho("ildella");
        description.setWhen(null);
        description.setText("Sometimes my app hangs up, using 100% CPU.\nI have tracked the problem, and found that the loop happens in\nEventListIterator.listChanged() where the first line is\n\nwhile(listChanges.next())\n\nand I think this is the cause of the loop.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("Additional comments, emailed from Daniele Dellafiore:\n\nI have submitted issues 91, but I can't add comment on it.\nhttps://glazedlists.dev.java.net/issues/show_bug.cgi?id=91\n\nI have some news, so I will write here.\n\nListChanges.next() method falls in the loop.\nWhen the loop occurs, the first call to next fall in the \"if\" part of the if-else statement.\nBeginning from the second call, the \"else\" part is executed infinitely.\n\nThe call sequence is:\n\nWeakReferenceProxy.listChanged()\n\nin this method is called, within else statement\n\nproxyTarget.listChanged(listChanges);\n\nwhere proxyTarget is a EventListIterator instance, and the loop occurs here, because listChanges.next \nalways returns true.\n\nI do not receive any exceptions, so I do not have a stack trace.\n\n\nIf you want to see the loop in action, you can have a look to CVS code of mcube project: run it and try \nto click on the buttons to sort a table. If you click two times quickly on the same button, you can see \nthat applications start using 100% CPU.\n\nI do not exclude that there could be some issue in my code, but right now I have only figured out the \nloop, not it's cause. Maybe you can help me in understanding what could this cause be.\n\nThanks, bye.\n");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("This an excellent bug report led to a very fast fix.\n\nThe problem was that the ListEventAssembler was creating 'reorder' events of size 0. Usually this does \nnot happen because the SortedList does not pass events when its size is 0. But if you have say, an \nEventSelectionModel, it is possible that it will create such events.\n\nThe problem has been solved.\n\nThanks again for the EXCELLENT and HELPFUL bug report.");
        currentIssue.getDescriptions().add(description);
        description = null;
        issues.add(currentIssue);
        currentIssue = null;
        currentIssue = new Issue();
        currentIssue.setId(new Integer(92));
        currentIssue.setStatus("STARTED");
        currentIssue.setPriority(Priority.P3);
        currentIssue.setResolution("");
        currentIssue.setComponent("glazedlists");
        currentIssue.setVersion("0.9.3");
        currentIssue.setAssignedTo("jessewilson");
        currentIssue.setSubcomponent("core");
        currentIssue.setIssueType("TASK");
        currentIssue.setQAContact("jessewilson");
        currentIssue.setShortDescription("Glazed Lists version 0.9.3 release");
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("Glazed Lists requires a release before October 25, 2004.\n\nThis should be a polish-release with the following changes:\n - no more migrationkit\n - Javadoc warnings where appropriate (for untested code, unfinished code, concurrency)\n - Demo as WebStart");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("I've refined the Javadocs for all the public *List classes.\nI've created a migrationkit .jar which is available here:\nhttps://glazedlists.dev.java.net/files/documents/1073/7976/glazedlists-0.8-migrationkit.jar");
        currentIssue.getDescriptions().add(description);
        description = null;
        issues.add(currentIssue);
        currentIssue = null;
        currentIssue = new Issue();
        currentIssue.setId(new Integer(93));
        currentIssue.setStatus("STARTED");
        currentIssue.setPriority(Priority.P2);
        currentIssue.setResolution("");
        currentIssue.setComponent("glazedlists");
        currentIssue.setVersion("0.9.3");
        currentIssue.setAssignedTo("jessewilson");
        currentIssue.setSubcomponent("core");
        currentIssue.setIssueType("DEFECT");
        currentIssue.setQAContact("jessewilson");
        currentIssue.setShortDescription("Multiple source support");
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("Glazed Lists does not support EventLists that have multiple sources.\n\nSee thread, \"ArrayIndexOutOfBoundsException\" on the users@ mailing list.");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("I've added support for multiple sources in Glazed Lists!\n\nThis has required one major change to the API.\nEventList now has a method, getPublisher() which returns an EventListPublisher.\n\nThis is so that EventLists can share EventListPublishers if they are chained. The EventListPublisher keeps \ntrack of all listeners and their dependencies. When a change is forwarded, all dependencies are \nmanaged to ensure the change is propagates in a safe sequence.\n\nThere are still some outstanding issues with this implementation, but it is a good start.\nOutstanding issues:\n - no support for events other than ListEvent\n - no support for CompositeList\n\nHopefully I can fix these issues soon!");
        currentIssue.getDescriptions().add(description);
        description = null;
        issues.add(currentIssue);
        currentIssue = null;
        currentIssue = new Issue();
        currentIssue.setId(new Integer(94));
        currentIssue.setStatus("NEW");
        currentIssue.setPriority(Priority.P5);
        currentIssue.setResolution("");
        currentIssue.setComponent("glazedlists");
        currentIssue.setVersion("0.9.3");
        currentIssue.setAssignedTo("jessewilson");
        currentIssue.setSubcomponent("core");
        currentIssue.setIssueType("DEFECT");
        currentIssue.setQAContact("jessewilson");
        currentIssue.setShortDescription("issues.xml is 104 KB");
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("Glazed Lists .jar file includes a 104 KB file \"issues.xml\" for the demo applet.\n\nIncluding this file is okay. Including 104 KB is ridiculous.\n\nTrim the file and update it to the latest issue set!");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("This is actually only 7KB compressed, but trimming it won't hurt anyway.\n\nAnd updating it is definitely worthwhile.");
        currentIssue.getDescriptions().add(description);
        description = null;
        issues.add(currentIssue);
        currentIssue = null;
        currentIssue = new Issue();
        currentIssue.setId(new Integer(95));
        currentIssue.setStatus("RESOLVED");
        currentIssue.setPriority(Priority.P3);
        currentIssue.setResolution("FIXED");
        currentIssue.setComponent("glazedlists");
        currentIssue.setVersion("0.9.3");
        currentIssue.setAssignedTo("jessewilson");
        currentIssue.setSubcomponent("swing");
        currentIssue.setIssueType("DEFECT");
        currentIssue.setQAContact("jessewilson");
        currentIssue.setShortDescription("TableComparatorChooser breaks when column count changes");
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("TableComparatorChooser breaks violently with a NullPointerException when the number of columns is \nchanged.\n\nInstead, TableComparatorChooser should simply adjust to the column change.\n\nThe only problem with this is that some columns may have extra comparators set for them. Figuring \nout how to do this correctly may be tricky!");
        currentIssue.getDescriptions().add(description);
        description = null;
        description = new Description();
        description.setWho("jessewilson");
        description.setWhen(null);
        description.setText("Fixed! Additional comparators are thrown out when the TableFormat is changed. This may be a drag, \nbut there are much better ways to turn on and off columns if that is to be desired.\n\nSee the mailing list for sample code that uses the TableColumnModel for this purpose:\nhttps://glazedlists.dev.java.net/servlets/ReadMsg?list=users&msgNo=234");
        currentIssue.getDescriptions().add(description);
        description = null;
        issues.add(currentIssue);
        currentIssue = null;
        return issues;
    }
}

/**
 * An additional comment.       
 */
class Description implements TextFilterable {
    private String who = null;
    private Date when = null;
    private String text = null;
    /**
     * Email of person posting long_desc.
     */
    public String getWho() {
        return who;
    }
    public void setWho(String who) {
        this.who = who;
    }
    /**
     * Timestamp when long_desc added ('yyy-mm-dd hh:mm')
     */
    public Date getWhen() {
        return when;
    }
    public void setWhen(Date when) {
        this.when = when;
    }
    /**
     * Free text that comprises the long desc.
     */
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    /**
     * Gets the strings to filter this issue by.
     */
    public void getFilterStrings(List baseList) {
        baseList.add(text);
        baseList.add(who);
    }
}


/**
 * Data pertaining to the issue's activity record.
 */
class Activity {
    private String user = null;
    private Date when = null;
    private String field = null;
    private String fieldDescription = null;
    private String oldValue = null;
    private String newValue = null;
    /**
     * user who performed the action
     */
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }
    /**
     * date the described change was made
     */
    public Date getWhen() {
        return when;
    }
    public void setWhen(Date when) {
        this.when = when;
    }
    /**
     * name of db field (in fielddefs) 
     */
    public String getField() {
        return field;
    }
    public void setField(String field) {
        this.field = field;
    }
    /**
     * description of the database field
     */
    public String getFieldDescription() {
        return fieldDescription;
    }
    public void setFieldDescription(String fieldDescription) {
        this.fieldDescription = fieldDescription;
    }
    /**
     * value changed from
     */
    public String getOldValue() {
        return oldValue;
    }
    public void setOldValue(String oldValue) {
        this.oldValue = oldValue;
    }
    /**
     * value changed to 
     */
    public String getNewValue() {
        return newValue;
    }
    public void setNewValue(String newValue) {
        this.newValue = newValue;
    }
}


/**
 * Data pertaining to attachments.  NOTE - some of these fields
 * are currently unimplemented (ispatch, filename, etc.).
 */
class Attachment {
    private String mimeType = null;
    private String attachId = null;
    private Date date = null;
    private String description = null;
    private String isPatch = null;
    private String filename = null;
    private String submitterId = null;
    private String submitterUsername = null;
    private String data = null;
    private String attachmentIzUrl = null;
    /**
     * Mime type for the attachment.
     */
    public String getMimeType() {
        return mimeType;
    }
    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }
    /**
     * A unique id for this attachment.
     */
    public String getAttachId() {
        return attachId;
    }
    public void setAttachId(String attachId) {
        this.attachId = attachId;
    }
    /**
     * Timestamp of when added 'yyyy-mm-dd hh:mm'
     */
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    /**
     * Short description for attachment.
     */
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * Whether attachment is a patch file.
     */
    public String getIsPatch() {
        return isPatch;
    }
    public void setIsPatch(String isPatch) {
        this.isPatch = isPatch;
    }
    /**
     * Filename of attachment.
     */
    public String getFilename() {
        return filename;
    }
    public void setFilename(String filename) {
        this.filename = filename;
    }
    /**
     * Issuezilla ID of attachement submitter.
     */
    public String getSubmitterId() {
        return submitterId;
    }
    public void setSubmitterId(String submitterId) {
        this.submitterId = submitterId;
    }
    /**
     * username of attachement submitter.
     */
    public String getSubmitterUsername() {
        return submitterUsername;
    }
    public void setSubmitterUsername(String submitterUsername) {
        this.submitterUsername = submitterUsername;
    }
    /**
     * Encoded attachment.
     */
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    /**
     * URL to attachment in iz.
     */
    public String getAttachmentIzUrl() {
        return attachmentIzUrl;
    }
    public void setAttachmentIzUrl(String attachmentIzUrl) {
        this.attachmentIzUrl = attachmentIzUrl;
    }
}
