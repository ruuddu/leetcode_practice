package tree_graph;

public class RedundantConnection_2 {

    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] roots = new int[edges.length + 1];
        for (int i = 0; i < roots.length; i++) roots[i] = i;

        int[] candidate1 = null, candidate2 = null;
        for (int[] e : edges) {
            int rootx = find(roots, e[0]), rooty = find(roots, e[1]);
            if (rooty != e[1]) candidate1 = e; // Record the last edge which results in "multiple parents" issue
            else if (rootx == rooty) candidate2 = e; // Record last edge which results in "cycle" issue, if any.
            else roots[rooty] = rootx;
        }

        // If there is only one issue, return this one.
        if (candidate1 == null) return candidate2;
        if (candidate2 == null) return candidate1;

        // If there are multiple answers, return the answer that occurs last in the given 2D-array.
        /* If both issues present, then the answer should be the first edge which results in "multiple parents" issue
        The reason is, when an issue happens, we skip the "union" process.
		Therefore, if both issues happen, it means the incorrent edge which results in "multiple parents" was ignored. */
        for (int[] e : edges) if (e[1] == candidate1[1]) return e;

        return new int[2];
    }

    // find Parent
    private int find(int[] roots, int i) {
        while (i != roots[i]) {
            roots[i] = roots[roots[i]];
            i = roots[i];
        }
        return i;
    }
}
