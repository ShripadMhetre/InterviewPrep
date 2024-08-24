package interviews;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    Q. Given an array of meeting time interval objects consisting of start and end times
    [[start_1,end_1],[start_2,end_2],...] (start_i < end_i), find the minimum number of days required to
    schedule all meetings without any conflicts.

    Example 1:
    Input: intervals = [(0,40),(5,10),(15,20)]
    Output: 2
    Explanation:
    day1: (0,40)
    day2: (5,10),(15,20)

    Example 2:
    Input: intervals = [(4,9)]
    Output: 1
    Note:
    (0,8),(8,10) is not considered a conflict at 8
 */
public class MeetingRoomsII {
    public static int solution(List<Interval> intervals) {
        if (intervals.isEmpty()) return 0;

        int N = intervals.size();
        int[] startTime = new int[N];
        int[] endTime = new int[N];

        for (int i = 0; i < N; i++) {
            startTime[i] = intervals.get(i).start;
            endTime[i] = intervals.get(i).end;
        }

        Arrays.sort(startTime);
        Arrays.sort(endTime);

        int res = 0;    // max no. of concurrent meetings i.e. our ans
        int count = 0;  // no. of meetings running currently
        int s = 0;
        int e = 0;

        while (s < N) {
            if (startTime[s] < endTime[e]) {
                s++;
                count++;
            } else {
                e++;
                count--;
            }
            res = Math.max(res, count);
        }

        return res;
    }

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();

        // 2 rooms required
        intervals.add(new Interval(0, 30));
        intervals.add(new Interval(5, 10));
        intervals.add(new Interval(15, 20));

        int ans = solution(intervals);
        System.out.println(ans);
    }
}
