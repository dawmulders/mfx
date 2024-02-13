/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package material.views.common;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import material.application.content.IMaterialView;




/**
 *
 * @author DMulders
 */
public abstract class AbstractMaterialView implements IMaterialView {

    private final Parent parent;
    private final String menuName;
    private final String pageName;
    private final Image menuIcon;



    public AbstractMaterialView(Parent parent, String menuName, String pageName, Image icon) {
        this.parent = parent;
        this.menuName = menuName;
        this.pageName = pageName;
        this.menuIcon = icon;
    }



    @Override
    public Parent getParent() {
        return parent;
    }



    @Override
    public String getMenuName() {
        return menuName;
    }



    @Override
    public String getViewName() {
        return pageName;
    }



    @Override
    public Image getMenuIcon() {
        return menuIcon;
    }

}
