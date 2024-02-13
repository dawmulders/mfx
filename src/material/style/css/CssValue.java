/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package material.style.css;




/**
 *
 * @author DMulders
 */
public class CssValue {

    public String key;
    public String value;



    public CssValue(String key, String value) {
        this.key = key;
        this.value = value;
    }



    @Override
    public String toString() {
        return key + ": " + value + ";";
    }

}
