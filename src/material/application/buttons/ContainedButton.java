/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package material.application.buttons;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.text.TextAlignment;
import material.design.Mfx;
import material.design.common.Bgs;
import material.design.common.Shadows;




/**
 *
 * @author DMulders
 */
public class ContainedButton extends Button {

    private final Background bgIdle = Bgs.bgContainedButtonIdle();
    private final Background bgHover = Bgs.bgContainedButtonHover();
    private final DropShadow dsIdle = Shadows.buttonIdle();
    private final DropShadow dsHover = Shadows.buttonHover();



    public ContainedButton(String text) {
        super(text.toUpperCase());
        init();
    }



    private void init() {
        super.setMinSize(64, 36);
        super.setHeight(36);
        super.setMaxHeight(36);
        super.setTextAlignment(TextAlignment.CENTER);
        super.setTextFill(Mfx.getOnPrimary());
        super.setFont(Mfx.getBtn());
        super.setPadding(new Insets(0, 16, 0, 16));

        super.setBorder(Border.EMPTY);
        super.setEffect(dsIdle);
        super.setBackground(bgIdle);
        super.hoverProperty().addListener((o, v1, v2) -> {
            if (v2) {
                super.setEffect(dsHover);
                super.setBackground(bgHover);
            } else {
                super.setEffect(dsIdle);
                super.setBackground(bgIdle);
            }
        });

    }
}
