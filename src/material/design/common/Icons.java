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
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import material.design.Mfx;




/**
 *
 * @author DMulders
 */
public class Icons {

    public static void main(String[] args) {
        printAccessorMethodsForIcons();
    }




    public enum IconStyle {
        NONE, LIGHT, PRIMARY
    }



    public static void printAccessorMethodsForIcons() {
        File file = new File("C:\\Libraries\\Code\\FxMaterial\\res\\graphics\\icons\\");
        File[] iconFiles = file.listFiles();
        for (int i = 0; i < iconFiles.length; i++) {
            File iconFile = iconFiles[i];
            String fileName = iconFile.getName();
            if (fileName.contains(".")) {
                String name = fileName.split("\\.")[0];
                name = name.substring(0, 1).toUpperCase() + name.substring(1);
                if (name.contains("_")) {
                    String[] parts = name.split("_");
                    name = parts[0];
                    for (int j = 1; j < parts.length; j++) {
                        String namePart = parts[j].substring(0, 1).toUpperCase() + parts[j].substring(1);
                        name += namePart;
                    }
                }

                System.out.println("public static Image get" + name + "(IconStyle iconStyle){");
                System.out.println("\tswitch(iconStyle){");
                System.out.println("\t\tcase LIGHT: return loadFromIconsLight(\"" + fileName + "\");");
                System.out.println("\t\tcase PRIMARY: return loadFromIconsPrimary(\"" + fileName + "\");");
                System.out.println("\t}");
                System.out.println("\treturn loadFromIcons(\"" + fileName + "\");");
                System.out.println("}\n\n");

            }
        }
    }



    public static WritableImage getColoredIcon(Image source, Color color, WritableImage target) {
        int w = (int) source.getWidth();
        int h = (int) source.getHeight();
        if (target == null) {
            target = new WritableImage(w, h);
        }
        PixelReader reader = source.getPixelReader();
        PixelWriter writer = target.getPixelWriter();
        Color pixIn, pixOut;

        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                pixIn = reader.getColor(x, y);
                if (pixIn.getOpacity() > 0.5) {
                    pixOut = Colors.getWithAlpha(color, pixIn.getOpacity());
                } else {
                    pixOut = Color.TRANSPARENT;
                }
                writer.setColor(x, y, pixOut);
            }
        }
        return target;
    }



    private static Image loadFromIcons(String filename) {
        File file = new File("C:\\Libraries\\Code\\FxMaterial\\res\\graphics\\icons\\" + filename);
        return loadOrCache(file);
    }



    private static Image loadFromIconsLight(String filename) {
        File file = new File("C:\\Libraries\\Code\\FxMaterial\\res\\graphics\\icons\\" + filename);
        return loadOrCacheLight(file);
    }



    private static Image loadFromIconsPrimary(String filename) {
        File file = new File("C:\\Libraries\\Code\\FxMaterial\\res\\graphics\\icons\\" + filename);
        return loadOrCachePrimary(file);
    }



    private static Image loadOrCache(File file) {
        if (null == cache) {
            cache = new HashMap<>();
        }
        if (!cache.containsKey(file)) {
            try {
                cache.put(file, new Image(new FileInputStream(file)));
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return cache.get(file);
    }



    private static Image loadOrCacheLight(File file) {
        if (null == cacheLight) {
            cacheLight = new HashMap<>();
        }
        if (!cacheLight.containsKey(file)) {
            try {
                final Image source = new Image(new FileInputStream(file));
                int w = (int) source.getWidth();
                int h = (int) source.getHeight();
                WritableImage target = new WritableImage(w, h);
                PixelReader pr = source.getPixelReader();
                PixelWriter pw = target.getPixelWriter();
                Color cr, cw;
                for (int y = 0; y < h; y++) {
                    for (int x = 0; x < w; x++) {
                        cr = pr.getColor(x, y);
                        if (cr.getOpacity() > 0.1) {
                            cw = Color.web("#ffffff", cr.getOpacity());
                        } else {
                            cw = Color.TRANSPARENT;
                        }
                        pw.setColor(x, y, cw);
                    }
                }
                cacheLight.put(file, target);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return cacheLight.get(file);
    }



    private static Image loadOrCachePrimary(File file) {
        if (null == cachePrimary) {
            cachePrimary = new HashMap<>();
        }
        if (!cachePrimary.containsKey(file)) {
            try {
                final Image source = new Image(new FileInputStream(file));
                int w = (int) source.getWidth();
                int h = (int) source.getHeight();
                WritableImage target = new WritableImage(w, h);
                PixelReader pr = source.getPixelReader();
                PixelWriter pw = target.getPixelWriter();
                Color cr, cw;
                for (int y = 0; y < h; y++) {
                    for (int x = 0; x < w; x++) {
                        cr = pr.getColor(x, y);
                        if (cr.getOpacity() > 0.1) {
                            cw = (Color) Mfx.getP1();
                        } else {
                            cw = Color.TRANSPARENT;
                        }
                        pw.setColor(x, y, cw);
                    }
                }
                cachePrimary.put(file, target);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return cachePrimary.get(file);
    }

    private static HashMap<File, Image> cache;
    private static HashMap<File, Image> cacheLight;
    private static HashMap<File, Image> cachePrimary;



    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    // CODE BELOW IS GENERATED BY CALLING main() ON THIS CLASS
    //
    public static Image getAction(IconStyle iconStyle) {
        switch (iconStyle) {
            case LIGHT:
                return loadFromIconsLight("action.png");
            case PRIMARY:
                return loadFromIconsPrimary("action.png");
        }
        return loadFromIcons("action.png");
    }



    public static Image getAdd(IconStyle iconStyle) {
        switch (iconStyle) {
            case LIGHT:
                return loadFromIconsLight("add.png");
            case PRIMARY:
                return loadFromIconsPrimary("add.png");
        }
        return loadFromIcons("add.png");
    }



    public static Image getAlert(IconStyle iconStyle) {
        switch (iconStyle) {
            case LIGHT:
                return loadFromIconsLight("alert.png");
            case PRIMARY:
                return loadFromIconsPrimary("alert.png");
        }
        return loadFromIcons("alert.png");
    }



    public static Image getAlignLeft(IconStyle iconStyle) {
        switch (iconStyle) {
            case LIGHT:
                return loadFromIconsLight("align_left.png");
            case PRIMARY:
                return loadFromIconsPrimary("align_left.png");
        }
        return loadFromIcons("align_left.png");
    }



    public static Image getAttachment(IconStyle iconStyle) {
        switch (iconStyle) {
            case LIGHT:
                return loadFromIconsLight("attachment.png");
            case PRIMARY:
                return loadFromIconsPrimary("attachment.png");
        }
        return loadFromIcons("attachment.png");
    }



    public static Image getAv(IconStyle iconStyle) {
        switch (iconStyle) {
            case LIGHT:
                return loadFromIconsLight("av.png");
            case PRIMARY:
                return loadFromIconsPrimary("av.png");
        }
        return loadFromIcons("av.png");
    }



    public static Image getBackward(IconStyle iconStyle) {
        switch (iconStyle) {
            case LIGHT:
                return loadFromIconsLight("backward.png");
            case PRIMARY:
                return loadFromIconsPrimary("backward.png");
        }
        return loadFromIcons("backward.png");
    }



    public static Image getBold(IconStyle iconStyle) {
        switch (iconStyle) {
            case LIGHT:
                return loadFromIconsLight("bold.png");
            case PRIMARY:
                return loadFromIconsPrimary("bold.png");
        }
        return loadFromIcons("bold.png");
    }



    public static Image getBorderColor(IconStyle iconStyle) {
        switch (iconStyle) {
            case LIGHT:
                return loadFromIconsLight("border_color.png");
            case PRIMARY:
                return loadFromIconsPrimary("border_color.png");
        }
        return loadFromIcons("border_color.png");
    }



    public static Image getCalendar(IconStyle iconStyle) {
        switch (iconStyle) {
            case LIGHT:
                return loadFromIconsLight("calendar.png");
            case PRIMARY:
                return loadFromIconsPrimary("calendar.png");
        }
        return loadFromIcons("calendar.png");
    }



    public static Image getCloseCircle(IconStyle iconStyle) {
        switch (iconStyle) {
            case LIGHT:
                return loadFromIconsLight("close_circle.png");
            case PRIMARY:
                return loadFromIconsPrimary("close_circle.png");
        }
        return loadFromIcons("close_circle.png");
    }



    public static Image getCloseSquare(IconStyle iconStyle) {
        switch (iconStyle) {
            case LIGHT:
                return loadFromIconsLight("close_square.png");
            case PRIMARY:
                return loadFromIconsPrimary("close_square.png");
        }
        return loadFromIcons("close_square.png");
    }



    public static Image getCloseWindow(IconStyle iconStyle) {
        switch (iconStyle) {
            case LIGHT:
                return loadFromIconsLight("close_window.png");
            case PRIMARY:
                return loadFromIconsPrimary("close_window.png");
        }
        return loadFromIcons("close_window.png");
    }



    public static Image getCode(IconStyle iconStyle) {
        switch (iconStyle) {
            case LIGHT:
                return loadFromIconsLight("code.png");
            case PRIMARY:
                return loadFromIconsPrimary("code.png");
        }
        return loadFromIcons("code.png");
    }



    public static Image getCodeBlock(IconStyle iconStyle) {
        switch (iconStyle) {
            case LIGHT:
                return loadFromIconsLight("code_block.png");
            case PRIMARY:
                return loadFromIconsPrimary("code_block.png");
        }
        return loadFromIcons("code_block.png");
    }



    public static Image getColorFill(IconStyle iconStyle) {
        switch (iconStyle) {
            case LIGHT:
                return loadFromIconsLight("color_fill.png");
            case PRIMARY:
                return loadFromIconsPrimary("color_fill.png");
        }
        return loadFromIcons("color_fill.png");
    }



    public static Image getCommunication(IconStyle iconStyle) {
        switch (iconStyle) {
            case LIGHT:
                return loadFromIconsLight("communication.png");
            case PRIMARY:
                return loadFromIconsPrimary("communication.png");
        }
        return loadFromIcons("communication.png");
    }



    public static Image getContent(IconStyle iconStyle) {
        switch (iconStyle) {
            case LIGHT:
                return loadFromIconsLight("content.png");
            case PRIMARY:
                return loadFromIconsPrimary("content.png");
        }
        return loadFromIcons("content.png");
    }



    public static Image getCopy(IconStyle iconStyle) {
        switch (iconStyle) {
            case LIGHT:
                return loadFromIconsLight("copy.png");
            case PRIMARY:
                return loadFromIconsPrimary("copy.png");
        }
        return loadFromIcons("copy.png");
    }



    public static Image getCss(IconStyle iconStyle) {
        switch (iconStyle) {
            case LIGHT:
                return loadFromIconsLight("css.png");
            case PRIMARY:
                return loadFromIconsPrimary("css.png");
        }
        return loadFromIcons("css.png");
    }



    public static Image getCut(IconStyle iconStyle) {
        switch (iconStyle) {
            case LIGHT:
                return loadFromIconsLight("cut.png");
            case PRIMARY:
                return loadFromIconsPrimary("cut.png");
        }
        return loadFromIcons("cut.png");
    }



    public static Image getDna(IconStyle iconStyle) {
        switch (iconStyle) {
            case LIGHT:
                return loadFromIconsLight("dna.png");
            case PRIMARY:
                return loadFromIconsPrimary("dna.png");
        }
        return loadFromIcons("dna.png");
    }



    public static Image getEditor(IconStyle iconStyle) {
        switch (iconStyle) {
            case LIGHT:
                return loadFromIconsLight("editor.png");
            case PRIMARY:
                return loadFromIconsPrimary("editor.png");
        }
        return loadFromIcons("editor.png");
    }



    public static Image getEventsCup(IconStyle iconStyle) {
        switch (iconStyle) {
            case LIGHT:
                return loadFromIconsLight("events_cup.png");
            case PRIMARY:
                return loadFromIconsPrimary("events_cup.png");
        }
        return loadFromIcons("events_cup.png");
    }



    public static Image getExitApp(IconStyle iconStyle) {
        switch (iconStyle) {
            case LIGHT:
                return loadFromIconsLight("exit_app.png");
            case PRIMARY:
                return loadFromIconsPrimary("exit_app.png");
        }
        return loadFromIcons("exit_app.png");
    }



    public static Image getExpandCircle(IconStyle iconStyle) {
        switch (iconStyle) {
            case LIGHT:
                return loadFromIconsLight("expand_circle.png");
            case PRIMARY:
                return loadFromIconsPrimary("expand_circle.png");
        }
        return loadFromIcons("expand_circle.png");
    }



    public static Image getExplore(IconStyle iconStyle) {
        switch (iconStyle) {
            case LIGHT:
                return loadFromIconsLight("explore.png");
            case PRIMARY:
                return loadFromIconsPrimary("explore.png");
        }
        return loadFromIcons("explore.png");
    }



    public static Image getFile(IconStyle iconStyle) {
        switch (iconStyle) {
            case LIGHT:
                return loadFromIconsLight("file.png");
            case PRIMARY:
                return loadFromIconsPrimary("file.png");
        }
        return loadFromIcons("file.png");
    }



    public static Image getFileSearch(IconStyle iconStyle) {
        switch (iconStyle) {
            case LIGHT:
                return loadFromIconsLight("file_search.png");
            case PRIMARY:
                return loadFromIconsPrimary("file_search.png");
        }
        return loadFromIcons("file_search.png");
    }



    public static Image getFolder(IconStyle iconStyle) {
        switch (iconStyle) {
            case LIGHT:
                return loadFromIconsLight("folder.png");
            case PRIMARY:
                return loadFromIconsPrimary("folder.png");
        }
        return loadFromIcons("folder.png");
    }



    public static Image getFolderCopy(IconStyle iconStyle) {
        switch (iconStyle) {
            case LIGHT:
                return loadFromIconsLight("folder_copy.png");
            case PRIMARY:
                return loadFromIconsPrimary("folder_copy.png");
        }
        return loadFromIcons("folder_copy.png");
    }



    public static Image getFolderCreate(IconStyle iconStyle) {
        switch (iconStyle) {
            case LIGHT:
                return loadFromIconsLight("folder_create.png");
            case PRIMARY:
                return loadFromIconsPrimary("folder_create.png");
        }
        return loadFromIcons("folder_create.png");
    }



    public static Image getFolderManager(IconStyle iconStyle) {
        switch (iconStyle) {
            case LIGHT:
                return loadFromIconsLight("folder_manager.png");
            case PRIMARY:
                return loadFromIconsPrimary("folder_manager.png");
        }
        return loadFromIcons("folder_manager.png");
    }



    public static Image getFolderOpen(IconStyle iconStyle) {
        switch (iconStyle) {
            case LIGHT:
                return loadFromIconsLight("folder_open.png");
            case PRIMARY:
                return loadFromIconsPrimary("folder_open.png");
        }
        return loadFromIcons("folder_open.png");
    }



    public static Image getFolderSettings(IconStyle iconStyle) {
        switch (iconStyle) {
            case LIGHT:
                return loadFromIconsLight("folder_settings.png");
            case PRIMARY:
                return loadFromIconsPrimary("folder_settings.png");
        }
        return loadFromIcons("folder_settings.png");
    }



    public static Image getFolderShared(IconStyle iconStyle) {
        switch (iconStyle) {
            case LIGHT:
                return loadFromIconsLight("folder_shared.png");
            case PRIMARY:
                return loadFromIconsPrimary("folder_shared.png");
        }
        return loadFromIcons("folder_shared.png");
    }



    public static Image getFolderSpecial(IconStyle iconStyle) {
        switch (iconStyle) {
            case LIGHT:
                return loadFromIconsLight("folder_special.png");
            case PRIMARY:
                return loadFromIconsPrimary("folder_special.png");
        }
        return loadFromIcons("folder_special.png");
    }



    public static Image getFolderTopic(IconStyle iconStyle) {
        switch (iconStyle) {
            case LIGHT:
                return loadFromIconsLight("folder_topic.png");
            case PRIMARY:
                return loadFromIconsPrimary("folder_topic.png");
        }
        return loadFromIcons("folder_topic.png");
    }



    public static Image getFolderZip(IconStyle iconStyle) {
        switch (iconStyle) {
            case LIGHT:
                return loadFromIconsLight("folder_zip.png");
            case PRIMARY:
                return loadFromIconsPrimary("folder_zip.png");
        }
        return loadFromIcons("folder_zip.png");
    }



    public static Image getForest(IconStyle iconStyle) {
        switch (iconStyle) {
            case LIGHT:
                return loadFromIconsLight("forest.png");
            case PRIMARY:
                return loadFromIconsPrimary("forest.png");
        }
        return loadFromIcons("forest.png");
    }



    public static Image getFormulas(IconStyle iconStyle) {
        switch (iconStyle) {
            case LIGHT:
                return loadFromIconsLight("formulas.png");
            case PRIMARY:
                return loadFromIconsPrimary("formulas.png");
        }
        return loadFromIcons("formulas.png");
    }



    public static Image getForward(IconStyle iconStyle) {
        switch (iconStyle) {
            case LIGHT:
                return loadFromIconsLight("forward.png");
            case PRIMARY:
                return loadFromIconsPrimary("forward.png");
        }
        return loadFromIcons("forward.png");
    }



    public static Image getGlobe(IconStyle iconStyle) {
        switch (iconStyle) {
            case LIGHT:
                return loadFromIconsLight("globe.png");
            case PRIMARY:
                return loadFromIconsPrimary("globe.png");
        }
        return loadFromIcons("globe.png");
    }



    public static Image getHamburgerMenu(IconStyle iconStyle) {
        switch (iconStyle) {
            case LIGHT:
                return loadFromIconsLight("hamburger_menu.png");
            case PRIMARY:
                return loadFromIconsPrimary("hamburger_menu.png");
        }
        return loadFromIcons("hamburger_menu.png");
    }



    public static Image getHardware(IconStyle iconStyle) {
        switch (iconStyle) {
            case LIGHT:
                return loadFromIconsLight("hardware.png");
            case PRIMARY:
                return loadFromIconsPrimary("hardware.png");
        }
        return loadFromIcons("hardware.png");
    }



    public static Image getHearth(IconStyle iconStyle) {
        switch (iconStyle) {
            case LIGHT:
                return loadFromIconsLight("hearth.png");
            case PRIMARY:
                return loadFromIconsPrimary("hearth.png");
        }
        return loadFromIcons("hearth.png");
    }



    public static Image getHome(IconStyle iconStyle) {
        switch (iconStyle) {
            case LIGHT:
                return loadFromIconsLight("home.png");
            case PRIMARY:
                return loadFromIconsPrimary("home.png");
        }
        return loadFromIcons("home.png");
    }



    public static Image getHtml(IconStyle iconStyle) {
        switch (iconStyle) {
            case LIGHT:
                return loadFromIconsLight("html.png");
            case PRIMARY:
                return loadFromIconsPrimary("html.png");
        }
        return loadFromIcons("html.png");
    }



    public static Image getImage(IconStyle iconStyle) {
        switch (iconStyle) {
            case LIGHT:
                return loadFromIconsLight("image.png");
            case PRIMARY:
                return loadFromIconsPrimary("image.png");
        }
        return loadFromIcons("image.png");
    }



    public static Image getImages(IconStyle iconStyle) {
        switch (iconStyle) {
            case LIGHT:
                return loadFromIconsLight("images.png");
            case PRIMARY:
                return loadFromIconsPrimary("images.png");
        }
        return loadFromIcons("images.png");
    }



    public static Image getInbox(IconStyle iconStyle) {
        switch (iconStyle) {
            case LIGHT:
                return loadFromIconsLight("inbox.png");
            case PRIMARY:
                return loadFromIconsPrimary("inbox.png");
        }
        return loadFromIcons("inbox.png");
    }



    public static Image getItalic(IconStyle iconStyle) {
        switch (iconStyle) {
            case LIGHT:
                return loadFromIconsLight("italic.png");
            case PRIMARY:
                return loadFromIconsPrimary("italic.png");
        }
        return loadFromIcons("italic.png");
    }



    public static Image getJs(IconStyle iconStyle) {
        switch (iconStyle) {
            case LIGHT:
                return loadFromIconsLight("js.png");
            case PRIMARY:
                return loadFromIconsPrimary("js.png");
        }
        return loadFromIcons("js.png");
    }



    public static Image getKey(IconStyle iconStyle) {
        switch (iconStyle) {
            case LIGHT:
                return loadFromIconsLight("key.png");
            case PRIMARY:
                return loadFromIconsPrimary("key.png");
        }
        return loadFromIcons("key.png");
    }



    public static Image getLeaf(IconStyle iconStyle) {
        switch (iconStyle) {
            case LIGHT:
                return loadFromIconsLight("leaf.png");
            case PRIMARY:
                return loadFromIconsPrimary("leaf.png");
        }
        return loadFromIcons("leaf.png");
    }



    public static Image getLeftLarge(IconStyle iconStyle) {
        switch (iconStyle) {
            case LIGHT:
                return loadFromIconsLight("left_large.png");
            case PRIMARY:
                return loadFromIconsPrimary("left_large.png");
        }
        return loadFromIcons("left_large.png");
    }



    public static Image getLeftSmall(IconStyle iconStyle) {
        switch (iconStyle) {
            case LIGHT:
                return loadFromIconsLight("left_small.png");
            case PRIMARY:
                return loadFromIconsPrimary("left_small.png");
        }
        return loadFromIcons("left_small.png");
    }



    public static Image getLicense(IconStyle iconStyle) {
        switch (iconStyle) {
            case LIGHT:
                return loadFromIconsLight("license.png");
            case PRIMARY:
                return loadFromIconsPrimary("license.png");
        }
        return loadFromIcons("license.png");
    }



    public static Image getMaps(IconStyle iconStyle) {
        switch (iconStyle) {
            case LIGHT:
                return loadFromIconsLight("maps.png");
            case PRIMARY:
                return loadFromIconsPrimary("maps.png");
        }
        return loadFromIcons("maps.png");
    }



    public static Image getMaximizeWindow(IconStyle iconStyle) {
        switch (iconStyle) {
            case LIGHT:
                return loadFromIconsLight("maximize_window.png");
            case PRIMARY:
                return loadFromIconsPrimary("maximize_window.png");
        }
        return loadFromIcons("maximize_window.png");
    }



    public static Image getMinimizeWindow(IconStyle iconStyle) {
        switch (iconStyle) {
            case LIGHT:
                return loadFromIconsLight("minimize_window.png");
            case PRIMARY:
                return loadFromIconsPrimary("minimize_window.png");
        }
        return loadFromIcons("minimize_window.png");
    }



    public static Image getNavigation(IconStyle iconStyle) {
        switch (iconStyle) {
            case LIGHT:
                return loadFromIconsLight("navigation.png");
            case PRIMARY:
                return loadFromIconsPrimary("navigation.png");
        }
        return loadFromIcons("navigation.png");
    }



    public static Image getNotification(IconStyle iconStyle) {
        switch (iconStyle) {
            case LIGHT:
                return loadFromIconsLight("notification.png");
            case PRIMARY:
                return loadFromIconsPrimary("notification.png");
        }
        return loadFromIcons("notification.png");
    }



    public static Image getOpenInNewWindow(IconStyle iconStyle) {
        switch (iconStyle) {
            case LIGHT:
                return loadFromIconsLight("open_in_new_window.png");
            case PRIMARY:
                return loadFromIconsPrimary("open_in_new_window.png");
        }
        return loadFromIcons("open_in_new_window.png");
    }



    public static Image getPackage(IconStyle iconStyle) {
        switch (iconStyle) {
            case LIGHT:
                return loadFromIconsLight("package.png");
            case PRIMARY:
                return loadFromIconsPrimary("package.png");
        }
        return loadFromIcons("package.png");
    }



    public static Image getPalette(IconStyle iconStyle) {
        switch (iconStyle) {
            case LIGHT:
                return loadFromIconsLight("palette.png");
            case PRIMARY:
                return loadFromIconsPrimary("palette.png");
        }
        return loadFromIcons("palette.png");
    }



    public static Image getPerson(IconStyle iconStyle) {
        switch (iconStyle) {
            case LIGHT:
                return loadFromIconsLight("person.png");
            case PRIMARY:
                return loadFromIconsPrimary("person.png");
        }
        return loadFromIcons("person.png");
    }



    public static Image getPets(IconStyle iconStyle) {
        switch (iconStyle) {
            case LIGHT:
                return loadFromIconsLight("pets.png");
            case PRIMARY:
                return loadFromIconsPrimary("pets.png");
        }
        return loadFromIcons("pets.png");
    }



    public static Image getPianoMidi(IconStyle iconStyle) {
        switch (iconStyle) {
            case LIGHT:
                return loadFromIconsLight("piano_midi.png");
            case PRIMARY:
                return loadFromIconsPrimary("piano_midi.png");
        }
        return loadFromIcons("piano_midi.png");
    }



    public static Image getPlaces(IconStyle iconStyle) {
        switch (iconStyle) {
            case LIGHT:
                return loadFromIconsLight("places.png");
            case PRIMARY:
                return loadFromIconsPrimary("places.png");
        }
        return loadFromIcons("places.png");
    }



    public static Image getPower(IconStyle iconStyle) {
        switch (iconStyle) {
            case LIGHT:
                return loadFromIconsLight("power.png");
            case PRIMARY:
                return loadFromIconsPrimary("power.png");
        }
        return loadFromIcons("power.png");
    }



    public static Image getReload(IconStyle iconStyle) {
        switch (iconStyle) {
            case LIGHT:
                return loadFromIconsLight("reload.png");
            case PRIMARY:
                return loadFromIconsPrimary("reload.png");
        }
        return loadFromIcons("reload.png");
    }



    public static Image getRemove(IconStyle iconStyle) {
        switch (iconStyle) {
            case LIGHT:
                return loadFromIconsLight("remove.png");
            case PRIMARY:
                return loadFromIconsPrimary("remove.png");
        }
        return loadFromIcons("remove.png");
    }



    public static Image getRightLarge(IconStyle iconStyle) {
        switch (iconStyle) {
            case LIGHT:
                return loadFromIconsLight("right_large.png");
            case PRIMARY:
                return loadFromIconsPrimary("right_large.png");
        }
        return loadFromIcons("right_large.png");
    }



    public static Image getRightSmall(IconStyle iconStyle) {
        switch (iconStyle) {
            case LIGHT:
                return loadFromIconsLight("right_small.png");
            case PRIMARY:
                return loadFromIconsPrimary("right_small.png");
        }
        return loadFromIcons("right_small.png");
    }



    public static Image getRocket(IconStyle iconStyle) {
        switch (iconStyle) {
            case LIGHT:
                return loadFromIconsLight("rocket.png");
            case PRIMARY:
                return loadFromIconsPrimary("rocket.png");
        }
        return loadFromIcons("rocket.png");
    }



    public static Image getRocketIdle(IconStyle iconStyle) {
        switch (iconStyle) {
            case LIGHT:
                return loadFromIconsLight("rocket_idle.png");
            case PRIMARY:
                return loadFromIconsPrimary("rocket_idle.png");
        }
        return loadFromIcons("rocket_idle.png");
    }



    public static Image getSave(IconStyle iconStyle) {
        switch (iconStyle) {
            case LIGHT:
                return loadFromIconsLight("save.png");
            case PRIMARY:
                return loadFromIconsPrimary("save.png");
        }
        return loadFromIcons("save.png");
    }



    public static Image getScaleWindow(IconStyle iconStyle) {
        switch (iconStyle) {
            case LIGHT:
                return loadFromIconsLight("scale_window.png");
            case PRIMARY:
                return loadFromIconsPrimary("scale_window.png");
        }
        return loadFromIcons("scale_window.png");
    }



    public static Image getScience(IconStyle iconStyle) {
        switch (iconStyle) {
            case LIGHT:
                return loadFromIconsLight("science.png");
            case PRIMARY:
                return loadFromIconsPrimary("science.png");
        }
        return loadFromIcons("science.png");
    }



    public static Image getSearch(IconStyle iconStyle) {
        switch (iconStyle) {
            case LIGHT:
                return loadFromIconsLight("search.png");
            case PRIMARY:
                return loadFromIconsPrimary("search.png");
        }
        return loadFromIcons("search.png");
    }



    public static Image getSelected(IconStyle iconStyle) {
        switch (iconStyle) {
            case LIGHT:
                return loadFromIconsLight("selected.png");
            case PRIMARY:
                return loadFromIconsPrimary("selected.png");
        }
        return loadFromIcons("selected.png");
    }



    public static Image getSettings(IconStyle iconStyle) {
        switch (iconStyle) {
            case LIGHT:
                return loadFromIconsLight("settings.png");
            case PRIMARY:
                return loadFromIconsPrimary("settings.png");
        }
        return loadFromIcons("settings.png");
    }



    public static Image getSettingsSquare(IconStyle iconStyle) {
        switch (iconStyle) {
            case LIGHT:
                return loadFromIconsLight("settings_square.png");
            case PRIMARY:
                return loadFromIconsPrimary("settings_square.png");
        }
        return loadFromIcons("settings_square.png");
    }



    public static Image getSkull(IconStyle iconStyle) {
        switch (iconStyle) {
            case LIGHT:
                return loadFromIconsLight("skull.png");
            case PRIMARY:
                return loadFromIconsPrimary("skull.png");
        }
        return loadFromIcons("skull.png");
    }



    public static Image getSnow(IconStyle iconStyle) {
        switch (iconStyle) {
            case LIGHT:
                return loadFromIconsLight("snow.png");
            case PRIMARY:
                return loadFromIconsPrimary("snow.png");
        }
        return loadFromIcons("snow.png");
    }



    public static Image getSocial(IconStyle iconStyle) {
        switch (iconStyle) {
            case LIGHT:
                return loadFromIconsLight("social.png");
            case PRIMARY:
                return loadFromIconsPrimary("social.png");
        }
        return loadFromIcons("social.png");
    }



    public static Image getStar(IconStyle iconStyle) {
        switch (iconStyle) {
            case LIGHT:
                return loadFromIconsLight("star.png");
            case PRIMARY:
                return loadFromIconsPrimary("star.png");
        }
        return loadFromIcons("star.png");
    }



    public static Image getTable(IconStyle iconStyle) {
        switch (iconStyle) {
            case LIGHT:
                return loadFromIconsLight("table.png");
            case PRIMARY:
                return loadFromIconsPrimary("table.png");
        }
        return loadFromIcons("table.png");
    }



    public static Image getTextFields(IconStyle iconStyle) {
        switch (iconStyle) {
            case LIGHT:
                return loadFromIconsLight("text_fields.png");
            case PRIMARY:
                return loadFromIconsPrimary("text_fields.png");
        }
        return loadFromIcons("text_fields.png");
    }



    public static Image getThea(IconStyle iconStyle) {
        switch (iconStyle) {
            case LIGHT:
                return loadFromIconsLight("thea.png");
            case PRIMARY:
                return loadFromIconsPrimary("thea.png");
        }
        return loadFromIcons("thea.png");
    }



    public static Image getTitle(IconStyle iconStyle) {
        switch (iconStyle) {
            case LIGHT:
                return loadFromIconsLight("title.png");
            case PRIMARY:
                return loadFromIconsPrimary("title.png");
        }
        return loadFromIcons("title.png");
    }



    public static Image getToggle(IconStyle iconStyle) {
        switch (iconStyle) {
            case LIGHT:
                return loadFromIconsLight("toggle.png");
            case PRIMARY:
                return loadFromIconsPrimary("toggle.png");
        }
        return loadFromIcons("toggle.png");
    }



    public static Image getTrash(IconStyle iconStyle) {
        switch (iconStyle) {
            case LIGHT:
                return loadFromIconsLight("trash.png");
            case PRIMARY:
                return loadFromIconsPrimary("trash.png");
        }
        return loadFromIcons("trash.png");
    }



    public static Image getTunes(IconStyle iconStyle) {
        switch (iconStyle) {
            case LIGHT:
                return loadFromIconsLight("tunes.png");
            case PRIMARY:
                return loadFromIconsPrimary("tunes.png");
        }
        return loadFromIcons("tunes.png");
    }



    public static Image getUnderline(IconStyle iconStyle) {
        switch (iconStyle) {
            case LIGHT:
                return loadFromIconsLight("underline.png");
            case PRIMARY:
                return loadFromIconsPrimary("underline.png");
        }
        return loadFromIcons("underline.png");
    }



    public static Image getUpSmall(IconStyle iconStyle) {
        switch (iconStyle) {
            case LIGHT:
                return loadFromIconsLight("up_small.png");
            case PRIMARY:
                return loadFromIconsPrimary("up_small.png");
        }
        return loadFromIcons("up_small.png");
    }



    public static Image getUser(IconStyle iconStyle) {
        switch (iconStyle) {
            case LIGHT:
                return loadFromIconsLight("user.png");
            case PRIMARY:
                return loadFromIconsPrimary("user.png");
        }
        return loadFromIcons("user.png");
    }

}
