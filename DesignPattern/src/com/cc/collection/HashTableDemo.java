package com.cc.collection;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

public class HashTableDemo {

	/**
	 * HashTable���̰߳�ȫ��һ��Collection��
	 * HashTable������key��valueΪnull hashMap����
	 * ���Ĳ�ͬ�ǣ�Hashtable�ķ�����Synchronize�ģ���HashMap���ǣ��ڶ���̷߳���Hashtableʱ������Ҫ�Լ�Ϊ���ķ���ʵ��ͬ������HashMap �ͱ���Ϊ֮�ṩ��ͬ���� 
	 * Hashtable��HashMap���õ�hash/rehash�㷨�����һ�����������ܲ����кܴ�Ĳ�
	 * �����
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
