package com.guo.rpc.server;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: hotlove_linx
 * @Date: 2021/5/20 00:50
 * @Description:
 */
public class LRUCache<K, V> {

    class Node<K, V> {
        K key;
        V value;
        Node<K, V> prev;
        Node<K, V> next;

        public Node() {};

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    class DoubleList<K, V> {
        Node<K, V> head;
        Node<K, V> tail;
        public DoubleList() {
            head = new Node<>();
            tail = new Node<>();

            head.next = tail;
            tail.prev = head;
        }

        public void addHead(Node<K, V> node) {
            node.next = head.next;
            node.prev = head;

            head.next.prev = node;
            head.next = node;
        }

        public void removeNode(Node<K, V> node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.prev = null;
            node.next = null;
            node = null;
        }

        public Node<K, V> getLast() {
            return tail.prev;
        }
    }

    Map<K, Node<K, V>> map = new HashMap<>();
    DoubleList<K, V> doubleList = new DoubleList<>();
    int cacheSize = 3;

    public LRUCache() {}

    public LRUCache(int cacheSize) {
        this.cacheSize = cacheSize;
    }

    public V get(K key) {
        if (!map.containsKey(key)) {
            return null;
        }
        Node<K, V> node = map.get(key);
        doubleList.removeNode(node);
        doubleList.addHead(node);
        return node.value;
    }

    public void put(K key, V value) {
        if (map.containsKey(key)) {
            Node<K, V> node = map.get(key);
            node.value = value;
            map.put(key, node);

            doubleList.removeNode(node);
            doubleList.addHead(node);
        } else {
            if (map.size() == cacheSize) {
                Node<K, V> last = doubleList.getLast();
                map.remove(last.key);
                doubleList.removeNode(last);
            }
            Node node = new Node(key, value);
            map.put(key, node);
            doubleList.addHead(node);
        }
    }

    public static void main(String[] args) {
        LRUCache<Integer, String> lruCache = new LRUCache<>();
        lruCache.put(1, "1");
        lruCache.put(2, "2");
        lruCache.put(3, "3");
        System.out.println(lruCache.map.keySet());
        lruCache.put(4, "4");
        System.out.println(lruCache.map.keySet());
        lruCache.put(4, "4");
        System.out.println(lruCache.map.keySet());
        lruCache.put(5, "4");
        System.out.println(lruCache.map.keySet());
    }
}
