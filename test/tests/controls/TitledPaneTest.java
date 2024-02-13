/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.controls;
import java.util.Iterator;
import java.util.List;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import material.application.buttons.ActionButton;
import material.design.common.Fonts;
import material.design.common.Icons;
import material.design.common.Nodes;
import material.design.common.Strings;




/**
 *
 * @author DMulders
 */
public class TitledPaneTest extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private boolean isLoaded = false;



    @Override
    public void start(Stage stage) throws Exception {
        FlowPane buttonPane = new FlowPane();
        ActionButton btn1 = new ActionButton(Icons.getExpandCircle(Icons.IconStyle.NONE));
        buttonPane.getChildren().add(btn1);

        VBox root = new VBox();
        root.getChildren().add(buttonPane);
        TitledPane pane1 = new TitledPane();
        TextArea lblContent = new TextArea("Content");
        lblContent.setWrapText(true);
        lblContent.setMinHeight(300);
        lblContent.setFont(Fonts.robotoMedium(16));
        pane1.setContent(lblContent);
        pane1.setText("Pane 1");
        pane1.setExpanded(false);
        pane1.expandedProperty().addListener((o, v1, v2) -> {
            if (!isLoaded) {
                if (v2) {
                    Iterator<Node> i = pane1.getChildrenUnmodifiable().iterator();
                    lblContent.setText("Titled Pane 1");
                    while (i.hasNext()) {
                        System.out.println("next");
                        Node node = i.next();
                        examineNode(node, 1, lblContent);
                    }

                }
            }
        });

        btn1.setOnAction((event) -> {
            hideArrow(pane1);
        });
        root.getChildren().add(pane1);
        Scene scene = new Scene(root, 700, 500);
        stage.setScene(scene);
        stage.show();

    }



    public void hideArrow(TitledPane pane) {
        List<Node> arrows = Nodes.findByStyleClass(pane, "arrow-button");
        if (!arrows.isEmpty()) {
            arrows.get(0).setVisible(false);
        }
    }



    public void examineNode(Node node, int index, TextArea out) {
        if (node != null) {
            String line = node.getClass().getSimpleName() + ", " + Strings.join(node.getStyleClass(), " ");
            List<Node> children = null;
            if (node instanceof Parent) {
                Parent parent = (Parent) node;
                line = parent.getClass().getName() + ", " + Strings.join(node.getStyleClass(), " ");
                children = parent.getChildrenUnmodifiable();
            }
            out.appendText("\n" + Strings.indent(line, index));
            if (children != null) {
                Iterator<Node> i = children.iterator();
                while (i.hasNext()) {
                    examineNode(i.next(), index + 1, out);
                }
            }
        }
    }

}
