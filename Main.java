public class Main {

    public static void main(String args[]) {
        Integer X[] = { 0, 2, 4, 7, 8, 1, 3, 5, 6, 12, 65, 34, 34, 32, 87, 12, 65, 12, 89, 23, 45, 3, 9, 23, 767, 123, 341, 143, 67 };
        int tamanho = X.length -1;
        
        QuickSort.Quicksort(1, tamanho, X);
        
        for (int i = 0; i <= tamanho; i++) {
            System.out.println(X[i]);
        }
    }
}
