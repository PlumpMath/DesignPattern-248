package com.cc.adapter;

public class AdapterTest {

	/**
	 * ������ģʽ��ĳ����Ľӿ�ת���ɿͻ�����������һ���ӿڱ�ʾ��Ŀ�����������ڽӿڲ�ƥ������ɵ���ļ��������⡣
	 * ��Ҫ��Ϊ���ࣺ���������ģʽ�������������ģʽ���ӿڵ�������ģʽ�����ȣ��������������������ģʽ
	 */
	public static void main(String[] args) {
		//���������
		/*Targetable target = new Adapter();
		target.method1();
		target.method2();*/
		//����������
		Source source = new Source();  
        Targetable target = new Wrapper(source);  
        target.method1();  
        target.method2();  
	}

}
