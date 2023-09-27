package org.kmo.datastruct.BinaryTree;

public class BinaryTree<T> {
    public T value;
    public BinaryTree<T> left;
    public BinaryTree<T> right;

    public BinaryTree(T value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public BinaryTree(T value, BinaryTree<T> left, BinaryTree<T> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "BinaryTree{" +
                "value=" + value +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
