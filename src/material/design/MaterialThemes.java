/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package material.design;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import material.design.colors.MaterialPalette;
import material.design.colors.MaterialPalettes;
import material.design.typography.MaterialFont;
import material.design.typography.MaterialFonts;




/**
 *
 * @author DMulders
 */
public class MaterialThemes {

    public static List<MaterialTheme> loadAll() {
        List<MaterialTheme> list = new ArrayList<>();
        List<MaterialFont> fontList = MaterialFonts.loadAll();
        List<MaterialPalette> paletteList = MaterialPalettes.loadAll();
        for (int i = 0; i < paletteList.size(); i++) {
            MaterialPalette palette = paletteList.get(i);
            MaterialFont fontMatch = null;
            String name = palette.getPaletteName();

            Iterator<MaterialFont> iter = fontList.iterator();
            while (iter.hasNext()) {
                MaterialFont font = iter.next();
                if (font.getFontName().equalsIgnoreCase(name)) {
                    fontMatch = font;
                    break;
                }
            }
            if (fontMatch != null) {
                list.add(new MaterialTheme(palette, fontMatch));
            } else {
                System.out.println("Could not find matching font for palette " + name);
            }
        }
        return list;
    }



    public static MaterialTheme load(String name) {
        MaterialPalette palette = MaterialPalettes.load(name);
        MaterialFont font = MaterialFonts.load(name);
        return new MaterialTheme(palette, font);
    }



    public static MaterialTheme create(String name) {
        MaterialPalette palette = MaterialPalettes.create(name);
        MaterialFont font = MaterialFonts.create(name);
        return new MaterialTheme(palette, font);
    }



    public static void store(MaterialTheme theme) {
        MaterialPalettes.store(theme.getMaterialPalette());
        MaterialFonts.store(theme.getMaterialFont());
    }

    
    public static void main(String[] args){
        MaterialTheme theme = new MaterialTheme(new MaterialPalette(), new MaterialFont(true));
        store(theme);
                
    }
    
    
}
