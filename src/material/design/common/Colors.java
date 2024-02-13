/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package material.design.common;




/**
 *
 * @author DMulders
 */
public class Colors {
    
    
    public static javafx.scene.paint.Color getOnColor(javafx.scene.paint.Color bgColor){
        int[] rgb = getRGB(bgColor);
        double luminance = ((0.299 * (double)rgb[0]) + (0.587 * (double)rgb[1]) + (0.114 * rgb[2]))/255.0;
        if(luminance > 0.5){
            return javafx.scene.paint.Color.BLACK;
        }else{
            return javafx.scene.paint.Color.WHITE;
        }
    }
    
    

    public static javafx.scene.paint.Color getWithAlpha(javafx.scene.paint.Color c, double opacity) {
        return javafx.scene.paint.Color.web(hexRGB(c), opacity);
    }



    public static String toCssColor(javafx.scene.paint.Color color) {
        if (color.getOpacity() < 1.0) {
            int[] rgb = getRGB(color);
            return "rgba(" + String.valueOf(rgb[0]) + ", " + String.valueOf(rgb[1] + ", " + String.valueOf(rgb[2]) + ", " + Strings.d2(color.getOpacity())) + ")";
        } else {
            return hexRGB(color);
        }
    }



    public static javafx.scene.paint.Color hexToPaint(String hex) {
        int[] rgb = fromHex(hex);
        return new javafx.scene.paint.Color(
                (double) rgb[0] / 255.0,
                (double) rgb[1] / 255.0,
                (double) rgb[2] / 255.0,
                1
        );
    }



    public static java.awt.Color hexToColor(String hex) {
        int[] rgb = fromHex(hex);
        return new java.awt.Color(rgb[0], rgb[1], rgb[2], 255);
    }



    public static String hexRGB(javafx.scene.paint.Color color) {
        int[] rgb = getRGB(color);
        return "#" + hex255(rgb);
    }



    public static String hexRGB(java.awt.Color color) {
        int[] rgb = getRGB(color);
        return "#" + hex255(rgb);
    }



    public static String hexRGBA(javafx.scene.paint.Color color) {
        int[] rgba = getRGBA(color);
        return "#" + hex255(rgba);
    }



    public static String hexRGBA(java.awt.Color color) {
        int[] rgba = getRGBA(color);
        return "#" + hex255(rgba);
    }



    public static String hexARGB(javafx.scene.paint.Color color) {
        int[] argb = getARGB(color);
        return "#" + hex255(argb);
    }



    public static String hexARGB(java.awt.Color color) {
        int[] argb = getARGB(color);
        return "#" + hex255(argb);
    }



    private static int[] fromHex(String hex) {
        String raw = hex.replace("#", "");
        int size = hex.length() / 2;
        int[] retval = new int[size];
        for (int i = 0; i < size; i++) {
            int i1 = i * 2;
            int i2 = i1 + 2;
            String hex255 = raw.substring(i1, i2);
            retval[i] = Integer.decode("#" + hex255);
        }
        return retval;
    }



    private static String hex255(int[] values) {
        String retval = "";
        for (int i = 0; i < values.length; i++) {
            retval += hex255(values[i]);
        }
        return retval;
    }



    private static String hex255(int val) {
        String hex = Integer.toHexString(val);
        if (hex.length() < 2) {
            hex = "0" + hex;
        }
        return hex;
    }



    private static int[] getRGB(javafx.scene.paint.Color c) {
        return new int[]{
            (int) (255.0 * c.getRed()),
            (int) (255.0 * c.getGreen()),
            (int) (255.0 * c.getBlue())
        };
    }



    private static int[] getRGB(java.awt.Color c) {
        return new int[]{c.getRed(), c.getGreen(), c.getBlue()};
    }



    private static int[] getRGBA(javafx.scene.paint.Color c) {
        return new int[]{
            (int) (255.0 * c.getRed()),
            (int) (255.0 * c.getGreen()),
            (int) (255.0 * c.getBlue()),
            (int) (255.0 * c.getOpacity())
        };
    }



    private static int[] getRGBA(java.awt.Color c) {
        return new int[]{c.getRed(), c.getGreen(), c.getBlue(), c.getAlpha()};
    }



    private static int[] getARGB(javafx.scene.paint.Color c) {
        return new int[]{
            (int) (255.0 * c.getOpacity()),
            (int) (255.0 * c.getRed()),
            (int) (255.0 * c.getGreen()),
            (int) (255.0 * c.getBlue())
        };
    }



    private static int[] getARGB(java.awt.Color c) {
        return new int[]{c.getAlpha(), c.getRed(), c.getGreen(), c.getBlue()};
    }

}
