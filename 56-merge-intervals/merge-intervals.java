class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int currentStart = intervals[0][0];
        int currentEnd = intervals[0][1];
        ArrayList<int[]> arr = new ArrayList<>(); 
        
        for(int i = 1; i < intervals.length; i++){

           int nextStart = intervals[i][0];
           int nextEnd = intervals[i][1];
            if(nextStart <= currentEnd){
                currentEnd = Math.max(currentEnd, nextEnd);
            }else{
                arr.add(new int[]{currentStart, currentEnd});
                currentStart = nextStart;
                currentEnd = nextEnd;
                
            }
        }
        arr.add(new int[]{currentStart, currentEnd});
        return arr.toArray(new int[arr.size()][]); 
    }
}