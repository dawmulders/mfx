/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package material.application.content;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import material.design.common.Bgs;
import material.design.common.Icons;




/**
 *
 * @author DMulders
 */
public class WindowPane extends BorderPane {

    private final WindowPaneHeader header;
    private Window window;
    private double windowWidth = Double.MAX_VALUE;
    private double windowHeight = Double.MAX_VALUE;
    private boolean isMaximized = false;

    private boolean isOnWindowBorder = false;
    private double mouseDownX = 0;
    private double mouseDownY = 0;


    public WindowPane() {
        super();
        super.setPadding(Insets.EMPTY);
        header = new WindowPaneHeader();
        super.setTop(header);
        initWindowPane();
    }



    private void initWindowPane() {
        super.addEventFilter(MouseEvent.MOUSE_MOVED, (event) -> {
            if (!isMaximized) {

                double x = event.getX();
                double y = event.getY();

                boolean onLeft = false;
                boolean onTop = false;
                boolean onRight = false;
                boolean onBottom = false;

                if (x < 3) {
                    onLeft = true;
                }
                if (x > (windowWidth - 5)) {
                    onRight = true;
                }
                if (y < 3) {
                    onTop = true;
                }
                if (y > (windowHeight - 10)) {
                    onBottom = true;
                }
                if (onLeft || onTop || onRight || onBottom) {
                    if (onLeft) {
                        if (onTop) {
                            super.setCursor(Cursor.NW_RESIZE);
                        } else if (onBottom) {
                            super.setCursor(Cursor.SW_RESIZE);
                        } else {
                            super.setCursor(Cursor.W_RESIZE);
                        }
                    } else if (onRight) {
                        if (onTop) {
                            super.setCursor(Cursor.NE_RESIZE);
                        } else if (onBottom) {
                            super.setCursor(Cursor.SE_RESIZE);
                        } else {
                            super.setCursor(Cursor.E_RESIZE);
                        }
                    } else if (onTop) {
                        super.setCursor(Cursor.N_RESIZE);
                    } else if (onBottom) {
                        super.setCursor(Cursor.S_RESIZE);
                    }
                } else {
                    super.setCursor(Cursor.DEFAULT);
                }
            }

        });

        super.sceneProperty().addListener((o, v1, v2) -> {
            if (v2 != null) {
                System.out.println("Scene detected in Window Pane!");
                v2.windowProperty().addListener((observable, oldValue, newValue) -> {
                    System.out.println("Window detected in Scene");
                    this.window = newValue;
                    this.windowWidth = window.getWidth();
                    this.windowHeight = window.getHeight();
                    initStageListener();
                });
            }
        });
    }



    private void initStageListener() {
        Stage stage = (Stage) window;
        stage.maximizedProperty().addListener((o, v1, v2) -> {
            if (v2) {
                isMaximized = true;
            } else {
                isMaximized = false;
                windowWidth = stage.getWidth();
                windowHeight = stage.getHeight();
            }
        });
        stage.widthProperty().addListener((o, v1, v2) -> {
            windowWidth = (double) v2;
        });
        stage.heightProperty().addListener((o, v1, v2) -> {
            windowHeight = (double) v2;
        });
    }




    public class WindowPaneHeader extends AnchorPane {

        private final WindowPaneButton btnMin, btnScale, btnClose;
        private final Image iconScaleUp, iconScaleDown;



        public WindowPaneHeader() {
            super();
            super.setBackground(Bgs.windowPaneHeader());
            iconScaleUp = Icons.getMaximizeWindow(Icons.IconStyle.LIGHT);
            iconScaleDown = Icons.getScaleWindow(Icons.IconStyle.LIGHT);
            btnMin = new WindowPaneButton(Icons.getMinimizeWindow(Icons.IconStyle.LIGHT), Bgs.windowButtonIdle(), Bgs.windowButtonHover(), Border.EMPTY, Border.EMPTY);
            btnScale = new WindowPaneButton(iconScaleUp, Bgs.windowButtonIdle(), Bgs.windowButtonHover(), Border.EMPTY, Border.EMPTY);
            btnClose = new WindowPaneButton(Icons.getCloseWindow(Icons.IconStyle.LIGHT), Bgs.windowButtonCloseIdle(), Bgs.windowButtonCloseHover(), Border.EMPTY, Border.EMPTY);
            AnchorPane.setTopAnchor(btnClose, 0.0);
            AnchorPane.setBottomAnchor(btnClose, 0.0);
            AnchorPane.setRightAnchor(btnClose, 0.0);

            AnchorPane.setTopAnchor(btnScale, 0.0);
            AnchorPane.setBottomAnchor(btnScale, 0.0);
            AnchorPane.setRightAnchor(btnScale, WindowPaneButton.button_w);

            AnchorPane.setTopAnchor(btnMin, 0.0);
            AnchorPane.setBottomAnchor(btnMin, 0.0);
            AnchorPane.setRightAnchor(btnMin, WindowPaneButton.button_w * 2);
            super.getChildren().addAll(btnClose, btnScale, btnMin);
            btnClose.setOnAction((ae) -> {
                closeWindow();
            });
            btnScale.setOnAction((ae) -> {
                scaleWindow();
            });
            btnMin.setOnAction((ae) -> {
                minimizeWindow();
            });

        }



        private void closeWindow() {
            if (super.getScene().getWindow() instanceof Stage) {
                Stage stage = (Stage) super.getScene().getWindow();
                stage.close();
            }
            System.exit(0);
        }



        private void scaleWindow() {
            if (super.getScene().getWindow() instanceof Stage) {
                Stage stage = (Stage) super.getScene().getWindow();
                if (stage.isMaximized()) {
                    stage.setMaximized(false);
                    btnScale.setIcon(iconScaleUp);
                } else {
                    stage.setMaximized(true);
                    btnScale.setIcon(iconScaleDown);
                }
            }
        }



        private void minimizeWindow() {
            if (super.getScene().getWindow() instanceof Stage) {
                Stage stage = (Stage) super.getScene().getWindow();
                stage.setIconified(true);
            }

        }

    }




    public class WindowPaneButton extends Button {

        private static final double button_w = 32;
        private static final double button_h = 20;
        private static final double icon_size = 24;

        private final ImageView iv = new ImageView();
        private final Background bgIdle, bgHover;
        private final Border bIdle, bHover;



        public WindowPaneButton(Image icon, Background bgIdle, Background bgHover, Border bIdle, Border bHover) {
            super();
            iv.setImage(icon);
            iv.setFitHeight(18);
            iv.setFitWidth(18);
            this.bgIdle = bgIdle;
            this.bgHover = bgHover;
            this.bIdle = bIdle;
            this.bHover = bHover;
            super.setBorder(bIdle);
            super.setBackground(bgIdle);
            super.setMinSize(button_w, button_h);
            super.setPrefSize(button_w, button_h);
            super.setMaxSize(button_w, button_h);
            super.setAlignment(Pos.CENTER);
            super.setFocusTraversable(false);
            super.setGraphic(iv);
            init();
        }



        private void init() {
            super.hoverProperty().addListener((o, v1, v2) -> {
                if (v2) {
                    super.setBackground(bgHover);
                    super.setBorder(bHover);
                } else {
                    super.setBackground(bgIdle);
                    super.setBorder(bIdle);
                }
            });

        }



        public void setIcon(Image icon) {
            iv.setImage(icon);
        }

    }

}
