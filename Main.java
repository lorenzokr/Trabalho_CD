import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class Main {

  public static void main(String args[]) {

    // int[] entradas = {10, 20, 30, 40, 50};
    int[] entradas = { 10, 100, 1000, 10000, 100000 };

    System.out.println("\n\n Iniciando execução");

    try (PrintWriter arquivo = new PrintWriter(new FileWriter("resultados.csv"))) {

      arquivo.println("Rodada,Algoritmo,Tamanho,Ordem,Tempo_ns,Status");
      arquivo.flush();

      long inicio;
      long fim;

      Integer[] vetorInteger;
      Integer[] vetorOriginal;
      int[] vetorInteiro;
      int[] vetorOriginalInteiro;
      double[] vetorDouble;
      double[] vetorOriginalDouble;

      // -=-=-=-=-=-=-=-=- AQUECEDORES DE CACHE -=-=-=-=-=-=-=-=-=-

      System.out.println("\n\n Aquecendo os algoritmos");

      vetorInteger = gerarVetorComparable(1, 0);
      BubbleSort.bubbleSort(Arrays.copyOf(vetorInteger, vetorInteger.length), 1);

      vetorInteger = gerarVetorComparable(1, 0);
      HeapSort.heapSort(Arrays.copyOf(vetorInteger, vetorInteger.length), 1);

      vetorInteger = gerarVetorComparable(1, 0);
      InsertionSort.insertionSort(Arrays.copyOf(vetorInteger, vetorInteger.length), 1);

      vetorInteger = gerarVetorComparable(1, 0);
      MergeSort.mergeSort(Arrays.copyOf(vetorInteger, vetorInteger.length), 0, 0);

      vetorInteger = gerarVetorComparable(1, 0);
      QuickSort.quickSort(Arrays.copyOf(vetorInteger, vetorInteger.length), 0, 0);

      vetorInteger = gerarVetorComparable(1, 0);
      SelectionSort.selectionSort(Arrays.copyOf(vetorInteger, vetorInteger.length), 1);

      vetorInteger = gerarVetorComparable(1, 0);
      ShellSort.shellSort(Arrays.copyOf(vetorInteger, vetorInteger.length), 1);

      vetorInteiro = gerarVetorInteiroCounting(1, 0);
      CountingSort.countingSort(Arrays.copyOf(vetorInteiro, vetorInteiro.length), 1);

      vetorInteiro = gerarVetorInteiro(1, 0);
      RadixSort.radixSort(Arrays.copyOf(vetorInteiro, vetorInteiro.length), 1);

      vetorDouble = gerarVetorDouble(1, 0);
      BucketSort.bucketSort(Arrays.copyOf(vetorDouble, vetorDouble.length), 1);

      System.out.println("Aquecimento encerrado");

      // -=-=-=-=-=-=-=-=- EXECUÇÃO DOS TESTES -=-=-=-=-=-=-=-=-=-

      for (int rodada = 1; rodada <= 10; rodada++) {

        System.out.println("\n\n================ RODADA " + rodada + " ================");

        for (int entrada : entradas) {

          System.out.println("\n\nTamanho da entrada: " + entrada);

          // Para os tamanhos menores, testar somente vetores aleatórios.
          // Para 1.000.000, testar aleatório, crescente e decrescente.
          // Para 10.000.000, testar somente aleatório.

          int primeiraOrdem = 0;
          int ultimaOrdem = 0;

          if (entrada == 1000000) {
            primeiraOrdem = 0;
            ultimaOrdem = 2;
          }

          for (int ordem = primeiraOrdem; ordem <= ultimaOrdem; ordem++) {

            String nomeOrdem = "Aleatorio";

            if (ordem == 1) {
              nomeOrdem = "Crescente";
            }

            else if (ordem == 2) {
              nomeOrdem = "Decrescente";
            }

            System.out.println("\nConfiguração: " + nomeOrdem);

            // -=-=-=-=-=-=-=-=- BUBBLE SORT -=-=-=-=-=-=-=-=-=-

            vetorOriginal = gerarVetorComparable(entrada, ordem);

            try {

              vetorInteger = Arrays.copyOf(vetorOriginal, vetorOriginal.length);

              inicio = System.nanoTime();
              BubbleSort.bubbleSort(vetorInteger, vetorInteger.length);
              fim = System.nanoTime();

              arquivo.println(rodada + ",BubbleSort," + entrada + "," + nomeOrdem + "," + (fim - inicio) + ",OK");
              arquivo.flush();

              System.out.println("BubbleSort: " + (fim - inicio) + " ns");

            }

            catch (OutOfMemoryError e) {

              arquivo.println(rodada + ",BubbleSort," + entrada + "," + nomeOrdem + ",-1,OUT_OF_MEMORY");
              arquivo.flush();

              System.out.println("BubbleSort: memória insuficiente");
              System.gc();

            }

            // -=-=-=-=-=-=-=-=- HEAP SORT -=-=-=-=-=-=-=-=-=-

            try {

              vetorInteger = Arrays.copyOf(vetorOriginal, vetorOriginal.length);

              inicio = System.nanoTime();
              HeapSort.heapSort(vetorInteger, vetorInteger.length);
              fim = System.nanoTime();

              arquivo.println(rodada + ",HeapSort," + entrada + "," + nomeOrdem + "," + (fim - inicio) + ",OK");
              arquivo.flush();

              System.out.println("HeapSort: " + (fim - inicio) + " ns");

            }

            catch (OutOfMemoryError e) {

              arquivo.println(rodada + ",HeapSort," + entrada + "," + nomeOrdem + ",-1,OUT_OF_MEMORY");
              arquivo.flush();

              System.out.println("HeapSort: memória insuficiente");
              System.gc();

            }

            // -=-=-=-=-=-=-=-=- INSERTION SORT -=-=-=-=-=-=-=-=-=-

            try {

              vetorInteger = Arrays.copyOf(vetorOriginal, vetorOriginal.length);

              inicio = System.nanoTime();
              InsertionSort.insertionSort(vetorInteger, vetorInteger.length);
              fim = System.nanoTime();

              arquivo.println(rodada + ",InsertionSort," + entrada + "," + nomeOrdem + "," + (fim - inicio) + ",OK");
              arquivo.flush();

              System.out.println("InsertionSort: " + (fim - inicio) + " ns");

            }

            catch (OutOfMemoryError e) {

              arquivo.println(rodada + ",InsertionSort," + entrada + "," + nomeOrdem + ",-1,OUT_OF_MEMORY");
              arquivo.flush();

              System.out.println("InsertionSort: memória insuficiente");
              System.gc();

            }

            // -=-=-=-=-=-=-=-=- MERGE SORT -=-=-=-=-=-=-=-=-=-

            try {

              vetorInteger = Arrays.copyOf(vetorOriginal, vetorOriginal.length);

              try {
                inicio = System.nanoTime();
                MergeSort.mergeSort(vetorInteger, 0, vetorInteger.length - 1);
                fim = System.nanoTime();

                arquivo.println(rodada + ",MergeSort," + entrada + "," + nomeOrdem + "," + (fim - inicio) + ",OK");
                arquivo.flush();
                System.out.println("MergeSort: " + (fim - inicio) + " ns");
              } catch (StackOverflowError e) {
                System.out.println("Stack overflow: o QuickSort excedeu a pilha.");
                arquivo.println(rodada + ",MergeSort," + entrada + "," + nomeOrdem + ",-1,STACK_OVERFLOW");
                arquivo.flush();
              }

            }

            catch (OutOfMemoryError e) {

              arquivo.println(rodada + ",MergeSort," + entrada + "," + nomeOrdem + ",-1,OUT_OF_MEMORY");
              arquivo.flush();

              System.out.println("MergeSort: memória insuficiente");
              System.gc();

            }

            // -=-=-=-=-=-=-=-=- QUICK SORT -=-=-=-=-=-=-=-=-=-

            try {

              vetorInteger = Arrays.copyOf(vetorOriginal, vetorOriginal.length);

              try {
                inicio = System.nanoTime();
                QuickSort.quickSort(vetorInteger, 0, vetorInteger.length - 1);
                fim = System.nanoTime();
                arquivo.println(rodada + ",QuickSort," + entrada + "," + nomeOrdem + "," + (fim - inicio) + ",OK");
                arquivo.flush();
                System.out.println("QuickSort: " + (fim - inicio) + " ns");
              } catch (StackOverflowError e) {
                System.out.println("Stack overflow: o QuickSort excedeu a pilha.");
                arquivo.println(rodada + ",QuickSort," + entrada + "," + nomeOrdem + ",-1,STACK_OVERFLOW");
                arquivo.flush();
              }

            }

            catch (OutOfMemoryError e) {

              arquivo.println(rodada + ",QuickSort," + entrada + "," + nomeOrdem + ",-1,OUT_OF_MEMORY");
              arquivo.flush();

              System.out.println("QuickSort: memória insuficiente");
              System.gc();

            }

            // -=-=-=-=-=-=-=-=- SELECTION SORT -=-=-=-=-=-=-=-=-=-

            try {

              vetorInteger = Arrays.copyOf(vetorOriginal, vetorOriginal.length);

              inicio = System.nanoTime();
              SelectionSort.selectionSort(vetorInteger, vetorInteger.length);
              fim = System.nanoTime();

              arquivo.println(rodada + ",SelectionSort," + entrada + "," + nomeOrdem + "," + (fim - inicio) + ",OK");
              arquivo.flush();

              System.out.println("SelectionSort: " + (fim - inicio) + " ns");

            }

            catch (OutOfMemoryError e) {

              arquivo.println(rodada + ",SelectionSort," + entrada + "," + nomeOrdem + ",-1,OUT_OF_MEMORY");
              arquivo.flush();

              System.out.println("SelectionSort: memória insuficiente");
              System.gc();

            }

            // -=-=-=-=-=-=-=-=- SHELL SORT -=-=-=-=-=-=-=-=-=-

            try {

              vetorInteger = Arrays.copyOf(vetorOriginal, vetorOriginal.length);

              inicio = System.nanoTime();
              ShellSort.shellSort(vetorInteger, vetorInteger.length);
              fim = System.nanoTime();

              arquivo.println(rodada + ",ShellSort," + entrada + "," + nomeOrdem + "," + (fim - inicio) + ",OK");
              arquivo.flush();

              System.out.println("ShellSort: " + (fim - inicio) + " ns");

            }

            catch (OutOfMemoryError e) {

              arquivo.println(rodada + ",ShellSort," + entrada + "," + nomeOrdem + ",-1,OUT_OF_MEMORY");
              arquivo.flush();

              System.out.println("ShellSort: memória insuficiente");
              System.gc();

            }

            // -=-=-=-=-=-=-=-=- COUNTING SORT -=-=-=-=-=-=-=-=-=-

            try {

              vetorOriginalInteiro = gerarVetorInteiroCounting(entrada, ordem);
              vetorInteiro = Arrays.copyOf(vetorOriginalInteiro, vetorOriginalInteiro.length);

              inicio = System.nanoTime();
              CountingSort.countingSort(vetorInteiro, vetorInteiro.length);
              fim = System.nanoTime();

              arquivo.println(rodada + ",CountingSort," + entrada + "," + nomeOrdem + "," + (fim - inicio) + ",OK");
              arquivo.flush();

              System.out.println("CountingSort: " + (fim - inicio) + " ns");

            }

            catch (OutOfMemoryError e) {

              arquivo.println(rodada + ",CountingSort," + entrada + "," + nomeOrdem + ",-1,OUT_OF_MEMORY");
              arquivo.flush();

              System.out.println("CountingSort: memória insuficiente");
              System.gc();

            }

            // -=-=-=-=-=-=-=-=- RADIX SORT -=-=-=-=-=-=-=-=-=-

            try {

              vetorOriginalInteiro = gerarVetorInteiro(entrada, ordem);
              vetorInteiro = Arrays.copyOf(vetorOriginalInteiro, vetorOriginalInteiro.length);

              inicio = System.nanoTime();
              RadixSort.radixSort(vetorInteiro, vetorInteiro.length);
              fim = System.nanoTime();

              arquivo.println(rodada + ",RadixSort," + entrada + "," + nomeOrdem + "," + (fim - inicio) + ",OK");
              arquivo.flush();

              System.out.println("RadixSort: " + (fim - inicio) + " ns");

            }

            catch (OutOfMemoryError e) {

              arquivo.println(rodada + ",RadixSort," + entrada + "," + nomeOrdem + ",-1,OUT_OF_MEMORY");
              arquivo.flush();

              System.out.println("RadixSort: memória insuficiente");
              System.gc();

            }

            // -=-=-=-=-=-=-=-=- BUCKET SORT -=-=-=-=-=-=-=-=-=-

            try {

              vetorOriginalDouble = gerarVetorDouble(entrada, ordem);
              vetorDouble = Arrays.copyOf(vetorOriginalDouble, vetorOriginalDouble.length);

              inicio = System.nanoTime();
              BucketSort.bucketSort(vetorDouble, vetorDouble.length);
              fim = System.nanoTime();

              arquivo.println(rodada + ",BucketSort," + entrada + "," + nomeOrdem + "," + (fim - inicio) + ",OK");
              arquivo.flush();

              System.out.println("BucketSort: " + (fim - inicio) + " ns");

            }

            catch (OutOfMemoryError e) {

              arquivo.println(rodada + ",BucketSort," + entrada + "," + nomeOrdem + ",-1,OUT_OF_MEMORY");
              arquivo.flush();

              System.out.println("BucketSort: memória insuficiente");
              System.gc();

            }

          }

        }

      }

      System.out.println("\n\nExecução encerrada");

    }

    catch (IOException e) {

      System.out.println("Erro ao escrever o arquivo: " + e.getMessage());

    }

  }

  /*
   * testes
   * 
   * Integer X[] = { 0, 2, 4, 7, 8, 1, 3, 5, 6, 12, 65, 34, 34, 32, 87, 12, 65,
   * 12, 89, 23, 45, 3, 9, 23, 767, 123, 341, 143, 67 };
   * 
   * Integer XX[] = { 0, 2, 4, 7, 8, 1, 3, 5, 6, 12, 65, 34, 34, 32, 87, 12, 65,
   * 12, 89, 23, 45, 3, 9, 23, 767, 123, 341, 143, 67 };
   * int tamanho = XX.length;
   * 
   * QuickSort.quickSort(XX, 0, tamanho - 1);
   * System.out.println("\n\nQuickSort");
   * 
   * for (int i = 0; i < tamanho; i++) {
   * System.out.println(XX[i]);
   * }
   * 
   * 
   * Integer XXX[] = { 0, 2, 4, 7, 8, 1, 3, 5, 6, 12, 65, 34, 34, 32, 87, 12, 65,
   * 12, 89, 23, 45, 3, 9, 23, 767, 123, 341, 143, 67 };
   * tamanho = XXX.length;
   * 
   * BubbleSort.bubbleSort(XXX, tamanho);
   * System.out.println("\n\nBubbleSort");
   * 
   * for (int i = 0; i < tamanho; i++) {
   * System.out.println(XXX[i]);
   * }
   * 
   * 
   * int XXXX[] = { 0, 2, 4, 7, 8, 1, 3, 5, 6, 12, 65, 34, 34, 32, 87, 12, 65, 12,
   * 89, 23, 45, 3, 9, 23, 767, 123, 341, 143, 67 };
   * tamanho = XXXX.length;
   * 
   * CountingSort.countingSort(XXXX, tamanho);
   * System.out.println("\n\nCountingSort");
   * 
   * for (int i = 0; i < tamanho; i++) {
   * System.out.println(XXXX[i]);
   * }
   * 
   * 
   * int XXXXX[] = { 0, 2, 4, 7, 8, 1, 3, 5, 6, 12, 65, 34, 34, 32, 87, 12, 65,
   * 12, 89, 23, 45, 3, 9, 23, 767, 123, 341, 143, 67 };
   * tamanho = XXXXX.length;
   * 
   * RadixSort.radixSort(XXXXX, tamanho);
   * System.out.println("\n\nRadixSort");
   * 
   * for (int i = 0; i < tamanho; i++) {
   * System.out.println(XXXXX[i]);
   * }
   * 
   * 
   * Integer XXXXXX[] = { 0, 2, 4, 7, 8, 1, 3, 5, 6, 12, 65, 34, 34, 32, 87, 12,
   * 65, 12, 89, 23, 45, 3, 9, 23, 767, 123, 341, 143, 67 };
   * tamanho = XXXXXX.length;
   * 
   * HeapSort.heapSort(XXXXXX, tamanho);
   * System.out.println("\n\nHeapSort");
   * 
   * for (int i = 0; i < tamanho; i++) {
   * System.out.println(XXXXXX[i]);
   * }
   * 
   * 
   * Integer XXXXXXX[] = { 0, 2, 4, 7, 8, 1, 3, 5, 6, 12, 65, 34, 34, 32, 87, 12,
   * 65, 12, 89, 23, 45, 3, 9, 23, 767, 123, 341, 143, 67 };
   * tamanho = XXXXXXX.length;
   * 
   * InsertionSort.insertionSort(XXXXXXX, tamanho);
   * System.out.println("\n\nInsertionSort");
   * 
   * for (int i = 0; i < tamanho; i++) {
   * System.out.println(XXXXXXX[i]);
   * }
   * 
   * 
   * Integer XXXXXXXX[] = { 0, 2, 4, 7, 8, 1, 3, 5, 6, 12, 65, 34, 34, 32, 87, 12,
   * 65, 12, 89, 23, 45, 3, 9, 23, 767, 123, 341, 143, 67 };
   * tamanho = XXXXXXXX.length;
   * 
   * SelectionSort.selectionSort(XXXXXXXX, tamanho);
   * System.out.println("\n\nSelectionSort");
   * 
   * for (int i = 0; i < tamanho; i++) {
   * System.out.println(XXXXXXXX[i]);
   * }
   * 
   * 
   * Integer XXXXXXXXX[] = { 0, 2, 4, 7, 8, 1, 3, 5, 6, 12, 65, 34, 34, 32, 87,
   * 12, 65, 12, 89, 23, 45, 3, 9, 23, 767, 123, 341, 143, 67 };
   * tamanho = XXXXXXXXX.length;
   * 
   * ShellSort.shellSort(XXXXXXXXX, tamanho);
   * System.out.println("\n\nShellSort");
   * 
   * for (int i = 0; i < tamanho; i++) {
   * System.out.println(XXXXXXXXX[i]);
   * }
   * 
   * 
   * double[] XXXXXXXXXX = gerarVetorDouble(20, 0);
   * tamanho = XXXXXXXXXX.length;
   * 
   * BucketSort.bucketSort(XXXXXXXXXX, tamanho);
   * System.out.println("\n\nBucketSort");
   * 
   * for (int i = 0; i < tamanho; i++) {
   * System.out.println(XXXXXXXXXX[i]);
   * }
   * 
   * }
   */

  private static Integer[] gerarVetorComparable(int n, int ordem) {

    Random gerador = new Random();

    Integer[] vetor = new Integer[n];

    if (ordem == 0) {

      for (int i = 0; i < n; i++) {
        vetor[i] = gerador.nextInt();
      }

    }

    else if (ordem == 1) {

      for (int i = 0; i < n; i++) {
        vetor[i] = i;
      }

    }

    else if (ordem == 2) {

      for (int i = 0; i < n; i++) {
        vetor[i] = n - 1 - i;
      }

    }

    return vetor;

  }

  private static int[] gerarVetorInteiro(int n, int ordem) {

    Random gerador = new Random();

    int[] vetor = new int[n];

    if (ordem == 0) {

      for (int i = 0; i < n; i++) {
        vetor[i] = gerador.nextInt(Integer.MAX_VALUE);
      }

    }

    else if (ordem == 1) {

      for (int i = 0; i < n; i++) {
        vetor[i] = i;
      }

    }

    else if (ordem == 2) {

      for (int i = 0; i < n; i++) {
        vetor[i] = n - 1 - i;
      }

    }

    return vetor;

  }

  private static int[] gerarVetorInteiroCounting(int n, int ordem) {

    Random gerador = new Random();

    int[] vetor = new int[n];

    if (ordem == 0) {

      for (int i = 0; i < n; i++) {
        vetor[i] = gerador.nextInt(1000);
      }

    }

    else if (ordem == 1) {

      for (int i = 0; i < n; i++) {
        vetor[i] = (int) ((long) i * 10000 / n);
      }

    }

    else if (ordem == 2) {

      for (int i = 0; i < n; i++) {
        vetor[i] = (int) ((long) (n - 1 - i) * 10000 / n);
      }

    }

    return vetor;

  }

  private static double[] gerarVetorDouble(int n, int ordem) {

    Random gerador = new Random();

    double[] vetor = new double[n];

    if (ordem == 0) {

      for (int i = 0; i < n; i++) {
        vetor[i] = gerador.nextDouble();
      }

    }

    else if (ordem == 1) {

      for (int i = 0; i < n; i++) {
        vetor[i] = (double) i / n;
      }

    }

    else if (ordem == 2) {

      for (int i = 0; i < n; i++) {
        vetor[i] = (double) (n - 1 - i) / n;
      }

    }

    return vetor;

  }

}
