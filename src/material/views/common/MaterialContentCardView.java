/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package material.views.common;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import material.design.Mfx;
import material.design.common.Shadows;




/**
 *
 * @author DMulders
 */
public class MaterialContentCardView extends FlowPane {

    public static final double CARD_WIDTH = 840;

    private final BorderPane cardPane;



    public MaterialContentCardView() {
        super();
        cardPane = new BorderPane();
        initBasis();
    }



    public BorderPane getCardPane() {
        return cardPane;
    }



    private void initBasis() {
        super.setBackground(Mfx.BG_UNDERLAY);
        super.setAlignment(Pos.CENTER);
        super.getChildren().add(cardPane);
        cardPane.setPadding(Insets.EMPTY);
        cardPane.setBackground(Mfx.getBgSurface());
        cardPane.setEffect(Shadows.cardShadow());
        cardPane.setMinSize(CARD_WIDTH, 400);
        cardPane.setPrefSize(CARD_WIDTH, 500);
        cardPane.setMaxWidth(CARD_WIDTH);
    }

}
