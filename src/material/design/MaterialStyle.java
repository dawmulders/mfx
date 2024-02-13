/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package material.design;
import material.design.colors.MaterialPalette;
import material.design.typography.MaterialFont;




/**
 *
 * @author DMulders
 */
public class MaterialStyle {

    private final String name;
    private MaterialPalette palette;
    private MaterialFont font;



    public MaterialStyle(String name) {
        this.name = name;
        this.palette = new MaterialPalette();
        this.font = new MaterialFont(false);
    }



    public MaterialStyle(String name, MaterialPalette palette, MaterialFont font) {
        this.name = name;
        this.palette = palette;
        this.font = font;
    }



    public String getName() {
        return name;
    }



    public MaterialPalette getPalette() {
        return palette;
    }



    public void setPalette(MaterialPalette palette) {
        this.palette = palette;
    }



    public MaterialFont getFont() {
        return font;
    }



    public void setFont(MaterialFont font) {
        this.font = font;
    }

}
