package tree_graph;

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

public class CountCompleteTreeNodes {
    public static void main(String[] args) {
    }

    // O(n) run through every node
    public int countNodes(TreeNode root) {
        int count = 0;
        if (root == null) return 0;
        count = countNodes(root.left) + countNodes(root.right) + 1;
        return count;
    }

    // Need to optimize the space complexity
    public int countNodes_optimize(TreeNode root) {
        int lh = 0, rh = 0;
        TreeNode curr = root;
        while (curr != null) {
            lh++;
            curr = curr.left;
        }
        curr = root;
        while (curr != null) {
            rh++;
            curr = curr.right;
        }
        if (lh == rh)
            return (int) Math.pow(2, lh) - 1;
        return 1 + countNodes_optimize(root.left) + countNodes_optimize(root.right); // This is not much different
    }

    int height(TreeNode root) {
        return root == null ? -1 : 1 + height(root.left);
    }

    /**
     * The height of a tree can be found by just going left. Let a single node tree have height 0.
     *      Find the height h of the whole tree. If the whole tree is empty, i.e., has height -1, there are 0 nodes.
     *
     * Otherwise check whether the height of the right subtree is just one less than that of the whole tree,
     * meaning left and right subtree have the same height.
     *
     * If yes, then the last node on the last tree row is in the right subtree and the left subtree is a full tree of
     *      height h-1. So we take the 2^h-1 nodes of the left subtree plus the 1 root node plus recursively the number of nodes in the right subtree.
     *
     * If no, then the last node on the last tree row is in the left subtree and the right subtree is a full tree of
     *      height h-2. So we take the 2^(h-1)-1 nodes of the right subtree plus the 1 root node plus recursively the number of nodes in the left subtree.
     */
    // O(logN) for binary search from root, at each recursive, run height() costs O(logN) => O(log(N)^2)
    public int countNodes_most_optimal(TreeNode root) {
        int h = height(root);
        return h < 0 ? 0 :
                height(root.right) == h - 1 ? (1 << h) + countNodes(root.right)
                                            : (1 << h - 1) + countNodes(root.left);
    }
}
