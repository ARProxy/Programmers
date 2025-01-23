import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<Integer, List<Integer>> graph = new HashMap<>() {
            {
                for(int i = 1; i <= n; i++) {
                    put(i, new ArrayList<>());
                }
            }
        };

        for( int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph.get(x).add(y);
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        int[] distance = new int[n + 1];

        queue.offer(1);
        visited[1] = true;

        while(!queue.isEmpty()) {
            int current = queue.poll();

            if(current == n) {
                System.out.println(distance[current]);
                return;
            }

            for(int next : graph.get(current)) {
                if(!visited[next]) {
                    queue.offer(next);
                    visited[next] = true;
                    distance[next] = distance[current] + 1;
                }
            }
        }

        System.out.println(-1);
    }
}