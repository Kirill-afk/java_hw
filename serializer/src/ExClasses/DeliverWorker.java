package ExClasses;

import java.util.List;
import java.util.Map;

public class DeliverWorker {

    private final String name;
    private final int degree;
    private final DeliverWorker boss;
    private final List<?> list;
    private final Map<?, ?> map;
    private final List<Leg> legs;


    public DeliverWorker(String name, Integer degree, DeliverWorker colleague, List<?> list, Map<?, ?> map, List<Leg> legs) {
        this.name = name;
        this.degree = degree;
        this.boss = colleague;
        this.list = list;
        this.map = map;
        this.legs = legs;
    }
}