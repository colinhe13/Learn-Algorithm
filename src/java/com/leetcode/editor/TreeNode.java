package com.leetcode.editor;

/**
 * @ClassName TreeNode
 * @Description TODO
 * @Author Colin
 * @Date 2022/8/24 23:56
 * @Version 1.0
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
