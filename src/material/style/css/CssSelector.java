/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package material.style.css;




/**
 *
 * @author DMulders
 */
public class CssSelector {

    private SelectorNode head;
    private SelectorNode tail;



    public CssSelector(String firstSelector) {
        head = tail = new SelectorNode(firstSelector, SelectorType.None);
    }



    @Override
    public String toString() {
        String retval = "";
        SelectorNode pointer = head;
        while (pointer != null) {
            retval += pointer.selector + SelectorType.getCssRepresentation(pointer.type);
            pointer = pointer.next;
        }
        return retval;
    }



    public void addCombination(String selector) {
        tail.type = SelectorType.Combined;
        SelectorNode node = new SelectorNode(selector, SelectorType.None);
        tail.next = node;
        tail = node;
    }



    public void addDescendant(String selector) {
        tail.type = SelectorType.Descendant;
        SelectorNode node = new SelectorNode(selector, SelectorType.None);
        tail.next = node;
        tail = node;
    }



    public void addDirectDescendant(String selector) {
        tail.type = SelectorType.DirectDescendant;
        SelectorNode node = new SelectorNode(selector, SelectorType.None);
        tail.next = node;
        tail = node;
    }



    public void addPseudo(String selector) {
        tail.type = SelectorType.Pseudo;
        SelectorNode node = new SelectorNode(selector, SelectorType.None);
        tail.next = node;
        tail = node;
    }




    public class SelectorNode {

        public String selector;
        public SelectorType type;
        public SelectorNode next;



        public SelectorNode(String selector, SelectorType type) {
            this.selector = selector;
            this.type = type;
        }



        public boolean hasNext() {
            return next != null;
        }

    }




    public enum SelectorType {
        None, Combined, Descendant, DirectDescendant, Pseudo;



        public static String getCssRepresentation(SelectorType type) {
            switch (type) {
                case None:
                    return "";
                case Combined:
                    return "";
                case Descendant:
                    return " ";
                case DirectDescendant:
                    return " > ";
                case Pseudo:
                    return ":";
            }
            return "";
        }
    }

}
