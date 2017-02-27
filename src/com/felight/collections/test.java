package com.felight.collections;

public class test {

	public static void main(String[] args) {
		//int ar[]={6,5,4,3,2,1};
		int array[]=Calculator.generateNaturalNumvers(10);
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
		System.out.println();
		
		/*StudentCollection std=new StudentCollection();
		Student st=new Student(1," Test");
		Student st2=new Student(2," Test1");
		Student st3=new Student(3," Test3");
		Student st4=new Student(4," Test4");
		std.add(st);
		std.add(st2);
		std.add(st4);
		std.addFirst(st3);
		//std.addToPosition(1,st);
		std.display();*/
	}

}
