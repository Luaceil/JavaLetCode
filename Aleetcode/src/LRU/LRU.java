package LRU;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedHashMap;

import static java.lang.Integer.valueOf;

public class LRU  extends LinkedHashMap<Integer,Integer> {
    private int capacity;


    public LRU(int capacity) {
        super(capacity,0.75f,true);
        this.capacity = capacity;
    }
    @Override
    protected boolean removeEldestEntry(java.util.Map.Entry<Integer, Integer> eldest) {
        return size()>capacity;
    }
    public int get(int key) {
        if (!super.containsKey(key)) {
            return -1;
        }
        return super.get(key);
    }
    public void put(int key, int value) {
        if (super.containsKey(key)) {
            remove(key);
        }
        super.put(key, value);

    }
    public static void main(String[] args) {
        LRU lru = new LRU(3);
        lru.put(1, 1);
        lru.put(2, 2);
        lru.put(3, 3);
        lru.put(4, 4);
        lru.put(2,2);
        System.out.println(lru.get(1));


    }


}
