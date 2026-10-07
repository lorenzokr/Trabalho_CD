public class InsertionSort {

  public static <T extends Comparable<T>> void Insertion(T[] T, int n) {
    for (int i = 1; i < n; i++) {
      T chave;
      chave = T[i];
      // T[i] = chave;
      int j = i - 1;
      while (j >= 0 && (T[j].compareTo(chave)) > 0) {
        T[j + 1] = T[j];
        j = j - 1;
      }
      T[j + 1] = chave;
    }
  }

  public static void main() {
    Integer X[] = { 10, 2, 4, 7, 8, 1, 3, 5 };
    int tamanho = X.length;
    Insertion(X, tamanho);
    for (int i = 0; i < tamanho; i++) {
      System.out.print(X[i] + "\t");
    }
  }

}
