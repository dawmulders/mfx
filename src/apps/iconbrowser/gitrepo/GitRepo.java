/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apps.iconbrowser.gitrepo;
import java.io.File;
import java.io.FileInputStream;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;




/**
 *
 * @author DMulders
 */
public class GitRepo extends Application{ 
 
    private static final String root_url = "https://github.com/google/material-design-icons";



    public static void main(String[] args) {
        launch(args);
    }



    @Override
    public void start(Stage stage) throws Exception {
        FlowPane root = new FlowPane();
        root.setHgap(16);
        root.setVgap(16);
        Font font = null;
       try{
           font = Font.loadFont(new FileInputStream(new File("C:\\Libraries\\Code\\FxMaterial\\res\\fonts\\MaterialSymbolsOutlined[FILL,GRAD,opsz,wght].ttf")), 20);
       }catch(Exception e){
       } 
       Label lbl = new Label(String.format("%c", 0xF1960));  
       lbl.setFont(font);
       root.getChildren().add(lbl);
       Scene scene = new Scene(root);
       stage.setScene(scene);
       stage.show();
       
       
        
    }

}
