package org.kmo.datastruct.BinaryTree;

import org.junit.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Q1Test {
    private BinaryTreeTest test = new BinaryTreeTest();
    @Test
    public void test01(){
        int[] pre = {1,2,3,4,5,6,7};
        int[] in = {3,2,4,1,6,5,7};
        Q1 q = new Q1();
        BinaryTree<Integer> tree = q.reConstructBinaryTree(pre, in);
        test.allOrder(tree);
        assertEquals(List.of(1,2,4,7,3,5,6,8), test.getRespre());
    }
}
