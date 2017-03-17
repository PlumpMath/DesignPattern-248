package com.cc.thread;

import org.junit.Test;

public class ThreadTest01 {

	/**
	 * 现在有T1、T2、T3三个线程，你怎样保证T2在T1执行完后执行，T3在T2执行完后执行？
	 * Java Thread中， join() 方法是让调用该方法的主线程执行run()时暂时卡住，等run()执行完成后， 主线程再调用执行join()后面的代码
	 * 如果去掉t1.join()这个语句过后， 输出的顺序是乱的， 加上这个语句后， 就会按照顺序输出，  从某种意义上说实现了同步。
	 */
	@Test
	public void Test1(){
		//线程1
		Thread thread1 = new Thread() {
			@Override
			public void run() {
				try {
					System.out.println("thread 1 running....");
					sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					System.out.println("thread 1 stoped....");
				}
				super.run();
			}
		};
		//线程2
		Thread thread2 = new Thread() {
			@Override
			public void run() {
				try {
					System.out.println("thread 2 running....");
					sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					System.out.println("thread 2 stoped....");
				}
				super.run();
			}
		};
		//线程3
		Thread thread3 = new Thread() {
			@Override
			public void run() {
				try {
					System.out.println("thread 3 running....");
					sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					System.out.println("thread 3 stoped....");
				}
				super.run();
			}
		};
		try {
			thread1.start();
			thread1.join();
			thread2.start();
			thread2.join();
			thread3.start();
			thread3.join();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
