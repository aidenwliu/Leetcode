class Solution {
    public String minWindow(String s, String t) {
        int[] pattern = new int[256];
        int[] text = new int[256];
        for (int i = 0; i < t.length(); i++) {
            pattern[t.charAt(i)]++;
        }
        int start = 0, end = 0, minStart = 0, minEnd = 0;
        int count = t.length();
        int minLen = s.length()+1;
        text[s.charAt(0)]++;
        if (pattern[s.charAt(0)] >= 1) count--;
        while(true) {
            //contract from the head
            if (count == 0) {
                while (text[s.charAt(start)] > pattern[s.charAt(start)]) {
                    //i++ vs. ++i
                    text[s.charAt(start ++)] --;
                }
                if (minLen > end - start +1) {
                    minStart = start;
                    minEnd = end;
                    minLen = end - start +1;
                }
            }
            //expand from the tail
            if (end < s.length()-1) {
                text[s.charAt(++end)] ++;
                if (pattern[s.charAt(end)] >= text[s.charAt(end)]) count--;
            }
            else break;
        }
        if (count == 0) 
            return s.substring(minStart, minEnd+1);
        else return "";
    }
}
//At each point, make decisions: 1) expand, move right 2) contract, move left
//If not satisfied, choose (1); 
//Otherwise, choose (2). As soon as not satisfying, move back to (1)
//Time & Space Complexities: O(s+t). vs O(n^2) in brute force
