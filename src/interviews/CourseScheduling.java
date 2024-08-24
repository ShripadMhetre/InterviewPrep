package interviews;

import java.util.*;

/*
    Q. There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites
    where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
    For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
    Return true if you can finish all courses. Otherwise, return false.

    Example 1:

    Input: numCourses = 2, prerequisites = [[1,0]]
    Output: true
    Explanation: There are a total of 2 courses to take.
    To take course 1 you should have finished course 0. So it is possible.

    Example 2:

    Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
    Output: false
    Explanation: There are a total of 2 courses to take.
    To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 */
public class CourseScheduling {
    // Uses Topological Sorting - Kahn's Algorithm
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] adjList = new ArrayList[numCourses];

        Queue<Integer> queue = new LinkedList<Integer>();
        int[] indegree = new int[numCourses];

        ArrayList<Integer> answer = new ArrayList<>();

        for (int[] pre: prerequisites) {
            int course = pre[0];
            int prerequisite = pre[1];

            if (adjList[prerequisite] == null) adjList[prerequisite] = new ArrayList<Integer>();

            adjList[prerequisite].add(course);
            indegree[course]++;
        }

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) queue.add(i);
        }

        while (!queue.isEmpty()) {
            int polledCourse = queue.poll();

            answer.add(polledCourse);

            if (adjList[polledCourse] != null) {
                for (int adjCourse: adjList[polledCourse]) {
                    indegree[adjCourse]--;

                    if (indegree[adjCourse] == 0) queue.add(adjCourse);
                }
            }
        }

        return answer.size() == numCourses;
    }


    // Solution 2: DFS Approach
    public boolean canFinishDFS(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> preMap = new HashMap<>();
        Set<Integer> visiting = new HashSet<>();    // tracks current path to detect cycle

        for (int i = 0; i < numCourses; i++) {
            preMap.put(i, new ArrayList<>());
        }

        for (int[] pair : prerequisites) {
            preMap.get(pair[0]).add(pair[1]);
        }

        for (int c = 0; c < numCourses; c++) {
            if (!dfs(c, preMap, visiting)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int crs, HashMap<Integer, List<Integer>> preMap, Set<Integer> visiting) {
        if (visiting.contains(crs)) {
            return false;
        }
        if (preMap.get(crs).isEmpty()) {
            return true;
        }

        visiting.add(crs);
        for (int pre : preMap.get(crs)) {
            if (!dfs(pre, preMap, visiting)) {
                return false;
            }
        }

        visiting.remove(crs);
        preMap.put(crs, new ArrayList<>());

        return true;
    }
}
