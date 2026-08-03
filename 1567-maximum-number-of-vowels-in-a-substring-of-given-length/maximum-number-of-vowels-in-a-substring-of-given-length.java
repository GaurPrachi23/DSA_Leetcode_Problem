class Solution {
    public int maxVowels(String s, int k) {
        int count = 0;
        int maxcount;
        
        for(int i = 0; i < k; i++){
            char ch = s.charAt(i);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                count++;
            }
            
        }
         maxcount = count;
        for(int i = k; i < s.length(); i++){
            char inCh = s.charAt(i);
            if(inCh == 'a' || inCh == 'e' || inCh == 'i' || inCh == 'o' || inCh == 'u'){
                
                count++;
            }
            char outCh = s.charAt(i - k);
            if(outCh == 'a' || outCh == 'e' || outCh == 'i' || outCh == 'o' || outCh == 'u'){
                
                count--;
            }
            maxcount = Math.max(maxcount, count);
        }

        return maxcount;
    }
}