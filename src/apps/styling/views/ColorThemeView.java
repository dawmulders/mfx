/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apps.styling.views;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import material.application.content.IMaterialView;
import material.application.navrail.INavRailView;
import material.application.navrail.NavigationRailView;
import material.application.texts.MaterialLabel;
import material.design.Mfx;
import material.design.common.Colors;
import material.design.common.Icons;
import material.design.common.Strings;
import material.design.typography.MaterialTypography;
import material.views.common.MaterialContentCardView;




/**
 *
 * @author DMulders
 */
public class ColorThemeView implements IMaterialView {

    private ColorThemePane view;
    private Image menuIcon;
    private NavigationRailView navRailView;



    public ColorThemeView() {
        this.view = new ColorThemePane();
        this.menuIcon = Icons.getPalette(Icons.IconStyle.PRIMARY);
        this.navRailView = new NavigationRailView();
        navRailView.addNavRailView(view);
    }



    @Override
    public Parent getParent() {
        return navRailView;
    }



    @Override
    public String getMenuName() {
        return "Colors";
    }



    @Override
    public String getViewName() {
        return "The Color System";
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
        view.rescale();
    }



    @Override
    public void prepareBeforeHiding() {
    }



    @Override
    public void onViewHidden() {
    }




    /**
     * Color Theme Pane Class -> INavRailView
     */
    public class ColorThemePane extends MaterialContentCardView implements INavRailView {

        private final Image navRailIcon = Icons.getPalette(Icons.IconStyle.NONE);

        private VBox box;

        private ColorThemeLabel ctlP1;
        private ColorThemeLabel ctlP2;
        private ColorThemeLabel ctlS1;
        private ColorThemeLabel ctlS2;
        private ColorThemeLabel ctlBg;
        private ColorThemeLabel ctlSurface;
        private ColorThemeLabel ctlError;



        /**
         * Constructor
         */
        public ColorThemePane() {
            super();
            box = new VBox();
            ctlP1 = new ColorThemeLabel("Primary", (Color) Mfx.getP1(), (Color) Mfx.getOnPrimary());
            ctlP2 = new ColorThemeLabel("Primary variant", (Color) Mfx.getP2(), (Color) Mfx.getOnPrimary());
            ctlS1 = new ColorThemeLabel("Secondary", (Color) Mfx.getS1(), (Color) Mfx.getOnSecondary());
            ctlS2 = new ColorThemeLabel("Secondary variant", (Color) Mfx.getS2(), (Color) Mfx.getOnSecondary());
            ctlBg = new ColorThemeLabel("Background", (Color) Mfx.getBg(), (Color) Mfx.getOnBg());
            ctlSurface = new ColorThemeLabel("Surface", (Color) Mfx.getSurface(), (Color) Mfx.getOnSurface());
            ctlError = new ColorThemeLabel("Error", (Color) Mfx.getError(), (Color) Mfx.getOnError());
            init();
        }



        @Override
        public Image getNavRailIcon() {
            return navRailIcon;
        }



        @Override
        public String getNavRailLabel() {
            return "Colors";
        }



        @Override
        public Parent getNavRailView() {
            return this;
        }



        public void rescale() {
            double w = CARD_WIDTH - 16;
            System.out.println("Width of card pane = " + Strings.d0(w));
            double w4 = w / 4;
            double w3 = w / 3;
            ctlP1.resetWidth(w4);
            ctlP2.resetWidth(w4);
            ctlS1.resetWidth(w4);
            ctlS2.resetWidth(w4);

            ctlBg.resetWidth(w3);
            ctlSurface.resetWidth(w3);
            ctlError.resetWidth(w3);
        }



        private void init() {
//            GridPane.setConstraints(ctlP1, 0, 0, 3, 1, HPos.CENTER, VPos.TOP);
//            GridPane.setConstraints(ctlP2, 3, 0, 3, 1, HPos.CENTER, VPos.TOP);
//            GridPane.setConstraints(ctlS1, 6, 0, 3, 1, HPos.CENTER, VPos.TOP);
//            GridPane.setConstraints(ctlS2, 9, 0, 3, 1, HPos.CENTER, VPos.TOP);
//
//            GridPane.setConstraints(ctlBg, 0, 1, 4, 1, HPos.CENTER, VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS);
//            GridPane.setConstraints(ctlSurface, 4, 1, 4, 1, HPos.CENTER, VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS);
//            GridPane.setConstraints(ctlError, 8, 1, 4, 1, HPos.CENTER, VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS);

            HBox topBox = new HBox();
            topBox.setAlignment(Pos.CENTER);
            double topWidth = super.CARD_WIDTH / 2;
            ctlP1.resetWidth(topWidth);
            ctlP2.resetWidth(topWidth);
            ctlS1.resetWidth(topWidth);
            ctlS2.resetWidth(topWidth);
            topBox.getChildren().addAll(ctlP1, ctlP2, ctlS1, ctlS2);

            HBox bottomBox = new HBox();
            bottomBox.setAlignment(Pos.CENTER);
            double bottomWidth = super.CARD_WIDTH / 3;
            ctlBg.resetWidth(bottomWidth);
            ctlSurface.resetWidth(bottomWidth);
            ctlError.resetWidth(bottomWidth);
            bottomBox.getChildren().addAll(ctlBg, ctlSurface, ctlError);
            super.getCardPane().setCenter(box);
            box.setSpacing(32);

            box.getChildren().addAll(topBox, bottomBox);
            box.setAlignment(Pos.CENTER);
            super.getCardPane().setAlignment(box, Pos.CENTER);
        }

    }




    public class ColorThemeLabel extends AnchorPane {

        private MaterialLabel nameLabel;
        private MaterialLabel hexLabel;
        private Color color;
        private Color onColor;



        public ColorThemeLabel(String name, Color color, Color onColor) {
            super();
            nameLabel = new MaterialLabel(name, MaterialTypography.H6);
            hexLabel = new MaterialLabel(Colors.hexRGB(color), MaterialTypography.CAPTION);
            this.color = color;
            this.onColor = onColor;
            nameLabel.setTextFill(onColor);
            hexLabel.setTextFill(onColor);
            AnchorPane.setTopAnchor(nameLabel, 16.0);
            AnchorPane.setLeftAnchor(nameLabel, 16.0);

            AnchorPane.setBottomAnchor(hexLabel, 16.0);
            AnchorPane.setRightAnchor(hexLabel, 32.0);

            super.setBackground(new Background(new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY)));
            super.setMinHeight(220);
            super.getChildren().addAll(nameLabel, hexLabel);
        }



        public void resetWidth(double w) {
            super.setMaxWidth(w);
            super.setPrefWidth(w);
        }
    }

}
