package hw_3;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        OpenHashMap<Integer, Double> map = new OpenHashMap<>();
        map.put(10, 20.0);
        map.put(11, 22.2);
        map.put(13, 26.6);
        System.out.println("map.contains(9) = " + map.contains(9));
        System.out.println("map.contains(10) = " + map.contains(10));
        System.out.println("map.get(11) = " + map.get(11));
        System.out.println("map.get(13) = " + map.get(13));
        System.out.println("map.size() = " + map.size());
        map.remove(11);
        System.out.println("map.size() = " + map.size());
        System.out.println("map.contains(11) = " + map.contains(11));
        map.put(11,11.11);
        System.out.println("map.get(11) = " + map.get(11));
    }
}
