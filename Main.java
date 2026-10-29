import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class Main {

    private static final int RODADAS = 10;

    private static final String[] ALGORITMOS_COMPARAVEIS = {
        "BubbleSort",
        "HeapSort",
        "InsertionSort",
        "MergeSort",
        "QuickSort",
        "SelectionSort",
        "ShellSort"
    };

    @FunctionalInterface
    private interface OrdenadorComparable {
        void ordenar(Integer[] vetor);
    }

    @FunctionalInterface
    private interface OrdenadorInteiro {
        void ordenar(int[] vetor);
    }

    @FunctionalInterface
    private interface OrdenadorDouble {
        void ordenar(double[] vetor);
    }

    public static void main(String[] args) {

        // Entradas pequenas para testar antes da execução completa.
        int[] entradas = {10, 20, 30, 40, 50};

        // Entradas para o experimento completo.
        // int[] entradas = {1000, 10000, 100000, 1000000, 10000000};

        System.out.println("\n\nIniciando execução");

        try (PrintWriter arquivo =
                new PrintWriter(new FileWriter("resultados.csv"))) {

            arquivo.println(
                "Rodada,Algoritmo,Tamanho,Ordem,Tempo_ns,Status"
            );
            arquivo.flush();

            // -=-=-=-=-=-=-=-=- AQUECEDORES DE CACHE -=-=-=-=-=-=-=-=-=-


            System.out.println("\nAquecendo os algoritmos");

            Integer[] vetorInteger = gerarVetorComparable(1, 0);
            int[] vetorInteiro = gerarVetorInteiro(1, 0);
            int[] vetorCounting = gerarVetorInteiroCounting(1, 0);
            double[] vetorDouble = gerarVetorDouble(1, 0);

            BubbleSort.bubbleSort(Arrays.copyOf(vetorInteger, 1), 1);
            System.out.println("BubbleSort aquecido");

            BucketSort.bucketSort(Arrays.copyOf(vetorDouble, 1), 1);
            System.out.println("BucketSort aquecido");

            CountingSort.countingSort(Arrays.copyOf(vetorCounting, 1), 1);
            System.out.println("CountingSort aquecido");

            HeapSort.heapSort(Arrays.copyOf(vetorInteger, 1), 1);
            System.out.println("HeapSort aquecido");

            InsertionSort.insertionSort(Arrays.copyOf(vetorInteger, 1), 1);
            System.out.println("InsertionSort aquecido");

            MergeSort.mergeSort(
                Arrays.copyOf(vetorInteger, 1), 0, 0
            );
            System.out.println("MergeSort aquecido");

            QuickSort.quickSort(
                Arrays.copyOf(vetorInteger, 1), 0, 0
            );
            System.out.println("QuickSort aquecido");

            RadixSort.radixSort(Arrays.copyOf(vetorInteiro, 1), 1);
            System.out.println("RadixSort aquecido");

            SelectionSort.selectionSort(
                Arrays.copyOf(vetorInteger, 1), 1
            );
            System.out.println("SelectionSort aquecido");

            ShellSort.shellSort(Arrays.copyOf(vetorInteger, 1), 1);
            System.out.println("ShellSort aquecido");


            // -=-=-=-=-=-=-=-=- EXPERIMENTO -=-=-=-=-=-=-=-=-=-


            for (int rodada = 1; rodada <= RODADAS; rodada++) {

                System.out.println(
                    "\n\n========== RODADA " + rodada
                    + " DE " + RODADAS + " =========="
                );

                for (int entrada : entradas) {

                    System.out.println(
                        "\n\nTamanho: " + entrada
                    );

                    // Todos os tamanhos recebem vetores aleatórios.
                    executarConfiguracao(
                        arquivo, rodada, entrada, "Aleatorio", 0
                    );

                    // Os vetores ordenados são testados apenas
                    // para um milhão de elementos.
                    if (entrada == 1000000) {

                        executarConfiguracao(
                            arquivo, rodada, entrada, "Crescente", 1
                        );

                        executarConfiguracao(
                            arquivo, rodada, entrada, "Decrescente", 2
                        );
                    }
                }
            }

            System.out.println("\n\nExperimento encerrado.");

        } catch (IOException e) {
            System.out.println(
                "Erro ao escrever o arquivo: " + e.getMessage()
            );
        }
    }


    private static void executarConfiguracao(
            PrintWriter arquivo,
            int rodada,
            int tamanho,
            String ordem,
            int tipoOrdem) {

        System.out.println(
            "\n--- " + ordem + " | Tamanho: " + tamanho
            + " | Rodada: " + rodada + " ---"
        );

        executarComparacoes(
            arquivo, rodada, tamanho, ordem, tipoOrdem
        );

        executarCounting(
            arquivo, rodada, tamanho, ordem, tipoOrdem
        );

        executarRadix(
            arquivo, rodada, tamanho, ordem, tipoOrdem
        );

        executarBucket(
            arquivo, rodada, tamanho, ordem, tipoOrdem
        );
    }


    // -=-=-=-=-=-=-=-=- ALGORITMOS COMPARÁVEIS -=-=-=-=-=-=-=-=-=-


    private static void executarComparacoes(
            PrintWriter arquivo,
            int rodada,
            int tamanho,
            String ordem,
            int tipoOrdem) {

        Integer[] original;

        try {
            original = gerarVetorComparable(tamanho, tipoOrdem);
        } catch (OutOfMemoryError e) {
            System.out.println(
                "Memória insuficiente para gerar Integer[] de "
                + tamanho + " elementos."
            );

            for (String algoritmo : ALGORITMOS_COMPARAVEIS) {
                registrarFalha(
                    arquivo, rodada, algoritmo, tamanho, ordem
                );
            }

            System.gc();
            return;
        }

        medirComparable(
            arquivo, rodada, "BubbleSort", tamanho, ordem,
            original,
            vetor -> BubbleSort.bubbleSort(vetor, vetor.length)
        );

        medirComparable(
            arquivo, rodada, "HeapSort", tamanho, ordem,
            original,
            vetor -> HeapSort.heapSort(vetor, vetor.length)
        );

        medirComparable(
            arquivo, rodada, "InsertionSort", tamanho, ordem,
            original,
            vetor -> InsertionSort.insertionSort(vetor, vetor.length)
        );

        medirComparable(
            arquivo, rodada, "MergeSort", tamanho, ordem,
            original,
            vetor -> MergeSort.mergeSort(
                vetor, 0, vetor.length - 1
            )
        );

        medirComparable(
            arquivo, rodada, "QuickSort", tamanho, ordem,
            original,
            vetor -> QuickSort.quickSort(
                vetor, 0, vetor.length - 1
            )
        );

        medirComparable(
            arquivo, rodada, "SelectionSort", tamanho, ordem,
            original,
            vetor -> SelectionSort.selectionSort(vetor, vetor.length)
        );

        medirComparable(
            arquivo, rodada, "ShellSort", tamanho, ordem,
            original,
            vetor -> ShellSort.shellSort(vetor, vetor.length)
        );
    }


    private static void medirComparable(
            PrintWriter arquivo,
            int rodada,
            String algoritmo,
            int tamanho,
            String ordem,
            Integer[] original,
            OrdenadorComparable ordenador) {

        try {
            // A cópia é criada antes da medição.
            Integer[] copia = Arrays.copyOf(
                original, original.length
            );

            long inicio = System.nanoTime();

            ordenador.ordenar(copia);

            long fim = System.nanoTime();

            registrarResultado(
                arquivo, rodada, algoritmo, tamanho, ordem,
                fim - inicio, "OK"
            );

        } catch (OutOfMemoryError e) {
            System.out.println(
                algoritmo + ": memória insuficiente para "
                + tamanho + " elementos."
            );

            registrarFalha(
                arquivo, rodada, algoritmo, tamanho, ordem
            );

            System.gc();
        }
    }


    // -=-=-=-=-=-=-=-=- COUNTING SORT -=-=-=-=-=-=-=-=-=-


    private static void executarCounting(
            PrintWriter arquivo,
            int rodada,
            int tamanho,
            String ordem,
            int tipoOrdem) {

        int[] original;

        try {
            original = gerarVetorInteiroCounting(
                tamanho, tipoOrdem
            );
        } catch (OutOfMemoryError e) {
            System.out.println(
                "CountingSort: memória insuficiente para gerar "
                + tamanho + " elementos."
            );

            registrarFalha(
                arquivo, rodada, "CountingSort",
                tamanho, ordem
            );

            System.gc();
            return;
        }

        medirInteiro(
            arquivo, rodada, "CountingSort", tamanho, ordem,
            original,
            vetor -> CountingSort.countingSort(vetor, vetor.length)
        );
    }


    // -=-=-=-=-=-=-=-=- RADIX SORT -=-=-=-=-=-=-=-=-=-


    private static void executarRadix(
            PrintWriter arquivo,
            int rodada,
            int tamanho,
            String ordem,
            int tipoOrdem) {

        int[] original;

        try {
            original = gerarVetorInteiro(tamanho, tipoOrdem);
        } catch (OutOfMemoryError e) {
            System.out.println(
                "RadixSort: memória insuficiente para gerar "
                + tamanho + " elementos."
            );

            registrarFalha(
                arquivo, rodada, "RadixSort", tamanho, ordem
            );

            System.gc();
            return;
        }

        medirInteiro(
            arquivo, rodada, "RadixSort", tamanho, ordem,
            original,
            vetor -> RadixSort.radixSort(vetor, vetor.length)
        );
    }


    private static void medirInteiro(
            PrintWriter arquivo,
            int rodada,
            String algoritmo,
            int tamanho,
            String ordem,
            int[] original,
            OrdenadorInteiro ordenador) {

        try {
            // A cópia é criada antes da medição.
            int[] copia = Arrays.copyOf(
                original, original.length
            );

            long inicio = System.nanoTime();

            ordenador.ordenar(copia);

            long fim = System.nanoTime();

            registrarResultado(
                arquivo, rodada, algoritmo, tamanho, ordem,
                fim - inicio, "OK"
            );

        } catch (OutOfMemoryError e) {
            System.out.println(
                algoritmo + ": memória insuficiente para "
                + tamanho + " elementos."
            );

            registrarFalha(
                arquivo, rodada, algoritmo, tamanho, ordem
            );

            System.gc();
        }
    }


    // -=-=-=-=-=-=-=-=- BUCKET SORT -=-=-=-=-=-=-=-=-=-


    private static void executarBucket(
            PrintWriter arquivo,
            int rodada,
            int tamanho,
            String ordem,
            int tipoOrdem) {

        double[] original;

        try {
            original = gerarVetorDouble(tamanho, tipoOrdem);
        } catch (OutOfMemoryError e) {
            System.out.println(
                "BucketSort: memória insuficiente para gerar "
                + tamanho + " elementos."
            );

            registrarFalha(
                arquivo, rodada, "BucketSort", tamanho, ordem
            );

            System.gc();
            return;
        }

        medirDouble(
            arquivo, rodada, "BucketSort", tamanho, ordem,
            original,
            vetor -> BucketSort.bucketSort(vetor, vetor.length)
        );
    }


    private static void medirDouble(
            PrintWriter arquivo,
            int rodada,
            String algoritmo,
            int tamanho,
            String ordem,
            double[] original,
            OrdenadorDouble ordenador) {

        try {
            // A cópia é criada antes da medição.
            double[] copia = Arrays.copyOf(
                original, original.length
            );

            long inicio = System.nanoTime();

            ordenador.ordenar(copia);

            long fim = System.nanoTime();

            registrarResultado(
                arquivo, rodada, algoritmo, tamanho, ordem,
                fim - inicio, "OK"
            );

        } catch (OutOfMemoryError e) {
            System.out.println(
                algoritmo + ": memória insuficiente para "
                + tamanho + " elementos."
            );

            registrarFalha(
                arquivo, rodada, algoritmo, tamanho, ordem
            );

            System.gc();
        }
    }


    // -=-=-=-=-=-=-=-=- REGISTRO DOS RESULTADOS -=-=-=-=-=-=-=-=-=-


    private static void registrarResultado(
            PrintWriter arquivo,
            int rodada,
            String algoritmo,
            int tamanho,
            String ordem,
            long tempo,
            String status) {

        arquivo.println(
            rodada + ","
            + algoritmo + ","
            + tamanho + ","
            + ordem + ","
            + tempo + ","
            + status
        );

        // Envia o resultado ao arquivo imediatamente.
        arquivo.flush();

        System.out.println(
            algoritmo + " | " + ordem
            + " | " + tamanho
            + " elementos | " + tempo
            + " ns | " + status
        );
    }


    private static void registrarFalha(
            PrintWriter arquivo,
            int rodada,
            String algoritmo,
            int tamanho,
            String ordem) {

        registrarResultado(
            arquivo, rodada, algoritmo, tamanho,
            ordem, -1, "OUT_OF_MEMORY"
        );
    }


    // -=-=-=-=-=-=-=-=- TESTES COMENTADOS -=-=-=-=-=-=-=-=-=-


    /* testes

    Integer X[] = { 0, 2, 4, 7, 8, 1, 3, 5, 6, 12, 65, 34, 34, 32, 87, 12, 65, 12, 89, 23, 45, 3, 9, 23, 767, 123, 341, 143, 67 };



    Integer XX[] = { 0, 2, 4, 7, 8, 1, 3, 5, 6, 12, 65, 34, 34, 32, 87, 12, 65, 12, 89, 23, 45, 3, 9, 23, 767, 123, 341, 143, 67 };
    tamanho = XX.length;

    QuickSort.quickSort(XX, 0, tamanho - 1);
    System.out.println("\n\nQuickSort");

    for (int i = 0; i < tamanho; i++) {
      System.out.println(XX[i]);
    }


    Integer XXX[] = { 0, 2, 4, 7, 8, 1, 3, 5, 6, 12, 65, 34, 34, 32, 87, 12, 65, 12, 89, 23, 45, 3, 9, 23, 767, 123, 341, 143, 67 };
    tamanho = XXX.length;

    BubbleSort.bubbleSort(XXX, tamanho);
    System.out.println("\n\nBubbleSort");

    for (int i = 0; i < tamanho; i++) {
      System.out.println(XXX[i]);
    }


    Integer XXXX[] = { 0, 2, 4, 7, 8, 1, 3, 5, 6, 12, 65, 34, 34, 32, 87, 12, 65, 12, 89, 23, 45, 3, 9, 23, 767, 123, 341, 143, 67 };
    tamanho = XXXX.length;

    CountingSort.countingSort(XXXX, tamanho);
    System.out.println("\n\nCountingSort");

    for (int i = 0; i < tamanho; i++) {
      System.out.println(XXXX[i]);
    }


    Integer XXXXX[] = { 0, 2, 4, 7, 8, 1, 3, 5, 6, 12, 65, 34, 34, 32, 87, 12, 65, 12, 89, 23, 45, 3, 9, 23, 767, 123, 341, 143, 67 };
    tamanho = XXXXX.length;

    HeapSort.heapSort(XXXXX, tamanho);
    System.out.println("\n\nHeapSort");

    for (int i = 0; i < tamanho; i++) {
      System.out.println(XXXXX[i]);
    }


    Integer XXXXXX[] = { 0, 2, 4, 7, 8, 1, 3, 5, 6, 12, 65, 34, 34, 32, 87, 12, 65, 12, 89, 23, 45, 3, 9, 23, 767, 123, 341, 143, 67 };
    tamanho = XXXXXX.length;

    InsertionSort.insertionSort(XXXXXX, tamanho);
    System.out.println("\n\nInsertionSort");

    for (int i = 0; i < tamanho; i++) {
      System.out.println(XXXXXX[i]);
    }


    int XXXXXXX[] = { 0, 2, 4, 7, 8, 1, 3, 5, 6, 12, 65, 34, 34, 32, 87, 12, 65, 12, 89, 23, 45, 3, 9, 23, 767, 123, 341, 143, 67 };
    tamanho = XXXXXXX.length;

    RadixSort.radixSort(XXXXXXX, tamanho);
    System.out.println("\n\nRadixSort");

    for (int i = 0; i < tamanho; i++) {
      System.out.println(XXXXXXX[i]);
    }


    Integer XXXXXXXX[] = { 0, 2, 4, 7, 8, 1, 3, 5, 6, 12, 65, 34, 34, 32, 87, 12, 65, 12, 89, 23, 45, 3, 9, 23, 767, 123, 341, 143, 67 };
    tamanho = XXXXXXXX.length;

    SelectionSort.selectionSort(XXXXXXXX, tamanho);
    System.out.println("\n\nSelectionSort");

    for (int i = 0; i < tamanho; i++) {
      System.out.println(XXXXXXXX[i]);
    }


    Integer XXXXXXXXX[] = { 0, 2, 4, 7, 8, 1, 3, 5, 6, 12, 65, 34, 34, 32, 87, 12, 65, 12, 89, 23, 45, 3, 9, 23, 767, 123, 341, 143, 67 };
    tamanho = XXXXXXXXX.length;

    ShellSort.shellSort(XXXXXXXXX, tamanho);
    System.out.println("\n\nShellSort");

    for (int i = 0; i < tamanho; i++) {
      System.out.println(XXXXXXXXX[i]);
    }


    double[] XXXXXXXXXX = gerarVetorDouble(20, 0);
    tamanho = XXXXXXXXXX.length;

    BucketSort.bucketSort(XXXXXXXXXX, tamanho);
    System.out.println("\n\nBucketSort");

    for (int i = 0; i < tamanho; i++) {
      System.out.println(XXXXXXXXXX[i]);
    }

    */


    // -=-=-=-=-=-=-=-=- GERADORES DE VETORES -=-=-=-=-=-=-=-=-=-


    private static Integer[] gerarVetorComparable(
            int n, int ordem) {

        Random gerador = new Random();

        Integer[] vetor = new Integer[n];

        if (ordem == 0) {
            for (int i = 0; i < n; i++) {
                vetor[i] = gerador.nextInt();
            }
        } else if (ordem == 1) {
            for (int i = 0; i < n; i++) {
                vetor[i] = i;
            }
        } else if (ordem == 2) {
            for (int i = 0; i < n; i++) {
                vetor[i] = n - 1 - i;
            }
        }

        return vetor;
    }


    private static int[] gerarVetorInteiro(
            int n, int ordem) {

        Random gerador = new Random();

        int[] vetor = new int[n];

        if (ordem == 0) {
            for (int i = 0; i < n; i++) {
                vetor[i] = gerador.nextInt(Integer.MAX_VALUE);
            }
        } else if (ordem == 1) {
            for (int i = 0; i < n; i++) {
                vetor[i] = i;
            }
        } else if (ordem == 2) {
            for (int i = 0; i < n; i++) {
                vetor[i] = n - 1 - i;
            }
        }

        return vetor;
    }


    private static int[] gerarVetorInteiroCounting(
            int n, int ordem) {

        Random gerador = new Random();

        int[] vetor = new int[n];

        if (ordem == 0) {
            for (int i = 0; i < n; i++) {
                vetor[i] = gerador.nextInt(1000);
            }
        } else if (ordem == 1) {
            for (int i = 0; i < n; i++) {
                vetor[i] = (int) ((long) i * 10000 / n);
            }
        } else if (ordem == 2) {
            for (int i = 0; i < n; i++) {
                vetor[i] = (int) ((long) (n - 1 - i) * 10000 / n);
            }
        }

        return vetor;
    }


    private static double[] gerarVetorDouble(
            int n, int ordem) {

        Random gerador = new Random();

        double[] vetor = new double[n];

        if (ordem == 0) {
            for (int i = 0; i < n; i++) {
                vetor[i] = gerador.nextDouble();
            }
        } else if (ordem == 1) {
            for (int i = 0; i < n; i++) {
                vetor[i] = (double) i / n;
            }
        } else if (ordem == 2) {
            for (int i = 0; i < n; i++) {
                vetor[i] = (double) (n - 1 - i) / n;
            }
        }

        return vetor;
    }

}
