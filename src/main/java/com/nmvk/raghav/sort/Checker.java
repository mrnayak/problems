package com.nmvk.raghav.sort;

import java.util.Comparator;

public class Checker implements Comparator {

	static class Player {
		String name;
		int score;

		Player(String name, int score) {
			this.name = name;
			this.score = score;
		}
	}

	@Override
	public int compare(Object o1, Object o2) {
		if (o1 instanceof Player && o2 instanceof Player) {
			Player p1 = (Player) o1;
			Player p2 = (Player) o2;
			return p1.score - p2.score;
		}
		return 0;
	}

}
