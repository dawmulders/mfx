/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package material.application.dialogs;
import javafx.animation.FadeTransition;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.util.Duration;
import material.application.MaterialRootView;
import material.application.buttons.MaterialIconButton;
import material.design.Mfx;
import material.design.common.Icons;




/**
 *
 * @author DMulders
 */
public class DialogPane extends FlowPane {

    private final MaterialRootView rootView;
    private final BorderPane dialogPane = new BorderPane();
    private final FlowPane dialogHeaderPane = new FlowPane();
    private final MaterialIconButton closeButton = new MaterialIconButton(Icons.getCloseCircle(Icons.IconStyle.NONE), false);

    private final FadeTransition fadeIn, fadeOut;



    public DialogPane(MaterialRootView root) {
        super();
        this.rootView = root;
        super.setBackground(Mfx.BG_SCRIM);
        dialogPane.setBackground(Mfx.getBgSurface());
        super.setAlignment(Pos.CENTER);
        super.getChildren().add(dialogPane);
        dialogPane.setMinSize(600, 400);
        dialogPane.setMaxSize(1600, 900);
        dialogHeaderPane.setAlignment(Pos.TOP_RIGHT);
        dialogHeaderPane.getChildren().add(closeButton);
        closeButton.setOnAction((ae) -> {
            onDialogHidden();
        });
        dialogPane.setTop(dialogHeaderPane);

        fadeIn = new FadeTransition(Duration.millis(300), this);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);

        fadeOut = new FadeTransition(Duration.millis(300), this);
        fadeOut.setFromValue(1.0);
        fadeOut.setToValue(0.0);
        fadeOut.setOnFinished((event) -> {
            super.setVisible(false);
        });

    }



    public BorderPane getDialogPane() {
        return dialogPane;
    }



    public void setDialog(Node content) {
        dialogPane.setCenter(content);
    }



    public void onDialogShow() {
        super.setOpacity(0.0);
        super.setVisible(true);
        fadeIn.play();
    }



    public void onDialogHidden() {
        fadeOut.play();
    }

}
