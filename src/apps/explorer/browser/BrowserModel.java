/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apps.explorer.browser;
import apps.explorer.models.RootFile;
import apps.explorer.models.SystemFile;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;




/**
 *
 * @author DMulders
 */
public class BrowserModel {

    private final ObservableList<RootFile> rootFiles = FXCollections.observableArrayList();
    private final ObjectProperty<SystemFile> location = new SimpleObjectProperty<>();



    public ObservableList<RootFile> getRootFiles() {
        return rootFiles;
    }



    public void addRootFile(RootFile rootFile) {
        rootFiles.add(rootFile);
    }



    public void removeRootFile(RootFile rootFile) {
        rootFiles.remove(rootFile);
    }



    public ReadOnlyObjectProperty<SystemFile> getLocationProperty() {
        return location;
    }



    public SystemFile getLocation() {
        return location.get();
    }



    public void setLocation(SystemFile sysfile) {
        location.set(sysfile);
    }

}
