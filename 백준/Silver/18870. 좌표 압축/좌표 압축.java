import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine().trim());
        int[] arr = new int[n];
        int[] sorted = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sorted[i] = arr[i];
        }
        
        Arrays.sort(sorted);
        
        MyHashMap rankMap = new MyHashMap();
        int rank = 0;
        for (int i = 0; i < n; i++) {
            if (!rankMap.containsKey(sorted[i])) {
                rankMap.put(sorted[i], rank++);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(rankMap.get(arr[i]));
            if (i < n - 1) sb.append(' ');
        }
        System.out.print(sb);
    }
}

class MyHashMap {
    
    private static final int BUCKET_SIZE = 1000003;
    
    private static class Node {
        int key;
        int value;
        Node next;
        
        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
    
    private final Node[] buckets;
    
    public MyHashMap() {
        buckets = new Node[BUCKET_SIZE];
    }
    
    private int hash(int key) {
        return (key & 0x7FFFFFF) % BUCKET_SIZE;
    }
    
    public void put(int key, int value) {
        int index = hash(key);
        
        if (buckets[index] == null) {
            buckets[index] = new Node(key, value);
            return;
        }
        
        Node current = buckets[index];
        while (true) {
            if (current.key == key) {
                current.value = value;
                return;
            }
            
            if (current.next == null) break;
            
            current = current.next;
        } 
        
        current.next = new Node(key, value);
    }
    
    public int get(int key) {
        int index = hash(key);
        Node current = buckets[index];
        
        while (current != null) {
            if (current.key == key) {
                return current.value;
            }
            
            current = current.next;
        }
        
        return -1;
    }
    
    public boolean containsKey(int key) {
        int index = hash(key);
        Node current = buckets[index];
        
        while (current != null) {
            if (current.key == key) {
                return true;
            }
            
            current = current.next;
        }
        return false;
    }
}