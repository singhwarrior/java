package com.karma.thread.signal.custom;

public class MySignal {
	private boolean processingDone = false;

	synchronized public boolean isProcessingDone() {
		return processingDone;
	}

	synchronized public void setProcessingDone(boolean processingDone) {
		this.processingDone = processingDone;
	}
}
