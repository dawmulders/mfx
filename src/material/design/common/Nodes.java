/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package material.design.common;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javafx.scene.Node;
import javafx.scene.Parent;




/**
 *
 * @author DMulders
 */
public class Nodes {

    public static Node findByClassName(Parent parent, String className) {
        List<Node> matches = new ArrayList<>();
        Iterator<Node> i = parent.getChildrenUnmodifiable().iterator();
        while (i.hasNext()) {
            findNodesByClassName(i.next(), className, matches);
        }
        if (matches.isEmpty()) {
            return null;
        }
        return matches.get(0);
    }



    public static List<Node> findByStyleClass(Parent parent, String styleClass) {
        List<Node> matches = new ArrayList<>();
        Iterator<Node> i = parent.getChildrenUnmodifiable().iterator();
        while (i.hasNext()) {
            findNodesByStyleClass(i.next(), styleClass, matches);
        }
        return matches;
    }



    private static void findNodesByClassName(Node node, String className, List<Node> matches) {
        String nodeName = node.getClass().getSimpleName();
        if (null != nodeName && nodeName.length() > 0) {
            if (nodeName.equalsIgnoreCase(className)) {
                matches.add(node);
            }
        }
        if (node instanceof Parent) {
            Parent parent = (Parent) node;
            if (!parent.getChildrenUnmodifiable().isEmpty()) {
                Iterator<Node> i = parent.getChildrenUnmodifiable().iterator();
                while (i.hasNext()) {
                    findNodesByClassName(i.next(), className, matches);
                }
            }
        }
    }



    private static void findNodesByStyleClass(Node node, String styleClass, List<Node> matches) {
        if (node.getStyleClass().contains(styleClass)) {
            matches.add(node);
        }

        if (node instanceof Parent) {
            Parent parent = (Parent) node;
            if (!parent.getChildrenUnmodifiable().isEmpty()) {
                Iterator<Node> i = parent.getChildrenUnmodifiable().iterator();
                while (i.hasNext()) {
                    findNodesByStyleClass(i.next(), styleClass, matches);
                }
            }
        }
    }

}
