package com.devtalk.multithreading;

public class SequencePrinterWithNThreads {
	private static final int THREAD_COUNTER = 3;

	public static void main(String[] args) {
		Job job = new Job("1");

		for (int t = 1; t <= THREAD_COUNTER; t++) {
			new Thread(job, String.valueOf(t)).start();
		}

	}
}

class Job implements Runnable {
	private static final int THREAD_COUNTER = 3;
	private static final int COUNTER = 18;
	private int count = 1;
	private String name;
	private Object lock = new Object();

	public Job(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		synchronized (lock) {
			while (this.count <= COUNTER) {

				if (Thread.currentThread().getName().equalsIgnoreCase(name)) {
					System.out.println("Number is: " + this.count + ". Printer: " + Thread.currentThread().getName());
					count++;
					int t = Integer.valueOf(Thread.currentThread().getName());
					if (t + 1 <= THREAD_COUNTER) {
						this.name = String.valueOf(t + 1);
					} else {
						this.name = String.valueOf((t + 1) % THREAD_COUNTER);
					}
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
