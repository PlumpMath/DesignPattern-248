package com.cc.factory;

public class FactoryTest {
	public static void main(String[] args) {
		/*��ͨ��������
		SendFactory factory = new SendFactory();
		Sender sender = factory.produce("mail");
		sender.Send();*/
		//�����������ģʽ
		/*SendFactory factory = new SendFactory();  
        Sender sender = factory.produceSms();  
        sender.Send();  */
		//��̬��������ģʽ
		Sender sender =SendFactory.produceMail();
		sender.Send();
	}
}
