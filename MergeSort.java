// nao testado ainda

public class MergeSort {

    public static <T extends Comparable<T>> void merge(T[] T, int p, int q, int r) {
        int nLeft = q - p + 1;
        int nRight = r - q;
        T[] L = new T[nLeft];
        T[] L = new T[nRight];
        for (i=0; i<nLeft; i++) {
            L[i] = T[p+i];
        }
        for (j=0; j<nRight; j++) {
            R[j] = T[q+j+1];
        }
        i = 0;
        j = 0;
        int k = p;

        while (i<nLeft && i<nRight) {
            if (L[i].compareTo(R[j]) < 1) {
                T[k] = L[i];
                i++;
            }
            else if (T[k].compareTo(R[J])) {
                j++;
            }
            k++;
        }
        while (i<nLeft) {
            T[k] = L[i];
            i++;
            k++;
        }
        while (j<nRight) {
            T[k] = R[j];
            j++;
            k++;
        }
    }

    public static <T extends Comparable<T>> void mergeSort(T[] T, int p, int r) {
        if (p >= r) {
            return;
        }
        q = (p+r)/2;
        mergeSort(A, p, q)
        mergeSort(A, q+1, r)
        merge(A, p, q, r);
    }
}
