package leetcode;

import java.util.*;

public class FruitInBasket {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(totalFruit(new int[] {3,3,3,1,2,1,1,2,3,3,4}));
	}
	
	// [3,3,3,1,2,1,1,2,3,3,4]
    public static int totalFruit(int[] tree) {
        Map<Integer, Integer> count = new HashMap<>();
        
        int i = 0, j;
        
        for (j = 0; j < tree.length; ++j) {
        	
            count.put(tree[j], count.getOrDefault(tree[j], 0) + 1);
            
            if (count.size() > 2) {
            	System.out.println(j);

            	count.put(tree[i], count.get(tree[i]) - 1); // reduce one count in left most fruit
            	
            	for(Map.Entry<Integer, Integer> m : count.entrySet()) {
            		System.out.println(m);
            	}
            	
            	count.remove(tree[i++], 0); // remove left most fruit if it's empty
            	System.out.println("i = " + i);
            }
        }
        System.out.println("=====");
        System.out.println(i);
        System.out.println(j);
        return j - i;
    }
    
    // Python for k baskets instead of 2 baskets as above
//    def totalFruit(self, tree, k):
//        count, i = {}, 0
//        for j, v in enumerate(tree):
//            count[v] = count.get(v, 0) + 1
//            if len(count) > k:
//                count[tree[i]] -= 1
//                if count[tree[i]] == 0: del count[tree[i]]
//                i += 1
//        return j - i + 1
}
