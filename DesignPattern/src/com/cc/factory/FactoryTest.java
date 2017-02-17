package com.cc.factory;

public class FactoryTest {
	public static void main(String[] args) {
		/*普通工厂方法
		SendFactory factory = new SendFactory();
		Sender sender = factory.produce("mail");
		sender.Send();*/
		//多个工厂方法模式
		/*SendFactory factory = new SendFactory();  
        Sender sender = factory.produceSms();  
        sender.Send();  */
		//静态工厂方法模式
		Sender sender =SendFactory.produceMail();
		sender.Send();
	}
}
