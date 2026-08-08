class Solution {
    public int findMaxLength(int[] nums) {
        int maxLen = 0;
        int currentSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0 , -1);
        for(int i= 0; i < nums.length; i++){
            if(nums[i] == 0){
                currentSum--;
            }else{
                currentSum++;
            }

            if(map.containsKey(currentSum)){
                int firstIndex = map.get(currentSum);
                maxLen = Math.max(maxLen, i - firstIndex);
            }else{
                map.put(currentSum, i);
            }
        }
        return maxLen;
    }
}