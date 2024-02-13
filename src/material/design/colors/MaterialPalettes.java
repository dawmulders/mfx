/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package material.design.colors;
import apps.explorer.models.Directories;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import material.design.common.Colors;
import material.design.common.Strings;
import material.sys.Sys;




/**
 *
 * @author DMulders
 */
public class MaterialPalettes {

    public static MaterialPalette create(String name) throws IllegalArgumentException {
        File file = getPaletteFile(name);
        if (file.exists()) {
            System.out.println("Cannot create new palette because the name " + name + " already exists");
            throw new IllegalArgumentException("Duplicate palette name");
        }
        MaterialPalette palette = new MaterialPalette();
        palette.setPaletteName(name);
        return palette;
    }



    public static MaterialPalette load(String name) {
        File file = getPaletteFile(name);
        MaterialPalette palette = new MaterialPalette();
        palette.setPaletteName(name);
        if (file.exists()) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                    readPaletteColor(palette, line);
                }
                reader.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return palette;
    }



    public static List<MaterialPalette> loadAll() {
        File folder = new File(Sys.getMaterialPalettesFolder().getAbsolutePath());
        File[] children = folder.listFiles();
        List<MaterialPalette> palettes = new ArrayList<>();
        for (int i = 0; i < children.length; i++) {
            File child = children[i];
            if (child.isFile() && Directories.getFileExtension(child).equalsIgnoreCase("palette")) {
                MaterialPalette palette = readPaletteFile(child);
                palettes.add(palette);
            }
        }
        return palettes;
    }



    public static void store(MaterialPalette palette) {
        File file = getPaletteFile(palette.getPaletteName());
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            PrintWriter writer = new PrintWriter(new FileWriter(file));

            writer.println(writeColor("primary", (Color) palette.getPrimary()));
            writer.println(writeColor("primaryVariant", (Color) palette.getPrimaryVariant()));
            writer.println(writeColor("secondary", (Color) palette.getSecondary()));
            writer.println(writeColor("secondaryVariant", (Color) palette.getSecondaryVariant()));
            writer.println(writeColor("background", (Color) palette.getBackground()));
            writer.println(writeColor("surface", (Color) palette.getSurface()));
            writer.println(writeColor("error", (Color) palette.getError()));
            writer.println(writeColor("onPrimary", (Color) palette.getOnPrimary()));
            writer.println(writeColor("onSecondary", (Color) palette.getOnSecondary()));
            writer.println(writeColor("onBackground", (Color) palette.getOnBackground()));
            writer.println(writeColor("onSurface", (Color) palette.getOnSurface()));
            writer.println(writeColor("text", (Color) palette.getText()));
            writer.println(writeColor("textVariant", (Color) palette.getTextVariant()));
            writer.println(writeColor("hover", (Color) palette.getHover()));
            writer.println(writeColor("hoverVariant", (Color) palette.getHoverVariant()));

            writer.flush();
            writer.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }



    private static MaterialPalette readPaletteFile(File file) {
        String name = file.getName().substring(0, file.getName().lastIndexOf("."));
        MaterialPalette palette = new MaterialPalette();
        palette.setPaletteName(name);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                readPaletteColor(palette, line);
            }
            reader.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return palette;
    }



    private static void readPaletteColor(MaterialPalette palette, String line) {
        String[] cells = line.split(";");
        String name = cells[0];
        Paint color = readColor(cells[1], cells[2]);
        if (name.equalsIgnoreCase("primary")) {
            palette.setPrimary(color);
        } else if (name.equalsIgnoreCase("primaryVariant")) {
            palette.setPrimaryVariant(color);
        } else if (name.equalsIgnoreCase("secondary")) {
            palette.setSecondary(color);
        } else if (name.equalsIgnoreCase("secondaryVariant")) {
            palette.setSecondaryVariant(color);
        } else if (name.equalsIgnoreCase("background")) {
            palette.setBackground(color);
        } else if (name.equalsIgnoreCase("surface")) {
            palette.setSurface(color);
        } else if (name.equalsIgnoreCase("error")) {
            palette.setError(color);
        } else if (name.equalsIgnoreCase("onPrimary")) {
            palette.setOnPrimary(color);
        } else if (name.equalsIgnoreCase("onSecondary")) {
            palette.setOnSecondary(color);
        } else if (name.equalsIgnoreCase("onBackground")) {
            palette.setOnBackground(color);
        } else if (name.equalsIgnoreCase("onSurface")) {
            palette.setOnSurface(color);
        } else if (name.equalsIgnoreCase("onError")) {
            palette.setOnError(color);
        } else if (name.equalsIgnoreCase("textVariant")) {
            palette.setTextVariant(color);
        } else if (name.equalsIgnoreCase("text")) {
            palette.setText(color);
        } else if (name.equalsIgnoreCase("hoverVariant")) {
            palette.setHoverVariant(color);
        } else if (name.equalsIgnoreCase("hover")) {
            palette.setHover(color);
        }
    }



    private static Paint readColor(String hex, String opacity) {
        return Color.web(hex, Double.parseDouble(opacity));
    }



    private static String writeColor(String key, Color color) {
        return key + ";" + Colors.hexRGB(color) + ";" + Strings.d2(color.getOpacity());
    }



    private static File getPaletteFile(String name) {
        return new File(Sys.getMaterialPalettesFolder().getAbsolutePath() + "\\" + name + ".palette");
    }

}
