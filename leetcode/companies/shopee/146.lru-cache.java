package leetcode.companies.shopee;


import java.util.HashMap;

class Node{
    int key, val;
    Node prev, next;

    Node(int key, int val){
        this.key = key;
        this.val = val;
    }
}

class LRUCache{
    int cap;
    HashMap<Integer, Node> cache;
    Node head, tail;

    LRUCache(int capacity){
        this.cap = capacity;
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        this.head.next = this.tail;
        this.tail.prev = this.head;
        this.cache = new HashMap<>();
    }

    int get(int key){
        if(cache.containsKey(key)){
            remove(cache.get(key));
            insert(cache.get(key));
            return cache.get(key).val;
        }
        return -1;
    }

    void put(int key, int value){
        if (cache.containsKey(key)) {
            Node existingNode = cache.get(key);
            remove(existingNode); 
            
            existingNode.val = value; 
            insert(existingNode); 
            return; 
        }

        if (cache.size() == cap) {
            Node lru = head.next; 
            remove(lru);          
            cache.remove(lru.key); 
        }
        Node newNode = new Node(key, value);
        cache.put(key, newNode);
        insert(newNode);
    }

    void insert(Node node){
        Node prev = tail.prev;
        Node next = tail;
        prev.next = node;
        next.prev = node;
        node.next = next;
        node.prev = prev;
    }

    void remove(Node node){
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }
}
