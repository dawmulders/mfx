/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package material.views.demo;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.layout.FlowPane;
import material.application.buttons.ContainedButton;
import material.application.buttons.OutlinedButton;
import material.application.buttons.TextButton;
import material.application.content.IMaterialView;
import material.application.layouts.GridView;
import material.application.texts.MaterialTextField;
import material.design.common.Icons;




/**
 *
 * @author DMulders
 */
public class DemoSettingsView implements IMaterialView {

    private SettingsView settingsView;
    private Image menuIcon;



    public DemoSettingsView() {
        settingsView = new SettingsView();
        menuIcon = Icons.getSettings(Icons.IconStyle.PRIMARY);
    }



    @Override
    public Parent getParent() {
        return settingsView;
    }



    @Override
    public String getMenuName() {
        return "Settings";
    }



    @Override
    public String getViewName() {
        return "Settings";
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




    public class SettingsView extends FlowPane {

        private final GridView grid = new GridView();



        public SettingsView() {
            super();
            init();
        }



        private void init() {
            super.setAlignment(Pos.CENTER);
            super.getChildren().add(grid);

            grid.setMinSize(500, 500);
            grid.addChild(new MaterialTextField("Test"), 0, 0, 1, 1, HPos.LEFT, VPos.BASELINE);
            grid.addChild(new MaterialTextField("Longer label test"), 1, 0, 1, 1, HPos.LEFT, VPos.BASELINE);
            grid.addChild(new MaterialTextField("Helper test", "Helper text"), 0, 1, 1, 1, HPos.LEFT, VPos.BASELINE);

            grid.addChild(new ContainedButton("Contained"), 1, 1, 1, 1, HPos.CENTER, VPos.BASELINE);
            grid.addChild(new OutlinedButton("outlined"), 0, 2, 1, 1, HPos.CENTER, VPos.BASELINE);
            grid.addChild(new TextButton("Text"), 1, 2, 1, 1, HPos.CENTER, VPos.BASELINE);

        }

    }

}
