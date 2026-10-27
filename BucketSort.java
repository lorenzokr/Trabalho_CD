import java.util.LinkedList;

public class BucketSort {
    public static <T extends Comparable<T>> void bucketSort(T[] T, int n) {

        LinkedList<Double>[] vetorLinkado = new LinkedList[n];
        int indice = 0;
        double[] vetorDouble = new double[n];

        for (int i = 0; i<n; i++) {
            vetorLinkado[i] = new LinkedList<>();
            vetorDouble[i] = T[i];
        }

        for (i = 0; i<n; i++) {
            indice = (int) (n*A[i]);
            indice = Math.min(indice, n);
            vetorLinkado[indice].add(vetorDouble[i]);
        }

        for (i = 0; i<n; i++) {
            ordenarPorInsercao(vetorLinkado[i]);
        }

        for (int i = 0; i < n; i++) {
            for (double valor : B[i]) {
                T[indice++] = valor;
            }
        }
    }

    private static void ordenarPorInsercao(LinkedList<Double> lista) {
        for (int i = 1; i < lista.size(); i++) {
            double valor = lista.get(i);
            int j = i - 1;

            while (j >= 0 && lista.get(j) > valor) {
                lista.set(j + 1, lista.get(j));
                j--;
            }

            lista.set(j + 1, valor);
        }
    }
}
