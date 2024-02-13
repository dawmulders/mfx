/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apps.styling.views;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import material.application.content.IMaterialView;
import material.application.layouts.MaterialScrollPane;
import material.application.texts.MaterialLabel;
import material.design.common.Icons;
import material.design.typography.MaterialTypography;
import material.views.common.MaterialContentCardView;




/**
 *
 * @author DMulders
 */
public class TypographyView implements IMaterialView {

    private final TypographyPane view;
    private final Image menuIcon;



    public TypographyView() {
        view = new TypographyPane();
        menuIcon = Icons.getTextFields(Icons.IconStyle.PRIMARY);
    }



    @Override
    public Parent getParent() {
        return view;
    }



    @Override
    public String getMenuName() {
        return "Typography";
    }



    @Override
    public String getViewName() {
        return "The Type System";
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




    public class TypographyPane extends MaterialContentCardView {

        private final MaterialScrollPane scrollPane;
        private final GridPane grid;

        private final MaterialLabel[] fontLabels;
        private final MaterialLabel[] nameLabels;
        private final MaterialLabel[] styleLabels;



        public TypographyPane() {
            super();
            scrollPane = new MaterialScrollPane();
            this.grid = new GridPane();
            MaterialTypography[] types = MaterialTypography.getTypes();
            this.fontLabels = new MaterialLabel[types.length];
            this.nameLabels = new MaterialLabel[types.length];
            this.styleLabels = new MaterialLabel[types.length];
            for (int i = 0; i < types.length; i++) {
                MaterialTypography fontType = types[i];
                String text = fontType.name();
                MaterialLabel lbl = new MaterialLabel(text, fontType, 340);
                fontLabels[i] = lbl;

                String name = lbl.getFont().getFamily();
                String style = lbl.getFont().getStyle();
                nameLabels[i] = new MaterialLabel(name, MaterialTypography.BODY, 240);
                styleLabels[i] = new MaterialLabel(style, MaterialTypography.BODY2);

            }
            init();
        }



        private void init() {
            super.getCardPane().setCenter(scrollPane);
            for (int i = 0; i < fontLabels.length; i++) {
                int index = 2*i;
                GridPane.setConstraints(fontLabels[i], 0, index, 1, 1, HPos.LEFT, VPos.BASELINE, Priority.NEVER, Priority.NEVER);
                GridPane.setConstraints(nameLabels[i], 1, index, 1, 1, HPos.LEFT, VPos.BASELINE, Priority.NEVER, Priority.NEVER);
                GridPane.setConstraints(styleLabels[i], 2, index, 1, 1, HPos.LEFT, VPos.BASELINE, Priority.NEVER, Priority.NEVER);
                grid.getChildren().addAll(fontLabels[i], nameLabels[i], styleLabels[i]);
            }
            grid.setPadding(new Insets(16));
            grid.setVgap(32);
            scrollPane.setContent(grid);
            scrollPane.setFitToWidth(true);
        }

    }

}
