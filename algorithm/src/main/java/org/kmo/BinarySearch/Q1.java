package org.kmo.BinarySearch;

import java.util.ArrayList;

/*
* 二分：旋转数组的最小数字
* https://www.cyc2018.xyz/%E7%AE%97%E6%B3%95/%E5%89%91%E6%8C%87%20Offer%20%E9%A2%98%E8%A7%A3/11.%20%E6%97%8B%E8%BD%AC%E6%95%B0%E7%BB%84%E7%9A%84%E6%9C%80%E5%B0%8F%E6%95%B0%E5%AD%97.html#%E9%A2%98%E7%9B%AE%E9%93%BE%E6%8E%A5
* */
public class Q1 {
    private ArrayList<Integer> arr;
    public Q1(ArrayList<Integer> arr){
        this.arr = arr;
    }
    public int find(){
        int i=0, j=arr.size()-1;
        while (i<j){
            int m = (i+j) >> 1;
            if(arr.get(i) < arr.get(m)){
                i = m;
            }else if(arr.get(i) > arr.get(m)){
                j = m;
            }else{
                int flag=0;
                for(int k=i;k<j;++k){
                    if(arr.get(k) > arr.get(k+1)){
                        flag=1;
                        return arr.get(k+1);
                    }
                }
                if(flag==0){
                    int min = arr.get(0);
                    for(int k=0; k<arr.size();++k){
                        min = arr.get(k)<min?arr.get(k):min;
                    }
                    return min;
                }
            }
        }
        return arr.get(i);
    }
}
