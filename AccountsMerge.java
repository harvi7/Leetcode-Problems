// https://www.youtube.com/watch?v=J5YnIxbG3hw&feature=youtu.be

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Set<String>> g = new HashMap<>();
        Map<String, String> emailToName = new HashMap<>();
        buildGraph(g, emailToName, accounts);
        List<List<String>> res = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        
        for (String mail: emailToName.keySet()) {
            if (visited.add(mail)) {
                List<String> list = new ArrayList<>();
                list.add(mail);
                dfs(g, list, mail, visited);
                Collections.sort(list);
                list.add(0, emailToName.get(mail));
                res.add(list);
            }
        }
        return res;
    }
    
    private void buildGraph(Map<String, Set<String>> g, Map<String, String> emailToName, List<List<String>> accounts) {
        for (List<String> a : accounts) {
            String name = a.get(0);
            for (int i = 1; i < a.size(); i++) {
                String mail = a.get(i);
                emailToName.put(mail, name);
                g.putIfAbsent(mail, new HashSet<>());
                
                if (i == 1) continue;
                String prev = a.get(i - 1);
                g.get(prev).add(mail);
                g.get(mail).add(prev);
            }
        }
    }
    
    private void dfs(Map<String, Set<String>> g, List<String> list, String mail, Set<String> visited) {
        if (g.get(mail) == null || g.get(mail).size() == 0) return;
        for (String neigh : g.get(mail)) {
            if (visited.add(neigh)) {
                list.add(neigh);
                dfs(g, list, neigh, visited);
            }
        }
    }
}