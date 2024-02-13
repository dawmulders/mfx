/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package material.application.appbar;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import material.application.buttons.MaterialIconButton;
import material.application.texts.MaterialLabel;
import material.design.Mfx;
import material.design.common.Icons;
import material.design.common.Icons.IconStyle;
import material.design.typography.MaterialTypography;




/**
 *
 * @author DMulders
 */
public class MaterialAppBar extends AnchorPane {

    private final MaterialIconButton navigationButton;
    private final MaterialLabel titleLabel;
    private final HBox buttonBox = new HBox();
    private final HBox leftBox = new HBox();



    public MaterialAppBar() {
        super();
        navigationButton = new MaterialIconButton(Icons.getHamburgerMenu(IconStyle.LIGHT), false);
        titleLabel = new MaterialLabel("Page title", MaterialTypography.H6);
        init();
    }



    public void setOnNavigationButtonClick(EventHandler<ActionEvent> handler) {
        navigationButton.setOnAction(handler);
    }



    public void setPageTitle(String pageTitle) {
        titleLabel.setText(pageTitle);
    }



    public HBox getButtonBox() {
        return buttonBox;
    }



    private void init() {
        super.setPrefWidth(Double.MAX_VALUE);
        super.setPrefHeight(56);
        super.setBackground(Mfx.getBgPrimary());
        titleLabel.setTextFill(Mfx.getOnPrimary());

        AnchorPane.setTopAnchor(navigationButton, 16.0);
        AnchorPane.setBottomAnchor(navigationButton, 16.0);
        AnchorPane.setLeftAnchor(navigationButton, 16.0);
        super.getChildren().add(navigationButton);

        AnchorPane.setTopAnchor(titleLabel, 16.0);
        AnchorPane.setBottomAnchor(titleLabel, 16.0);
        AnchorPane.setLeftAnchor(titleLabel, 16.0 + navigationButton.getPrefWidth() + 32.0); //padding + width navigastionbutton + spacing between title and navigationbutton
        super.getChildren().add(titleLabel);

        buttonBox.setSpacing(24);
        AnchorPane.setTopAnchor(buttonBox, 16.0);
        AnchorPane.setBottomAnchor(buttonBox, 16.0);
        AnchorPane.setRightAnchor(buttonBox, 16.0);
        super.getChildren().add(buttonBox);

    }
}
