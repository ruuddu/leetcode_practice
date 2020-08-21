package tree_graph;

public class BinaryTreeMaxPathSum {
    public static void main(String[] args) {
    }

    //Definition for a binary tree node.
    public class TreeNode {
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

    static int max_sum = Integer.MIN_VALUE;

    private static int maxPathSum(TreeNode root) {
        max_count(root);
        return max_sum;
    }

    private static int max_count(TreeNode root) {
        if (root == null) return 0;

        // max sum on the left and right sub-trees of node
        int left_gain = Math.max(max_count(root.left), 0);
        int right_gain = Math.max(max_count(root.right), 0);

        // the price to start a new path where `node` is a highest node
        int price_newpath = root.val + left_gain + right_gain;

        // update max_sum if it's better to start a new path
        max_sum = Math.max(max_sum, price_newpath);

        // for recursion :
        // return the max gain if continue the same path
        return root.val + Math.max(left_gain, right_gain);
    }

    // Good explanation for edge case
    // https://leetcode.com/problems/binary-tree-maximum-path-sum/discuss/169912/54811null13472nullnullnull1/178842
}
