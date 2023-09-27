package org.kmo.datastruct.BinaryTree;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 二叉树遍历测试，非递归
 */
public class BinaryTreeTest {
    private final BinaryTree<Integer> bt = new BinaryTree<Integer>(
                1,
                new BinaryTree<Integer>(2,new BinaryTree<Integer>(4),new BinaryTree<Integer>(7)),
                new BinaryTree<Integer>(3,new BinaryTree<Integer>(5),new BinaryTree<Integer>(6))
        );
    private List<Integer> res = new ArrayList<Integer>();
    private List<Integer> respre = new ArrayList<Integer>();
    private List<Integer> resin = new ArrayList<Integer>();
    private List<Integer> respost = new ArrayList<Integer>();

    public List<Integer> getRes() {
        return res;
    }

    public List<Integer> getRespre() {
        return respre;
    }

    public List<Integer> getResin() {
        return resin;
    }

    public List<Integer> getRespost() {
        return respost;
    }

    @Test
    public void test01(){
        preOrder(bt);
        assertEquals(List.of(1,2,4,7,3,5,6),res);
        res.clear();
    }
    @Test
    public void test02(){
        inOrder(bt);
        assertEquals(List.of(4,2,7,1,5,3,6),res);
        res.clear();
    }
    @Test
    public void test03(){
        postOrder(bt);
        assertEquals(List.of(4,7,2,5,6,3,1),res);
        res.clear();
    }
    @Test
    public void test04(){
        allOrder(bt);
        assertEquals(List.of(1,2,4,7,3,5,6),respre);
        assertEquals(List.of(4,2,7,1,5,3,6),resin);
        assertEquals(List.of(4,7,2,5,6,3,1),respost);
        respre.clear();
        resin.clear();
        respost.clear();
    }
    public void preOrder(BinaryTree<Integer> node){
        ArrayDeque<BinaryTree<Integer>> stack = new ArrayDeque<BinaryTree<Integer>>();
        do {
            if (node!=null) {
                stack.push(node);
                res.add(node.value);
                node = node.left;
            } else {
                node = stack.pop().right;
            }
        } while(node!=null || !stack.isEmpty());
    }

    public void pre(BinaryTree<Integer> curr){
        ArrayDeque<BinaryTree<Integer>> stack = new ArrayDeque<BinaryTree<Integer>>();
        do {
            if (curr!=null){
                stack.push(curr);
                res.add(curr.value);
                curr = curr.left;
            }else {
                curr = stack.pop().right;
            }
        }while (curr!=null || !stack.isEmpty());
    }
    public void inOrder(BinaryTree<Integer> node){
        ArrayDeque<BinaryTree<Integer>> stack = new ArrayDeque<BinaryTree<Integer>>();
        do {
            if (node!=null){
                stack.push(node);
                node = node.left;
            }else {
                node = stack.pop();
                res.add(node.value);
                node = node.right;
            }
        }while (node!=null || !stack.isEmpty());
    }

    public void in(BinaryTree<Integer> curr){
        ArrayDeque<BinaryTree<Integer>> stack = new ArrayDeque<BinaryTree<Integer>>();
        do {
            if (curr!=null){
                stack.push(curr);
                curr = curr.left;
            }else {
                curr = stack.pop();
                res.add(curr.value);
                curr = curr.right;
            }

        }while (curr!=null || !stack.isEmpty());
    }
    public void postOrder(BinaryTree<Integer> node){
        ArrayDeque<BinaryTree<Integer>> stack = new ArrayDeque<BinaryTree<Integer>>();
        BinaryTree<Integer> lastp = null;
        do {
            if (node!=null){
                stack.push(node);
                node = node.left;
            }else {
                BinaryTree<Integer> peek = stack.getFirst();
                if(peek.right==null || peek.right==lastp){
                    lastp = stack.pop();
                    res.add(lastp.value);
                }else {
                    node = peek.right;
                }
            }
        }while (node!=null || !stack.isEmpty());
    }

    public void post(BinaryTree<Integer> curr){
        ArrayDeque<BinaryTree<Integer>> stack = new ArrayDeque<BinaryTree<Integer>>();
        BinaryTree<Integer> lastp = null;
        do {
            if (curr!=null){
                stack.push(curr);
                curr=curr.left;
            }else {
                BinaryTree<Integer> peek = stack.getFirst();
                if (peek.right!=null && peek.right!=lastp){
                    curr = peek.right;
                }else {
                    lastp = stack.pop();
                    res.add(lastp.value);
                }
            }
        }while (curr!=null || !stack.isEmpty());
    }

    public void allOrder(BinaryTree<Integer> curr){
        ArrayDeque<BinaryTree<Integer>> stack = new ArrayDeque<BinaryTree<Integer>>();
        BinaryTree<Integer> lastp = null;
        do {
            if (curr!=null){
                stack.push(curr);
                respre.add(curr.value);
//                处理左子树
                curr=curr.left;
            }else {
                BinaryTree<Integer> peek = stack.getFirst();
//                没有右子树
                if (peek.right == null){
                    resin.add(peek.value);
                    lastp = stack.pop();
                    respost.add(lastp.value);
//                    右子树已处理
                }else if (peek.right==lastp){
                    lastp = stack.pop();
                    respost.add(lastp.value);
//                    处理右子树
                }else {
                    resin.add(peek.value);
                    curr = peek.right;
                }
            }
        }while (curr!=null || !stack.isEmpty());
    }
}
