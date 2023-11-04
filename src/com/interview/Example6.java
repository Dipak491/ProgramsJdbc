package com.interview;

public class Example6 {

	public static void main(String[] args) 
	{
		int x;
		
		x =5;
		
		{
			int y =6;
			
			System.out.println(x+ " " +y);  //5  6
		}
		
		System.out.println(x + "  "+y); //error y can not be resolved y 

	}

}