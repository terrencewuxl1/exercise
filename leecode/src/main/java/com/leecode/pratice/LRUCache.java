package com.leecode.pratice;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

class LRUCache {

      class Node{
            int key;
            int val;
            Node pre;
            Node next;
            public Node(int k,int value){
                key=k;
                val=value;
            }
        }
        final HashMap<Integer,Node> map;
        final Node head=new Node(0,-1);
        final Node tail=new Node(0,-1);
        final int capacity;

        public LRUCache() {
            map=new HashMap<>();
            head.next=tail;
            tail.pre=head;
            this.capacity=2;
        }

        private void deleteNode(Node node){
            node.pre.next=node.next;
            node.next.pre=node.pre;
        }

        private void addToHead(Node node){
            node.pre =head;
            node.next=head.next;
            head.next.pre=node;
            head.next=node;
        }

        public int get(int key) {
            if(map.containsKey(key)){
                Node curr=map.get(key);
                deleteNode(curr);
                addToHead(curr);
                return curr.val;
            }
            return -1;
        }

        public void put(int key, int value) {
            if(map.containsKey(key)){
                Node curr=map.get(key);
                curr.val=value;
                deleteNode(curr);
                addToHead(curr);

            }else{
                if(map.size()==capacity){
                    map.remove(tail.pre.key);
                    deleteNode(tail.pre);
                }
                Node curr=new Node(key,value);
                addToHead(curr);
                map.put(key,curr);

            }
        }

    @Override
    public String toString() {
        return "LRUCache{" +
                "map=" + map.toString() +'}';
    }

    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */

    @Test
    public void test(){
        LRUCache cache = new LRUCache();

        cache.put(1, 1);
        printNode(head);
        System.out.println(cache);
        cache.put(2, 2);
        printNode(head);
        System.out.println(cache);
        cache.get(1);       // returns 1
        printNode(head);
        System.out.println(cache);
        cache.put(3, 3);    // evicts key 2
        printNode(head);
        System.out.println(cache);
        cache.get(2);       // returns -1 (not found)
        printNode(head);
        System.out.println(cache);
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4
    }

    public void printNode(Node head){
        while (head!=null){
            System.out.print(head.val+"->");
            head=head.next;
        }
        System.out.println("");
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
