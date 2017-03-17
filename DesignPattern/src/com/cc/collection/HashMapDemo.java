package com.cc.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapDemo {

	/**
	 * HahsMap寻址容易，插入删除高效
	 * 无序、不重复
	 * 线程不安全 HashMap允许null key和null value
	 * HashMap是Hashtable的轻量级实现（非线程安全的实现）主要区别在于HashMap允许空（null）键值（key）,由于非线程安全，效率上可能高于Hashtable
	 */
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("a", "a");
		map.put("b", "b1");
		map.put("b", "b2");
		map.put("c", "c");
		map.put("d", "d");
		map.put("", "kong");
		//循环
		Set<String> set = map.keySet();
		Iterator<String> it = set.iterator();
		while(it.hasNext()){
			System.out.println(map.get(it.next()));
		}
		
		for (String s : set) {
			System.out.println(map.get(s));
		}
	}

}
