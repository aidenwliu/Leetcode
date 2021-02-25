class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        if (numRows == 0) return ans;
        ans.add(new ArrayList<>());
        ans.get(0).add(1);
        
        for (int i = 1; i < numRows; i++) {
            List<Integer> cur = new ArrayList<>();
            List<Integer> prev = ans.get(i-1);
            
            cur.add(1);
            for (int j = 1; j < i; j++) {
                cur.add(prev.get(j-1)+prev.get(j));
            }
            cur.add(1);
            ans.add(cur);
        }
        return ans;
    }
}
