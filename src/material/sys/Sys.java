/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package material.sys;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.util.Properties;
import material.design.common.Strings;




/**
 *
 * @author DMulders
 */
public class Sys {

    public static boolean WRITE_INFO = true;
    public static boolean WRITE_WARNINGS = true;
    public static boolean WRITE_EXCEPTIONS = true;



    public static void print(Class source, String text) {
        System.out.println(source.getSimpleName());
    }



    public static File getAppDataFolder() {
        File file = new File(System.getProperty("user.home") + "\\AppData\\Local\\Mfx\\");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }



    public static File getMaterialPalettesFolder() {
        File folder = new File(getAppDataFolder().getAbsolutePath() + "\\Materials\\Palettes\\");
        if (!folder.exists()) {
            folder.mkdirs();
        }
        return folder;
    }



    public static File getMaterialFontsFolder() {
        File folder = new File(getAppDataFolder().getAbsolutePath() + "\\Materials\\Fonts\\");
        if (!folder.exists()) {
            folder.mkdirs();
        }
        return folder;
    }



    public static File getGeneratedStylesheetsFolder() {
        File folder = new File(getAppDataFolder().getAbsolutePath() + "\\Generated\\Stylesheets\\");
        if (!folder.exists()) {
            folder.mkdirs();
        }
        return folder;
    }



    public static File getLastLocationProperty(String key) {
        Properties props = loadLocations();
        if (!props.containsKey(key)) {
            props.put(key, System.getProperty("user.home"));
            storeLocations(props);
        }
        return new File((String) props.get(key));
    }



    public static void setLastLocationProperty(String key, File file) {
        String location = file.getAbsolutePath();
        if (file.isFile()) {
            location = file.getParentFile().getAbsolutePath();
        }
        Properties props = loadLocations();
        props.put(key, location);
        storeLocations(props);
    }



    private static Properties loadLocations() {
        File file = new File(getAppDataFolder().getAbsolutePath() + "\\locations.properties");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception e) {
            }
        }
        Properties props = new Properties();
        try {
            props.load(new FileInputStream(file));
        } catch (Exception e) {
            System.out.println(e);
        }
        return props;
    }



    private static void storeLocations(Properties props) {
        File file = new File(getAppDataFolder().getAbsolutePath() + "\\locations.properties");
        try {
            props.store(new FileOutputStream(file), "stored on " + Strings.dateTime(LocalDateTime.now()));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
