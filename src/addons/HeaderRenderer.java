/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addons;

import java.awt.Component;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Ilyas El Bani
 */
public class HeaderRenderer implements TableCellRenderer {

    TableCellRenderer renderer;
    DefaultTableCellRenderer defaultRenderer;


    public HeaderRenderer(JTable table) {
        renderer = (TableCellRenderer) table.getTableHeader().getDefaultRenderer();
        defaultRenderer = (DefaultTableCellRenderer) renderer;
        defaultRenderer.setHorizontalAlignment(JLabel.CENTER);
    }

    @Override
    public Component getTableCellRendererComponent(
            JTable table, Object value, boolean isSelected,
            boolean hasFocus, int row, int col) {
        return defaultRenderer.getTableCellRendererComponent(
                table, value, isSelected, hasFocus, row, col);
    }
}

