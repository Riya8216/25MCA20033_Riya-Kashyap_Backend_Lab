class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        ArrayList<Integer>[] graph = new ArrayList[numCourses];

        for (int i = 0; i < numCourses; i++)
            graph[i] = new ArrayList<>();

        int[] indegree = new int[numCourses];

        for (int[] p : prerequisites) {
            graph[p[1]].add(p[0]);
            indegree[p[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0)
                q.add(i);
        }

        int[] ans = new int[numCourses];
        int index = 0;

        while (!q.isEmpty()) {
            int course = q.poll();
            ans[index++] = course;

            for (int next : graph[course]) {
                indegree[next]--;

                if (indegree[next] == 0)
                    q.add(next);
            }
        }

        if (index != numCourses)
            return new int[0];

        return ans;
    }
}
