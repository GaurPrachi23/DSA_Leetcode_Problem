class Solution {
    public int climbStairs(int n) {
        if(n <= 2){
            return n;
        }
        // return climbStairs(n - 1) + climbStairs(n - 2);
        int a = 1;
        int b = 2;
        for(int i = 3; i <= n; i++){
            int curr = a + b;
            a = b;
            b = curr;
        }
        return b;
    }
}