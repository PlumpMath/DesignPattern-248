package com.cc.command;
/**
 * ����ģʽ�ܺ���⣬�ٸ����ӣ�˾��Ա������ʿ��ȥ�ɼ����飬����������ĽǶ������ǣ�˾��Ա�������ǣ����������������ݣ�������ʿ�������ʿ��ȥִ�С�
 * ������̺��ڣ������໥����κ�һ��������ȥ���������ˣ�ֻ��Ҫ�����Լ����¶����У�˾��ԱҪ���ǽ��������ȥ��ע����ʿ������ôʵ�ֵġ�
 * Invoker�ǵ����ߣ�˾��Ա����Receiver�Ǳ������ߣ�ʿ������MyCommand�����ʵ����Command�ӿڣ����н��ն���
 * @author chao
 *
 */
public class Test {
	public static void main(String[] args) {
		Receiver receiver = new Receiver();
		Command cmd = new MyCommand(receiver);
		Invoker invoker = new Invoker(cmd);
		invoker.action();
	}
}
