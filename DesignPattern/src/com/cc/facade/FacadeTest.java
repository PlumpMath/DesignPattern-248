package com.cc.facade;

public class FacadeTest {

	/**
	 * �������û��Computer�࣬��ô��CPU��Memory��Disk����֮�佫���໥����ʵ����������ϵ��������������ص��������޸�һ���࣬
	 * ���ܻ������������޸�
	 * ���ⲻ��������Ҫ�����ģ�����Computer�࣬����֮��Ĺ�ϵ��������Computer������������˽�������ã��⣬�������ģʽ��
	 */
	public static void main(String[] args) {
		Computer computer = new Computer();
		computer.startup();
		computer.shutdown();
	}

}
