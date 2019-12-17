package hw_4;

import hw_3.OpenHashMap;

import java.util.HashMap;
import java.util.Map;

public class CountMapIml<Key> implements CountMap {
    private OpenHashMap<Key, Integer> map;

    public CountMapIml() {
        this.map = new OpenHashMap<>();
    }

    // добавляет элемент в этот контейнер.
    public void add(Object o){
        if (map.contains((Key) o)){
            map.put((Key) o, map.get((Key) o) + 1);
        }else{
            map.put((Key) o, 1);
        }
    }

    //Возвращает количество добавлений данного элемента
    public int getCount(Object o){
        return map.get((Key) o);
    }

    //Удаляет элемент из контейнера и возвращает количество его добавлений(до удаления)
    public int remove(Object o){
        int count = map.get((Key) o);
        map.remove((Key) o);
        return count;
    }

    //количество разных элементов
    public int size(){
        return map.size();
    }

    //Добавить все элементы из source в текущий контейнер, при совпадении ключей, суммировать значения
    public void addAll(CountMap source){
        Map<Key, Integer> tmp = source.toMap();
        for (Key key: tmp.keySet()){
            if (map.contains(key)){
                map.put(key, map.get(key) + tmp.get(key));
            }else{
                map.put(key, tmp.get(key));
            }
        }
    }

    //Вернуть java.util.Map. ключ - добавленный элемент, значение - количество его добавлений
    public Map toMap(){
        Map<Key, Integer> jMap = new HashMap<>();
        for (Key key: map.getKeys()){
            jMap.put(key, map.get(key));
        }
        return jMap;
    }

    //Тот же самый контракт как и toMap(), только всю информацию записать в destination
    public void toMap(Map destination){
        destination = this.toMap();
    }
}
