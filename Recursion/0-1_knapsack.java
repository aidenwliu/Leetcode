class Solution {
  public static boolean knapSack (int s, int[] weights, int index) {
    if (s==0) return true;
    if (s<0 || weights.length =< index) return false;
    
    return knapSack(s-weights[index], weights, index+1) ||
           knapSack(s, weights, index+1);
  }
}
