/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> map = new HashMap<>();
        for (Employee e : employees) {
            map.put(e.id, e);
        }
        return dfs(id, map);
        
    }
    private int dfs(int id, HashMap<Integer, Employee> map) {
        int res = 0;
        Employee cur = map.get(id);
        res += cur.importance;
        for (int i : cur.subordinates) {
            res += dfs(i, map);
        }
        return res;
    }
}
