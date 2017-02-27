package com.felight.collections;

public class Employee {
	public int id;
	public String Name;
	private double Salary;
	
	Employee(int id,String Name,double Salary){
		this.id=id;
		this.Name=Name;
		this.setSalary(Salary);
	}

	public double getSalary() {
		return Salary;
	}

	public void setSalary(double salary) {
		Salary = salary;
	}

}
