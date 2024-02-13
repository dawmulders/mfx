/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apps.explorer.navigator;
import apps.explorer.models.FileType;
import apps.explorer.models.SystemFile;
import java.util.Iterator;
import javafx.scene.control.TreeItem;




/**
 *
 * @author DMulders
 */
public class FileTreeItem extends TreeItem<SystemFile> {

    private boolean isLeaf = false;
    private boolean isLoaded = false;



    /**
     *
     * @param sysfile
     */
    public FileTreeItem(SystemFile sysfile) {
        super(sysfile);
        if (sysfile.fileType == FileType.DATAFILE) {
            isLoaded = true;
            isLeaf = true;
        }
    }



    public boolean isItemLoaded() {
        return isLoaded;
    }



    public boolean isLeafItem() {
        return isLeaf;
    }



    @Override
    public boolean isLeaf() {
        if (!isLeaf && !isLoaded) {
            isLoaded = true;
            FileTreeView.buildItem(this);

        }
        return isLeaf;
    }



    public boolean contains(SystemFile sysfile) {
        return find(sysfile) != null;
    }



    public FileTreeItem find(SystemFile sysfile) {
        FileTreeItem match = null;
        Iterator<TreeItem<SystemFile>> i = super.getChildren().iterator();
        while (i.hasNext()) {
            TreeItem<SystemFile> item = i.next();
            if (item.getValue().equals(sysfile)) {
                match = (FileTreeItem) item;
                break;
            }
        }
        return match;
    }

}
