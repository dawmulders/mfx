/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package material.application.navrail;
import java.util.Iterator;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ReadOnlyBooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener.Change;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import material.application.layouts.MaterialScrollPane;




/**
 *
 * @author DMulders
 */
public class MaterialNavigationRail extends VBox {

    public static final double RAIL_WIDTH = 72;

    private final INavRailController controller;

    private final FlowPane actionButtonPane = new FlowPane();
    private final NavRailActionButton actionButton = new NavRailActionButton();
    private final BooleanProperty isActionButtonVisible = new SimpleBooleanProperty(true);

    private final MaterialScrollPane scroller = new MaterialScrollPane();
    private final VBox contentBox = new VBox();
    private final ObservableList<NavRailMenuButton> menuButtons = FXCollections.observableArrayList();
    private final ToggleGroup toggleGroup = new ToggleGroup();



    public MaterialNavigationRail(INavRailController controller) {
        super();
        this.controller = controller;

        init();
    }



    public ObservableList<NavRailMenuButton> getMenuButtons() {
        return menuButtons;
    }



    public INavRailView getSelectedView() {
        if (toggleGroup.getSelectedToggle() != null && toggleGroup.getSelectedToggle() instanceof NavRailMenuButton) {
            NavRailMenuButton menuButton = (NavRailMenuButton) toggleGroup.getSelectedToggle();
            return menuButton.getView();
        }
        return null;
    }



    public NavRailMenuButton getMenuForView(INavRailView view) {
        NavRailMenuButton match = null;
        Iterator<NavRailMenuButton> i = menuButtons.iterator();
        while (i.hasNext()) {
            NavRailMenuButton menuButton = i.next();
            if (menuButton.getView() == view) {
                match = menuButton;
                break;
            }
        }
        return match;
    }



    public void setActionButtonVisible(boolean visible) {
        isActionButtonVisible.set(visible);
    }



    public boolean isActionButtonVisible() {
        return isActionButtonVisible.get();
    }



    public ReadOnlyBooleanProperty getIsActionButtonVisible() {
        return isActionButtonVisible;
    }



    protected void createNavRailMenu(INavRailView view) {
        NavRailMenuButton menuButton = new NavRailMenuButton(view, view.getNavRailIcon(), view.getNavRailLabel());
        menuButton.setToggleGroup(toggleGroup);
        menuButtons.add(menuButton);
    }



    protected void removeNavRailMenu(INavRailView view) {
        NavRailMenuButton menuButton = getMenuForView(view);
        if (menuButton != null) {
            menuButton.setToggleGroup(null);
            menuButtons.remove(menuButton);
        }
    }



    private void appendMenuButtonToRail(NavRailMenuButton menuButton) {
        contentBox.getChildren().add(menuButton);
    }



    private void removeMenuButtonFromRail(NavRailMenuButton menuButton) {
        contentBox.getChildren().remove(menuButton);
    }



    private void init() {
        super.setPrefWidth(RAIL_WIDTH);
        super.setMinWidth(RAIL_WIDTH);
        super.setMaxWidth(RAIL_WIDTH);
        super.setPrefHeight(Double.MAX_VALUE);
        super.setAlignment(Pos.TOP_CENTER);
        super.setPadding(new Insets(8, 0, 8, 0));

        contentBox.setPrefWidth(RAIL_WIDTH);
        contentBox.setMinWidth(RAIL_WIDTH);
        contentBox.setMaxWidth(RAIL_WIDTH);
        contentBox.setMaxHeight(Double.MAX_VALUE);
        contentBox.setAlignment(Pos.TOP_CENTER);
        scroller.setContent(contentBox);
        //scroller.setPrefHeight(Double.MAX_VALUE);
        scroller.setMaxHeight(Double.MAX_VALUE);
        scroller.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scroller.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scroller.setBorder(Border.EMPTY);
        scroller.setBackground(Background.EMPTY);
        initActionButton();
        super.getChildren().add(scroller);
        controller.getNavRailViews().addListener((Change<? extends INavRailView> c) -> {
            while (c.next()) {
                if (c.wasAdded()) {
                    Iterator<? extends INavRailView> iAdd = c.getAddedSubList().iterator();
                    while (iAdd.hasNext()) {
                        INavRailView view = iAdd.next();
                        createNavRailMenu(view);
                    }
                } else if (c.wasRemoved()) {
                    Iterator<? extends INavRailView> iDel = c.getRemoved().iterator();
                    while (iDel.hasNext()) {
                        INavRailView view = iDel.next();
                        removeNavRailMenu(view);
                    }
                }
            }
        });

        menuButtons.addListener((Change<? extends NavRailMenuButton> c) -> {
            while (c.next()) {
                if (c.wasAdded()) {
                    Iterator<? extends NavRailMenuButton> i = c.getAddedSubList().iterator();
                    while (i.hasNext()) {
                        appendMenuButtonToRail(i.next());
                    }
                } else if (c.wasRemoved()) {
                    Iterator<? extends NavRailMenuButton> i = c.getRemoved().iterator();
                    while (i.hasNext()) {
                        removeMenuButtonFromRail(i.next());
                    }
                }
            }
        });

        toggleGroup.selectedToggleProperty().addListener((o, v1, v2) -> {
            if (v2 != null && v2 instanceof NavRailMenuButton) {
                NavRailMenuButton menuButton = (NavRailMenuButton) v2;
                controller.setSelectedView(menuButton.getView());
            }
        });
        controller.getSelectedView().addListener((o, v1, v2) -> {
            if (v2 != null) {
                NavRailMenuButton menuButton = getMenuForView(v2);
                if (menuButton != null && !menuButton.isSelected()) {
                    toggleGroup.selectToggle(menuButton);
                }
            }
        });

    }



    private void initActionButton() {
        actionButtonPane.setMinSize(RAIL_WIDTH, RAIL_WIDTH);
        actionButtonPane.setPrefSize(RAIL_WIDTH, RAIL_WIDTH);
        actionButtonPane.setMaxSize(RAIL_WIDTH, RAIL_WIDTH);
        actionButtonPane.setAlignment(Pos.CENTER);
        actionButtonPane.setPadding(new Insets(0, 0, 8, 0));
        actionButtonPane.getChildren().add(actionButton);
        super.getChildren().add(actionButtonPane);

        isActionButtonVisible.addListener((o, v1, v2) -> {
            if (v2) {
                actionButtonPane.setVisible(true);
                super.getChildren().remove(scroller);
                super.getChildren().add(actionButtonPane);
                super.getChildren().add(scroller);

            } else {
                actionButtonPane.setVisible(false);
                super.getChildren().remove(actionButtonPane);

            }
        });
    }

}
