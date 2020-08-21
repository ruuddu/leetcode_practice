package array_string;

import java.util.Map;
import java.util.HashMap;

public class LongestSubstringWithoutRepeatChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int n = s.length(), count = 0;
        
        for(int start = 0, end = 0; end < n; end++){
            if(map.containsKey(s.charAt(end))){
                start = Math.max(map.get(s.charAt(end)), start);
            }
            
	        // count is the length of longest substring
	        // start first index of longest substring
	        // end is the last index of longest substring
            count = Math.max(count, end - start + 1);
            map.put(s.charAt(end), end + 1);
        }
        return count;
    }
}
