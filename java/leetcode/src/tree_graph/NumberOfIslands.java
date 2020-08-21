package tree_graph;

public class NumberOfIslands {
    public static void main(String[] args) {

    }

    void dfs(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;

        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0'; // mark 0 for visited node
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

    public int numIslands(char[][] grid) {
        // base case: grid is EMPTY
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length; // row
        int nc = grid[0].length; // column
        int num_islands = 0;

        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    num_islands++;
                    dfs(grid, r, c); // depth first search for every found island root node
                }
            }
        }

        return num_islands;
    }
}
