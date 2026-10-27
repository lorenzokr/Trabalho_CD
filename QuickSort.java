public class QuickSort {
  int p, q;

  public static <T extends Comparable<T>> int Particiona(
      T[] A, int p, int r) {
    T x = A[r];
    int i = p - 1;
    for (int j = p; j < r; j++) {
      if (A[j].compareTo(x) <= 0) {
        i++;
        T temp = A[i];
        A[i] = A[j];
        A[j] = temp;
      }
    }
    T temp = A[i + 1];
    A[i + 1] = A[r];
    A[r] = temp;
    return i + 1;
  }

  public static <T extends Comparable<T>> void quickSort(
      T[] A, int p, int r) {
    if (p < r) {
      int q = Particiona(A, p, r);
      quickSort(A, p, q - 1);
      quickSort(A, q + 1, r);
    }
  }

  public static void main(String[] args) {
    Integer[] X = { 43, 12, 65, 23, 76 };
    quickSort(X, 0, X.length - 1);
    for (int i = 0; i < X.length; i++) {
      System.out.println(X[i]);
    }
  }
}
