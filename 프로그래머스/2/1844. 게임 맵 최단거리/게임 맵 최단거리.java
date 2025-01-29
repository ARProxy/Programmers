import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    private static int n;
    private static int m;
    private static int[][] visited;

    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        visited = new int[n][m];

        return bfs(maps, 0, 0);
    }

    private int bfs(int[][] maps, int i, int j) {
        var dx = List.of(-1, 1, 0, 0);
        var dy = List.of(0, 0, -1, 1);

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(i, j));
        visited[i][j] = 1;

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            int cx = point.x;
            int cy = point.y;

            if (cx == n - 1 && cy == m - 1) {
                return visited[cx][cy];
            }

            for (int k = 0; k < 4; k++) {
                int nx = cx + dx.get(k);
                int ny = cy + dy.get(k);

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && maps[nx][ny] == 1 && visited[nx][ny] == 0) {
                    queue.add(new Point(nx, ny));
                    visited[nx][ny] = visited[cx][cy] + 1;
                }
            }
        }
        return -1;
    }

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}