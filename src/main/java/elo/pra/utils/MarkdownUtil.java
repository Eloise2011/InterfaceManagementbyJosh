package elo.pra.utils;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.commonmark.Extension;
import org.commonmark.ext.gfm.tables.TableBlock;
import org.commonmark.ext.gfm.tables.TablesExtension;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.AttributeProvider;
import org.commonmark.renderer.html.HtmlRenderer;

/**
 * @author Joshua.H.Brooks
 * @description
 * @date 2024-05-15 23:45
 */
public class MarkdownUtil {

    private final static Parser parser;
    private final static HtmlRenderer renderer;

    static {
        Extension tablesExtension = TablesExtension.create();
        List<Extension> extensions = Arrays.asList(tablesExtension); // 支持表格扩展
        parser = Parser.builder().extensions(extensions).build();
        renderer = HtmlRenderer.builder().attributeProviderFactory(context -> new HtmlAttributeProvider())
                .extensions(extensions).build();
    }

    public static String render(String text) {
        Node document = parser.parse(text);
        return renderer.render(document);
    }

    /**
     * 给markdown的表格加上样式
     *
     * @author EX_HUANGSL1
     *
     */
    static class HtmlAttributeProvider implements AttributeProvider {

        @Override
        public void setAttributes(Node node, String tagName, Map<String, String> attributes) {
            if (node instanceof TableBlock) { // 判断是否是Table表格，是的话，加上css类样式 table table-bordered
                attributes.put("class", "table table-bordered");
            }
        }

    }

}