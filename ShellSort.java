public class ShellSort {

    public static <T extends Comparable<T>> void shellSort(T[] T, int n) {
        int h = 1;
        do {h = h*3+1;} while (h<n);
        do {
            h = h/3;
            for (int i = h+1; i<n; i++) {
                T temp = T[i]; 
                int j = i;
                while (T[j-h].compareTo(temp) > 0) {
                    T[j] = T[j-h];
                    j = j-h;
                    if (j <= h) { break; }
                }
                T[j] = temp;
            }
        }
        while(h!=1);
    }
}
