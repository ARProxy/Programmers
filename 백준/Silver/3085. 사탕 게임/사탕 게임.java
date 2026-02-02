import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(reader.readLine());
        String[][] candies = new String[n][n];
        for (int i = 0; i < n; i++) {
            candies[i] = reader.readLine().split("");
        }
        
        int result = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                
                // 오른쪽
                if (j + 1 < n) {
                    swap(candies, i, j, i, j + 1);
                    result = Math.max(result, getMaxLength(candies, n));
                    swap(candies, i, j, i, j + 1);  // 원상복구
                }
                
                // 아래
                if (i + 1 < n) {
                    swap(candies, i, j, i + 1, j);
                    result = Math.max(result, getMaxLength(candies, n));
                    swap(candies, i, j, i + 1, j);  // 원상복구
                }
            }
        }
        
        System.out.println(result);
    }
    
    static void swap(String[][] candies, int r1, int c1, int r2, int c2) {
        String temp = candies[r1][c1];
        candies[r1][c1] = candies[r2][c2];
        candies[r2][c2] = temp;
    }
    
    static int getMaxLength(String[][] candies, int n) {
        int max = 1;
        
        for (int i = 0; i < n; i++) {
            max = Math.max(max, getMaxInRow(candies, i));
            max = Math.max(max, getMaxInCol(candies, i));
        }
        
        return max;
    }
    
    static int getMaxInRow(String[][] candies, int row) {
        int max = 1;
        int count = 1;
        
        for (int j = 1; j < candies[row].length; j++) {
            if (candies[row][j].equals(candies[row][j - 1])) {
                count++;
                max = Math.max(max, count);
            } else {
                count = 1;
            }
        }
        return max;
    }
    
    static int getMaxInCol(String[][] candies, int col) {
        int max = 1;
        int count = 1;
        
        for (int i = 1; i < candies.length; i++) {
            if (candies[i][col].equals(candies[i - 1][col])) {
                count++;
                max = Math.max(max, count);
            } else {
                count = 1;
            }
        }
        return max;
    }
}