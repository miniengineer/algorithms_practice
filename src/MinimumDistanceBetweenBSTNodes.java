//  Link: https://leetcode.com/problems/minimum-distance-between-bst-nodes/
//    Given the root of a Binary Search Tree (BST), return the minimum difference between the values
//    of any two different nodes in the tree.
//
//    Example 1:
//    Input: root = [4,2,6,1,3]
//    Output: 1
//
//    Example 2:
//    Input: root = [1,0,48,null,null,12,49]
//    Output: 1
//
//
//    Constraints:
//    The number of nodes in the tree is in the range [2, 100].
//    0 <= Node.val <= 105

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    public int val;
    public TreeNode left, right;
    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class MinimumDistanceBetweenBSTNodes {
    public static int globalMinDistance = Integer.MAX_VALUE;
    public static List<Integer> listOfNodeValues = new ArrayList<>();

    public static void main(String[] args) {
        // root = [90,69,null,49,89,null,52]
        TreeNode tree = new TreeNode(90, new TreeNode(69), null);
        tree.left.left = new TreeNode(49);
        tree.left.left.right = new TreeNode(52);
        tree.left.right = new TreeNode(89);

        System.out.println(minDiffInBST(tree));
        // must be 1
        // diff between root 90 and it's grandchild node 89
    }

    // Time complexity is O(n) -
    //              we traverse BST once + loop through the same amount of nodes
    // Space complexity is O(n) -
    //              list where we store BST node values is dependent on the # of BST nodes
    public static int minDiffInBST(TreeNode root) {
        // use inorder traversal to output a sorted list
        fillListWithInorderTraversal(root);

        for (int i = 0; i < listOfNodeValues.size() - 1; i++) {
            int currValue = listOfNodeValues.get(i);
            int nextValue = listOfNodeValues.get(i + 1);

            globalMinDistance = Math.min(globalMinDistance, nextValue - currValue);
        }

        return globalMinDistance;
    }

    public static void fillListWithInorderTraversal(TreeNode root) {
        if (root == null) return;

        fillListWithInorderTraversal(root.left);
        listOfNodeValues.add(root.val);
        fillListWithInorderTraversal(root.right);
    }
}
