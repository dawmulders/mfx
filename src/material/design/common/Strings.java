/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package material.design.common;
import java.io.File;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;




/**
 *
 * @author DMulders
 */
public class Strings {

    public static final DecimalFormat DF0 = new DecimalFormat("#", DecimalFormatSymbols.getInstance(Locale.ENGLISH));
    public static final DecimalFormat DF1 = new DecimalFormat("#.0", DecimalFormatSymbols.getInstance(Locale.ENGLISH));
    public static final DecimalFormat DF2 = new DecimalFormat("#.00", DecimalFormatSymbols.getInstance(Locale.ENGLISH));

    public static final DateTimeFormatter YYMMDDHHSS = DateTimeFormatter.ofPattern("yyMMdd_HHmm");
    public static final DateTimeFormatter YYYYMMDDHHSS = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");



    public static final String indent(String text, int tabs) {
        String retval = "";
        for (int i = 0; i < tabs; i++) {
            retval += "\t";
        }
        return retval + text;
    }



    public static final String join(List<String> list, String delimiter) {
        String retval = "";
        if (null != list && !list.isEmpty()) {
            retval = list.get(0);
            if (list.size() > 1) {
                for (int i = 1; i < list.size(); i++) {
                    retval += delimiter + list.get(i);
                }
            }
        }
        return retval;
    }



    public static final String d0(double value) {
        return DF0.format(value);
    }



    public static final String d1(double value) {
        return DF1.format(value);
    }



    public static final String d2(double value) {
        return DF2.format(value);
    }



    public static String dateTime(LocalDateTime ldt) {
        return YYYYMMDDHHSS.format(ldt);
    }



    public static final String timestampYymmdd_hhss() {
        return YYMMDDHHSS.format(LocalDateTime.now());
    }



    public static String toUpperCaseWithSpaces(String raw) {
        String name = raw.trim();
        if (name.contains(".")) {
            name = name.substring(0, name.lastIndexOf("."));
        }
        if (name.contains("_")) {
            String[] parts = name.split("_");
            name = "";
            for (int ii = 0; ii < parts.length; ii++) {
                name += parts[ii].substring(0, 1).toUpperCase();
                name += parts[ii].substring(1);
                if (ii < parts.length - 1) {
                    name += " ";
                }
            }
        } else {
            name = name.substring(0, 1).toUpperCase() + name.substring(1);
        }
        return name;
    }



    public static String toCamelCase(File file) {
        return toCamelCase(file.getName());
    }



    public static String toCamelCase(String name) {
        if (name.contains(".")) {
            name = name.substring(0, name.lastIndexOf("."));
        }
        if (name.contains("_")) {
            String[] parts = name.split("_");
            name = "";
            for (int ii = 0; ii < parts.length; ii++) {
                name += parts[ii].substring(0, 1).toUpperCase();
                name += parts[ii].substring(1);
            }
        } else {
            name = name.substring(0, 1).toUpperCase() + name.substring(1);
        }
        return name;
    }

}
