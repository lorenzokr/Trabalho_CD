// nao testado ainda

public class CountingSort {

    public static void countingSort(int[] A, int n) {

        int k = getMax(A, n);
        int[] B = new int[n];
        int[] C = new int[k+1];

        // inicializa zerado
        for (int i=0; i<k; i++) {
            C[i] = 0;
        }

        //conta quantidade de vezes que cada valor aparece
        for (int i=0; i<n; i++) {
            C[A[i]] = C[A[i]] + 1;
        }
        // acumula posições
        for (int i=1; i<=k; i++) {
            C[i] = C[i] + C[i-1];
        }
        // copia de volta ordenado
        for (int i=n-1; i>=0; i--) {
            B[C[A[i]]-1] = A[i];
            C[A[i]] = C[A[i]] - 1;
        }

        for (int i=0; i<n; i++) {
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
