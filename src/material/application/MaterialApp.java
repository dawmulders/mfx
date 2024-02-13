/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package material.application;
import javafx.application.Application;
import javafx.stage.Stage;
import material.views.demo.DemoHomeView;
import material.views.demo.DemoLaunchView;
import material.views.demo.DemoSettingsView;




/**
 *
 * @author DMulders
 */
public class MaterialApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        MaterialRootView rootview = new MaterialRootView();
        DemoHomeView homeView = new DemoHomeView();
        DemoLaunchView launchView = new DemoLaunchView();
        DemoSettingsView view = new DemoSettingsView();
        rootview.addMenu(homeView);
        rootview.addMenu(launchView);

        rootview.addAndSelectMenu(view);

        MaterialScene scene = new MaterialScene(rootview);
        stage.setScene(scene);
        stage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }
}
