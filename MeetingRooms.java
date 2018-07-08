package LeetCode.searchingAndSorting;

import java.util.Arrays;

public class MeetingRooms {
	public static void main(String[] args) {
		Interval interval1 = new Interval(13,15);
		Interval interval2= new Interval(1,13);
		Interval interval3 = new Interval(6,9);
		Interval[] intervals = {interval1, interval2, interval3};
		System.out.println(minMeetingRooms(intervals));
	}

	public static int minMeetingRooms(Interval[] intervals) {
		if(intervals.length<1)
			return 0;
		int rooms=0;
		int maxRooms = Integer.MIN_VALUE;
		int[] starts = new int[intervals.length];
		int[] ends = new int[intervals.length];
		int index = 0;
		for(Interval interval:intervals) {
			starts[index]=interval.start;
			ends[index]=interval.end-1;
			index++;
		}
		Arrays.sort(starts);
		Arrays.sort(ends);
		int startsIndex=0, endsIndex=0;
		while(startsIndex<starts.length&&endsIndex<ends.length) {
			if(starts[startsIndex]<=ends[endsIndex]) {
				rooms++;	
				System.out.println(rooms);
				if(rooms>maxRooms) {
					maxRooms=rooms;
				}
				startsIndex++;
			}else {
				rooms--;
				endsIndex++;
			}
		}
		
		return maxRooms;
	}
	public static int minMeetingRoomsunSorted(Interval[] intervals) {
		int maxStart=intervals[0].start;
		int minEnd = intervals[0].end;
		int rooms = 1, maxRooms = Integer.MIN_VALUE;
		for(int i=1;i<intervals.length;i++) {
			if(intervals[i].start>maxStart&&intervals[i].start<minEnd) {
				rooms++;
				maxStart = intervals[i].start;
				minEnd=Math.min(minEnd,intervals[i].end);
			}else {
				
			}
		}
		return 0;
		
	}

}



class Interval {
	int start;
	int end;
	Interval() { start = 0; end = 0; }
	Interval(int s, int e) { start = s; end = e; }
}
