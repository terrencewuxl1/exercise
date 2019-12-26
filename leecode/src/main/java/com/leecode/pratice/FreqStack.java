package com.leecode.pratice;


import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class FreqStack {
    class Node {
        int val;
        int times;
        int ser;

        public Node(int v,int t,int serial) {
            val = v;
            times=t;
            ser=serial;
        }
    }

    PriorityQueue<Node> q;
    Map<Integer,Node> map;
    int serial=0;

    public FreqStack() {
        q = new PriorityQueue<>((o1, o2) -> {
            if (o1.times == o2.times) return o2.ser - o1.ser;
            else return o2.times - o1.times;
        });
        map=new HashMap<>();
    }


    public void push(int x) {
        if(map.containsKey(x)){
            Node xNode=map.get(x);
            xNode.times++;
            q.offer(new Node(xNode.val,xNode.times,serial));
        }else{
            map.put(x, new Node(x,1,serial));
            q.offer(new Node(x,1,serial));
        }
        serial++;
    }

    public int pop() {
        Node pNode=q.poll();
        int pal=pNode.val;
        if(pNode.times==1){
            map.remove(pal);
        }else {
            Node n=map.get(pal);
            n.times--;
            map.put(pal,n);
        }
        return pal;
    }

    @Test
    public void test(){
        FreqStack f=new FreqStack();
        f.push(5);
        f.push(7);
        f.push(5);
        f.push(7);
        f.push(4);
        f.push(5);
        f.pop();
        f.pop();
        f.pop();
        f.pop();

    }
}
