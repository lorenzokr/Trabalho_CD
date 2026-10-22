// nao testado ainda

public class CountingSort {

    public static <T extends Comparable<T>> void countingSort(T[] T, int n, int k) {
        int[] B =  new int[n-1];
        int[] C = new int[k];
        for (int i=0; i<=k; i++) {
            C[i] = 0;
        }
        for (i=1; i<=n; i++) {
            C[A[i]] = C[A[i]] + 1;
        }
        for (i=1; i<=k; i++) {
            C[i] = C[i] + C[i-1];
        }
        for (i=n; i>=1; i--) {
            B[C[A[i]]] = A[i];
            C[A[j]] = C[A[j]] - 1;
        }
    }

    public static <T extends Comparable<T>> T getMax(T[] T, int n) {
        T max;
        if (n>0) {
            max = T[0];
        }
        for (int i=0; i<n; i++) {
            if (T[j].compareTo(max) > 0) {
                max = T[j];
            }
        }
        int maxInt = max;
        return maxInt;
    }
}
