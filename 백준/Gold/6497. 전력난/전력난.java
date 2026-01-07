import java.io.*;
import java.util.*;

public class Main {
    
    static int[] parent;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            
            if (m == 0 && n == 0) break;
            
            List<int[]> edges = new ArrayList<>();
            long totalCost = 0;
            
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int z = Integer.parseInt(st.nextToken());
                
                edges.add(new int[] {x, y, z});
                totalCost += z;
            }
            
            edges.sort((a, b) -> a[2] - b[2]);
            
            parent = new int[m];
            for (int i = 0; i < m; i++) {
                parent[i] = i;
            }
            
            long mstCost = 0;
            int edgeCount = 0;
            
            for (int[] edge : edges) {
                int x = edge[0];
                int y = edge[1];
                int z = edge[2];
                
                if (find(x) != find(y)) {
                    union(x, y);
                    mstCost += z;
                    edgeCount++;
                    
                    if (edgeCount == m - 1) break;
                }
            }
            
            sb.append(totalCost - mstCost).append("\n");
        }
        
        System.out.print(sb);
    }
    
    static int find(int x) {
        if (parent[x] == x) return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }
    
    static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            parent[rootY] = rootX;
        }
    }
}