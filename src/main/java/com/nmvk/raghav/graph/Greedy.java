package com.nmvk.raghav.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Greedy {

	public static void main(String[] args) {
		
		
		int[] x = {2,4,6};
		
		int d = 0;
		towerPlaceMent(x, d);
		
		
	}

	private static void towerPlaceMent(int[] x, int d) {
		
		List<Integer> y = new LinkedList<>();
		
		int tower1 = x[0] + d;
		y.add(tower1);
		
		int lastTower = tower1;
		for(int i = 1; i < x.length; i++)
		{
			if(d < Math.abs(x[i] - lastTower))
			{
				lastTower = x[i] + d;
				y.add(lastTower);
			}
		}
		
		System.out.println(y);
	}

}
