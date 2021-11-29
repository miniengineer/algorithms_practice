//   Link: https://leetcode.com/problems/binary-tree-level-order-traversal/
//    Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
//
//    Example 1:
//    Input: root = [3,9,20,null,null,15,7]
//    Output: [[3],[9,20],[15,7]]
//    Example 2:
//
//    Input: root = [1]
//    Output: [[1]]
//    Example 3:
//
//    Input: root = []
//    Output: []

//    Constraints:
//    The number of nodes in the tree is in the range [0, 2000].
//    -1000 <= Node.val <= 1000

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

    public static void main(String[] args) {
        // root = [90,69,null,49,89,null,52]
        TreeNode rightSubtree= new TreeNode(20, new TreeNode(15), new TreeNode(7));
        TreeNode tree = new TreeNode(3, new TreeNode(9), rightSubtree);

        System.out.println(levelOrderTraversal(tree));
        // must be [[3], [9,20], [15,7]]
    }

    // Time complexity is O(n) - Visit each node once
    // Space complexity is O(n) - queue & result size depends on TreeNode size
    public static List<List<Integer>> levelOrderTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> listOfNodeValues = new ArrayList();
        listOfNodeValues.add(root.val);
        result.add(listOfNodeValues);

        if (root.left != null) {
            queue.add(root.left);
        }

        if (root.right != null) {
            queue.add(root.right);
        }

        while (!queue.isEmpty()) {
            int currQueueSize = queue.size();
            List<Integer> nodeValuesList = new ArrayList();

            while (currQueueSize > 0) {
                TreeNode currNode = queue.poll();
                nodeValuesList.add(currNode.val);

                if (currNode.left != null) {
                    queue.add(currNode.left);
                }

                if (currNode.right != null) {
                    queue.add(currNode.right);
                }

                currQueueSize--;
            }

            result.add(nodeValuesList);
        }

        return result;
    }

    // non-working solution
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> listOfNodeValues = new ArrayList();
        listOfNodeValues.add(root.val);
        result.add(listOfNodeValues);

        // cleanup listOfNodeValues so we can reuse it
        listOfNodeValues.clear();

        if (root.left != null) {
            queue.add(root.left);
        }

        if (root.right != null) {
            queue.add(root.right);
        }

        while (!queue.isEmpty()) {
            int currQueueSize = queue.size();

            while (currQueueSize > 0) {
                TreeNode currNode = queue.poll();
                listOfNodeValues.add(currNode.val);

                if (currNode.left != null) {
                    queue.add(currNode.left);
                }

                if (currNode.right != null) {
                    queue.add(currNode.right);
                }

                currQueueSize--;
            }

            result.add(listOfNodeValues);
            // cleanup listOfNodeValues so we can reuse it
            listOfNodeValues.clear();
        }

        return result;
    }
}
