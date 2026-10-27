//não testado ainda

public class HeapSort {

    public static <T extends Comparable<T>> void heapSort(T[] T, int n) {

        //Constroi heap
        for (i=n/2; i>0; i--) {
            constroiMaxHeap(T, n, i);
        }

        T temp;
        for (i=n; i>=1; i--) {
            temp = T[i];
            T[i] = T[1];
            T[1] = temp;
            n--;
            constroiMaxHeap(T, n, i);
        }
    }

    public static <T extends Comparable<T>> void constroiMaxHeap(T[] T, int n, int i) {
        pai = i;
        filho = 2*i+1;
        T temp;
        while (filho <= n) {
            if (filho+1 <= n && T[filho].compareTo(T[filho+1]) < 0) {
                filho++;
            }
            if (T[filho].compareTo(T[pai]) > 0) {
                temp = T[filho];
                T[filho] = T[pai];
                T[pai] = temp;
                pai = filho;
                filho = filho*2;
            }
            else {
                break;
            }
        }
    }
}

