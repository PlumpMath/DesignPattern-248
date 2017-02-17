package com.cc.single;

/**
 * ����ģʽ 2016��12��29�� 16:10:09
 * 
 * @author chao
 *         ��������Singleton����һ�ֳ��õ����ģʽ����JavaӦ���У����������ܱ�֤��һ��JVM�У��ö���ֻ��һ��ʵ�����ڡ�������ģʽ�м����ô�
 *         ��
 * 
 *         1��ĳЩ�ഴ���Ƚ�Ƶ��������һЩ���͵Ķ�������һ�ʺܴ��ϵͳ������
 * 
 *         2��ʡȥ��new��������������ϵͳ�ڴ��ʹ��Ƶ�ʣ�����GCѹ����
 * 
 *         3����Щ���罻�����ĺ��Ľ������棬�����Ž������̣����������Դ�������Ļ���ϵͳ��ȫ���ˡ�
 *         ������һ�����ӳ����˶��˾��Աͬʱָ�ӣ��϶����ҳ�һ�ţ�������ֻ��ʹ�õ���ģʽ�����ܱ�֤���Ľ��׷��������������������̡�
 */
public class Single {

	// 1�����Ƚ����캯�������˽�е�
	private Single() {
	};

	// 2��һ������ ʵ���� ����ʽ
	public static Single single;// ��Ҫ��ʱ��new���� �̲߳���ȫ

	// ����ʽ
	// public static Single single = new Single();//������ص�ʱ���ʵ������һ�����󣬲�����Ҫ����Ҫ
	// �̰߳�ȫ

	// 3�����徲̬�ķ���
	/*public static Single getSingle() {
		if (single == null) {
			single = new Single();
			System.out.println("��һ�ε��ã���Ҫʵ��������");
		} else {
			System.out.println("�ö����Ѿ�ʵ�������� ����Ҫ��ʵ������");
		}
		return single;
	}*/
	//synchronized�ؼ�����ס������������������÷����������ϻ������½�����Ϊÿ�ε���getInstance()��
	//��Ҫ�Զ�����������ʵ�ϣ�ֻ���ڵ�һ�δ��������ʱ����Ҫ������֮��Ͳ���Ҫ��
	public static Single getSingle(){
		if (single == null) {
			synchronized(single){
				single = new Single();
				System.out.println("��һ�ε��ã���Ҫʵ��������");
			}
		} else {
			System.out.println("�ö����Ѿ�ʵ�������� ����Ҫ��ʵ������");
		}
		return single;
	}
	
    /* �˴�ʹ��һ���ڲ�����ά������ */
	private static class SingletonFactory {
		private static Single instance = new Single();
	}
	/* ��ȡʵ�� */  
	public static Single getInstance() {
		return SingletonFactory.instance;
	}
	/* ����ö����������л������Ա�֤���������л�ǰ�󱣳�һ�� */  
    public Object readResolve() {  
        return single;  
    }
}
