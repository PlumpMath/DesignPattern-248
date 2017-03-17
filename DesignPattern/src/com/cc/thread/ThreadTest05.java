package com.cc.thread;


/**
 * volatile
 * 
 * @author chao �� java
 *         ������������һ���У�������jvm����ʱ���ڴ�ķ��䡣������һ���ڴ�������jvm�����ջ��ÿһ���߳�����ʱ����һ���߳�ջ��
 * 
 *         �߳�ջ�������߳�����ʱ�����ֵ��Ϣ�����̷߳���ĳһ������ʱ��ֵ��ʱ������ͨ������������ҵ���Ӧ�ڶ��ڴ�ı�����ֵ��Ȼ��Ѷ��ڴ�
 * 
 *         �����ľ���ֵload���̱߳����ڴ��У�����һ������������֮���߳̾Ͳ��ٺͶ����ڶ��ڴ����ֵ���κι�ϵ������ֱ���޸ĸ���������ֵ��
 * 
 *         ���޸���֮���ĳһ��ʱ�̣��߳��˳�֮ǰ�����Զ����̱߳���������ֵ��д�������ڶ��б����������ڶ��еĶ����ֵ�Ͳ����仯�ˡ�
 *         
 *         volatile ���εı���ÿ��ʹ�ö��ᵽ���ڴ�ȥȡ��˵����������ǲ��ȶ��ģ�����jvm���������ʱ���޸�ÿ�α��̷߳���ʱ����ǿ�ȴӹ����ڴ����ض��ó�Ա������ֵ�����ң�����Ա���������仯ʱ��ǿ���߳̽��仯ֵ��д�������ڴ档�������κ�ʱ�̣�������ͬ���߳����ǿ���ĳ����Ա������ͬһ��ֵ��
 *         û��ʹ��volatile ���εı��� �̻߳�ѱ������浽�����ڴ��У�������ֱ�������ڴ��ж�ȡ����Ϳ������һ���߳��޸���һ��������ֵ����һ���̻߳�����ʹ�üĴ����еı���������������ݲ�һ��
 * 
 */
public class ThreadTest05 {
	public volatile static int count = 0;
	/*public static ThreadLocal<Integer> count = new ThreadLocal<Integer>(){
		protected Integer initialValue() {
            return 0;  
        }
	};*/
	public static void inc(){
		//�����ӳ�1�룬ʹЧ����ϸ
		try {
			//Thread.sleep(1000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		count++;
	}
	public static void main(String[] args) {
		//ͬʱ����1000���̣߳�ȥ����i++���㣬����ʵ�ʽ��
		for (int i = 0; i < 1000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                	ThreadTest05.inc();
                }
            }).start();
        }
		//����ÿ�����е�ֵ���п��ܲ�ͬ,����Ϊ1000
        System.out.println("���н��:Counter.count=" + ThreadTest05.count);
	}
}