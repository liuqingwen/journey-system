package com.journey.jframe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author liuqingwen
 * @date 2018/2/27.
 */
public class JButtonTest {

    public static void main(String[] args) {

        JFrame jFrame = new ButtonJFrame();
        jFrame.setExtendedState(Frame.MAXIMIZED_BOTH);
        jFrame.setTitle("天天中彩票");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);

    }

    private static void addComponent(JFrame jFrame, JComponent... jComponents) {
        if (jComponents == null) return ;
        for (JComponent jComponent : jComponents) {
            jFrame.add(jComponent);
        }
    }

    private static void addComponent(JComponent jComponent, JComponent... jComponents) {
        if (jComponents == null) return ;
        for (JComponent jComponent1 : jComponents) {
            jComponent.add(jComponent1);
        }
    }

    static class ButtonJFrame extends JFrame {

        JPanel jPanel;

        public ButtonJFrame() throws HeadlessException {

            jPanel = new ButtonPanel();
            addComponent(this, jPanel);
            addComponent(jPanel, new MyButton("Yellow", (actionEvent) -> {
                        try {
                            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
                            SwingUtilities.updateComponentTreeUI(this);
                            jPanel.setBackground(Color.YELLOW);
                        }catch (Exception e) {}
                    }),
                    new MyButton("Blue", (actionEvent) -> {
                        try {
                            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
                            SwingUtilities.updateComponentTreeUI(this);
                            jPanel.setBackground(Color.BLUE);
                        }catch (Exception e) {}
                    }),
                    new MyButton("Red", (actionEvent) ->  {
                        try {
                            UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
                            SwingUtilities.updateComponentTreeUI(this);
                            jPanel.setBackground(Color.RED);
                        }catch (Exception e) {}
                    }),
                    new MyButton("还原", actionEvent -> {
                        try {
                            UIManager.setLookAndFeel("com.apple.laf.AquaLookAndFeel");
                            SwingUtilities.updateComponentTreeUI(this);
                            jPanel.setBackground(Color.GRAY);
                        }catch (Exception e) {}
                    })
            );

            InputMap inputMap = jPanel.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
            inputMap.put(KeyStroke.getKeyStroke("control Y"), "jPanel.YELLOW");
            inputMap.put(KeyStroke.getKeyStroke("control B"), "jPanel.BLUE");
            inputMap.put(KeyStroke.getKeyStroke("control R"), "jPanel.RED");

            ActionMap actionMap = jPanel.getActionMap();
            actionMap.put("jPanel.YELLOW", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    jPanel.setBackground(Color.YELLOW);
                }
            });
            actionMap.put("jPanel.BLUE", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    jPanel.setBackground(Color.BLUE);
                }
            });
            actionMap.put("jPanel.RED", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    jPanel.setBackground(Color.RED);
                }
            });
        }

        @Override
        public void paintComponents(Graphics g) {
            super.paintComponents(g);
        }

    }

    static class ButtonPanel extends JPanel {

        public ButtonPanel() {
            super();
        }

    }

    static class MyButton extends JButton {

        public MyButton(String name, ActionListener actionListener) {
            super(name);
            addActionListener(actionListener);
        }

    }

}
