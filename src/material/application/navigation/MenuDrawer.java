/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package material.application.navigation;
import java.util.Iterator;
import java.util.List;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import material.application.MaterialController;
import material.application.content.IMaterialView;
import material.design.Mfx;




/**
 *
 * @author DMulders
 */
public class MenuDrawer extends BorderPane {

    private final MaterialController controller;
    private final ToggleGroup menuToggleGroup = new ToggleGroup();
    private final DrawerBox menuBox;

    private final DropShadow dropShadow = new DropShadow(BlurType.TWO_PASS_BOX, Color.web("#212121", 0.6), 14, 0.3, 2, 0);
    private final TranslateTransition showTransition;
    private final TranslateTransition hideTransition;

    private boolean isShowing = false;



    public MenuDrawer(MaterialController controller) {
        super();
        this.controller = controller;
        showTransition = new TranslateTransition(Duration.millis(350), this);
        showTransition.setToX(0);
        hideTransition = new TranslateTransition(Duration.millis(350), this);
        hideTransition.setToX(-300);
        super.setTranslateX(-300);
        menuBox = new DrawerBox();
        init();
    }



    protected void onMenuSelected(IMaterialView view) {
        controller.setMaterialView(view);
        controller.getRootView().closeNavigationDrawer();
    }



    protected void updateSelectedMenu(IMaterialView view) {
        MaterialDrawerMenu mdm = menuBox.findMenuForView(view);
        if (mdm != null) {
            menuToggleGroup.selectToggle(mdm);
        }
    }



    public void onMenuDrawerOpen() {
        showTransition.stop();
        hideTransition.stop();
        showTransition.play();
    }



    public void onMenuDrawerClose() {
        showTransition.stop();
        hideTransition.stop();
        hideTransition.play();
    }



    public MaterialDrawerMenu getSelectedMenu() {
        if (menuToggleGroup.getSelectedToggle() != null) {
            if (menuToggleGroup.getSelectedToggle() instanceof MaterialDrawerMenu) {
                MaterialDrawerMenu mdm = (MaterialDrawerMenu) menuToggleGroup.getSelectedToggle();
                return mdm;
            }
        }
        return null;
    }



    public IMaterialView getSelectedMaterialView() {
        MaterialDrawerMenu mdm = getSelectedMenu();
        if (null != mdm) {
            return mdm.getMaterialView();
        }
        return null;
    }



    protected ToggleGroup getToggleGroup() {
        return menuToggleGroup;
    }



    private void createMenu(IMaterialView view) {
        MaterialDrawerMenu mdm = new MaterialDrawerMenu(this, view);
        menuBox.addMenu(mdm);

    }



    private void init() {
        super.setPrefWidth(256);
        super.setMaxWidth(256);
        super.setMinWidth(256);
        super.setPrefHeight(Double.MAX_VALUE);
        super.setBackground(Mfx.getBgSurface());
        super.setEffect(dropShadow);
        super.setCenter(menuBox);

        controller.getCurrentViewProperty().addListener((o, v1, v2) -> {
            if (v2 != null) {
                IMaterialView mv = getSelectedMaterialView();
                if (mv == null || v2 != mv) {
                    updateSelectedMenu(v2);
                }
            }
        });

        controller.getMaterialViewList().addListener(new ListChangeListener<IMaterialView>() {

            @Override
            public void onChanged(ListChangeListener.Change<? extends IMaterialView> c) {
                while (c.next()) {
                    List<? extends IMaterialView> views;
                    if (c.wasAdded()) {
                        views = c.getAddedSubList();
                        Iterator<? extends IMaterialView> i = views.iterator();
                        while (i.hasNext()) {
                            IMaterialView view = i.next();
                            createMenu(view);

                        }

                    } else if (c.wasRemoved()) {
                        views = c.getRemoved();
                        Iterator<? extends IMaterialView> i = views.iterator();
                    }
                }
            }
        });

        showTransition.setOnFinished((event) -> {
            isShowing = true;
        });

        hideTransition.setOnFinished((event) -> {
            isShowing = false;
        });

        menuToggleGroup.selectedToggleProperty().addListener((o, v1, v2) -> {
            if (v2 != null) {
                if (v2 instanceof MaterialDrawerMenu) {
                    MaterialDrawerMenu mdm = (MaterialDrawerMenu) v2;
                    onMenuSelected(mdm.getMaterialView());
                }
            }
        });
    }




    public class DrawerBox extends VBox {

        private final ObservableList<MaterialDrawerMenu> menus = FXCollections.observableArrayList();



        public DrawerBox() {
            super();
            super.setPadding(new Insets(18, 0, 0, 0));
        }



        public void addMenu(MaterialDrawerMenu menu) {
            super.getChildren().add(menu);
            menus.add(menu);
        }



        public MaterialDrawerMenu findMenuForView(IMaterialView view) {
            MaterialDrawerMenu match = null;
            Iterator<MaterialDrawerMenu> i = menus.iterator();
            while (i.hasNext()) {
                MaterialDrawerMenu mdm = i.next();
                if (mdm.getMaterialView() == view) {
                    match = mdm;
                    break;
                }
            }
            return match;
        }

    }

}
