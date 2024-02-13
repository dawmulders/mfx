/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package material.application.navigation;
import javafx.geometry.Pos;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.paint.Color;
import material.application.content.IMaterialView;
import material.design.Mfx;
import material.design.common.Bgs;
import material.design.common.Icons;




/**
 *
 * @author DMulders
 */
public class MaterialDrawerMenu extends ToggleButton {

    private final ImageView imageView = new ImageView();

    private final MenuDrawer drawer;
    private final IMaterialView view;
    private final Image iconIdle;
    private final Image iconSelected;

    private final Background bgIdle;
    private final Background bgHover;
    private final Background bgSelected;

    private final Color onIdle;
    private final Color onHover;
    private final Color onSelected;



    public MaterialDrawerMenu(MenuDrawer drawer, IMaterialView view) {
        super();
        this.drawer = drawer;
        this.view = view;
        iconIdle = Icons.getColoredIcon(view.getMenuIcon(), Mfx.ON_IDLE_GRAY, null);
        iconSelected = Icons.getColoredIcon(view.getMenuIcon(), (Color) Mfx.getP1(), null);
        bgIdle = Bgs.drawerMenuIdle();
        bgHover = Bgs.drawerMenuHover();
        bgSelected = Bgs.drawerMenuActive();
        onIdle = Mfx.ON_IDLE_GRAY;
        onHover = Mfx.ON_IDLE_GRAY_DARK;
        onSelected = (Color) Mfx.getP1();
        init();
    }
        
    public IMaterialView getMaterialView() {
        return view;
    }
    
    


    private void init() {
        super.setMinHeight(48);
        super.setMaxHeight(48);
        super.setPrefHeight(48);
        super.setPrefWidth(Double.MAX_VALUE);
        super.setAlignment(Pos.BASELINE_LEFT);

        super.setText(view.getMenuName());

        super.setFont(Mfx.getSub2());
        super.setTextFill(onIdle);
        super.setBackground(bgIdle);
        super.setBorder(Border.EMPTY);
        super.setGraphicTextGap(36);

        imageView.setImage(iconIdle);
        imageView.setFitWidth(24);
        imageView.setFitHeight(24);
        imageView.setPreserveRatio(true);
        imageView.setSmooth(true);
        super.setGraphic(imageView);

        super.hoverProperty().addListener((o, v1, v2) -> {
            if (v2 == true) {
                if (!super.isSelected()) {
                    super.setBackground(bgHover);
                    super.setTextFill(onHover);
                    imageView.setImage(iconSelected);
                }
            } else {
                if (!super.isSelected()) {
                    super.setBackground(bgIdle);
                    super.setTextFill(onIdle);
                    imageView.setImage(iconIdle);
                }
            }
        });

        super.selectedProperty().addListener((o, v1, v2) -> {
            if (v2 == true) {
                super.setBackground(bgSelected);
                super.setTextFill(onSelected);
                imageView.setImage(iconSelected);
            } else {
                if (!super.isHover()) {
                    super.setBackground(bgIdle);
                    super.setTextFill(onIdle);
                    imageView.setImage(iconIdle);
                }
            }
        });
        
        super.setFocusTraversable(false);
        super.setToggleGroup(drawer.getToggleGroup());
    }

}
