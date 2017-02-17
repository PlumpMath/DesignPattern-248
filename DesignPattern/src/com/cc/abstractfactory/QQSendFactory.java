package com.cc.abstractfactory;

public class QQSendFactory implements Provider {

	@Override
	public Sender produce() {
		return new QQSend();
	}

}
