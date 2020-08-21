package leetcode;

import java.util.Stack;

public class FindPermutation {

    public static void main(String[] args) {
        int[] res = findPermutation("IIDDIIID");
        for (int i : res) {
            System.out.print(i + " ");
        }
    }

    public static int[] findPermutation(String s) {
        int[] result = new int[s.length() + 1];
        Stack<Integer> st = new Stack<>();

        int j = 0;
        // have to start at I = 1 since the permutation start with 1 2 3 4 5 ...
        for (int i = 1; i <= s.length(); i++) {
            if (s.charAt(i - 1) == 'I') {
                st.push(i);
                while (!st.isEmpty()) {
                    result[j++] = st.pop();
                }
            } else {
                st.push(i);
            }
        }

        // push last iTH number into stack
        st.push(s.length() + 1);

        // pop all stack values and append to result array
        while (!st.isEmpty()) {
            result[j++] = st.pop();
        }
        return result;
    }
}
