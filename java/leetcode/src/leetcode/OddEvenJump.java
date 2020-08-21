package leetcode;

import java.util.*;

public class OddEvenJump {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int test = oddEvenJumps(new int[] {2,3,1,1,4} );
		System.out.println(test);
	}
    // Runtime: O(n*log(n))
    // Memory: O(n)
    public static int oddEvenJumps(int[] A) {
        int n = A.length;
        
        boolean[] odd = new boolean[n];
        boolean[] even = new boolean[n];
//        for(int i = 0; i<5;i++)	System.out.println(odd[i]);
        
        TreeMap<Integer, Integer> indexes = new TreeMap<>();
        
        // Begin state, end value is always reachable
        indexes.put(A[n-1], n-1);
        odd[n-1] = true;
        even[n-1] = true;
        int count = 1;
//        2,3,1,1,4
        
        for (int i=n-2; i>=0; --i) {
            int cur = A[i];
            System.out.println(i);
            // Methods floorEntry() and ceilingEntry() imply less or equal, or greater
            // than equal, in comparison with lowerKey() and higherKey() (where equality
            // is not included). Therefore 1 condition less.
            Map.Entry<Integer, Integer> nextLow = indexes.floorEntry(cur);
            Map.Entry<Integer, Integer> nextHigh = indexes.ceilingEntry(cur);
                
            // If there is lower value present, set corresponding value from odd to even
            if (nextLow != null) even[i] = odd[(int) nextLow.getValue()];
            
            if (nextLow != null) {
            	System.out.println(odd[(int) nextLow.getValue()]);
            	System.out.println(nextLow.getValue());
            }
            
            System.out.println("==========");

            // If there is higher value present, set corresponding value from even to odd
            if (nextHigh != null) odd[i] = even[(int) nextHigh.getValue()];
            
            if (nextHigh != null) {
            	System.out.println(even[(int) nextHigh.getValue()]);
            	System.out.println(nextHigh.getValue());
            }
            
            // The first move is always odd, so count all odds which are true
            /* 
             * tvo:
             * We only count odd true/false because at each step, we evaluate true/false for next largest value and
             * next smallest value. At current i index, if odd is true, that means from that i, we can reach to the end 
             * since we evaluate backward from last index. Therefore, last index always is true for both even/odd jump.
            */
            if (odd[i]) count++;
            
            indexes.put(cur, i);
        }
        
        return count;
    }
//     public int oddEvenJumps(int[] A) {
//         int N = A.length;
//         if (N <= 1) return N;
//         boolean[] odd = new boolean[N];
//         boolean[] even = new boolean[N];
//         odd[N-1] = even[N-1] = true;

//         TreeMap<Integer, Integer> vals = new TreeMap();
//         vals.put(A[N-1], N-1);
//         for (int i = N-2; i >= 0; --i) {
//             int v = A[i];
//             if (vals.containsKey(v)) {
//                 odd[i] = even[vals.get(v)];
//                 even[i] = odd[vals.get(v)];
//             } else {
//                 Integer lower = vals.lowerKey(v);
//                 Integer higher = vals.higherKey(v);

//                 if (lower != null)
//                     even[i] = odd[vals.get(lower)];
//                 if (higher != null) {
//                     odd[i] = even[vals.get(higher)];
//                 }
//             }
//             vals.put(v, i);
//         }

//         int ans = 0;
//         for (boolean b: odd)
//             if (b) ans++;
//         return ans;
//     }

}
