/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apps.explorer.navigator;
import apps.explorer.models.Directories;
import apps.explorer.models.RootFile;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;




/**
 *
 * @author DMulders
 */
public class FileTreeTest extends Application {

    public static void main(String[] args) {
        launch(args);
    }



    @Override
    public void start(Stage stage) throws Exception {
        BorderPane root = new BorderPane();
        RootFile rootFile = Directories.listRoots()[0];
        FileTreeView ftv = new FileTreeView(rootFile);
        root.setCenter(ftv);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
