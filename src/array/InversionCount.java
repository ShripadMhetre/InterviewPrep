package array;

/*
    Q. Given an array, calculate the inversion count of the array.
        Note:
            - The inversion count of an array denotes how far is the array from being sorted.
            - If the array is sorted, inversion count is 0. If the array is sorted in reverse order, the inversion count is maximum.
            - More formally, the inversion count of an array A is the number of pairs (i, j) such A[i] < A[j] and i > j.

        Example:
            Lets take the following array: 8, 4, 1, 2

            This array has an inversion count of 5.
            (8, 4), (8, 1), (8, 2), (4, 1), (4, 2)
 */
public class InversionCount {
    static int merge(int[] arr, int low, int mid, int high) {
        int n1 = mid - low + 1;
        int n2 = high - mid;

        int[] a1 = new int[n1];
        int[] a2 = new int[n2];

        for (int i = 0; i < n1; i++) {
            a1[i] = arr[low+i];
        }

        for (int i = 0; i < n2; i++) {
            a2[i] = arr[mid+1+i];
        }

        int i = 0, j = 0, k = 0, inversions = 0;
        while (i < n1 && j < n2) {
            // if 1st subarray element is <= 2nd subarray element then no inversion required
            if (a1[i] <= a2[j]) {
                arr[low + k] = a1[i];
                i++;
            } else {
                arr[low + k] = a2[j];
                j++;
                //  if a1[i] > a2[j] then all the elements of a1 after ith index would also be greater than a2[j]
                // Hence total inversions required would be difference between start index of a2 and curr index of a1.
                inversions += mid + 1 - (low+i);
            }
            k++;
        }

        while (i < n1) {
            arr[low + k++] = a1[i++];
        }

        while (j < n2) {
            arr[low + k++] = a2[j++];
        }
        return inversions;
    }

    static int mergeSort(int[] arr, int low, int high) {
        int inversions = 0;

        if (low < high) {
            int mid = low + (high-low)/2;
            inversions += mergeSort(arr, low, mid);
            inversions += mergeSort(arr, mid+1, high);
            inversions += merge(arr, low, mid, high);
        }

        return inversions;
    }

    public static void main(String[] args) {
        int[] arr = {8, 4, 1, 2};
        int count = mergeSort(arr, 0, arr.length-1);
        System.out.println("Inversion Count: " + count);
    }
}
