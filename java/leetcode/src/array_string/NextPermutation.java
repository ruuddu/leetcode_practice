package array_string;

public class NextPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] test = new int[] {1, 2, 3};
		int[] test = new int[] {1, 3, 2};
		test = new int[] {2, 3, 1};
		nextPermutation(test);
		for(int i : test) System.out.print(i + ", ");
	}

    public static void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        // looping until value at current i < next i
        // find first decrease value from the last one
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            // find number larger than current i
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            // swap them 
            swap(nums, i, j);
        }
        // reverse the rest
        reverse(nums, i + 1);
    }
    
    public static void swap(int[] nums, int a, int b){
        int temp = nums[b];
        nums[b] = nums[a];
        nums[a] = temp;
    }
    
    public static void reverse(int[] nums, int a){
        int b = nums.length - 1;
        while(a < b){
            swap(nums, a, b);
            a++;
            b--;
        }
    }
}
