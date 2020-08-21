package array_string;

public class NextClosestTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    static int[] mins = { 600, 60, 10, 1 };
    
    
    // 19:34 => 1174 => result 19:39
    
    public static String nextClosestTime(String time) {
        int colon = time.indexOf(':');
        
        // find the current minutes
        int cur = Integer.valueOf(time.substring(0, colon)) * 60 + Integer.valueOf(time.substring(colon + 1));
        
        char[] next = new char[4];
        
        // 1440 = 24 hours * 60 minutes
        for (int i = 1, d = 0; i <= 1440 && d < 4; i++) {
            int m = (cur + i) % 1440;
            
            for (d = 0; d < 4; d++) {
            	
                next[d] = (char)('0' + m / mins[d]);
                
                m %= mins[d];
                
                // if the number is not in the original time string
                // BREAK
                if (time.indexOf(next[d]) == -1) break;
                
            }
            
        }
        return new String(next, 0, 2) + ':' + new String(next, 2, 2);
    }
}
