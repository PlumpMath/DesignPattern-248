package com.cc.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * 在并发量比较小的情况下，使用synchronized是个不错的选择，但是在并发量比较高的情况下，其性能下降很严重，
 * 此时ReentrantLock是个不错的方案。
 * lock接口在多线程和并发编程中最大的优势是它们为读和写分别提供了锁
 * @author chao
 *
 */
public class ThreadTest03 {

	/**
	 * 使用lock来实现两个线程之间的同步
	 * 两个线程依次打印"A""B",总共打印10次。
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