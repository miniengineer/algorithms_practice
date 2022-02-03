// Link: https://leetcode.com/problems/word-search/

// Tip
// look at each node individually and think about what information we need?
// 1. tilt of the current tree |leftSubtreesValues - rightSubtreesValues|
// 2. sum of all current tree values (leftSubtreeValues and rightSubtreeValues)

// Binary Tree, Depth First Search

// Time Complexity is O(n) since we're going to visit each node at least once
// Space Complexity is O(n) since we're using recursion and callstack will be same as # of nodes

public class BinaryTreeTilt {
    public static int sumOfEveryTilt = 0;

    public static void main(String[] args) {
        int[] arr1 = { 21,7,14,1,1,2,2,3,3 };
        TreeNode node1 = new TreeNode(3, null, null);
        TreeNode node2 = new TreeNode(1, node1, node1);
        TreeNode node3 = new TreeNode(7, node2, new TreeNode(1, null, null));
        TreeNode node4 = new TreeNode(2, null, null);
        TreeNode node5 = new TreeNode(14, node4, node4);
        TreeNode binaryTree = new TreeNode(21, node3, node5);

        BinaryTreeTilt binaryTreeTilt = new BinaryTreeTilt();
        System.out.println(binaryTreeTilt.findTilt(binaryTree));
        // must be 9
    }

    public int findTilt(TreeNode root) {
        // need to override since it's a static variable
        sumOfEveryTilt = 0;
        dfs(root);

        return sumOfEveryTilt;
    }

    public int dfs(TreeNode root) {
        if (root == null) return 0;

        int left = dfs(root.left);
        int right = dfs(root.right);

        int tilt = Math.abs(left - right);
        sumOfEveryTilt += tilt;

        System.out.println("Tilt of node " + root.val + " : | " + left + " - " + right + " = " + tilt);


        return root.val + left + right;
    }
}

// Logs for input: [21,7,14,1,1,2,2,3,3]

//    Tilt of node 3 : | 0 - 0 = 0
//    Tilt of node 3 : | 0 - 0 = 0
//    Tilt of node 1 : | 3 - 3 = 0
//    Tilt of node 1 : | 0 - 0 = 0
//    Tilt of node 7 : | 7 - 1 = 6
//    Tilt of node 2 : | 0 - 0 = 0
//    Tilt of node 2 : | 0 - 0 = 0
//    Tilt of node 14 : | 2 - 2 = 0
//    Tilt of node 21 : | 15 - 18 = 3