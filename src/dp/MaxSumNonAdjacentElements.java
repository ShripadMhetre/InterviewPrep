package dp;

/**
 *  Given an array of positive numbers, find the maximum sum of a subsequence with the constraint
 *  that no 2 numbers in the sequence should be adjacent in the array.
 */
public class MaxSumNonAdjacentElements {
    public static int solution(int[] arr) {
        int n = arr.length;
        int inc = arr[0];   // sum including current element
        int exc = 0;        // sum excluding current element

        for (int i = 2; i < n; i++) {
            int newInc = exc + arr[i];  // sum including curr element will be max sum excluding prev element plus curr element.
            int newExc = Math.max(inc, exc);    // new excluding will be max of previous inc and exc sum.

            inc = newInc;
            exc = newExc;
        }

        int ans = Math.max(inc, exc);   // Final max sum answer will be max of inc and exc.

        return ans;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{6, 5, 10, 10, 100, 5, 6};
        System.out.println(solution(arr));
    }
}
