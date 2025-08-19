import java.util.LinkedList;
import java.util.Queue;

public class Bfs {
    static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    static int bfsShortenDist(int[][] maze) {
        int n = maze.length, m = maze[0].length;
        boolean[][] visited = new boolean[n][m];

        //초기 셋팅
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 1});
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], dist = cur[2];

            if (x == n - 1 && y == m - 1) {
                return dist;
            }

            for (int[] d : dir) {
                int nx = x + d[0];
                int ny = y + d[1];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (visited[nx][ny]) continue;
                if (maze[nx][ny] != 0) continue;

                visited[nx][ny] = true;
                q.add(new int[]{nx, ny, dist + 1});
            }
        }
        return -1;
    }

    static int bfsShortenDistByEdge(int[][] maze, int sx, int sy, int ex, int ey) {
        // 길이 및 visited 배열 생성 작업
        int n = maze.length, m = maze[0].length;
        boolean[][] visited = new boolean[n][m];
        
        // 큐 생성 및 초기화 작업
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sx, sy, 0});
        visited[sx][sy] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], dist = cur[2];

            if(x == ex && y == ey) return dist;

            for (int[] d : dir) {
                int nx = x + d[0];
                int ny = y + d[1];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (visited[nx][ny]) continue;
                if (maze[nx][ny] != 0) continue;

                visited[nx][ny] = true;
                q.add(new int[]{nx, ny, dist + 1});
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println("==N-1, M-1 까지의 최단 거리==");
        int[][] maze = {
                {0, 1, 0, 0},
                {0, 0, 0, 1},
                {1, 1, 0, 0},
                {0, 0, 0, 0}
        };
        System.out.println("최단 거리: " + bfsShortenDist(maze)); // 출력: 7

       maze = new int[][] {
                {0, 1, 0, 0},
                {0, 1, 0, 1},
                {0, 0, 0, 0},
                {1, 1, 0, 0}
        };
        System.out.println("==임의의 좌표 까지의 최단 거리==");
        System.out.println(bfsShortenDistByEdge(maze, 0,0, 0,3));
    }
}

