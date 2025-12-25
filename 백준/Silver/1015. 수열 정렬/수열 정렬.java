import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;
    static int[][] temp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        arr = new int[n][2];
        temp = new int[n][2];
        
        for (int i = 0; i < n; i++) {
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = i;
        }
        
        mergeSort(0, n - 1);
        
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[arr[i][1]] = i;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(p[i]).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
    
    static void mergeSort(int left, int right) {
        if (left >= right) return;
        
        int mid = (left + right) / 2;
        mergeSort(left, mid);
        mergeSort(mid + 1, right);
        merge(left, mid, right);
    }
    
    static void merge(int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;
        
        while (i <= mid && j <= right) {
            if (arr[i][0] < arr[j][0]) {
                temp[k++] = arr[i++];
            } else if (arr[i][0] > arr[j][0]) {
                temp[k++] = arr[j++];
            } else {
                if (arr[i][1] < arr[j][1]) {
                    temp[k++] = arr[i++];
                } else {
                    temp[k++] = arr[j++];
                }
            }
        }
        
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        
        for (int t = left; t <= right; t++) {
            arr[t] = temp[t];
        }
    }
}