//Sol 1. Recursion w memoization
class Solution {
    Map<Integer, Integer> memo = new HashMap<>();
    public int numDecodings(String s) {
        return helper(0, s);
    }
    
    private int helper(int idx, String str) {
        if (memo.containsKey(idx))
            return memo.get(idx);
        
        //terminating cases
        if (idx == str.length()) return 1;
        if (str.charAt(idx) == '0') return 0;
        if (idx == str.length()-1) return 1;
        
        int res = helper(idx+1, str);
        if (Integer.parseInt(str.substring(idx, idx+2))<=26)
            res += helper(idx+2, str);
        
        memo.put(idx, res);
        return res;
    }
}
//Sol 2. 1D DP Iteration
class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        
        dp[1] = s.charAt(0) == '0'? 0:1;
        
        for (int i = 2; i < dp.length; i++) {
            if (s.charAt(i-1)!='0') dp[i] = dp[i-1];
            
            int twoDig = Integer.valueOf(s.substring(i-2, i));
            if (twoDig >= 10 && twoDig <= 26) {
                dp[i] += dp[i-2];
            }
        }
        return dp[s.length()];
    }
}
//Sol 3. DP Iteration Optimized; Space Complexity: O(1)
class Solution {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') return 0;
        
        int n = s.length();
        int oneBack = 1;
        int twoBack = 1;
        
        for (int i = 1; i < n; i++) {
            int cur = 0;
            if (s.charAt(i) != '0') cur = oneBack;
            int twoDig = Integer.valueOf(s.substring(i-1,i+1));
            if (twoDig >= 10 && twoDig <= 26) cur += twoBack;
            twoBack = oneBack;
            oneBack = cur;
            
        }
        return oneBack;
    }
}
