/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.views.apps;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import material.application.MaterialApplication;
import material.application.MaterialRootView;
import material.application.content.IMaterialView;
import material.application.sidebar.MaterialSidebarView;
import material.design.common.Icons;




/**
 *
 * @author DMulders
 */
public class SidebarTest extends MaterialApplication {

    public static void main(String[] args) {
        launch(args);
    }



    @Override
    public void loadMaterialViews(MaterialRootView rootview) {
        rootview.addAndSelectMenu(new SideBarView());
    }




    public class SideBarView implements IMaterialView {

        private final MaterialSidebarView view = new MaterialSidebarView();
        private final Image icon = Icons.getThea(Icons.IconStyle.NONE);



        @Override
        public Parent getParent() {
            return view;
        }



        @Override
        public String getMenuName() {
            return "";
        }



        @Override
        public String getViewName() {
            return "";
        }



        @Override
        public Image getMenuIcon() {
            return icon;
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
}
