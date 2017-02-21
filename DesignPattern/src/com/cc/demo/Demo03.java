package com.cc.demo;

public class Demo03 implements Runnable{

	/**
	 * Synchronized(�߳�ͬ��)
	 * 1��Ϊʲô��ʹ���߳�ͬ��
	 * 	java������̲߳������ƣ�������̷߳���ͬһ�������Ա������ʱ�򣬽�������̰߳�ȫ����
	 * 	java synchronized�ؼ��� ��synchronized������һ����������һ��������ʱ���ܺ�֤��ͬһʱ�����ֻ��һ���߳�ִ�иô���
	 * Synchronized ��ס�ľ�����ʲô����ס����һ�����󣬶�������synchronized�����ڷ�����ʱ����ס������������ʵ�� public synchronized
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
