import java.util.Scanner;

public class sorting{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println("Choose sorting algorithm:");
        System.out.println("a. Selection sort");
        System.out.println("b. Bubble sort");
        System.out.println("c. Insertion sort");
        System.out.println("d. Merge sort");
        System.out.print("Enter your choice: ");
        char choice = scanner.next().charAt(0);

        switch (choice) {
            case 'a':
                selectionSort(arr);
                System.out.println("Sorted array using Selection sort:");
                break;
            case 'b':
                bubbleSort(arr);
                System.out.println("Sorted array using Bubble sort:");
                break;
            case 'c':
                insertionSort(arr);
                System.out.println("Sorted array using Insertion sort:");
                break;
            case 'd':
                mergeSort(arr, 0, arr.length - 1);
                System.out.println("Sorted array using Merge sort:");
                break;
            default:
                System.out.println("Invalid choice!");
                scanner.close();
                return;
        }

        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Time complexities
        System.out.println("Time complexities:");
        System.out.println("a. Selection sort: O(n^2)");
        System.out.println("b. Bubble sort: O(n^2)");
        System.out.println("c. Insertion sort: O(n^2)");
        System.out.println("d. Merge sort: O(n log n)");

        scanner.close();
    }

    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for (int i = 0; i < n1; ++i) {
            L[i] = arr[left + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = arr[mid + 1 + j];
        }
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}
