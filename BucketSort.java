import java.util.LinkedList;

public class BucketSort {
    public static void bucketSort(double[] T, int n) {

        int indice = 0;

        LinkedList<Double>[] vetorLinkado = new LinkedList[n];
        for (int i = 0; i<n; i++) {
            vetorLinkado[i] = new LinkedList<>();
        }

        for (int i = 0; i<n; i++) {
            indice = (int) (n*T[i]);
            vetorLinkado[indice].add(T[i]);
        }

        for (int i = 0; i<n; i++) {
            ordenarPorInsercao(vetorLinkado[i]);
        }

        indice = 0;
        for (int i = 0; i < n; i++) {
            for (double valor : vetorLinkado[i]) {
                T[indice] = valor;
                indice++;
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
