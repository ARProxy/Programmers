import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int t = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(reader.readLine());
            int[] result = primeCalculator(n);
            sb.append(result[0]).append(" ").append(result[1]).append("\n");
        }
        System.out.print(sb);
    }
    
    static boolean[] isPrime(int n) {
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;
        
        for (int i = 2; i * i <= n; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    prime[j] = false;
                }
            }
        }
        return prime;
    }
    
    static int[] primeCalculator(int token) {
        boolean[] prime = isPrime(token);
        int[] result = new int[2];
        
        for (int a = token/2; a >= 2; a--) {
            int b = token - a;
            
            if (prime[a] && prime[b]) {
                result[0] = a;
                result[1] = b;
                break;
            }
        }
        return result;
    }
}