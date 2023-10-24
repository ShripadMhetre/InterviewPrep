package heap;

import java.util.PriorityQueue;

/*
    Time Complexity: O(NlogN), Space: O(N)
 */
public class MedianInRunningStreamIntegers {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianInRunningStreamIntegers() {
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        minHeap = new PriorityQueue<>();
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek())/2.0;
        }

        return maxHeap.peek();
    }

    public void insertNum(int num) {
        if (maxHeap.isEmpty() || maxHeap.peek() >= num) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }

        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        } else if (maxHeap.size() < minHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }

    public static void main(String[] args) {
        MedianInRunningStreamIntegers stream = new MedianInRunningStreamIntegers();
        stream.insertNum(3);
        stream.insertNum(1);

        System.out.println(stream.findMedian());

        stream.insertNum(5);
        stream.insertNum(4);

        System.out.println(stream.findMedian());
    }
}
