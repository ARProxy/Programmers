import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int[][] map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[][] visited = new boolean[N][N];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0], c = cur[1];

            if (r == N - 1 && c == N - 1) {
                System.out.println("HaruHaru");
                return;
            }

            int jump = map[r][c];

            // 오른쪽으로 jump칸
            int nc = c + jump;
            if (nc < N && !visited[r][nc]) {
                visited[r][nc] = true;
                queue.offer(new int[]{r, nc});
            }

            // 아래로 jump칸
            int nr = r + jump;
            if (nr < N && !visited[nr][c]) {
                visited[nr][c] = true;
                queue.offer(new int[]{nr, c});
            }
        }

        System.out.println("Hing");
    }
}