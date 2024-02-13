/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apps.explorer.models;
import java.io.File;
import java.util.ArrayList;
import java.util.List;




/**
 *
 * @author DMulders
 */
public class Directories {
    
    public static void main(String[] args){
        RootFile[] roots = listRoots();
        for(RootFile root:roots){
            System.out.println(root.rootName);
            List<Directory> dirs = root.createDirectoryList();
            dirs.forEach((t) -> {
                System.out.println("\t " + t.getAbsolutePath());
            });
        }
    }
    
    public static Directory[] getUserDirectories() {
        return new Directory[]{
            new Directory(System.getProperty("user.home") + "\\"),
            new Directory(System.getProperty("user.home") + "\\Desktop"),
            new Directory(System.getProperty("user.home") + "\\Downloads"),
            new Directory(System.getProperty("user.home") + "\\Documents"),
            new Directory(System.getProperty("user.home") + "\\Images")
        };
    }



    public static RootFile[] listRoots() {
        List<RootFile> list = new ArrayList<>();
        File folder = new File(System.getProperty("user.home") + "\\AppData\\Local\\Mfx\\Roots\\");
        File[] children = folder.listFiles();
        if (null != children) {
            for (int i = 0; i < children.length; i++) {
                String ext = getFileExtension(children[i]);
                if (ext.equalsIgnoreCase("mfxroot")) {
                    String name = children[i].getName().replace(".mfxroot", "");
                    list.add(new RootFile(name));
                }
            }
        }
        return list.toArray(new RootFile[list.size()]); 
    }



    public static Directory[] listDirs(File root) {
        List<Directory> list = new ArrayList<>();
        File[] files = root.listFiles();
        if (null != files) {
            for (int i = 0; i < files.length; i++) {
                if (files[i].isDirectory() && !files[i].isHidden() && !files[i].getName().startsWith(".")) {
                    list.add(new Directory(files[i].getPath()));
                }
            }
        }
        list.sort((o1, o2) -> {
            return o1.getName().compareTo(o2.getName());
        });
        return list.toArray(new Directory[list.size()]);
    }



    public static DataFile[] listData(File root) {
        List<DataFile> list = new ArrayList<>();
        File[] files = root.listFiles();
        if (null != files) {
            for (int i = 0; i < files.length; i++) {
                String ext = getFileExtension(files[i]);
                if (ext.length() > 0) {
                    list.add(new DataFile(files[i].getAbsolutePath()));
                }
            }
        }
        list.sort((o1, o2) -> {
            return o1.getName().compareTo(o2.getName());
        });
        return list.toArray(new DataFile[list.size()]);
    }



    public static String getFileExtension(File file) {
        if (file == null || file.isHidden() || file.isDirectory() || !file.getName().contains(".") || file.getName().lastIndexOf(".") >= (file.getName().length() - 1)) {
            return "";
        }
        String[] parts = file.getName().split("\\.");
        return parts[parts.length - 1];
    }



    
}
