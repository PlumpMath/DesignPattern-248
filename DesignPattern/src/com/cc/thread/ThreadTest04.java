package com.cc.thread;

public class ThreadTest04 {

	/**
	 * ����д��������Ҫ���Ǵ���һ���̻߳���ȴ������״̬��
	 * ��򵥵ľ�����һ���߳���סһ������1��ʱ��ȥ�������2�����ڶ����߳�����ס����2��ͬʱȥ�������1����ok�ˡ�
	 * ����Ϊ���������õĲ���ͬһ�����������ͻ���������
	 */
	public static void main(String[] args) {
		Thread t1 = new Thread(new DeadLock(true));
        Thread t2 = new Thread(new DeadLock(false));
        t1.start();
        t2.start();

	}

}
/**
 * �߳�����
 * @author chao
 *
 */
class DeadLock implements Runnable{
	public boolean flag;
	public Object o1 = new Object();
    public Object o2 = new Object();
    public DeadLock(boolean flag){
        this.flag = flag;//�ڹ��췽��������һ��״̬
    }
	@Override
	public void run() {
		if(this.flag){
			synchronized (o1) {
				try {
					Thread.sleep(1000);//�ڵ�һ���߳���סo1����ʱ˯��1�룬��ô��һ�������߳�ռ��o1
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
				//�߳�o2��סo2����ôǰ0.1������o2ռ��o2����0.1����߳�2����o1����ʱo1���߳�1ռ��
				//����o2�ȴ�o1�Ľ����1����߳�����o2����o2���߳�2ռ�ţ���ô�߳�1��Ҫ�ȴ��߳�2�Ľ�����������ǻ���ȴ��Ͳ���
				//������
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