/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package material.application.layouts;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import material.design.Mfx;
import material.design.common.Shadows;




/**
 *
 * @author DMulders
 */
public class HeaderedScrollPane extends StackPane {

    private final BorderPane header;
    private final MaterialScrollPane scroller;

    private FadeTransition fadeIn, fadeOut;



    public HeaderedScrollPane() {
        super();
        header = new BorderPane();
        scroller = new MaterialScrollPane();
        init();
    }



    public BorderPane getHeader() {
        return header;
    }



    public MaterialScrollPane getScroller() {
        return scroller;
    }



    private void init() {
        StackPane.setAlignment(scroller, Pos.CENTER);
        StackPane.setAlignment(header, Pos.TOP_CENTER);
        super.getChildren().add(scroller);
        super.getChildren().add(header);
        header.setMaxHeight(48);
        header.setMinHeight(48);
        header.setBackground(Mfx.getBgSurface());
        header.setEffect(Shadows.cardShadow());

        fadeIn = new FadeTransition(Duration.millis(240), header);
        fadeIn.setToValue(1);
        fadeOut = new FadeTransition(Duration.millis(160), header);
        fadeOut.setToValue(0.0);
        fadeOut.setOnFinished((event) -> {
            header.setVisible(false);
        });

        scroller.vvalueProperty().addListener((o, v1, v2) -> {
            if (v1 != null) {
                double vPrev = (double) v1;
                double vCurr = (double) v2;
                    
                if(vPrev > vCurr && !header.isVisible()){
                    header.setOpacity(0.0);
                    header.setVisible(true);
                    fadeIn.play();
                }
                
                if(vCurr > vPrev){
                    if(header.isVisible() && fadeOut.getStatus()!=Animation.Status.RUNNING){
                        fadeOut.play();
                    }
                }
            }
        });
    }
}
