//Time Complexity: O(nlogk)
class Solution { 
    public int findKthLargest(int[] nums, int k) {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            public int compare(Integer a, Integer b){
                return a-b;
            }
        };
        PriorityQueue<Integer> minHeap = new PriorityQueue(k, comparator);
        for (int i = 0; i < k; i++){
            minHeap.add(nums[i]);
        }
        for (int i = k; i < nums.length; i++){
            if (nums[i] >= minHeap.peek()){
                minHeap.poll();
                minHeap.add(nums[i]);
            }
        }
        return minHeap.poll();
    }
}

//Better solution: Half QuickSort with O(n) Time Complexity.
