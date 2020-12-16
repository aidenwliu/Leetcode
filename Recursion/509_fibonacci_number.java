/* Sol_1. 
   Recursion */
public class Solution {
    public int fib(int N) {
        if (N <= 1) {
            return N;
        }
        return fib(N-1) + fib(N-2);
    }
}
//Time complexity: O(2^N).
//Space complexity: O(N).

/* Sol_2. 
   Iteration */
class Solution {
    public int fib(int n) {
        if (n <= 1) {
            return n;
        } 
        return memorize(n);
    }
    
    public int memorize(int n) {
        int[] cache = new int[n+1];
        cache[1] = 1;
        
        for (int i = 2; i <= n; i++) {
          cache[i] = cache[i-1] + cache[i-2];
        }
        
        return cache[n];
    }
}
//Time complexity: O(N).
//Space complexity: O(N).

//Iteration is better because it uses memorization to reduce the time complexity.
