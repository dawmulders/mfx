/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package material.design;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import material.design.colors.MaterialPalette;
import material.design.common.Colors;
import material.design.typography.MaterialFont;
import material.design.typography.MaterialTypography;




/**
 *
 * @author DMulders
 */
public class Mfx implements IMaterialTheme {

    private static Mfx instance = null;

    public static final Background BG_UNDERLAY = new Background(new BackgroundFill(Color.web("#e5e5e5"), CornerRadii.EMPTY, Insets.EMPTY));
    public static final Background BG_TRANS = new Background(new BackgroundFill(Color.web("#ffffff", 0.0), CornerRadii.EMPTY, Insets.EMPTY));
    public static final Background BG_OVERLAY = new Background(new BackgroundFill(Color.web("#ffffff", 0.6), CornerRadii.EMPTY, Insets.EMPTY));
    public static final Background BG_SCRIM = new Background(new BackgroundFill(Color.web("#212121", 0.6), CornerRadii.EMPTY, Insets.EMPTY));

    private static Background bgPrimary;
    private static Background bgPrimary2;
    private static Background bgSecondary;
    private static Background bgSecondary2;
    private static Background bgSurface;

    public static Color TEXT_GRAY = Color.web("#5a5f64");

    public static Color IDLE_GRAY_BG = Color.web("#444444", 0.2);
    public static Color ON_IDLE_GRAY = Color.web("#444444", 0.8);
    public static Color ON_IDLE_GRAY_DARK = Color.web("#111111");
    
    public static Color DISABLED_GRAY = Color.web("#d3d3d3");
    public static Color SHADOW_COLOR = Color.web("#222222", 0.6);
    public static Color SHADOW_COLOR_DARKER = Color.web("#000000", 0.7);



    public static Background getBgPrimary() {
        if (bgPrimary == null) {
            bgPrimary = new Background(new BackgroundFill(getP1(), CornerRadii.EMPTY, Insets.EMPTY));
        }
        return bgPrimary;
    }



    public static Background getBgPrimary2() {
        if (bgPrimary2 == null) {
            bgPrimary2 = new Background(new BackgroundFill(getP2(), CornerRadii.EMPTY, Insets.EMPTY));
        }
        return bgPrimary2;
    }



    public static Background getBgSecondary() {
        if (bgSecondary == null) {
            bgSecondary = new Background(new BackgroundFill(getS1(), CornerRadii.EMPTY, Insets.EMPTY));
        }
        return bgSecondary;
    }



    public static Background getBgSecondary2() {
        if (bgSecondary2 == null) {
            bgSecondary2 = new Background(new BackgroundFill(getS2(), CornerRadii.EMPTY, Insets.EMPTY));
        }
        return bgSecondary2;
    }



    public static Background getBgSurface() {
        if (bgSurface == null) {
            bgSurface = new Background(new BackgroundFill(getSurface(), CornerRadii.EMPTY, Insets.EMPTY));
        }
        return bgSurface;
    }



    public static Color getPrimaryTransparent(double opacity) {
        return Colors.getWithAlpha((Color) getP1(), opacity);
    }



    public static Mfx getInstance() {
        if (null == instance) {
            synchronized (Mfx.class) {
                if (null == instance) {
                    instance = new Mfx();
                }
            }
        }
        return instance;
    }

    private MaterialPalette palette = new MaterialPalette();
    private MaterialFont font = new MaterialFont(true);



    protected Mfx() {
    }



    public void setPalette(MaterialPalette palette) {
        this.palette = palette;
        bgPrimary = null;
        bgSurface = null;
    }



    public void setFont(MaterialFont font) {
        this.font = font;
    }



    @Override
    public MaterialPalette getMaterialPalette() {
        return palette;
    }



    @Override
    public MaterialFont getMaterialFont() {
        return font;
    }



    public static Paint getP1() {
        return getInstance().p1();
    }



    public static Paint getP2() {
        return getInstance().p2();
    }



    public static Paint getOnPrimary() {
        return getInstance().onP();
    }



    public static Paint getS1() {
        return getInstance().s1();
    }



    public static Paint getS2() {
        return getInstance().s2();
    }



    public static Paint getOnSecondary() {
        return getInstance().onS();
    }



    public static Paint getBg() {
        return getInstance().bg();
    }



    public static Paint getOnBg() {
        return getInstance().onBg();
    }



    public static Paint getSurface() {
        return getInstance().surface();
    }



    public static Paint getOnSurface() {
        return getInstance().onSurface();
    }



    public static Paint getText() {
        return getInstance().text();
    }



    public static Paint getTextVariant() {
        return getInstance().textVariant();
    }



    public static Paint getHover() {
        return getInstance().hover();
    }



    public static Paint getHoverVariant() {
        return getInstance().hoverVariant();
    }



    public static Paint getError() {
        return getInstance().error();
    }



    public static Paint getOnError() {
        return getInstance().onError();
    }



    public static Font getH1() {
        return getInstance().h1();
    }



    public static Font getH2() {
        return getInstance().h2();
    }



    public static Font getH3() {
        return getInstance().h3();
    }



    public static Font getH4() {
        return getInstance().h4();
    }



    public static Font getH5() {
        return getInstance().h5();
    }



    public static Font getH6() {
        return getInstance().h6();
    }



    public static Font getSub1() {
        return getInstance().sub1();
    }



    public static Font getSub2() {
        return getInstance().sub2();
    }



    public static Font getBody() {
        return getInstance().body();
    }



    public static Font getBody2() {
        return getInstance().body2();
    }



    public static Font getCaption() {
        return getInstance().caption();
    }



    public static Font getOverline() {
        return getInstance().overline();
    }



    public static Font getBtn() {
        return getInstance().btn();
    }



    public static Font getTypography(MaterialTypography mt) {
        return getInstance().typography(mt);
    }

}
