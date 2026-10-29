import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {

  public static <T extends Comparable<T>> void main(String args[]) {

//    int[] entradas = {10, 20, 30, 40, 50};
    int[] entradas = {1000, 10000, 100000, 1000000, 10000000};

    System.out.println("\n\n Iniciando execução");

    try (PrintWriter arquivo = new PrintWriter(new FileWriter("resultados.csv"))) {
      arquivo.println("Algoritmo,Tamanho,Tempo_ns");


      // -=-=-=-=-=-=-=-=- BUBBLE SORT -=-=-=-=-=-=-=-=-=-


      System.out.println("\n\n BubbleSort");

      //Carregando algoritmos na cache
      long inicio = System.nanoTime();
      Integer[] vetorInteger = new Integer[1];
      vetorInteger = gerarVetorComparable(1);
      BubbleSort.bubbleSort(vetorInteger, 1);
      long fim = System.nanoTime();

      for(int entrada : entradas) {

        try {
        System.out.println("\nEntrada "+entrada);
        vetorInteger = new Integer[entrada];
        vetorInteger = gerarVetorComparable(entrada);
        inicio = System.nanoTime();
        BubbleSort.bubbleSort(vetorInteger, vetorInteger.length);
        fim = System.nanoTime();
        arquivo.println("BubbleSort,"+entrada+","+(fim-inicio));
        }

        catch (OutOfMemoryError e) {
          arquivo.println("BubbleSort,"+entrada+",NaN");
          System.out.println("\n Bubble sort: Memória insuficiente para entrada "+entrada);
          break;
        }
      }
      System.out.println("\n\n Execução do bubble encerrada");


      // -=-=-=-=-=-=-=-=- BUCKET SORT -=-=-=-=-=-=-=-=-=-


      System.out.println("\n\n BucketSort");

      //Carregando algoritmos na cache
      inicio = System.nanoTime();
      double[] vetorDouble = new double[1];
      vetorDouble = gerarVetorDouble(1);
      BucketSort.bucketSort(vetorDouble, 1);
      fim = System.nanoTime();

      for(int entrada : entradas) {

        try {
        System.out.println("\nEntrada "+entrada);
        vetorDouble = new double[entrada];
        vetorDouble = gerarVetorDouble(entrada);
        inicio = System.nanoTime();
        BucketSort.bucketSort(vetorDouble, vetorDouble.length);
        fim = System.nanoTime();
        arquivo.println("BucketSort,"+entrada+","+(fim-inicio));
        }

        catch (OutOfMemoryError e) {
          arquivo.println("BucketSort,"+entrada+",NaN");
          System.out.println("\n Bucket sort: Memória insuficiente para entrada "+entrada);
          break;
        }
      }
      System.out.println("\n\n Execução do bucket encerrada");


      // -=-=-=-=-=-=-=-=- COUNTING SORT -=-=-=-=-=-=-=-=-=-


      System.out.println("\n\n CountingSort");

      //Carregando algoritmos na cache
      inicio = System.nanoTime();
      vetorInteger = new Integer[1];
      vetorInteger = gerarVetorComparableCounting(1);
      CountingSort.countingSort(vetorInteger, 1);
      fim = System.nanoTime();

      for(int entrada : entradas) {

        try {
        System.out.println("\nEntrada "+entrada);
        vetorInteger = new Integer[entrada];
        vetorInteger = gerarVetorComparableCounting(entrada);
        inicio = System.nanoTime();
        CountingSort.countingSort(vetorInteger, vetorInteger.length);
        fim = System.nanoTime();
        arquivo.println("CountingSort,"+entrada+","+(fim-inicio));
        }

        catch (OutOfMemoryError e) {
          arquivo.println("CountingSort,"+entrada+",NaN");
          System.out.println("\n Counting sort: Memória insuficiente para entrada "+entrada);
          break;
        }
      }
      System.out.println("\n\n Execução do counting encerrada");




      System.out.println("\n\n HeapSort");

      //Carregando algoritmos na cache
      inicio = System.nanoTime();
      vetorInteger = new Integer[1];
      vetorInteger = gerarVetorComparable(1);
      HeapSort.heapSort(vetorInteger, 1);
      fim = System.nanoTime();

      for(int entrada : entradas) {

        try {
        System.out.println("\nEntrada "+entrada);
        vetorInteger = new Integer[entrada];
        vetorInteger = gerarVetorComparable(entrada);
        inicio = System.nanoTime();
        HeapSort.heapSort(vetorInteger, vetorInteger.length);
        fim = System.nanoTime();
        arquivo.println("HeapSort,"+entrada+","+(fim-inicio));
        }

        catch (OutOfMemoryError e) {
          arquivo.println("HeapSort,"+entrada+",NaN");
          System.out.println("\n Heap sort: Memória insuficiente para entrada "+entrada);
          break;
        }
      }
      System.out.println("\n\n Execução do heap encerrada");




      System.out.println("\n\n InsertionSort");

      //Carregando algoritmos na cache
      inicio = System.nanoTime();
      vetorInteger = new Integer[1];
      vetorInteger = gerarVetorComparable(1);
      InsertionSort.insertionSort(vetorInteger, 1);
      fim = System.nanoTime();

      for(int entrada : entradas) {

        try {
        System.out.println("\nEntrada "+entrada);
        vetorInteger = new Integer[entrada];
        vetorInteger = gerarVetorComparable(entrada);
        inicio = System.nanoTime();
        InsertionSort.insertionSort(vetorInteger, vetorInteger.length);
        fim = System.nanoTime();
        arquivo.println("InsertionSort,"+entrada+","+(fim-inicio));
        }

        catch (OutOfMemoryError e) {
          arquivo.println("InsertionSort,"+entrada+",NaN");
          System.out.println("\n Insertion sort: Memória insuficiente para entrada "+entrada);
          break;
        }
      }
      System.out.println("\n\n Execução do insertion encerrada");




      System.out.println("\n\n MergeSort");

      //Carregando algoritmos na cache
      inicio = System.nanoTime();
      vetorInteger = new Integer[10];
      vetorInteger = gerarVetorComparable(10);
      MergeSort.mergeSort(vetorInteger, 0, (vetorInteger.length-1));
      fim = System.nanoTime();

      for(int entrada : entradas) {

        try {
        System.out.println("\nEntrada "+entrada);
        vetorInteger = new Integer[entrada];
        vetorInteger = gerarVetorComparable(entrada);
        inicio = System.nanoTime();
        MergeSort.mergeSort(vetorInteger, 0, (vetorInteger.length-1));
        fim = System.nanoTime();
        arquivo.println("MergeSort,"+entrada+","+(fim-inicio));
        }

        catch (OutOfMemoryError e) {
          arquivo.println("MergeSort,"+entrada+",NaN");
          System.out.println("\n Merge sort: Memória insuficiente para entrada "+entrada);
          break;
        }
      }
      System.out.println("\n\n Execução do merge encerrada");




      System.out.println("\n\n QuickSort");

      //Carregando algoritmos na cache
      inicio = System.nanoTime();
      vetorInteger = new Integer[1];
      vetorInteger = gerarVetorComparable(1);
      QuickSort.quickSort(vetorInteger, 0, 0);
      fim = System.nanoTime();

      for(int entrada : entradas) {

        try {
        System.out.println("\nEntrada "+entrada);
        vetorInteger = new Integer[entrada];
        vetorInteger = gerarVetorComparable(entrada);
        inicio = System.nanoTime();
        QuickSort.quickSort(vetorInteger, 0, (vetorInteger.length-1));
        fim = System.nanoTime();
        arquivo.println("QuickSort,"+entrada+","+(fim-inicio));
        }

        catch (OutOfMemoryError e) {
          arquivo.println("QuickSort,"+entrada+",NaN");
          System.out.println("\n Quick sort: Memória insuficiente para entrada "+entrada);
          break;
        }
      }
      System.out.println("\n\n Execução do quick encerrada");




      System.out.println("\n\n RadixSort");

      //Carregando algoritmos na cache
      inicio = System.nanoTime();
      vetorInteger = new Integer[1];
      vetorInteger = gerarVetorComparableRadix(1);
      RadixSort.radixSort(vetorInteger, 1);
      fim = System.nanoTime();

      for(int entrada : entradas) {

        try {
        System.out.println("\nEntrada "+entrada);
        vetorInteger = new Integer[entrada];
        vetorInteger = gerarVetorComparableCounting(entrada);
        inicio = System.nanoTime();
        RadixSort.radixSort(vetorInteger, vetorInteger.length);
        fim = System.nanoTime();
        arquivo.println("RadixSort,"+entrada+","+(fim-inicio));
        }

        catch (OutOfMemoryError e) {
          arquivo.println("RadixSort,"+entrada+",NaN");
          System.out.println("\n Radix sort: Memória insuficiente para entrada "+entrada);
          break;
        }
      }
      System.out.println("\n\n Execução do radix encerrada");




      System.out.println("\n\n SelectionSort");

      //Carregando algoritmos na cache
      inicio = System.nanoTime();
      vetorInteger = new Integer[1];
      vetorInteger = gerarVetorComparable(1);
      SelectionSort.selectionSort(vetorInteger, 1);
      fim = System.nanoTime();

      for(int entrada : entradas) {

        try {
        System.out.println("\nEntrada "+entrada);
        vetorInteger = new Integer[entrada];
        vetorInteger = gerarVetorComparable(entrada);
        inicio = System.nanoTime();
        SelectionSort.selectionSort(vetorInteger, vetorInteger.length);
        fim = System.nanoTime();
        arquivo.println("SelectionSort,"+entrada+","+(fim-inicio));
        }

        catch (OutOfMemoryError e) {
          arquivo.println("SelectionSort,"+entrada+",NaN");
          System.out.println("\n Selection sort: Memória insuficiente para entrada "+entrada);
          break;
        }
      }
      System.out.println("\n\n Execução do selection encerrada");




      System.out.println("\n\n ShellSort");

      //Carregando algoritmos na cache
      inicio = System.nanoTime();
      vetorInteger = new Integer[1];
      vetorInteger = gerarVetorComparable(1);
      ShellSort.shellSort(vetorInteger, 1);
      fim = System.nanoTime();

      for(int entrada : entradas) {

        try {
        System.out.println("\nEntrada "+entrada);
        vetorInteger = new Integer[entrada];
        vetorInteger = gerarVetorComparable(entrada);
        inicio = System.nanoTime();
        ShellSort.shellSort(vetorInteger, vetorInteger.length);
        fim = System.nanoTime();
        arquivo.println("ShellSort,"+entrada+","+(fim-inicio));
        }

        catch (OutOfMemoryError e) {
          arquivo.println("ShellSort,"+entrada+",NaN");
          System.out.println("\n Shell sort: Memória insuficiente para entrada "+entrada);
          break;
        }
      }
      System.out.println("\n\n Execução do shell encerrada");
    }

    catch (IOException e) {
      System.out.println("Erro ao escrever o arquivo: " + e.getMessage());
    }
  }
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


    double[] XXXXXXXXXX = gerarVetorDouble(20);
    tamanho = XXXXXXXXXX.length;

    BucketSort.bucketSort(XXXXXXXXXX, tamanho);
    System.out.println("\n\nBucketSort");

    for (int i = 0; i < tamanho; i++) {
      System.out.println(XXXXXXXXXX[i]);
    }
  }*/






  private static <T extends Comparable<T>> Integer[] gerarVetorComparable(int n) {

    Random gerador = new Random();

    Integer[] vetor = new Integer[n];
    for (int i=0; i<n; i++) {
      vetor[i] = (Integer)gerador.nextInt();
    }

    return vetor;
  }

  private static int[] gerarVetorInteiro(int n) {

    Random gerador = new Random();

    int[] vetor = new int[n];
    for (int i=0; i<n; i++) {
      vetor[i] = gerador.nextInt(Integer.MAX_VALUE);
    }

    return vetor;
  }

  private static <T extends Comparable<T>> Integer[] gerarVetorComparableCounting(int n) {

    Random gerador = new Random();

    Integer[] vetor = new Integer[n];
    for (int i=0; i<n; i++) {
      vetor[i] = (Integer)gerador.nextInt(1000);
    }

    return vetor;
  }

  private static <T extends Comparable<T>> Integer[] gerarVetorComparableRadix(int n) {

    Random gerador = new Random();

    Integer[] vetor = new Integer[n];
    for (int i=0; i<n; i++) {
      vetor[i] = (Integer)gerador.nextInt();
    }

    return vetor;
  }

  private static double[] gerarVetorDouble(int n) {

    Random gerador = new Random();

    double[] vetor = new double[n];
    for (int i=0; i<n; i++) {
      vetor[i] = gerador.nextDouble();
    }
    return vetor;
  }
}
