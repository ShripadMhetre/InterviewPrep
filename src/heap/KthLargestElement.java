package heap;

import java.util.PriorityQueue;

/*
    Q. Given a list of numbers, find the kth largest element in the list.
 */
public class KthLargestElement {
    public static int getKthLargestElement(int[] list, int k) {
        // Min Heap of size k
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

        // Iterate over list elements and add to min heap.
        for (int num: list) {
            minHeap.add(num);

            // If size of min heap becomes greater than k remove (i.e. poll) the minimum element.
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }
        // minimum of final k elements present in the min heap will be Kth largest
        return minHeap.poll();
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 6, 4, 1};
        int k = 3;
        System.out.println("Kth largest element: " + getKthLargestElement(arr, k));
    }
}
