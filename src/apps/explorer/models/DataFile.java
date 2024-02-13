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
public class DataFile extends SystemFile {

    private final String fileName;
    private final String fileExt;



    public DataFile(String path) {
        super(path, FileType.DATAFILE);
        this.fileExt = Directories.getFileExtension(this);
        this.fileName = super.getName().replace("." + fileExt, "");
    }



    public String getFileNameWithoutExt() {
        return fileName;
    }



    public String getFileExtension() {
        return fileExt;
    }

}
