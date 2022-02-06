package sorting;

public class MergeSort {
    public static void mergeSort(int[] arr, int left, int right) {
        if (right <= left) return;

        int mid = (left+right)/2;

        mergeSort(arr, left, mid);
        mergeSort(arr, mid+1, right);

        merge(arr, left, mid, right);
    }

    static void merge(int[] arr, int left, int mid, int right) {
        // calculating lengths
        int lengthLeft = mid - left + 1;
        int lengthRight = right - mid;

        // creating temporary subarrs
        int leftArr[] = new int [lengthLeft];
        int rightArr[] = new int [lengthRight];

        // copying our sorted subarrs into temporaries
        for (int i = 0; i < lengthLeft; i++)
            leftArr[i] = arr[left+i];
        for (int i = 0; i < lengthRight; i++)
            rightArr[i] = arr[mid+i+1];

        // iterators containing current index of temp subarrs
        int leftIndex = 0;
        int rightIndex = 0;

        // copying from leftArr and rightArr back into arr
        for (int i = left; i < right + 1; i++) {
            // if there are still uncopied elements in R and L, copy minimum of the two
            if (leftIndex < lengthLeft && rightIndex < lengthRight) {
                if (leftArr[leftIndex] < rightArr[rightIndex]) {
                    arr[i] = leftArr[leftIndex];
                    leftIndex++;
                }
                else {
                    arr[i] = rightArr[rightIndex];
                    rightIndex++;
                }
            }
            // if all the elements have been copied from rightArr, copy the rest of leftArr
            else if (leftIndex < lengthLeft) {
                arr[i] = leftArr[leftIndex];
                leftIndex++;
            }
            // if all the elements have been copied from leftArr, copy the rest of rightArr
            else if (rightIndex < lengthRight) {
                arr[i] = rightArr[rightIndex];
                rightIndex++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{10, 2, 35, 1, 0, 99};
        mergeSort(arr, 0, arr.length-1);

        System.out.println("After sorting: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
