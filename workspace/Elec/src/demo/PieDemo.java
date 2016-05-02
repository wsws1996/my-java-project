package demo;

import java.awt.Font;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;

public class PieDemo {

	public static void main(String[] args) {
		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("北京",12);
		dataset.setValue("上海",6);
		dataset.setValue("深圳",2);
		
		JFreeChart chart = ChartFactory.createPieChart3D("用户统计报表（所属单位）",
				dataset ,  true, true,
				true);
		chart.getTitle().setFont(new Font("宋体", Font.BOLD, 18));
		chart.getLegend().setItemFont(new Font("宋体", Font.BOLD, 15));

		PiePlot3D piePlot3D = (PiePlot3D) chart.getPlot();
		piePlot3D.setLabelFont(new Font("宋体", Font.BOLD, 15));
		
		String labelFormat="{0} {1} ({2})";
		piePlot3D.setLabelGenerator(new StandardPieSectionLabelGenerator(labelFormat));
//		barRenderer3D
//				.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
//		barRenderer3D.setBaseItemLabelsVisible(true);
//		barRenderer3D.setBaseItemLabelFont(new Font("宋体", Font.BOLD, 15));
		ChartFrame chartFrame = new ChartFrame("xyz", chart);
		chartFrame.setVisible(true);
		chartFrame.pack();
	}

}
