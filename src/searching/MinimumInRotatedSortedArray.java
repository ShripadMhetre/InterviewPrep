package searching;

public class MinimumInRotatedSortedArray {
    public static int findMin(int[] arr) {
        int l = 0, r = arr.length-1;
        int res = arr[0];

        while (l <= r) {
            if (arr[l] < arr[r]) {
                res = Math.min(res, arr[l]);
                break;
            }

            int mid = l + (r-l)/2;

            res = Math.min(res, arr[mid]);

            if (arr[mid] >= arr[l]) l = mid+1;
            else r = mid-1;
        }

        return res;
    }
    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 6, 1, 2};
        System.out.println("Min Value: " + findMin(arr));
    }
}
