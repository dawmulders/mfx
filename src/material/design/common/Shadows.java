/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package material.design.common;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import material.design.Mfx;




/**
 *
 * @author DMulders
 */
public class Shadows {

    public static DropShadow buttonIdle() {
        return new DropShadow(BlurType.TWO_PASS_BOX, Mfx.SHADOW_COLOR, 6, 0.4, 2, 2);
    }



    public static DropShadow buttonHover() {
        return new DropShadow(BlurType.TWO_PASS_BOX, Mfx.SHADOW_COLOR_DARKER, 6, 0.4, 2, 2);
    }
    
    public static DropShadow cardShadow(){
        return new DropShadow(BlurType.TWO_PASS_BOX, Mfx.SHADOW_COLOR, 15, 0.2, 2, 2);
    }
}
