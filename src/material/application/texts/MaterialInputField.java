/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package material.application.texts;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import material.design.Mfx;
import material.design.common.Bgs;
import material.design.common.Borders;




/**
 *
 * @author DMulders
 */
public class MaterialInputField extends TextField {

    private final Background bgIdle, bgHover, bgSelected;
    private final Border bIdle, bHover, bSelected;



    public MaterialInputField() {
        super();
        super.getStyleClass().add("material-input-field");
        bgIdle = Bgs.inputFieldIdle();
        bgHover = Bgs.inputFieldHover();
        bgSelected = Bgs.inputFieldActive();
        bIdle = Borders.inputFieldIdle();
        bHover = Borders.inputFieldHover();
        bSelected = Borders.inputFieldSelected();
        init();
    }



    private void init() {
        super.setBackground(bgIdle);
        super.setBorder(bIdle);
        super.setFont(Mfx.getBody());
        super.setMinHeight(48);
        super.setMaxHeight(48);
        super.setPrefHeight(48);
        super.setMinWidth(280);

        super.focusedProperty().addListener((o, v1, v2) -> {
            if (v2) {
                super.setBackground(bgSelected);
                super.setBorder(bSelected);
            } else {
                super.setBackground(bgIdle);
                super.setBorder(bIdle);
            }
        });

        super.hoverProperty().addListener((o, v1, v2) -> {
            if (v2) {
                if (!super.isFocused()) {
                    super.setBorder(bHover);
                    super.setBackground(bgHover);
                }
            } else {
                if (!super.isFocused()) {
                    super.setBorder(bIdle);
                    super.setBackground(bgIdle);
                }
            }
        });

    }

}
