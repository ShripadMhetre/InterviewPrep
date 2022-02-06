package sorting;

public class SelectionSort {
    /*
        In each iteration, we assume that the first unsorted element is the minimum
        and iterate through the rest to see if there's a smaller element.
        Once we find the current minimum of the unsorted part of the array,
        we swap it with the first element and consider it a part of the sorted array.
     */
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            int minIndex = i;

            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    minIndex = j;
                }
            }

            //swaping
            int temp = arr[i];
            arr[i] = min;
            arr[minIndex] = temp;
        }
    }

    public static void main(String[] args) {
            int[] arr = new int[]{10, 2, 35, 1, 0, 99};
            selectionSort(arr);

            System.out.println("After sorting: ");
            for (int i = 0; i < arr.length; i++) {
                System.out.println(arr[i]);
            }
    }
}
