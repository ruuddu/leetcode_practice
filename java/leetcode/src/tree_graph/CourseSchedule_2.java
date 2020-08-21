package tree_graph;

import java.util.*;

public class CourseSchedule_2 {

    public static void main(String[] args) {
        int[][] test = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        for (int i : findOrder(4, test)) {
            System.out.print(i + " ");
        }

        int[][] test2 = {{1, 0}, {0, 1}};
        for (int i : findOrder(2, test2)) {
            System.out.print(i + " ");
        }

        int[][] test3 = {{1, 0}, {2, 1}};
        for (int i : findOrder(3, test3)) {
            System.out.print(i + " ");
        }
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {

        List<Integer>[] adjacentList = new List[numCourses];
        for (int i = 0; i < numCourses; ++i) adjacentList[i] = new ArrayList<>();

        Stack<Integer> stack = new Stack<>();

        boolean[] visited = new boolean[numCourses];

        // inDegree to flag the cycle if there is
        int[] inDegree = new int[numCourses];

        for (int coursePair[] : prerequisites) {
            adjacentList[coursePair[1]].add(coursePair[0]);
            inDegree[coursePair[0]]++;
        }

        // main action
        for (int i = 0; i < adjacentList.length; i++) {
            if(!visited[i]) {
                topoUtil(i, visited, stack, adjacentList, inDegree);
            }
        }

        if (stack.size() != numCourses) {
            return new int[]{};
        }

        int[] result = new int[numCourses];
        int count = 0;
        while(!stack.empty()){
            result[count++] = stack.pop();
        }
        return result;
    }

    public static void topoUtil(int vertex, boolean[] visited, Stack<Integer> stack, List<Integer>[] adjacentList, int[] inDegree) {
        // empty => insert to stack
        if (adjacentList[vertex].isEmpty()) {
            visited[vertex] = true;
            if (!stack.contains(vertex)) {
                stack.push(vertex);
                System.out.println("Pushing " + vertex);
                return;
            }
        }

        if(!visited[vertex]) {
            System.out.println("Marking " + vertex);
            visited[vertex] = true;
            // working on adjacent list
            for (int singleCourse : adjacentList[vertex]) {

                // check if there is cycle
                if(visited[singleCourse] && !stack.contains(singleCourse)){
                    return;
                }

                System.out.println("Working on " + singleCourse);
                topoUtil(singleCourse, visited, stack, adjacentList, inDegree);
            }
            if (!stack.contains(vertex)) {
                System.out.println("Pushing === " + vertex);
                stack.push(vertex);
            }
        }
    }

    // faster version
    public int[] findOrder2(int numCourses, int[][] prerequisites) {

        // in Degree
        int[] indegrees = new int[numCourses];

        // Array of List
        List<Integer>[] graph = new List[numCourses];

        // initialize graph - adjacent list
        for (int i = 0; i < numCourses; ++i) graph[i] = new ArrayList<>();

        for (int[] p : prerequisites) {
            // update graph with graph[need_study] = goal
            graph[p[1]].add(p[0]);

            // keep track of coming edges
            indegrees[p[0]]++;
        }

        int count = 0;
        // returned array
        int[] ret = new int[numCourses];

        // Queue to keep result
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; ++i) {
            // check very first vertex without coming edges
            if (indegrees[i] == 0) {
                ret[count++] = i;
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int t = queue.poll();
            for (int child : graph[t]) {
                indegrees[child]--; // decreasing count means prerequisite has been resolved / studied
                if (indegrees[child] == 0) {
                    queue.offer(child);
                    ret[count++] = child;
                }
            }
        }

        return count == numCourses ? ret : new int[0];
    }
}
