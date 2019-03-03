public class Bst{

	private class Node{
		int value;
		Node left;
		Node right;
	}
	public boolean isBST(Node n){
		if (n == null){
			return true;
		}
		return isBST(n, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean isBST(Node n, int min, int max){
		if (n == null){
			return true;
		}

		if (!(n.value > min && n.value <= max)){
			return false;
		}

		return isBST(n.right,n.value,max) && isBST(n.left,min,n.value);
	
	}


}