package org.kmo;

public class BinarySearch {
    public static int main(int[] arr,int target) {
        int i=0, j=arr.length-1;
        while (i<=j){
            int m = (i+j) / 2;
            if(target<arr[m]){
                j=m-1;
            }else if (target>arr[m]){
                i=m+1;
            }else {
                return m;
            }
        }
        return -1;
    }
}
