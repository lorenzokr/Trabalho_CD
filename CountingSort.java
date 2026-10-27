// nao testado ainda

public class CountingSort {

    public static <T extends Comparable<T>> void countingSort(T[] T, int n) {
        int k = getMax(T, n);
        int[] A = new int[n];
        int[] B = new int[n];
        int[] C = new int[k];

        // inicializa zerado e converte
        for (int i=0; i<=k; i++) {
            C[i] = 0;
            A[i] = T[i];
        }
        //conta quantidade de vezes que cada valor aparece
        for (i=1; i<=n; i++) {
            C[A[i]] = C[A[i]] + 1;
        }
        // acumula posições
        for (i=1; i<=k; i++) {
            C[i] = C[i] + C[i-1];
        }
        // copia de volta ordenado
        for (i=n; i>=1; i--) {
            B[C[A[i]]] = A[i];
            C[A[j]] = C[A[j]] - 1;
        }
    }
    for (int i = 0; i < n; i++) {
      C[A[i]]++;
    }
    for (int i = 1; i <= k; i++) {
      C[i] = C[i] + C[i - 1];
    }
    for (int i = n - 1; i >= 0; i--) {
      B[C[A[i]] - 1] = A[i];
      C[A[i]]--;
    }
    for (int i = 0; i < n; i++) {
      A[i] = B[i];
    }
  }

  public static int getMax(int[] A, int n) {
    int max = A[0];
    for (int i = 1; i < n; i++) {
      if (A[i] > max) {
        max = A[i];
      }
    }
    return max;
  }
}
