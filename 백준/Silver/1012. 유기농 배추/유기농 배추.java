import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스 개수

        for (int t = 0; t < T; t++) {
            int width = sc.nextInt(); // 배추밭의 가로길이
            int height = sc.nextInt(); // 배추밭의 세로길이
            int k = sc.nextInt(); // 배추가 심어져 있는 위치의 개수
            boolean[][] path = new boolean[width][height];

            for (int i = 0; i < k; i++) {
                int x = sc.nextInt(); // 배추의 X 좌표
                int y = sc.nextInt(); // 배추의 Y 좌표
                path[x][y] = true;
            }

            int graphCount = countGraphs(path, width, height);
            System.out.println(graphCount);
        }
        sc.close();
    }

    public static int countGraphs(boolean[][] path, int width, int height) {
        int graphCount = 0;
        boolean[][] visited = new boolean[width][height];

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (path[i][j] && !visited[i][j]) {
                    dfs(path, visited, i, j);
                    graphCount++;
                }
            }
        }
        return graphCount;
    }

    public static void dfs(boolean[][] path, boolean[][] visited, int i, int j) {
        int width = path.length;
        int height = path[0].length;

        if (i < 0 || i >= width || j < 0 || j >= height || visited[i][j] || !path[i][j]) {
            return;
        }

        visited[i][j] = true;
        dfs(path, visited, i + 1, j);
        dfs(path, visited, i - 1, j);
        dfs(path, visited, i, j + 1);
        dfs(path, visited, i, j - 1);
    }
}
