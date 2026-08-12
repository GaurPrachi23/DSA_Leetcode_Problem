class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        
        int currentEnd = intervals[0][1];
        int count = 0;
        for(int i = 1; i < intervals.length; i++){
            int nextStart = intervals[i][0];
            int nextEnd = intervals[i][1];

            if(nextStart < currentEnd){
               count++;

               if(nextEnd < currentEnd){
                currentEnd = nextEnd;
               }
            }
            else{
                currentEnd = nextEnd;
            }
        }
        return count;
    }
}