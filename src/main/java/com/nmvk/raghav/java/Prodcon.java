package com.nmvk.raghav.java;

import java.util.ArrayList;
import java.util.List;
public class Prodcon {
	
	
	static class Producer extends Thread {
		List<String> list;

		public Producer(List<String> list) {
			this.list = list;
		}

		@Override
		public void run() {

			for (int i = 0; i < 9; i++) {
				if (list.size() != 0) {
					synchronized (list) {
						try {
							list.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				synchronized (list) {
					System.out.println("Producer : " + i);
					list.add(String.valueOf(i));
					list.notifyAll();
				}

			}

		}
	}

	static class Consumer extends Thread {
		List<String> list;

		public Consumer(List<String> list) {
			this.list = list;
		}

		@Override
		public void run() {
			for (int i = 0; i < 9; i++) {
				if (list.size() == 0) {
					try {
						synchronized (list) {
							System.out.println("Waiting for the producer");
							list.wait();
							System.out.println("Yippie Producer produced");
						}
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				synchronized (list) {
					System.out.println("Consuming : " + list.get(0));
					list.remove(0);
					list.notifyAll();
				}
			}
		}

	}

	public static void main(String[] args) throws InterruptedException {
		List<String> arr = new ArrayList<>();
		Producer p = new Producer(arr);
		p.start();

		Consumer c = new Consumer(arr);
		c.start();
		
		c.join();
		p.join();
		
		System.out.println(arr.size());
	}

}
