//não testado ainda

public class HeapSort {

    public static <T extends Comparable<T>> void heapSort(T[] T, int n) {

        //Constroi heap
        for (int i=n/2-1; i>=0; i--) {
            constroiMaxHeap(T, n, i);
        }

        T temp;
        for (int i=n-1; i>0; i--) {
            temp = T[i];
            T[i] = T[0];
            T[0] = temp;
            n--;
            constroiMaxHeap(T, i, 0);
        }
    }

    public static <T extends Comparable<T>> void constroiMaxHeap(T[] T, int n, int i) {
        int pai = i;
        int filho = 2*i+1;
        T temp;
        while (filho < n) {
            if (filho+1 < n && T[filho].compareTo(T[filho+1]) < 0) {
                filho++;
            }
            if (T[filho].compareTo(T[pai]) > 0) {
                temp = T[filho];
                T[filho] = T[pai];
                T[pai] = temp;
                pai = filho;
                filho = pai*2 + 1;
            }
            else {
                break;
            }
        }
    }
}

