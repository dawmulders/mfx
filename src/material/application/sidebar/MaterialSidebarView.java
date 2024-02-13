/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package material.application.sidebar;
import javafx.scene.layout.BorderPane;




/**
 *
 * @author DMulders
 */
public class MaterialSidebarView extends BorderPane {

    private final MaterialSideBar sidebar;



    public MaterialSidebarView() {
        super();
        sidebar = new MaterialSideBar();
        super.setLeft(sidebar);
    }

}
