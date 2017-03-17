package com.cc.collection;

import java.util.Iterator;
import java.util.Vector;

public class VectorDemo {

	/**
	 * Vector 是线程安全的 默认容量是10 当容量不够的时候会增加 10》20》40
	 */
	public static void main(String[] args) {
		Vector<String> v = new Vector<String>();
		v.add("a");
		v.add("b");
		v.add("c");
		v.add("d");
		v.add("e");
		Iterator<String> it = v.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}

}
