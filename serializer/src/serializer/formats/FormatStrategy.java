package serializer.formats;

import java.util.List;
import java.util.Map;

public interface FormatStrategy {
    String serMap(Map<String, String> keyVal);
    String serList(List<String> elems);
    String serPrimitive(Object o);
    String finalSer(Object o, String MeaningPart);
}
