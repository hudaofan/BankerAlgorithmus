package com.brainshark.banker.entity;

public class Resources {

	private int a;
	private int b;
	private int c;
	private int d;

	public Resources() {
		super();
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}

	public int getD() {
		return d;
	}

	public void setD(int d) {
		this.d = d;
	}

	public Resources(int a, int b, int c, int d) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}

	public String abcd() {
		return "A B C D";
	}

	public String toResources() {
		return "\tA:" + a + " " + "\tB:" + b + " " + "\tC:" + c + " " + "\tD:" + d;
	}

	@Override
	public String toString() {
		return a + " " + b + " " + c + " " + d;
	}

}
