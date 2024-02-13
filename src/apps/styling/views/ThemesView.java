/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apps.styling.views;
import java.util.Iterator;
import java.util.List;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener.Change;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import material.application.MaterialRootView;
import material.application.buttons.ActionButton;
import material.application.buttons.FloatingActionButton;
import material.application.content.IMaterialView;
import material.application.texts.MaterialLabel;
import material.design.MaterialTheme;
import material.design.MaterialThemes;
import material.design.Mfx;
import material.design.colors.MaterialPalette;
import material.design.common.Colors;
import material.design.common.Fonts;
import material.design.common.Icons;
import material.design.typography.MaterialFont;
import material.design.typography.MaterialTypography;




/**
 *
 * @author DMulders
 */
public class ThemesView implements IMaterialView {

    private final Image menuIcon = Icons.getPalette(Icons.IconStyle.NONE);
    private final ThemesPane view;
    private final ObservableList<MaterialTheme> themeList = FXCollections.observableArrayList();
    private final ObjectProperty<MaterialTheme> selectedTheme = new SimpleObjectProperty<>();



    public ThemesView() {
        view = new ThemesPane();
    }



    public void createNewMaterialTheme() {
        MaterialRootView mrv = getMaterialRootView();
        if (null != mrv) {
            mrv.showDialog();
        }
    }



    @Override
    public Parent getParent() {
        return view;
    }



    @Override
    public String getMenuName() {
        return "Themes";
    }



    @Override
    public String getViewName() {
        return "My Themes";
    }



    @Override
    public Image getMenuIcon() {
        return menuIcon;
    }



    @Override
    public void prepareBeforeShowing() {
        if (themeList.isEmpty()) {
            themeList.addAll(MaterialThemes.loadAll());
        }
    }




    /**
     * Themes Pane -> The actual root view for ThemesView Contains a preview
     * pane and a list pane
     */
    public class ThemesPane extends BorderPane {

        public ThemesControlPane controlPane;
        public ThemesListPane listPane;
        public PreviewPane previewPane;
        public ThemesActionPane actionPane;



        public ThemesPane() {
            super();
            super.setPadding(new Insets(24));
            controlPane = new ThemesControlPane();
            listPane = new ThemesListPane();
            previewPane = new PreviewPane();
            actionPane = new ThemesActionPane();
            super.setTop(controlPane);
            super.setLeft(listPane);
            super.setCenter(previewPane);
            super.setBottom(actionPane);
        }

    }




    /**
     * Themes List Pane -> for selecting a Theme
     */
    public class ThemesListPane extends FlowPane {

        private final ObservableList<ThemeListButton> buttons = FXCollections.observableArrayList();
        private final ToggleGroup toggleGroup = new ToggleGroup();



        public ThemesListPane() {
            super();
            super.setPadding(new Insets(16));
            super.setHgap(8);
            super.setColumnHalignment(HPos.CENTER);
            super.setAlignment(Pos.TOP_LEFT);
            super.setBackground(Mfx.getBgSurface());

            themeList.addListener((Change<? extends MaterialTheme> c) -> {
                while (c.next()) {
                    if (c.wasAdded()) {
                        Iterator<? extends MaterialTheme> i = c.getAddedSubList().iterator();
                        while (i.hasNext()) {
                            MaterialTheme mt = i.next();
                            ThemeListButton tlb = new ThemeListButton(mt);
                            buttons.add(tlb);
                        }
                    } else if (c.wasRemoved()) {
                        Iterator<? extends MaterialTheme> i = c.getRemoved().iterator();
                        while (i.hasNext()) {
                            MaterialTheme mt = i.next();
                            ThemeListButton tlb = getButton(mt);
                            if (null != tlb) {
                                buttons.remove(tlb);
                            }
                        }
                    }
                }
            });

            buttons.addListener((Change<? extends ThemeListButton> c) -> {
                while (c.next()) {
                    if (c.wasAdded()) {
                        addButtons(c.getAddedSubList());
                    } else if (c.wasRemoved()) {
                        removeButtons(c.getRemoved());
                    }
                }
            });

            toggleGroup.selectedToggleProperty().addListener((o, v1, v2) -> {
                if (null != v2 && v2 instanceof ThemeListButton) {
                    ThemeListButton tlb = (ThemeListButton) v2;
                    selectedTheme.set(tlb.theme);
                } else {
                    selectedTheme.set(null);
                }
            });

        }



        private void addButtons(List<? extends ThemeListButton> buttons) {
            buttons.forEach((t) -> {
                t.setToggleGroup(toggleGroup);
            });
            super.getChildren().addAll(buttons);
        }



        private void removeButtons(List<? extends ThemeListButton> buttons) {
            buttons.forEach((t) -> {
                t.setSelected(false);
                t.setToggleGroup(null);
            });
            super.getChildren().removeAll(buttons);
        }



        public ThemeListButton getButton(MaterialTheme mt) {
            List<ThemeListButton> matches = buttons.filtered((t) -> {
                return t.theme == mt; //To change body of generated lambdas, choose Tools | Templates.
            });
            if (!matches.isEmpty()) {
                return matches.get(0);
            }
            return null;
        }

    }




    public class PreviewPane extends VBox {

        public final MaterialLabel lblTitle = new MaterialLabel("-", MaterialTypography.H5);

        public final PaletteLabel plP1 = new PaletteLabel("Primary", 3);
        public final PaletteLabel plP2 = new PaletteLabel("Primary variant", 3);
        public final PaletteLabel plS1 = new PaletteLabel("Secondary", 3);
        public final PaletteLabel plS2 = new PaletteLabel("Secondary variant", 3);

        public final PaletteLabel plBackground = new PaletteLabel("Background", 4);
        public final PaletteLabel plSurface = new PaletteLabel("Surface", 4);
        public final PaletteLabel plError = new PaletteLabel("Error", 4);

        public final PaletteLabel plOnP = new PaletteLabel("On primary", 6);
        public final PaletteLabel plOnS = new PaletteLabel("On secondary", 6);
        public final PaletteLabel plOnBg = new PaletteLabel("On background", 4);
        public final PaletteLabel plOnSurface = new PaletteLabel("On surface", 4);
        public final PaletteLabel plOnError = new PaletteLabel("On error", 4);



        public PreviewPane() {
            super();
            selectedTheme.addListener((o, v1, v2) -> {
                if (v2 != null) {
                    previewTheme(v2);
                } else {
                    clearPreview();
                }
            });
            init();
        }



        private void clearPreview() {
            lblTitle.setText("-");
            plP1.setColor(Color.WHITE);
            plP2.setColor(Color.WHITE);
            plS1.setColor(Color.WHITE);
            plS2.setColor(Color.WHITE);
            plBackground.setColor(Color.WHITE);
            plSurface.setColor(Color.WHITE);
            plError.setColor(Color.WHITE);
            plOnP.setColor(Color.WHITE);
            plOnS.setColor(Color.WHITE);
            plOnBg.setColor(Color.WHITE);
            plOnSurface.setColor(Color.WHITE);
            plOnError.setColor(Color.WHITE);
        }



        private void previewTheme(MaterialTheme theme) {
            lblTitle.setText(theme.getMaterialPalette().getPaletteName());
            loadColors(theme.getMaterialPalette());
            loadFonts(theme.getMaterialFont());
        }



        private void loadColors(MaterialPalette palette) {
            plP1.setColor((Color) palette.getPrimary());
            plP2.setColor((Color) palette.getPrimaryVariant());
            plS1.setColor((Color) palette.getSecondary());
            plS2.setColor((Color) palette.getSecondaryVariant());
            plBackground.setColor((Color) palette.getBackground());
            plSurface.setColor((Color) palette.getSurface());
            plError.setColor((Color) palette.getError());
            plOnP.setColor((Color) palette.getOnPrimary());
            plOnS.setColor((Color) palette.getOnSecondary());
            plOnBg.setColor((Color) palette.getOnBackground());
            plOnSurface.setColor((Color) palette.getOnSurface());
            plOnError.setColor((Color) palette.getOnError());
        }



        private void loadFonts(MaterialFont font) {

        }



        private void init() {
            super.setSpacing(4);
            super.setPadding(new Insets(16));
            super.setAlignment(Pos.CENTER);
            HBox box1 = new HBox();
            box1.setSpacing(4);
            box1.getChildren().addAll(plP1, plP2, plS1, plS2);

            HBox box2 = new HBox();
            box2.setSpacing(6);
            box2.getChildren().addAll(plBackground, plSurface, plError);

            HBox box3 = new HBox();
            box3.setSpacing(12);
            box3.getChildren().addAll(plOnP, plOnS);

            HBox box4 = new HBox();
            box4.setSpacing(6);
            box4.getChildren().addAll(plOnBg, plOnSurface, plOnError);

            super.getChildren().addAll(lblTitle, box1, box2, box3, box4);
        }

    }




    public class ThemesActionPane extends HBox {

        private final ActionButton btnEdit = new ActionButton(Icons.getEditor(Icons.IconStyle.NONE));
        private final ActionButton btnCopy = new ActionButton(Icons.getCopy(Icons.IconStyle.NONE));
        private final ActionButton btnRemove = new ActionButton(Icons.getRemove(Icons.IconStyle.NONE));



        public ThemesActionPane() {
            super();
            super.setMinHeight(72);
            super.setMaxHeight(72);
            super.setBackground(Background.EMPTY);
            super.setAlignment(Pos.CENTER_RIGHT);
            super.setSpacing(16);
            super.setBackground(Background.EMPTY);
            super.getChildren().addAll(btnEdit, btnCopy, btnRemove);
            selectedTheme.addListener((o, v1, v2) -> {
                if (v2 == null) {
                    btnEdit.setDisable(true);
                    btnCopy.setDisable(true);
                    btnRemove.setDisable(true);
                } else {
                    btnEdit.setDisable(false);
                    btnCopy.setDisable(false);
                    btnRemove.setDisable(false);
                }
            });
            btnEdit.setDisable(true);
            btnCopy.setDisable(true);
            btnRemove.setDisable(true);

        }

    }




    public class ThemesControlPane extends HBox {

        public FloatingActionButton fab = new FloatingActionButton();



        public ThemesControlPane() {
            super();
            super.setMinHeight(72);
            super.setMaxHeight(72);
            super.setBackground(Background.EMPTY);
            super.getChildren().add(fab);
            fab.setOnAction((ae) -> {
                createNewMaterialTheme();
            });
        }

    }




    public class ThemeListButton extends ToggleButton {

        public final MaterialTheme theme;

        private Background bgIdle;
        private Background bgHover;



        public ThemeListButton(MaterialTheme theme) {
            super(theme.getMaterialPalette().getPaletteName());
            this.theme = theme;
            super.setWrapText(true);
            super.setPrefWidth(80);
            super.setMinWidth(80);
            super.setMaxWidth(80);
            super.setMinHeight(72);
            super.setMaxHeight(72);
            super.setPrefHeight(72);
            super.setTextAlignment(TextAlignment.CENTER);

            bgIdle = new Background(new BackgroundFill(theme.p1(), new CornerRadii(4), Insets.EMPTY));
            bgHover = new Background(new BackgroundFill(theme.p2(), new CornerRadii(4), Insets.EMPTY));
            super.setFont(theme.caption());
            super.setTextFill(Colors.getOnColor((Color) theme.p1()));
            super.setBackground(bgIdle);
            super.setFocusTraversable(false);
            super.hoverProperty().addListener((o, v1, v2) -> {
                if (v2) {
                    super.setBackground(bgHover);
                } else {
                    if (!super.isSelected()) {
                        super.setBackground(bgIdle);
                    }
                }
            });
            super.selectedProperty().addListener((o, v1, v2) -> {
                if (v2) {
                    super.setBackground(bgHover);
                } else {
                    super.setBackground(bgIdle);
                }
            });
            super.setBorder(Border.EMPTY);
        }
    }




    public class PaletteLabel extends AnchorPane {

        private Label lblTitle;
        private Label lblHex;



        public PaletteLabel(String title, int columns) {
            super();
            super.setPrefWidth(columns * 80);
            lblTitle = new Label(title);
            lblHex = new Label("#------");
            AnchorPane.setTopAnchor(lblTitle, 16.0);
            AnchorPane.setLeftAnchor(lblTitle, 16.0);
            AnchorPane.setRightAnchor(lblHex, 16.0);
            AnchorPane.setBottomAnchor(lblHex, 16.0);
            init();

        }



        public void setColor(Color color) {
            super.setBackground(new Background(new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY)));
            lblHex.setText(Colors.hexRGB(color));
            Color textFill = Colors.getOnColor(color);
            lblHex.setTextFill(textFill);
            lblTitle.setTextFill(textFill);
        }



        private void init() {
            super.getChildren().addAll(lblTitle, lblHex);
            super.setMinHeight(120);
            lblTitle.setFont(Fonts.robotoMedium(14));
            lblHex.setFont(Fonts.roboto(12));
            setColor(Color.WHITE);

        }

    }

}
