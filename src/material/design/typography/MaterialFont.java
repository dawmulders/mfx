/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package material.design.typography;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javafx.scene.text.Font;
import material.design.common.Fonts;




/**
 *
 * @author DMulders
 */
public class MaterialFont {

    private String name = "Default";
    private Font h1 = Fonts.robotoLight(96);
    private Font h2 = Fonts.robotoLight(60);
    private Font h3 = Fonts.roboto(48);
    private Font h4 = Fonts.roboto(34);
    private Font h5 = Fonts.roboto(24);
    private Font h6 = Fonts.robotoMedium(20);
    private Font subtitle1 = Fonts.roboto(16);
    private Font subtitle2 = Fonts.robotoMedium(14);
    private Font body1 = Fonts.roboto(16);
    private Font body2 = Fonts.robotoMedium(14);
    private Font button = Fonts.robotoMedium(14);
    private Font caption = Fonts.robotoMedium(12);
    private Font overline = Fonts.roboto(10);

    private List<File> fontfiles;



    public MaterialFont(boolean loadDefaultFiles) {
        if (loadDefaultFiles) {
            fontfiles = Fonts.robotoFontFiles();
        }
    }



    public MaterialFont(String name) {
        this.name = name;
    }



    public String getFontName() {
        return name;
    }



    public void setFontName(String name) {
        this.name = name;
    }



    /**
     * Headline 1, default 96px, light
     *
     * @return
     */
    public Font getH1() {
        return h1;
    }



    public void setH1(Font h1) {
        this.h1 = h1;
    }



    /**
     * Headline 2, default 60px, light
     *
     * @return
     */
    public Font getH2() {
        return h2;
    }



    public void setH2(Font h2) {
        this.h2 = h2;
    }



    /**
     * Headline 3, default 48px
     *
     * @return
     */
    public Font getH3() {
        return h3;
    }



    public void setH3(Font h3) {
        this.h3 = h3;
    }



    /**
     * Headline 4, default 34px
     *
     * @return
     */
    public Font getH4() {
        return h4;
    }



    public void setH4(Font h4) {
        this.h4 = h4;
    }



    public Font getH5() {
        return h5;
    }



    public void setH5(Font h5) {
        this.h5 = h5;
    }



    public Font getH6() {
        return h6;
    }



    public void setH6(Font h6) {
        this.h6 = h6;
    }



    public Font getSubtitle1() {
        return subtitle1;
    }



    public void setSubtitle1(Font subtitle1) {
        this.subtitle1 = subtitle1;
    }



    public Font getSubtitle2() {
        return subtitle2;
    }



    public void setSubtitle2(Font subtitle2) {
        this.subtitle2 = subtitle2;
    }



    public Font getBody1() {
        return body1;
    }



    public void setBody1(Font body1) {
        this.body1 = body1;
    }



    public Font getBody2() {
        return body2;
    }



    public void setBody2(Font body2) {
        this.body2 = body2;
    }



    public Font getButton() {
        return button;
    }



    public void setButton(Font button) {
        this.button = button;
    }



    public Font getCaption() {
        return caption;
    }



    public void setCaption(Font caption) {
        this.caption = caption;
    }



    public Font getOverline() {
        return overline;
    }



    public void setOverline(Font overline) {
        this.overline = overline;
    }



    public boolean hasFontFiles() {
        return fontfiles != null && fontfiles.size() > 0;
    }



    public int fontfileCount() {
        if (null == fontfiles) {
            return 0;
        }
        return fontfiles.size();
    }



    public void clearFontfiles() {
        if (null != fontfiles) {
            fontfiles.clear();
        }
    }



    public File getFontfile(int index) {
        return fontfiles.get(index);
    }



    public void addFontfile(File fontfile) {
        if (null == fontfiles) {
            fontfiles = new ArrayList<>();
        }
        fontfiles.add(fontfile);
    }



    public Iterator<File> fontfileIterator() {
        if (null == fontfiles) {
            fontfiles = new ArrayList<>();
        }
        return fontfiles.iterator();
    }



    public Font typography(MaterialTypography mt) {
        switch (mt) {
            case BODY:
                return body1;
            case BODY2:
                return body2;
            case BUTTON:
                return button;
            case CAPTION:
                return caption;
            case OVERLINE:
                return overline;
            case SUB1:
                return subtitle1;
            case SUB2:
                return subtitle2;
            case H1:
                return h1;
            case H2:
                return h2;
            case H3:
                return h3;
            case H4:
                return h4;
            case H5:
                return h5;
            case H6:
                return h6;
        }
        return body1;
    }

}
