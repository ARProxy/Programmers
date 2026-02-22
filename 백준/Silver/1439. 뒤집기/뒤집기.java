import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim();

        int zeroGroup = 0;
        int oneGroup = 0;

        char prev = ' ';
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != prev) {
                if (s.charAt(i) == '0') zeroGroup++;
                else oneGroup++;
                prev = s.charAt(i);
            }
        }

        System.out.println(Math.min(zeroGroup, oneGroup));
    }
}