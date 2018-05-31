/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.HashMap;

/**
 *
 * @author sekha
 */
class DoublyLinkedListNode {

    int key;
    int val;

    DoublyLinkedListNode next;
    DoublyLinkedListNode prev;

    public DoublyLinkedListNode(int key, int val) {
        this.key = key;
        this.val = val;
        next = null;
        prev = null;
    }

    public void setNext(DoublyLinkedListNode next) {
        this.next = next;
    }

    public void setPrev(DoublyLinkedListNode next) {
        this.prev = prev;
    }

    @Override
    public boolean equals(Object obj) {
        DoublyLinkedListNode dln = (DoublyLinkedListNode) obj;
        return this.key == dln.key;
    }

}

class DoublyLinkedList {

    private DoublyLinkedListNode head;
    private DoublyLinkedListNode tail;
    private int size;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        size = 0;
    }

    public void addToHead(DoublyLinkedListNode node) {
        if (head == null && tail == null) {
            this.head = node;
            this.tail = node;
        } else {
            node.next = this.head;
            this.head.prev = node;
            this.head = node;
        }
        size++;
    }

    public DoublyLinkedListNode remove(DoublyLinkedListNode node) {

        if (node != null) {
            if (node.next == null && node.prev == null) {
                this.head = null;
                this.tail = null;

            } else if (node == tail) {
                this.tail = node.prev;
                node.prev.next = null;
                node.prev = null;
            } else if (node == head) {
                this.head = node.next;
                node.next.prev = null;
                node.next = null;
            } else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
                node.next = null;
                node.prev = null;
            }
        }

        size--;
        return node;
    }

    public DoublyLinkedListNode removeFromTail() {
        return remove(this.tail);
    }

    public int size() {
        //System.out.println("SIZE " + size);
        return this.size;
    }

}

public class LRUCache {

    DoublyLinkedList dl;
    HashMap<Integer, DoublyLinkedListNode> cache = null;
    int capacity;

    public LRUCache(int capacity) {
        dl = new DoublyLinkedList();
        cache = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        DoublyLinkedListNode oldNode = cache.get(key);
        if (oldNode == null) {
            return -1;
        }

        DoublyLinkedListNode evictNode = dl.remove(oldNode);
        dl.addToHead(evictNode);

        return oldNode.val;
    }

    public void put(int key, int value) {
        if (this.capacity > 0) {
            if (cache.get(key) == null) {

                DoublyLinkedListNode newNode = new DoublyLinkedListNode(key, value);
                if (dl.size() == capacity) {
                    DoublyLinkedListNode evictNode = dl.removeFromTail();
                    cache.remove(evictNode.key);
                }

                cache.put(key, newNode);
                dl.addToHead(newNode);
            }else{
                cache.get(key).val = value;
                DoublyLinkedListNode evictNode = dl.remove(cache.get(key));
                dl.addToHead(evictNode);
            }
        }

    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3.
        cache.put(4, 4);    // evicts key 1.
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4
    }
}
