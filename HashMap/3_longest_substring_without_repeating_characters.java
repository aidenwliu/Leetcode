class Solution { //sliding window
    public int lengthOfLongestSubstring(String s) {
        int a_pointer =  0;
        int b_pointer =  0;
        int max = 0;
        
        HashSet<Character> set = new HashSet<>();
        
        while (b_pointer < s.length()) {
            if (!set.contains(s.charAt(b_pointer))) {
                set.add(s.charAt(b_pointer));
                b_pointer++;
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(a_pointer));
                a_pointer++;
            }
        }
        return max;
    }
}
