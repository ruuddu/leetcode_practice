package leetcode;


// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class BalancedTree {

    // Worst case O(n^2) : Best case O(N logN)
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        // the difference is that we have to call isBalanced most of the time when optimal solution does NOT
        return Math.abs(leftHeight - rightHeight) <= 1 && isBalanced(root.left) && isBalanced(root.right) ? true : false;
    }

    private int height(TreeNode root) {
        if (root == null) return 0;
        return Math.max(height(root.left) + 1, height(root.right) + 1);
    }

    /** ============== */
    int dfsHeight (TreeNode root) {
        if (root == null) return 0;

        int leftHeight = dfsHeight (root.left);
        if (leftHeight == -1) return -1;
        int rightHeight = dfsHeight (root.right);
        if (rightHeight == -1) return -1;

        if (Math.abs(leftHeight - rightHeight) > 1)  return -1;
        return Math.max(leftHeight, rightHeight) + 1;
    }

    // O(N) only visit each node once - Bottom Up
    public boolean isBalanced_optimal(TreeNode root) {
        return dfsHeight (root) != -1;
    }
}
