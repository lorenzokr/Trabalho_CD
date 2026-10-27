public class RadixSort {

  public static <T extends Comparable<T>> void radixSort(T[] T, int n) {

    int[] tempArr = new int[n];

    for (int i = 0; i < n; i++) {
      tempArr[i] = T[i];
    }

    int max = tempArr[0];

    for (int i = 1; i < T.length; i++) {
      if (tempArr[i] > max) {
        max = T[i];
      }
    }

    for (int exp = 1; max / exp > 0; exp *= 10) {
      countingSortByDigit(T, exp);
    }

    for (int i = 0; i < n; i++) {
      T[i] = tempArr[i];
    }
  }

  private static void countingSortByDigit(int[] arr, int exp) {
    int n = arr.length;
    int[] output = new int[n];
    int[] count = new int[10];

    for (int i = 0; i < n; i++) {
      int digit = (arr[i] / exp) % 10;
      count[digit]++;
    }

    for (int i = 1; i < 10; i++) {
      count[i] += count[i - 1];
    }

    for (int i = n - 1; i >= 0; i--) {
      int digit = (arr[i] / exp) % 10;
      output[count[digit] - 1] = arr[i];
      count[digit]--;
    }

    System.arraycopy(output, 0, arr, 0, n);
  }
}
