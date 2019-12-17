package serializer;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MyUtilities {

    public static String getIndent(int indent) {
        return String.join("", Collections.nCopies(indent, " "));
    }

    public static Map<String, Object> getDeclaredFields (Object o) {
        HashMap<String, Object> hashMap = new HashMap<>();
        Field[] fields = o.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                hashMap.put(field.getName(), field.get(o));
            } catch (IllegalAccessException e) {
                throw new IllegalStateException("Impossible accessibility error");
            }
        }
        return hashMap;
    }

    public static String moveBlockWoutFirstLine(String s, int indent) {
        return String.join("\n" + getIndent(indent), s.split("\n"));
    }
    public static String moveBlock(String s, int indent) {
        return getIndent(indent) + moveBlockWoutFirstLine(s, indent);
    }
}
