package com.cc.thread;


public class ThreadTest02{
	public static final Object obj = new Object();
	public static void main(String[] args) {
		new Thread(new Producer()).start();
		new Thread(new Consumer()).start();
	}
}

/**
 * �����߳����δ�ӡ"A""B",�ܹ���ӡ10�Ρ�
 * 
 * @author chao ����ʹ��static
 *         obj��Ϊ���Ķ��󣬵��߳�Produce����ʱ������Produce���Ȼ��������Consumer��ȴ�������ӡ
 *         ��A���󣬻��������ͷ�����Ȼ�������Լ�
 *         ��Consumer��ö���������ӡ��B����Ȼ���ͷ����������Լ�����ôProduce�ֻ�������Ȼ��...һֱѭ����ȥ��ֱ��count =
 *         0.������ʹ��Synchronized��wait()�Լ�notify()�Ϳ��Դﵽ�߳�ͬ����Ŀ�ġ�
 * 
 */
class Consumer implements Runnable{
	@Override
	public void run() {
		int count = 10;
		while(count>0){
			synchronized (ThreadTest02.obj) {
				//wait()��notify()������synchronized������е���
				System.out.println("B");
				count --;
				ThreadTest02.obj.notify(); // �����ͷŶ�����
				 try {
					 ThreadTest02.obj.wait();//������ǰ����
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
                ThreadTest02.obj.notify();//�����ͷŵ�ǰ������
                 try {
                	 ThreadTest02.obj.wait();//������ǰ����
                } catch (InterruptedException e) {
                       // TODO Auto-generated catch block
                      e.printStackTrace();
                }
			}
		}
		
	}
	
}
