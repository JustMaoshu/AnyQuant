package presentation.graphs;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieToolTipGenerator;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;
import javax.swing.*;

/**
 * Created by zmj on 2016/5/3.
 */
public class ThreeDPieChart {

  public JPanel generateThreeDPieChart(String title,String name[],double data[]){
            DefaultPieDataset dataset = new DefaultPieDataset();
            int length=data.length;
            for(int i=0;i<length;i++){
                 dataset.setValue(name[i],data[i]);
            }
            JFreeChart chart = ChartFactory.createPieChart3D(title,dataset, true, true, false);
            chart.setBackgroundPaint(Color.gray);
            // 设置标题文字
            ChartFrame frame = new ChartFrame(title,chart, true);
            PiePlot3D plot = (PiePlot3D) chart.getPlot();
            //显示名称：数值
            plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}:{1}"));
            // 图形边框颜色
            plot.setBaseSectionOutlinePaint(Color.GRAY);
            // plot.setBaseSectionPaint(Color.WHITE);
            // 图形边框粗细
            plot.setBaseSectionOutlineStroke(new BasicStroke(1.0f));

            // 指定图片的透明度(0.0-1.0)
            plot.setForegroundAlpha(1f);
            // 指定显示的饼图上圆形(false)还椭圆形(true)
            plot.setCircular(true);

            // 设置第一个 饼块section 的开始位置，默认是12点钟方向
            plot.setStartAngle(360);
            // 设置鼠标悬停提示
            plot.setToolTipGenerator(new StandardPieToolTipGenerator());
            // 设置突出显示的数据块
            plot.setExplodePercent("One", 0.1D);
            // 设置饼图各部分标签字体
            plot.setLabelFont(new Font("宋体", Font.BOLD, 20));
            // 设置分饼颜色
            plot.setSectionPaint(0, new Color(244, 194, 144));
            // plot.setSectionPaint("2", new Color(144, 233, 144));
            // 设置图例说明Legend上的文字
            chart.getLegend().setItemFont(new Font("宋体", Font.PLAIN, 18));
            // 定义字体格式
            Font font = new java.awt.Font("黑体", java.awt.Font.CENTER_BASELINE,30);
            TextTitle title1 = new TextTitle(title);
            title1.setFont(font);
            chart.setTitle(title1);
            ChartPanel chartPanel=new ChartPanel(chart);
            return chartPanel;
        }

    public static void main(String[] args){
        String name[]={"管理人员","市场人员","开发人员","后勤人员","财务人员"};
        double data[]={25,35,20,5,15};
        JFrame jFrame=new JFrame();
        ThreeDPieChart chart=new ThreeDPieChart();
        jFrame.add(chart.generateThreeDPieChart("aaa",name,data));
        jFrame.pack();
        jFrame.setVisible(true);
    }
}
