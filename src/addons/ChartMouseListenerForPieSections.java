/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addons;

import MODEL.DB_Statistics;
import java.awt.Color;
import java.sql.SQLException;
import java.text.DecimalFormat;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartMouseEvent;
import org.jfree.chart.ChartMouseListener;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.entity.ChartEntity;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.jdbc.JDBCPieDataset;

/**
 *
 * @author Ilyas El Bani
 */
public class ChartMouseListenerForPieSections implements ChartMouseListener {

    private DB_Statistics dbStat = new DB_Statistics();

    public ChartMouseListenerForPieSections() {

    }

    @Override
    public void chartMouseClicked(ChartMouseEvent event) {
        ChartEntity entity = event.getEntity();
        String entitiyString = entity.toString();
        String cat = "";
        if (entitiyString.startsWith("PieSection")) {
            cat = entitiyString.substring(entitiyString.indexOf("(") + 1, entitiyString.lastIndexOf(")"));
            System.out.println(cat);
        } else if (entitiyString.startsWith("LegendItemEntity:")) {
            cat = entitiyString.substring(entitiyString.indexOf("=") + 1, entitiyString.indexOf(","));
            System.out.println(cat);
        }
        if (cat != "") {
            try {
                String query
                        = "select A.designation, quantite from article A,detail_commande DC where A.idArticle = DC.idArticle and categorie=\"" + cat + "\";";
                JDBCPieDataset dataset = new JDBCPieDataset(dbStat.getConnexion(), query);
                JFreeChart chart = ChartFactory.createPieChart3D("Ventes par Article " + cat, dataset, true, true, true);
                chart.getTitle().setPaint(CustomColors.lightViolet);

                PiePlot3D P = (PiePlot3D) chart.getPlot();
                //  P.setSimpleLabels(true);
                PieSectionLabelGenerator gen = new StandardPieSectionLabelGenerator(
                        "{0}: {1} ({2})", new DecimalFormat("0"), new DecimalFormat("0%"));
                P.setLabelGenerator(gen);
                P.setBackgroundPaint(Color.white);
                P.setDrawingSupplier(new ChartDrawingSupplier());

                ChartFrame frame = new ChartFrame("Pie Chart", chart);
                frame.setVisible(true);
                frame.setSize(700, 500);
                frame.setLocationRelativeTo(null);

            } catch (SQLException ex) {
                System.out.println("Erreur dans la requete JDBCCategoryDataset PieChart ELEEMNT CATEGORIE " + ex.getMessage());
            }
        }
    }

    @Override

    public void chartMouseMoved(ChartMouseEvent event) {
    }

}
