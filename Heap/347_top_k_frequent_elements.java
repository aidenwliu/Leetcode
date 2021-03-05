class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if (k == nums.length) return nums;
        
        Map<Integer, Integer> map = new HashMap<>();
        //O(n)
        for (int n : nums) 
            map.put(n, map.getOrDefault(n,0)+1);
        
        Queue<Integer> heap = new PriorityQueue<>(
            (n1,n2) -> map.get(n1)-map.get(n2)
        );
        //O(nlogk) for add & poll
        for (int i : map.keySet()) {
            heap.add(i);
            if (heap.size() > k) 
                heap.poll();
        }
        //O(klogk)
        int[] res = new int[k];
        for (int j = k-1; j >= 0; j--) {
            res[j] = heap.poll();
        }
        return res;
    }
}
//Time: O(nlogk)
//Space: O(n+k). HashMap & heap
