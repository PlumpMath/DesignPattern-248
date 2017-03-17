package com.cc.collection;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

public class HashTableDemo {

	/**
	 * HashTable是线程安全的一个Collection。
	 * HashTable不允许key和value为null hashMap可以
	 * 最大的不同是，Hashtable的方法是Synchronize的，而HashMap不是，在多个线程访问Hashtable时，不需要自己为它的方法实现同步，而HashMap 就必须为之提供外同步。 
	 * Hashtable和HashMap采用的hash/rehash算法都大概一样，所以性能不会有很大的差
	 * 无序的
	 */
	public static void main(String[] args) {
		Hashtable<String,String> h = new Hashtable<String, String>();
		h.put("a", "a");
		h.put("a", "b");
		//h.put("", "b");
		h.put("b", "b");
		h.put("c", "c");
		h.put("d", "d");
		Set<String> set = h.keySet();
		Iterator<String> it = set.iterator();
		while(it.hasNext()){
			System.out.println("hashtable key: value:"+h.get(it.next()));
		}
		Enumeration<String> e = h.elements();
		while(e.hasMoreElements()){
			System.out.println(e.nextElement());
		}
	}

}
