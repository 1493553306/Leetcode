package BreadthFirstSearch;

/*
An undirected, connected graph of N nodes (labeled 0, 1, 2, ..., N-1) is given as graph.

        graph.length = N, and j != i is in the list graph[i] exactly once, if and only if nodes i and j are connected.

        Return the length of the shortest path that visits every node. You may start and stop at any node, you may revisit nodes multiple times, and you may reuse edges.



        Example 1:

        Input: [[1,2,3],[0],[0],[0]]
        Output: 4
        Explanation: One possible path is [1,0,2,0,3]
        Example 2:

        Input: [[1],[0,2,4],[1,3,4],[2],[1,2]]
        Output: 4
        Explanation: One possible path is [0,1,4,2,3]
*/

import java.util.*;

public class ShortestPathVisitingAllNodes {
    public static int shortestPathLength(int[][] graph) {
        int N = graph.length, mask = 1, count = 0;
        Set<String> set = new HashSet<>();
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            mask |= (1 << i);
            int[] make = new int[] {(1<<i),i};
            set.add(make[0] + "+" + make[1]);
            q.offer(make);
        }
        while (true) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int[] curr = q.poll();
                if (curr[0] == mask) return count;
                for (int next : graph[curr[1]]) {
                    int nextPath = curr[0] | (1 << next);
                    if (!set.add(nextPath + "+" + next)) continue;
                    q.offer(new int[]{nextPath,next});
                }
            }
            count++;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = Integer.parseInt(sc.nextLine());
        int[][] graph = new int[len][];
        for(int i = 0; i < len; i++){
            String[] tmp = sc.nextLine().split(" ");
            graph[i] = new int[tmp.length];
            for(int j = 0; j < tmp.length; j++)
                graph[i][j] = Integer.parseInt(tmp[j]);
        }
        shortestPathLength(graph);
    }



}
