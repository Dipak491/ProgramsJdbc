package com.interview;

public class Example5 {

	public static void main(String[] args) {

		int var[] = new int[10];
		
		for(int i = 0; i<10; ++i)
		{
			var[i] = i/2;
			
			var[i]++;
			System.out.println(var[i]+ " ");
			
			i++;

		}
		
	}

}
