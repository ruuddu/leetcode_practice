package leetcode;

import static java.lang.System.out;

public class LicenceKeyFormatting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// S = "2-5g-3-J", K = 2
		out.println(licenseKeyFormatting("2-5g-3-J", 2));
	}
	
    public static String licenseKeyFormatting(String S, int K) {
        if (S.length() <= K)
            return S.replace("-","").toUpperCase();
        String cleaned = S.replace("-","").toUpperCase();
        int firstGroupSize = cleaned.length() % K;
        StringBuilder sb = new StringBuilder();
        int i = 0;
        if (firstGroupSize != 0){
            sb.append(cleaned.substring(0, firstGroupSize));
            i += firstGroupSize;
            if (K < cleaned.length())
                sb.append("-");
        }
        for (; i < cleaned.length(); i+=K){
            sb.append(cleaned.substring(i, i+K));
            
            if (i + K < cleaned.length())
                sb.append("-");
        }
        return sb.toString();
    }
    
    // faster - 12ms
    // StringBuilder sb = new StringBuilder();
    // int count = 0;
    // for (int i = S.length() - 1; i >= 0; i--) {
    //     char c = S.charAt(i);
    //     if (c != '-') {
    //         if (count > 0 && count % K == 0) {
    //             sb.append('-');
    //         }
    //         sb.append(c);
    //         count++;
    //     }
    // }
    // return sb.reverse().toString().toUpperCase();

}
