package chartUtil;

import java.awt.BasicStroke;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.zkoss.zkex.zul.impl.JFreeChartEngine;
import org.zkoss.zul.Chart;

public class StockChartEngine extends JFreeChartEngine {

	private static final long serialVersionUID = 1L;
	public int width = 2;
    public boolean showLine = true;
    public boolean showShape = true;
 
    public boolean prepareJFreeChart(JFreeChart jfchart, Chart chart) {
        LineAndShapeRenderer renderer = (LineAndShapeRenderer) ((CategoryPlot) jfchart.getPlot()).getRenderer();
        renderer.setSeriesStroke(0, new BasicStroke(width));
        renderer.setSeriesStroke(1, new BasicStroke(width));
        renderer.setSeriesStroke(2, new BasicStroke(width));
 
        renderer.setSeriesLinesVisible(0, chart.isThreeD());
        renderer.setSeriesLinesVisible(1, showLine);
        renderer.setSeriesLinesVisible(2, showLine);
 
        renderer.setSeriesShapesVisible(0, showShape);
        renderer.setSeriesShapesVisible(1, showShape);
        renderer.setSeriesShapesVisible(2, showShape);
         
        renderer.setSeriesPaint(0, StockChartColors.COLOR_1);
        renderer.setSeriesPaint(1, StockChartColors.COLOR_2);
        renderer.setSeriesPaint(2, StockChartColors.COLOR_3);
        return false;
    }
 
    public void setWidth(int width) {
        this.width = width;
    }
 
    public void setShowLine(boolean showLine) {
        this.showLine = showLine;
    }
 
    public void setShowShape(boolean showShape) {
        this.showShape = showShape;
    }
}