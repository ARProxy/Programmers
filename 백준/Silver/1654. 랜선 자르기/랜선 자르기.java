import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");
        int k = Integer.parseInt(firstLine[0]);
        int n = Integer.parseInt(firstLine[1]);
        
        int[] cables = new int[k];
        for (int i = 0; i < k; i++) {
            cables[i] = Integer.parseInt(br.readLine());
        }
        
        long left = 1;
        long right = Arrays.stream(cables).max().orElse(0);
        long maxLength = 0;
        
        while (left <= right) {
            long mid = (left + right) / 2;
            long count = 0;
            
            for (int cable : cables) {
                count += cable / mid;
            }
            
            if (count >= n) {
                maxLength = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        System.out.println(maxLength);
    }
}
