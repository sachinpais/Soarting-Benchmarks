package com.felight.collections;

public class Calculator {
	
	public static int add(int a,int b){
		return a+b;
	}
	
	public static int substract(int a,int b){
		return a-b;
	}
	public static int multiply(int a,int b){
		return a*b;
	}
	public static int divide(int a,int b){
		return a/b;
	}
	
	public static int[] generateNaturalNumvers(int size){
		int[] array=new int[size];
		for(int i=0;i<size;i++)
			array[i]=i+1;
		
		return array;
	}
	
	public static int[] BubbleSort(int[] array){
		int j;
		int temp;
		boolean flag=true;
		while ( flag )
		{
			flag= false;
			for( j=0;j<array.length-1;j++ )
			{
				if ( array[j] > array[j+1] )
				{
					temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
					flag = true;
				}
			}
		}
		return array;
	}
	
	public static boolean isPrime(int number){
		if(number%2==0)
			return false;
		else
			return true;
	}

}
