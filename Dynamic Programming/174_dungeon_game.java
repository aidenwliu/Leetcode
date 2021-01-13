class Solution { //bottom up
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon.length == 0 || dungeon[0].length == 0) return 0;
        int[][] dp = new int[dungeon.length][dungeon[0].length];
        for (int i = dungeon.length-1; i >= 0; i--) {
            for (int j = dungeon[0].length-1; j >= 0; j--) {
            	if (i == dungeon.length-1 && j == dungeon[0].length-1){
                    dp[i][j] = Math.max(0, -dungeon[i][j]);
                }else if (i == dungeon.length-1){
                    dp[i][j] = Math.max(0, -dungeon[i][j]+dp[i][j+1]);
                }else if (j == dungeon[0].length-1){
                    dp[i][j] = Math.max(0, -dungeon[i][j]+dp[i+1][j]);
                }else{
                    dp[i][j] = Math.max(0, -dungeon[i][j]+Math.min(dp[i+1][j],dp[i][j+1]));
                }
        	}
        }
        //+1 because the knight dies immediately when health == 0
        return dp[0][0]+1;
        
    }
}
