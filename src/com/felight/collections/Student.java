package com.felight.collections;

public class Student {
	public int id;
	public String Name;
	
	Student(int id,String Name){
		this.id=id;
		this.Name=Name;
		
	}
	void Display(){
		System.out.println(id+""+Name);
	}
}
