/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package material.style.controls;
import javafx.scene.control.Label;







/**
 *
 * @author DMulders
 */
public class MfxLabel extends Label{
    
    public MfxLabel(String text){
        super(text);
        super.getStyleClass().add("mfx-label");
    }
    
}
