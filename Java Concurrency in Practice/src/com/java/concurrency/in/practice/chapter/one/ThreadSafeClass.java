package com.java.concurrency.in.practice.chapter.one;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadSafeClass {
	
	private AtomicInteger count = new AtomicInteger(0);
	private int counterNotAtomic = 0;
	
	public int getCouterValue() {
		return count.get();
	}
	
	public int getCounterNotAtomicValue() {
		return counterNotAtomic;
	}
	
	public void serviceSelf() {
		count.addAndGet(1);
	}
	
	public void serviceSelfNotAtomic() {
		counterNotAtomic++;
	}
	
	


}
