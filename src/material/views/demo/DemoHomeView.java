/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package material.views.demo;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import material.application.content.IMaterialView;
import material.design.common.Icons;
import material.views.common.MaterialContentCardView;




/**
 *
 * @author DMulders
 */
public class DemoHomeView implements IMaterialView {

    private final Image menuIcon = Icons.getHome(Icons.IconStyle.NONE);
    private final MaterialContentCardView view;


    public DemoHomeView() {
        super();
        view = new MaterialContentCardView();
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



    @Override
    public void prepareBeforeShowing() {
    }



    @Override
    public void onViewShown() {
    }



    @Override
    public void prepareBeforeHiding() {
    }



    @Override
    public void onViewHidden() {
    }

}
