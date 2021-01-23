class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++)
            graph.add(new ArrayList<Integer>());
        int[] preNum = new int[numCourses];
        
        for (int i = 0; i < prerequisites.length; i++) {
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]); //add outgoing edges
            preNum[prerequisites[i][0]]++; //count incoming edges
        }
        
        for (int i = 0; i < numCourses; i++) {
            boolean availableCourse = false;
            for (int j = 0; j < numCourses; j++) {
                if (preNum[j] == 0) {
                    for (int k : graph.get(j))
                        preNum[k]--;
                    availableCourse = true;
                    preNum[j] = -1;
                    break;
                }
            }
            if (!availableCourse)
                    return false;
        }
       return true;
    }
}
