// https://leetcode.com/problems/employee-importance/solution/

class Solution {
    Map<Integer, Employee> emap;
    public int getImportance(List<Employee> employees, int id) {
        emap = new HashMap();
        for (Employee e: employees) emap.put(e.id, e);
        return dfs(id);
    }
    public int dfs(int eid) {
        Employee employee = emap.get(eid);
        int ans = employee.importance;
        for (Integer subid: employee.subordinates)
            ans += dfs(subid);
        return ans;
    }
}