package com.example.demo.aop;

public class aa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i=0;
		for(testA('A');testA('B')&&(i<2);testA('c')) {
			i++;
			testA('D');
		}
	}
	
	public static boolean testA(char c) {
		System.out.println(c);
		return true;
	}
	
}
