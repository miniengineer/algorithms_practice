//  Link: https://leetcode.com/problems/invert-binary-tree/
//    Given the root of a binary tree, invert the tree, and return its root.
//
//    Example 1:
//
//
//    Input: root = [4,2,7,1,3,6,9]
//    Output: [4,7,2,9,6,3,1]
//    Example 2:
//
//
//    Input: root = [2,1,3]
//    Output: [2,3,1]
//    Example 3:
//
//    Input: root = []
//    Output: []
//
//
//    Constraints:
//
//    The number of nodes in the tree is in the range [0, 100].
//    -100 <= Node.val <= 100

public class InvertBinaryTree {
    public static void main(String[] args) {
        // root = [2,1,3]
        TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(3));

        root = invertTree(root);
        System.out.println(root.left.val);
        System.out.println(root.right.val);
        // must be [3,1]
    }

    public static TreeNode invertTree(TreeNode root) {
        postOrderInvert(root);
        return root;
    }

    public static void postOrderInvert(TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) return;
        postOrderInvert(root.left);
        postOrderInvert(root.right);

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
