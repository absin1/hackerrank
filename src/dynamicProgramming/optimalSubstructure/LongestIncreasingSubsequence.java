package dynamicProgramming.optimalSubstructure;

public class LongestIncreasingSubsequence {
	public static void main(String[] arg) {
		int arr[] = { 50, 3, 10, 7, 40, 80 };
		System.err.println(getLongestIncreasingSubsequence(arr, arr.length));
	}

	public static int getLongestIncreasingSubsequence(int[] arr, int n) {
		int lis = 1;
		double pow = Math.pow((double) 2, (double) n);
		int count = 0;
		if (pow <= (double) Integer.MAX_VALUE)
			count = (int) pow;
		for (int input = 0; input < count; input++) {
			boolean[] bits = new boolean[n];
			for (int i = n - 1; i >= 0; i--) {
				bits[i] = (input & (1 << i)) != 0;
			}
			int index = 0;
			int[] subSeq = new int[n];
			for (int i = 0; i < subSeq.length; i++) {
				subSeq[i] = -1;
			}
			for (int k = 0; k < n; k++) {
				if (bits[k])
					subSeq[index++] = arr[k];
			}
			if (isIncremental(subSeq)) {
				int subSeqLength = 0;
				System.out.print(input + " = ");
				for (int i : subSeq) {
					if (i == -1)
						break;
					System.out.print(i + ">");
					subSeqLength++;
				}
				if (subSeqLength > lis)
					lis = subSeqLength;
				System.out.println();
			}
		}
		return lis;
	}

	private static int[] getAllPossibleIS(int[] arr, int n) {
		double pow = Math.pow((double) 2, (double) n);
		int count = 0;
		if (pow <= (double) Integer.MAX_VALUE)
			count = (int) pow;
		for (int input = 0; input < count; input++) {
			boolean[] bits = new boolean[n];
			for (int i = n - 1; i >= 0; i--) {
				bits[i] = (input & (1 << i)) != 0;
			}
			int index = 0;
			int[] subSeq = new int[n];
			for (int i = 0; i < subSeq.length; i++) {
				subSeq[i] = -1;
			}
			for (int k = 0; k < n; k++) {
				if (bits[k])
					subSeq[index++] = arr[k];
			}
			if (isIncremental(subSeq)) {
				System.out.print(input + " = ");
				for (int i : subSeq) {
					if (i == -1)
						break;
					System.out.print(i + ">");
				}
				System.out.println();
			}
		}
		return null;
	}

	private static boolean isIncremental(int[] subSeq) {
		int first = subSeq[0];
		boolean isIncremental = true;
		for (int i = 1; i < subSeq.length; i++) {
			if (subSeq[i] == -1)
				break;
			if (subSeq[i] < first) {
				isIncremental = false;
				break;
			} else
				first = subSeq[i];
		}
		return isIncremental;
	}
}
