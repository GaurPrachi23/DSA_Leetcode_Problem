class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int iniColor = image[sr][sc];
        if(iniColor != color){
            dfs(image, sr, sc, iniColor, color);
        }
        return image;
    }
    public void dfs(int[][] image, int x, int y, int iniColor, int color){
        if(x < 0 || x >= image.length || y < 0 || y >= image[0].length || image[x][y] != iniColor){
            return;
        }
        image[x][y] = color;
        dfs(image, x - 1, y, iniColor, color);
        dfs(image, x + 1, y, iniColor, color);
        dfs(image, x, y - 1, iniColor, color);
        dfs(image, x, y + 1, iniColor, color);
    }
}