/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package material.application.navrail;
import javafx.geometry.Pos;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import material.application.texts.MaterialLabel;
import material.design.Mfx;
import material.design.common.Bgs;
import material.design.common.Icons;
import material.design.typography.MaterialTypography;




/**
 *
 * @author DMulders
 */
public class NavRailMenuButton extends ToggleButton {

    private final INavRailView navRailView;
    private final Image iconIdle;
    private final Image iconSelected;
    private final Background bgIdle = Bgs.navRailMenuButtonIdle();
    private final Background bgHover = Bgs.navRailMenuButtonHover();
    private final Background bgSelected = Bgs.navRailMenuButtonSelected();
    private final Color fillIdle = Mfx.ON_IDLE_GRAY;
    private final Color fillHover = Mfx.ON_IDLE_GRAY_DARK;
    private final Color fillSelected = (Color) Mfx.getP1();

    private final ImageView iconView = new ImageView();
    private final MaterialLabel menuLabel = new MaterialLabel("", MaterialTypography.CAPTION, 48);
    private final VBox box = new VBox();



    public NavRailMenuButton(INavRailView navRailView, Image icon, String name) {
        super();
        this.navRailView = navRailView;
        this.iconIdle = Icons.getColoredIcon(icon, Mfx.ON_IDLE_GRAY, null);
        this.iconSelected = Icons.getColoredIcon(icon, (Color) Mfx.getP1(), null);
        menuLabel.setText(name);
        init();
    }



    public INavRailView getView() {
        return navRailView;
    }



    private void init() {
        super.setMinSize(72, 72);
        super.setMaxSize(72, 72);
        super.setPrefSize(72, 72);
        box.setMinSize(56, 56);
        box.setMaxSize(56, 56);
        box.setPrefSize(56, 56);
        box.setAlignment(Pos.CENTER);
        box.getChildren().addAll(iconView);
        if (menuLabel.getText() != null && menuLabel.getText().length() > 0) {
            box.getChildren().add(menuLabel);
        }
        menuLabel.textProperty().addListener((o, v1, v2) -> {
            if (v2 == null || v2.length() < 1) {
                box.getChildren().remove(menuLabel);
            } else {
                if (!box.getChildren().contains(menuLabel)) {
                    box.getChildren().add(menuLabel);
                }
            }
        });
        iconView.setFitWidth(24);
        iconView.setFitHeight(24);
        iconView.setImage(iconIdle);
        menuLabel.setTextFill(fillIdle);
        menuLabel.setTextAlignment(TextAlignment.CENTER);
        menuLabel.setAlignment(Pos.CENTER);

        super.setGraphic(box);
        super.setAlignment(Pos.CENTER);
        super.setBackground(bgIdle);
        super.setBorder(Border.EMPTY);
        super.hoverProperty().addListener((o, v1, v2) -> {
            if (v2 == true) {
                super.setBackground(bgHover);
                if (!super.isSelected()) {
                    menuLabel.setTextFill(fillHover);
                }
            } else {
                if (super.isSelected()) {
                    super.setBackground(bgSelected);
                    iconView.setImage(iconSelected);
                    menuLabel.setTextFill(fillSelected);
                } else {
                    super.setBackground(bgIdle);
                    iconView.setImage(iconIdle);
                    menuLabel.setTextFill(fillIdle);
                }
            }
        });
        super.selectedProperty().addListener((o, v1, v2) -> {
            if (v2) {
                super.setBackground(bgSelected);
                menuLabel.setTextFill(fillSelected);
                iconView.setImage(iconSelected);
            } else {
                super.setBackground(bgIdle);
                iconView.setImage(iconIdle);
                menuLabel.setTextFill(fillIdle);
            }
        });
        super.pressedProperty().addListener((o, v1, v2) -> {
            if (v2) {
                super.setBackground(bgSelected);
                menuLabel.setTextFill(fillSelected);
                iconView.setImage(iconSelected);
            } else {
                if (!super.isSelected() && !super.isHover()) {
                    super.setBackground(bgIdle);
                    iconView.setImage(iconIdle);
                    menuLabel.setTextFill(fillIdle);
                }
            }
        });
        super.setFocusTraversable(false);
    }

}
