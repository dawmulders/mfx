/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package material.application.texts;
import javafx.scene.control.Label;
import material.design.Mfx;
import material.design.typography.MaterialTypography;




/**
 *
 * @author DMulders
 */
public class MaterialLabel extends Label {

    public MaterialLabel(String text, MaterialTypography mt) {
        super(text);
        super.getStyleClass().add("material-label");
        super.setFont(Mfx.getTypography(mt));

    }



    public MaterialLabel(String text, MaterialTypography mt, double fixedWidth) {
        super(text);
        super.getStyleClass().add("material-label");
        super.setFont(Mfx.getTypography(mt));
        super.setMinWidth(fixedWidth);
        super.setPrefWidth(fixedWidth);
        super.setMaxWidth(fixedWidth);

    }

}
