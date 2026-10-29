
public class BubbleSort {

  public static <T extends Comparable<T>> void bubbleSort(T[] T, int n) {
    int troca = 1;
    for (int i = 0; i < n; i++) {
      while (troca == 1) {
        troca = 0;
        for (int j = n-1; j > i; j--) {
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
}
