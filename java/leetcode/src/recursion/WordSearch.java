package recursion;

import java.util.ArrayList;
import java.util.List;

public class WordSearch {

    /**  Trie + DFS = FAST  */
    // https://leetcode.com/problems/word-search-ii/discuss/59780/Java-15ms-Easiest-Solution-(100.00)
    public List<String> findWords_optimal(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, res);
            }
        }
        return res;
    }

    public void dfs(char[][] board, int i, int j, TrieNode p, List<String> res) {
        char c = board[i][j];
        if (c == '#' || p.next[c - 'a'] == null) return;
        p = p.next[c - 'a'];
        if (p.word != null) {   // found one
            res.add(p.word);
            p.word = null;     // de-duplicate
        }

        board[i][j] = '#'; // remove visited cell
        if (i > 0) dfs(board, i - 1, j, p, res);
        if (j > 0) dfs(board, i, j - 1, p, res);
        if (i < board.length - 1) dfs(board, i + 1, j, p, res);
        if (j < board[0].length - 1) dfs(board, i, j + 1, p, res);
        board[i][j] = c;
    }

    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode p = root;
            for (char c : w.toCharArray()) {
                int i = c - 'a';
                if (p.next[i] == null) p.next[i] = new TrieNode();
                p = p.next[i];
            }
            p.word = w;
        }
        return root;
    }

    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }

    // Search start from every single cell - SLOW
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList();
        for (String word : words)
            if (exist(board, word))
                res.add(word);
        return res;
    }

    public boolean exist(char[][] board, String word) {

        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && existWord(board, word, i, j, 1))
                    return true;
            }
        return false;
    }

    private boolean existWord(char[][] board, String word, int row, int col, int index) {
        // Hit the end of the word
        if (index == word.length())
            return true;

        board[row][col] = '.';


        // Check four directions

        if (row > 0 && board[row - 1][col] == word.charAt(index) && existWord(board, word, row - 1, col, index + 1)) {
            board[row][col] = word.charAt(index - 1);
            return true;
        }

        if (row < board.length - 1 && board[row + 1][col] == word.charAt(index) && existWord(board, word, row + 1, col, index + 1)) {
            board[row][col] = word.charAt(index - 1);
            return true;
        }

        if (col > 0 && board[row][col - 1] == word.charAt(index) && existWord(board, word, row, col - 1, index + 1)) {
            board[row][col] = word.charAt(index - 1);
            return true;
        }

        if (col < board[0].length - 1 && board[row][col + 1] == word.charAt(index) && existWord(board, word, row, col + 1, index + 1)) {
            board[row][col] = word.charAt(index - 1);
            return true;
        }

        board[row][col] = word.charAt(index - 1);
        return false;
    }
}
