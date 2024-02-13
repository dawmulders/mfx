/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apps.iconbrowser.gitrepo;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;




/**
 *
 * @author DMulders
 */
public class MaterialIconFiles {

    private static String REPO_PATH = "C:\\Libraries\\Code\\FxMaterial\\icons";
    private static String RESOURCE_PATH = "C:\\Libraries\\Code\\FxMaterial\\res\\materialicons";



    public static void main(String[] args) {
        createResourceFoldersForIcons();
    }



    public static void createResourceFoldersForIcons() {
        for (int i = 0; i < MaterialIconCategory.CATEGORIES.length; i++) {
            MaterialIconCategory cat = MaterialIconCategory.CATEGORIES[i];
            File catFolderFile = new File(RESOURCE_PATH + "\\" + cat.name());
            catFolderFile.mkdirs();

            for (MaterialIconStyle style : MaterialIconStyle.STYLES) {
                File styleFolderFile = new File(RESOURCE_PATH + "\\" + cat.name() + "\\" + style.name());
                styleFolderFile.mkdir();
                List<File> imageSources = collectImageFilesFromRepo(cat, style);
                
                System.out.println(cat.name() + " " + style.name() + " " + String.valueOf(imageSources.size()) + " images");
                
                Iterator<File> iter = imageSources.iterator();
                while (iter.hasNext()) {
                    File source = iter.next();
                    File target = new File(RESOURCE_PATH + "\\" + cat.name() + "\\" + style.name() + "\\" + formatRepoImageName(source));
                    try {
                        Files.copy(Paths.get(source.toURI()), Paths.get(target.toURI()), StandardCopyOption.REPLACE_EXISTING);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
            }

        }
    }



    private static String formatRepoImageName(File file) {
        String name = file.getName();
        name = name.replace(".png", "");
        name = name.replace("baseline_", "");
        name = name.replace("sharp_", "");
        name = name.replace("round_", "");
        name = name.replace("twotone_", "");
        name = name.replace("outline_", "");
        if (name.contains("_black_")) {
            name = name.split("_black_")[0];
        }
        return name + ".png";
    }



    public static List<File> collectImageFilesFromRepo(MaterialIconCategory cat, MaterialIconStyle style) {
        List<File> imageFiles = new ArrayList<>();
        File repoRoot = new File(REPO_PATH + "\\" + cat.name());
        List<File> iconFolders = getFolders(repoRoot, false);
        Iterator<File> i = iconFolders.iterator();
        while (i.hasNext()) {
            File iconFolder = i.next();
            File styleFolder = findStyleFolder(iconFolder, style);
            if (styleFolder == null) {
                System.out.println("No stylefolder found for " + iconFolder.getName());
                continue;
            }
            String iconName = iconFolder.getName();
            File imageFile = getLargestImageFile(styleFolder);
            if (imageFile != null) {
                imageFiles.add(imageFile);
            } else {
                System.out.println("No image file found for " + iconName);
            }
        }
        return imageFiles;
    }



    private static File getLargestImageFile(File folder) {
        List<File> images = getImages(folder, true);
        File largest = null;
        long maxSize = 0;
        for (int i = 0; i < images.size(); i++) {
            File file = images.get(i);
            long length = file.length();
            if (length > maxSize) {
                maxSize = length;
                largest = file;
            }
        }
        if (largest == null) {

        }
        return largest;
    }



    private static File findStyleFolder(File iconFolder, MaterialIconStyle style) {
        File match = null;
        List<File> styleFolders = getFolders(iconFolder, false);
        Iterator<File> i = styleFolders.iterator();
        while (i.hasNext()) {
            File folder = i.next();
            if (isStyleFolder(folder, style)) {
                match = folder;
                break;
            }
        }
        return match;
    }



    private static boolean isStyleFolder(File folder, MaterialIconStyle style) {
        String name = folder.getName();
        if (name.contains("outlined")) {
            return style == MaterialIconStyle.outlined;
        }
        if (name.contains("round")) {
            return style == MaterialIconStyle.rounded;
        }
        if (name.contains("sharp")) {
            return style == MaterialIconStyle.sharp;
        }
        if (name.contains("twotone")) {
            return style == MaterialIconStyle.twotone;
        }
        if (name.contains("materialicons")) {
            return style == MaterialIconStyle.standard;
        }
        return false;
    }



    private static List<File> getFolders(File file, boolean deepsearch) {
        List<File> results = new ArrayList<>();
        collectFolders(results, file, deepsearch);
        return results;
    }



    private static List<File> getImages(File file, boolean deepsearch) {
        List<File> results = new ArrayList<File>();
        collectImages(results, file, deepsearch);
        return results;
    }



    private static void collectFolders(List<File> results, File folder, boolean recursive) {
        File[] files = folder.listFiles();
        if (null != files) {
            for (int i = 0; i < files.length; i++) {
                if (files[i].isDirectory()) {
                    results.add(files[i]);
                    if (recursive) {
                        collectFolders(results, files[i], true);
                    }
                }
            }
        }
    }



    private static void collectImages(List<File> results, File folder, boolean recursive) {
        File[] children = folder.listFiles();
        if (null != children) {
            for (int i = 0; i < children.length; i++) {
                if (isImageFile(children[i])) {
                    results.add(children[i]);
                } else if (children[i].isDirectory() && recursive) {
                    collectImages(results, children[i], true);
                }
            }
        } else if (isImageFile(folder)) {
            results.add(folder);
        }
    }



    private static boolean isImageFile(File file) {
        if (file != null && file.isFile()) {
            String name = file.getName().toLowerCase();
            return name.endsWith("png") || name.endsWith("jpg") || name.endsWith("jpeg") || name.endsWith("gif");
        }

        return false;
    }



    private static File moveFileToDir(File file, File dir) {
        File target = new File(dir.getAbsolutePath() + "\\" + file.getName());
        try {
            Files.move(Paths.get(file.getAbsolutePath()), Paths.get(target.getAbsolutePath()), StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            System.out.println(e);
        }
        return target;
    }

}
