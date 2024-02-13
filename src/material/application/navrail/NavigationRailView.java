/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package material.application.navrail;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;




/**
 *
 * @author DMulders
 */
public class NavigationRailView extends BorderPane implements INavRailController {

    private final ObservableList<INavRailView> navRailViews = FXCollections.observableArrayList();
    private final ObjectProperty<INavRailView> selectedViewProp = new SimpleObjectProperty<>();
    private final MaterialNavigationRail navRail;

    private final FlowPane contentFlowPane = new FlowPane();



    public NavigationRailView() {
        super();
        navRail = new MaterialNavigationRail(this);
        initNavRailView();
    }
    
    public MaterialNavigationRail getNavigationRail(){
        return navRail;
    }



    public void addNavRailView(INavRailView view) {
        navRailViews.add(view);
    }



    private void initNavRailView() {
        contentFlowPane.setAlignment(Pos.CENTER);
        super.setLeft(navRail);
        super.setCenter(contentFlowPane);
        selectedViewProp.addListener((o, v1, v2) -> {
            if (v1 != null) {
                //contentFlowPane.getChildren().remove(v1.getNavRailView());
            }
            if (v2 != null) {
                super.setCenter(v2.getNavRailView());
                
            }
        });
    }



    @Override
    public void setSelectedView(INavRailView navRailView) {
        selectedViewProp.set(navRailView);
    }



    @Override
    public ReadOnlyObjectProperty<INavRailView> getSelectedView() {
        return selectedViewProp;
    }



    @Override
    public ObservableList<INavRailView> getNavRailViews() {
        return navRailViews;
    }

}
