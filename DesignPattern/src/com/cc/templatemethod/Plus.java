package com.cc.templatemethod;

public class Plus extends AbstractCalculator {

	@Override
	protected int calculate(int num1, int num2) {
		return num1 + num2;
	}

}
