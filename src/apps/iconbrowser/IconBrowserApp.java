/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apps.iconbrowser;
import apps.iconbrowser.browser.IconCategoryNavRailView;
import apps.iconbrowser.gitrepo.MaterialIconCategory;
import apps.iconbrowser.gitrepo.MaterialIconStyle;
import javafx.application.Platform;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import material.application.MaterialApplication;
import material.application.MaterialRootView;
import material.application.content.IMaterialView;
import material.application.navrail.NavigationRailView;
import material.design.common.Icons;
import material.design.common.Icons.IconStyle;




/**
 *
 * @author DMulders
 */
public class IconBrowserApp extends MaterialApplication {

    public static void main(String[] args) {
        launch(args);
    }



    @Override
    public void loadMaterialViews(MaterialRootView rootview) {
        IconBrowserMaterialView view = new IconBrowserMaterialView();
        rootview.addAndSelectMenu(view);
        
        rootview.getAppBar().getChildren();
    }




    public class IconBrowserMaterialView implements IMaterialView {

        private final NavigationRailView view;
        private final Image menuIcon;
        private final ObjectProperty<MaterialIconStyle> selectedStyle = new SimpleObjectProperty<>(MaterialIconStyle.standard);

        private IconCategoryNavRailView currentView;



        public IconBrowserMaterialView() {
            view = new NavigationRailView();
            view.getNavigationRail().setActionButtonVisible(false);
            menuIcon = Icons.getRocket(Icons.IconStyle.NONE);
            view.getSelectedView().addListener((o, v1, v2) -> {
                if (v2 != null && v2 instanceof IconCategoryNavRailView) {
                    IconCategoryNavRailView navRailView = (IconCategoryNavRailView) v2;
                    currentView = navRailView;
                    Platform.runLater(() -> {
                        navRailView.onCategoryViewLoaded(selectedStyle.get());
                    });
                }
            });
            initViews();
        }



        public void setMaterialIconStyle(MaterialIconStyle style) {
            selectedStyle.set(style);
            if (null != currentView) {
                currentView.onCategoryViewLoaded(style);
            }
        }



        private void initViews() {
            IconCategoryNavRailView[] views = new IconCategoryNavRailView[]{
                new IconCategoryNavRailView(Icons.getAction(IconStyle.NONE), "action", MaterialIconCategory.action),
                new IconCategoryNavRailView(Icons.getAlert(IconStyle.NONE), "alert", MaterialIconCategory.alert),
                new IconCategoryNavRailView(Icons.getAv(IconStyle.NONE), "av", MaterialIconCategory.av),
                new IconCategoryNavRailView(Icons.getCommunication(IconStyle.NONE), "com", MaterialIconCategory.communication),
                new IconCategoryNavRailView(Icons.getContent(IconStyle.NONE), "content", MaterialIconCategory.content),
                new IconCategoryNavRailView(Icons.getHardware(IconStyle.NONE), "device", MaterialIconCategory.device),
                new IconCategoryNavRailView(Icons.getEditor(IconStyle.NONE), "editor", MaterialIconCategory.editor),
                new IconCategoryNavRailView(Icons.getFile(IconStyle.NONE), "file", MaterialIconCategory.file),
                new IconCategoryNavRailView(Icons.getHardware(IconStyle.NONE), "hardware", MaterialIconCategory.hardware),
                new IconCategoryNavRailView(Icons.getHome(IconStyle.NONE), "home", MaterialIconCategory.home),
                new IconCategoryNavRailView(Icons.getImage(IconStyle.NONE), "image", MaterialIconCategory.image),
                new IconCategoryNavRailView(Icons.getMaps(IconStyle.NONE), "maps", MaterialIconCategory.maps),
                new IconCategoryNavRailView(Icons.getNavigation(IconStyle.NONE), "nav", MaterialIconCategory.navigation),
                new IconCategoryNavRailView(Icons.getNotification(IconStyle.NONE), "notify", MaterialIconCategory.notification),
                new IconCategoryNavRailView(Icons.getPlaces(IconStyle.NONE), "places", MaterialIconCategory.places),
                new IconCategoryNavRailView(Icons.getSearch(IconStyle.NONE), "search", MaterialIconCategory.search),
                new IconCategoryNavRailView(Icons.getSocial(IconStyle.NONE), "social", MaterialIconCategory.social),
                new IconCategoryNavRailView(Icons.getToggle(IconStyle.NONE), "toggle", MaterialIconCategory.toggle)
            };
            for (IconCategoryNavRailView navrailview : views) {
                view.addNavRailView(navrailview);
            }
        }



        public ReadOnlyObjectProperty<MaterialIconStyle> getIconStyleProperty() {
            return selectedStyle;
        }



        public MaterialIconStyle getSelectedStyle() {
            return selectedStyle.get();
        }



        @Override
        public Parent getParent() {
            return view;
        }



        @Override
        public String getMenuName() {
            return "Icons";
        }



        @Override
        public String getViewName() {
            return "Material Design Icons";
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

    }

}
