class Solution { 
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b)->Integer.compare(a[0],b[0])); //O(nlogn)
        LinkedList<int[]> merged = new LinkedList<>();
        for (int[] x : intervals) {
            if (merged.isEmpty() || merged.getLast()[1] < x[0]) {
                merged.add(x);
            } else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], x[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
