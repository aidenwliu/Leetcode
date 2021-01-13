class Solution {
    public boolean wordPatternMatch(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        return isMatch(s, 0, pattern, 0, map, set);
}
    boolean isMatch(String str, int i, String pattern, int j, Map<Character, String> map, Set<String> set) {
        //if both are traversed -> match; if one is traversed while the other isn't -> mismatch
        if (i == str.length() && j == pattern.length()) return true;
        if (i == str.length() || j == pattern.length()) return false;
        
        char c = pattern.charAt(j);
        
        //if c is matched to a string already
        if (map.containsKey(c)) {
          String s = map.get(c);
          if (!str.startsWith(s, i)) return false;
          else return isMatch(str, i + s.length(), pattern, j + 1, map, set);
        }
        
        //if c isn't matched to a string already
        for (int k = i; k < str.length(); k++) {
          
          
          String p = str.substring(i, k + 1);
          
          //if string is matched to another c already
          if (set.contains(p)) {
            continue; 
          }
          map.put(c, p);
          set.add(p);
          
          //backtracking
          if (isMatch(str, k + 1, pattern, j + 1, map, set)) {
            return true;
          }
          map.remove(c);
          set.remove(p);
        }
        return false;
    }
}
