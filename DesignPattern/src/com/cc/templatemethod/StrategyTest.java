package com.cc.templatemethod;

public class StrategyTest {

	/**
	 * ����һ��ģ�巽��ģʽ������ָ��һ���������У���һ�����������ٶ���1...n�������������ǳ���ģ�
	 * Ҳ������ʵ�ʵķ���������һ���࣬�̳иó����࣬��д���󷽷���ͨ�����ó����࣬ʵ�ֶ�����ĵ���
	 * 
	 * ������AbstractCalculator���ж���һ��������calculate��calculate()����spilt()�ȣ�
	 * Plus��Minus�ֱ�̳�AbstractCalculator�࣬ͨ����AbstractCalculator�ĵ���ʵ�ֶ�����ĵ���
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String exp = "8+8";
		AbstractCalculator cal = new Plus();
		int result = cal.calculate(exp, "\\+");
		System.out.println(result);
	}

}
