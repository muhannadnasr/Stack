package eg.edu.alexu.csd.datastructure.stack;

import eg.edu.alexu.csd.datastructure.stack.IStack;

public class Stack implements IStack{
	
	Singly stack = new Singly ();
	
	int size = 0 ;
	
	
	/**
	* this method puts an element at a certain position in a singly linkedlist.
	* @param index that we choose to put the element in (zero-based)
	* @param element object to be put in the position chosen
	*/


	public void add(int index, Object element) {
	     if (index >size && index <0){
			throw new RuntimeException();
		}else {
			stack.add(size-index,element);
		}
	     size++;		
	}
	
	/**
	* this method return the last element of the list after removing it
	* @return peek of the stack and if the stack is empty it throws an exception
	*/

	
	public Object pop() {
		if (size >0){
			Object find = stack.head.value;
			stack.remove(0);
			size --;
			return find ;

		}else{
			throw new RuntimeException();
		}
	}
	
	
	/**
	* this method return the last element of the list but the difference that it doesn't remove it
	* @return peek of the stack and if the stack is empty it throws an exception
	*/
	
	public Object peek() {
		if (size >0){
		Object find = stack.head.value;
		return find;
		}else{
			throw new RuntimeException();
		}
	}
	
	/**
	* it places the given element in the top of the stack
	* @param element object to place in the top
	*/

	public void push(Object element) {
		stack.add(0,element);
		size++;
	}
	

	/**
	* this method checks whether the stack is empty of not
	* @return false if the stack isn't empty and true if it's empty
	*/
	
	
	public boolean isEmpty() {
		if (stack.head==null ){
			return true ;
		}
		return false;
	}
	
	/**
	* this method helps to know the number of elements that exist in the stack
	* @return the number of elements
	*/
	public int size() {
		if (stack.head==null){
			return 0;
		}
		return size;
	}

	
}