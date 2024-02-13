/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package material.design.common;
import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import javafx.scene.image.Image;




/**
 *
 * @author DMulders
 */
public class Images {

    public static Image loadFile(File file) {
        return getOrLoadImageFile(file);
    }



    public static Image getDefaultImage() {
        if (DEFAULT_IMAGE == null) {
            File file = new File("C:\\Libraries\\Code\\FxMaterial\\res\\graphics\\images\\placeholder.png");
            try {
                DEFAULT_IMAGE = new Image(new FileInputStream(file));
            } catch (Exception e) {
                System.out.println("Failed to load placeholder image");
            }
        }
        return DEFAULT_IMAGE;
    }



    private static Image getOrLoadImageFile(File file) {
        if (null == CACHE) {
            CACHE = new HashMap<>();
        }
        if (!CACHE.containsKey(file)) {
            try {
                Image img = new Image(new FileInputStream(file));
                CACHE.put(file, img);
            } catch (Exception e) {
                System.out.println("Images.getOrLoadImageFile() Could not load " + file.getAbsolutePath());
            }
        }
        return CACHE.get(file);
    }

    private static Image DEFAULT_IMAGE = null;
    private static HashMap<File, Image> CACHE = null;
}
