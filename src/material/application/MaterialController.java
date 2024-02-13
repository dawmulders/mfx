/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package material.application;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import material.application.content.IMaterialView;




/**
 *
 * @author DMulders
 */
public class MaterialController {

    private MaterialRootView rootView = null;
    private final ObservableList<IMaterialView> viewList = FXCollections.observableArrayList();
    private final ObjectProperty<IMaterialView> currentView = new SimpleObjectProperty<>();



    public MaterialController() {
    }



    public MaterialController(MaterialRootView rootview) {
        this.rootView = rootview;
    }



    public MaterialRootView getRootView() {
        return rootView;
    }



    public void setRootView(MaterialRootView rootView) {
        this.rootView = rootView;
    }



    public void setMaterialView(IMaterialView view) {
        currentView.set(view);
    }



    public ReadOnlyObjectProperty<IMaterialView> getCurrentViewProperty() {
        return currentView;
    }



    public ObservableList<IMaterialView> getMaterialViewList() {
        return viewList;
    }

}
