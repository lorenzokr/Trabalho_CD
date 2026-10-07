public class Sort {

  public static <T extends Comparable<T>> int Particiona(int p, int r, T[] A) {
    int j;
    T x, temp;
    x = A[r];
    int i = p - 1;
    for (j = p; j < r; j++) {
      if (A[j].compareTo(x) <= 0) {
        i++;
        temp = A[i];
        A[i] = A[j];
        A[j] = temp;
      }
    }
    temp = A[i + 1];
    A[i + 1] = A[r];
    A[r] = temp;
    return i + 1;
  }

  public static <T extends Comparable<T>> void Quicksort(int p, int r, T[] A) {
    // System.out.println("valor do p" + p);
    // System.out.println("valor do r" + r);
    if (p < r) {
      int q = Particiona(p, r, A);
      // System.out.println("valor do q" + q);
      Quicksort(p, q - 1, A);
      Quicksort(q + 1, r, A);
    }
  }

  public static void main() {
    Integer X[] = { 0, 2, 4, 7, 8, 1, 3, 5, 6, 12, 65, 34, 34, 32, 87, 12, 65, 12, 89, 23, 45, 3, 9, 23, 767, 123, 341,
        143,
        67 };
    int tamanho = X.length - 1;
    Quicksort(1, tamanho, X);
    for (int i = 0; i <= tamanho; i++) {
      System.out.println(X[i]);
    }
  }
}
