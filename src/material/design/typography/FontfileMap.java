/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package material.design.typography;
import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javafx.scene.text.Font;




/**
 *
 * @author DMulders
 */
public class FontfileMap {

    private final Map<MaterialFontSpec, File> map;



    public FontfileMap() {
        map = new HashMap<>();
    }



    public void registerFile(File file) {
        try {
            Font font = Font.loadFont(new FileInputStream(file), 10);
            MaterialFontSpec mfs = new MaterialFontSpec(font.getFamily(), font.getSize(), font.getStyle(), font.getName());
            map.put(mfs, file);
        } catch (Exception e) {
            System.out.println(e);
        }
    }



    public void registerSpec(File file, String family, String style, String name) {
        try {
            Font font = Font.loadFont(new FileInputStream(file), 10);
            MaterialFontSpec mfs = new MaterialFontSpec(family, 10, style, name);
            map.put(mfs, file);
        } catch (Exception e) {
            System.out.println(e);
        }
    }



    public Font loadFont(String family, double size, String style, String name) {
        File file = findFile(family, style, name);
        if (file != null) {
            try {
                return Font.loadFont(new FileInputStream(file), size);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return null;
    }



    public File findFile(String family, String style, String name) {
        MaterialFontSpec spec = findSpec(family, style, name);
        if (spec != null) {
            return map.get(spec);
        }
        return null;
    }



    public MaterialFontSpec findSpec(String family, String style, String name) {
        MaterialFontSpec match = null;
        Iterator<MaterialFontSpec> i = map.keySet().iterator();
        while (i.hasNext()) {
            MaterialFontSpec mfs = i.next();
            if (mfs.equals(family, style, name)) {
                match = mfs;
                break;
            }
        }
        return match;
    }

}
