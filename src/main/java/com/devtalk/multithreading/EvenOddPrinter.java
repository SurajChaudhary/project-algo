package com.devtalk.multithreading;

public class EvenOddPrinter {

	public static void main(String[] args) {
		EvenOddJob job = new EvenOddJob();

		new Thread(job, "pong").start();
		new Thread(job, "ping").start();
	}
}

class EvenOddJob implements Runnable {
	private static final int COUNTER = 18;
	private int count = 1;
	private Object lock = new Object();

	@Override
	public void run() {
		synchronized (lock) {
			while (this.count <= COUNTER) {

				if (Thread.currentThread().getName().equalsIgnoreCase("pong") && (this.count % 2 == 0)) {
					System.out.println(
							"Even Number is: " + this.count + ". Printer: " + Thread.currentThread().getName());
					count++;
					lock.notifyAll();
				} else if (Thread.currentThread().getName().equalsIgnoreCase("ping") && (this.count % 2 != 0)) {
					System.out
							.println("Odd Number is: " + this.count + ". Printer: " + Thread.currentThread().getName());
					count++;
					lock.notifyAll();
				} else {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			}
		}

	}

}