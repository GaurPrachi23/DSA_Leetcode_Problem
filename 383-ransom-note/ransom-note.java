class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> have = new HashMap<>();
        HashMap<Character, Integer> need = new HashMap<>();

        for(int i = 0; i < ransomNote.length(); i++){
            char ch = ransomNote.charAt(i);
            have.put(ch, have.getOrDefault(ch, 0)+ 1);
        }
        for(int i = 0; i < magazine.length(); i++){
            char ch = magazine.charAt(i);
            need.put(ch, need.getOrDefault(ch, 0)+ 1);
        }
        for(char ch : have.keySet()){
            int countInNote = have.get(ch);
            int countInMag = need.getOrDefault(ch, 0);

            if(countInMag < countInNote){
                return false;
            }
        }

        return true;
    }
}