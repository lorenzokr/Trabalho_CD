public class RadixSort {

  public static void radixSort(Integer[] T, int n) {
    int[] A = new int[n];
    for (int i=0; i<n; i++) {
      A[i] = (int) T[i];
    }
    int max = CountingSort.getMax(A, n);
    for (int exp = 1; max / exp > 0; exp *= 10) {
      countingSortDigito(A, n, exp);
    }
    for (int i=0; i<n; i++) {
      T[i] = (Integer) A[i];
    }
  }

  private static void countingSortDigito(int[] A, int n, int exp) {
    int[] B = new int[n];
    int[] C = new int[10];
    for (int i = 0; i < n; i++) {
      int digito = (A[i] / exp) % 10;
      C[digito]++;
    }
    for (int i = 1; i < 10; i++) {
      C[i] += C[i - 1];
    }
    for (int i = n - 1; i >= 0; i--) {
      int digito = (A[i] / exp) % 10;
      B[C[digito] - 1] = A[i];
      C[digito]--;
    }
    for (int i = 0; i < n; i++) {
      A[i] = B[i];
    }
  }
}
