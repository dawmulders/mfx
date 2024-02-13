/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apps.styling.views;
import apps.styling.stylesheets.StylesheetEditor;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import material.application.content.IMaterialView;
import material.design.common.Icons;




/**
 *
 * @author DMulders
 */
public class CssTemplateView implements IMaterialView {

    private final Image menuIcon = Icons.getCss(Icons.IconStyle.NONE);
    private final StylesheetEditor view;



    public CssTemplateView() {
        view = new StylesheetEditor();
    }



    @Override
    public Parent getParent() {
        return view;
    }



    @Override
    public String getMenuName() {
        return "css";
    }



    @Override
    public String getViewName() {
        return "Css Template Dditor";
    }



    @Override
    public Image getMenuIcon() {
        return menuIcon;
    }

}
