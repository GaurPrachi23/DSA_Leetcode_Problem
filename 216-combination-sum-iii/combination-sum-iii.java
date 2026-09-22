class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        generate(current, result, k, n, 1);
        return result;
    }
    public void generate(List<Integer> current, List<List<Integer>> result, int k, int remaining, int start){
        if(remaining < 0){
            return;
        }
        if(current.size() == k && remaining == 0){
            //if(remaining == 0){
            result.add(new ArrayList<>(current));
            //}
            return;
        }
        for(int i = start; i <= 9; i++){
            current.add(i);
            remaining -= i;
            generate(current, result, k, remaining, i + 1);
            remaining += i;
            current.remove(current.size() - 1);
        }
    }
}