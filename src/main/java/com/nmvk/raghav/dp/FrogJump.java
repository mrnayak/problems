package com.nmvk.raghav.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class FrogJump {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] x = { 0,1,3,4,5,7,9,10,12 };
		System.out.println(distDP(x));
		long n = 1l;
        long sum = 0;
        for(long i = 0; i < n; i++){
            if(n+i == (n ^ i)) sum++;
        }
	}

	public static boolean canCross(int[] stones) {

		List<Integer> aList = new ArrayList<>();

		for (int s : stones)
			aList.add(s);

		 aList.remove(0);
		// System.out.println(dist(stones[aList.size()], aList, 1));
		return dist(stones[aList.size()], aList, 1) == 0;
	}

	public static int dist(int distance, List<Integer> points, int jump) {
		List<Integer> pts = new ArrayList<>(points);
		int point = pts.get(0);

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		if (point == distance)
			return 0;
		for (int k = jump - 1; k <= jump + 1; k++) {
			if (k == 0)
				continue;
			if (pts.contains(point + k)) {
				pq.add(dist(distance, pts.subList(pts.indexOf(point + k), pts.size()), k));
			}
		}
		return pq.peek() == null ? distance : pq.peek();
	}

	public static boolean distDP(int[] stones) {
		Map<Integer, HashSet<Integer>> map = new HashMap<>();

		for (int i = 0; i < stones.length; i++)
			map.put(stones[i], new HashSet<>());
		 map.get(0).add(1);
		for (int p : stones) {
			for (int step : map.get(p)) {
				int d = step + p;
				if (d == stones[stones.length - 1]) {
					return true;
				}  if (map.get(d) != null) {
					HashSet<Integer> set = map.get(d);
					set.add(step);
					if (step - 1 > 0)
						set.add(step - 1);
					set.add(step + 1);
				}
			}
		}

		return false;
	}

}
