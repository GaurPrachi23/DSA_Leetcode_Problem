class Solution {
    public int characterReplacement(String s, int k) {
        int low = 0, INT_MIN = 0;
        int[] freq = new int[26];
        int maxfreq = 0;
        for(int high = 0; high < s.length(); high++){
            freq[s.charAt(high) - 'A']++;

            maxfreq = Math.max(maxfreq,freq[s.charAt(high) - 'A']);
            
            if(high - low + 1 - maxfreq > k){
                freq[s.charAt(low) - 'A']--;
                low++;
            }
            INT_MIN = Math.max(INT_MIN, high - low + 1);
        }
        return INT_MIN;
    }
}