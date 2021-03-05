//Time: O(n)
//Space: O(1)
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = 1;
        for (int i = 1; i < res.length; i++) {
            res[i] = nums[i-1]*res[i-1];
        }
        
        int right = 1;
        for (int j = res.length-1; j >= 0; j--) {
            res[j] = right*res[j];
            right *= nums[j];
        }
        
        return res;
    }
}
