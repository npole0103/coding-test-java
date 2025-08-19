import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dfs {
    static List<Integer>[] graph;
    static boolean[] visited;

    static void dfs(int node) {
        visited[node] = true;
        System.out.print(node + " ");

        for(int next : graph[node]) {
            if(!visited[next]) {
                dfs(next);
            }
        }
    }

    public static void main(String[] args) {
        // 정점 n, 간선 m
        /*
        (0)
         | \
         |  \
        (1) (2)
         |   |
         |   |
        (3) (4)

        0 → 1 → 3 → (되돌아감) → 2 → 4
         */
        int n = 5, m = 4, start = 0;
//        int[][] edges = {
//                {0,1},
//                {0,2},
//                {1,3},
//                {2,4}
//        };

        int[][] edges = new int[m][2];
        // 간선 직접 입력
        edges[0] = new int[]{0, 1};
        edges[1] = new int[]{0, 2};
        edges[2] = new int[]{1, 3};
        edges[3] = new int[]{2, 4};

        graph = new ArrayList[n];
        visited = new boolean[n];
        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        System.out.println("DFS 방문 순서 : ");
        dfs(start);
    }
}
