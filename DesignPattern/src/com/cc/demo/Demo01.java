package com.cc.demo;

import java.lang.reflect.Field;

public class Demo01 {
	public static void main(String[] args){
		Integer a=1,b=2;
		System.out.println("before:a="+a+",b="+b);
		/**
		 * 总结
		 * 1、函数调用的值传递/引用传递
		 * 2、反射调用的可访问性
		 * 3、java编译的自动装箱、拆箱
		 * 4、Integer装箱的对象缓存
		 */
		//swap(a, b);
		swap3(a, b);
		System.out.println("after:a="+a+",b="+b);
	}
	
	private static void swap(Integer i1,Integer i2){
		try {
			Field f = Integer.class.getDeclaredField("value");
			f.setAccessible(true);//设置权限 反射获取私有的成员变量
			//int temp =  i1.intValue();//temp=1
			Integer temp = new Integer(i1.intValue());
			f.set(i1, i2.intValue());//修改地址后temp=2
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
	//修改值
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
