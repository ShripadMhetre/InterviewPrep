package searching;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = { 4, 5, 6, 7, 8, 9, 11, 22};
        int num = 7;
        int ans = search(arr, num);
        if (ans == -1) {
            System.out.println(num + " not present in the array...");
        } else {
            System.out.println("Index of " + num + "= " + ans);
        }
    }

    private static int search(int[] arr, int num) {
        int low = 0, high = arr.length-1;
        while (low <= high) {
            int mid = low + (high-low)/2;

            if (arr[mid] == num) return mid;
            else if (arr[mid] < num) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return -1;
    }
}
