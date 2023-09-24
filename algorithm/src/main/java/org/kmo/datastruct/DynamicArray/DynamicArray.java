package org.kmo.datastruct.DynamicArray;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class DynamicArray implements Iterable<Integer>{
    private int size=0;
    private final int onecap = 16;
    private int capacity=onecap;
    private int[] arr;
//    构造方法
    public DynamicArray(){
        arr = new int[capacity];
    }
    public DynamicArray(int[] brr){
        arr = new int[capacity];
        insert(0, brr);
    }
//    自动扩容
//    提供新添的数量
    private void capOK(int newnums){
        if (size+newnums>capacity){
            int dis = (size+newnums-capacity);
            int newcap = ((dis/onecap) + 1) * onecap;
            capacity += newcap;
            int[] tmp = arr;
            arr = new int[capacity];
            System.arraycopy(tmp,0,arr,0,size);
        }
    }
//    追加
    public void append(int n){
        capOK(1);
        arr[size++] = n;
    }
//    插入
    public void insert(int post, int num){
        if(post<0 || size<post){
            System.out.println("post error");
            return;
        }
        capOK(1);
        if (post != size){
            int[] tmp = Arrays.copyOfRange(arr, post, size);
            System.arraycopy(tmp,0,arr,post+1,size-post);
        }
        arr[post] = num;
        size++;
    }
    public void insert(int post, int[] brr){
        if (post<0 || size<post){
            System.out.println("post error");
            return;
        }
        capOK(brr.length);
        if(post != size){
            int[] tmp = Arrays.copyOfRange(arr, post, size);
            System.arraycopy(tmp,0,arr,post+brr.length, size-post);
        }
        System.arraycopy(brr,0,arr,post,brr.length);
        size+=brr.length;
    }
//    删除
    public int pop(){
        if(size<=0){
            System.out.println("No element to pop");
            return 0;
        }
        int tmp = arr[size-1];
        arr[size-1] = 0;
        size --;
        return tmp;
    }
    public int remove(int post){
        if (0<=post && post<size){
            int tmp = arr[post];
            System.arraycopy(arr,post+1,arr,post,size-post-1);
            arr[--size] = 0;
            return tmp;
        }else {
            System.out.println("error post");
            return 0;
        }
    }
//    打印
    public void print(){
        System.out.println(Arrays.toString(Arrays.copyOfRange(arr,0,size)));
    }
//    size
    public int size(){
        return size;
    }
//    get
    public int get(int post){
        return arr[post];
    }
//    遍历方式一forEach
//    2是因为iterable冲突所以改名
    public void forEach2(Consumer<Integer> consumer){
        for (int i=0; i<size; ++i){
            consumer.accept(arr[i]);
        }
    }
//    遍历方式二iterator
//    匿名内部类
    @Override
    public Iterator<Integer> iterator(){
        return new Iterator<Integer>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public Integer next() {
                if (hasNext()){
                    return arr[index++];
                }
                throw new NoSuchElementException();
            }
        };
    }
//    遍历方式三stream
    public IntStream stream(){
        return IntStream.of(Arrays.copyOfRange(arr,0,size));
    }
}
