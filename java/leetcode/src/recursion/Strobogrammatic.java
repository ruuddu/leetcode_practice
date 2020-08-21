package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Strobogrammatic {


    /**
     * Numbers 0,1,6,9,8 are numbers whose inverted images give themselves or another number among them
     * inverted_images = { 0: 0, 1: 1, 6: 9, 8: 8, 9: 6}
     *
     * A number is strobrogrammatic if i'th digit is inverted image of len(num) - i - 1 st digit
     * eg in 9 6 9 6
     *       0 1 2 3
     *
     * the digit at 0th index 9 is inverted image of digit at 3rd index
     * the digit at 1st index 6 is inverted image of digit at 2nd index
     *
     * Any strobogrammatic number is only formed from the invertable numbers and can never have any number
     * that is non invertable
     * */

    /**
     * Good Explanation
     * https://leetcode.com/problems/strobogrammatic-number-ii/discuss/418620/Awesome-algorithm-with-easy-and-detailed-explanation!-Beats-96-runtime-100-memory
     * */
    public List<String> findStrobogrammatic(int n) {
        List<String> one = Arrays.asList("0", "1", "8"), two = Arrays.asList(""), r = two;

        // if # is odd, add 0, 1, 8 in the middle
        if (n % 2 == 1)
            r = one;
        // else add empty "" in the middle

        // increase 2 by each iteration
        for (int i = (n % 2) + 2; i <= n; i += 2) {
            List<String> newList = new ArrayList<>();

            for (String str : r) {

                if (i != n)
                    newList.add("0" + str + "0");

                newList.add("1" + str + "1");
                newList.add("6" + str + "9");
                newList.add("8" + str + "8");
                newList.add("9" + str + "6");
            }
            r = newList;
        }
        return r;
    }
}
