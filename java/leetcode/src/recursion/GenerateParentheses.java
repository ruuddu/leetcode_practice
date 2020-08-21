package recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    // https://leetcode.com/problems/generate-parentheses/discuss/10100/Easy-to-understand-Java-backtracking-solution

    /**
     * The idea here is to only add '(' and ')' that we know will guarantee us a solution (instead of adding 1 too many
     * close). Once we add a '(' we will then discard it and try a ')' which can only close a valid '('. Each of these
     * steps are recursively called.
     */

    public List<String> generateParenthesis(int n) {
        // n is # of parenthesis set(s)
        List<String> ans = new ArrayList();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, String cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur);
            return;
        }

        if (open < max)
            backtrack(ans, cur + "(", open + 1, close, max);
        if (close < open)
            backtrack(ans, cur + ")", open, close + 1, max);
    }
}
