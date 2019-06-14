package com.devtalk.multithreading;

public class SequencePrinter {
	private static final int COUNTER = 18;

	public static void main(String[] args) {

		Task task = new Task(1, 1);

		new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (task) {
					while (task.getValue() <= COUNTER) {
						if (task.getName() == 1) {
							task.print();
							task.increaseValue();
							task.setName(2);
							task.notifyAll();
						} else {
							try {
								task.wait();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
					try {
						task.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			}

		}, "1").start();

		new Thread(new Runnable() {

			@Override
			public void run() {
				synchronized (task) {
					while (task.getValue() <= COUNTER) {

						if (task.getName() == 2) {
							task.print();
							task.increaseValue();
							task.setName(3);
							task.notifyAll();
						} else {
							try {
								task.wait();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
				}
			}

		}, "2").start();

		new Thread(new Runnable() {

			@Override
			public void run() {
				synchronized (task) {
					while (task.getValue() <= COUNTER) {

						if (task.getName() == 3) {
							task.print();
							task.increaseValue();
							task.setName(1);
							task.notifyAll();
						} else {
							try {
								task.wait();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
				}
			}

		}, "3").start();

	}

}

class Task {

	private int i;
	private int name;

	public Task(int i, int name) {
		this.i = i;
		this.name = name;
	}

	public synchronized void increaseValue() {
		this.i = this.i + 1;
	}

	public synchronized int getValue() {
		return this.i;
	}

	public synchronized void setName(int name) {
		this.name = name;
	}

	public synchronized int getName() {
		return this.name;
	}

	public synchronized void print() {
		System.out.println("Number is: " + this.i + ". Printer: " + Thread.currentThread().getName());
	}

}
