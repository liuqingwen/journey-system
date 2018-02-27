package com.journey.jframe;

import java.awt.*;
import java.util.Arrays;

/**
 * @author liuqingwen
 * @date 2018/2/27.
 */
public class GraphicsEnvironmentTest {

    public static void main(String[] args) {


        GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] availableFontFamilyNames = graphicsEnvironment.getAvailableFontFamilyNames();
        System.out.println(availableFontFamilyNames.length);
        System.out.println(Arrays.toString(availableFontFamilyNames));


    }

}
