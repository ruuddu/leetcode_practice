package array_string;

public class MultiplyStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// total combination of two numbers' digit won't be over than (n1's digits + n2's digits + 1)
	public String multiply(String num1, String num2) {
        int n1 = num1.length(), n2 = num2.length();
        int[] total = new int[n1+n2];
        for(int f = n1 - 1; f >= 0; f--){
            for(int l = n2 - 1; l >= 0; l--){
                // multiple two numbers
                int mul = (num1.charAt(f) - '0') * (num2.charAt(l) - '0');
                
                // plus with right index: for example: 12 + 9 = 21 
                mul += total[f+l+1];
                
                total[f+l] += mul / 10;
                total[f+l+1] = mul % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < total.length; i++){
            // important row since there might something like 0000 or 0600
        	if( !(sb.length() == 0 && total[i] == 0) ){
                sb.append(total[i]);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
	}
}

