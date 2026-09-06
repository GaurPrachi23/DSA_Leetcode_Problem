class Solution {
    public int findKthNumber(int m, int n, int k) {
        // ArrayList<Integer> list = new ArrayList<>();
        // for(int i = 1; i <= m; i++){
        //     for(int j = 1; j <= n; j++){
        //         list.add(i * j);
        //     }
        // }
        // Collections.sort(list);
        // return list.get(k - 1);
        int low = 1;
        int high = m * n;
        while(low < high){
            int mid = low + (high - low) / 2;
            int count = 0;
            for(int i = 1; i <= m; i++){
                 count += Math.min(n, mid / i);
            }
            if(count < k){
                low = mid + 1;
            }else{
                high = mid;
            }
        }
        return low;
    }
}