class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits.length() == 0){
            return result;
        }
        StringBuilder current = new StringBuilder();
        String[] mapping = {
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };
        backtrack(digits, 0, current, result, mapping);
        return result;
    }
    public void backtrack(String digits, int index, StringBuilder current, List<String> result, String[] mapping){
        if(index == digits.length()){
            result.add(current.toString());
            return;
        }
        char digit = digits.charAt(index);
        String letters = mapping[digit - '0'];
        for(int i = 0; i < letters.length(); i++){
            char ch = letters.charAt(i);
            current.append(ch);

            backtrack(digits, index + 1, current, result, mapping);
            current.deleteCharAt(current.length() - 1);
        }
        
    }
}