class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] m = new int[n][n];
        for (int i = n-1; i>=0; i--) {
            m[i][i] = 1;
            for (int j = i+1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)){
                    m[i][j] = m[i+1][j-1]+2;
                } else {
                    m[i][j] = Math.max(m[i][j-1], m[i+1][j]);
                }
            }
        }
        return m[0][n-1];
    }
}
