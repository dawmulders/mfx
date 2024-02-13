/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package material.style.css;
import java.util.HashMap;
import java.util.Map;




/**
 *
 * @author DMulders
 */
public class CssTemplateEntry {

    private String selector;
    private Map<String, String> dict;



    public CssTemplateEntry() {
        dict = new HashMap<>();
    }



    public CssTemplateEntry(String selector) {
        this.selector = selector;
        this.dict = new HashMap<>();
    }



    public CssTemplateEntry(String selector, Map<String, String> values) {
        this.selector = selector;
        this.dict = values;
    }
    
    
    
    

}
