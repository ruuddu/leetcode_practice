package sorting_searching;

public class FindMedianSortedArrays {


    /**
     * Better solution
     * 1) Calculate the medians m1 and m2 of the input arrays ar1[]
     * and ar2[] respectively.
     *
     * 2) If m1 and m2 both are equal then we are done.
     * return m1 (or m2)
     *
     * 3) If m1 is greater than m2, then median is present in one
     * of the below two subarrays.
     * a)  From first element of ar1 to m1 (ar1[0...|_n/2_|])
     * b)  From m2 to last element of ar2  (ar2[|_n/2_|...n-1])
     *
     * 4) If m2 is greater than m1, then median is present in one
     * of the below two subarrays.
     * a)  From m1 to last element of ar1  (ar1[|_n/2_|...n-1])
     * b)  From first element of ar2 to m2 (ar2[0...|_n/2_|])
     *
     * 5) Repeat the above process until size of both the subarrays
     * becomes 2.
     *
     * 6) If size of the two arrays is 2 then use below formula to get
     * the median.
     * Median = (max(ar1[0], ar2[0]) + min(ar1[1], ar2[1]))/2
     */

    /** SAME SIZE **/

    static int getMedian(int[] a, int[] b, int startA, int startB, int endA, int endB) {
        if (endA - startA == 1) {
            return (Math.max(a[startA], b[startB]) + Math.min(a[endA], b[endB])) / 2;
        }
        /* get the median of
            the first array */
        int m1 = median(a, startA, endA);

        /* get the median of
            the second array */
        int m2 = median(b, startB, endB);

        /* If medians are equal then
            return either m1 or m2 */
        if (m1 == m2) {
            return m1;
        }

        /* if m1 < m2 then median must
            exist in ar1[m1....] and
                ar2[....m2] */
        else if (m1 < m2) {
            return getMedian(a, b, (endA + startA + 1) / 2, startB, endA, (endB + startB + 1) / 2);
        }

        /* if m1 > m2 then median must
            exist in ar1[....m1] and
            ar2[m2...] */
        else {
            return getMedian(a, b, startA, (endB + startB + 1) / 2, (endA + startA + 1) / 2, endB);
        }
    }

    /* Function to get median
    of a sorted array */
    static int median(int[] arr, int start, int end) {
        int n = end - start + 1;
        if (n % 2 == 0) {
            return (arr[start + (n / 2)] + arr[start + (n / 2 - 1)]) / 2;
        } else {
            return arr[start + n / 2];
        }
    }



    public static void main(String[] args) {
        int[] a1 = new int[]{1, 3};
        int[] a2 = new int[]{2, 3, 4};
        System.out.println(findMedianSortedArrays(a1, a2));
    }

    /** DIFFERENT SIZE **/
    // HARD SOLUTION

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Deal with invalid corner case.
        // if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) return 0.0;

        int m = nums1.length, n = nums2.length;
        int l = (m + n + 1) / 2; //left half of the combined median
        int r = (m + n + 2) / 2; //right half of the combined median

        // If the nums1.length + nums2.length is odd, the 2 functions will return the same number
        // Else if nums1.length + nums2.length is even, the 2 function will return the left number
        // and right number that make up a median
        return (getKth(nums1, 0, nums2, 0, l) + getKth(nums1, 0, nums2, 0, r)) / 2.0;
    }

    private static double getKth(int[] nums1, int start1, int[] nums2, int start2, int k) {
        // This function finds the Kth element in nums1 + nums2

        // If nums1 is exhausted, return kth number in nums2
        if (start1 > nums1.length - 1) return nums2[start2 + k - 1];

        // If nums2 is exhausted, return kth number in nums1
        if (start2 > nums2.length - 1) return nums1[start1 + k - 1];

        // If k == 1, return the first number
        // Since nums1 and nums2 is sorted, the smaller one among the start point of nums1 and nums2 is the first one
        if (k == 1) return Math.min(nums1[start1], nums2[start2]);

        int mid1 = Integer.MAX_VALUE;
        int mid2 = Integer.MAX_VALUE;
        if (start1 + k / 2 - 1 < nums1.length) mid1 = nums1[start1 + k / 2 - 1];
        if (start2 + k / 2 - 1 < nums2.length) mid2 = nums2[start2 + k / 2 - 1];

        // Throw away half of the array from nums1 or nums2. And cut k in half
        if (mid1 < mid2) {
            return getKth(nums1, start1 + k / 2, nums2, start2, k - k / 2); //nums1.right + nums2
        } else {
            return getKth(nums1, start1, nums2, start2 + k / 2, k - k / 2); //nums1 + nums2.right
        }
    }
}
