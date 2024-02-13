/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package material.application;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import material.application.content.WindowPane;
import material.design.common.Bgs;




/**
 *
 * @author DMulders
 */
public abstract class MaterialApplication extends Application {

    protected WindowPane windowPane;
    protected MaterialRootView rootView;
    protected MaterialScene materialScene;



    @Override
    public void start(Stage stage) throws Exception {
        rootView = new MaterialRootView();
        windowPane = new WindowPane();
        windowPane.setBackground(Bgs.windowPane());
        windowPane.setCenter(rootView);
        materialScene = new MaterialScene(windowPane);

        stage.setScene(materialScene);
        loadMaterialViews(rootView);
        stage.setMaximized(false);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
        stage.centerOnScreen();
    }



    public MaterialRootView getRootView() {
        return rootView;
    }



    public MaterialScene getMaterialScene() {
        return materialScene;
    }



    public abstract void loadMaterialViews(MaterialRootView rootview);

}
