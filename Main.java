// O código possui a partir da linha 409 a instrução para execução de testes de verificação de corretude dos algoritmos.
// Basta comentar o código principal nas partes demarcadas e descomentar o código dos testes.

import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class Main {

  public static void main(String args[]) {

    //int[] entradas = {10, 20, 30, 40, 50};
    int[] entradas = {1000, 10000, 100000, 1000000};


    System.out.println("\n Iniciando execução");

    //Comentar aqui para realização de testes
/*
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

    */// Terminar o comentário aqui para execução dos testes

  // TESTES DE REFERÊNCIA PARA O ARQUIVO



    try (PrintWriter testes = new PrintWriter(new FileWriter("testes.txt"))) {

      String[] nomesOrdens = {
        "Aleatorio",
        "Crescente",
        "Decrescente",
        "Valores repetidos"
      };

      testes.println("---- TESTES ----\n");

      // QuickSort
      testes.println("QuickSort:");

      for (int ordem = 0; ordem < 4; ordem++) {
        testes.println("\n" + nomesOrdens[ordem] + ":");

        for (int i = 0; i < 3; i++) {
          Integer[] vetor = gerarVetorComparable(10, ordem);
          Integer[] original = Arrays.copyOf(vetor, vetor.length);

          QuickSort.quickSort(vetor, 0, vetor.length - 1);

          testes.println("Vetor original: " + Arrays.toString(original));
          testes.println("Ordenado: " + Arrays.toString(vetor));
        }
      }

      // BubbleSort
      testes.println("\n\nBubbleSort:");

      for (int ordem = 0; ordem < 4; ordem++) {
        testes.println("\n" + nomesOrdens[ordem] + ":");

        for (int i = 0; i < 3; i++) {
          Integer[] vetor = gerarVetorComparable(10, ordem);
          Integer[] original = Arrays.copyOf(vetor, vetor.length);

          BubbleSort.bubbleSort(vetor, vetor.length);

          testes.println("Vetor original: " + Arrays.toString(original));
          testes.println("Ordenado: " + Arrays.toString(vetor));
        }
      }

      // CountingSort
      testes.println("\n\nCountingSort:");

      for (int ordem = 0; ordem < 4; ordem++) {
        testes.println("\n" + nomesOrdens[ordem] + ":");

        for (int i = 0; i < 3; i++) {
          int[] vetor = gerarVetorInteiroCounting(10, ordem);
          int[] original = Arrays.copyOf(vetor, vetor.length);

          CountingSort.countingSort(vetor, vetor.length);

          testes.println("Vetor original: " + Arrays.toString(original));
          testes.println("Ordenado: " + Arrays.toString(vetor));
        }
      }

      // RadixSort
      testes.println("\n\nRadixSort:");

      for (int ordem = 0; ordem < 4; ordem++) {
        testes.println("\n" + nomesOrdens[ordem] + ":");

        for (int i = 0; i < 3; i++) {
          int[] vetor = gerarVetorInteiro(10, ordem);
          int[] original = Arrays.copyOf(vetor, vetor.length);

          RadixSort.radixSort(vetor, vetor.length);

          testes.println("Vetor original: " + Arrays.toString(original));
          testes.println("Ordenado: " + Arrays.toString(vetor));
        }
      }

      // HeapSort
      testes.println("\n\nHeapSort:");

      for (int ordem = 0; ordem < 4; ordem++) {
        testes.println("\n" + nomesOrdens[ordem] + ":");

        for (int i = 0; i < 3; i++) {
          Integer[] vetor = gerarVetorComparable(10, ordem);
          Integer[] original = Arrays.copyOf(vetor, vetor.length);

          HeapSort.heapSort(vetor, vetor.length);

          testes.println("Vetor original: " + Arrays.toString(original));
          testes.println("Ordenado: " + Arrays.toString(vetor));
        }
      }

      // InsertionSort
      testes.println("\n\nInsertionSort:");

      for (int ordem = 0; ordem < 4; ordem++) {
        testes.println("\n" + nomesOrdens[ordem] + ":");

        for (int i = 0; i < 3; i++) {
          Integer[] vetor = gerarVetorComparable(10, ordem);
          Integer[] original = Arrays.copyOf(vetor, vetor.length);

          InsertionSort.insertionSort(vetor, vetor.length);

          testes.println("Vetor original: " + Arrays.toString(original));
          testes.println("Ordenado: " + Arrays.toString(vetor));
        }
      }

      // SelectionSort
      testes.println("\n\nSelectionSort:");

      for (int ordem = 0; ordem < 4; ordem++) {
        testes.println("\n" + nomesOrdens[ordem] + ":");

        for (int i = 0; i < 3; i++) {
          Integer[] vetor = gerarVetorComparable(10, ordem);
          Integer[] original = Arrays.copyOf(vetor, vetor.length);

          SelectionSort.selectionSort(vetor, vetor.length);

          testes.println("Vetor original: " + Arrays.toString(original));
          testes.println("Ordenado: " + Arrays.toString(vetor));
        }
      }

      // ShellSort
      testes.println("\n\nShellSort:");

      for (int ordem = 0; ordem < 4; ordem++) {
        testes.println("\n" + nomesOrdens[ordem] + ":");

        for (int i = 0; i < 3; i++) {
          Integer[] vetor = gerarVetorComparable(10, ordem);
          Integer[] original = Arrays.copyOf(vetor, vetor.length);

          ShellSort.shellSort(vetor, vetor.length);

          testes.println("Vetor original: " + Arrays.toString(original));
          testes.println("Ordenado: " + Arrays.toString(vetor));
        }
      }

      // BucketSort
      testes.println("\n\nBucketSort:");

      for (int ordem = 0; ordem < 4; ordem++) {
        testes.println("\n" + nomesOrdens[ordem] + ":");

        for (int i = 0; i < 3; i++) {
          double[] vetor = gerarVetorDouble(10, ordem);
          double[] original = Arrays.copyOf(vetor, vetor.length);

          BucketSort.bucketSort(vetor, vetor.length);

          testes.println("Vetor original: " + Arrays.toString(original));
          testes.println("Ordenado: " + Arrays.toString(vetor));
        }
      }

      testes.close();

      System.out.println("\n\n Testes executados e salvos no arquivo testes.txt\n ");
    }

    catch (IOException e) {

      System.out.println("Erro ao escrever o arquivo: " + e.getMessage());

    }
  }
  /* FIM DOS TESTES */


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

    else if (ordem == 3) {

      Integer[] valores = new Integer[5];

      for (int i = 0; i < 5; i++) {
        valores[i] = gerador.nextInt();
      }

      for (int i = 0; i < n; i++) {
        vetor[i] = valores[gerador.nextInt(5)];
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

    else if (ordem == 3) {

      int[] valores = new int[5];

      for (int i = 0; i < 5; i++) {
        valores[i] = gerador.nextInt(Integer.MAX_VALUE);
      }

      for (int i = 0; i < n; i++) {
        vetor[i] = valores[gerador.nextInt(5)];
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

    else if (ordem == 3) {

      int[] valores = new int[5];

      for (int i = 0; i < 5; i++) {
        valores[i] = gerador.nextInt(1000);
      }

      for (int i = 0; i < n; i++) {
        vetor[i] = valores[gerador.nextInt(5)];
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

    else if (ordem == 3) {

      double[] valores = new double[5];

      for (int i = 0; i < 5; i++) {
        valores[i] = gerador.nextDouble();
      }

      for (int i = 0; i < n; i++) {
        vetor[i] = valores[gerador.nextInt(5)];
      }

    }

    return vetor;

  }

}
