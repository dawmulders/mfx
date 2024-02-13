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
public class CssStatement {
    private final List<CssSelector> selectors = new ArrayList<>();
    private final List<CssValue> values = new ArrayList<>();
    
    public CssStatement(){
        
    }
    
    public void appenSelector(CssSelector selector){
        selectors.add(selector);
    }
    public void appendValue(CssValue value){
        values.add(value);
    }
    
}
