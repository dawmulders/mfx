/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package material.application.navrail;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.collections.ObservableList;




/**
 *
 * @author DMulders
 */
public interface INavRailController {

    public void setSelectedView(INavRailView navRailView);



    public ReadOnlyObjectProperty<INavRailView> getSelectedView();



    public ObservableList<INavRailView> getNavRailViews();

}
