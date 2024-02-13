/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apps.iconbrowser.gitrepo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;




/**
 *
 * @author DMulders
 */
public class GitLink {

    public static List<GitLink> create(Elements elements) {
        List<GitLink> list = new ArrayList<>();
        Iterator<Element> i = elements.iterator();
        while (i.hasNext()) {
            Element element = i.next();
            if (element.hasAttr("href")) {
                GitLink gitlink = new GitLink(element);
                list.add(gitlink);
            }
        }
        return list;
    }

    private final String href;
    private final String label;



    /**
     *
     * @param href
     * @param label
     */
    public GitLink(String href, String label) {
        this.href = href;
        this.label = label;
    }



    /**
     * For link elements with a href attribute
     *
     * @param element
     */
    public GitLink(Element element) {
        String base_url = element.ownerDocument().location();
        String link_url = element.attr("href");
        if (link_url.startsWith("/")) {
            link_url = base_url + link_url;
        } else if (!link_url.contains(base_url)) {
            link_url = base_url + "/" + link_url;
        }
        this.href = link_url;
        this.label = element.text();
    }



    @Override
    public String toString() {
        return label + " [" + href + "]";
    }

}
