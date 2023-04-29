// https://leetcode.com/problems/course-schedule/solution/
// https://www.youtube.com/watch?v=0LjVxtLnNOk
// https://www.youtube.com/watch?v=rG2-_lgcZzo

// class Solution {
//     public boolean canFinish(int numCourses, int[][] prerequisites) {
//         int[] inDegree = new int[numCourses];
//         int count = 0;
        
//         for (int i = 0; i < prerequisites.length; i++)
//             inDegree[prerequisites[i][0]]++;
        
//         Stack<Integer> stack = new Stack<Integer>();
        
//         for (int i = 0; i < inDegree.length; i++) 
//             if (inDegree[i] == 0)
//                 stack.push(i);
        
//         while (!stack.isEmpty()) {
//             int curr = stack.pop();
//             count++;
            
//             for (int i = 0; i < prerequisites.length; i++) {
//                 if (prerequisites[i][1] == curr) {
//                     inDegree[prerequisites[i][0]]--;
//                     if (inDegree[prerequisites[i][0]] == 0)
//                         stack.push(prerequisites[i][0]);
//                 }
//             }
//         }
        
//         return count == numCourses;
//     }
// }

class GNode {
    public Integer inDegrees = 0;
    public List<Integer> outNodes = new LinkedList<Integer>();
}


class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) return true; 

        HashMap<Integer, GNode> graph = new HashMap<>();

        for (int[] relation : prerequisites) {
            // relation[1] -> relation[0]
            GNode prevCourse = this.getCreateGNode(graph, relation[1]);
            GNode nextCourse = this.getCreateGNode(graph, relation[0]);

            prevCourse.outNodes.add(relation[0]);
            nextCourse.inDegrees += 1;
        }

        int totalDeps = prerequisites.length;
        LinkedList<Integer> nodepCourses = new LinkedList<Integer>();
        for (Map.Entry<Integer, GNode> entry : graph.entrySet()) {
            GNode node = entry.getValue();
            if (node.inDegrees == 0)
                nodepCourses.add(entry.getKey());
        }

        int removedEdges = 0;
        while (nodepCourses.size() > 0) {
            Integer course = nodepCourses.pop();

            for (Integer nextCourse : graph.get(course).outNodes) {
                GNode childNode = graph.get(nextCourse);
                childNode.inDegrees -= 1;
                removedEdges += 1;
                if (childNode.inDegrees == 0)
                nodepCourses.add(nextCourse);
            }
        }

        if (removedEdges != totalDeps) return false;
        else return true;
  }


    protected GNode getCreateGNode(HashMap<Integer, GNode> graph, Integer course) {
        GNode node = null;
        if (graph.containsKey(course)) {
            node = graph.get(course);
        } else {
            node = new GNode();
            graph.put(course, node);
        }
        return node;
    }
}