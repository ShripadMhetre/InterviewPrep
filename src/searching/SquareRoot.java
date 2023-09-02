package searching;

/*
    Q. Given a non-negative integer x, return the square root of x rounded down to the nearest integer.
        The returned integer should be non-negative as well.
        Note: You must not use any built-in exponent function or operator.

        Example 1:
            Input: x = 4
            Output: 2
            Explanation: The square root of 4 is 2, so we return 2.

        Example 2:
            Input: x = 8
            Output: 2
            Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.
 */
public class SquareRoot {
    public static int mySqrt(int x) {
        if (x <= 1) return x;

        int start = 0, end = x;
        int ans = 0;

        while (start <= end) {
            int mid = start + (end-start)/2;

            if (mid <= x/mid) {
                ans = mid;
                start = mid+1;
            } else {
                end = mid - 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int num = 8;
        System.out.println(mySqrt(num));
    }
}
