package com.felight.collections;

public class StudentCollection {
	private StudentNode node;
	private StudentNode FirstNode, CurrentNode,NextNode;
	private StudentNode NewNode;
	int index = 0;
	boolean status = true;

	public void add(Student student) {
		if (node == null) {
			node = new StudentNode(null, student, null);
			FirstNode = node;
			CurrentNode = node;
		} else {
			NewNode = new StudentNode(CurrentNode, student, null);
			NewNode.setPrevious(CurrentNode);
			CurrentNode.setNext(NewNode);
			CurrentNode = NewNode;
		}
	}

	public void addFirst (Student student) {
		int position=0;
		while (status) {
			if (position == 0) {
				CurrentNode=FirstNode;
				NewNode = new StudentNode(null, student, CurrentNode);
				CurrentNode.setPrevious(NewNode);
				NewNode.setNext(CurrentNode);
				FirstNode=NewNode;
				status=false;
			}
		}
	}
		
	public void addLast(Student student){
		CurrentNode=FirstNode;
		while(CurrentNode.getNext()!=null){
			NextNode=CurrentNode = CurrentNode.next;
			CurrentNode=NextNode;
			
		}	
			
	}
	
	public void addToPosition(int position,Student student){
		CurrentNode=FirstNode;
		while(index!=position){
			NextNode=CurrentNode = CurrentNode.next;
			CurrentNode=NextNode;
			index++;
		}
		NewNode=new StudentNode(CurrentNode,student,NextNode);
		CurrentNode.setNext(NewNode);
		NextNode.setPrevious(NewNode);
		
	}

		/*	} else if(index==position){
				NewNode = new StudentNode(CurrentNode, student, null);
				NewNode.setNext(CurrentNode.getNext());
				//CurrentNode.getNext().setPrevious(NewNode.getNext());
				CurrentNode.setNext(NewNode);
				//NewNode.setPrevious(CurrentNode);
				CurrentNode = NewNode;
				NewNode=NewNode.getNext();
				status = false;
			}
			index++;
		}*/


	public void display() {
		CurrentNode = FirstNode;
		while (CurrentNode.getNext() != null) {
			CurrentNode.student.Display();
			CurrentNode = CurrentNode.next;
		}
		CurrentNode.student.Display();

	}

}
