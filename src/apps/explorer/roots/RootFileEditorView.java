/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apps.explorer.roots;
import apps.explorer.models.Directories;
import apps.explorer.models.Directory;
import apps.explorer.models.RootFile;
import java.util.List;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Parent;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import material.application.buttons.MaterialIconButton;
import material.application.content.IMaterialView;
import material.application.texts.MaterialLabel;
import material.design.common.Icons;
import material.design.typography.MaterialTypography;




/**
 *
 * @author DMulders
 */
public class RootFileEditorView implements IMaterialView {

    private final Image menuIcon;
    private final RootFileEditorPane view;



    public RootFileEditorView() {
        menuIcon = Icons.getFolderManager(Icons.IconStyle.NONE);
        view = new RootFileEditorPane();
    }



    @Override
    public Parent getParent() {
        return view;
    }



    @Override
    public String getMenuName() {
        return "Edit";
    }



    @Override
    public String getViewName() {
        return "Root file editor";
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




    public class RootFileEditorPane extends BorderPane {

        private final ListView<RootFile> listView = new ListView<>();
        private final HBox controlBox = new HBox();
        private final RootFileEditor editor;



        public RootFileEditorPane() {
            super();
            editor = new RootFileEditor();
            super.setLeft(listView);
            super.setCenter(editor);
            super.setBottom(controlBox);
            listView.getSelectionModel().selectedItemProperty().addListener((o, v1, v2) -> {
                editor.setRootFile(v2);
            });
            listView.getItems().addAll(Directories.listRoots());
            MaterialIconButton mibCreateRoot = new MaterialIconButton(Icons.getFolderCreate(Icons.IconStyle.NONE), true);
            mibCreateRoot.setOnAction((event) -> {
                createRoot();
            });
            controlBox.getChildren().add(mibCreateRoot);
        }



        private void createRoot() {

        }

    }




    public class RootFileEditor extends GridPane {

        private final MaterialLabel title = new MaterialLabel("Titel", MaterialTypography.H3);
        private final TextArea textArea = new TextArea();
        private final ObjectProperty<RootFile> rootProp = new SimpleObjectProperty<>();



        public RootFileEditor() {
            super();
            init();
        }



        public void setRootFile(RootFile rf) {
            rootProp.set(rf);
        }



        private void init() {
            GridPane.setConstraints(title, 0, 0, 1, 1, HPos.LEFT, VPos.BASELINE);
            GridPane.setConstraints(textArea, 0, 1, 1, 1, HPos.LEFT, VPos.BASELINE);
            super.getChildren().addAll(title, textArea);
            super.setVgap(32);
            textArea.setPrefColumnCount(120);
            textArea.setPrefRowCount(30);
            rootProp.addListener((o, v1, v2) -> {
                if (v2 != null) {
                    title.setText(v2.rootName);
                    List<Directory> dirs = v2.createDirectoryList();
                    textArea.setText("");
                    String raw = "";
                    for (int i = 0; i < dirs.size(); i++) {
                        raw += dirs.get(i).getAbsolutePath();
                        raw += "\n";
                    }
                    textArea.setText(raw);
                }
            });
        }

    }

}
