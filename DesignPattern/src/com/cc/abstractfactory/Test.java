package com.cc.abstractfactory;

public class Test {

	/**
	 * ���Գ��󹤳�ģʽ
	 * ��������ģʽ��һ��������ǣ���Ĵ������������࣬Ҳ����˵�������Ҫ��չ����
	 * ����Թ���������޸ģ���Υ���˱հ�ԭ�����ԣ�����ƽǶȿ��ǣ���һ�������⣬��ν����
	 * ���õ����󹤳�ģʽ��������������࣬����һ����Ҫ�����µĹ��ܣ�ֱ�������µĹ�����Ϳ����ˣ�����Ҫ�޸�֮ǰ�Ĵ���
	 * @param args
	 */
	public static void main(String[] args) {
		Provider provider = new QQSendFactory();
		Sender sender = provider.produce();
		sender.Send();
	}

}
