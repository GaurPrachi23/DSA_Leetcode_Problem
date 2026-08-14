class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        int newStart = newInterval[0];
        int newEnd = newInterval[1];

        ArrayList<int[]> ans = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {

            int currentStart = intervals[i][0];
            int currentEnd = intervals[i][1];

            
            if (currentEnd < newStart) {
                ans.add(new int[]{currentStart, currentEnd});
            }

            
            else if (currentStart > newEnd) {

                ans.add(new int[]{newStart, newEnd});

                
                for (int j = i; j < intervals.length; j++) {
                    ans.add(intervals[j]);
                }

                return ans.toArray(new int[ans.size()][]);
            }

            
            else {
                newStart = Math.min(newStart, currentStart);
                newEnd = Math.max(newEnd, currentEnd);
            }
        }

        
        ans.add(new int[]{newStart, newEnd});

        return ans.toArray(new int[ans.size()][]);
    }
}