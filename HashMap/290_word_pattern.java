class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (pattern.length() != words. length) return false;
        
        HashMap<Character, String> map = new HashMap();
        
        for (int i = 0; i < pattern.length(); i++) {
            char cur_char = pattern.charAt(i);
            if (map.containsKey(cur_char)) {
                if (!map.get(cur_char).equals(words[i])) {
                    return false;
                }
            } else {
                if (map.containsValue(words[i])) {
                    return false;
                }
                map.put(cur_char, words[i]);
            }
        }
        
        return true;
    } 
}
