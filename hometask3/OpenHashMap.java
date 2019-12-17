package hw_3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class OpenHashMap<Key, Value> {
    private final int INITIAL_CAPASITY = 16;
    private final float DEFAULT_LOAD_FACTOR = 0.75f;

    private int size;
    private int capacity;
    private final float loadFactor;
    private Object[] keys;
    private Object[] values;
    private boolean[] exist;

    public OpenHashMap() {
        this.size = 0;
        this.capacity = INITIAL_CAPASITY;
        this.loadFactor = DEFAULT_LOAD_FACTOR;
        this.keys = new Object[this.capacity];
        this.values = new Object[this.capacity];
        this.exist = new boolean[this.capacity];
        Arrays.fill(exist, false);
    }

    private void resize(int newCapacity){
        Object[] new_keys = new Object[newCapacity];
        Object[] new_values = new Object[newCapacity];
        boolean[] new_exist = new boolean[newCapacity];
        Arrays.fill(new_exist, false);
        for (int i = 0; i < capacity; ++i){
            if (exist[i]){
                for (int j = (Math.abs(keys[i].hashCode()) % newCapacity); ;++j){
                    if (j == newCapacity){
                        j = 0;
                    }
                    if (!new_exist[j]){
                        new_keys[j] = keys[i];
                        new_values[j] = values[i];
                        new_exist[j] = true;
                        break;
                    }
                }
            }
        }
        keys = new_keys;
        values = new_values;
        exist = new_exist;
        capacity = newCapacity;
    }

    public void put(Key key, Value value) throws IllegalArgumentException{
        if (key == null){
            throw new IllegalArgumentException("Key can't be null");
        }
        if (value == null){
            throw new IllegalArgumentException("Value can't be null");
        }
        for (int i = (Math.abs(key.hashCode()) % capacity); ; ++i){
            if (i == capacity){
                i = 0;
            }
            if (!exist[i]){
                keys[i] = key;
            }
            if (keys[i] == key){
                if (!exist[i]){
                    size++;
                    exist[i] = true;
                }
                values[i] = value;
                break;
            }
        }
        if (size >= capacity * loadFactor) {
            this.resize(capacity * 2 + 1);
        }
    }

    public Value get(Key key) throws RuntimeException {
        if (key == null){
            throw new IllegalArgumentException("Key can't be null");
        }
        if (contains(key)) {
            for (int i = (Math.abs(key.hashCode()) % capacity); ; ++i) {
                if (i == capacity) {
                    i = 0;
                }
                if (key == keys[i]) {
                    if (exist[i]){
                        return (Value) values[i];
                    }
                }
            }
        }else{
            throw new RuntimeException("Key isn't existed");
        }
    }

    public void remove(Key key) throws RuntimeException {
        if (key == null){
            throw new IllegalArgumentException("Key can't be null");
        }
        if (contains(key)) {
            for (int i = (Math.abs(key.hashCode()) % capacity); ; ++i) {
                if (i == capacity) {
                    i = 0;
                }
                if (key == keys[i]) {
                    if (exist[i]) {
                        exist[i] = false;
                        size--;
                        return;
                    }
                }
            }
        }else{
            throw new RuntimeException("Key isn't existed");
        }
    }

    public boolean contains(Key key) {
        if (key == null){
            throw new IllegalArgumentException("Key can't be null");
        }
        int step = 0;
        for (int i = (Math.abs(key.hashCode()) % capacity); ; ++i) {
            if (i == capacity) {
                i = 0;
            }
            if (key == keys[i]) {
                if (exist[i]){
                    return true;
                }
            }
            if (step == capacity){
                return false;
            }
            step++;
        }
    }

    public int size() {
        return size;
    }

    public Set<Key> getKeys(){
        Set<Key> keySet = new HashSet<>();
        for (int i = 0; i < capacity; ++i){
            if (exist[i]){
                keySet.add((Key)keys[i]);
            }
        }
        return keySet;
    }
}
