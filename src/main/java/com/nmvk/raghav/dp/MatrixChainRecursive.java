package com.nmvk.raghav.dp;

public class MatrixChainRecursive {

	static long recursions = 0;

	public static void main(String[] args) {
		long y = 3 * 45*23* 9* 3* 99* 108* 76* 12* 77* 16* 18* 4;
		System.out.println(y);
		// TODO Auto-generated method stub
		long startTime = System.nanoTime();
		int p[] = {5, 2, 4, 7, 3, 9, 7, 8, 6, 3, 7, 5, 5};

		System.out.println(p.length);
		int x = matrixRecursive(p, 1, p.length - 1);
		System.out.println(x);
		System.out.println(recursions);
		System.out.println("Time to finish is " + (System.nanoTime() - startTime));
	}

	static int matrixRecursive(int[] p, int i, int j) {
		recursions++;
		if (i == j)
			return 0;
		
		//Equivalent to infinity
		int m = Integer.MAX_VALUE;

		for (int k = i; k < j; k++) {
			int q = matrixRecursive(p, i, k) + matrixRecursive(p, k + 1, j) + p[i - 1] * p[k] * p[j];
			if (q < m)
				m = q;
		}

		return m;
	}
}
