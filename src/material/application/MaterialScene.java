/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package material.application;
import java.io.File;
import javafx.scene.Parent;
import javafx.scene.Scene;
import material.design.Mfx;




/**
 *
 * @author DMulders
 */
public class MaterialScene extends Scene {

    public MaterialScene(Parent parent) {
        super(parent, 1600, 900, Mfx.getP1());

        loadStyleSheetFile(new File("C:\\Libraries\\Code\\FxMaterial\\res\\css.material\\style.css"));
    }



    public final void loadStyleSheetFile(File file) {
        super.getStylesheets().add("file:///" + file.getAbsolutePath().replace("\\", "/"));
    }

}
