package interviews;

/*
    Q. Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
        determine if a person could attend all meetings.

        Example1
        Input: intervals = [(0,30),(5,10),(15,20)]
        Output: false
        Explanation:
        (0,30), (5,10) and (0,30),(15,20) will conflict

        Example2
        Input: intervals = [(5,8),(9,15)]
        Output: true
        Explanation:
        Two times will not conflict
 */

import com.sun.jdi.IntegerValue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Interval {
      int start, end;
      Interval(int start, int end) {
          this.start = start;
          this.end = end;
      }
}

public class MeetingRooms {

    public static boolean canAttendMeetings(List<Interval> intervals) {
        Collections.sort(intervals, (a, b) -> a.start - b.start);

        for (int i = 1; i < intervals.size(); i++) {
            Interval i1 = intervals.get(i-1);
            Interval i2 = intervals.get(i);

            if (i1.end > i2.start) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();

        // returns false
        intervals.add(new Interval(0, 30));
        intervals.add(new Interval(5, 10));
        intervals.add(new Interval(15, 20));

        // returns true
//        intervals.add(new Interval(5, 8));
//        intervals.add(new Interval(9, 15));
//        intervals.add(new Interval(15, 20));

        System.out.println(canAttendMeetings(intervals));
    }
}
