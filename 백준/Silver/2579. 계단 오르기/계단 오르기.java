import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine()); // 계단의 수
        int[] datas = new int[n];
        
        for (int i = 0; i < n; i++) {
            datas[i] = Integer.parseInt(br.readLine());
        }
        
        solution(n, datas);
    }
    
    public static void solution(int n, int[] datas) {
        if (n == 0) {
            System.out.println(0);
            return;
        }
        
        int[] dpTable = new int[n];
        dpTable[0] = datas[0];
        
        if (n > 1) dpTable[1] = Math.max(datas[0] + datas[1], datas[1]);
        if (n > 2) dpTable[2] = Math.max(datas[0] + datas[2], datas[1] + datas[2]);
        
        for (int dataIndex = 3; dataIndex < n; dataIndex++) {
            dpTable[dataIndex] = Math.max(
                datas[dataIndex] + datas[dataIndex - 1] + dpTable[dataIndex - 3],
                datas[dataIndex] + dpTable[dataIndex - 2]
            );
        }
        
        System.out.println(dpTable[n - 1]);
    }
}
