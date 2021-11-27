// Binary Tree InOrder Traversal: https://leetcode.com/problems/binary-tree-inorder-traversal/
// Binary Tree PreOrder Traversal https://leetcode.com/problems/binary-tree-preorder-traversal/
// Binary Tree PostOrder Traversal https://leetcode.com/problems/binary-tree-postorder-traversal/
// prefix is the location of the root in the sequence

import java.util.ArrayList;
import java.util.List;

// Definition for a binary tree node.
class TreeNode {
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

public class TreeTraversals {
    public static List<Integer> list = new ArrayList<Integer>();
    public static void main(String[] arg) {
        // root = [1, null, 2, 3]
        TreeNode tree = new TreeNode(1, null, new TreeNode(2));
        tree.right.left = new TreeNode(3);

        System.out.println(printInorderTraversal(tree));
        // must be [1,3,2]

        System.out.println(printPreorderTraversal(tree));
        // must be [1,2,3]

        System.out.println(printPostorderTraversal(tree));
        // must be [3,2,1]
    }

    public static List<Integer> printInorderTraversal(TreeNode root) {
        if (root == null) return list;
        inorderTraversal(root);

        return list;
    }

    public static List<Integer> printPreorderTraversal(TreeNode root) {
        if (root == null) return list;

        preorder(root);
        return list;
    }

    public static List<Integer> printPostorderTraversal(TreeNode root) {
        if (root == null) return list;

        postorder(root);
        return list;
    }

    public static void inorderTraversal(TreeNode root) {
        if (root == null) return;

        inorderTraversal(root.left);
        list.add(root.val);
        inorderTraversal(root.right);
    }

    public static void preorder(TreeNode root) {
        if (root == null) return;

        list.add(root.val);
        preorder(root.left);
        preorder(root.right);
    }

    public static void postorder(TreeNode root) {
        if (root == null) return;

        postorder(root.left);
        postorder(root.right);
        list.add(root.val);
    }
}
