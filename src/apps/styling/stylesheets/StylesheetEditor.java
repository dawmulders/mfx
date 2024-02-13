/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apps.styling.stylesheets;
import java.util.Iterator;
import java.util.List;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.web.HTMLEditor;
import material.design.common.Strings;




/**
 *
 * @author DMulders
 */
public class StylesheetEditor extends StackPane {

    private final CssEditor editor = new CssEditor();



    public StylesheetEditor() {
        super();
        init();
    }



    public void loadTemplateText(String text) {
        editor.loadCss(text);
    }



    public void examineNode(Node node, int index) {
        if (node != null) {
            String line = node.getClass().getSimpleName() + ", " + Strings.join(node.getStyleClass(), " ") + ", " + node.getTypeSelector();
            List<Node> children = null;
            if (node instanceof Parent) {
                Parent parent = (Parent) node;
                line = parent.getClass().getSimpleName() + ", " + Strings.join(node.getStyleClass(), " ") + ", " + node.getTypeSelector();
                children = parent.getChildrenUnmodifiable();
            }
            System.out.println(Strings.indent(line, index));
            if (children != null) {
                Iterator<Node> i = children.iterator();
                while (i.hasNext()) {
                    examineNode(i.next(), index + 1);
                }
            }
        }
    }



    private void init() {
        StackPane.setAlignment(editor, Pos.CENTER);
        super.getChildren().add(editor);
    }




    /**
     *
     */
    public class CssEditor extends HTMLEditor {

        public CssEditor() {
            super();
            super.addEventFilter(KeyEvent.KEY_PRESSED, (event) -> {
                if(event.getCode() == KeyCode.U && event.isControlDown()){
                    System.out.println(super.getHtmlText());
                }
            });
        }



        public void loadCss(String raw) {
            String htmlText = "<p><font face=\"Consolas\">";
            String[] chars = raw.split("(?!^)");
            System.out.println(chars.length);

            for (int i = 0; i < chars.length; i++) {
                String letter = chars[i];
                if (letter.equalsIgnoreCase("{")) {
                    htmlText += letter + "<br />&nbsp;&nbsp;&nbsp;&nbsp; ";
                }else  if (letter.equalsIgnoreCase("}")) {
                    htmlText += "<br />" + letter + "</font></p>" + "<p><font face=\"Consolas\">";
                }else if(letter.equalsIgnoreCase(";")){
                    htmlText += letter + "<br />&nbsp;&nbsp;&nbsp;&nbsp;";
                }else{
                    htmlText += letter;
                }
            }
            super.setHtmlText(htmlText);
        }

    }

}
