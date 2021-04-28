class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res, new StringBuilder(), n, 0, 0);
        return res;
    }
    
    private void backtrack(List<String> res, StringBuilder cur, int max, int open, int close) {
        //exit
        if (cur.length() == max*2) {
            res.add(cur.toString());
            return;
        }
        //backtrack
        if (open < max){
            cur.append("(");
            backtrack(res, cur, max, open+1, close);
            cur.deleteCharAt(cur.length()-1);
        }
        if (close < open){
            cur.append(")");
            backtrack(res, cur, max, open, close+1);
            cur.deleteCharAt(cur.length()-1);
        }
    }
}
