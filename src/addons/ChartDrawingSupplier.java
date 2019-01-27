/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// Source :  https://stackoverflow.com/questions/13009349/how-to-change-pie-chart-colors-of-jfreechart
package addons;

import java.awt.Color;
import java.awt.Paint;
import org.jfree.chart.plot.DefaultDrawingSupplier;

/**
 *
 * @author Ilyas El Bani
 */
public class ChartDrawingSupplier extends DefaultDrawingSupplier {

    public Paint[] paintSequence;
    public int paintIndex;
    public int fillPaintIndex;

    {
        paintSequence = new Paint[]{
            /*
            (47,50,68)
            (40,64,81)
            (29,79,89)
            (21,93,92)
            (31,107,89)
            (55,120,81)
            (85,131,71)
            (120,140,62)
            (157,146,58)
            (196,150,64)
             */
            new Color(0x0077c8),
            new Color(0xda1884),
            new Color(0xe4002b),
            new Color(0xfe5000),
            new Color(0xefdf00),
            new Color(0x84bd00),
            new Color(0x009f4d),
            new Color(0x00205b),
            new Color(0x005670),
            new Color(0x4298b5),
            new Color(0x8db9ca),
            new Color(0x0085ad),
            new Color(0x48a9c5),
            new Color(0x74d2e7),
            new Color(0xa51890),
            new Color(0x008eaa),};
    }

    @Override
    public Paint getNextPaint() {
        Paint result
                = paintSequence[paintIndex % paintSequence.length];
        paintIndex++;
        return result;
    }

    @Override
    public Paint getNextFillPaint() {
        Paint result
                = paintSequence[fillPaintIndex % paintSequence.length];
        fillPaintIndex++;
        return result;
    }
}
