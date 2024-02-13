/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package material.application.navrail;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.paint.Color;
import material.design.Mfx;
import material.design.common.Bgs;
import material.design.common.Icons;




/**
 *
 * @author DMulders
 */
public class NavRailActionButton extends Button {

    public static final double BUTTON_SIZE = 56;
    public static final double ICON_SIZE = 24;
    private final ImageView iv = new ImageView();
    private final Background bgIdle;
    private final Background bgHover;



    public NavRailActionButton() {
        super();
        Image icon = Icons.getColoredIcon(Icons.getAdd(Icons.IconStyle.NONE), (Color) Mfx.getOnPrimary(), null);
        iv.setImage(icon);
        bgIdle = Bgs.floatingActionButtonIdle();
        bgHover = Bgs.floatingActionButtonHover();
        init();
    }



    private void init() {
        super.setPrefSize(BUTTON_SIZE, BUTTON_SIZE);
        super.setMinSize(BUTTON_SIZE, BUTTON_SIZE);
        super.setMaxSize(BUTTON_SIZE, BUTTON_SIZE);
        super.setAlignment(Pos.CENTER);
        super.setGraphic(iv);
        super.setBackground(bgIdle);
        super.setBorder(Border.EMPTY);
        super.hoverProperty().addListener((o, v1, v2) -> {
            if (v2 == true) {
                super.setBackground(bgHover);
            } else {
                super.setBackground(bgIdle);
            }
        });
        iv.setFitHeight(ICON_SIZE);
        iv.setFitWidth(ICON_SIZE);
        iv.setSmooth(true);
    }

}
