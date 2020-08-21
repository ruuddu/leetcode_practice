package array_string;

public class PlusOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] digits = plusOne(new int[] {0});
		for(int i : digits) {
			System.out.print(i);	
		}
	}

    public static int[] plusOne(int[] digits) {
        // [9,9,9]
    	for(int i = digits.length - 1; i >= 0; i--) {
        	if(digits[i] < 9) {
        		digits[i] = digits[i] + 1;
        		return digits;
        	}
        	digits[i] = 0;
        }
    	if(digits[0] == 0) {
    		int[] newDigits = new int[digits.length + 1];
    		newDigits[0] = 1;
    		return newDigits;
    	}
    	return digits;
    }
}
