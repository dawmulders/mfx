/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apps.styling;
import apps.styling.views.ColorThemeView;
import apps.styling.views.MaterialFontView;
import apps.styling.views.ThemesView;
import apps.styling.views.TypographyView;
import javafx.application.Platform;
import material.application.MaterialApplication;
import material.application.MaterialRootView;
import material.design.typography.MaterialFont;




/**
 *
 * @author DMulders
 */
public class StylingApp extends MaterialApplication {

    public static void main(String[] args) {
        launch(args);

    }



    @Override
    public void loadMaterialViews(MaterialRootView rootview) {
        typographyView = new TypographyView();
        colorView = new ColorThemeView();
        themesView = new ThemesView();
        fontView = new MaterialFontView();

        rootView.addAndSelectMenu(fontView);
        rootView.addMenu(typographyView);
        rootview.addMenu(colorView);
        rootview.addMenu(themesView);
        super.materialScene.getWindow().setOnShowing((event) -> {
            Platform.runLater(() -> {
                fontView.openMaterialFont(new MaterialFont(true));
            });

        });
    }

    private ThemesView themesView;
    private TypographyView typographyView;
    private ColorThemeView colorView;
    private MaterialFontView fontView;
}
