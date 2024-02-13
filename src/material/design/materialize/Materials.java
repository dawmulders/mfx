/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package material.design.materialize;
import material.design.IMaterialTheme;
import material.design.colors.MaterialPalette;
import material.design.typography.MaterialFont;




/**
 *
 * @author DMulders
 */
public class Materials implements IMaterialTheme {

    /**
     * Instance properties
     */
    private MaterialFont font;
    private MaterialPalette palette;



    /**
     * Singleton getter
     *
     * @return
     */
    public static Materials materials() {
        if (null == instance) {
            synchronized (Materials.class) {
                if (null == instance) {
                    instance = new Materials();
                }
            }
        }
        return instance;
    }

    /**
     * Singleton instance
     */
    private static Materials instance = null;



    /**
     * private constructor
     */
    private Materials() {
        font = new MaterialFont(false);
        palette = new MaterialPalette();
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
