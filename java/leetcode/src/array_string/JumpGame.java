package array_string;

public class JumpGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(canJump(new int[] {2, 4, 2, 1, 0, 2, 0}));

	}
	// fastest version
    public static boolean canJump(int[] nums) {
        int maxIndex=0;
        for(int i=0; i < nums.length; i++){
            if(maxIndex < i){ // if maxIndex smaller than i, means there is no way to move to last index
                return false;
            }
            maxIndex = Math.max(maxIndex, nums[i] + i);
        }
        return true;
    }
	
	// Greedy: better than DP with memoization
//    public static boolean canJump(int[] nums) {
//        int lastPos = nums.length - 1;
//        for (int i = nums.length - 1; i >= 0; i--) {
//            if (i + nums[i] >= lastPos) {
//                lastPos = i;
//            }
//        }
//        return lastPos == 0;
//    }
	
//	enum Index {
//	    GOOD, BAD, UNKNOWN
//	}
//	// Bottom-up DP with memoization
//    public static boolean canJump(int[] nums) {
//        Index[] memo = new Index[nums.length];
//        for (int i = 0; i < memo.length; i++) {
//            memo[i] = Index.UNKNOWN;
//        }
//        memo[memo.length - 1] = Index.GOOD;
//
//        for (int i = nums.length - 2; i >= 0; i--) {
//            int furthestJump = Math.min(i + nums[i], nums.length - 1);
//            for (int j = i + 1; j <= furthestJump; j++) {
//                if (memo[j] == Index.GOOD) {
//                    memo[i] = Index.GOOD;
//                    break;
//                }
//            }
//        }
//        for (int i = 0; i < memo.length; i++) {
//            System.out.println(memo[i]);
//        }
//        return memo[0] == Index.GOOD;
//    }

}
