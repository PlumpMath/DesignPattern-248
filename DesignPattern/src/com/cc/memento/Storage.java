package com.cc.memento;

public class Storage {
	private Memento memento;
	
	public Storage(Memento memento){
		this.memento=memento;
	}

	public Memento getMemento() {
		return memento;
	}
	public void setMemento(Memento memento) {
		this.memento = memento;
	}
	
}
