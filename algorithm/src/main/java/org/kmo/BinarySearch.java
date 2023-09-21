package org.kmo;

public class BinarySearch {
    public static int main(int[] arr,int target) {
        int i=0, j=arr.length;
        while (i<j){
            int m = (i+j) >> 1;
            if(target<arr[m]){
                j=m;
            }else if (arr[m]<target){
                i=m+1;
            }else {
                return m;
            }
        }
        return -1;
    }
}
