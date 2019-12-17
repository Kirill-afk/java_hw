package serializer.formats;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static serializer.MyUtilities.*;

//ser == serialized

public class FtJSON implements FormatStrategy {

    private final int indent;

    public FtJSON(int indent) {
        this.indent = indent;
    }

    @Override
    public String serMap(Map<String, String> keyVal) {
        ArrayList<String> mapVal = new ArrayList<>();
        keyVal.forEach((k, v) -> mapVal.add(moveBlock(moveKV(k, v), this.indent)));
        return "{\n" + String.join(",\n", mapVal) + "\n}";
    }

    @Override
    public String serList(List<String> elems) {
        String separator;
        if (checkSimplicity(elems)) separator = ", ";
        else separator = ",\n";
        List<String> movedElems = elems.stream()
                .map(el -> moveBlockWoutFirstLine(el, 1))
                .collect(Collectors.toList());
        return "[" +
                String.join(separator, movedElems) +
                "]";
    }

    @Override
    public String serPrimitive(Object value) {
        return getPrimitive(value);
    }

    @Override
    public String finalSer(Object o, String meaningPart) {
        return meaningPart;
    }

    private boolean checkSimplicity(List<String> elems) {
        return elems.stream().noneMatch(s -> s.contains("\n"));
    }

    private String moveKV(String key, String value) {
        String jsonKey = "\"" + key + "\": ";
        return jsonKey + moveBlockWoutFirstLine(value, jsonKey.length());
    }

    private String getPrimitive(Object o) {
        if (o == null) {
            return "null";
        } else {
            String serObj = o.toString();
            if (o instanceof Boolean || o instanceof Number) {
                return serObj;
            } else {
                return "\"" + serObj + "\"";
            }
        }
    }
}
