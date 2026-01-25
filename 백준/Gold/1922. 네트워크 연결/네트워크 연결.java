import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;
    static int[] rank;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine().trim());
        int m = Integer.parseInt(br.readLine().trim());
        
        int[][] edges = new int[m][3];
        
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            edges[i][0] = Integer.parseInt(st.nextToken());
            edges[i][1] = Integer.parseInt(st.nextToken());
            edges[i][2] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(edges, (a, b) -> a[2] - b[2]);
        
        parent = new int[n + 1];
        rank = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
        
        int totalCost = 0;
        int edgeCount = 0;
        
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            int cost = edge[2];
            
            if (a == b) continue;
            
            if (union(a, b)) {
                totalCost += cost;
                edgeCount++;
                
                if (edgeCount == n - 1) break;
            }
        }
        
        System.out.println(totalCost);
    }
    
    static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    
    static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        
        if (rootA == rootB) return false;
        
        if (rank[rootA] < rank[rootB]) {
            parent[rootA] = rootB;
        } else if (rank[rootA] > rank[rootB]) {
            parent[rootB] = rootA;
        } else {
            parent[rootB] = rootA;
            rank[rootA]++;
        }
        
        return true;
    }
}