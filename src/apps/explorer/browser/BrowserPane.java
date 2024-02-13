/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apps.explorer.browser;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import material.application.texts.MaterialInputField;




/**
 *
 * @author DMulders
 */
public class BrowserPane extends BorderPane {

    public BrowserPane(BrowserModel model) {
        super();

        FlowPane root = new FlowPane();
        MaterialInputField input = new MaterialInputField();
        root.getChildren().add(input);
        super.setCenter(root);
    }

}
