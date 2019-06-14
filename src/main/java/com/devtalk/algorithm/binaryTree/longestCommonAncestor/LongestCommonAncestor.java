package com.devtalk.algorithm.binaryTree.longestCommonAncestor;

import com.devtalk.algorithm.binaryTree.traversal.TreeNode;

public class LongestCommonAncestor {

    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(7);
    root.left.left.left = new TreeNode(8);
    root.left.left.right = new TreeNode(9);
    root.right.right.left = new TreeNode(10);
    root.right.right.right = new TreeNode(11);


    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
     root.right = new TreeNode(3);
     root.left.left = new TreeNode(4);
     root.left.right = new TreeNode(5);
     root.right.left = new TreeNode(6);
     root.right.right = new TreeNode(7);

        System.out.println("LCA(4, 5): " + tree.findLCA(4,5));
        System.out.println("LCA(4, 6): " + tree.findLCA(4,6));
        System.out.println("LCA(3, 4): " + tree.findLCA(3,4));
        System.out.println("LCA(2, 4): " + tree.findLCA(2,4));
}
