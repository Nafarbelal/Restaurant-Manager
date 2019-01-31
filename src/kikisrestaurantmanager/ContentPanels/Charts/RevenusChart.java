/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kikisrestaurantmanager.ContentPanels.Charts;

import MODEL.DB_Statistics;
import addons.CustomColors;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

/**
 *
 * @author Ilyas El Bani
 */
public class RevenusChart {

    DB_Statistics dbStat = new DB_Statistics();
    public ChartPanel chartPanel = null;

    public RevenusChart(String type) {
        switch (type) {
            case "ParJour":
                loadCharteParJour();
                break;
            case "ParSemaine":
                loadCharteParSemaine();
                break;
            case "ParMois":
                loadCharteParMois();
                break;

        }
    }

    private void loadCharteParJour() {
        try {
            TimeSeries serieRevenus = new TimeSeries("Revenus");
            ResultSet Rs = dbStat.RevenusParJour();
            while (Rs.next()) {
                Date time = Rs.getDate("Date");
                int value = Rs.getInt("MntTotal");
                serieRevenus.add(new Day(time), value);
            }
            TimeSeriesCollection dataset = new TimeSeriesCollection(serieRevenus);

            JFreeChart chart = ChartFactory.createTimeSeriesChart("Revenus Total Par Jour", "Date", "Revenu", dataset);
            XYPlot plot = chart.getXYPlot();
            plot.setDomainPannable(true);
            plot.getRangeAxis().setStandardTickUnits(NumberAxis.createIntegerTickUnits());

            XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
            renderer.setSeriesPaint(0, Color.RED);
            renderer.setSeriesStroke(0, new BasicStroke(4.0f));
            plot.setBackgroundPaint(Color.white);
            plot.setRangeGridlinesVisible(true);
            plot.setRangeGridlinePaint(Color.BLACK);

            plot.setDomainGridlinesVisible(true);
            plot.setDomainGridlinePaint(Color.BLACK);
            plot.setRenderer(renderer);
            DateAxis dateAxis = (DateAxis) chart.getXYPlot().getDomainAxis();
            Calendar cal = Calendar.getInstance();
            cal.setTime(new java.util.Date());
            dateAxis.setMaximumDate(cal.getTime());

            cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH) - 7);
            dateAxis.setMinimumDate(cal.getTime());

            chart.getTitle().setPaint(CustomColors.lightViolet);
            //  P.setSimpleLabels(true);
            chartPanel = new ChartPanel(chart);
            chartPanel.setRangeZoomable(false);
            /* chartPanel.setDomainZoomable(false);*/
            chartPanel.setMouseWheelEnabled(true);

        } catch (SQLException ex) {
            System.out.println("Erreur dans la requete JDBCCategoryDataset PieChart " + ex.getMessage());
        }
    }

    private void loadCharteParMois() {
        try {
            TimeSeries serieRevenus = new TimeSeries("Revenus");
            ResultSet Rs = dbStat.RevenusParMois();
            while (Rs.next()) {
                Date time = Rs.getDate("Date");
                int value = Rs.getInt("MntTotal");
                serieRevenus.add(new Day(time), value);
            }
            TimeSeriesCollection dataset = new TimeSeriesCollection(serieRevenus);

            JFreeChart chart = ChartFactory.createTimeSeriesChart("Revenus Total Par Mois", "Date", "Revenu", dataset);
            XYPlot plot = chart.getXYPlot();
            plot.setDomainPannable(true);
            plot.getRangeAxis().setStandardTickUnits(NumberAxis.createIntegerTickUnits());

            XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
            renderer.setSeriesPaint(0, Color.RED);
            renderer.setSeriesStroke(0, new BasicStroke(4.0f));
            plot.setBackgroundPaint(Color.white);
            plot.setRangeGridlinesVisible(true);
            plot.setRangeGridlinePaint(Color.BLACK);

            plot.setDomainGridlinesVisible(true);
            plot.setDomainGridlinePaint(Color.BLACK);
            plot.setRenderer(renderer);
            DateAxis dateAxis = (DateAxis) chart.getXYPlot().getDomainAxis();
            Calendar cal = Calendar.getInstance();
            cal.setTime(new java.util.Date());
            // dateAxis.setMaximumDate(cal.getTime());
            dateAxis.setDateFormatOverride(new SimpleDateFormat("MMM yyyy"));
            // cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH) - 7);
            //dateAxis.setMinimumDate(cal.getTime());

            chart.getTitle().setPaint(CustomColors.lightViolet);
            //  P.setSimpleLabels(true);
            chartPanel = new ChartPanel(chart);
            chartPanel.setRangeZoomable(false);
            /* chartPanel.setDomainZoomable(false);*/
            chartPanel.setMouseWheelEnabled(true);

        } catch (SQLException ex) {
            System.out.println("Erreur dans la requete JDBCCategoryDataset PieChart " + ex.getMessage());
        }
    }

    private void loadCharteParSemaine() {
        try {
            TimeSeries serieRevenus = new TimeSeries("Revenus");
            ResultSet Rs = dbStat.RevenusParSemaine();
            int sz = Rs.getFetchSize();
            while (Rs.next()) {
                Date time = Rs.getDate("Date");
                int value = Rs.getInt("MntTotal");
                serieRevenus.add(new Day(time), value);
                System.out.println("====>" + time + "    " + value);
            }
            TimeSeriesCollection dataset = new TimeSeriesCollection(serieRevenus);
            JFreeChart chart = ChartFactory.createTimeSeriesChart("Revenus Total Par Semaine", "Date", "Revenu", dataset);
            XYPlot plot = chart.getXYPlot();
            plot.setDomainPannable(true);
            plot.getRangeAxis().setStandardTickUnits(NumberAxis.createIntegerTickUnits());

            XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
            renderer.setSeriesPaint(0, Color.RED);
            renderer.setSeriesStroke(0, new BasicStroke(4.0f));
            plot.setBackgroundPaint(Color.white);
            plot.setRangeGridlinesVisible(true);
            plot.setRangeGridlinePaint(Color.BLACK);

            plot.setDomainGridlinesVisible(true);
            plot.setDomainGridlinePaint(Color.BLACK);
            plot.setRenderer(renderer);
            DateAxis dateAxis = (DateAxis) chart.getXYPlot().getDomainAxis();
            Calendar cal = Calendar.getInstance();
            cal.setTime(new java.util.Date());
            // dateAxis.setMaximumDate(cal.getTime());
            dateAxis.setDateFormatOverride(new SimpleDateFormat("w - yyyy"));
            // cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH) - 7);
            //dateAxis.setMinimumDate(cal.getTime());

            chart.getTitle().setPaint(CustomColors.lightViolet);
            //  P.setSimpleLabels(true);
            chartPanel = new ChartPanel(chart);
            chartPanel.setRangeZoomable(false);
            /* chartPanel.setDomainZoomable(false);*/
            chartPanel.setMouseWheelEnabled(true);

        } catch (SQLException ex) {
            System.out.println("Erreur dans la requete JDBCCategoryDataset PieChart " + ex.getMessage());
        }
    }

    public ChartPanel getChartPanel() {
        return chartPanel;
    }
    
    
}
