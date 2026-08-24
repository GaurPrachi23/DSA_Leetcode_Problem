class Solution {
    public int maxTurbulenceSize(int[] arr) {
        if(arr.length == 1){
            return 1;
        }
    
        int length = 1;
        int ans = 1;
        int prev = 0;
        for(int i = 1; i < arr.length; i++){
            int curr;

            if(arr[i] > arr[i-1])
                curr = 1;
            else if(arr[i] < arr[i-1])
                curr = -1;
            else{
                curr = 0;
            }
                
            if(curr == 0){
                length = 1;
            }
                
            else if(curr != prev){
                length++;
            }else{
                length = 2;
            }
            ans = Math.max(ans, length);
            prev = curr;
        }
        return ans;
    }
}