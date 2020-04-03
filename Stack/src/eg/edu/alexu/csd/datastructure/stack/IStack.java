package eg.edu.alexu.csd.datastructure.stack;

public interface IStack {
	
	public void add(int index, Object element);
	
	public Object pop();
	
	public Object peek();
	
	public void push(Object element);
	
	public boolean isEmpty();
	
	public int size();

}