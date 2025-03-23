import java.util.Scanner;
import java.util.Random;

class prg1 {
	static int searchCount = 0;
	static int sortCount = 0;

	static int sequentialSearch(int[] a, int key) {
		for (int i = 0; i < a.length; i++) {
			searchCount++;
			if (a[i] == key) {
				return i;
			}
		}
		return -1;
	}

	static void selectionSort(int[] a) {
		int n = a.length;
		for (int i = 0; i < n - 1; i++) {
			int min = i;
			for (int j = i + 1; j < n; j++) {
				sortCount++;
				if (a[j] < a[min]) {
					min = j;
				}
			}
			if (min != i) {
				int temp = a[i];
				a[i] = a[min];
				a[min] = temp;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random r = new Random();

		System.out.println("Enter the no of elements: ");
		int n = sc.nextInt();

		int[] a = new int[n];

		for (int i = 0; i < n; i++) {
			a[i] = r.nextInt(10000);
		}

		int rand = r.nextInt(n);
		System.out.println("Random no generated is: " + rand);

		System.out.println("Enter the key to search: ");
		int key = sc.nextInt();

		int index = sequentialSearch(a, key);

		if (index == -1) {
			System.out.println("key not found");
		} else {
			System.out.println("Key found at index: " + index);
		}

		selectionSort(a);

		System.out.println("Sorted Elements are: ");
		for (int i = 0; i < n; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();

		System.out.println("No of Basic operations for searching: " + searchCount);
		System.out.println("No of Basic operations for sorting: " + sortCount);
		sc.close();
	}
}
