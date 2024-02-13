/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apps.explorer.models;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;




/**
 *
 * @author DMulders
 */
public class RootFile extends SystemFile {

    public final String rootName;
    private HashSet<Directory> dirs;



    public RootFile(String name) {
        super(createRootFilePath(name), FileType.ROOTFILE);
        this.rootName = name;
        dirs = new HashSet<>();
        dirs.addAll(loadChildren(name));
    }



    public List<Directory> createDirectoryList() {
        List<Directory> dirlist = new ArrayList<>();
        dirlist.addAll(dirs);
        dirlist.sort((o1, o2) -> {
            return o1.getName().compareTo(o2.getName());
        });
        return dirlist;
    }



    public void addDirectory(Directory dir) {
        if (dirs.add(dir)) {
            storeChildren(rootName, dirs);
        }
    }



    public void removeDirectory(Directory dir) {
        if (dirs.remove(dir)) {
            storeChildren(rootName, dirs);
        }
    }



    private static String createRootFilePath(String name) {
        File folder = new File(System.getProperty("user.home") + "\\AppData\\Local\\Mfx\\Roots\\");
        folder.mkdirs();
        File file = new File(folder.getAbsolutePath() + "\\" + name + ".mfxroot");
        try {
            file.createNewFile();
        } catch (Exception e) {
        }
        return file.getAbsolutePath();
    }



    private static List<Directory> loadChildren(String name) {
        File file = new File(System.getProperty("user.home") + "\\AppData\\Local\\Mfx\\Roots\\" + name + ".mfxroot");
        List<Directory> list = new ArrayList<>();
        try {
            if (file.exists()) {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                    list.add(new Directory(line));
                }
                reader.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }



    private static void storeChildren(String name, HashSet<Directory> set) {
        File file = new File(System.getProperty("user.home") + "\\AppData\\Local\\Mfx\\Roots\\" + name + ".mfxroot");
        Iterator<Directory> i = set.iterator();
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(file));
            while (i.hasNext()) {
                Directory dir = i.next();
                pw.println(dir.getAbsolutePath());
            }
            pw.flush();
            pw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
