package com.cc.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListDemo {

	/**
	 * Collection
		├List 默认容量是10
		│├LinkedList
		│├ArrayList
		│└Vector
		│　└Stack
		└Set
		Map
		├Hashtable
		├HashMap
		└WeakHashMap
	 * ArrayList是List的子类，它和HashSet相反，允许存放重复元素，因此有序。集合中元素被访问的顺序取决于集合的类型
	 * 如果对ArrayList进行访问，迭代器将从索引0开始，没迭代一次，索引值加1，然而，如果访问HashSet中的元素，每个元素将会按照某种随机的顺序出现
	 * 虽然可以确定在迭代过程中能够遍历到集合中的所有元素，但无法预知元素被访问的次序
	 */
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("c");
		list.add("d");
		
		//使用Iterator遍历
		Iterator<String> it = list.iterator();
		while(it.hasNext()){
			System.out.print(it.next() + " ");
		}
		System.out.println();
		//使用foreach遍历
		for (String s : list) {
			System.out.print(s);
		}
		System.out.println();
		//toString
		System.out.println(list);
	}

}
