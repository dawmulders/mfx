/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apps.explorer.navigator;
import apps.explorer.browser.BrowserModel;
import apps.explorer.models.RootFile;
import java.util.Iterator;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener.Change;
import javafx.collections.ObservableList;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import material.application.layouts.MaterialScrollPane;




/**
 *
 * @author DMulders
 */
public class MaterialFileTreeView extends BorderPane {

    private final BrowserModel model;
    private final MaterialScrollPane scroller;
    private final VBox treeBox = new VBox();

    private final ObservableList<FileTreeView> treeViews = FXCollections.observableArrayList();
    private FileTreeItem selectedItem;



    public MaterialFileTreeView(BrowserModel model) {
        super();
        this.model = model;
        this.scroller = new MaterialScrollPane();
        init();
    }



    public void setSelectedFileTreeItem(FileTreeItem item) {
        Iterator<FileTreeView> i = treeViews.iterator();
        while (i.hasNext()) {
            FileTreeView treeview = i.next();
            if (treeview.getSelectionModel().getSelectedItem() != item) {
                treeview.getSelectionModel().clearSelection();
            }
        }
        model.setLocation(item.getValue());
    }



    public void createNewRoot(RootFile rootFile) {
        FileTreeView treeView = new FileTreeView(rootFile);
        treeView.setPrefHeight(900);
        treeViews.add(treeView);
        treeView.getSelectionModel().selectedItemProperty().addListener((o, v1, v2) -> {
            if (v2 != null) {
                if (v2 instanceof FileTreeItem) {
                    FileTreeItem fti = (FileTreeItem) v2;
                    setSelectedFileTreeItem(fti);
                }
            }
        });
    }



    private void init() {
        super.setCenter(scroller);
        scroller.setContent(treeBox);
        treeBox.setPrefHeight(1200);
        model.getRootFiles().addListener((Change<? extends RootFile> c) -> {
            while (c.next()) {
                if (c.wasAdded()) {
                    Iterator<? extends RootFile> i = c.getAddedSubList().iterator();
                    while (i.hasNext()) {
                        createNewRoot(i.next());
                    }
                }
            }
        });

        treeViews.addListener((Change<? extends FileTreeView> c) -> {
            while (c.next()) {
                if (c.wasAdded()) {
                    Iterator<? extends FileTreeView> i = c.getAddedSubList().iterator();
                    while (i.hasNext()) {
                        FileTreeView view = i.next();
                        treeBox.getChildren().add(view);
                    }

                }
            }
        });
    }
}
