/* Sol_1.
   Recursion */
class Solution {
    public int climbStairs(int n) {
        int[] memo = new int[n+1];
        return helper(0, n, memo);
    }

    public int helper(int i, int n, int memo[]){
        if (i > n) return 0; //base
        if (i == n) return 1; //base
        if (memo[i] > 0) return memo[i];
        memo[i] = helper(i+1, n, memo)+helper(i+2, n, memo);
        return memo[i];
    }
}
//Time Complexity: O(n)
//Space Complexity: O(n)

/* Sol_2.
   Dynamic Programming */
class Solution {
    public int climbStairs(int n) {
        if (n==1) return 1;
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
//Time Complexity: O(n)
//Space Complexity: O(n)

/* Sol_3.
   Fib (vs. Sol_2. DP) */
class Solution {
    public int climbStairs(int n) {
        if (n==1) return 1;
        int first = 1;
        int sec = 2;
        for (int i = 3; i <= n; i++){
           int third = first + sec;
           first = sec;
           sec = third;
        }
        return sec;
    }
}
//Time Complexity: O(n)
//Space Complexity: O(1)

/*Sol_1 prunes recursion tree with the help of memo array
  and reduce the size of recursion tree from 2^n to n. */
