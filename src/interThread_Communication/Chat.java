package interThread_Communication;

import java.util.Arrays;

public class Chat {
	boolean flag = false;

	public synchronized void Question(String msg) {
		if(flag) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(msg);
		flag = true;
		notify();
	}

	public synchronized void Answer(String msg) {
		if(!flag) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(msg);
		flag = false;
		notify();
	}	
}

class T1 implements Runnable {
	Chat m;
	String[] s1 = {"Hi", "How are you", "I am doing well"};
	
	public T1(Chat m1) {
		this.m = m1;
		Thread t1 = new Thread(this, "Question Thread");
		t1.start();
		//System.out.println(t1.getName());
	}
	@Override
	public void run() {
		for(int i=0; i<s1.length; i++) {
			m.Question(s1[i]);
		}
	}
	
}
class T2 implements Runnable {
	Chat m;
	String[] s2 = {"Hi", "I am good, what about you?", "Great!"};
	
	public T2(Chat m2) {
		this.m = m2;
		Thread t2 = new Thread(this, "Answer thread");
		t2.start();
		//System.out.println(t2.getName());
	}
	@Override
	public void run() {
		for(int i=0; i<s2.length; i++) {
			m.Answer(s2[i]);
		}
	}
}