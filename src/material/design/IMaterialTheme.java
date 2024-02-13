/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package material.design;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import material.design.colors.MaterialPalette;
import material.design.typography.MaterialFont;
import material.design.typography.MaterialTypography;




/**
 *
 * @author DMulders
 */
public interface IMaterialTheme {

    public MaterialPalette getMaterialPalette();



    public MaterialFont getMaterialFont();



    public default Paint p1() {
        return getMaterialPalette().getPrimary();
    }



    public default Paint p2() {
        return getMaterialPalette().getPrimaryVariant();
    }



    public default Paint onP() {
        return getMaterialPalette().getOnPrimary();
    }



    public default Paint s1() {
        return getMaterialPalette().getSecondary();
    }



    public default Paint s2() {
        return getMaterialPalette().getSecondaryVariant();
    }



    public default Paint onS() {
        return getMaterialPalette().getOnSecondary();
    }



    public default Paint bg() {
        return getMaterialPalette().getBackground();
    }



    public default Paint onBg() {
        return getMaterialPalette().getOnBackground();
    }



    public default Paint surface() {
        return getMaterialPalette().getSurface();
    }



    public default Paint onSurface() {
        return getMaterialPalette().getOnSurface();
    }



    public default Paint error() {
        return getMaterialPalette().getError();
    }



    public default Paint onError() {
        return getMaterialPalette().getOnError();
    }



    public default Paint text() {
        return getMaterialPalette().getText();
    }



    public default Paint textVariant() {
        return getMaterialPalette().getTextVariant();
    }



    public default Paint hover() {
        return getMaterialPalette().getHover();
    }



    public default Paint hoverVariant() {
        return getMaterialPalette().getHoverVariant();
    }



    public default Font h1() {
        return getMaterialFont().getH1();
    }



    public default Font h2() {
        return getMaterialFont().getH2();
    }



    public default Font h3() {
        return getMaterialFont().getH3();
    }



    public default Font h4() {
        return getMaterialFont().getH4();
    }



    public default Font h5() {
        return getMaterialFont().getH5();
    }



    public default Font h6() {
        return getMaterialFont().getH6();
    }



    public default Font sub1() {
        return getMaterialFont().getSubtitle1();
    }



    public default Font sub2() {
        return getMaterialFont().getSubtitle2();
    }



    public default Font body() {
        return getMaterialFont().getBody1();
    }



    public default Font body2() {
        return getMaterialFont().getBody2();
    }



    public default Font caption() {
        return getMaterialFont().getCaption();
    }



    public default Font overline() {
        return getMaterialFont().getOverline();
    }



    public default Font btn() {
        return getMaterialFont().getButton();
    }



    public default Font typography(MaterialTypography mt) {
        switch (mt) {
            case BODY:
                return body();
            case BODY2:
                return body2();
            case BUTTON:
                return btn();
            case CAPTION:
                return caption();
            case OVERLINE:
                return overline();
            case SUB1:
                return sub1();
            case SUB2:
                return sub2();
            case H1:
                return h1();
            case H2:
                return h2();
            case H3:
                return h3();
            case H4:
                return h4();
            case H5:
                return h5();
            case H6:
                return h6();
        }
        return body();
    }
}
