/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package material.application.content;
import java.io.File;
import java.io.FileInputStream;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import material.application.MaterialController;
import material.application.appbar.MaterialAppBar;
import material.design.Mfx;
import material.sys.Sys;




/**
 *
 * @author DMulders
 */
public class ContentView extends AnchorPane {

    private final MaterialController controller;
    private final MaterialAppBar appBar;



    public ContentView(MaterialController controller) {
        super();
        this.controller = controller;
        this.appBar = new MaterialAppBar();
        init();
    }



    public MaterialAppBar getAppBar() {
        return appBar;
    }



    private void init() {
        AnchorPane.setTopAnchor(appBar, 0.0);
        AnchorPane.setLeftAnchor(appBar, 0.0);
        AnchorPane.setRightAnchor(appBar, 0.0);
        super.getChildren().add(appBar);
        try {
            File file = new File("C:\\Libraries\\Code\\FxMaterial\\res\\graphics\\backgrounds\\material_bg.png");
            Image img = new Image(new FileInputStream(file));
            super.setBackground(new Background(new BackgroundImage(img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true))));
        } catch (Exception e) {
        }

        this.controller.getCurrentViewProperty().addListener((o, v1, v2) -> {
            if (v1 != null && super.getChildren().contains(v1.getParent())) {
                unloadMaterialView(v1);
            }
            if (v2 != null) {
                loadMaterialView(v2);
            }
        });
    }



    private void unloadMaterialView(IMaterialView view) {
        if (Sys.WRITE_INFO) {
            System.out.println("Unloading material view");
        }
        view.prepareBeforeHiding();
        super.getChildren().remove(view.getParent());
        Platform.runLater(() -> {
            view.onViewHidden();
        });

    }



    private void loadMaterialView(IMaterialView view) {
        super.setBackground(Mfx.BG_TRANS);
        Parent parent = view.getParent();
        AnchorPane.setTopAnchor(parent, 56.0);
        AnchorPane.setBottomAnchor(parent, 0.0);
        AnchorPane.setLeftAnchor(parent, 0.0);
        AnchorPane.setRightAnchor(parent, 0.0);
        view.prepareBeforeShowing();
        super.getChildren().add(parent);
        appBar.setPageTitle(view.getViewName());
        Platform.runLater(() -> {
            view.onViewShown();
        });

    }

}
