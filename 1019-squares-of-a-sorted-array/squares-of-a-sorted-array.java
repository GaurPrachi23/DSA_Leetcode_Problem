class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        List<Integer> neg = new ArrayList<>();
        List<Integer> pos = new ArrayList<>();

        // Step 1: Split negative & positive
        for(int num : nums){
            if(num < 0){
                neg.add(num);
            } else {
                pos.add(num);
            }
        }

        // Step 2: Square values
        for(int i = 0; i < neg.size(); i++)
            neg.set(i, neg.get(i) * neg.get(i));

        Collections.reverse(neg);

        for(int i = 0; i < pos.size(); i++)
            pos.set(i, pos.get(i) * pos.get(i));

        // Step 3: Merge
        int i = 0, j = 0, id = 0;
        int n1 = neg.size(), n2 = pos.size();
        int[] res = new int[n1 + n2];

        while(i < n1 && j < n2){
            if(neg.get(i) <= pos.get(j)){
                res[id++] = neg.get(i++);
            } else {
                res[id++] = pos.get(j++);
            }
        }

        while(i < n1)
            res[id++] = neg.get(i++);

        while(j < n2)
            res[id++] = pos.get(j++);

        return res;
    }
}