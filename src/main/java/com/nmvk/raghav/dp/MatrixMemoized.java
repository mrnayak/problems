package com.nmvk.raghav.dp;

public class MatrixMemoized {

	static int recursions = 0;
	public static void main(String[] args) {
		long startTime = System.nanoTime(); 
		int p[] = 
			{ 40, 20, 30, 10, 30, 80, 25, 15, 40, 20, 65, 70, 80, 20, 10, 30, 80, 25, 15, 40,40, 20, 30, 10, 30, 80, 25, 15, 40, 20, 65, 70, 80, 20, 10, 30, 80, 25, 15, 40,40, 20, 30, 10, 30, 80, 25, 15, 40, 20, 65, 70, 80, 20, 10, 30, 80, 25, 15, 40,40, 20, 30, 10, 30, 80, 25, 15, 40, 20, 65, 70, 80, 20, 10, 30, 80, 25, 15, 40 }



 

  ;

		int x = memoizedMatrixChain(p);
		System.out.println(x);
		System.out.println(recursions);
		System.out.println(System.nanoTime() - startTime);
	}

	static int memoizedMatrixChain(int[] p) {
		int n = p.length;
		int m[][] = new int[n][n];

		for (int i = 0; i < n; i++)
			for (int j = i; j < n; j++) {
				m[i][j] = Integer.MAX_VALUE;
			}
		
		return lookUpChain(m, p, 1, n-1);
	}

	static int lookUpChain(int m[][],int[] p, int i, int j) {
		recursions++;
		if(m[i][j] < Integer.MAX_VALUE)
			return m[i][j];
		if (i == j)
			return 0;

		for (int k = i; k < j; k++) {
			int q = lookUpChain(m,p, i, k) + lookUpChain(m,p, k + 1, j) + p[i - 1] * p[k] * p[j];
			if (q < m[i][j])
				m[i][j] = q;
		}

		return m[i][j];
	}
}
