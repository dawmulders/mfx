/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package material.design.typography;
import java.util.Objects;
import javafx.scene.text.Font;
import material.design.common.Strings;




/**
 *
 * @author DMulders
 */
public class MaterialFontSpec {

    public final String family;
    public final double size;
    public final String style;
    public final String name;



    public MaterialFontSpec(String family, double size, String style, String name) {
        this.family = family;
        this.size = size;
        this.style = style;
        this.name = name;
    }



    @Override
    public String toString() {
        return family + ", " + Strings.d0(size) + ", " + style + ", " + name;
    }



    @Override
    public boolean equals(Object obj) {
        if (null != obj) {
            if (obj instanceof MaterialFontSpec) {
                MaterialFontSpec mfs = (MaterialFontSpec) obj;
                return this.family.equalsIgnoreCase(mfs.family)
                        && Math.sqrt(Math.pow(this.size - mfs.size, 2)) < 0.5
                        && this.style.equalsIgnoreCase(mfs.style)
                        && this.name.equalsIgnoreCase(mfs.name);
            } else if (obj instanceof Font) {
                Font font = (Font) obj;
                return this.family.equalsIgnoreCase(font.getFamily())
                        && Math.sqrt(Math.pow(this.size - font.getSize(), 2)) < 0.5
                        && this.style.equalsIgnoreCase(font.getStyle())
                        && this.name.equalsIgnoreCase(font.getName());
            }
        }
        return false;
    }



    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.family);
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.size) ^ (Double.doubleToLongBits(this.size) >>> 32));
        hash = 97 * hash + Objects.hashCode(this.style);
        hash = 97 * hash + Objects.hashCode(this.name);
        return hash;
    }



    public boolean equalsFont(Font font) {
        return this.family.equalsIgnoreCase(font.getFamily())
                && Math.sqrt(Math.pow(this.size - font.getSize(), 2)) < 0.5
                && this.style.equalsIgnoreCase(font.getStyle())
                && this.name.equalsIgnoreCase(font.getName());
    }



    public boolean equals(String family, String style, String name) {
        return this.family.equalsIgnoreCase(family)
                && this.style.equalsIgnoreCase(style)
                && this.name.equalsIgnoreCase(name);
    }



    public String toMaterialFontfileLine() {
        return this.toString().replaceAll(",", ";");
    }

}
