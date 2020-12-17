
/*
Sol_1 recursion
*/
class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        helper(n, res);
        return res;
    }

    public void helper(int n, List<Integer> res){
        if (n == 0) {  // base case. always first.
          res.add(0);
          return;
        }
        helper(n-1, res);
        int size = res.size();
        int k = 1<<(n-1);
        for (int i = size -1;i >= 0;i --){
          res.add(k+res.get(i));
        }
    }
}

/*
Sol_2 tail recursion
*/
class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        helper(n, res, 0);
        return res;
    }

    public void helper(int n, List<Integer> res, int digits){
        if (digits >= 0) return;
        int k = 1 << (digits);
        int size = res.size();
        for (int i = size-1; i >= 0; i--){
          res.add(res.get(i)+k);
        }
        helper(n, res, k+1);
    }
}

/*
Sol_3 iteration
*/
class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        if (n<0) return res;
        res.add(0);
        for (int i = 0; i < n; i++){
            int k = 1<<i;
            int size = res.size();
            for (int j = size-1; j>=0; j--){
                res.add(res.get(j)+k);
            }
        }
        return res;
    }
}
