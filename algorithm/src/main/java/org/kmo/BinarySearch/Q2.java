package org.kmo.BinarySearch;


import java.util.ArrayList;

/*
*
* 53. 数字在排序数组中出现的次数
* https://www.cyc2018.xyz/%E7%AE%97%E6%B3%95/%E5%89%91%E6%8C%87%20Offer%20%E9%A2%98%E8%A7%A3/53.%20%E6%95%B0%E5%AD%97%E5%9C%A8%E6%8E%92%E5%BA%8F%E6%95%B0%E7%BB%84%E4%B8%AD%E5%87%BA%E7%8E%B0%E7%9A%84%E6%AC%A1%E6%95%B0.html#%E9%A2%98%E7%9B%AE%E9%93%BE%E6%8E%A5
* https://www.nowcoder.com/practice/70610bf967994b22bb1c26f9ae901fa2?tpId=13&tqId=11190&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking&from=cyc_github
* */
public class Q2 {
    private ArrayList<Integer> arr;

    public Q2(ArrayList<Integer> arr){
        this.arr = arr;
    }
    public int find(int target){
        int flag = new BinarySearch(arr).find(target);
        if (flag==-1){
            return 0;
        }
        int count = 1;
        int flagbk = flag-1;
        while(flagbk>=0 && arr.get(flagbk)==target){
            count++;
            flagbk--;
        }
        flagbk = flag + 1;
        while (flagbk<arr.size() && arr.get(flagbk)==target){
            count++;
            flagbk++;
        }
        return count;
    }

}
