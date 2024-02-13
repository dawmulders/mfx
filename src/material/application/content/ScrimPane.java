/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package material.application.content;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;




/**
 *
 * @author DMulders
 */
public class ScrimPane extends FlowPane {

    
    
    
    public ScrimPane() {
        super();
        super.setBackground(new Background(new BackgroundFill(Color.web("#323232", 0.08), CornerRadii.EMPTY, Insets.EMPTY)));
        super.setPrefWidth(Double.MAX_VALUE);
        super.setPrefHeight(Double.MAX_VALUE);
    }

}
