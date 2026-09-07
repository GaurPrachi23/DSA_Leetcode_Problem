class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String word : words){
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<Map.Entry<String, Integer>> pq = 
            new PriorityQueue<>((a, b) -> {
                if(!a.getValue().equals(b.getValue())){
                    return a.getValue() - b.getValue();
                }
                return b.getKey().compareTo(a.getKey());
            }
            
        );
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.offer(entry);
            if(pq.size() > k){
                pq.poll();
            }
        }
        ArrayList<String> result = new ArrayList<>();
        while (!pq.isEmpty()){
            result.add(pq.poll().getKey());
        }
        Collections.sort(result, (a, b) -> {

            if (!map.get(a).equals(map.get(b))) {
                return map.get(b) - map.get(a);
            }

            return a.compareTo(b);
        });

        return result;
    }
}