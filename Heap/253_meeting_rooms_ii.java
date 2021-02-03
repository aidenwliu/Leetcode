class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0)
            return 0; 
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){ 
                return a[0]-b[0];
            } 
        });
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); 
        int room = 0;
        for (int i = 0; i < intervals.length; i++){                   
            minHeap.offer(intervals[i][1]);
            if (intervals[i][0] < minHeap.peek()){
                room++; 
            } else {
                minHeap.poll(); 
            }
        }
        return room;
    }
}
