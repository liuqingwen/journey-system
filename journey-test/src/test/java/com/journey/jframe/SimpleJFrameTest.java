package com.journey.jframe;

import com.google.common.collect.Lists;

import javax.swing.*;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 * @author liuqingwen
 * @date 2018/2/27.
 */
public class SimpleJFrameTest {

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> jframe());
    }

    private static void jframe() {
        JFrame jFrame = new JFrame();
//        jFrame.setSize(200, 300);
//        jFrame.setBounds(400, 300, getDimension().width / 2, getDimension().height / 2);
        jFrame.setExtendedState(Frame.MAXIMIZED_BOTH);
        jFrame.setTitle("天天中彩票");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        jFrame.setBackground(SystemColor.desktop);
//        jFrame.setLocationByPlatform(true);
        LiuJComponent liuJComponent = new LiuJComponent();
        addComponent(jFrame, liuJComponent);
//        JComponent liuShapeComponent = new LiuShapeComponent();
//        liuShapeComponent.setBackground(SystemColor.desktop);
//        addComponent(jFrame, liuShapeComponent);
        jFrame.setVisible(true);
    }

    public static Dimension getDimension() {
        return Toolkit.getDefaultToolkit().getScreenSize();
    }

    public static void addComponent(JFrame jFrame, JComponent... jComponent) {
        if (jComponent != null) {
            Lists.newArrayList(jComponent).forEach(jc -> jFrame.add(jc));
        }
    }

    static class LiuJComponent extends JComponent {

        @Override
        protected void paintComponent(Graphics g) {

            Graphics2D graphics2D = (Graphics2D)g;
            graphics2D.setBackground(Color.BLUE);

            Font apple_braille = new Font("Apple Braille", Font.BOLD, 14);
            graphics2D.setFont(apple_braille);
//            graphics2D.drawString("中国人", 75, 100);

            FontRenderContext fontRenderContext = graphics2D.getFontRenderContext();
            Rectangle2D r = apple_braille.getStringBounds("zhongguoren", fontRenderContext);
            r.setRect(300, 300, 500, 200);
            graphics2D.draw(r);
        }

//        @Override
//        public Dimension getPreferredSize() {
//            return new Dimension(200, 300);
//        }
    }

    static class LiuShapeComponent extends JComponent {

        double leftx = 600, lefty = 400, radius = 200, with = 300, height = 200;

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D graphics2D = (Graphics2D)g;
            graphics2D.setPaint(Color.BLUE.brighter().brighter().brighter());

            // 圆形
            Ellipse2D circle = new Ellipse2D.Double();
            circle.setFrameFromCenter(leftx, lefty, leftx + radius, lefty + radius);
            graphics2D.draw(circle);

            // 直线
            Point2D points = new Point2D.Double(leftx - radius, lefty);
            Point2D pointe = new Point2D.Double(leftx + radius, lefty);
            Line2D line = new Line2D.Double(points, pointe);
            graphics2D.draw(line);

            // 矩形
            Rectangle2D rectangle = new Rectangle.Double(leftx - with / 2, lefty - height / 2, with, height);
            graphics2D.draw(rectangle);

            graphics2D.setPaint(new Color(0, 128, 128));

            // 椭圆
            Ellipse2D ellipse = new Ellipse2D.Double(leftx - with / 2, lefty - height / 2, with, height);
            graphics2D.draw(ellipse);

            Point2D pointLeftTop = new Point2D.Double(leftx - with / 2, lefty - height / 2);
            Point2D pointRightBottom = new Point2D.Double(leftx + with / 2, lefty + height / 2);
            Line2D lineOfOppositeAngles = new Line2D.Double(pointLeftTop, pointRightBottom);
            graphics2D.draw(lineOfOppositeAngles);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(400, 400);
        }
    }

}
