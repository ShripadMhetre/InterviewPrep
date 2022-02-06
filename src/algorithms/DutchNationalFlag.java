package algorithms;

import java.util.Arrays;

/**
 *  Dutch National Flag Algorithm :-
 *      Sort an array of 0's 1's & 2's
 */
public class DutchNationalFlag {

    public static void main(String[] args) {
        int[] arr = {2, 0, 0, 2, 1, 0, 1, 0, 0};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr) {
        int low = 0, mid = 0, high = arr.length - 1;

        while (mid <= high) {
            if (arr[mid] == 0) {
                int temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;

                low++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else {
                int temp = arr[high];
                arr[high] = arr[mid];
                arr[mid] = temp;

                high--;
            }
        }
    }
}
