/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apps.explorer.browser;
import apps.explorer.navigator.MaterialFileTreeView;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import material.application.content.IMaterialView;
import material.design.common.Icons;




/**
 *
 * @author DMulders
 */
public class MaterialBrowserView implements IMaterialView {

    private final BrowserModel model;
    private final Image menuIcon;
    private final BorderPane view;
    private final BrowserPane browserView;
    private final MaterialFileTreeView treeView;



    public MaterialBrowserView(BrowserModel model) {
        this.model = model;
        this.menuIcon = Icons.getExplore(Icons.IconStyle.NONE);
        this.treeView = new MaterialFileTreeView(model);
        browserView = new BrowserPane(model);
        view = new BorderPane();
        view.setCenter(browserView);
        view.setLeft(treeView);
    }



    @Override
    public Parent getParent() {
        return view;
    }



    @Override
    public String getMenuName() {
        return "Explorer";
    }



    @Override
    public String getViewName() {
        return "File explorer";
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
