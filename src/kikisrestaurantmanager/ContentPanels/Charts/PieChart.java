/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kikisrestaurantmanager.ContentPanels.Charts;

import MODEL.DB_Statistics;
import addons.ChartDrawingSupplier;
import addons.ChartMouseListenerForPieSections;
import addons.CustomColors;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GridLayout;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.jdbc.JDBCPieDataset;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

/**
 *
 * @author Ilyas El Bani
 */
public class PieChart {

    DB_Statistics dbStat = new DB_Statistics();
    public ChartPanel chartPanel = null;
    String debutDate;
    String finDate;

    public PieChart(String debutDate, String finDate) {
        this.debutDate = debutDate;
        this.finDate = finDate;
        loadPieChart1();

    }

    private void loadPieChart1() {
        String query = "select A.Categorie, SUM(quantite) from article A,detail_commande DC,Commande C where A.idArticle = DC.idArticle and DC.idCommande = C.idCommande and C.date >=\"" + debutDate + "\" and C.date<=\"" + finDate + "\" group by categorie;";
        try {
            JDBCPieDataset dataset = new JDBCPieDataset(dbStat.getConnexion(), query);
            JFreeChart chart = ChartFactory.createPieChart3D("Ventes Par Catégorie", dataset, true, true, true);
            //DESIGN
            chart.getTitle().setPaint(CustomColors.lightViolet);
            PiePlot3D P = (PiePlot3D) chart.getPlot();
            //  P.setSimpleLabels(true);
            PieSectionLabelGenerator gen = new StandardPieSectionLabelGenerator(
                    "{0}: {1} ({2})", new DecimalFormat("0"), new DecimalFormat("0%"));
            P.setLabelGenerator(gen);
            P.setBackgroundPaint(Color.white);
            P.setDrawingSupplier(new ChartDrawingSupplier());
            //Fin DESIGN 

            chartPanel = new ChartPanel(chart);
            chartPanel.addChartMouseListener(new ChartMouseListenerForPieSections(debutDate, finDate));

        } catch (SQLException ex) {
            System.out.println("Erreur dans la requete JDBCCategoryDataset PieChart " + ex.getMessage());
        }
    }

    public ChartPanel getChartPanel() {
        return chartPanel;
    }

}
