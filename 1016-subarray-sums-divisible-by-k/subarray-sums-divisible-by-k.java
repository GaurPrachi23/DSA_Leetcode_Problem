class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int prefixSum = 0;
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for(int i = 0; i < nums.length; i++){
            prefixSum += nums[i];
            int rem = prefixSum % k;
            if(rem < 0){
                rem += k;

            }
            if(map.containsKey(rem)){
                ans += map.get(rem);
            }
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }
        return ans;
    }
}