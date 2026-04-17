class Solution {
    public int lengthOfLongestSubstring(String s) {
        int low = 0, maxlen = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for(int high = 0; high < s.length(); high++){
            char ch = s.charAt(high);
            

            if(map.containsKey(ch)){
                low = Math.max(low, map.get(ch) + 1);
            }
            map.put(ch, high);
            int len = high - low + 1;
            maxlen = Math.max(maxlen, len);
        }
        return maxlen;
    }
}