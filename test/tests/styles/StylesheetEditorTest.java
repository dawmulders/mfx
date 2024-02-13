/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.styles;
import apps.styling.stylesheets.StylesheetEditor;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javafx.application.Application;
import javafx.stage.Stage;
import material.application.MaterialScene;
import material.design.typography.MaterialFont;
import material.style.css.StylesheetParser;




/**
 *
 * @author DMulders
 */
public class StylesheetEditorTest extends Application {

    public static void main(String[] args) {
        launch(args);
    }



    @Override
    public void start(Stage stage) throws Exception {
        MaterialFont mf = new MaterialFont(true);
        StylesheetEditor editor = new StylesheetEditor();
        MaterialScene scene = new MaterialScene(editor);
        stage.setScene(scene);
        stage.show();
        loadStylesheet(editor);
    }



    public void loadStylesheet(StylesheetEditor editor) {
        String raw = "";
        try {
            File file = StylesheetParser.getTemplateFile();
            BufferedReader reader = new BufferedReader(new FileReader(file));
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                raw += line + "\n";
            }
            reader.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        editor.loadTemplateText(raw);
    }

}
