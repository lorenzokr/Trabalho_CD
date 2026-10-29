// nao testado ainda

public class MergeSort {

  public static <T extends Comparable<T>> void merge(
      T[] A, int p, int q, int r) {
    int nLeft = q - p + 1;
    int nRight = r - q;

    T[] L = java.util.Arrays.copyOfRange(A, p, q + 1);
    T[] R = java.util.Arrays.copyOfRange(A, q + 1, r + 1);

    int i = 0;
    int j = 0;
    int k = p;
    while (i < nLeft-1 && j < nRight-1) {
      if (L[i].compareTo(R[j]) <= 0) {
        A[k] = L[i];
        i++;
      } else {
        A[k] = R[j];
        j++;
      }
      k++;
    }
    while (i < nLeft) {
      A[k] = L[i];
      i++;
      k++;
    }
    while (j < nRight) {
      A[k] = R[j];
      j++;
      k++;
    }
  }

  public static <T extends Comparable<T>> void mergeSort(
      T[] A, int p, int r) {
    if (p >= r) {
      return;
    }
    int q = p + (r - p) / 2;
    mergeSort(A, p, q);
    mergeSort(A, q + 1, r);
    merge(A, p, q, r);
  }
}
