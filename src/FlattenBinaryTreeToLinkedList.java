//   Link: https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
//    Given the root of a binary tree, flatten the tree into a "linked list":
//
//    The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
//    The "linked list" should be in the same order as a pre-order traversal of the binary tree.
//
//
//    Example 1:
//
//    Input: root = [1,2,5,3,4,null,6]
//    Output: [1,null,2,null,3,null,4,null,5,null,6]
//    Example 2:
//
//    Input: root = []
//    Output: []
//    Example 3:
//
//    Input: root = [0]
//    Output: [0]

import java.util.ArrayList;

public class FlattenBinaryTreeToLinkedList {
    public static ArrayList<TreeNode> treeNodesPreorderList = new ArrayList();

    public static void main(String[] args) {
        // root = [1,2,5,3,4,null,6]
        TreeNode leftSubtree = new TreeNode(2, new TreeNode(3), new TreeNode(4));
        TreeNode rightSubtree = new TreeNode(5, null, new TreeNode(6));
        TreeNode root = new TreeNode(1, leftSubtree, rightSubtree);

        flatten(root);
        // must be [1,null,2,null,3,null,4,null,5,null,6]
    }

    // Time complexity is O(n) -
    //              O(n) for preorder traversal + O(n) for iterating through the list = O(2n)
    //              = still O(n)
    // Space complexity is O(n) - because ArrayList size always depends on root size
    public static void flatten(TreeNode root) {
        if (root != null) {
            // need to change the root itself
            preorderTraversal(root);
            treeNodesPreorderList.remove(0);

            for (TreeNode t : treeNodesPreorderList) {
                root.right = new TreeNode(t.val);
                root.left = null;
                root = root.right;
            }
        }
    }

    public static void preorderTraversal(TreeNode root) {
        if (root == null) return;

        treeNodesPreorderList.add(root);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }
}
