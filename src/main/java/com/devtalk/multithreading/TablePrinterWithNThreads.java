package com.devtalk.multithreading;

public class TablePrinterWithNThreads {
	private static final int THREAD_COUNTER = 4;

	public static void main(String[] args) {
		MyJob job = new MyJob(2, "1");

		for (int t = 1; t <= THREAD_COUNTER; t++) {
			new Thread(job, String.valueOf(t)).start();
		}

	}
}

class MyJob implements Runnable {
	private static final int THREAD_COUNTER = 4;
	private int value;
	private String threadName;
	private int count = 1;
	private Object lock = new Object();

	public MyJob(int value, String threadName) {
		this.value = value;
		this.threadName = threadName;
	}

	@Override
	public void run() {
		synchronized (lock) {
			while (this.count <= 10) {
				if (Thread.currentThread().getName().equalsIgnoreCase(this.threadName)) {
					System.out.println("" + this.value + "*" + this.count + " is: " + (this.value * this.count)
							+ ". Printer: " + Thread.currentThread().getName());
					count++;
					int t = Integer.valueOf(Thread.currentThread().getName());
					if (t + 1 <= THREAD_COUNTER) {
						this.threadName = String.valueOf(t + 1);
					} else {
						this.threadName = String.valueOf((t + 1) % THREAD_COUNTER);
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
