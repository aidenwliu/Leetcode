class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>(); //index
        
        for (int i = 0; i < n*2; i++) { //traverse circular array
            int num = nums[i%n];
            while (!stack.isEmpty() && nums[stack.peek()] <num) {
                res[stack.peek()] = num;
                stack.pop();
            }
            if (i<n)
                stack.push(i);
        }
        return res;
    }
}
