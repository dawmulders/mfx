/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package material.design.colors;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import material.design.common.Colors;




/**
 *
 * @author DMulders
 */
public class MaterialPalette {

    private String paletteName = "Default";
    private Paint primary = Colors.hexToPaint("#6200ee");
    private Paint primaryVariant = Colors.hexToPaint("#3700b3");
    private Paint secondary = Colors.hexToPaint("#03dac6");
    private Paint secondaryVariant = Colors.hexToPaint("#018786");

    private Paint background = Colors.hexToPaint("#ffffff");
    private Paint surface = Colors.hexToPaint("#ffffff");
    private Paint error = Colors.hexToPaint("#b00020");

    private Paint onPrimary = Colors.hexToPaint("#ffffff");
    private Paint onSecondary = Colors.hexToPaint("#000000");
    private Paint onBackground = Colors.hexToPaint("#000000");
    private Paint onSurface = Colors.hexToPaint("#000000");
    private Paint onError = Colors.hexToPaint("#ffffff");

    private Paint text = Colors.hexToPaint("434343");
    private Paint textVariant = Colors.hexToPaint("434343");

    private Paint hover = Color.web("#212121", 0.8);
    private Paint hoverVariant = Color.web("#212121", 0.8);



    public MaterialPalette() {
    }



    public MaterialPalette(String name) {
        this.paletteName = name;
    }



    public String getPaletteName() {
        return paletteName;
    }



    public void setPaletteName(String name) {
        paletteName = name;
    }



    public Paint getText() {
        return text;
    }



    public void setText(Paint text) {
        this.text = text;
    }



    public Paint getTextVariant() {
        return textVariant;
    }



    public void setTextVariant(Paint textVariant) {
        this.textVariant = textVariant;
    }



    public Paint getHover() {
        return hover;
    }



    public void setHover(Paint hover) {
        this.hover = hover;
    }



    public Paint getHoverVariant() {
        return hoverVariant;
    }



    public void setHoverVariant(Paint hoverVariant) {
        this.hoverVariant = hoverVariant;
    }



    public Paint getPrimary() {
        return primary;
    }



    public void setPrimary(Paint primary) {
        this.primary = primary;
        this.onPrimary = Colors.getOnColor((Color) primary);
    }



    public Paint getPrimaryVariant() {
        return primaryVariant;
    }



    public void setPrimaryVariant(Paint primaryVariant) {
        this.primaryVariant = primaryVariant;
    }



    public Paint getSecondary() {
        return secondary;
    }



    public void setSecondary(Paint secondary) {
        this.secondary = secondary;
        this.onSecondary = Colors.getOnColor((Color) secondary);
    }



    public Paint getSecondaryVariant() {
        return secondaryVariant;
    }



    public void setSecondaryVariant(Paint secondaryVariant) {
        this.secondaryVariant = secondaryVariant;
    }



    public Paint getBackground() {
        return background;
    }



    public void setBackground(Paint background) {
        this.background = background;
        this.onBackground = Colors.getOnColor((Color) background);
    }



    public Paint getSurface() {
        return surface;
    }



    public void setSurface(Paint surface) {
        this.surface = surface;
        this.onSurface = Colors.getOnColor((Color) surface);
    }



    public Paint getError() {
        return error;
    }



    public void setError(Paint error) {
        this.error = error;
        this.onError= Colors.getOnColor((Color) error);
    }



    public Paint getOnPrimary() {
        return onPrimary;
    }



    public void setOnPrimary(Paint onPrimary) {
        this.onPrimary = onPrimary;
    }



    public Paint getOnSecondary() {
        return onSecondary;
    }



    public void setOnSecondary(Paint onSecondary) {
        this.onSecondary = onSecondary;
    }



    public Paint getOnBackground() {
        return onBackground;
    }



    public void setOnBackground(Paint onBackground) {
        this.onBackground = onBackground;
    }



    public Paint getOnSurface() {
        return onSurface;
    }



    public void setOnSurface(Paint onSurface) {
        this.onSurface = onSurface;
    }



    public Paint getOnError() {
        return onError;
    }



    public void setOnError(Paint onError) {
        this.onError = onError;
    }

}
