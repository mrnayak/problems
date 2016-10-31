package com.nmvk.raghav.dp;

public class MatrixChain {

	static int loops = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long startTime = System.nanoTime();
		int p[] ={ 40, 20, 30, 10, 30, 80, 25, 15, 40, 20, 65, 70, 80, 20, 10, 30, 80, 25, 15, 40,40, 20, 30, 10, 30, 80, 25, 15, 40, 20, 65, 70, 80, 20, 10, 30, 80, 25, 15, 40,40, 20, 30, 10, 30, 80, 25, 15, 40, 20, 65, 70, 80, 20, 10, 30, 80, 25, 15, 40,40, 20, 30, 10, 30, 80, 25, 15, 40, 20, 65, 70, 80, 20, 10, 30, 80, 25, 15, 40 };
		System.out.println(p.length);

		matrixTabular(p);
		System.out.println(loops);
		System.out.println(System.nanoTime() - startTime);
	}

	static void matrixTabular(int[] p) {
		int n = p.length;

		int[][] m = new int[n][n];
		int[][] s = new int[n][n];
		// Set m values to zero.
		for (int i = 0; i < n; i++) {
			m[i][i] = 0;
		}

		//l is chain length
		for (int l = 2; l < n; l++) {
			for (int i = 1; i < n - l + 1; i++) {
				loops++;
				int j = i + l - 1;
				if (j == n)
					continue;
				m[i][j] = Integer.MAX_VALUE;
				for (int k = i; k <= j - 1; k++) {
					loops++;
					int q = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
					if (q < m[i][j])
						m[i][j] = q;
						s[i][j] = k;
				}
			}
		}
		System.out.println(m[1][n-1]);
		
		//printOptimalParam(p,s,0,n-1);
	}
	
	static void printOptimalParam(int[] p, int[][] s, int i, int j)
	{
		if(i == j)
			System.out.print(p[i]);
		else
		{
			System.out.print("(");
			printOptimalParam(p, s, i, s[i][j]);
			System.out.print("*");
			printOptimalParam(p, s, s[i][j], j);
			System.out.print(")");
		}
			
	}
}
