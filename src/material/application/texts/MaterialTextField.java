/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package material.application.texts;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.ParallelTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import material.design.Mfx;
import material.design.common.Bgs;
import material.design.common.Borders;
import material.design.common.Fonts;
import material.design.common.Icons;




/**
 *
 * @author DMulders
 */
public class MaterialTextField extends GridPane {

    private final TextField textField;
    private final MaterialTextFieldLabel label;
    private final MaterialTextFieldHelper helper;
    private final MaterialTextFieldButton button;

    private Background bgIdle;
    private Background bgHover;
    private Background bgFocus;

    private Border borderIdle;
    private Border borderHover;
    private Border borderFocus;



    /**
     * Constructor
     *
     * @param labelText
     */
    public MaterialTextField(String labelText) {
        super();
        textField = new TextField();
        label = new MaterialTextFieldLabel(labelText);
        helper = new MaterialTextFieldHelper();
        button = new MaterialTextFieldButton();
        init();
    }



    public MaterialTextField(String labelText, String helperText) {
        super();
        textField = new TextField();
        label = new MaterialTextFieldLabel(labelText);
        helper = new MaterialTextFieldHelper(helperText);
        button = new MaterialTextFieldButton();
        init();
    }



    public void setLabelText(String labelText) {
        label.setText(labelText);
    }



    public String getLabelText() {
        return label.getText();
    }



    public void setHelperText(String helperText) {
        helper.setText(helperText);
    }



    public String getHelperText() {
        return helper.getText();
    }



    public void clearInput() {
        textField.setText("");
    }



    private void init() {
        bgIdle = Bgs.bgTextFieldIdle();
        borderIdle = Borders.textFieldIdle();
        bgHover = Bgs.bgTextFieldHover();
        borderHover = Borders.textFieldHover();
        bgFocus = Bgs.bgTextFieldFocus();
        borderFocus = Borders.textFieldFocus();

        GridPane.setConstraints(textField, 0, 0, 1, 1, HPos.LEFT, VPos.CENTER, Priority.ALWAYS, Priority.NEVER);
        super.getChildren().add(textField);
        GridPane.setConstraints(label, 0, 0, 1, 1, HPos.LEFT, VPos.CENTER, Priority.NEVER, Priority.NEVER, new Insets(0, 0, 0, 9));
        super.getChildren().add(label);
        GridPane.setConstraints(helper, 0, 1, 1, 1, HPos.LEFT, VPos.CENTER, Priority.NEVER, Priority.NEVER, new Insets(0, 0, 0, 9));
        super.getChildren().add(helper);
        GridPane.setConstraints(button, 0, 0, 1, 1, HPos.RIGHT, VPos.CENTER, Priority.NEVER, Priority.NEVER, new Insets(0, 9, 0, 0));
        super.getChildren().add(button);
        textField.setMinHeight(48);
        textField.setMinWidth(280);
        textField.setMaxHeight(48);
        textField.setPrefHeight(48);
        textField.setAlignment(Pos.BASELINE_LEFT);

        textField.setBackground(bgIdle);
        textField.setBorder(borderIdle);
        textField.setFont(Mfx.getBody2());
        textField.hoverProperty().addListener((o, v1, v2) -> {
            if (!textField.isFocused()) {
                if (v2 == true) {
                    textField.setBackground(bgHover);
                    textField.setBorder(borderHover);
                } else {
                    textField.setBackground(bgIdle);
                    textField.setBorder(borderIdle);
                }
            }
        });
        textField.focusedProperty().addListener((o, v1, v2) -> {
            if (v2 == true) {
                label.onFocusOn();
                textField.setBackground(bgFocus);
                textField.setBorder(borderFocus);
            } else {
                label.onFocusOff();
                button.updateVisibility();
                textField.setBackground(bgIdle);
                textField.setBorder(borderIdle);
            }
        });
    }




    /**
     * Label
     */
    public class MaterialTextFieldLabel extends Label {

        private final double labelScale = 0.8;
        private final TranslateTransition focusOnTrans = new TranslateTransition();
        private final TranslateTransition focusOffTrans = new TranslateTransition();
        private final ScaleTransition scaleOnTrans = new ScaleTransition();
        private final ScaleTransition scaleOffTrans = new ScaleTransition();
        private Timeline tlOn;
        private Timeline tlOff;
        private ParallelTransition paraTransOn;
        private ParallelTransition paraTransOff;
        private Color fillIdle;
        private Color fillFocus;

        private double scaledDeltaX = -1;



        public MaterialTextFieldLabel(String text) {
            super(text);
            fillIdle = Mfx.ON_IDLE_GRAY;
            fillFocus = (Color) Mfx.getP1();
            super.setFont(Mfx.getBody2());
            super.setTextFill(Mfx.ON_IDLE_GRAY);
            init();
        }



        public void recalcDeltaX() {
            double wL = super.getWidth();
            if (wL > 0) {
                double wS = labelScale * wL;
                double deltaW = wL - wS;
                double deltaX = deltaW / 2;
                focusOnTrans.setToX(-1 * deltaX);
                focusOffTrans.setToX(0);
                scaledDeltaX = deltaX;
            }
        }



        protected void onFocusOn() {
            if (textField.getText() != null && textField.getText().length() > 0) {
                super.setTextFill(fillFocus);
            } else {
                if (scaledDeltaX < 0) {
                    recalcDeltaX();
                }
                paraTransOn.play();
            }
        }



        protected void onFocusOff() {
            if (textField.getText() != null && textField.getText().length() > 0) {
                super.setTextFill(fillIdle);
            } else {
                paraTransOff.play();
            }
        }



        private void init() {
            scaleOnTrans.setNode(this);
            scaleOnTrans.setToX(0.8);
            scaleOnTrans.setToY(0.8);
            scaleOnTrans.setDuration(Duration.millis(200));

            scaleOffTrans.setNode(this);
            scaleOffTrans.setToX(1.0);
            scaleOffTrans.setToY(1.0);
            scaleOffTrans.setDuration(Duration.millis(200));

            focusOnTrans.setNode(this);
            focusOnTrans.setByY(-11);
            focusOnTrans.setByX(0);
            focusOnTrans.setDuration(Duration.millis(200));

            focusOffTrans.setNode(this);
            focusOffTrans.setToY(0);
            focusOffTrans.setToX(0);
            focusOffTrans.setDuration(Duration.millis(200));

            tlOff = new Timeline(
                    new KeyFrame(Duration.millis(200), new KeyValue(super.textFillProperty(), fillIdle)),
                    new KeyFrame(Duration.millis(200), new KeyValue(super.textFillProperty(), fillFocus))
            );
            tlOn = new Timeline(
                    new KeyFrame(Duration.millis(200), new KeyValue(super.textFillProperty(), fillFocus)),
                    new KeyFrame(Duration.millis(200), new KeyValue(super.textFillProperty(), fillIdle))
            );

            paraTransOn = new ParallelTransition(scaleOnTrans, focusOnTrans, tlOn);
            paraTransOff = new ParallelTransition(scaleOffTrans, focusOffTrans, tlOff);
            super.textProperty().addListener((o, v1, v2) -> {
                recalcDeltaX();
            });
        }

    }




    /**
     * Clear button
     */
    public class MaterialTextFieldButton extends Button {

        private final Image iconIdle;
        private final Image iconHover;
        private final ImageView imageView;



        public MaterialTextFieldButton() {
            super();
            iconHover = Icons.getCloseCircle(Icons.IconStyle.NONE);
            iconIdle = Icons.getColoredIcon(iconHover, Mfx.ON_IDLE_GRAY, null);
            imageView = new ImageView();
            init();
        }



        private void updateVisibility() {
            if (textField.getText() != null && textField.getText().length() > 0) {
                if (!super.isVisible()) {
                    super.setVisible(true);
                }
            } else {
                if (super.isVisible()) {
                    super.setVisible(false);
                }
            }
        }



        private void init() {
            super.setBackground(Background.EMPTY);
            super.setBorder(Border.EMPTY);
            super.setText("");
            super.setGraphic(imageView);
            super.setAlignment(Pos.CENTER);
            super.setVisible(false);
            super.setFocusTraversable(false);
            imageView.setFitWidth(18);
            imageView.setFitHeight(18);
            imageView.setSmooth(true);
            imageView.setImage(iconIdle);

            textField.textProperty().addListener((o, v1, v2) -> {
                updateVisibility();
            });

            super.hoverProperty().addListener((o, v1, v2) -> {
                if (v2) {
                    imageView.setImage(iconHover);
                } else {
                    imageView.setImage(iconIdle);
                }
            });
            super.setOnAction((ae) -> {
                clearInput();
            });

        }
    }




    /**
     * Helper text field, displayed below the text field
     */
    public class MaterialTextFieldHelper extends Label {

        public MaterialTextFieldHelper() {
            super();
            init();
        }



        public MaterialTextFieldHelper(String text) {
            super(text);
            init();
        }



        private void init() {
            super.setFont(Fonts.robotoMedium(10));
            super.setTextFill(Mfx.ON_IDLE_GRAY);
            super.setAlignment(Pos.TOP_LEFT);
        }

    }

}
