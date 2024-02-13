/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package material.application.sidebar;
import javafx.scene.layout.GridPane;
import material.design.Mfx;




/**
 *
 * @author DMulders
 */
public class MaterialSideBar extends GridPane {

    public MaterialSideBar() {
        super();
        init();
    }



    private void init() {
        super.setBackground(Mfx.getBgSecondary());
        super.setMinWidth(72);
    }

}
