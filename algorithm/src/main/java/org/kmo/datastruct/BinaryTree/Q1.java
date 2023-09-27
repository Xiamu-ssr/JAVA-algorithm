package org.kmo.datastruct.BinaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 *根据前中序遍历构建二叉树
 *https://www.cyc2018.xyz/%E7%AE%97%E6%B3%95/%E5%89%91%E6%8C%87%20Offer%20%E9%A2%98%E8%A7%A3/7.%20%E9%87%8D%E5%BB%BA%E4%BA%8C%E5%8F%89%E6%A0%91.html#%E9%A2%98%E7%9B%AE%E9%93%BE%E6%8E%A5
 * https://www.nowcoder.com/practice/8a19cbe657394eeaac2f6ea9b0f6fcf6?tpId=13&tqId=11157&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking&from=cyc_github
 * */

public class Q1 {
    HashMap<Integer, Integer> map = new HashMap<>();
    public BinaryTree<Integer> reConstructBinaryTree (int[] preOrder, int[] vinOrder) {
        for(int i=0; i<vinOrder.length; ++i){
            map.put(vinOrder[i],i);
        }
        return work(preOrder, vinOrder);
    }
    public BinaryTree<Integer> work(int[] pre, int[] in){
        if(pre.length==0){
            return null;
        }else if (pre.length==1){
            return new BinaryTree<Integer>(pre[0]);
        }
        BinaryTree<Integer> root = new BinaryTree<Integer>(pre[0]);
//        int midflag = map.get(root.value);
        ArrayList<Integer> tmp = new ArrayList<>(Arrays.asList())
        root.left = work(Arrays.copyOfRange(pre,1,midflag+1),Arrays.copyOfRange(in,0,midflag));
        root.right = work(Arrays.copyOfRange(pre,midflag+1,pre.length),Arrays.copyOfRange(in,midflag+1,in.length));
        return root;
    }
}
