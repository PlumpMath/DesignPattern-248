package com.cc.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetDemo {

	/**
	 * HashSet��Set�ӿڵ�һ�����࣬
	 * ��Ҫ�ص��ǣ����治�ܴ���ظ���Ԫ�أ����Ҳ���ɢ�еĴ洢����������û��˳��
	 * ����˵��û��˳����ָ��Ԫ�ز����˳��������˳��һ��
	 */
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		set.add("a");
        set.add("b");
        set.add("c");
        set.add("c");
        set.add("d");
		
		//ʹ��Iterable��������
		Iterator<String> it = set.iterator();
		while(it.hasNext()){
			System.out.print(it.next()+" ");
		}
		System.out.println();
		//ʹ��foreachѭ��
		for (String s : set) {
			System.out.print(s);
		}
		System.out.println();
		//ʹ��toString�������
		System.out.println(set.toString());
	}

}
