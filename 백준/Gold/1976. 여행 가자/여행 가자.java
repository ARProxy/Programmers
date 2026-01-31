import java.io.*;

public class Main {
    
    static final int BUFFER_SIZE = 1 << 16;
    static byte[] buffer = new byte[BUFFER_SIZE];
    static int bufferPointer = 0;
    static int bytesRead = 0;
    static InputStream in = System.in;
    
    static int[] parent;
    
    public static void main(String[] args) throws IOException {
        int n = readInt();
        int m = readInt();
        
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int connected = readInt();
                if (connected == 1 && i < j) {
                    union(i, j);
                }
            }
        }
        
        int[] plan = new int[m];
        for (int i = 0; i < m; i++) {
            plan[i] = readInt();
        }
        
        boolean possible = true;
        int root = find(plan[0]);
        
        for (int i = 1; i < m; i++) {
            if (find(plan[i]) != root) {
                possible = false;
                break;
            }
        }
        
        System.out.println(possible ? "YES" : "NO");
    }
    
    static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        
        return parent[x];
    }
    
    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            parent[rootB] = rootA;
        }
    }
    
    static int readInt() throws IOException {
        int num = 0;
        byte c = read();
        
        while (c <= ' ') c = read();
        
        boolean negative = (c == '-');
        if (negative) c = read();
        
        while (c >= '0' && c <= '9') {
            num = num * 10 + (c - '0');
            c = read();
        }

        return negative ? -num : num;
    }

    static byte read() throws IOException {
        if (bufferPointer == bytesRead) {
            bytesRead = in.read(buffer, 0, BUFFER_SIZE);
            bufferPointer = 0;
        }
        return buffer[bufferPointer++];
    }
}