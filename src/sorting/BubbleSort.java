package sorting;

public class BubbleSort {
    public static void bubbleSort(int[] arr) {
       int n = arr.length;
       boolean swapped = false;

        for (int i = 0; i < n-1; i++) {
            swapped = false;
            for (int j = 0; j < n-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
            }
            // if no element got swapped that means, array is sorted
            if (swapped == false) break;    // this makes Best Case Complexity = O(N)
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{10, 2, 35, 1, 0, 99};
        bubbleSort(arr);

        System.out.println("After sorting: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
