/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package material.style.css;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import javafx.scene.paint.Color;
import material.design.MaterialStyle;
import material.design.common.Colors;
import material.design.common.Strings;
import material.sys.Sys;




/**
 *
 * @author DMulders
 */
public class StylesheetParser {

    public static File getTemplateFile() {
        return new File(Sys.getAppDataFolder().getAbsolutePath() + "\\Stylesheets\\style_template.css");
    }



    public static File createStylesheetFile(MaterialStyle style) {
        File template = new File(Sys.getAppDataFolder().getAbsolutePath() + "\\Stylesheets\\style_template.css");
        return generateStylesheet(template, style);
    }



    public static File generateStylesheet(File cssTemplate, MaterialStyle style) {
        File cssOutput = new File(Sys.getGeneratedStylesheetsFolder().getAbsolutePath() + "\\" + style.getName() + ".css");
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(cssOutput));
            BufferedReader reader = new BufferedReader(new FileReader(cssTemplate));

            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                String newline = parseLine(line, style);
                System.out.println(newline);
                writer.println(newline);
            }

            reader.close();
            writer.flush();
            writer.close();
        } catch (Exception e) {
            System.out.println("Failed to generate style sheet");
            System.out.println(e);
        }
        return cssOutput;
    }



    private static String parseLine(String line, MaterialStyle style) {
        if (line.contains("#onPrimary")) {
            return line.replace("#onPrimary", Colors.toCssColor((Color) style.getPalette().getOnPrimary()));
        }
        if (line.contains("#primaryVariant")) {
            return line.replace("#primaryVariant", Colors.toCssColor((Color) style.getPalette().getPrimaryVariant()));
        }
        if (line.contains("#primary")) {
            return line.replace("#primary", Colors.toCssColor((Color) style.getPalette().getPrimary()));
        }
        if (line.contains("#onSecondary")) {
            return line.replace("#onSecondary", Colors.toCssColor((Color) style.getPalette().getOnSecondary()));
        }
        if (line.contains("#secondaryVariant")) {
            return line.replace("#secondaryVariant", Colors.toCssColor((Color) style.getPalette().getSecondaryVariant()));
        }
        if (line.contains("#secondary")) {
            return line.replace("#secondary", Colors.toCssColor((Color) style.getPalette().getSecondary()));
        }

        if (line.contains("#onBackground")) {
            return line.replace("#onBackground", Colors.toCssColor((Color) style.getPalette().getOnBackground()));
        }
        if (line.contains("#background")) {
            return line.replace("#background", Colors.toCssColor((Color) style.getPalette().getBackground()));
        }
        if (line.contains("#onSurface")) {
            return line.replace("#onSurface", Colors.toCssColor((Color) style.getPalette().getOnSurface()));
        }
        if (line.contains("#surface")) {
            return line.replace("#surface", Colors.toCssColor((Color) style.getPalette().getSurface()));
        }
        if (line.contains("#onError")) {
            return line.replace("#onError", Colors.toCssColor((Color) style.getPalette().getOnError()));
        }
        if (line.contains("#error")) {
            return line.replace("#error", Colors.toCssColor((Color) style.getPalette().getError()));
        }

        if (line.contains("#h1")) {
            return line.replace("#h1", Strings.d1(style.getFont().getH1().getSize()) + "px \"" + style.getFont().getH1().getFamily() + "\" ");
        }
        if (line.contains("#h2")) {
            return line.replace("#h2", Strings.d1(style.getFont().getH2().getSize()) + "px \"" + style.getFont().getH2().getFamily() + "\" ");
        }
        if (line.contains("#h3")) {
            return line.replace("#h3", Strings.d1(style.getFont().getH3().getSize()) + "px \"" + style.getFont().getH3().getFamily() + "\" ");
        }
        if (line.contains("#h4")) {
            return line.replace("#h4", Strings.d1(style.getFont().getH4().getSize()) + "px \"" + style.getFont().getH4().getFamily() + "\" ");
        }
        if (line.contains("#h5")) {
            return line.replace("#h5", Strings.d1(style.getFont().getH5().getSize()) + "px \"" + style.getFont().getH5().getFamily() + "\" ");
        }
        if (line.contains("#h6")) {
            return line.replace("#h6", Strings.d1(style.getFont().getH6().getSize()) + "px \"" + style.getFont().getH6().getFamily() + "\" ");
        }

        if (line.contains("#subtitle1")) {
            return line.replace("#subtitle1", Strings.d1(style.getFont().getSubtitle1().getSize()) + "px \"" + style.getFont().getSubtitle1().getFamily() + "\" ");
        }
        if (line.contains("#subtitle2")) {
            return line.replace("#subtitle2", Strings.d1(style.getFont().getSubtitle2().getSize()) + "px \"" + style.getFont().getSubtitle2().getFamily() + "\" ");
        }
        if (line.contains("#body2")) {
            return line.replace("#body2", Strings.d1(style.getFont().getBody2().getSize()) + "px \"" + style.getFont().getBody2().getFamily() + "\" ");
        }
        if (line.contains("#body")) {
            return line.replace("#body1", Strings.d1(style.getFont().getBody1().getSize()) + "px \"" + style.getFont().getBody1().getFamily() + "\" ");
        }

        if (line.contains("#button")) {
            return line.replace("#button", Strings.d1(style.getFont().getButton().getSize()) + "px \"" + style.getFont().getButton().getFamily() + "\" ");
        }
        if (line.contains("#caption")) {
            return line.replace("#caption", Strings.d1(style.getFont().getCaption().getSize()) + "px \"" + style.getFont().getCaption().getFamily() + "\" ");
        }
        if (line.contains("#overline")) {
            return line.replace("#overline", Strings.d1(style.getFont().getOverline().getSize()) + "px \"" + style.getFont().getOverline().getFamily() + "\" ");
        }

        return line;
    }

}
