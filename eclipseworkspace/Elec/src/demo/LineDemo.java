package demo;

import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Shape;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

public class LineDemo {

	public static void main(String[] args) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.addValue(12, "中国", "北京");
		dataset.addValue(6, "中国", "上海");
		dataset.addValue(2, "中国", "天津");
		dataset.addValue(1, "美国", "上海");
		dataset.addValue(2, "美国", "北京");
		dataset.addValue(3, "美国", "天津");
		JFreeChart chart = ChartFactory.createLineChart("用户统计报表（所属单位）",
				"所属单位名称", "数量", dataset, PlotOrientation.VERTICAL, true, true,
				true);
		chart.getTitle().setFont(new Font("宋体", Font.BOLD, 18));
		chart.getLegend().setItemFont(new Font("宋体", Font.BOLD, 15));

		CategoryPlot categoryPlot = (CategoryPlot) chart.getPlot();

		CategoryAxis categoryAxis = (CategoryAxis) categoryPlot.getDomainAxis();
		NumberAxis numberAxis = (NumberAxis) categoryPlot.getRangeAxis();

		categoryAxis.setTickLabelFont(new Font("宋体", Font.BOLD, 18));
		categoryAxis.setLabelFont(new Font("宋体", Font.BOLD, 18));

		numberAxis.setLabelFont(new Font("宋体", Font.BOLD, 18));

		numberAxis.setAutoTickUnitSelection(false);

		NumberTickUnit unit = new NumberTickUnit(1);
		numberAxis.setTickUnit(unit);

		LineAndShapeRenderer lineAndShapeRenderer = (LineAndShapeRenderer) categoryPlot
				.getRenderer();

		lineAndShapeRenderer
				.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		lineAndShapeRenderer.setBaseItemLabelsVisible(true);
		lineAndShapeRenderer
				.setBaseItemLabelFont(new Font("宋体", Font.BOLD, 15));

		Shape shape = new Rectangle(10, 10);
		lineAndShapeRenderer.setSeriesShape(0, shape);
		lineAndShapeRenderer.setSeriesShapesVisible(0, true);
		
		lineAndShapeRenderer.setSeriesShape(1, shape);
		lineAndShapeRenderer.setSeriesShapesVisible(1, true);
		ChartFrame chartFrame = new ChartFrame("图表", chart);
		chartFrame.setVisible(true);
		chartFrame.pack();
	}

}
