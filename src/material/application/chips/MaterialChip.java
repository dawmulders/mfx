/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package material.application.chips;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ReadOnlyBooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import material.design.common.Icons;




/**
 *
 * @author DMulders
 */
public class MaterialChip extends GridPane {

    protected final ToggleButton container;
    protected final ImageView thumbnail;
    protected final Button removeButton;

    private final BooleanProperty isRemovableProperty = new SimpleBooleanProperty();

    protected Background bgIdle;
    protected Background bgHover;
    protected Background bgSelected;

    protected Border borderIdle;
    protected Border borderSelected;

    protected Color fillIdle;
    protected Color fillHover;
    protected Color fillSelected;



    public MaterialChip(String text, boolean removable) {
        super();
        container = new ToggleButton();
        thumbnail = new ImageView();
        removeButton = new Button();
    }



    public MaterialChip(Image thumbnail, String text, boolean removable) {
        this.container = new ToggleButton(text);
        this.thumbnail = new ImageView(thumbnail);
        this.removeButton = new Button();
    }



    public ToggleButton getContainer() {
        return container;
    }



    public ImageView getThumbnail() {
        return thumbnail;
    }



    public Button getRemoveButton() {
        return removeButton;
    }



    public ReadOnlyBooleanProperty getIsRemovableProperty() {
        return isRemovableProperty;
    }



    public boolean isRemovable() {
        return isRemovableProperty.get();
    }



    public void setRemovable(boolean value) {
        isRemovableProperty.set(value);
    }



    private void initBase() {
        container.setMinHeight(32);
        container.setPrefHeight(32);
        container.setMaxHeight(32);

    }




    public class ChipRemoveButton extends Button {

        private final ImageView imageView;



        public ChipRemoveButton() {
            super();
            imageView = new ImageView(Icons.getRemove(Icons.IconStyle.NONE));
            imageView.setFitWidth(18);
            imageView.setFitHeight(18);
            super.setBackground(Background.EMPTY);
            super.setBorder(Border.EMPTY);
        }
    }

}
