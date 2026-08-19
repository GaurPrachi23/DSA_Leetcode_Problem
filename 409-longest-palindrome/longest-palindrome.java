class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        int res = 0;
        boolean odd = false;
        for(int freq : map.values()){
            if(freq % 2 == 0){
                res += freq;
            }else{
                res += freq - 1;
                odd = true;
            }
        }
        if(odd){
            res++;
        }
        return res;
    }
}