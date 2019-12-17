package serializer;

import serializer.formats.FormatStrategy;

import java.io.Serializable;
import java.util.*;

public class ObjSerializer implements Serializer {

    private final FormatStrategy format;

    public ObjSerializer(FormatStrategy format) {
        this.format = format;
    }

    @Override
    public String serialize(Object o) {
        return format.finalSer(o, serDeclaredFields(o));
    }

    private String serDeclaredFields(Object o) {
        return serMap(MyUtilities.getDeclaredFields(o));
    }

    private String serObj (Object o) {
        if (o == null) {
            return format.serPrimitive(null);
        }
        Class<?> mainClass = o.getClass();
        if (Collection.class.isAssignableFrom(mainClass)) {
            return serCollection((Collection<?>) o);
        } else if (Map.class.isAssignableFrom(mainClass)) {
            return serMap((Map<?, ?>) o);
        } else if (isSimple(mainClass)) {
            return format.serPrimitive(o);
        } else {
            return serDeclaredFields(o);
        }
    }

    private String serMap(Map<?, ?> map) {
        Map<String, String> serElems = new HashMap<>();
        map.forEach((k, v) -> serElems.put(k.toString(), serObj(v)));
        return format.serMap(serElems);
    }

    private String serCollection(Collection<?> collection) {
        List<String> serElems = new ArrayList<>();
        collection.forEach(v -> serElems.add(serObj(v)));
        return format.serList(serElems);
    }

    private boolean isSimple(Class<?> type) {
        return type.isPrimitive() || Serializable.class.isAssignableFrom(type);
    }
}
