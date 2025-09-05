package LRU;

import java.util.HashMap;

import java.util.Map;

class LRUCache {
    static class LinkedNode{
        LinkedNode next;
        LinkedNode prev;
        int key;
        int value;
        LinkedNode(int key,int value){
            this.key = key;
            this.value = value;
        }
    }

    private final LinkedNode doummy =new LinkedNode(-1,-1);
    private final int capacity ;
    private final HashMap<Integer, LinkedNode> keyToMap=new HashMap<>();
    //最近最少使用
    //删除map的一个key
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    public int get(int key) {
         if(keyToMap.containsKey(key)){
            LinkedNode node = keyToMap.get(key);
            node.prev.next = node.next;
            node.next.prev = node.prev;
            put(node.key,node.value);
            return node.value;
         }
         return -1;
    }

    public void put(int key, int value) {
        if(keyToMap.size()==capacity){
            remove();
        }
        LinkedNode node = new LinkedNode(key,value);
        keyToMap.put(key,node);
        LinkedNode next = doummy.next;
        doummy.next=node;
        node.prev=doummy;
        node.next=next;
        next.prev=node;
    }
    public void remove() {
        LinkedNode node = doummy.prev;
        keyToMap.remove(node.key);
        node.prev.next =node.next;
        node.next.prev = node.prev;
    }
}

