/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csseditor;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import material.application.buttons.MaterialIconButton;
import material.design.common.Icons;
import material.sys.Sys;




/**
 *
 * @author DMulders
 */
public class CssEditorPane extends GridPane {

    public TextArea textArea;

    public MaterialIconButton btnSave;
    public MaterialIconButton btnReload;



    public CssEditorPane() {
        super();
        textArea = new TextArea();
        btnSave = new MaterialIconButton(Icons.getSave(Icons.IconStyle.NONE), true);
        btnReload = new MaterialIconButton(Icons.getReload(Icons.IconStyle.NONE), true);
        init();
    }



    public void reload() {
        String raw = "";
        try {
            File file = new File(Sys.getAppDataFolder().getAbsolutePath() + "\\Stylesheets\\style_template.css");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                raw += line;
                raw += "\n";
            }
            reader.close();

        } catch (Exception e) {
        }
        textArea.setText(raw);
    }



    public void save() {
        String raw = textArea.getText();
        try {
            File file = new File(Sys.getAppDataFolder().getAbsolutePath() + "\\Stylesheets\\style_template.css");
            PrintWriter writer = new PrintWriter(new FileWriter(file));
            writer.print(raw);
            writer.flush();
            writer.close();
        } catch (Exception e) {
        }
    }



    private void init() {
        super.setVgap(24);
        textArea.setPrefColumnCount(REMAINING);
        textArea.setPrefRowCount(50);

        btnReload.setOnAction((ae) -> {
            reload();
        });
        btnSave.setOnAction((ae)->{
            save();
        });

        GridPane.setConstraints(textArea, 0, 1, REMAINING, REMAINING, HPos.CENTER, VPos.TOP, Priority.ALWAYS, Priority.ALWAYS);
        GridPane.setConstraints(btnReload, 0, 0, 1, 1, HPos.LEFT, VPos.CENTER);
        GridPane.setConstraints(btnSave, 1, 0, 1, 1, HPos.LEFT, VPos.CENTER);

        super.getChildren().addAll(textArea, btnReload, btnSave);
    }

}
