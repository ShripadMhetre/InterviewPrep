package interviews;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    Q. You are given an array of non-overlapping intervals intervals where intervals[i] = [start_i, end_i] represents the
    start and the end time of the ith interval. intervals is initially sorted in ascending order by start_i.
    You are given another interval newInterval = [start, end].
    Insert newInterval into intervals such that intervals is still sorted in ascending order by start_i and
    also intervals still does not have any overlapping intervals. You may merge the overlapping intervals if needed.
    Return intervals after adding newInterval.

    Note: Intervals are non-overlapping if they have no common point. For example, [1,2] and [3,4] are non-overlapping,
    but [1,2] and [2,3] are overlapping.

    Example 1:
    Input: intervals = [[1,3],[4,6]], newInterval = [2,5]
    Output: [[1,6]]

    Example 2:
    Input: intervals = [[1,2],[3,5],[9,10]], newInterval = [6,7]
    Output: [[1,2],[3,5],[6,7],[9,10]]
 */
public class InsertNewInterval {
    public static int[][] solution(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        int N = intervals.length;

        int i = 0;
        // first add all the intervals ending before new intervals start
        while (i < N && intervals[i][1] < newInterval[0]) {
            ans.add(intervals[i]);
            i++;
        }

        // then merge the overlapping intervals
        while (i < N && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        // add the big merged interval
        ans.add(newInterval);

        // then add remaining intervals coming after the newInterval's timeframe
        while (i < N) {
            ans.add(intervals[i]);
            i++;
        }

        // create final result array
        int[][] res = new int[ans.size()][2];
        for (int j = 0; j < ans.size(); j++) {
            res[j][0] = ans.get(j)[0];
            res[j][1] = ans.get(j)[1];
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] intervals = {
//                {1, 2},
//                {3, 5},
//                {9, 10},
                {1, 3},
                {4, 6},
        };

        int[] newInterval = {2, 5};

        int[][] res = solution(intervals, newInterval);
        System.out.println(Arrays.deepToString(res));
    }
}
