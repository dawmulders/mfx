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
public class Directory extends SystemFile {

    private Directory[] dirs;
    private DataFile[] data;
    private SystemFile[] entries;



    public Directory(String path) {
        super(path, FileType.DIRECTORY);
    }



    public int getDirCount() {
        return getDirs().length;
    }



    public int getDataFileCount() {
        return getDataFiles().length;
    }



    public Directory[] getDirs() {
        if (null == dirs) {
            dirs = Directories.listDirs(this);
        }
        return dirs;
    }



    public DataFile[] getDataFiles() {
        if (null == data) {
            data = Directories.listData(this);
        }
        return data;
    }



    public SystemFile[] getSystemFiles() {
        if (null == entries) {
            entries = new SystemFile[getDirCount() + getDataFileCount()];
            int index = 0;
            for (int i = 0; i < dirs.length; i++) {
                entries[index] = dirs[i];
                index++;
            }
            for (int i = 0; i < data.length; i++) {
                entries[index] = data[i];
                index++;
            }
        }
        return entries;
    }

}
