import java.util.*;

public class Main {
    static ArrayList<Integer>[] tree;
    static int[] parent;
    static boolean[] visited;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        tree = new ArrayList[N + 1];
        parent = new int[N + 1];
        visited = new boolean[N + 1];
        
        for(int i=0; i<=N; i++) {
            tree[i] = new ArrayList<>();
        }
        
        for(int i=1; i<N; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            tree[a].add(b);
            tree[b].add(a);
        }
        findParent(1);
        
        for(int i=2; i<=N; i++) {
            System.out.println(parent[i]);
        }
    }
    
    public static void findParent(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        
        while(!queue.isEmpty()) {
            int node = queue.poll();
            
            for(int child : tree[node]) {
                if(!visited[child]) {
                    parent[child] = node;
                    visited[child] = true;
                    queue.add(child);
                }
            }
        }
    }
}