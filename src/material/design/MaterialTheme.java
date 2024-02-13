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
public class MaterialTheme implements IMaterialTheme {

    private MaterialPalette palette;
    private MaterialFont font;



    public MaterialTheme(MaterialPalette palette, MaterialFont font) {
        this.palette = palette;
        this.font = font;
    }



    @Override
    public MaterialPalette getMaterialPalette() {
        return palette;
    }



    @Override
    public MaterialFont getMaterialFont() {
        return font;
    }

}
