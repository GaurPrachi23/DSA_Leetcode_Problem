class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        generate(candidates, target, 0, current, result);
        return result;
    }
    public void generate(int[] candidates, int remaining, int index, List<Integer> current, List<List<Integer>> result){
        if(remaining == 0){
            result.add(new ArrayList<>(current));
            return;
        }
        for(int i = index; i < candidates.length; i++){
            if(candidates[i] > remaining){
                continue;
            }
            current.add(candidates[i]);

            generate(candidates, remaining - candidates[i], i, current, result);
            current.remove(current.size() - 1);
        }
    }

}