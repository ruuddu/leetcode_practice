package array_string;

public class LongestSubstringAtMostTwoDistinctChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        int[] map = new int[128];
        int first = 0, end = 0, k = 0, max = 0;
        while(first < s.length() && end < s.length()){
            char c = s.charAt(end);
            if(map[c] == 0){
                k++;
            }
            map[c]++;

            if(k > 2){
                max =  Math.max(max, end - first);
                while(first < end){
                    c = s.charAt(first);
                    map[c]--;
                    first++;
                    if(map[c] == 0){
                        k--;
                        break;
                    }
                }
            }
            
            end++;
        }
        return max == 0 ? s.length() : Math.max(max,  end - first);
    }

}
