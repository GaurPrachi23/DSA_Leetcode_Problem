class Solution {
    public int fib(int n) {
        // if(n == 0){
        //     return 0;
        // }
        // if(n == 1){
        //     return 1;
        // }
        // return fib(n - 1) + fib(n - 2);
        // if(n <= 1){
        //     return n;
        // }
        // int f[] = new int[n + 1];
        // f[0] = 1;
        // f[1] = 1;
        // for(int i = 2; i < n; i++){
        //     f[i] = f[i - 1] + f[i - 2];
        // }
        // return f[n - 1];
        if(n <= 1){
            return n;
        }
        int a = 0;
        int b = 1;
        for(int i = 2; i <= n; i++){
            int curr = a + b;
            a = b;
            b = curr;
           
        }
        return b;
     }
}