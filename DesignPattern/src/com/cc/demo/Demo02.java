package com.cc.demo;

public class Demo02 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Integer -128 - 127 jvm启动时就分配好了内存地址 超过这个范围 就会重新分配地址
		Integer a=127;
		Integer b=127;
		System.out.println(a==b);
	}

}
