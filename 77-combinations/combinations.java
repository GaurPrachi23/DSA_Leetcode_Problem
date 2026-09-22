class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        generate(current, result, n, k, 1);
        return result;
    }
    public void generate(List<Integer> current, List<List<Integer>> result, int n, int k, int start){
        if(current.size() == k){
            result.add(new ArrayList<>(current));
            return;
        }
        for(int i = start; i <= n; i++){
            current.add(i);
            generate(current , result, n, k, i + 1);
            current.remove(current.size() - 1);

        }
    }
}