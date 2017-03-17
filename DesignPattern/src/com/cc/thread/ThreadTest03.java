package com.cc.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * �ڲ������Ƚ�С������£�ʹ��synchronized�Ǹ������ѡ�񣬵����ڲ������Ƚϸߵ�����£��������½������أ�
 * ��ʱReentrantLock�Ǹ�����ķ�����
 * lock�ӿ��ڶ��̺߳Ͳ����������������������Ϊ����д�ֱ��ṩ����
 * @author chao
 *
 */
public class ThreadTest03 {

	/**
	 * ʹ��lock��ʵ�������߳�֮���ͬ��
	 * �����߳����δ�ӡ"A""B",�ܹ���ӡ10�Ρ�
	 */
	public static void main(String[] args) {
		Lock lock = new ReentrantLock();
        
		Consumer_lock consumer = new Consumer_lock(lock);
		Producer_lock producer = new Producer_lock(lock);
		new Thread( producer).start();
         new Thread(consumer).start();
	}

}
class Producer_lock implements Runnable{

	private Lock lock;
	public Producer_lock(Lock lock){
		this.lock=lock;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int count = 10;
		while(count > 0){
			try {
				lock.lock();
				count --;
				System.out.println("A");
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				lock.unlock();
				try {
					Thread.sleep(90L);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
}
class Consumer_lock implements Runnable{

	private Lock lock;
	
	public Consumer_lock(Lock lock){
		this.lock=lock;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int count = 10;
		while(count > 0){
			try {
				lock.lock();
				count --;
				System.out.println("B");
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				lock.unlock();
				try {
					Thread.sleep(91L);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
}