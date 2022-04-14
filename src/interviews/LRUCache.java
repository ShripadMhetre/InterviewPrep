package interviews;

import java.util.HashMap;

class Node {
    int key;
    int value;
    Node next;
    Node prev;

    public Node(int key, int value) {
        this.key = key;
        this.value  = value;
        next = null;
        prev = null;
    }
}


/*
    Q. Implement Least Recently Used (LRU) cache.

    You need to implement the following for the LRUCache class:

    1. LRUCache(int capacity) - initializes the cache to store data of size: capacity.
    2. int get(int key) - returns the value of the key if it exists, otherwise returns -1.
    3. void add(int key, int value) - updates the value of the key if the key exists. Otherwise, add the key-value pair to the cache.
       If the no. of keys exceeds the capacity from this operation, evict the least recently used key.

    Note: Try to achieve each operation in O(1) time complexity.
 */
public class LRUCache {
    Node front;
    Node rear;
    HashMap<Integer, Node> hm;
    int capacity = 0;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        hm = new HashMap<>();
    }

    public int get(int key) {
        if (hm.get(key) == null) return -1;

        Node t = hm.get(key);

        // remove from the current position and add it to rear in the queue as the node recently accessed
        removeNode(t);
        addNode(t);

        return t.value;
    }

    public void add(int key, int value) {
        if (hm.containsKey(key)) {
            Node t = hm.get(key);
            t.value = value;

            removeNode(t);
            addNode(t);
        } else {
            if (hm.size() >= capacity) {
                hm.remove(front.key);
                removeNode(front);
            }

            Node t = new Node(key, value);
            addNode(t);
            hm.put(key, t);
        }
    }

    // Adds to rear
    public void addNode(Node node) {
        if (rear != null) {
            rear.next = node;
        }

        node.prev = rear;
        node.next = null;
        rear = node;

        if (front == null) {
            front = rear;
        }
    }

    // Removes the given node and update front, rear pointers accordingly
    public void removeNode(Node node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            front = node.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            rear = node.prev;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache cache = new LRUCache(capacity);
 * int value = cache.get(key);
 * cache.add(key, value);
 */