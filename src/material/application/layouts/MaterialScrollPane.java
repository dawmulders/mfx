/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package material.application.layouts;
import javafx.scene.control.ScrollPane;




/**
 *
 * @author DMulders
 */
public class MaterialScrollPane extends ScrollPane {

    public MaterialScrollPane() {
        super();
        super.getStyleClass().add("material-scroll-pane");
        super.setFitToWidth(true);
        super.setFitToHeight(true);

    }

}
