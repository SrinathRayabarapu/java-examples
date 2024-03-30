package com.dsalgo.caches;

import com.dsalgo.linkedlist.DoublyNode;
import lombok.extern.slf4j.Slf4j;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * implement LRU algorithm in below ways -
 *  1. LRUCache where : cache will have limited capacity
 *  set(key, value) will replace the least recently values if the capacity is more
 *  get(key) will get the value if the key present, else return -1
 * <p>
 *
 *  We will use a Hashmap and Queue
 *
 * @author Srinath.Rayabarapu
 */
@Slf4j
public class LRUCacheMain {

    public static void main(String[] args) {

        // 1. LRU cache with key value pairs
        LRUCache cache = new LRUCache(2);

        cache.add(1, 10);
        cache.add(2, 20);

        log.info("Value for the key: 1 is {}", cache.get(1));

        // evicts key 2 and store a key (3) with
        cache.add(3, 30);

        log.info("Value for the key: 2 is {}", cache.get(2)); // returns -1 (not found)

        // evicts key 1 and store a key (4) with
        cache.add(4, 40);

        log.info("Value for the key: 1 is {}", cache.get(1)); // returns -1 (not found)
        log.info("Value for the key: 3 is {}", cache.get(3)); // returns 30
        log.info("Value for the key: 4 is {}", cache.get(4)); // return 40

        log.info("-----------------------");


/*        // 2. simple LRU implementation with size restrictions
        LRUWithDeque lru = new LRUWithDeque(4);

        lru.add(1);
        lru.add(2);
        lru.add(3);
        lru.add(1);
        lru.add(4);
        lru.add(5);
        lru.add(5);

        // 2 is removed
        lru.display();*/

    }

}

@Slf4j
class LRUCache {

    private int capacity;

    private DoublyNode head, tail;

    private Map<Integer, DoublyNode> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new DoublyNode(0, 0);
        tail = new DoublyNode(0, 0);
        head.previous = null;
        head.next = tail;
        tail.previous = head;
        tail.next = null;
        map = new HashMap<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            DoublyNode node = map.get(key);
            deleteNode(node);
            addToHead(node);
            return node.value;
        }
        log.error("Didn't find any value for the key {}", key);
        // in case no key found in cache
        return -1;
    }

    /**
     * add node to head
     *
     * @param node
     */
    private void addToHead(DoublyNode node) {
        node.next = head.next;
        node.next.previous = node;
        node.previous = head;
        head.next = node;
    }

    /**
     * deletes any node at any position
     *
     * @param node
     */
    private void deleteNode(DoublyNode node) {
        node.previous.next = node.next;
        node.next.previous = node.previous;
    }

    public void add(int key, int value) {
        DoublyNode node;
        if (map.containsKey(key)) {
            node = map.get(key);
            node.value = value;
            map.remove(key);
            deleteNode(node);
        } else {
            node = new DoublyNode(key, value);
            if (map.size() == capacity) {
                map.remove(tail.previous.key);
                deleteNode(tail.previous);
            }
        }
        addToHead(node);
        map.put(key, node);
    }

}

/**
 * LRU implementation class
 */
@Slf4j
class LRUWithDeque {

    Deque<Integer> queue;
    int capacity = 0;

    LRUWithDeque(int capacity) {
        this.capacity = capacity;
        this.queue = new LinkedList<>();
    }

    void add(Integer ele) {
        if (queue.contains(ele)) {
            queue.remove(ele);
        } else {
            if (queue.size() == capacity) {
                queue.removeLast();
            }
        }
        queue.push(ele);
    }

    void display() {
        for (Integer integer : queue) {
            log.info(integer + " ");
        }
    }

}