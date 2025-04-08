import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine(); // 개행 문자 제거

        int[][] miro = new int[N][M];
        for (int i = 0; i < N; i++) {
            String row = sc.nextLine();
            for (int j = 0; j < M; j++) {
                miro[i][j] = row.charAt(j) - '0';
            }
        }

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        int result = findShortestPath(N, M, miro, directions);
        System.out.println(result);
    }

    static int findShortestPath(int n, int m, int[][] miro, int[][] directions) {
        int[][] distance = new int[n][m];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            Arrays.fill(distance[i], -1);
        }

        distance[0][0] = 0; // 시작점의 거리를 0으로 설정
        queue.offer(new int[]{0, 0});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                if (isValidCell(newX, newY, n, m) && miro[newX][newY] == 1 && distance[newX][newY] == -1) {
                    distance[newX][newY] = distance[x][y] + 1;
                    queue.offer(new int[]{newX, newY});
                }
            }
        }
        return distance[n - 1][m - 1] + 1;
    }

    static boolean isValidCell(int x, int y, int n, int m) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}
