public class ShellSort {

    public static <T extends Comparable<T>> void shellSort(T[] T, int n) {
        int h = 1;
        do {h = h*3+1;} while (h<n);
        do {
            h = h/3;
            for (int i = h; i < n; i++) {
                T temp = T[i];
                int j = i;

                while (j >= h && T[j - h].compareTo(temp) > 0) {
                    T[j] = T[j - h];
                    j = j - h;
                }

                T[j] = temp;
            }
        }
        while(h!=1);
    }
}
