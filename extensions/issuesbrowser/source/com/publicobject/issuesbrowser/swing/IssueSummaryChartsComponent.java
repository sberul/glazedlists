/* Glazed Lists                                                 (c) 2003-2006 */
/* http://publicobject.com/glazedlists/                      publicobject.com,*/
/*                                                     O'Dell Engineering Ltd.*/
package com.publicobject.issuesbrowser.swing;

import ca.odell.glazedlists.EventList;
import ca.odell.glazedlists.FunctionList;
import ca.odell.glazedlists.GlazedLists;
import ca.odell.glazedlists.impl.swing.SwingThreadProxyEventList;
import ca.odell.glazedlists.jfreechart.EventListPieDataset;
import com.publicobject.issuesbrowser.Issue;
import com.publicobject.issuesbrowser.OpenIssuesByMonthCategoryDataset;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.renderer.category.DefaultCategoryItemRenderer;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.PieDataset;
import org.jfree.data.category.CategoryDataset;
import org.jfree.text.TextBlock;
import org.jfree.ui.RectangleEdge;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * This component is placed below the issues table and is shown when no issues
 * are selected in the issues table. It is meant to demonstrate the binding of
 * Glazed Lists to the JFreeChart project.
 *
 * @author James Lemieux
 */
class IssueSummaryChartsComponent {

    // the panel which displays Issues By Status
    private final ChartPanel pieChartPanel_IssuesByStatus;

    // the panel which displays Open Issues Over Time
    private final ChartPanel lineChartPanel_OpenIssuesOverTime;

    // the panel containing all ChartPanels
    private final JPanel allChartsPanel = new JPanel(new GridBagLayout());

    // map each unique Issue status to a representative color
    private static final Map<String,Paint> issuesStatusToPaintMap = new HashMap<String,Paint>();
    static {
        issuesStatusToPaintMap.put("NEW", Color.RED);
        issuesStatusToPaintMap.put("STARTED", Color.ORANGE);
        issuesStatusToPaintMap.put("CLOSED", Color.YELLOW);
        issuesStatusToPaintMap.put("RESOLVED", Color.GREEN);
        issuesStatusToPaintMap.put("UNCONFIRMED", Color.BLUE);
        issuesStatusToPaintMap.put("VERIFIED", Color.PINK);
        issuesStatusToPaintMap.put("REOPENED", Color.MAGENTA);
    }

    public IssueSummaryChartsComponent(EventList<Issue> issuesList) {
        // build a PieDataset representing Issues by Status
        final Comparator<Issue> issuesByStatusGrouper = GlazedLists.beanPropertyComparator(Issue.class, "status");
        final StatusFunction statusFunction = new StatusFunction();
        final PieDataset issuesByStatusDataset = new EventListPieDataset(new SwingThreadProxyEventList<Issue>(issuesList), statusFunction, issuesByStatusGrouper);

        // build a Pie Chart and a panel to display it
        final JFreeChart pieChart_IssuesByStatus = new JFreeChart("Issues By Status", new CustomPiePlot(issuesByStatusDataset));
        this.pieChartPanel_IssuesByStatus = new ChartPanel(pieChart_IssuesByStatus, true);

        // build a Line Chart and a panel to display it
        final JFreeChart lineChart_OpenIssuesOverTime = ChartFactory.createLineChart("Open Issues Over Time", "Time", "Open Issues", new OpenIssuesByMonthCategoryDataset(issuesList), PlotOrientation.VERTICAL, true, true, false);
        final CategoryPlot categoryPlot = lineChart_OpenIssuesOverTime.getCategoryPlot();
        categoryPlot.setDomainAxis(new CustomCategoryAxis());
        categoryPlot.setRenderer(new CustomCategoryItemRenderer(categoryPlot.getDataset()));
        this.lineChartPanel_OpenIssuesOverTime = new ChartPanel(lineChart_OpenIssuesOverTime, true);

        // add all ChartPanels to a master panel
        this.allChartsPanel.add(this.pieChartPanel_IssuesByStatus, new GridBagConstraints(0, 0, 1, 1, 0.4, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
        this.allChartsPanel.add(this.lineChartPanel_OpenIssuesOverTime, new GridBagConstraints(1, 0, 1, 1, 0.6, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
    }

    /**
     * Returns the component that displays the charts.
     */
    public JComponent getComponent() {
        return this.allChartsPanel;
    }

    /**
     * A function to extract the status from the first element in a list of
     * {@link Issue} objects that share the same status.
     */
    private static class StatusFunction implements FunctionList.Function<List,Comparable> {
        public Comparable evaluate(List sourceValue) {
            return ((Issue) sourceValue.get(0)).getStatus();
        }
    }

    /**
     * This custom PiePlot selects Paint values based on section data.
     */
    private static class CustomPiePlot extends PiePlot {
        public CustomPiePlot(PieDataset dataset) {
            super(dataset);
        }

        public Paint getSectionPaint(int section) {
            final String rowKeyForSeries = (String) this.getDataset().getKey(section);
            return issuesStatusToPaintMap.get(rowKeyForSeries);
        }
    }

    /**
     * This custom renderer selects Paint values based on series data.
     */
    private static class CustomCategoryItemRenderer extends DefaultCategoryItemRenderer {
        private final CategoryDataset dataset;

        public CustomCategoryItemRenderer(CategoryDataset dataset) {
            this.dataset = dataset;
            this.setShapesVisible(false);
        }

        public Paint getSeriesPaint(int series) {
            final String rowKeyForSeries = (String) this.dataset.getRowKey(series);
            return issuesStatusToPaintMap.get(rowKeyForSeries);
        }
    }

    /**
     * This custom CategoryAxis formats the labels of the Date axis as desired.
     */
    private static class CustomCategoryAxis extends CategoryAxis {
        private static final DateFormat DATE_FORMAT = new SimpleDateFormat("MMM yyyy");

        // map each Date to a pretty formatted display value
        private final Map<Comparable,String> labelMap = new HashMap<Comparable,String>();

        public CustomCategoryAxis() {
            // display the labels vertically rather than horizontally
            this.setCategoryLabelPositions(CategoryLabelPositions.UP_90);
        }

        protected TextBlock createLabel(Comparable category, float width, RectangleEdge edge, Graphics2D g2) {
            // check the cache for an existing formatted string
            String labelString = labelMap.get(category);

            // formate the date string and cache it
            if (labelString == null) {
                labelString = makeColumnString((Date) category);
                labelMap.put(category, labelString);
            }

            // prepare the label using the labelString
            return super.createLabel(labelString, width, edge, g2);
        }

        /**
         * Returns a formatted version of the given <code>date</code>.
         */
        private static String makeColumnString(Date date) {
            return DATE_FORMAT.format(date).toUpperCase();
        }
    }
}