package dynamic_programming;

public class UniquePath {
    public int uniquePaths(int m, int n) {
        // only DOWN or RIGHT to reach goal
        // bottom-up solution
        // either DP or memoization
        // brute force solution first

        /**
         brute force
         */
        // base case - recursion
        // if( m == 1 || n == 1) return 1;
        // return uniquePaths(m - 1, n) + uniquePaths(m , n-1);

        /**
         Recursion with memoization
         */
        // int[][] storage = new int[m+1][n+1];
        // return helper(m, n, storage);


        /**
         Dynamic Programming
         */
        if (m == 1 || n == 1) return 1;
        int[][] storage = new int[m + 1][n + 1];

        for (int i = 2; i <= m; i++) {
            for (int j = 2; j <= n; j++) {
                if (i - 1 == 1) storage[i - 1][j] = 1;
                if (j - 1 == 1) storage[i][j - 1] = 1;
                storage[i][j] = storage[i - 1][j] + storage[i][j - 1];

            }
        }
        return storage[m][n];
    }

    /**
     * Recursion with memoization
     */
    private int helper(int m, int n, int[][] storage) {
        if (m == 1 || n == 1) return 1;
        if (storage[m][n] != 0) {
            return storage[m][n];
        }
        storage[m][n] = helper(m - 1, n, storage) + helper(m, n - 1, storage);
        return storage[m][n];
    }
}
