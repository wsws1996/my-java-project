package demo;

import java.awt.Font;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis3D;
import org.jfree.chart.axis.NumberAxis3D;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.data.category.DefaultCategoryDataset;

public class BarDemo {

	public static void main(String[] args) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.addValue(2, "中国", "北京");
		dataset.addValue(6, "中国", "上海");
		dataset.addValue(2, "中国", "深圳");
		dataset.addValue(2, "美国", "华盛顿");
		dataset.addValue(12, "美国", "西雅图");
		dataset.addValue(4, "美国", "纽约");
		dataset.addValue(4, "印度", "新德里");
		JFreeChart chart = ChartFactory.createBarChart3D("用户统计报表（所属单位）",
				"所属单位名称", "数量", dataset, PlotOrientation.VERTICAL, true, true,
				true);
		chart.getTitle().setFont(new Font("宋体", Font.BOLD, 18));
		chart.getLegend().setItemFont(new Font("宋体", Font.BOLD, 15));

		CategoryPlot categoryPlot = (CategoryPlot) chart.getPlot();

		CategoryAxis3D categoryAxis3D = (CategoryAxis3D) categoryPlot
				.getDomainAxis();
		NumberAxis3D numberAxis3D = (NumberAxis3D) categoryPlot.getRangeAxis();

		categoryAxis3D.setTickLabelFont(new Font("宋体", Font.BOLD, 18));
		categoryAxis3D.setLabelFont(new Font("宋体", Font.BOLD, 18));

		numberAxis3D.setLabelFont(new Font("宋体", Font.BOLD, 18));

		numberAxis3D.setAutoTickUnitSelection(false);

		NumberTickUnit unit = new NumberTickUnit(1);
		numberAxis3D.setTickUnit(unit);

		BarRenderer3D barRenderer3D = (BarRenderer3D) categoryPlot
				.getRenderer();

		barRenderer3D.setMaximumBarWidth(0.08);
		
		barRenderer3D.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
	barRenderer3D.setBaseItemLabelsVisible(true);
	barRenderer3D.setBaseItemLabelFont(new Font("宋体", Font.BOLD, 15));
		ChartFrame chartFrame = new ChartFrame("xyz", chart);
		chartFrame.setVisible(true);
		chartFrame.pack();
	}

}
