class Solution {
    public int lengthOfLIS(int[] nums) {
    //     return solve(0, -1, nums);
    // }
    // public int solve(int index, int prevIndex, int[] nums){
    //     if(index == nums.length){
    //         return 0;
    //     }
    //     int skip = solve(index + 1, prevIndex, nums);
    //     int take = 0;
    //     if(prevIndex == -1 || nums[index] > nums[prevIndex]){
    //         take = 1 + solve(index + 1, index, nums);
    //     }

    //     return Math.max(take, skip);
        int[][] dp = new int[nums.length + 1][nums.length + 1];
        for(int i = nums.length - 1; i >= 0; i--){
            for(int j = i - 1; j >= -1; j--){
                int skip = dp[i + 1][j + 1];
                int take = 0;
                if(j == -1 || nums[i] > nums[j]){
                    take = 1 + dp[i + 1][i + 1];
                }
                dp[i][j + 1] = Math.max(take, skip);
            }
        }
        return dp[0][0];
    }
}