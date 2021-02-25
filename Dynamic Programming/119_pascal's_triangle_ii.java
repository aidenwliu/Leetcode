class Solution {
    public List<Integer> getRow(int rowIndex) { //DP
        List<Integer> res = new ArrayList<>(rowIndex+1) {
            {
                add(1);
            }
        };
        
        for (int i = 0; i < rowIndex; i++) {
            for (int j = i; j > 0; j--) {
                res.set(j, res.get(j-1)+res.get(j));
            }
            res.add(1);
        }
        
        return res;
    }
}
