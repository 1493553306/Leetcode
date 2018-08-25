package Graph;

/*
207 判断有向图是否有环
There are a total of n courses you have to take, labeled from 0 to n-1.

        Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

        Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

        Example 1:

        Input: 2, [[1,0]]
        Output: true
        Explanation: There are a total of 2 courses to take.
        To take course 1 you should have finished course 0. So it is possible.
        Example 2:

        Input: 2, [[1,0],[0,1]]
        Output: false
        Explanation: There are a total of 2 courses to take.
        To take course 1 you should have finished course 0, and to take course 0 you should
        also have finished course 1. So it is impossible.
*/

import java.util.*;

public class CourseSchedule {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inCount = new int[numCourses];
        List<List<Integer>> graph = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        for(int i = 0; i < numCourses; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] val : prerequisites){
            inCount[val[0]]++;
            graph.get(val[1]).add(val[0]);
        }
        for(int i = 0; i < numCourses; i++){
            if(inCount[i] == 0)
                q.offer(i);
        }
        while (q.size() > 0){
           int i =  q.poll();
           count++;
           for(int val : graph.get(i)){
               inCount[val]--;
               if(inCount[val] == 0)
                   q.offer(val);
           }
        }
        return count == numCourses;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[][] prerequisites= new int[num][2];
        for(int i = 0; i < num; i++){
            prerequisites[i][0] = sc.nextInt();
            prerequisites[i][1] = sc.nextInt();
        }
        canFinish(num, prerequisites);
    }
}
