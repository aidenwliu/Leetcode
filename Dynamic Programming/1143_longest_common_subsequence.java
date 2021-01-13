class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n1= text1.length(), n2= text2.length();
        String[][] dp= new String[n1+1][n2+1];
        char[] c1= text1.toCharArray();
        char[] c2= text2.toCharArray();
        
        for(int i=0;i<=n1;i++){
            for(int j=0;j<=n2;j++){
                if(i==0 || j==0) 
                    dp[i][j]= "";
                else if(c1[i-1]==c2[j-1]) 
                    dp[i][j]= dp[i-1][j-1]+c1[i-1];
                else 
                    dp[i][j]= dp[i][j-1].length() > dp[i-1][j].length()? dp[i][j-1]: dp[i-1][j];
            }
        }
        return dp[n1][n2].length();
    }
}
