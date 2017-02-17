package com.cc.prototype;

import java.io.IOException;

public class Test {

	public static void main(String[] args) throws ClassNotFoundException, IOException{
		Prototype prototype = new Prototype();
		prototype.setString("…Ó∏¥÷∆");
		Object s = prototype.deepClone();
		Prototype p = (Prototype)s;
		System.out.println(p.getString());
	}
}
