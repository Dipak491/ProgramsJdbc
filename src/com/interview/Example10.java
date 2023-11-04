package com.interview;

class A
{
	public int calculate(int a, int b)
	{
		return 1;
	}
}

class B extends A
{
	public int calculate(int a, int b)
	{
		return 2;
	}
}


public class Example10 {

	public static void main(String[] args) 
	{
		B obj = new B();
		
		//System.out.println("b is "+b.calculate(0,1)); given lines have error 
		//let fix it 
		
		System.out.println("b is"+obj.calculate(0, 1)); //b is 2
		

	}

}
//