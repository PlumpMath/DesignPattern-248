package com.cc.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListDemo {

	/**
	 * Collection
		��List Ĭ��������10
		����LinkedList
		����ArrayList
		����Vector
		������Stack
		��Set
		Map
		��Hashtable
		��HashMap
		��WeakHashMap
	 * ArrayList��List�����࣬����HashSet�෴���������ظ�Ԫ�أ�������򡣼�����Ԫ�ر����ʵ�˳��ȡ���ڼ��ϵ�����
	 * �����ArrayList���з��ʣ���������������0��ʼ��û����һ�Σ�����ֵ��1��Ȼ�����������HashSet�е�Ԫ�أ�ÿ��Ԫ�ؽ��ᰴ��ĳ�������˳�����
	 * ��Ȼ����ȷ���ڵ����������ܹ������������е�����Ԫ�أ����޷�Ԥ֪Ԫ�ر����ʵĴ���
	 */
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("c");
		list.add("d");
		
		//ʹ��Iterator����
		Iterator<String> it = list.iterator();
		while(it.hasNext()){
			System.out.print(it.next() + " ");
		}
		System.out.println();
		//ʹ��foreach����
		for (String s : list) {
			System.out.print(s);
		}
		System.out.println();
		//toString
		System.out.println(list);
	}

}
