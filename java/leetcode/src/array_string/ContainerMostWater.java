package array_string;

public class ContainerMostWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public int maxArea(int[] height) {
        int start = 0, end = height.length - 1;
        int max = 0;
        while(start < end){
            if (height[start] > height[end]) {
                max = Math.max(max, height[end] * (end - start) );
                end--;
            }
            if (height[start] <= height[end]) {
                max = Math.max(max, height[start] * (end - start) );  
                start++;
            } 
        }
        return max;
    }
}
