package Greedy;

import java.util.*;

public class MergeIntervals {
    private class IntervalComparator implements Comparator<Interval>{
        public int compare(Interval a, Interval b){
            return a.start-b.start;
        }
    }
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size() <= 1) return intervals;
        List<Interval> result = new ArrayList<Interval>();
        Collections.sort(intervals, new IntervalComparator());
        result.add(intervals.get(0));
        for(int i = 1; i < intervals.size(); i++){
            Interval tmp = result.get(result.size()-1);
            if(tmp.end < intervals.get(i).start)
                result.add(intervals.get(i));
            else {
                if(tmp.end < intervals.get(i).end)
                    tmp.end = intervals.get(i).end;
            }
        }
        return result;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        List<Interval> intervals = new ArrayList<Interval>();
        for(int i = 0; i < len; i++)
            intervals.add(new Interval(sc.nextInt(),sc.nextInt()));
        MergeIntervals sl = new MergeIntervals();
        sl.merge(intervals);
    }
}
