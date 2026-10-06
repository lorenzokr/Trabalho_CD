public class Sort {
  int p, q;

  public static int Particiona(int[] A, int p, int r) {
    int x, j;
    int temp;
    x = A[r];
    int i = p - 1;
    for (j = p; j < r - 1; j++) {
      if (A[j] <= A[x]) {
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

  public static void Quicksort(int[] A, int p, int r) {
    if (p < r) {
      int q = Particiona(A, p, r);
      Quicksort(A, p, q - 1);
      Quicksort(A, q + 1, r);
    }
  }

  public static void main() {
    int X[] = { 43, 12, 65, 23, 76 };
    Quicksort(X, 0, 4);
    for (int i = 0; i < 5; i++) {
      System.out.println(X[i]);
    }
  }
}
