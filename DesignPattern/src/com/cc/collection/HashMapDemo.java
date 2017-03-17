package com.cc.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapDemo {

	/**
	 * HahsMapѰַ���ף�����ɾ����Ч
	 * ���򡢲��ظ�
	 * �̲߳���ȫ HashMap����null key��null value
	 * HashMap��Hashtable��������ʵ�֣����̰߳�ȫ��ʵ�֣���Ҫ��������HashMap����գ�null����ֵ��key��,���ڷ��̰߳�ȫ��Ч���Ͽ��ܸ���Hashtable
	 */
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("a", "a");
		map.put("b", "b1");
		map.put("b", "b2");
		map.put("c", "c");
		map.put("d", "d");
		map.put("", "kong");
		//ѭ��
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
