package SortingFunctions;

import java.util.Random;

public class SortingFunctions {

    static public void selectSort(int[] arr) {
        int n = arr.length;

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++)
        {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;

            // Swap the found minimum element with the first
            // element
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }
    static public void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arr[j] > arr[j+1])
                {
                    // swap arr[j+1] and arr[i]
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
    }
    static private void heapify(int[] arr, int n, int i) {
        int largest = i; // Initialize largest as root
        int l = 2*i + 1; // left = 2*i + 1
        int r = 2*i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // If largest is not root
        if (largest != i)
        {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }
    static public void heapSort(int[] arr) {
        int n = arr.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // One by one extract an element from heap
        for (int i=n-1; i>=0; i--)
        {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }
    static public void shellSort(int[] arr) {
        int n = arr.length;
        for (int gap = n/2; gap > 0; gap /= 2)
        {
            for (int i = gap; i < n; i += 1)
            {
                int temp = arr[i];
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap)
                    arr[j] = arr[j - gap];
                arr[j] = temp;
            }
        }
    }
    static public void cocktailSort(int[] a) {
        boolean swapped = true;
        int start = 0;
        int end = a.length;
        while (swapped == true) {
            swapped = false;
            for (int i = start; i < end - 1; ++i) {
                if (a[i] > a[i + 1]) {
                    int temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                    swapped = true;
                }
            }
            if (swapped == false)
                break;
            swapped = false;
            end = end - 1;
            for (int i = end - 1; i >= start; i--) {
                if (a[i] > a[i + 1]) {
                    int temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                    swapped = true;
                }
            }
            start = start + 1;
        }
    }

    static void  ustawMalejaca(int[] tab){
        for(int i=0; i<tab.length;i++){
            tab[tab.length-i-1]=i;
        }
    }
    static void losuj(int[] tab){
        Random generator = new Random();
        for(int i=0; i<tab.length;i++){
            tab[i] = generator.nextInt();
        }
    }
    static void ustawRosnaco(int[] tab){
        for(int i=0; i<tab.length;i++){
            tab[i]=i;
        }
    }

    static public void SortingFunctions(int i){

        int[] tab = new int[i];
        long tStart, tEnd;
        double delta;
        System.out.println("Sortowanie Bąbelkowe: ");
        SortingFunctions.ustawMalejaca(tab);
        tStart = System.currentTimeMillis();
        SortingFunctions.bubbleSort(tab);
        tEnd = System.currentTimeMillis();
        delta=(tEnd-tStart)/1000.0;
        System.out.println("\tdla tablicy ustawionej malejąco: " + delta);
        SortingFunctions.losuj(tab);
        tStart = System.currentTimeMillis();
        SortingFunctions.bubbleSort(tab);
        tEnd = System.currentTimeMillis();
        delta=(tEnd-tStart)/1000.0;
        System.out.println("\tdla tablicy ustawionej losowo: " + delta);
        SortingFunctions.ustawRosnaco(tab);
        tStart = System.currentTimeMillis();
        SortingFunctions.bubbleSort(tab);
        tEnd = System.currentTimeMillis();
        delta=(tEnd-tStart)/1000.0;
        System.out.println("\tdla tablicy ustawionej rosnąco: " + delta);

        System.out.println("Sortowanie 'heapsort': ");
        SortingFunctions.ustawMalejaca(tab);
        tStart = System.currentTimeMillis();
        SortingFunctions.heapSort(tab);
        tEnd = System.currentTimeMillis();
        delta=(tEnd-tStart)/1000.0;
        System.out.println("\tdla tablicy ustawionej malejąco: " + delta);
        SortingFunctions.losuj(tab);
        tStart = System.currentTimeMillis();
        SortingFunctions.heapSort(tab);
        tEnd = System.currentTimeMillis();
        delta=(tEnd-tStart)/1000.0;
        System.out.println("\tdla tablicy ustawionej losowo: " + delta);
        SortingFunctions.ustawRosnaco(tab);
        tStart = System.currentTimeMillis();
        SortingFunctions.heapSort(tab);
        tEnd = System.currentTimeMillis();
        delta=(tEnd-tStart)/1000.0;
        System.out.println("\tdla tablicy ustawionej rosnąco: " + delta);

        System.out.println("Sortowanie 'shellSort': ");
        SortingFunctions.ustawMalejaca(tab);
        tStart = System.currentTimeMillis();
        SortingFunctions.shellSort(tab);
        tEnd = System.currentTimeMillis();
        delta=(tEnd-tStart)/1000.0;
        System.out.println("\tdla tablicy ustawionej malejąco: " + delta);
        SortingFunctions.losuj(tab);
        tStart = System.currentTimeMillis();
        SortingFunctions.shellSort(tab);
        tEnd = System.currentTimeMillis();
        delta=(tEnd-tStart)/1000.0;
        System.out.println("\tdla tablicy ustawionej losowo: " + delta);
        SortingFunctions.ustawRosnaco(tab);
        tStart = System.currentTimeMillis();
        SortingFunctions.shellSort(tab);
        tEnd = System.currentTimeMillis();
        delta=(tEnd-tStart)/1000.0;
        System.out.println("\tdla tablicy ustawionej rosnąco: " + delta);

        System.out.println("Sortowanie 'selectSort': ");
        SortingFunctions.ustawMalejaca(tab);
        tStart = System.currentTimeMillis();
        SortingFunctions.selectSort(tab);
        tEnd = System.currentTimeMillis();
        delta=(tEnd-tStart)/1000.0;
        System.out.println("\tdla tablicy ustawionej malejąco: " + delta);
        SortingFunctions.losuj(tab);
        tStart = System.currentTimeMillis();
        SortingFunctions.selectSort(tab);
        tEnd = System.currentTimeMillis();
        delta=(tEnd-tStart)/1000.0;
        System.out.println("\tdla tablicy ustawionej losowo: " + delta);
        SortingFunctions.ustawRosnaco(tab);
        tStart = System.currentTimeMillis();
        SortingFunctions.selectSort(tab);
        tEnd = System.currentTimeMillis();
        delta=(tEnd-tStart)/1000.0;
        System.out.println("\tdla tablicy ustawionej rosnąco: " + delta);

        System.out.println("Sortowanie 'coctailSort': ");
        SortingFunctions.ustawMalejaca(tab);
        tStart = System.currentTimeMillis();
        SortingFunctions.cocktailSort(tab);
        tEnd = System.currentTimeMillis();
        delta=(tEnd-tStart)/1000.0;
        System.out.println("\tdla tablicy ustawionej malejąco: " + delta);
        SortingFunctions.losuj(tab);
        tStart = System.currentTimeMillis();
        SortingFunctions.cocktailSort(tab);
        tEnd = System.currentTimeMillis();
        delta=(tEnd-tStart)/1000.0;
        System.out.println("\tdla tablicy ustawionej losowo: " + delta);
        SortingFunctions.ustawRosnaco(tab);
        tStart = System.currentTimeMillis();
        SortingFunctions.cocktailSort(tab);
        tEnd = System.currentTimeMillis();
        delta=(tEnd-tStart)/1000.0;
        System.out.println("\tdla tablicy ustawionej rosnąco: " + delta);
    }
}
