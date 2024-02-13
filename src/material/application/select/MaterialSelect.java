/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package material.application.select;
import javafx.scene.control.ComboBox;




/**
 *
 * @author DMulders
 */
public class MaterialSelect extends ComboBox<String> {

    public MaterialSelect() {
        super();
        super.getStyleClass().add("material-select");
    }

}
