package org.wang.elec.utils;

import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.struts2.ServletActionContext;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis3D;
import org.jfree.chart.axis.NumberAxis3D;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.data.category.DefaultCategoryDataset;

public class ChartUtils {

	public static String createBarChart(List<Object[]> list) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		if (list!=null&&list.size()>0) {
			for (Object[] o : list) {
				dataset.addValue(Double.parseDouble(o[2].toString()), o[1].toString(), o[0].toString());
			}
		}
		JFreeChart chart = ChartFactory.createBarChart3D("用户统计报表",
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

//		numberAxis3D.setAutoTickUnitSelection(false);
//		NumberTickUnit unit=new NumberTickUnit(1);
//		numberAxis3D.setTickUnit(unit);

		BarRenderer3D barRenderer3D = (BarRenderer3D) categoryPlot
				.getRenderer();

		barRenderer3D.setMaximumBarWidth(0.08);

		barRenderer3D
				.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		barRenderer3D.setBaseItemLabelsVisible(true);
		barRenderer3D.setBaseItemLabelFont(new Font("宋体", Font.BOLD, 15));
		String filename= DateFormatUtils.format(new Date(), "yyyyMMddHHmmss")+".png";
		File file = new File(ServletActionContext.getServletContext().getRealPath("/chart")+"/"+filename);
		try {
			ChartUtilities.saveChartAsPNG(file, chart, 600, 500);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return filename;
	}

}
