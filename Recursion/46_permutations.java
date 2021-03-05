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
//Time complexity: O(n!)
// in the first level of the tree, you have N options,
// and for each of the option, you have N-1 option, 
// and for each of these N-1 options, you have another N-2 options, 
// so putting them together you would end up N*(N-1)*(N-2).... = N!
//Space complexity: O(n!)
