package com.cc.demo;

import java.lang.reflect.Field;

public class Demo01 {
	public static void main(String[] args){
		Integer a=1,b=2;
		System.out.println("before:a="+a+",b="+b);
		/**
		 * �ܽ�
		 * 1���������õ�ֵ����/���ô���
		 * 2��������õĿɷ�����
		 * 3��java������Զ�װ�䡢����
		 * 4��Integerװ��Ķ��󻺴�
		 */
		//swap(a, b);
		swap3(a, b);
		System.out.println("after:a="+a+",b="+b);
	}
	
	private static void swap(Integer i1,Integer i2){
		try {
			Field f = Integer.class.getDeclaredField("value");
			f.setAccessible(true);//����Ȩ�� �����ȡ˽�еĳ�Ա����
			//int temp =  i1.intValue();//temp=1
			Integer temp = new Integer(i1.intValue());
			f.set(i1, i2.intValue());//�޸ĵ�ַ��temp=2
			f.set(i2, temp);
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static void swap2(Integer i1,Integer i2){
		System.out.println("after:a="+i2+",b="+i1);
		System.exit(0);
	}
	//�޸�ֵ
	private static void swap3(Integer i1,Integer i2){
		try {
			Field f = Integer.class.getDeclaredField("value");
			f.setAccessible(true);
			f.set(i1, i1*100);
			f.set(i2, i2*100);
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
