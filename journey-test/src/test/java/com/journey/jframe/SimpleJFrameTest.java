package com.journey.jframe;

import javax.swing.*;
import java.awt.*;

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
        jFrame.setBounds(400, 300, 200, 300);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        jFrame.setLocationByPlatform(true);
        jFrame.setVisible(true);
    }

}
