/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package material.application.buttons;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.CornerRadii;
import material.design.Mfx;




/**
 *
 * @author DMulders
 */
public class MaterialIconButton extends Button {

    private final ImageView imageView = new ImageView();
    private Background bgIdle;
    private Background bgHover;



    public MaterialIconButton(Image icon, boolean solid) {
        super();
        imageView.setImage(icon);
        if (solid) {
            initSolid();
        } else {
            initTransparent();
        }
        init();
    }



    private void initSolid() {
        bgIdle = new Background(new BackgroundFill(Mfx.getBg(), CornerRadii.EMPTY, Insets.EMPTY));
        bgHover = Mfx.BG_SCRIM;
    }



    private void initTransparent() {
        bgIdle = Mfx.BG_TRANS;
        bgHover = Mfx.BG_OVERLAY;
    }



    private void init() {
        imageView.setFitHeight(24);
        imageView.setFitWidth(24);
        imageView.setPreserveRatio(true);
        imageView.setSmooth(true);
        super.setGraphic(imageView);
        super.setAlignment(Pos.CENTER);
        super.setMinSize(24, 24);
        super.setMaxSize(24, 24);
        super.setPrefSize(24, 24);
        super.setBackground(bgIdle);
        super.setBorder(Border.EMPTY);
        super.hoverProperty().addListener((o, v1, v2) -> {
            if (v2) {
                super.setBackground(bgHover);
            } else {
                super.setBackground(bgIdle);
            }
        });
        super.setFocusTraversable(false);
    }

}
