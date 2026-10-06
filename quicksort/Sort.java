public class Sort {
  int A[];

  public Sort(int A[]) {
    this.A = A;
  }

  public int Particiona(int p, int r) {
    int x, j;
    int temp;
    x = A[r];
    int i = p - 1;
    for (j = p; j < r; j++) {
      if (A[j] <= x) {
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

  public void Quicksort(int p, int r) {
    // System.out.println("valor do p" + p);
    // System.out.println("valor do r" + r);
    if (p < r) {
      int q = Particiona(p, r);
      // System.out.println("valor do q" + q);
      Quicksort(p, q - 1);
      Quicksort(q + 1, r);
    }
  }

  public static void main() {
    int X[] = { 0, 2, 4, 7, 8, 1, 3, 5, 6, 12, 65, 34, 34, 32, 87, 12, 65, 12, 89, 23, 45, 3, 9, 23, 767, 123, 341, 143,
        67 };
    int tamanho = X.length - 1;
    Sort s = new Sort(X);
    s.Quicksort(1, tamanho);
    for (int i = 0; i <= tamanho; i++) {
      System.out.println(X[i]);
    }
  }
}
