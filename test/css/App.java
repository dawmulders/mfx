/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package css;
import java.io.File;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import material.design.MaterialStyle;
import material.style.css.StylesheetParser;




/**
 *
 * @author DMulders
 */
public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }



    @Override
    public void start(Stage stage) throws Exception {
        DrawerPane root = new DrawerPane();
        Scene scene = new Scene(root);
        MaterialStyle style = new MaterialStyle("default");

        File file = StylesheetParser.generateStylesheet(new File("C:\\Libraries\\Code\\FxMaterial\\res\\css.material\\template.css"), style);

        scene.getStylesheets().add("file:///" + file.getAbsolutePath().replace("\\", "/"));
        stage.setScene(scene);
        stage.show();
    }

}
