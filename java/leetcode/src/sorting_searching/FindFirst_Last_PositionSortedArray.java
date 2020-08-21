package sorting_searching;

public class FindFirst_Last_PositionSortedArray {

    public static int[] searchRange(int[] nums, int target) {
        return helper(0, nums.length - 1, target, nums);
    }

    public static int[] helper(int start, int end, int target, int[] nums) {
        // base case

        if (nums.length == 0) return new int[]{-1, -1};

        if (nums[start] == nums[end] && nums[start] == target) {
            return new int[]{start, end};
        }

        if (nums[start] <= target && nums[end] >= target) {
            int mid = (start + end) / 2;
            int[] l = helper(start, mid, target, nums);
            int[] r = helper(mid + 1, end, target, nums);


            if (l[0] == -1 && r[0] == -1)
                return new int[]{-1, -1};

            if (l[0] == -1) return r;
            else if (r[0] == -1) return l;
            else return new int[]{l[0], r[1]};
        }

        return new int[]{-1, -1};
    }
}
