class Solution {
    public String findLCS(String s1, String s2){ //refer to #1143. Longest Common Subsequence
        int n1= s1.length(), n2= s2.length();
        String[][] dp= new String[n1+1][n2+1];
        char[] c1= s1.toCharArray();
        char[] c2= s2.toCharArray();
        
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
        return dp[n1][n2];
    }
    
    public String shortestCommonSupersequence(String str1, String str2) {
        String LCS= findLCS(str1, str2);
        StringBuilder ans= new StringBuilder();
        int p1=0, p2=0;
        
        char[] lcs= LCS.toCharArray();
        char[] s1= str1.toCharArray();
        char[] s2= str2.toCharArray();
        
        for(char c: lcs){
            while(s1[p1] !=c)
                ans.append(s1[p1++]);
            while(s2[p2] !=c)
                ans.append(s2[p2++]);
            ans.append(c);
            p1++;
            p2++;
        }
        ans.append(str1.substring(p1)).append(str2.substring(p2));
        return ans.toString();
    }
}
