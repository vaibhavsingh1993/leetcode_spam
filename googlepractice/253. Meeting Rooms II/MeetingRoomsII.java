/* Idea is to sort the start and end times of meetings and see the number of times start times come before end times.*/

public class MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        
        for(int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        
        Arrays.sort(start);
        Arrays.sort(end);
        
        int numRooms = 0;
        int endTimes = 0;
        for(int i = 0; i < start.length; i++ ) {
            //System.out.println("start[i] is " + start[i]);
            //System.out.println("end[endTimes] is " + end[endTimes]);
            if(start[i] < end[endTimes]) {
                numRooms++;
            } else {
                endTimes++; // compare with new endtime    
            }
        }
        return numRooms;
    }
}
