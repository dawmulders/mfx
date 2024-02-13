/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package material.application;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import material.application.appbar.MaterialAppBar;
import material.application.content.ContentView;
import material.application.content.IMaterialView;
import material.application.content.ScrimPane;
import material.application.dialogs.DialogPane;
import material.application.navigation.MenuDrawer;




/**
 *
 * @author DMulders
 */
public class MaterialRootView extends StackPane {

    private MaterialController controller;

    private ContentView contentView;
    private MenuDrawer drawer;
    private ScrimPane scrim;
    private DialogPane dialog;



    public MaterialRootView() {
        super();
        this.controller = new MaterialController(this);
        contentView = new ContentView(controller);
        drawer = new MenuDrawer(controller);
        scrim = new ScrimPane();
        dialog = new DialogPane(this);
        init();
    }



    public MaterialController getController() {
        return controller;
    }



    public MenuDrawer getMenuDrawer() {
        return drawer;
    }



    public ContentView getContentView() {
        return contentView;
    }



    public void showDialog() {
        dialog.onDialogShow();
    }



    public MaterialAppBar getAppBar() {
        return contentView.getAppBar();
    }



    public void addMenu(IMaterialView view) {
        controller.getMaterialViewList().add(view);
    }



    public void addAndSelectMenu(IMaterialView view) {
        controller.getMaterialViewList().add(view);
        controller.setMaterialView(view);
    }



    public void openNavigationDrawer() {
        scrim.setVisible(true);
        drawer.onMenuDrawerOpen();
    }



    public void closeNavigationDrawer() {
        scrim.setVisible(false);
        drawer.onMenuDrawerClose();
    }



    private void init() {
        super.setMinSize(800, 600);
        StackPane.setAlignment(contentView, Pos.CENTER);
        StackPane.setAlignment(scrim, Pos.CENTER);
        StackPane.setAlignment(drawer, Pos.TOP_LEFT);
        super.getChildren().add(contentView);
        super.getChildren().add(scrim);
        super.getChildren().add(drawer);
        super.getChildren().add(dialog);
        scrim.setVisible(false);
        dialog.setVisible(false);
        scrim.setOnMouseClicked((event) -> {
            closeNavigationDrawer();
        });

        contentView.getAppBar().setOnNavigationButtonClick((event) -> {
            openNavigationDrawer();
        });

    }

}
