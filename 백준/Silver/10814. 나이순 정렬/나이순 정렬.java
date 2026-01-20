import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        List<List<String>> bucket = new ArrayList<>();
        for (int i = 0; i <= 200; i++) {
            bucket.add(new ArrayList<>());
        }
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            bucket.get(age).add(age + " " + name);
        }
        
        StringBuilder sb = new StringBuilder();
        for (List<String> list : bucket) {
            for (String s : list) {
                sb.append(s).append("\n");
            }
        }
        
        System.out.print(sb);
    }
}