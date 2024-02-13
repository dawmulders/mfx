/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package material.views.common;
import javafx.animation.FadeTransition;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.util.Duration;
import material.sys.Sys;




/**
 *
 * @author DMulders
 */
public class MaterialViewEntry extends AbstractMaterialView {

    protected FadeTransition fadeIn;
    protected FadeTransition fadeOut;
    
    public MaterialViewEntry(Parent parent, String menuName, String pageName, Image icon) {
        super(parent, menuName, pageName, icon);
        fadeIn = new FadeTransition(Duration.millis(300), parent);
        fadeIn.setFromValue(0);
        fadeIn.setToValue(1);
        fadeOut = new FadeTransition(Duration.millis(300), parent);
        fadeOut.setFromValue(1);
        fadeOut.setToValue(0);
    }

    


    @Override
    public void prepareBeforeShowing() {
        super.getParent().setOpacity(0);
        if (Sys.WRITE_INFO) {
            System.out.println();
        }
    }



    @Override
    public void onViewShown() {
        fadeIn.play();
    }



    @Override
    public void prepareBeforeHiding() {
        fadeOut.play();
    }



    @Override
    public void onViewHidden() {
    }

}
