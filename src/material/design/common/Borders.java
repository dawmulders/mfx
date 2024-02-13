/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package material.design.common;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import material.design.Mfx;




/**
 *
 * @author DMulders
 */
public class Borders {

    public static Border textFieldIdle() {
        return new Border(new BorderStroke(Color.web("#212121", 0.3), BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(0, 0, 2, 0)));
    }



    public static Border textFieldHover() {
        return new Border(new BorderStroke(Color.web("#212121", 0.4), BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(0, 0, 2, 0)));
    }



    public static Border textFieldFocus() {
        return new Border(new BorderStroke(Mfx.getP1(), BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(0, 0, 2, 0)));
    }



    public static Border outlinedButtonIdle() {
        return new Border(new BorderStroke(Mfx.ON_IDLE_GRAY, BorderStrokeStyle.SOLID, new CornerRadii(6, false), new BorderWidths(1)));
    }



    public static Border outlinedButtonHover() {
        return new Border(new BorderStroke(Mfx.ON_IDLE_GRAY_DARK, BorderStrokeStyle.SOLID, new CornerRadii(6, false), new BorderWidths(1)));
    }



    public static Border inputFieldIdle() {
        return new Border(new BorderStroke(Mfx.ON_IDLE_GRAY, BorderStrokeStyle.SOLID, new CornerRadii(4, false), new BorderWidths(1)));
    }



    public static Border inputFieldHover() {
        return new Border(new BorderStroke(Mfx.ON_IDLE_GRAY_DARK, BorderStrokeStyle.SOLID, new CornerRadii(4, false), new BorderWidths(1)));
    }



    public static Border inputFieldSelected() {
        return new Border(new BorderStroke(Mfx.getP1(), BorderStrokeStyle.SOLID, new CornerRadii(4, false), new BorderWidths(1)));
    }



    public static Border basicIdle() {
        return new Border(new BorderStroke(Color.TRANSPARENT, BorderStrokeStyle.SOLID, new CornerRadii(6, false), new BorderWidths(2)));
    }



    public static Border basicHover() {
        return new Border(new BorderStroke(Mfx.ON_IDLE_GRAY, BorderStrokeStyle.SOLID, new CornerRadii(6, false), new BorderWidths(2)));
    }



    public static Border basicSelected() {
        return new Border(new BorderStroke(Mfx.getP1(), BorderStrokeStyle.SOLID, new CornerRadii(6, false), new BorderWidths(2)));
    }

}
