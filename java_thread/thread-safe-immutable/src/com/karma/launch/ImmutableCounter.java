package com.karma.launch;

public class ImmutableCounter {
	private int value=0;
	
	public ImmutableCounter(int value) {
		this.value = value;
	}
	public ImmutableCounter increament(){
		int incrementedValue = value+1;
		return new ImmutableCounter(incrementedValue);
	}
	public int getValue(){
		return value;
	}
}
