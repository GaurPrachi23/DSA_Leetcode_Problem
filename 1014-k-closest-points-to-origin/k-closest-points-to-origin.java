class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // Arrays.sort(points, (a, b) ->
        // (a[0] * a[0] + a[1] * a[1]) - 
        // (b[0] * b[0] + b[1] * b[1])
        // );

        // int[][] ans = new int[k][2];
        // for(int i = 0; i < k; i++){
        //     ans[i] = points[i];
        // }
        // return ans;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) ->{
            int distA = a[0] * a[0] + a[1] * a[1];
            int distB = b[0] * b[0] + b[1] * b[1];

            return distB - distA;
        });
        for(int[] point : points){
            pq.offer(point);

            if(pq.size() > k){
                pq.poll();
            }
        }

        int[][] res = new int[k][2];
        int i = 0;
        while(!pq.isEmpty()){
            res[i] = pq.poll();
            i++;
        }
        return res;
    }
}