import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            if (isGroupWord(br.readLine())) {
                count++;
            }
        }
        
        System.out.println(count);
    }
    
    private static boolean isGroupWord(String word) {
        boolean[] visited = new boolean[26]; // a-z 알파벳 방문 체크
        char prev = '\0'; // 이전 문자 저장
        
        for (int i = 0; i < word.length(); i++) {
            char current = word.charAt(i);
            
            if (current != prev) {
                if (visited[current - 'a']) {
                    return false;
                }
                visited[current - 'a'] = true;
                prev = current;
            }
        }
        
        return true;
    }
}
