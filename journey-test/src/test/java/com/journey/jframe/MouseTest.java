package com.journey.jframe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

/**
 * @author liuqingwen
 * @date 2018/3/3.
 */
public class MouseTest {

    public static void main(String[] args) {

        JFrame jFrame = new MouseFrame();
        jFrame.setExtendedState(Frame.MAXIMIZED_BOTH);
        jFrame.setTitle("天天中彩票");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);


    }


    public static class MouseFrame extends JFrame {
        public MouseFrame () {
            add(new MouseComponent());
            pack();
        }
    }


    public static class MouseComponent extends JComponent {

        private static final int SIDELENGTH = 10;
        private ArrayList<Rectangle2D> squares;
        private Rectangle2D current;
        public MouseComponent() {
            squares = new ArrayList<>();
            current = null;
            addMouseListener(new MouseHandler());
            addMouseMotionListener(new MouseMotionHandler());
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(300, 200);
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D graphics2D = (Graphics2D)g;
            for (Rectangle2D r : squares) {
                graphics2D.draw(r);
            }
        }

        public Rectangle2D find(Point2D point2D) {
            for (Rectangle2D rectangle2D : squares) {
                if (rectangle2D.contains(point2D)) return rectangle2D;
            }
            return null;
        }

        public void add(Point2D point2D) {
            double x = point2D.getX();
            double y = point2D.getY();

            current = new Rectangle2D.Double(x - SIDELENGTH / 2, y - SIDELENGTH / 2, SIDELENGTH, SIDELENGTH);
            squares.add(current);
            repaint();
        }

        public void remove(Rectangle2D rectangle2D) {
            if (rectangle2D == null) return ;
            if (rectangle2D == current) current = null;
            squares.remove(rectangle2D);
            repaint();
        }

        public class MouseHandler extends MouseAdapter {

            @Override
            public void mouseClicked(MouseEvent e) {
                current = find(e.getPoint());
                if (current == null) add(e.getPoint());
            }

            @Override
            public void mousePressed(MouseEvent e) {
                current = find(e.getPoint());
                if (current != null && e.getClickCount() >=2) remove(current);
            }
        }

        public class MouseMotionHandler implements MouseMotionListener {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (find(e.getPoint()) == null) setCursor(Cursor.getDefaultCursor());
                else setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                if (current != null) {
                    int x = e.getX();
                    int y = e.getY();

                    current.setFrame(x - SIDELENGTH / 2, y - SIDELENGTH / 2, SIDELENGTH, SIDELENGTH);
                    repaint();
                }
            }
        }

    }

}
