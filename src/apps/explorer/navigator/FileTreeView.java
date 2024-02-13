/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apps.explorer.navigator;
import apps.explorer.models.DataFile;
import apps.explorer.models.Directory;
import apps.explorer.models.FileType;
import apps.explorer.models.RootFile;
import apps.explorer.models.SystemFile;
import java.util.List;
import javafx.geometry.Pos;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import material.design.Mfx;
import material.design.common.Bgs;
import material.design.common.Icons;




/**
 *
 * @author DMulders
 */
public class FileTreeView extends TreeView<SystemFile> {

    private final RootFile rootFile;



    public FileTreeView(RootFile rootFile) {
        super();
        this.rootFile = rootFile;
        init();
    }



    private void init() {
        super.setCellFactory((param) -> {
            return new FileTreeCell();
        });
        super.setEditable(false);
        super.setMaxHeight(Double.MAX_VALUE);
        super.getSelectionModel().selectedItemProperty().addListener((o, v1, v2) -> {
            if (v2 != null) {
                if (v2 instanceof FileTreeItem) {
                    FileTreeItem fti = (FileTreeItem) v2;
                    if (!fti.isItemLoaded()) {
                        buildItem(fti);
                    }
                    
                }
            }
        });
        FileTreeItem root = new FileTreeItem(rootFile);
        buildItem(root);
        super.setRoot(root);
        super.setShowRoot(false);
    }



    public static TreeItem<SystemFile> buildNode(SystemFile sysfile) {
        FileTreeItem fti = new FileTreeItem(sysfile);
        if (sysfile.fileType == FileType.DIRECTORY) {
            Directory dir = (Directory) sysfile;
            Directory[] childDirs = dir.getDirs();
            if (childDirs != null) {
                for (int i = 0; i < childDirs.length; i++) {
                    FileTreeItem childItem = new FileTreeItem(childDirs[i]);
                    fti.getChildren().add(childItem);
                }
            }
            DataFile[] datas = dir.getDataFiles();
            if (datas != null) {
                for (int i = 0; i < datas.length; i++) {
                    FileTreeItem childItem = new FileTreeItem(datas[i]);
                    fti.getChildren().add(childItem);
                }
            }
        }
        return fti;
    }



    public static void buildItem(FileTreeItem item) {
        SystemFile sysfile = item.getValue();
        if (sysfile.fileType == FileType.DIRECTORY) {
            Directory root = (Directory) sysfile;
            Directory[] childDirs = root.getDirs();
            DataFile[] childFiles = root.getDataFiles();

            if (null != childDirs) {
                for (int i = 0; i < childDirs.length; i++) {
                    if (!item.contains(childDirs[i])) {
                        item.getChildren().add(buildNode(childDirs[i]));
                    }
                }
            }
            if (null != childFiles) {
                for (int i = 0; i < childFiles.length; i++) {
                    if (!item.contains(childFiles[i])) {
                        item.getChildren().add(buildNode(childFiles[i]));
                    }
                }
            }
        } else if (sysfile.fileType == FileType.ROOTFILE) {
            RootFile rootFile = (RootFile) sysfile;
            List<Directory> childDirs = rootFile.createDirectoryList();
            for (int i = 0; i < childDirs.size(); i++) {
                if (!item.contains(childDirs.get(i))) {
                    item.getChildren().add(buildNode(childDirs.get(i)));
                }
            }
        }
    }




    public class FileTreeCell extends TreeCell<SystemFile> {

        private final ImageView iv = new ImageView();



        public FileTreeCell() {
            super();
            super.setTextFill(Mfx.TEXT_GRAY);
            super.setFont(Mfx.getBody2());
            super.setGraphicTextGap(24);
            super.setAlignment(Pos.BASELINE_LEFT);
            iv.setFitWidth(20);
            iv.setFitHeight(20);
            super.setBackground(bgCellIdle);
            super.setBorder(Border.EMPTY);
            super.hoverProperty().addListener((o, v1, v2) -> {
                if (!super.isSelected() && !super.isEmpty()) {
                    if (v2) {
                        super.setBackground(bgCellHover);
                    } else {
                        super.setBackground(bgCellIdle);
                    }
                }
            });
            super.selectedProperty().addListener((o, v1, v2) -> {
                if (v2) {
                    super.setBackground(bgCellSelected);
                    super.setTextFill(Mfx.getP1());
                    TreeItem<SystemFile> item = super.getTreeItem();
                    if (item != null) {
                        if (item.getValue().fileType == FileType.DIRECTORY) {
                            if (item.isExpanded()) {
                                iv.setImage(iconDirectoryOpenSelected);
                            } else {
                                iv.setImage(iconDirectorySelected);
                            }
                        } else {
                            iv.setImage(iconFileSelected);
                        }
                    }
                } else {
                    super.setBackground(bgCellIdle);
                    super.setTextFill(Mfx.TEXT_GRAY);
                    TreeItem<SystemFile> item = super.getTreeItem();
                    if (item != null) {
                        if (item.getValue().fileType == FileType.DIRECTORY) {
                            if (item.isExpanded()) {
                                iv.setImage(iconDirectoryOpen);
                            } else {
                                iv.setImage(iconDirectory);
                            }
                        } else {
                            iv.setImage(iconFile);
                        }
                    }
                }
            });
        }



        @Override
        public void updateItem(SystemFile item, boolean empty) {
            super.updateItem(item, empty);
            if (empty) {
                super.setGraphic(null);
                super.setText("");
            } else {
                super.setGraphic(iv);
                super.setText(item.getName());
                TreeItem<SystemFile> treeItem = super.getTreeItem();
                if (item.fileType == FileType.DIRECTORY) {
                    if (treeItem.isExpanded()) {
                        if (!super.isSelected()) {
                            iv.setImage(iconDirectoryOpen);
                        } else {
                            iv.setImage(iconDirectoryOpenSelected);
                        }
                    } else {
                        if (super.isSelected()) {
                            iv.setImage(iconDirectorySelected);
                        } else {
                            iv.setImage(iconDirectory);
                        }
                    }
                    super.getTreeItem().expandedProperty().addListener((o, v1, v2) -> {
                        if (v2) {
                            if (super.isSelected()) {
                                iv.setImage(iconDirectoryOpenSelected);
                            } else {
                                iv.setImage(iconDirectoryOpen);
                            }
                        } else {
                            if (super.isSelected()) {
                                iv.setImage(iconDirectorySelected);
                            } else {
                                iv.setImage(iconDirectory);
                            }
                        }
                    });
                } else {
                    iv.setImage(iconFile);
                }
            }
        }

    }
    private static final Image iconFile = Icons.getColoredIcon(Icons.getFile(Icons.IconStyle.NONE), Mfx.TEXT_GRAY, null);
    private static final Image iconFileSelected = Icons.getFile(Icons.IconStyle.PRIMARY);
    private static final Image iconDirectory = Icons.getColoredIcon(Icons.getFolder(Icons.IconStyle.NONE), Mfx.TEXT_GRAY, null);
    private static final Image iconDirectorySelected = Icons.getFolder(Icons.IconStyle.PRIMARY);
    private static final Image iconDirectoryOpen = Icons.getColoredIcon(Icons.getFolderOpen(Icons.IconStyle.NONE), Mfx.TEXT_GRAY, null);
    private static final Image iconDirectoryOpenSelected = Icons.getFolderOpen(Icons.IconStyle.PRIMARY);

    private static Background bgCellIdle = Bgs.drawerMenuIdle();
    private static Background bgCellHover = Bgs.drawerMenuHover();
    private static Background bgCellSelected = Bgs.drawerMenuActive();

}
