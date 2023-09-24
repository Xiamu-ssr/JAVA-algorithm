package org.kmo.algorithm.BinarySearch;

/*
* x 的平方根
* https://leetcode.cn/problems/sqrtx/description/
* https://www.cyc2018.xyz/%E7%AE%97%E6%B3%95/Leetcode%20%E9%A2%98%E8%A7%A3/Leetcode%20%E9%A2%98%E8%A7%A3%20-%20%E4%BA%8C%E5%88%86%E6%9F%A5%E6%89%BE.html#_1-%E6%B1%82%E5%BC%80%E6%96%B9
 * */

public class Q3 {
    public int find(int target) {
        switch (target){
            case 0:
                return 0;
            case 1:
                return 1;
        }
        long left = 1, right = target;
        while(left+1 != right){
            long mid = (left+right) >> 1;
            if(mid*mid < target){
                left = mid;
            }else if(target < mid*mid){
                right = mid;
            }else {
                return (int)mid;
            }
        }

        return (int)left;
    }

}
