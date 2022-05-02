/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class RenderTable extends DefaultTableCellRenderer {

    public Component getTableCellRendererComponent(JTable table,
            Object value,
            boolean isSelected,
            boolean hasFocus,
            int row,
            int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if (EvaluarPar(row)) {
            this.setOpaque(true);
            Color myColor = new Color(56, 103, 214);
            this.setBackground(myColor);
            this.setForeground(new Color(248, 248, 255));
            //table.setFillsViewportHeight(true);
            //table.getTableHeader().setOpaque(false);
            //table.setFont(new Font("Arial",Font.BOLD,14));
            //table.getTableHeader().setBackground(new Color(25,42,86));
            //table.getTableHeader().setForeground(new Color(255,255,255));
            //table.setRowHeight(25);
            //table.setSelectionBackground(new Color(45,52,54));
            //table.setSelectionForeground(new Color(248,248,255));
        } else {
            // Restaurar los valores por defecto
            this.setOpaque(true);
            Color myColor = new Color(100, 135, 217);
            this.setBackground(myColor);
            this.setForeground(new Color(248, 248, 255));
            //table.setFillsViewportHeight(true);
            //table.getTableHeader().setOpaque(false);
            //table.setFont(new Font("Arial",Font.BOLD,14));
            //table.getTableHeader().setBackground(new Color(25,42,86));
            //table.getTableHeader().setForeground(new Color(255,255,255));
            //table.setRowHeight(25);
            //table.setSelectionBackground(new Color(45,52,54));
            //table.setSelectionForeground(new Color(248,248,255));
        }

        return this;
    }

    public boolean EvaluarPar(int numero) {
        return (numero % 2 == 0);
    }
}
