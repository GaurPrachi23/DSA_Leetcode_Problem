class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            if(st.empty()){
                st.push(s.charAt(i));
                continue;
            }
            if(st.peek() == s.charAt(i)){
                st.pop();
                continue;
            }
            st.push(s.charAt(i));
        }
        StringBuilder res = new StringBuilder();

        for(char ch : st) {
            res.append(ch);
        }

        return res.toString();
    }
}