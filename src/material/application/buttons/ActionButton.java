/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package material.application.buttons;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import material.design.common.Bgs;
import material.design.common.Shadows;




/**
 *
 * @author DMulders
 */
public class ActionButton extends Button {

    public static final double BUTTON_SIZE = 48;
    public static final double ICON_SIZE = 24;
    private final ImageView iv = new ImageView();
    private final Background bgDisabled;
    private final Background bgIdle;
    private final Background bgHover;



    public ActionButton(Image icon) {
        super();
        iv.setImage(icon);
        bgDisabled = Bgs.actionButtonDisabled();
        bgIdle = Bgs.actionButtonIdle();
        bgHover = Bgs.actionButtonHover();
        init();
    }



    private void init() {
        super.setEffect(Shadows.buttonIdle());
        super.setPrefSize(BUTTON_SIZE, BUTTON_SIZE);
        super.setMinSize(BUTTON_SIZE, BUTTON_SIZE);
        super.setMaxSize(BUTTON_SIZE, BUTTON_SIZE);
        super.setAlignment(Pos.CENTER);
        super.setGraphic(iv);
        super.setGraphicTextGap(0);
        super.setBackground(bgIdle);
        super.setBorder(Border.EMPTY);
        super.hoverProperty().addListener((o, v1, v2) -> {
            if (!super.isDisabled()) {
                if (v2 == true) {
                    super.setBackground(bgHover);
                } else {
                    super.setBackground(bgIdle);
                }
            }
        });
        super.disabledProperty().addListener((o, v1, v2) -> {
            if (v2) {
                super.setBackground(bgDisabled);
            } else {
                super.setBackground(bgIdle);
            }
        });
        iv.setFitHeight(ICON_SIZE);
        iv.setFitWidth(ICON_SIZE);
        iv.setPreserveRatio(true);
        iv.setSmooth(true);
    }
}
