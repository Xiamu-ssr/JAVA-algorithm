package org.kmo.datastruct.BinaryTree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 二叉树遍历测试，递归
 */
public class BinaryTreeTestRec {
    private final BinaryTree<Integer> bt = new BinaryTree<Integer>(
                1,
                new BinaryTree<Integer>(2,new BinaryTree<Integer>(4),null),
                new BinaryTree<Integer>(3,new BinaryTree<Integer>(5),new BinaryTree<Integer>(6))
        );
    private List<Integer> res = new ArrayList<Integer>();
    @Test
    public void test01(){
        preOrderRec(bt);
        assertEquals(List.of(1,2,4,3,5,6),res);
        res.clear();
    }
    @Test
    public void test02(){
        inOrderRec(bt);
        assertEquals(List.of(4,2,1,5,3,6),res);
        res.clear();
    }
    @Test
    public void test03(){
        postOrderRec(bt);
        assertEquals(List.of(4,2,5,6,3,1),res);
        res.clear();
    }
    public void preOrderRec(BinaryTree<Integer> node){
        if (node==null){return;}
        res.add(node.value);
        preOrderRec(node.left);
        preOrderRec(node.right);
    }
    public void inOrderRec(BinaryTree<Integer> node){
        if (node==null){return;}
        inOrderRec(node.left);
        res.add(node.value);
        inOrderRec(node.right);
    }
    public void postOrderRec(BinaryTree<Integer> node){
        if (node==null){return;}
        postOrderRec(node.left);
        postOrderRec(node.right);
        res.add(node.value);
    }
}
