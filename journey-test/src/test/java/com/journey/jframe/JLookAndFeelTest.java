package com.journey.jframe;

import javax.swing.*;

/**
 * 观感
 *
 * 观感实践 在 JButtonTest.java 中
 *
 * @author liuqingwen
 * @date 2018/2/28.
 */
public class JLookAndFeelTest {

    public static void main(String[] args) {


        UIManager.LookAndFeelInfo[] installedLookAndFeels = UIManager.getInstalledLookAndFeels();
        for (UIManager.LookAndFeelInfo ui : installedLookAndFeels) {
            System.out.println(ui.getClassName() + "---" + ui.getName());
        }


    }

}
