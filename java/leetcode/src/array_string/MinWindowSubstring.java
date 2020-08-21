package array_string;

public class MinWindowSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/* HARD */
	/*
	 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T 
	 * in complexity O(n).
	 * Example:

Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"
Note:

If there is no such window in S that covers all characters in T, return the empty string "".
If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
	 */

	// COMMON SOLUTION FOR SUBSTRING
	//https://leetcode.com/problems/minimum-window-substring/discuss/26808/here-is-a-10-line-template-that-can-solve-most-substring-problems
	public String minWindow(String s, String t) {
		int [] map = new int[128];
		for (char c : t.toCharArray()) {
			map[c]++;
		}
		int start = 0, end = 0, minStart = 0, minLen = Integer.MAX_VALUE, counter = t.length();
        // S = "ADOBBEC ODEBANC", T = "ABC"
        // 3 2 1 0
        // map[a] = 1
        // map[b] = 1
        // map[c] = 1
        
		while (end < s.length()) {
			char c1 = s.charAt(end);
            
			if (map[c1] > 0) counter--;
            
			map[c1]--;
			end++;
            
			while (counter == 0) {
				if (minLen > end - start) { // found new minimum length
					minLen = end - start;
					minStart = start;
				}
                
				char c2 = s.charAt(start); // moving start pointer to the right until substring invalid
				map[c2]++;
				if (map[c2] > 0) counter++;
				start++;
			}
		}

		return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
	}
}
