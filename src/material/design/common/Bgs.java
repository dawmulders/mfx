/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package material.design.common;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import material.design.Mfx;




/**
 *
 * @author DMulders
 */
public class Bgs {

    public static Background create(Paint color, double radius) {
        return new Background(new BackgroundFill(color, new CornerRadii(radius, false), Insets.EMPTY));
    }



    public static Background basicIdle() {
        return new Background(new BackgroundFill(Color.TRANSPARENT, new CornerRadii(6, false), Insets.EMPTY));
    }



    public static Background basicHover() {
        return new Background(new BackgroundFill(Colors.getWithAlpha(Mfx.IDLE_GRAY_BG, 0.05), new CornerRadii(6, false), Insets.EMPTY));
    }



    public static Background drawerMenuIdle() {
        return new Background(new BackgroundFill(Color.TRANSPARENT, new CornerRadii(4, 4, 4, 4, false), new Insets(4, 8, 4, 8)));
    }



    public static Background drawerMenuHover() {
        return new Background(new BackgroundFill(Mfx.IDLE_GRAY_BG, new CornerRadii(4, 4, 4, 4, false), new Insets(4, 8, 4, 8)));
    }



    public static Background drawerMenuActive() {
        return new Background(new BackgroundFill(Mfx.getPrimaryTransparent(0.2), new CornerRadii(4, 4, 4, 4, false), new Insets(4, 8, 4, 8)));
    }



    public static Background bgTextFieldIdle() {
        return new Background(new BackgroundFill(Color.web("#212121", 0.12), new CornerRadii(4, 4, 0, 0, false), Insets.EMPTY));
    }



    public static Background bgTextFieldHover() {
        return new Background(new BackgroundFill(Color.web("#212121", 0.18), new CornerRadii(4, 4, 0, 0, false), Insets.EMPTY));
    }



    public static Background bgTextFieldFocus() {
        return new Background(new BackgroundFill(Color.web("#212121", 0.2), new CornerRadii(4, 4, 0, 0, false), Insets.EMPTY));
    }



    public static Background bgContainedButtonIdle() {
        return new Background(new BackgroundFill(Mfx.getP1(), new CornerRadii(6, false), Insets.EMPTY));
    }



    public static Background bgContainedButtonHover() {
        return new Background(new BackgroundFill(Mfx.getP2(), new CornerRadii(6, false), Insets.EMPTY));
    }



    public static Background outlinedButtonIdle() {
        return new Background(new BackgroundFill(Color.TRANSPARENT, new CornerRadii(6, false), Insets.EMPTY));
    }



    public static Background outlinedButtonHover() {
        return new Background(new BackgroundFill(Mfx.getPrimaryTransparent(0.12), new CornerRadii(6, false), Insets.EMPTY));
    }



    public static Background floatingActionButtonIdle() {
        return new Background(new BackgroundFill(Mfx.getP2(), new CornerRadii(0.5, true), Insets.EMPTY));
    }



    public static Background floatingActionButtonHover() {
        return new Background(new BackgroundFill(Mfx.getP1(), new CornerRadii(0.5, true), Insets.EMPTY));
    }



    public static Background actionButtonDisabled() {
        return new Background(new BackgroundFill(Mfx.DISABLED_GRAY, new CornerRadii(0.5, true), Insets.EMPTY));
    }



    public static Background actionButtonIdle() {
        return new Background(new BackgroundFill(Mfx.getBg(), new CornerRadii(0.5, true), Insets.EMPTY));
    }



    public static Background actionButtonHover() {
        return new Background(new BackgroundFill(Mfx.getS1(), new CornerRadii(0.5, true), Insets.EMPTY));
    }



    public static Background navRailMenuButtonIdle() {
        return new Background(new BackgroundFill(Color.TRANSPARENT, new CornerRadii(0.5, true), new Insets(8)));
    }



    public static Background navRailMenuButtonHover() {
        return new Background(new BackgroundFill(Mfx.IDLE_GRAY_BG, new CornerRadii(0.5, true), new Insets(8)));
    }



    public static Background navRailMenuButtonSelected() {
        return new Background(new BackgroundFill(Color.TRANSPARENT, new CornerRadii(0.5, true), new Insets(8)));
    }



    public static Background windowPane() {
        return new Background(new BackgroundFill(Color.web("#dedede"), new CornerRadii(6, 6, 6, 6, false), Insets.EMPTY));
    }



    public static Background windowPaneHeader() {
        return new Background(new BackgroundFill(Mfx.getP2(), new CornerRadii(6, 6, 0, 0, false), Insets.EMPTY));
    }



    public static Background windowButtonCloseIdle() {
        return new Background(new BackgroundFill(Color.TRANSPARENT, new CornerRadii(0, 6, 0, 0, false), Insets.EMPTY));
    }



    public static Background windowButtonCloseHover() {
        return new Background(new BackgroundFill(Mfx.getError(), new CornerRadii(0, 6, 0, 0, false), Insets.EMPTY));
    }



    public static Background windowButtonIdle() {
        return new Background(new BackgroundFill(Color.TRANSPARENT, new CornerRadii(0, 0, 0, 0, false), Insets.EMPTY));
    }



    public static Background windowButtonHover() {
        return new Background(new BackgroundFill(Color.web("#ffffff", 0.1), new CornerRadii(0, 0, 0, 0, false), Insets.EMPTY));
    }



    public static Background inputFieldIdle() {
        return new Background(new BackgroundFill(Color.web("#ffffff", 0.0), new CornerRadii(4, 4, 4, 4, false), Insets.EMPTY));
    }



    public static Background inputFieldHover() {
        return new Background(new BackgroundFill(Color.web("#ffffff", 0.0), new CornerRadii(4, 4, 4, 4, false), Insets.EMPTY));
    }



    public static Background inputFieldActive() {
        return new Background(new BackgroundFill(Color.web("#ffffff", 0.0), new CornerRadii(4, 4, 4, 4, false), Insets.EMPTY));
    }

}
