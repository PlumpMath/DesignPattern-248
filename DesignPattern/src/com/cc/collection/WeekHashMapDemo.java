package com.cc.collection;

import java.util.WeakHashMap;

public class WeekHashMapDemo {

	/**
	 * ע��1:null ֵ�� null ������֧�֡� ע��2�������̰߳�ȫ�ġ� ע��3���������Ŀ���ʧ����Ϊ���ܵõ���֤��
	 * ע��4��WeakHashMap������ġ� ע��5:ȷ��ֵ���󲻻�ֱ�ӻ��ӵ�ǿ����������ļ���
	 */
	public static void main(String[] args) {
		int size = 100;
		
		if(args.length>0){
			size = new Integer(args[0]);
		}
		Key[] keys = new Key[size];
		WeakHashMap<Key, Value> whm = new WeakHashMap<Key, Value>();
		for (int i = 0; i < size; i++) {
            Key k = new Key(Integer.toString(i));
            Value v = new Value(Integer.toString(i));
            if (i % 3 == 0) {
                keys[i] = k;//ǿ����
            }
            whm.put(k, v);//���м�ֵ����WeakHashMap��
        }
		System.out.println(whm);
		System.out.println(whm.size());
		System.gc();

		try {
			// �Ѵ�������ʱ���ø�����������������������
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(whm);
		System.out.println(whm.size());
	}
}
class Key {
    String id;

    public Key(String id) {
        this.id = id;
    }

    public String toString() {
        return id;
    }

    public int hashCode() {
        return id.hashCode();
    }

    public boolean equals(Object r) {
        return (r instanceof Key) && id.equals(((Key) r).id);
    }

    public void finalize() {
        System.out.println("Finalizing Key " + id);
    }
}

class Value {
    String id;

    public Value(String id) {
        this.id = id;
    }

    public String toString() {
        return id;
    }

    public void finalize() {
        System.out.println("Finalizing Value " + id);
    }

}
