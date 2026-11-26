class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
    //    int n = text1.length();
    //    int m = text2.length();
    //    int[][] dp = new int[n + 1][m + 1];
    //    for(int i = n - 1; i >=0; i--){
    //         for(int j = m - 1; j >= 0; j--){
    //             if(text1.charAt(i) == text2.charAt(j)){
    //                 dp[i][j] = 1 + dp[i + 1][j + 1];
    //             }
    //             else{
    //                 dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
    //             }
    //         }
    //    }
    //    return dp[0][0];
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n][m];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return solve(text1, text2, 0, 0, dp);
    }
    public int solve(String s1, String s2, int i, int j, int[][] dp){
        if(i == s1.length() || j == s2.length()){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = 1 + solve(s1, s2, i + 1, j + 1, dp);
        }
        
        return dp[i][j] = Math.max(solve(s1, s2, i + 1, j, dp),
                                   solve(s1, s2, i, j + 1, dp)
        );
        
    }
}