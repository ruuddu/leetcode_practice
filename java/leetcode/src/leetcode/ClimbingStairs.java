package leetcode;

public class ClimbingStairs {

    // TIMED-OUT SOLUTION
    public int climbStairs_timedout(int n) {
        return helper(n+1);
    }

    private int helper(int n){
        if( n == 0 ) return 0;
        if( n == 1 ) return 1;
        return helper(n-1) + helper(n-2);
    }

    // WORKING SOLUTION
    // FIBONACCI
    // TIME : O(N)
    // SPACE: O(1)
    public int climbStairs(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;

        int one_step_before = 2;
        int two_steps_before = 1;
        int all_ways = 0;

        for (int i = 2; i < n; i++) {
            all_ways = one_step_before + two_steps_before;
            two_steps_before = one_step_before;
            one_step_before = all_ways;
        }
        return all_ways;
    }
}
