/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apps.explorer;
import apps.explorer.browser.BrowserModel;
import apps.explorer.browser.MaterialBrowserView;
import apps.explorer.models.Directories;
import apps.explorer.models.RootFile;
import apps.explorer.roots.RootFileEditorView;
import material.application.MaterialApplication;
import material.application.MaterialRootView;




/**
 *
 * @author DMulders
 */
public class MaterialFileExplorer extends MaterialApplication {

    public static void main(String[] args) {
        launch(args);
    }



    @Override
    public void loadMaterialViews(MaterialRootView rootview) {
        model = new BrowserModel();

        browserView = new MaterialBrowserView(model);
        rootview.addAndSelectMenu(browserView);
        
        editorView = new RootFileEditorView();
        rootview.addMenu(editorView);
        
        RootFile[] roots = Directories.listRoots();
        for(RootFile root:roots){
            model.addRootFile(root);
        }
    }

    private BrowserModel model;

    private MaterialBrowserView browserView;
    private RootFileEditorView editorView;

}
