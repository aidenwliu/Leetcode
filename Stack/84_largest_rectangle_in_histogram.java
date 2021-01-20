class Solution { //Monotone Stack
    public int largestRectangleArea(int[] heights) {
        int area = 0;
        Stack<Integer> stack = new Stack<Integer>();
        
        for (int i = 0; i < heights.length; i++) {
            if (stack.isEmpty() || heights[stack.peek()] < heights[i] ) {
                stack.push(i);
            } else {
                int start = stack.pop();
                int width = stack.isEmpty()? i:i-stack.peek()-1; //stack.peek() => right border; -1 => left border
                area = Math.max(area, heights[start]*width);
                i--;
            }
        }
        
        while (!stack.isEmpty()) {
            int start = stack.pop();
            int width = stack.isEmpty()? heights.length : heights.length-stack.peek()-1;
            area = Math.max(area, heights[start]*width);
        }
        return area;
    }
}
