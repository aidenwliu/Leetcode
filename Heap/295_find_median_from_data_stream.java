class MedianFinder {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
    /** initialize your data structure here. */
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        if(!minHeap.isEmpty() && num > minHeap.peek()) {
            minHeap.offer(num);
        } else {
            maxHeap.offer(-num);
        }
        if(minHeap.size() - maxHeap.size() == 2) {
            maxHeap.offer(-minHeap.poll());
        } else if (maxHeap.size() - minHeap.size() == 2) {
            minHeap.offer(-maxHeap.poll());
        }
    }
    
    public double findMedian() {
        if (minHeap.size() > maxHeap.size())
            return minHeap.peek();
        if (minHeap.size() < maxHeap.size())
            return -maxHeap.peek();
        
        return (double)(minHeap.peek()-maxHeap.peek())/2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
