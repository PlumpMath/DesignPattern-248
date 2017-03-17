package com.cc.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetDemo {

	/**
	 * HashSet是Set接口的一个子类，
	 * 主要特点是：里面不能存放重复的元素，而且采用散列的存储方法，所以没有顺序。
	 * 这里说的没有顺序是指：元素插入的顺序和输出的顺序不一致
	 */
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		set.add("a");
        set.add("b");
        set.add("c");
        set.add("c");
        set.add("d");
		
		//使用Iterable方法遍历
		Iterator<String> it = set.iterator();
		while(it.hasNext()){
			System.out.print(it.next()+" ");
		}
		System.out.println();
		//使用foreach循环
		for (String s : set) {
			System.out.print(s);
		}
		System.out.println();
		//使用toString输出集合
		System.out.println(set.toString());
	}

}
