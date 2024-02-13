/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package material.design.colors;
import javafx.scene.paint.Color;
import material.design.common.Colors;




/**
 *
 * @author DMulders
 */
public class MaterialShade {

    public static final MaterialShade RED = new MaterialShade("Red", "#FFEBEE", "#FFCDD2", "#EF9A9A", "#E57373", "#EF5350", "#F44336", "#E53935", "#D32F2F", "#C62828", "#B71C1C");
    public static final MaterialShade PINK = new MaterialShade("Pink", "#FCE4EC", "#F8BBD0", "#F48FB1", "#F06292", "#EC407A", "#E91E63", "#D81B60", "#C2185B", "#AD1457", "#880E4F");
    public static final MaterialShade PURPLE = new MaterialShade("Purple", "#F3E5F5", "#E1BEE7", "#CE93D8", "#BA68C8", "#AB47BC", "#9C27B0", "#8E24AA", "#7B1FA2", "#6A1B9A", "#4A148C");
    public static final MaterialShade DEEP_PURPLE = new MaterialShade("Deep Purple", "#EDE7F6", "#D1C4E9", "#B39DDB", "#9575CD", "#7E57C2", "#673AB7", "#5E35B1", "#512DA8", "#4527A0", "#311B92");
    public static final MaterialShade INDIGO = new MaterialShade("Indigo", "#E8EAF6", "#C5CAE9", "#9FA8DA", "#7986CB", "#5C6BC0", "#3F51B5", "#3949AB", "#303F9F", "#283593", "#1A237E");
    public static final MaterialShade BLUE = new MaterialShade("Blue", "#E3F2FD", "#BBDEFB", "#90CAF9", "#64B5F6", "#42A5F5", "#2196F3", "#1E88E5", "#1976D2", "#1565C0", "#0D47A1");
    public static final MaterialShade LIGHT_BLUE = new MaterialShade("Light Blue", "#E1F5FE", "#B3E5FC", "#81D4FA", "#4FC3F7", "#29B6F6", "#03A9F4", "#039BE5", "#0288D1", "#0277BD", "#01579B");
    public static final MaterialShade CYAN = new MaterialShade("Cyan", "#E0F7FA", "#B2EBF2", "#80DEEA", "#4DD0E1", "#26C6DA", "#00BCD4", "#00ACC1", "#0097A7", "#00838F", "#006064");
    public static final MaterialShade TEAL = new MaterialShade("Teal", "#E0F2F1", "#B2DFDB", "#80CBC4", "#4DB6AC", "#26A69A", "#009688", "#00897B", "#00796B", "#00695C", "#004D40");
    public static final MaterialShade GREEN = new MaterialShade("Green", "#E8F5E9", "#C8E6C9", "#A5D6A7", "#81C784", "#66BB6A", "#4CAF50", "#43A047", "#388E3C", "#2E7D32", "#1B5E20");
    public static final MaterialShade LIGHT_GREEN = new MaterialShade("Light Green", "#F1F8E9", "#DCEDC8", "#C5E1A5", "#AED581", "#9CCC65", "#8BC34A", "#7CB342", "#689F38", "#558B2F", "#33691E");
    public static final MaterialShade LIME = new MaterialShade("Lime", "#F9FBE7", "#F0F4C3", "#E6EE9C", "#DCE775", "#D4E157", "#CDDC39", "#C0CA33", "#AFB42B", "#9E9D24", "#827717");
    public static final MaterialShade YELLOW = new MaterialShade("Yellow", "#FFFDE7", "#FFF9C4", "#FFF59D", "#FFF176", "#FFEE58", "#FFEB3B", "#FDD835", "#FBC02D", "#F9A825", "#F57F17");
    public static final MaterialShade AMBER = new MaterialShade("Amber", "#FFF8E1", "#FFECB3", "#FFE082", "#FFD54F", "#FFCA28", "#FFC107", "#FFB300", "#FFA000", "#FF8F00", "#FF6F00");
    public static final MaterialShade ORANGE = new MaterialShade("Orange", "#FFF3E0", "#FFE0B2", "#FFCC80", "#FFB74D", "#FFA726", "#FF9800", "#FB8C00", "#F57C00", "#EF6C00", "#E65100");
    public static final MaterialShade DEEP_ORANGE = new MaterialShade("Deep Orange", "#FBE9E7", "#FFCCBC", "#FFAB91", "#FF8A65", "#FF7043", "#FF5722", "#F4511E", "#E64A19", "#D84315", "#BF360C");
    public static final MaterialShade BROWN = new MaterialShade("Brown", "#EFEBE9", "#D7CCC8", "#BCAAA4", "#A1887F", "#8D6E63", "#795548", "#6D4C41", "#5D4037", "#4E342E", "#3E2723");
    public static final MaterialShade GRAY = new MaterialShade("Gray", "#FAFAFA", "#F5F5F5", "#EEEEEE", "#E0E0E0", "#BDBDBD", "#9E9E9E", "#757575", "#616161", "#424242", "#212121");
    public static final MaterialShade BLUE_GRAY = new MaterialShade("Blue Gray", "#ECEFF1", "#CFD8DC", "#B0BEC5", "#90A4AE", "#78909C", "#607D8B", "#546E7A", "#455A64", "#37474F", "#263238");



    public static MaterialShade[] MATERIAL_PALETTES() {
        return new MaterialShade[]{RED, PINK, PURPLE, DEEP_PURPLE, INDIGO, BLUE, LIGHT_BLUE, CYAN, TEAL, GREEN, LIGHT_GREEN, LIME, YELLOW, AMBER, ORANGE, DEEP_ORANGE, BROWN, GRAY, BLUE_GRAY};
    }

    private String name;
    private Color[] variants;



    public MaterialShade(String name, Color c50, Color c100, Color c200, Color c300, Color c400, Color c500, Color c600, Color c700, Color c800, Color c900) {
        this.name = name;
        this.variants = new Color[]{c50, c100, c200, c300, c400, c500, c600, c700, c800, c900};
    }



    public MaterialShade(String name, String c50, String c100, String c200, String c300, String c400, String c500, String c600, String c700, String c800, String c900) {
        this.name = name;
        this.variants = new Color[]{Colors.hexToPaint(c50), Colors.hexToPaint(c100),
            Colors.hexToPaint(c200), Colors.hexToPaint(c300), Colors.hexToPaint(c400),
            Colors.hexToPaint(c500), Colors.hexToPaint(c600), Colors.hexToPaint(c700),
            Colors.hexToPaint(c800), Colors.hexToPaint(c900)};
    }



    public String getName() {
        return name;
    }



    public Color get(int index) {
        if (index < 0 || index > 9) {
            throw new IndexOutOfBoundsException("Palette color indices range from 0 to 9");
        }
        return variants[index];
    }



    public Color c50() {
        return variants[0];
    }



    public Color c100() {
        return variants[1];
    }



    public Color c200() {
        return variants[2];
    }



    public Color c300() {
        return variants[3];
    }



    public Color c400() {
        return variants[4];
    }



    public Color c500() {
        return variants[5];
    }



    public Color c600() {
        return variants[6];
    }



    public Color c700() {
        return variants[7];
    }



    public Color c800() {
        return variants[8];
    }



    public Color c900() {
        return variants[9];
    }

}
