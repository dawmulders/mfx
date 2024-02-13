/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package material.design.materialize;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.effect.Effect;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.paint.Paint;




/**
 *
 * @author DMulders
 */
public class MaterialSkin {

    public Background bgDiable = null;
    public Background bgIdle = null;
    public Background bgHover = null;
    public Background bgSelected = null;

    public Paint onDisable = null;
    public Paint onIdle = null;
    public Paint onHover = null;
    public Paint onSelected = null;

    public Border borderDisable = null;
    public Border borderIdle = null;
    public Border borderHover = null;
    public Border borderSelected = null;

    public Effect fxDisable = null;
    public Effect fxIdle = null;
    public Effect fxHover = null;
    public Effect fxSelected = null;



    public void applySkin(Button obj) {
        if (obj.isDisabled()) {
            applySkin(obj, bgDiable, borderDisable, onDisable, fxDisable);
        } else if (obj.isPressed()) {
            applySkin(obj, bgSelected, borderSelected, onSelected, fxSelected);
        } else if (obj.isHover()) {
            applySkin(obj, bgHover, borderHover, onHover, fxHover);
        } else {
            applySkin(obj, bgIdle, borderIdle, onIdle, fxIdle);
        }
    }



    public void applySkin(ToggleButton obj) {
        if (obj.isDisabled()) {
            applySkin(obj, bgDiable, borderDisable, onDisable, fxDisable);
        } else if (obj.isSelected() || obj.isPressed()) {
            applySkin(obj, bgSelected, borderSelected, onSelected, fxSelected);
        } else if (obj.isHover()) {
            applySkin(obj, bgHover, borderHover, onHover, fxHover);
        } else {
            applySkin(obj, bgIdle, borderIdle, onIdle, fxIdle);
        }
    }

   



    private static void applySkin(Button button, Background bg, Border border, Paint fill, Effect effect) {
        if (null != bg) {
            button.setBackground(bg);
        }
        if (null != border) {
            button.setBorder(border);
        }
        if (null != fill) {
            button.setTextFill(fill);
        }
        button.setEffect(effect);
    }



    private static void applySkin(ToggleButton button, Background bg, Border border, Paint fill, Effect effect) {
        if (null != bg) {
            button.setBackground(bg);
        }
        if (null != border) {
            button.setBorder(border);
        }
        if (null != fill) {
            button.setTextFill(fill);
        }
        button.setEffect(effect);
    }



    

}
