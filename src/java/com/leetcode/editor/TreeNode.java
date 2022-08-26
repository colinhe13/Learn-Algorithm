package com.leetcode.editor;

/**
 * @ClassName TreeNode
 * @Description TODO
 * @Author Colin
 * @Date 2022/8/24 23:56
 * @Version 1.0
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
