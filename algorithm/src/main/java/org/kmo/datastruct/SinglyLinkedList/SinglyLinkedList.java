package org.kmo.datastruct.SinglyLinkedList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class SinglyLinkedList implements Iterable<Integer>{
    private Logger logger = LoggerFactory.getLogger("");
    private Node head;
    private Node tail;
    private int size;
    public SinglyLinkedList(){
        head = null;
        tail = null;
        size = 0;
    }
//    当内部类和外部内的成员变量无联系，可以加static（建议加）
    private static class Node{
        int value;
        Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

//    增
    public void addFirst(int value){
        head = new Node(value, head);
        size++;
        if (size==1){
            tail = head;
        }
    }
    public void addLast(int value){
        if (size==0){
            addFirst(value);
        }else {
            tail.next = new Node(value,null);
            tail = tail.next;
            size++;
        }
    }
    public void insert(int index, int value){
        if (0<index && index<size){
            Node p = findIndex(index-1);
            p.next = new Node(value,p.next);
            size++;
        }else if (index==0){
            addFirst(value);
        }else if (index==size){
            addLast(value);
        }else {
            throw illegalIndex(index);
        }
    }
//    删
    public void removeFirst(){
        if (size==1){
            head=null;
            tail=null;
            size=0;
        }else if (size>1){
            head = head.next;
            size--;
        }else {
            logger.warn("size 0 none to remove");
        }
    }
    public void remove(int index){
        if (index<0 || size<=index){
            throw illegalIndex(index);
        }else if (index==0){
            removeFirst();
        }else {
            Node p = findIndex(index-1);
            p.next = p.next.next;
            size--;
        }
    }
//    查
    private Node findIndex(int index){
        if (0<index && index<size-1){
            int i=1;
            for (Node p=head.next; p.next!=null; p=p.next,i++){
                if (i==index){
                    return p;
                }
            }
        } else if (size!=0 && index == 0){
            return head;
        } else if (size!=0 && index==size-1){
            return tail;
        } else{
            throw illegalIndex(index);
        }
        return null;
    }
    public int get(int index){
        return findIndex(index).value;
    }
//    遍历
    public void forEach2(Consumer<Integer> consumer){
        Node p = head;
        while (p!=null){
            consumer.accept(p.value);
            p = p.next;
        }
    }
    @Override
    public Iterator<Integer> iterator(){
        return new Iterator<Integer>() {
            private Node p = head;
            @Override
            public boolean hasNext() {
                return p!=null;
            }

            @Override
            public Integer next() {
                Node tmp = p;
                p = p.next;
                return tmp.value;
            }
        };
    }
//    other
    public int size(){
        return size;
    }
    private IllegalArgumentException illegalIndex(int index){
        return new IllegalArgumentException(String.format("index [%d] 不合法\n",index));
    }
}


