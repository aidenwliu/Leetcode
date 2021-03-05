class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        permute(nums, new ArrayList<>(), res);
        return res;
    }
    
  //Non-primitive return type -> helper method to recurse
    private void permute(int[] nums, List<Integer> cur, List<List<Integer>> res) {
        if (cur.size() == nums.length) {
            res.add(new ArrayList<Integer>(cur)); //deep copy
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (cur.contains(nums[i]))
                continue;
            cur.add(nums[i]);
            permute(nums, cur, res);
            cur.remove(cur.size()-1); //backtracking
        }
    }
}
