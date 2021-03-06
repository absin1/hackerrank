package problems;

import java.util.HashSet;
import java.util.Scanner;

public class AnagramsPossible {
	public static HashSet<String> allAnagrams = new HashSet<>();

	public static void main(String[] args) {
		System.out.print("Enter the string: ");
		Scanner scanner = new Scanner(System.in);
		String s = scanner.nextLine();
		scanner.close();
		backTrack(s.toCharArray(), 0, s.toCharArray().length - 1);
		System.out.println("Total count: " + allAnagrams.size());
	}

	// O(n*n!) Note that there are n! permutations and it requires O(n) time to
	// print a a permutation.
	// Note: It also doesn't handle repetitions that is TO-DO
	public static void backTrack(char[] s, int i, int n) {
		int j;
		if (i == n) {
			allAnagrams.add(String.valueOf(s));
			System.out.println(s);
		} else {
			for (j = i; j <= n; j++) {
				swap(s, i, j);
				backTrack(s, i + 1, n);
				swap(s, i, j);
			}
		}

	}

	private static void swap(char[] s, int i, int j) {
		char temp;
		temp = s[i];
		s[i] = s[j];
		s[j] = temp;
	}

}
