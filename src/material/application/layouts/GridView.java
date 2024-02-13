/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package material.application.layouts;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import material.design.Mfx;




/**
 *
 * @author DMulders
 */
public class GridView extends GridPane {

    public GridView() {
        super();
        super.setBackground(Mfx.getBgSurface());
        setSpacing(32, 24);
        setPadding(32, 48, 48, 48);
    }



    public void addChild(Node node, int col, int row, int colspan, int rowspan, HPos horizontal, VPos vertical) {
        GridPane.setConstraints(node, col, row, colspan, rowspan, horizontal, vertical);
        super.getChildren().add(node);
    }



    public final void setSpacing(double hgap, double vgap) {
        super.setHgap(hgap);
        super.setVgap(vgap);
    }



    public final void setPadding(double top, double right, double bottom, double left) {
        super.setPadding(new Insets(top, right, bottom, left));
    }
}
