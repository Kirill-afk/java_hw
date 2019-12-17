
import ExClasses.*;
import serializer.ObjSerializer;
import serializer.Serializer;
import serializer.formats.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        DeliverWorker deliverWorker = createComplexDoctorObject();

        Serializer jsonRecursiveSerializer = new ObjSerializer(new FtJSON(1));
        System.out.println(jsonRecursiveSerializer.serialize(deliverWorker));

        Serializer xmlRecursiveSerializer = new ObjSerializer(new FtXML(4));
        System.out.println(xmlRecursiveSerializer.serialize(deliverWorker));
    }

    private static DeliverWorker createComplexDoctorObject() {

        Map<String, String> mw = new HashMap<>();

        List<Leg> legs = Arrays.asList(new Leg("left"), new Leg("right"));
        DeliverWorker deliverWorker3 = new DeliverWorker("Richard", 3, null, null, null, legs);
        Map<DeliverWorker, DeliverWorker> delClub = new HashMap<>();
        delClub.put(deliverWorker3, deliverWorker3);
        DeliverWorker deliverWorker2 = new DeliverWorker("John", 2, null, Arrays.asList("1", "2", "3"), delClub, legs);
        return new DeliverWorker("Alex", 4, deliverWorker2, Arrays.asList(1, 2, 3), null, legs);
    }
}