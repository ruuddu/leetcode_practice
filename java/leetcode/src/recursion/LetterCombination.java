package recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LetterCombination {

    public List<String> letterCombinations_better(String digits) {
        LinkedList<String> ans = new LinkedList<String>();
        if (digits.isEmpty()) return ans;
        String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for (int i = 0; i < digits.length(); i++) {
            int x = Character.getNumericValue(digits.charAt(i));
            while (ans.peek().length() == i) {
                String t = ans.remove();
                for (char s : mapping[x].toCharArray())
                    ans.add(t + s);
            }
        }
        return ans;
    }

    public List<String> letterCombinations(String digits) {
        // Queue and DFS to search for every single possible combination
        Queue<String> q = new LinkedList<>();
        q.offer("");
        String[] arr = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        List<String> l = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            int n = Character.getNumericValue(digits.charAt(i));
            System.out.println(q.size());

            int queueSize = q.size();
            while (queueSize > 0) {
                StringBuilder sb = new StringBuilder(q.poll());
                for (int j = 0; j < arr[n].length(); j++) {

                    String temp = arr[n].charAt(j) + "";
                    temp = sb.toString() + temp;

                    if (i == digits.length() - 1) {
                        l.add(temp);
                    } else {
                        q.offer(temp);
                    }
                }
                queueSize--;
            }
        }
        return l;
    }
}
