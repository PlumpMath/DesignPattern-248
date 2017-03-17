package com.cc.thread;


public class ThreadTest02{
	public static final Object obj = new Object();
	public static void main(String[] args) {
		new Thread(new Producer()).start();
		new Thread(new Consumer()).start();
	}
}

/**
 * 两个线程依次打印"A""B",总共打印10次。
 * 
 * @author chao 这里使用static
 *         obj作为锁的对象，当线程Produce启动时（假如Produce首先获得锁，则Consumer会等待），打印
 *         “A”后，会先主动释放锁，然后阻塞自己
 *         。Consumer获得对象锁，打印“B”，然后释放锁，阻塞自己，那么Produce又会获得锁，然后...一直循环下去，直到count =
 *         0.这样，使用Synchronized和wait()以及notify()就可以达到线程同步的目的。
 * 
 */
class Consumer implements Runnable{
	@Override
	public void run() {
		int count = 10;
		while(count>0){
			synchronized (ThreadTest02.obj) {
				//wait()和notify()必须在synchronized代码块中调用
				System.out.println("B");
				count --;
				ThreadTest02.obj.notify(); // 主动释放对象锁
				 try {
					 ThreadTest02.obj.wait();//阻塞当前对象
               } catch (InterruptedException e) {
                      // TODO Auto-generated catch block
                     e.printStackTrace();
               }
			}
		}
	}
	
}
class Producer implements Runnable{

	@Override
	public void run() {
		int count = 10;
		while(count>0){
			synchronized (ThreadTest02.obj) {
				System. out.println( "A");
                count --;
                ThreadTest02.obj.notify();//主动释放当前对象锁
                 try {
                	 ThreadTest02.obj.wait();//阻塞当前对象
                } catch (InterruptedException e) {
                       // TODO Auto-generated catch block
                      e.printStackTrace();
                }
			}
		}
		
	}
	
}
