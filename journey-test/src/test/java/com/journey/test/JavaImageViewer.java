package com.journey.test;

import org.junit.Test;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * @author liuqingwen
 * @date 2018/1/16.
 */
public class JavaImageViewer {

    public static strictfp void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new ImageViewerFrame();
            frame.setTitle("ImageViewer");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }

    @Test
    public void test() {

        int i = 1000_000_000;
        System.out.println(i);
    }

}

class ImageViewerFrame extends JFrame {

    private JLabel label;
    private JFileChooser chooser;
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 400;

    public ImageViewerFrame() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        label = new JLabel();
        add(label);

        chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("."));

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menu = new JMenu("File");
        menuBar.add(menu);

        JMenuItem optionItem = new JMenuItem("Open");
        menu.add(optionItem);

        optionItem.addActionListener((event) -> {
            int result = chooser.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                String name = chooser.getSelectedFile().getPath();
                label.setIcon(new ImageIcon(name));
            }
        });

        JMenuItem exitItem = new JMenuItem("Exit");
        menu.add(exitItem);
        exitItem.addActionListener(event -> System.exit(0));
    }


}
