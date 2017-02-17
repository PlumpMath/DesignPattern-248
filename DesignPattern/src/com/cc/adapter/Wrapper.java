package com.cc.adapter;
/**
 * ∂‘œÛ  ≈‰∆˜
 * @author chao
 *
 */
public class Wrapper implements Targetable {

	private Source source;
	
	public Wrapper(Source source){  
        super();  
        this.source = source;  
    }  
	
	@Override
	public void method1() {
		System.out.println("this is original method!");
	}

	@Override
	public void method2() {
		System.out.println("this is the targetable method!");
	}

}
