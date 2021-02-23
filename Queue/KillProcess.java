// https://leetcode.com/problems/kill-process/solution/

class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        HashMap < Integer, List < Integer >> children = new HashMap < > ();
        
        for (int i = 0; i < ppid.size(); i++) {
            if (ppid.get(i) > 0) {
                children.putIfAbsent(ppid.get(i), new ArrayList < Integer > ());
                children.get(ppid.get(i)).add(pid.get(i));
            }
        }
        List<Integer> killedProcesses = new ArrayList<>();
        Queue < Integer > queue = new LinkedList < > ();
        queue.add(kill);
        while (!queue.isEmpty()) {
            Integer processToKill = queue.remove();
            killedProcesses.add(processToKill);
            
            if (!children.containsKey(processToKill)) continue;
            for (Integer child : children.get(processToKill))
                queue.add(child);
    
        }
        return killedProcesses;
    }
}