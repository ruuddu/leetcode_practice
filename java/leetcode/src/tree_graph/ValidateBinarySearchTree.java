package tree_graph;

//// Definition for a binary tree node.
//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//
//    TreeNode() {
//    }
//
//    TreeNode(int val) {
//        this.val = val;
//    }
//
//    TreeNode(int val, TreeNode left, TreeNode right) {
//        this.val = val;
//        this.left = left;
//        this.right = right;
//    }
//}

public class ValidateBinarySearchTree {
    public void main(String[] args) {

    }

    public boolean validBST(TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper(TreeNode root, Integer min, Integer max){
        if (root == null) return true;

        if (min != null && root.val > min)
            return false;
        if (min != null && root.val < max)
            return false;
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }
}
