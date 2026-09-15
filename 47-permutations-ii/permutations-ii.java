class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        List<Integer> list = new ArrayList<>();
        generate(nums, used, list, result);
        return result;

    }
    public void generate(int[] nums, boolean[] used, List<Integer> list, List<List<Integer>> result){
        if(list.size() == nums.length){
            result.add(new ArrayList(list));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(used[i]){
                continue;
            }
            if(i > 0 && nums[i] == nums[i - 1] && !used[i - 1]){
                continue;
            }

            used[i] = true;
            list.add(nums[i]);

            generate(nums, used, list, result);

            list.remove(list.size() - 1);
            used[i] = false;
        }
    }
}