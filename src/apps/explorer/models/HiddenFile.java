/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apps.explorer.models;




/**
 *
 * @author DMulders
 */
public class HiddenFile extends SystemFile {

    public HiddenFile(String pathname) {
        super(pathname, FileType.HIDDEN);
    }

}
