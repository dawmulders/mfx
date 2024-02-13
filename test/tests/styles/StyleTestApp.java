/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.styles;
import java.io.File;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import material.design.MaterialStyle;
import material.style.controls.MfxButton;
import material.style.controls.MfxLabel;
import material.style.css.StylesheetParser;




/**
 *
 * @author DMulders
 */
public class StyleTestApp extends Application {

    
    private Scene scene;
    
    public static void main(String[] args) {
        launch(args);
    }



    @Override
    public void start(Stage stage) throws Exception {
        TestPane root = new TestPane();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    
    public void loadSheet1(){
        MaterialStyle style = new MaterialStyle("test_1");
        style.getPalette().setPrimary(Color.web("#4cc52b"));
        style.getPalette().setPrimaryVariant(Color.web("#a8e895"));
        style.getPalette().setBackground(Color.web("#212121"));
        style.getPalette().setOnBackground(Color.web("#ededed"));
        File file = StylesheetParser.createStylesheetFile(style);
        scene.getStylesheets().clear();
        scene.getStylesheets().add("file:///" + file.getAbsolutePath().replace("\\", "/"));
        
    }

    public void loadSheet2(){
        MaterialStyle style = new MaterialStyle("test_2");
        File file = StylesheetParser.createStylesheetFile(style);
        scene.getStylesheets().clear();
        scene.getStylesheets().add("file:///" + file.getAbsolutePath().replace("\\", "/"));
        
    }



    public class TestPane extends GridPane {

        MfxButton btn1, btn2, btn3;
        MfxLabel lbl1, lbl2, lbl3, lbl4;



        public TestPane() {
            super();
            init();
        }



        private void init() {
            
            
            lbl1 = new MfxLabel("lbl 1");
            lbl2 = new MfxLabel("lbl 2");
            lbl3 = new MfxLabel("lbl 3");
            lbl4 = new MfxLabel("Titel Label");
            lbl4.getStyleClass().add("mfx-title");
        
            
            btn1 = new MfxButton();
            btn1.setText("btn 1");
            btn2 = new MfxButton();
            btn2.setText("btn 2");
            btn3 = new MfxButton();
            btn3.setText("btn 3");

            GridPane.setConstraints(lbl4, 0, 0);
            GridPane.setConstraints(lbl1, 0, 1);
            GridPane.setConstraints(lbl2, 0, 2);
            GridPane.setConstraints(lbl3, 0, 3);
            GridPane.setConstraints(btn1, 1, 1);
            GridPane.setConstraints(btn2, 1, 2);
            GridPane.setConstraints(btn3, 1, 3);
            super.getChildren().addAll(lbl1, lbl2, lbl3, lbl4, btn1, btn2, btn3);
            super.setHgap(32);
            super.setVgap(32);
            super.setPadding(new Insets(32));
            btn1.setOnAction((ae)->{
                loadSheet1();
            });
            btn2.setOnAction((ae)->{
                loadSheet2();
            });
        }

    }

}
