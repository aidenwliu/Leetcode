class Solution {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) return "";
        
        String[] strs =  new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, new Comparator<String>(){
            public int compare(String str1, String str2) {
                return (str2+str1).compareTo(str1+str2);  //continuity
            }
        });
        
        if (strs[0].charAt(0) == '0') return "0";
        
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < strs.length; i++)
            res.append(strs[i]);
        
        return res.toString();
    }
}
