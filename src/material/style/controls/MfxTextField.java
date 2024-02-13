/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package material.style.controls;
import javafx.scene.control.TextField;




/**
 *
 * @author DMulders
 */
public class MfxTextField extends TextField {

    public MfxTextField() {
        super();
        super.getStyleClass().add("mfx-text-field");
    }

}
