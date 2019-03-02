public class Stack{
	private Node top;
	private Node max;
	
	private class Node{
		private int value;
		private Node next;
		private Node prevMax;
	}


	public Stack() {}

	public void push(int value){
		Node n = new Node();
		n.value = value;

		if (top == null){
			top = n;
		}else{
			n.next = top;
			top = n;
		}

		if (max == null || n.value > max.value){
			n.prevMax = max;
			max = n;
		}
	}

	public int pop(){
		if (top == null){
			throw new NullPointerException("Stack cannot be empty");
		}
		
		if (top.prevMax != null){
			max = top.prevMax;
		}

		int retVal = top.value;

		top = top.next;

		return retVal;

	}

	public int max(){
		return max.value;
	}

	public String toString(){
		String s = "" + top.value;
		Node curr = top;
		while (curr.next != null){
			s += "\n" + curr.next.value;
			curr = curr.next;			
		}
		return s;
	}
	public static void main(String[] args){
		Stack s = new Stack();

		s.push(5);
		s.push(2);
		s.push(1);
		s.push(-10);
		//System.out.println(s.toString());

		s.pop();
		System.out.println(s.toString());
		
	}

}