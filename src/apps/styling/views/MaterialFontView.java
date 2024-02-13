/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apps.styling.views;
import java.io.File;
import java.util.Iterator;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import material.application.buttons.ActionButton;
import material.application.content.IMaterialView;
import material.application.texts.MaterialLabel;
import material.design.Mfx;
import material.design.common.Icons;
import material.design.common.Strings;
import material.design.typography.MaterialFont;
import material.design.typography.MaterialTypography;
import material.design.typography.MfxFont;
import material.sys.Sys;




/**
 *
 * @author DMulders
 */
public class MaterialFontView implements IMaterialView {

    private final Image menuIcon = Icons.getTextFields(Icons.IconStyle.NONE);
    private final MaterialFontDisplay view;
    private final ObjectProperty<MaterialFont> materialFont = new SimpleObjectProperty<>();
    private final ObservableList<MfxFont> mfxFontList = FXCollections.observableArrayList();
    private final ObservableList<File> fontFileList = FXCollections.observableArrayList();

    private MfxListCell expandedCell = null;



    public MaterialFontView() {
        view = new MaterialFontDisplay();
        materialFont.addListener((o, v1, v2) -> {
            mfxFontList.clear();
            if (v2 != null) {
                MaterialTypography[] types = MaterialTypography.getTypes();
                for (int i = 0; i < types.length; i++) {
                    mfxFontList.add(new MfxFont(types[i], v2.typography(types[i])));
                }
            }
        });
    }



    public void openMaterialFont(MaterialFont font) {
        this.materialFont.set(font);
    }



    public void selectNewFontFile() {
        FileChooser chooser = new FileChooser();
        chooser.setInitialDirectory(Sys.getLastLocationProperty("select_font"));
        chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Font file", "*.ttf", "*.otf", "*.woff", "*.woff2"));
        File fontFile = chooser.showOpenDialog(view.getScene().getWindow());
        if (fontFile != null) {
            Sys.setLastLocationProperty("select_font", fontFile.getParentFile());
            fontFileList.add(fontFile);
        }

    }



    public void setMaterialFont(MaterialFont font) {
        this.materialFont.set(font);
    }



    public MfxFont getMfxFont(MaterialTypography typo) {
        MfxFont match = null;
        Iterator<MfxFont> i = mfxFontList.iterator();
        while (i.hasNext()) {
            MfxFont mfxFont = i.next();
            if (mfxFont.typography == typo) {
                match = mfxFont;
                break;
            }
        }
        return match;
    }



    public void setMfxFont(MfxFont mfxFont) {
        MfxFont prev = getMfxFont(mfxFont.typography);
        if (prev != null) {
            int index = mfxFontList.indexOf(prev);
            mfxFontList.remove(prev);
            mfxFontList.set(index, mfxFont);
        } else {
            mfxFontList.add(mfxFont);
        }
    }



    @Override
    public Parent getParent() {
        return view;
    }



    @Override
    public String getMenuName() {
        return "Fonts";
    }



    @Override
    public String getViewName() {
        return "Material Font Designer";
    }



    @Override
    public Image getMenuIcon() {
        return menuIcon;
    }




    public class MaterialFontDisplay extends StackPane {

        public final MaterialFontListView fontListView = new MaterialFontListView();
        public final BorderPane rootPane = new BorderPane();



        public MaterialFontDisplay() {
            super();
            init();
        }



        private void init() {
            FlowPane header = new FlowPane();
            ActionButton btnLoad = new ActionButton(Icons.getReload(Icons.IconStyle.NONE));
            header.getChildren().add(btnLoad);
            btnLoad.setOnAction((ae) -> {
                materialFont.set(null);
                materialFont.set(new MaterialFont(true));
            });
            rootPane.setTop(header);
            rootPane.setCenter(fontListView);
            StackPane.setAlignment(rootPane, Pos.CENTER);
            super.getChildren().add(rootPane);
        }

    }




    public class MaterialFontListView extends ListView<MfxFont> {

        public MaterialFontListView() {
            super(mfxFontList);
            super.setCellFactory((param) -> {
                return new MfxListCell();
            });
        }

    }




    public class MfxListCell extends ListCell<MfxFont> {

        TitledPane cellRoot = new TitledPane();
        
        final GridPane contentNode = new GridPane();
        final MaterialLabel lblFont, lblWeight, lblSize;
        final MaterialLabel valFont, valWeight, valSize;



        public MfxListCell() {
            super();
            
            lblFont = new MaterialLabel("Font", MaterialTypography.CAPTION, 120);
            lblWeight = new MaterialLabel("Weight", MaterialTypography.CAPTION, 120);
            lblSize = new MaterialLabel("Size", MaterialTypography.CAPTION, 120);
            valFont = new MaterialLabel("-", MaterialTypography.CAPTION, 120);
            valWeight = new MaterialLabel("-", MaterialTypography.CAPTION, 120);
            valSize = new MaterialLabel("-", MaterialTypography.CAPTION, 120);
            lblFont.setTextFill(Mfx.TEXT_GRAY);
            lblWeight.setTextFill(Mfx.TEXT_GRAY);
            lblSize.setTextFill(Mfx.TEXT_GRAY);
            GridPane.setConstraints(lblFont, 0, 0);
            GridPane.setConstraints(lblWeight, 1, 0);
            GridPane.setConstraints(lblSize, 2, 0);
            GridPane.setConstraints(valFont, 0, 1);
            GridPane.setConstraints(valWeight, 1, 1);
            GridPane.setConstraints(valSize, 2, 1);
            contentNode.getChildren().addAll(lblFont, lblWeight, lblSize, valFont, valWeight, valSize);
            cellRoot.setContent(contentNode);
            super.itemProperty().addListener((o, v1, v2) -> {
                if (v2 == null) {
                    cellRoot.setText("");
                    valFont.setText("-");
                    valWeight.setText("-");
                    valSize.setText("-");
                } else {

                }
            });
            cellRoot.setAnimated(true);
            cellRoot.setExpanded(false);
            cellRoot.expandedProperty().addListener((o, v1, v2) -> {
                if (v2) {
                    if (expandedCell != null) {
                        expandedCell.cellRoot.setExpanded(false);
                    }
                    expandedCell = this;
                }
            });
        }



        @Override
        public void updateItem(MfxFont item, boolean empty) {
            super.updateItem(item, empty);
            super.setText("");
            if (!empty) {
                super.setGraphic(cellRoot);
                MaterialLabel ml = new MaterialLabel(MaterialTypography.getFullName(item.typography), item.typography);
                cellRoot.setGraphic(ml);
                valFont.setText(item.font.getFamily());
                valWeight.setText(item.font.getStyle());
                valSize.setText(Strings.d0(item.font.getSize()));
            } else {
                super.setGraphic(null);
            }
        }

    }

}
