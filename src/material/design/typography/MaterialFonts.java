/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package material.design.typography;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javafx.scene.text.Font;
import material.design.common.Strings;
import material.sys.Sys;




/**
 *
 * @author DMulders
 */
public class MaterialFonts {

    public static void store(MaterialFont font) {
        storeMaterialFontFile(font);
        storeMaterialFontfiles(font);
    }



    public static MaterialFont create(String name) {
        MaterialFont font = new MaterialFont(name);
        store(font);
        return font;
    }



    public static MaterialFont load(String name) {
        File fontfolder = getFontFolder(name);
        return loadFromFile(fontfolder);
    }



    public static List<MaterialFont> loadAll() {
        List<MaterialFont> fonts = new ArrayList<>();
        File root = Sys.getMaterialFontsFolder();
        File[] fontRoots = root.listFiles();
        if (fontRoots != null) {
            for (int i = 0; i < fontRoots.length; i++) {
                MaterialFont materialFont = loadFromFile(fontRoots[i]);
                fonts.add(materialFont);
            }
        }
        return fonts;
    }



    private static void storeMaterialFontFile(MaterialFont materialFont) {
        File fontfile = getFontFile(materialFont.getFontName());
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(fontfile));

            writer.println(makeLine("h1", materialFont.getH1()));
            writer.println(makeLine("h2", materialFont.getH2()));
            writer.println(makeLine("h3", materialFont.getH3()));
            writer.println(makeLine("h4", materialFont.getH4()));
            writer.println(makeLine("h5", materialFont.getH5()));
            writer.println(makeLine("h6", materialFont.getH6()));
            writer.println(makeLine("subtitle1", materialFont.getSubtitle1()));
            writer.println(makeLine("subtitle2", materialFont.getSubtitle2()));
            writer.println(makeLine("body1", materialFont.getBody1()));
            writer.println(makeLine("body2", materialFont.getBody2()));
            writer.println(makeLine("button", materialFont.getButton()));
            writer.println(makeLine("caption", materialFont.getCaption()));
            writer.println(makeLine("overline", materialFont.getOverline()));

            writer.flush();
            writer.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }



    private static void storeMaterialFontfiles(MaterialFont materialFont) {
        File fontfileFolder = getFontFileFolder(materialFont.getFontName());
        if (materialFont.hasFontFiles()) {
            Iterator<File> i = materialFont.fontfileIterator();
            while (i.hasNext()) {
                File file = i.next();
                String filename = file.getName();
                File targetFile = new File(fontfileFolder.getAbsolutePath() + "\\" + filename);
                if (!targetFile.exists()) {
                    try {
                        Files.copy(Paths.get(file.toURI()), Paths.get(targetFile.toURI()), StandardCopyOption.REPLACE_EXISTING);
                    } catch (Exception e) {
                        System.out.println("Failed to copy font file to Material Font fontfiles folder");
                        System.out.println("\tsource " + file.getAbsolutePath());
                        System.out.println("\ttarget " + targetFile.getAbsolutePath());
                    }
                }
            }
        }
    }



    private static String makeLine(String key, Font font) {
        return key + ";" + font.getFamily() + ";" + Strings.d0(font.getSize()) + ";" + font.getStyle() + ";" + font.getName();
    }



    private static MaterialFontSpec readLine(String line) {
        String[] cells = line.split(";");
        String family = cells[1];
        double size = Double.parseDouble(cells[2]);
        String style = cells[3];
        String name = cells[4];
        return new MaterialFontSpec(family, size, style, name);
    }



    private static MaterialFont loadFromFile(File fontFolder) {
        String name = fontFolder.getName();
        MaterialFont materialFont = new MaterialFont(name);
        FontfileMap map = new FontfileMap();
        File fontfileFolder = getFontFileFolder(name);
        File[] fontfiles = fontfileFolder.listFiles();
        if (fontfiles != null) {
            for (int i = 0; i < fontfiles.length; i++) {
                map.registerFile(fontfiles[i]);
            }
        }
        File fontfile = getFontFile(name);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fontfile));
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                String key = line.split(";")[0];
                MaterialFontSpec spec = readLine(line);
                Font font = map.loadFont(spec.family, spec.size, spec.style, spec.name);
                if (font != null) {
                    materialFont.addFontfile(map.findFile(spec.family, spec.style, spec.name));
                    if (key.equalsIgnoreCase("h1")) {
                        materialFont.setH1(font);
                    }
                    if (key.equalsIgnoreCase("h2")) {
                        materialFont.setH2(font);
                    }
                    if (key.equalsIgnoreCase("h3")) {
                        materialFont.setH3(font);
                    }
                    if (key.equalsIgnoreCase("h4")) {
                        materialFont.setH4(font);
                    }
                    if (key.equalsIgnoreCase("h5")) {
                        materialFont.setH5(font);
                    }
                    if (key.equalsIgnoreCase("h6")) {
                        materialFont.setH6(font);
                    }
                    if (key.equalsIgnoreCase("subtitle1")) {
                        materialFont.setSubtitle1(font);
                    }
                    if (key.equalsIgnoreCase("subtitle2")) {
                        materialFont.setSubtitle2(font);
                    }
                    if (key.equalsIgnoreCase("body1")) {
                        materialFont.setBody1(font);
                    }
                    if (key.equalsIgnoreCase("body2")) {
                        materialFont.setBody2(font);
                    }
                    if (key.equalsIgnoreCase("button")) {
                        materialFont.setButton(font);
                    }
                    if (key.equalsIgnoreCase("caption")) {
                        materialFont.setCaption(font);
                    }
                    if (key.equalsIgnoreCase("overline")) {
                        materialFont.setOverline(font);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return materialFont;
    }



    private static File getFontFolder(String name) {
        File folder = new File(Sys.getMaterialFontsFolder().getAbsolutePath() + "\\" + name);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        return folder;
    }



    private static File getFontFileFolder(String name) {
        File folder = new File(Sys.getMaterialFontsFolder() + "\\" + name + "\\fontfiles\\");
        if (!folder.exists()) {
            folder.mkdirs();
        }
        return folder;
    }



    private static File getFontFile(String name) {
        File folder = new File(Sys.getMaterialFontsFolder() + "\\" + name);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        File file = new File(folder.getAbsolutePath() + "\\" + name + ".materialfont");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception e) {
            }
        }
        return file;
    }

}
