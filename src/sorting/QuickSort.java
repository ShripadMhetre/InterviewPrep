package sorting;

public class QuickSort {
    /*
        Quicksort is another Divide and Conquer algorithm. It picks one element of an array as the pivot
        and sorts all the other elements around it, for example smaller elements to the left, and larger to the right.
        This guarantees that the pivot is in its proper place after the process.
        Then the algorithm recursively does the same for the left and right portions of the array.
     */
    static int partition(int[] array, int begin, int end) {
        int pivot = end;

        int counter = begin;
        for (int i = begin; i < end; i++) {
            if (array[i] < array[pivot]) {
                int temp = array[counter];
                array[counter] = array[i];
                array[i] = temp;
                counter++;
            }
        }
        int temp = array[pivot];
        array[pivot] = array[counter];
        array[counter] = temp;

        return counter;
    }

    public static void quickSort(int[] array, int begin, int end) {
        if (end <= begin) return;
        int pivot = partition(array, begin, end);
        quickSort(array, begin, pivot-1);
        quickSort(array, pivot+1, end);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{10, 2, 35, 1, 0, 99};
        quickSort(arr, 0, arr.length-1);

        System.out.println("After sorting: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
