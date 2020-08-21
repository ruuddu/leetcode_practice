package array_string;

import java.util.*;

public class ThreeSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(newThreeSum(new int[] {-1, 0, 1, 2, -1, -4}));
	}

	public List<List<Integer>> threeSum(int[] nums) {
		Set<List<Integer>> threeSumSet  = new HashSet<>();

		Arrays.sort(nums);

		for(int i=0; i<nums.length-2;i++){ //Doing length-2, because we want two elems j and k after i.
			int j = i+1;

			int k = nums.length-1;

			while(j<k){

				int sum = nums[i] + nums[j] + nums[k];

				if(sum == 0){

					threeSumSet.add(Arrays.asList(nums[i], nums[j], nums[k]));

					j++;
					k--;
				}
				else if (sum > 0){
					k--;
				} 
				else if (sum < 0){
					j++;
				} 
			}

		}

		return new ArrayList<>(threeSumSet);
	}
	
    public static List<List<Integer>> newThreeSum(int[] nums) {
        Arrays.sort(nums);
        // can just use hashset so no need to detect the duplicate at A B and C but it's slower
        List<List<Integer>> threeSumSet  = new ArrayList<>();
        //Doing length - 2, because we want two elems j and k after i.
        for(int i = 0; i < nums.length - 2; i++){ 
            if (i > 0 && nums[i] == nums[i-1]) continue; // A
            System.out.println(i);
            System.out.println("===");
            int j = i + 1; // next index of i
            
            int k = nums.length - 1; // last index of array
            
            while( j < k ){
                int sum = nums[i] + nums[j] + nums[k];
                
                if(sum == 0){
                	threeSumSet.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while(j < k && nums[j] == nums[j+1]){ // B
                        j++;
                    }
                    while(j < k && nums[k] == nums[k-1]){ // C
                        k--;
                    }
                    j++;
                    k--;
                }
                else if (sum > 0){
                    k--; // move last index back 1 step
                } 
                else if (sum < 0){
                    j++; // move next index of i forward 1 step
                } 
            }

        }
        
        //return new ArrayList<>(threeSumSet);
        return threeSumSet;
    }
	
	// Fast but hard to understand
//	public List<List<Integer>> threeSum(int[] nums) {
//		Arrays.sort(nums);
//		List<List<Integer>> res = new ArrayList<>();
//		for (int i = 0; i < nums.length && nums[i] <= 0; ++i)
//			if (i == 0 || nums[i - 1] != nums[i])
//				twoSumII(nums, i, res);
//		return res;
//	}
//	
//	void twoSumII(int[] nums, int i, List<List<Integer>> res) {
//		int lo = i + 1, hi = nums.length - 1;
//		while (lo < hi) {
//			int sum = nums[i] + nums[lo] + nums[hi];
//			if (sum < 0 || (lo > i + 1 && nums[lo] == nums[lo - 1]))
//				++lo;
//			else if (sum > 0 || (hi < nums.length - 1 && nums[hi] == nums[hi + 1]))
//				--hi;
//			else
//				res.add(Arrays.asList(nums[i], nums[lo++], nums[hi--]));
//		}
//	}
}
