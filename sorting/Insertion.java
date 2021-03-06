package sorting;

public class Insertion {
	// Insertion sort is like arranging your cards after you receive them. You
	// start from any end and move the later cards such that order is maintained
	// till you have browsed.
	public static void main(String args[]) {
		int[] input = { 64, 25, 12, 22, 11 };
		// insertionSort(input);
		// insertionSortAlternative(input);
		insertionSortRecursive(input, input.length - 1);
		for (int i : input) {
			System.out.print(i + " ");
		}
	}

	public static void insertionSortRecursive(int[] input, int n) {
		if (n <= 0)
			return;
		insertionSortRecursive(input, n - 1);
		int temp = input[n];
		boolean isShift = false;
		int i;
		for (i = n - 1; i >= 0; i--) {
			if (temp < input[i]) {
				input[i + 1] = input[i];
				isShift = true;
			} else
				break;
		}
		if (isShift) {
			input[i+1] = temp;
		}
	}

	public static void insertionSortAlternative(int[] arr) {
		int n = arr.length;
		for (int i = 1; i < n; ++i) {
			int key = arr[i];
			int j = i - 1;

			/*
			 * Move elements of arr[0..i-1], that are greater than key, to one
			 * position ahead of their current position
			 */
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = key;
		}
	}

	public static void insertionSort(int[] input) {
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < i; j++) {
				if (input[j] > input[i]) {
					int temp = input[i];
					for (int k = i; k > j; k--) {
						input[k] = input[k - 1];
					}
					input[j] = temp;
					break;
				}
			}
		}
	}
}
