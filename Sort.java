
public class Sort {

  public static <T extends Comparable<T>> void BublleSort(T[] T, int n) {
    int troca = 1;
    for (int i = 0; i < n; i++) {
      while (troca == 1) {
        troca = 0;
        for (int j = n; j > i; j--) {
          if (T[j].compareTo(T[j - 1]) == -1) {
            troca = 1;
            T temp = T[j];
            T[j] = T[j - 1];
            T[j - 1] = temp;
          }
        }
      }
    }
  }

  public static void main() {
    Integer X[] = { 8, 3, 15, 9, -1, 0, 15, -1, -19, 6, 7 };
    int n = X.length - 1;
    BublleSort(X, n);
    for (int i = 0; i < n; i++) {
      System.out.print(X[i] + "\t");
    }
  }
}
