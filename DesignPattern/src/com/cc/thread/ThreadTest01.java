package com.cc.thread;

import org.junit.Test;

public class ThreadTest01 {

	/**
	 * ������T1��T2��T3�����̣߳���������֤T2��T1ִ�����ִ�У�T3��T2ִ�����ִ�У�
	 * Java Thread�У� join() �������õ��ø÷��������߳�ִ��run()ʱ��ʱ��ס����run()ִ����ɺ� ���߳��ٵ���ִ��join()����Ĵ���
	 * ���ȥ��t1.join()��������� �����˳�����ҵģ� ����������� �ͻᰴ��˳�������  ��ĳ��������˵ʵ����ͬ����
	 */
	@Test
	public void Test1(){
		//�߳�1
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
		//�߳�2
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
		//�߳�3
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
