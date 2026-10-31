class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]> [] graph = new ArrayList[n + 1];
        for(int i = 1; i <= n ; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] t : times){
            graph[t[0]].add(new int[]{t[1], t[2]});
        }
        int [] dist = new int[n+ 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> Integer.compare(a[0], b[0])
        );
        pq.offer(new int[]{0, k});

        while(!pq.isEmpty()){
            int[] current = pq.poll();
            int d= current[0];
            int node = current[1];
            if(d > dist[node]){
                continue;
            }
            for(int[] edge : graph[node]){
                int neighbour = edge[0];
                int weight = edge[1];
                int newDistance = d + weight;
                if(newDistance < dist[neighbour]){
                    dist[neighbour] = newDistance;
                    pq.offer(new int[] {newDistance, neighbour});
                }
            }
        }
        int ans = 0;
        for(int i = 1; i <= n; i++){
            if(dist[i] == Integer.MAX_VALUE){
                return -1;
            }
            ans = Math.max(ans, dist[i]);
        }return ans; 
    }
}