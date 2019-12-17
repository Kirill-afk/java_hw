package serializer.formats;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static serializer.MyUtilities.*;

public class FtXML implements FormatStrategy {
    private final int indent;

    public FtXML(int indent) {
        this.indent = indent;
    }

    @Override
    public String serMap(Map<String, String> keyToElement) {
        ArrayList<String> mapElements = new ArrayList<>();
        keyToElement.forEach((k, v) -> mapElements.add(serKeyValue(k, v)));
        return String.join("\n", mapElements);
    }

    @Override
    public String serList(List<String> elements) {
        return elements.stream()
                .map(e -> serKeyValue("element", e))
                .collect(Collectors.joining("\n"));
    }

    @Override
    public String serPrimitive(Object obj) {
        return obj != null ? obj.toString() : "";
    }

    @Override
    public String finalSer(Object obj, String body) {
        return serKeyValue(obj.getClass().getName(), body);
    }

    private String serKeyValue(String k, String v) {
        String body;
        if (v.contains("<")) {
            body = "\n" + moveBlock(v, this.indent) + "\n";
        } else {
            body = v;
        }
        return getStartTag(k) + body + getEndTag(k);
    }

    private String getStartTag(Object key) {
        return "<" + key.toString() + ">";
    }

    private String getEndTag(Object key) {
        return "</" + key.toString() + ">";
    }
}