/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apps.explorer.models;
import java.io.File;




/**
 *
 * @author DMulders
 */
public class SystemFile extends File {

    public final FileType fileType;



    public SystemFile(String path, FileType type) {
        super(path);
        this.fileType = type;
    }

}
