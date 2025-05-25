import java.util.*;

public class Main {
    static int N, M, R;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] order;
    static int orderCounter;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        R = sc.nextInt();

        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        order = new int[N + 1];
        orderCounter = 1;

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph[u].add(v);
            graph[v].add(u);
        }

        // 그래프의 각 리스트를 정렬하여 내림차순으로 방문하도록 함
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i], Collections.reverseOrder());
        }

        dfs(R);

        for (int i = 1; i <= N; i++) {
            System.out.println(order[i]);
        }
    }

    static void dfs(int v) {
        visited[v] = true;
        order[v] = orderCounter++;

        for (int next : graph[v]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}
