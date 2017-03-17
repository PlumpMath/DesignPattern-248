package com.cc.thread;

public class ThreadTest04 {

	/**
	 * 所以写死锁最主要的是创建一个线程互相等待结果的状态，
	 * 最简单的就是在一个线程锁住一个对象1的时候去请求对象2，而第二个线程在锁住对象2的同时去请求对象1，就ok了。
	 * 是因为两个锁引用的不是同一个锁，这样就会引起死锁
	 */
	public static void main(String[] args) {
		Thread t1 = new Thread(new DeadLock(true));
        Thread t2 = new Thread(new DeadLock(false));
        t1.start();
        t2.start();

	}

}
/**
 * 线程死锁
 * @author chao
 *
 */
class DeadLock implements Runnable{
	public boolean flag;
	public Object o1 = new Object();
    public Object o2 = new Object();
    public DeadLock(boolean flag){
        this.flag = flag;//在构造方法里输入一个状态
    }
	@Override
	public void run() {
		if(this.flag){
			synchronized (o1) {
				try {
					Thread.sleep(1000);//在第一个线程锁住o1对象时睡眠1秒，那么这一秒内是线程占着o1
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				synchronized (o2) {
					System.out.println("01 is ok");
				}
			}
		}else{
			 try {
				Thread.sleep(100);
				//线程o2锁住o2，那么前0.1秒内是o2占着o2，在0.1秒后，线程2请求o1而此时o1被线程1占着
				//所以o2等待o1的结果。1秒后，线程请求o2，而o2被线程2占着，那么线程1又要等待线程2的结果，于是他们互相等待就产生
				//死锁了
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 synchronized(o1){
                 System.out.println("02 is ok");
             }
		}
	}
	
}