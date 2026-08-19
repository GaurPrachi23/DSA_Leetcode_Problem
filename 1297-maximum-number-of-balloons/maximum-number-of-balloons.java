class Solution {
    public int maxNumberOfBalloons(String text) {
        int res = Integer.MAX_VALUE;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < text.length(); i++){
            map.put(text.charAt(i), map.getOrDefault(text.charAt(i), 0) + 1);
        }
            int b = map.getOrDefault('b', 0);
            int a = map.getOrDefault('a', 0);
            int l = map.getOrDefault('l', 0) / 2;          
            int o = map.getOrDefault('o', 0)/ 2;
            int n = map.getOrDefault('n', 0);

            res = Math.min(res, b);
            res = Math.min(res, a);
            res = Math.min(res, l);
            res = Math.min(res, o);
            res = Math.min(res, n);
        
        return res;
    }
}