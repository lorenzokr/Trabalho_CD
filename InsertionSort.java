public class InsertionSort {

  public static <T extends Comparable<T>> void insertionSort(T[] T, int n) {
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
}
