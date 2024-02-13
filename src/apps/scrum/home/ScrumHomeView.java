/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apps.scrum.home;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import material.application.content.IMaterialView;
import material.design.common.Icons;




/**
 *
 * @author DMulders
 */
public class ScrumHomeView implements IMaterialView {

    private final Image menuIcon = Icons.getHome(Icons.IconStyle.NONE);
    private final HomeView view;



    public ScrumHomeView() {
        view = new HomeView();
    }



    @Override
    public Parent getParent() {
        return view;
    }



    @Override
    public String getMenuName() {
        return "Home";
    }



    @Override
    public String getViewName() {
        return "Home";
    }



    @Override
    public Image getMenuIcon() {
        return menuIcon;
    }




    public class HomeView extends StackPane {
    }
}
