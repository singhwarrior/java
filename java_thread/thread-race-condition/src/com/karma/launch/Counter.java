package com.karma.launch;

public class Counter {
	private Integer count = 0;

	public void increament(int value) {
		count = count + value;
		System.out.println(count);
	}
}
