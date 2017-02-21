package com.cc.demo;

public class Demo03 implements Runnable{

	/**
	 * Synchronized(线程同步)
	 * 1、为什么是使用线程同步
	 * 	java允许多线程并发控制，当多个线程访问同一个共享成员变量的时候，将会产生线程安全问题
	 * 	java synchronized关键字 当synchronized来修饰一个方法或者一个代码块的时候。能后保证在同一时刻最多只有一个线程执行该代码
	 * Synchronized 锁住的具体是什么？锁住的是一个对象，而当我们synchronized作用在方法的时候，锁住的是这个对象的实例 public synchronized
	 */
	public static void main(String[] args) {
		Demo03 d3 = new Demo03();
		Thread thread1 = new Thread(d3,"Thread-A");
		Thread thread2 = new Thread(d3,"Thread-B");
		thread1.start();
		thread2.start();
	}

	@Override
	public synchronized void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName());
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}

}
