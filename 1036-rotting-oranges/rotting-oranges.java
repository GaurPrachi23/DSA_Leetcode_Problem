class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2){
                    queue.offer(new int[]{i, j});
                }
                if(grid[i][j] ==1){
                    freshCount++;
                }
            }
        }
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        int  time = 0;
        while(!queue.isEmpty() && freshCount > 0){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] current = queue.poll();
                int row = current[0];
                int col = current[1];

                for(int k = 0; k < 4; k++){
                    int nr = row + dr[k];
                    int nc = col + dc[k];
                    if(nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == 1){
                        grid[nr][nc] = 2;
                        freshCount--;
                        queue.offer(new int[] {nr, nc});
                    }
                }
            }
            time++;
        }
        if(freshCount > 0){
            return -1;
        }
        return time;
    }
}