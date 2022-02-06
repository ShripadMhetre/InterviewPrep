package sorting;

import java.util.Arrays;
/*
    Counting sort is a sorting technique based on keys between a specific range.
    It works by counting the number of objects having distinct key values.
    Then doing some arithmetic to calculate the position of each object in the output sequence.
 */
public class CountingSort {
    public static void countingSort(int[] arr) {
            int arrayLength = arr.length;
            if (arrayLength == 0) return;

            /** find maximum and minimum values **/
            int max = arr[0], min = arr[0];

            for (int i = 1; i < arrayLength; i++) {
                if (arr[i] > max)
                    max = arr[i];
                if (arr[i] < min)
                    min = arr[i];
            }

            int range = max - min + 1;

            int[] count = new int[range];

            /** initialize the occurrence of each element in the count array **/
            for (int i = 0; i < arrayLength; i++)
                count[arr[i] - min]++;

            /** calculate sum of indexes **/
            for (int i = 1; i < range; i++)
                count[i] += count[i - 1];

            /** modify original array according to the sum count **/
            int j = 0;
            for (int i = 0; i < range; i++)
                while (j < count[i])
                    arr[j++] = i + min;
    }

    public static void main(String[] args) {
        int[] arr = {5, 5, 2, 3, 4, 3, 5};

        countingSort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
