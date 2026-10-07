public class SelectionSort {

  public static <T extends Comparable<T>> void Selection(T[] A, int n) {
    for (int i = 0; i < n - 1; i++) {
      int min;
      min = i;
      for (int j = i + 1; j < n; j++) {
        if (A[j].compareTo(A[min]) < 0) {
          min = j;
        }
        // troca A[i] com A[min];
        T temp;
        temp = A[i];
        A[i] = A[min];
        A[min] = temp;
      }

    }
  }

  public static void main() {
    Integer X[] = { 10, 2, 4, 7, 8, 1, 3, 5 };
    int tamanho = X.length;
    Selection(X, tamanho);
    for (int i = 0; i < tamanho; i++) {
      System.out.print(X[i] + "\t");
    }
  }
}
