package array;

import java.util.Arrays;

/*
    Q. Given an array of intervals where intervals[i] = [starti, endi],
        return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

        Example 1:
        Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
        Output: 1
        Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.

        Example 2:
        Input: intervals = [[1,2],[1,2],[1,2]]
        Output: 2
        Explanation: You need to remove two [1,2] to make the rest of the intervals non-overlapping.

        Example 3:
        Input: intervals = [[1,2],[2,3]]
        Output: 0
        Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
 */
public class NonOverlappingIntervals {

    public static int eraseOverlapIntervals(int[][] intervals) {
        // Sort the intervals based on start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int prevEnd = intervals[0][1];
        int ans = 0;

        for (int i = 1; i < intervals.length; i++) {
            // if start time equals/greater than prevEnd means not overlapping
            if (intervals[i][0] >= prevEnd) {
                prevEnd = intervals[i][1];
            } else {
                ans++;  // incrementing count of answer when overlapping
                prevEnd = Math.min(prevEnd, intervals[i][1]);   // keeping the interval which has smaller endTime
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};

        int ans = eraseOverlapIntervals(intervals);

        System.out.println("No. of erased intervals: " + ans);
    }
}
