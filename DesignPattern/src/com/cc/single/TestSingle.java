package com.cc.single;

public class TestSingle {

	public static void main(String[] args) {
		Single single1 = Single.getSingle();
		Single single2 = Single.getSingle();
		System.out.println(single1==single2);
	}

}
