package com.cc.decorator;

import com.cc.decorator.Sourceable;

public class Source implements Sourceable {

	@Override
	public void method() {
		System.out.println("the original method!");  
	}

}
