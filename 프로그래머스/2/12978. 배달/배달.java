import java.util.*;

class Solution {
    private final int INF = Integer.MAX_VALUE;

    public int solution(int N, int[][] roads, int K) {
        List<List<Node>> adj = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            int a = road[0], b = road[1], c = road[2];
            adj.get(a).add(new Node(b, c));
            adj.get(b).add(new Node(a, c));
        }

        int[] distance = dijkstra(1, N, adj);

        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (distance[i] <= K) {
                count++;
            }
        }
        return count;
    }

    private int[] dijkstra(int start, int N, List<List<Node>> adj) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] distance = new int[N + 1];
        Arrays.fill(distance, INF);

        distance[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            if (distance[current.vertex] < current.cost) continue;

            for (Node next : adj.get(current.vertex)) {
                if (distance[next.vertex] > distance[current.vertex] + next.cost) {
                    distance[next.vertex] = distance[current.vertex] + next.cost;
                    pq.offer(new Node(next.vertex, distance[next.vertex]));
                }
            }
        }
        return distance;
    }
}

class Node implements Comparable<Node> {
    int vertex, cost;

    Node(int vertex, int cost) {
        this.vertex = vertex;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.cost, o.cost);
    }
}
