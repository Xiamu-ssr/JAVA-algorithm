package org.kmo.BinarySearch;

import java.util.ArrayList;

public class BinarySearch {
    private ArrayList<Integer> arr = new ArrayList<Integer>();

    public BinarySearch(ArrayList<Integer> arr) {
        this.arr = arr;
    }

    public int find(int target) {
        int i=0, j=arr.size();
        while (i<j){
            int m = (i+j) >> 1;
            if(target<arr.get(m)){
                j=m;
            }else if (arr.get(m)<target){
                i=m+1;
            }else {
                return m;
            }
        }
        return -1;
    }
}
