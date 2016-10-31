package com.nmvk.raghav;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Cube {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		PrintWriter pw = new PrintWriter("outputs.txt");
		for (int k = 0; k < t; k++) {
			int n = in.nextInt();
			int m = in.nextInt();
			long[][][] cube = new long[n + 1][n + 1][n + 1];
			Map<String, Long> map = new TreeMap<>();
			for (int i = 0; i < m; i++) {
				String s = in.next();

				if (s.equalsIgnoreCase("UPDATE")) {
					int w = in.nextInt();
					int y = in.nextInt();
					int z = in.nextInt();

					String key = w + "Ragh" + y + "Ragh" + z;
					map.put(key, in.nextLong());
				} else {
					int x1 = in.nextInt();
					int y1 = in.nextInt();
					int z1 = in.nextInt();

					int x2 = in.nextInt();
					int y2 = in.nextInt();
					int z2 = in.nextInt();

					long sum = 0;
					int ty1 = y1;
					int tz1 = z1;
					for (String key : map.keySet()) {
						StringTokenizer st = new StringTokenizer(key, "Ragh");
						int xprime = Integer.parseInt(st.nextToken());
						int yprime = Integer.parseInt(st.nextToken());
						int zprime = Integer.parseInt(st.nextToken());

						if (xprime >= x1 && xprime <= x2)
							if (yprime >= y1 && yprime <= y2)
								if (zprime >= z1 && zprime <= z2)
									sum += map.get(key);

					}

					pw.println(sum);
				}

				pw.flush();
			}
		}
	}

}
