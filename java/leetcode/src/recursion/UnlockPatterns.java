package recursion;

public class UnlockPatterns {


    public int numberOfPatterns(int m, int n) {
        boolean[] visited = new boolean[10];//use 1 - 9

        visited[0] = true; // so that if block = 0, visit[block] = true

        int[][] block = new int[10][10];//use 1 - 9

        // we did it because they're symmetric
        block[1][3] = block[3][1] = 2;
        block[1][7] = block[7][1] = 4;
        block[1][9] = block[9][1] = block[3][7] = block[7][3] = block[2][8] = block[8][2] = block[4][6] = block[6][4] = 5;
        block[7][9] = block[9][7] = 8;
        block[3][9] = block[9][3] = 6;
        int count = 0;
        // starting from 1 is simmilar as 3, 7 and 9
        count += dfs(1, m, n, 1, visited, block) * 4;

        // starting from 2 is simmilar as 4, 6 and 8
        count += dfs(4, m, n, 1, visited, block) * 4;

        // 5 is a center which is unique
        count += dfs(5, m, n, 1, visited, block);
        return count;
    }

    /**
     * p : start key
     * m : minimum pattern
     * n : maximum pattern
     * d : # of key already visited
     * */
    // m = 2
    // n = 2
    private int dfs(int p, int m, int n, int d, boolean[] visited, int[][] block) {
        // reach max pattern
        if (d == n) return 1;

        int count = 0;

        // mark visited key
        visited[p] = true;

        // if m is too large, we need to make sure d >= m to increase the count
        if (d >= m) count++;

        // start from 1 to 9
        for (int i = 1; i < 10; i++) {
            //  if the key is not visited yet AND middle key is passed
            if (!visited[i] && visited[block[p][i]])
                count += dfs(i, m, n, d + 1, visited, block);
        }

        // unmark visited key
        visited[p] = false;
        return count;
    }
}
