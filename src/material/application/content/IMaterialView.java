/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package material.application.content;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import material.application.MaterialRootView;




/**
 *
 * @author DMulders
 */
public interface IMaterialView {

    public Parent getParent();



    public String getMenuName();



    public String getViewName();



    public Image getMenuIcon();



    public default void prepareBeforeShowing() {
    }



    public default void onViewShown() {
    }



    public default void prepareBeforeHiding() {
    }



    public default void onViewHidden() {
    }



    public default MaterialRootView getMaterialRootView() {
        Parent curr = getParent();
        MaterialRootView root = null;
        while (curr != null) {
            if (curr instanceof MaterialRootView) {
                root = (MaterialRootView) curr;
                break;
            }
            curr = curr.getParent();
        }
        return root;
    }

}
