/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package material.style.css;
import java.util.ArrayList;
import java.util.List;







/**
 *
 * @author DMulders
 */
public class CssParser {
    private final List<CssStatement> statements = new ArrayList<>();
    private CssStatement currentStatement = null;
    private CssSelector currentSelector = null;
    private String buffer = "";
    
    
    public CssParser(){
        
    }
    
    
    public void parse(String raw){
        String[] chars = raw.split("(?!^)");
        boolean parsingSelector = true;
        for(int i = 0; i < chars.length; i++){
            if(chars[i].equals("{")){
                
            }
                 
        }
        
    }
   
    
    
}
