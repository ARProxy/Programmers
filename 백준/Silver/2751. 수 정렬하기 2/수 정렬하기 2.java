import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final int MAX_INSERTION_SORT_SIZE = 44;
    private static final int MAX_MIXED_INSERTION_SORT_SIZE = 65;
    private static final int MAX_RECURSION_DEPTH = 128;
    private static final int DELTA = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        sort(a, 0, 0, n);

        StringBuilder sb = new StringBuilder();
        for (int num : a) {
            sb.append(num).append("\n");
        }

        System.out.println(sb);
    }

    private static void sort(int[] a, int bits, int low, int high) {
        while (true) {
            int end = high - 1;
            int size = high - low;

            if (size < MAX_MIXED_INSERTION_SORT_SIZE && (bits & 1) > 0) {
                mixedInsertionSort(a, low, high);
                return;
            }

            if (size < MAX_INSERTION_SORT_SIZE) {
                insertionSort(a, low, high);
                return;
            }

            if ( (bits += DELTA) > MAX_RECURSION_DEPTH) {
                heapSort(a, low, high);
                return;
            }

            int step = (size >> 3) * 3 + 3;
            int e1 = low + step;
            int e5 = end - step;
            int e3 = (e1 + e5) >>> 1;
            int e2 = (e1 + e3) >>> 1;
            int e4 = (e3 + e5) >>> 1;
            int a3 = a[e3];

            if (a[e5] < a[e2]) { int t = a[e5]; a[e5] = a[e2]; a[e2] = t; }
            if (a[e4] < a[e1]) { int t = a[e4]; a[e4] = a[e1]; a[e1] = t; }
            if (a[e5] < a[e4]) { int t = a[e5]; a[e5] = a[e4]; a[e4] = t; }
            if (a[e2] < a[e1]) { int t = a[e2]; a[e2] = a[e1]; a[e1] = t; }
            if (a[e4] < a[e2]) { int t = a[e4]; a[e4] = a[e2]; a[e2] = t; }

            if (a3 < a[e2]) {
                if (a3 < a[e1]) {
                    a[e3] = a[e2]; a[e2] = a[e1]; a[e1] = a3;
                } else {
                    a[e3] = a[e2]; a[e2] = a3;
                }
            } else if (a3 > a[e4]) {
                if (a3 > a[e5]) {
                    a[e3] = a[e4]; a[e4] = a[e5]; a[e5] = a3;
                } else {
                    a[e3] = a[e4]; a[e4] = a3;
                }
            }

            int lower = low;
            int upper = end;

            if (a[e1] < a[e2] && a[e2] < a[e3] && a[e3] < a[e4] && a[e4] < a[e5]) {
                int pivot1 = a[e1];
                int pivot2 = a[e5];

                a[e1] = a[lower];
                a[e5] = a[upper];

                while (a[++lower] < pivot1);
                while (a[--upper] > pivot2);

                for (int unused = --lower, k = ++upper; --k > lower; ) {
                    int ak = a[k];

                    if (ak < pivot1) {
                        while (lower < k) {
                            if (a[++lower] >= pivot1) {
                                if (a[lower] > pivot2) {
                                    a[k] = a[--upper];
                                    a[upper] = a[lower];
                                } else {
                                    a[k] = a[lower];
                                }
                                a[lower] = ak;
                                break;
                            }
                        }
                    } else if (ak > pivot2) {
                        a[k] = a[--upper];
                        a[upper] = ak;
                    }
                }

                a[low] = a[lower]; a[lower] = pivot1;
                a[end] = a[upper]; a[upper] = pivot2;

                sort(a, bits | 1, lower + 1, upper);
                sort(a, bits | 1, upper + 1, high);

            } else {
                int pivot = a[e3];
                a[e3] = a[lower];

                for (int k = ++upper; --k > lower; ) {
                    int ak = a[k];

                    if (ak != pivot) {
                        a[k] = pivot;

                        if (ak < pivot) {
                            while (a[++lower] < pivot);

                            if (a[lower] > pivot) {
                                a[--upper] = a[lower];
                            }
                            a[lower] = ak;
                        } else {
                            a[--upper] = ak;
                        }
                    }
                }

                a[low] = a[lower]; a[lower] = pivot;

                sort(a, bits | 1, upper, high);
            }

            high = lower;
        }
    }

    private static void mixedInsertionSort(int[] a, int low, int high) {
        for (int i = low + 1; i < high; i++) {
            int ai = a[i];

            if (ai < a[i - 1]) {
                int j = i;

                while (a[j - 1] > ai) {
                    a[j] = a[j - 1];
                    j--;
                }

                a[j] = ai;
            }
        }
    }

    private static void insertionSort(int[] a, int low, int high) {
        for (int i = low + 1; i < high; i++) {
            int ai = a[i];

            if (ai < a[i - 1]) {
                int j = i;

                while (j > low && a[j - 1] > ai) {
                    a[j] = a[j - 1];
                    j--;
                }

                a[j] = ai;
            }
        }
    }

    private static void heapSort(int[] a, int low, int high) {
        int n = high - low;

        for (int i = (n >>> 1) - 1; i >= 0; i--) {
            heapify(a, low, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            int t = a[low]; a[low] = a[low + i]; a[low + i] = t;
            heapify(a, low, i, 0);
        }
    }

    private static void heapify(int[] a, int offset, int n, int i) {
        int ai = a[offset + i];

        while (true) {
            int l = (i << 1) + 1;
            int r = l + 1;

            if (l >= n) break;

            int largest = l;
            if (r < n && a[offset + r] > a[offset + l]) {
                largest = r;
            }

            if (ai >= a[offset + largest]) break;

            a[offset + i] = a[offset + largest];
            i = largest;
        }

        a[offset + i] = ai;
    }
}
