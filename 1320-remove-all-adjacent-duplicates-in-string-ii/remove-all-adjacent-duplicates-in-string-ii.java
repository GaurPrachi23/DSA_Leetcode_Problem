class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Character> st = new Stack<>();
        Stack<Integer> count = new Stack<>(); 
        for(int i = 0; i < s.length(); i++){
            if(st.empty()){
                st.push(s.charAt(i));
                count.push(1);
                continue;
            }
            if(st.peek() == s.charAt(i)){
                count.push(count.pop() + 1);
                if(count.peek() == k){
                    st.pop();
                    count.pop();
                }
                continue;
            }
            st.push(s.charAt(i));
            count.push(1);
            
        }
        StringBuilder res = new StringBuilder();

        for(int i = 0; i < st.size(); i++){
            for(int j = 0; j < count.get(i); j++){
                res.append(st.get(i));
            }
        }

        return res.toString();
    }
}