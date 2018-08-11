import java.util.*;

/**
 * https://leetcode.com/problems/merge-intervals/description/
 *
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * Example 1:
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 *
 * Example 2:
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 */

public class MergeIntervals {

    public static void main(String[] args) {
        MergeIntervals mergeIntervals = new MergeIntervals();
        List<Interval> intervals = mergeIntervals.getList();
        List<Interval> mergedList = mergeIntervals.merge(intervals);
        System.out.print("");
    }

    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new IntComparator());
        LinkedList<Interval> retList = new LinkedList<>();
        for(Interval interval : intervals) {
            if(retList.isEmpty() || retList.getLast().end < interval.start) {
                retList.add(interval);
            } else {
                retList.getLast().end = Math.max(interval.end, retList.getLast().end);
            }
        }
        return retList;
    }

    private class IntComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval a, Interval b) {
            return a.start < b.start ? -1 : a.start == b.start ? 0 : 1;
        }
    }

    public List<Interval> getList() {
        List<Interval> intervals = new ArrayList<>();
        Interval interval1 = new Interval(1, 4);
        Interval interval2 = new Interval(4, 5);
//        Interval interval3 = new Interval(8, 10);
//        Interval interval4 = new Interval(15, 18);
        intervals.add(interval1);
        intervals.add(interval2);
//        intervals.add(interval3);
//        intervals.add(interval4);
        return intervals;
    }

    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            this.start = s;
            this.end = e;
        }
    }

}
