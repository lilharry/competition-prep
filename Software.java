import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Software{
	
	// find node with highest average of values + its children.
	// don't count the leaves.
	//  1
	//   \ 
	//    2
	//   / \ 
	//  3   4
	// / \
	//10  5
	// retval = 2



	public static Node highestAverageValue(Node root){

		Map<Node,List<Integer>> cache = new HashMap<Node,List<Integer>>();

		computeTotalsIntoMap(root,cache);

		return maxOf(root,cache);

	}


    //returns key w/ maximum avg in map
	//pass root for starting value of comparisons
	public static Node maxOf(Node root, Map<Node,List<Integer>> map){

		Node max = root;
		double maxAvg = map.get(root).get(0)*1.0/ map.get(root).get(1); 

		for (Map.Entry<Node,List<Integer>> n : map.entrySet()){
			if (!(n.getValue().get(1) == 1)){
				double navg = n.getValue().get(0) *1.0 / n.getValue().get(1);
				if ( navg > maxAvg){
					max = n.getKey();
					maxAvg = navg;
				}
			}
		}
		return max;
	}

	public static List<Integer> computeTotalsIntoMap(Node root, Map<Node,List<Integer>> cache){

		List<Integer> retVal = new ArrayList<>();
		
		retVal.add(root.value);
		retVal.add(1);

		for (Node n : root.children){
			List<Integer> n_total = computeTotalsIntoMap(n,cache);
			retVal.set(0,retVal.get(0)+ n_total.get(0));
			retVal.set(1,retVal.get(1)+ n_total.get(1));
		}

		cache.put(root, retVal);

		return retVal;

	}



	public static void main(String[] args){


		//        110
		//     /      \
		//   120       200
		//  / \      /  |  \
		// 150 71  250 110  90

		// should return 200


		// 200's children
		List<Node> node2C = new ArrayList<Node>();
		Node node2C1 = new Node(250);
		Node node2C2 = new Node(110);
		Node node2C3 = new Node(90);

		node2C.add(node2C1);
		node2C.add(node2C2);
		node2C.add(node2C3);

		Node node2 = new Node(200,node2C);

		// 120's children
		List<Node> node1C = new ArrayList<Node>();
		
		Node node1C1 = new Node(150);
		Node node1C2 = new Node(71);
		
		node1C.add(node1C1);
		node1C.add(node1C2);

		Node node1 = new Node(120, node1C);
		
		//110's children
		List<Node> rC = new ArrayList<Node>();
		rC.add(node1);
		rC.add(node2);

		Node root = new Node(110, rC);

		//print value of found node (should be 200)
		System.out.println(Software.highestAverageValue(root).toString());
	}



	public static class Node{
		public int value;
		public List<Node> children;
		public Node(int value){
			this.value = value;
			children = new ArrayList<Node>();
		} 
		public Node(int value, List<Node> children){
			this.value = value;
			this.children = children;
		} 
		public String toString(){
			return String.format("Value is %d.", value);
		}
	}


}