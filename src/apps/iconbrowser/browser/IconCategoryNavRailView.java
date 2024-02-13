/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apps.iconbrowser.browser;
import apps.iconbrowser.gitrepo.MaterialIconCategory;
import apps.iconbrowser.gitrepo.MaterialIconStyle;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Iterator;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener.Change;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import material.application.layouts.HeaderedScrollPane;
import material.application.layouts.MaterialScrollPane;
import material.application.navrail.INavRailView;
import material.application.texts.MaterialLabel;
import material.design.common.Bgs;
import material.design.common.Borders;
import material.design.common.Strings;
import material.design.typography.MaterialTypography;




/**
 *
 * @author DMulders
 */
public class IconCategoryNavRailView implements INavRailView, ChangeListener<MaterialIconStyle> {

    private static String RESOURCE_PATH = "C:\\Libraries\\Code\\FxMaterial\\res\\materialicons";

    private final MaterialIconCategory category;
    private final Image navRailIcon;
    private final String menuName;
    private final ObservableList<IconImage> icons = FXCollections.observableArrayList();
    private final IconView view;
    private final HeaderedScrollPane headeredScroller;
    private final MaterialScrollPane scroller;

    


    public IconCategoryNavRailView(Image menuIcon, String menuName, MaterialIconCategory cat) {
        this.category = cat;
        this.menuName = menuName;
        this.navRailIcon = menuIcon;
        this.view = new IconView();
        this.headeredScroller = new HeaderedScrollPane();
        this.scroller = headeredScroller.getScroller();
        scroller.setContent(view);
        scroller.setFitToWidth(true);
        scroller.setFitToHeight(false);

    }



    public void onCategoryViewLoaded(MaterialIconStyle style) {
        if (icons.isEmpty()) {
            File folder = new File(RESOURCE_PATH + "\\" + category.name() + "\\" + style.name());
            File[] files = folder.listFiles();
            for (File file : files) {
                try {
                    icons.add(new IconImage(new FileInputStream(file), file.getName()));
                } catch (Exception e) {
                }
            }
        }
    }



    @Override
    public Image getNavRailIcon() {
        return navRailIcon;
    }



    @Override
    public String getNavRailLabel() {
        return menuName;
    }



    @Override
    public Parent getNavRailView() {
        return headeredScroller;
    }



    @Override
    public void changed(ObservableValue<? extends MaterialIconStyle> o, MaterialIconStyle v1, MaterialIconStyle v2) {
        icons.clear();
    }




    /**
     *
     */
    public class IconView extends TilePane {

        private final ObservableList<IconToggle> toggles = FXCollections.observableArrayList();
        private final ToggleGroup tg = new ToggleGroup();



        public IconView() {
            super();
            super.setAlignment(Pos.CENTER);
            super.setPrefColumns(10);
            super.setHgap(16);
            super.setVgap(16);
            super.setPadding(new Insets(24, 48, 32, 48));
            icons.addListener((Change<? extends IconImage> c) -> {
                while (c.next()) {
                    if (c.wasAdded()) {
                        Iterator<? extends IconImage> i = c.getAddedSubList().iterator();
                        while (i.hasNext()) {
                            IconImage image = i.next();
                            IconToggle toggle = new IconToggle(image, image.iconName);
                            toggle.setToggleGroup(tg);
                            toggles.add(toggle);
                        }
                    } else if (c.wasRemoved()) {
                        Iterator<? extends IconImage> i = c.getRemoved().iterator();
                        while (i.hasNext()) {
                            IconImage image = i.next();
                            IconToggle toggle = find(image);
                            if (toggle != null) {
                                toggles.remove(toggle);
                            }
                        }
                    }
                }
            });
            toggles.addListener((Change<? extends IconToggle> c) -> {
                while (c.next()) {
                    if (c.wasAdded()) {
                        Iterator<? extends IconToggle> i = c.getAddedSubList().iterator();
                        while (i.hasNext()) {
                            IconToggle toggle = i.next();
                            appendToggle(toggle);
                        }
                    }
                    if (c.wasRemoved()) {
                        Iterator<? extends IconToggle> i = c.getRemoved().iterator();
                        while (i.hasNext()) {
                            IconToggle toggle = i.next();
                            removeToggle(toggle);
                        }
                    }
                }
            });
        }



        public IconToggle find(IconImage img) {
            IconToggle match = null;
            Iterator<IconToggle> i = toggles.iterator();
            while (i.hasNext() && match == null) {
                IconToggle it = i.next();
                if (it.getName().equals(img.getIconName())) {
                    match = it;
                    break;
                }
            }
            return match;
        }



        private void removeToggle(IconToggle toggle) {
            super.getChildren().remove(toggle);
        }



        private void appendToggle(IconToggle toggle) {
            super.getChildren().add(toggle);
        }
    }




    /**
     * Image extended to store name
     */
    public class IconImage extends Image {

        private String iconName;



        public IconImage(InputStream in, String iconName) {
            super(in);
            this.iconName = Strings.toUpperCaseWithSpaces(iconName);
        }



        public String getIconName() {
            return iconName;
        }
    }




    /**
     * Icon Toggle
     */
    public class IconToggle extends ToggleButton {

        final VBox container = new VBox();
        final FlowPane imagePane = new FlowPane();
        final MaterialLabel label;
        final ImageView iv;

        final Background bgIdle, bgHover, bgSelected;
        final Border bIdle, bHover, bSelected;



        public IconToggle(Image icon, String name) {
            super();
            super.getStyleClass().add("material-icon-toggle");
            bgIdle = Bgs.basicIdle();
            bgHover = Bgs.basicHover();
            bgSelected = Bgs.basicHover();
            bIdle = Borders.basicIdle();
            bHover = Borders.basicIdle();
            bSelected = Borders.basicSelected();
            label = new MaterialLabel(name, MaterialTypography.BODY2, 96);
            label.setWrapText(true);
            label.setMaxHeight(48);
            label.setMinHeight(48);
            label.setAlignment(Pos.CENTER);
            label.setTextAlignment(TextAlignment.CENTER);

            imagePane.setMinSize(96, 96);
            imagePane.setMaxSize(96, 96);
            imagePane.setPrefSize(96, 96);
            imagePane.setAlignment(Pos.CENTER);
            iv = new ImageView(icon);

            iv.setFitWidth(48);
            iv.setFitHeight(48);
            imagePane.getChildren().add(iv);
            container.setAlignment(Pos.CENTER);
            container.getChildren().addAll(imagePane, label);
            super.setGraphic(container);

            super.setBackground(bgIdle);
            super.setBorder(bIdle);
            super.hoverProperty().addListener((o, v1, v2) -> {
                if (!super.isSelected()) {
                    if (v2 == true) {
                        super.setBackground(bgHover);
                        super.setBorder(bHover);
                        super.setEffect(null);
                    } else {
                        super.setBackground(bgIdle);
                        super.setBorder(bIdle);
                        super.setEffect(null);
                    }
                }
            });
            super.selectedProperty().addListener((o, v1, v2) -> {
                if (v2 == true) {
                    super.setBackground(bgSelected);
                    super.setBorder(bSelected);
                    super.setEffect(null);
                } else {
                    super.setBackground(bgIdle);
                    super.setBorder(bIdle);
                    super.setEffect(null);
                }
            });
            super.pressedProperty().addListener((o, v1, v2) -> {
                super.setEffect(null);
            });
            super.setFocusTraversable(false);
        }



        public String getName() {
            return label.getText();
        }



        public Image getImage() {
            return iv.getImage();
        }

    }

}
