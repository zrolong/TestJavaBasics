package com.example.testgeneric;

public class Student {

	private Object javase;
	private Object oracle;

	public Student() {

	}

	public Student(Object javase, Object oracle) {

		this.javase = javase;
		this.oracle = oracle;
	}

	public Object getJavase() {
		return javase;
	}

	public void setJavase(Object javase) {
		this.javase = javase;
	}

	public Object getOracle() {
		return oracle;
	}

	public void setOracle(Object oracle) {
		this.oracle = oracle;
	}

}
