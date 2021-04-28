class Solution { //find all combinations => backtrack
    List<String> res = new ArrayList<String>();
    String[] arr = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        combinations(digits, 0, "");
        return res;
    }
    
    private void combinations(String digits, int i, String k) {
        if (digits.length() == 0) return;
        if (i == digits.length()) {
            res.add(k);
            return;
        }
        String temp = arr[digits.charAt(i)-50];
        for (int j = 0; j < temp.length(); j++) {
            combinations(digits, i+1, k+temp.charAt(j));
        }
        
    }
}
