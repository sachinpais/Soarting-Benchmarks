package com.felight.collections;

public class StudentNode {
	StudentNode previous;
	Student student;
	StudentNode next;
	
	StudentNode(StudentNode previous,Student student,StudentNode next){
		this.previous=previous;
		this.student=student;
		this.next=next;
		
	}
	
	public void setNext(StudentNode next){
		this.next=next;
	}
	
	public StudentNode getNext(){
		return next;
	}
	public void setPrevious(StudentNode previous){
		this.previous=previous;
	}
	public StudentNode getPrevious(){
		return this.previous;
	}

}
