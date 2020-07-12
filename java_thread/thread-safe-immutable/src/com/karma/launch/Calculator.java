package com.karma.launch;

public class Calculator {
	private ImmutableCounter counter;

	public ImmutableCounter getCounter() {
		return counter;
	}

	public void setCounter(ImmutableCounter counter) {
		this.counter = counter;
	}
	
	public void increament(){
		this.counter = this.counter.increament();
	}
	
}
