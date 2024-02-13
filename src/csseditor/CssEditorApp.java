/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csseditor;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;




/**
 *
 * @author DMulders
 */
public class CssEditorApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }



    @Override
    public void start(Stage stage) throws Exception {
        CssEditorPane root = new CssEditorPane();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
