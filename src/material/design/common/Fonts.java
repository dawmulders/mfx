/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package material.design.common;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.text.Font;




/**
 *
 * @author DMulders
 */
public class Fonts {

    public static List<File> robotoFontFiles() {
        List<File> files = new ArrayList<File>();
        files.add(new File("C:\\Libraries\\Code\\FxMaterial\\res\\fonts\\roboto\\Roboto-Regular.ttf"));
        files.add(new File("C:\\Libraries\\Code\\FxMaterial\\res\\fonts\\roboto\\Roboto-Light.ttf"));
        files.add(new File("C:\\Libraries\\Code\\FxMaterial\\res\\fonts\\roboto\\Roboto-Thin.ttf"));
        files.add(new File("C:\\Libraries\\Code\\FxMaterial\\res\\fonts\\roboto\\Roboto-Medium.ttf"));
        files.add(new File("C:\\Libraries\\Code\\FxMaterial\\res\\fonts\\roboto\\Roboto-Bold.ttf"));
        files.add(new File("C:\\Libraries\\Code\\FxMaterial\\res\\fonts\\roboto\\Roboto-Black.ttf"));
        return files;
    }



    public static Font roboto(int size) {
        return load(new File("C:\\Libraries\\Code\\FxMaterial\\res\\fonts\\roboto\\Roboto-Regular.ttf"), size);
    }



    public static Font robotoLight(int size) {
        return load(new File("C:\\Libraries\\Code\\FxMaterial\\res\\fonts\\roboto\\Roboto-Light.ttf"), size);
    }



    public static Font robotoThin(int size) {
        return load(new File("C:\\Libraries\\Code\\FxMaterial\\res\\fonts\\roboto\\Roboto-Thin.ttf"), size);
    }



    public static Font robotoMedium(int size) {
        return load(new File("C:\\Libraries\\Code\\FxMaterial\\res\\fonts\\roboto\\Roboto-Medium.ttf"), size);
    }



    public static Font robotoBold(int size) {
        return load(new File("C:\\Libraries\\Code\\FxMaterial\\res\\fonts\\roboto\\Roboto-Bold.ttf"), size);
    }



    public static Font robotoBlack(int size) {
        return load(new File("C:\\Libraries\\Code\\FxMaterial\\res\\fonts\\roboto\\Roboto-Black.ttf"), size);
    }



    private static Font load(File fontfile, int size) {
        try {
            return Font.loadFont(new FileInputStream(fontfile), size);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

}
