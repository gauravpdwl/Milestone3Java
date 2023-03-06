package BinaryTree;

public class PrintNodesatDistanceKFromNode {
		
	public static void findNodeLocation(BinaryTreeNode<Integer> root, int node, int k) {
	    //Your code goes here
		String nodeLocation = null;
		KDistanceNodeProblemReturnObj robj=null;
		KDistanceNodeProblemReturnObj leftob=findNode(root.left, node,1);
		KDistanceNodeProblemReturnObj rightob=findNode(root.right, node,1);
		
		if(root.data==node) {
			robj=new KDistanceNodeProblemReturnObj();
			nodeLocation="center";
			robj.node=root;
			robj.dfr=0;
			
		}else if(leftob.node!=null) {
			nodeLocation="left";
			robj=leftob;
		}else if(rightob.node!=null){
			nodeLocation="right";
			robj=rightob;
		}else {
			System.out.println(node+" - Node is not present in given Tree");
			return;
		}
		
		if(robj!=null ) {
			System.out.println("Node returned - "+robj.node.data);
			System.out.println("Distance from Root - "+robj.dfr);
			System.out.println("Location - "+nodeLocation);
		}
		
		//nodes below given node at distance K
		displayKDistanceNodes(robj.node, node, k);
		
		//if distance from root is same as K
		if(robj.dfr==k) {
			System.out.println(root.data);
		}
		
		//nodes upwards till root 
		if(nodeLocation=="left") {
			displayFromRoot(root.left, node, robj.dfr-1,k);
			System.out.println("k-robj.dfr -> "+(k-robj.dfr));
			if((k-robj.dfr-1)>=0) {
				displayKDistanceNodes(root.right, node,k-robj.dfr-1);
			}
		}
		
		if(nodeLocation=="right") {
			displayFromRoot(root.right, node, robj.dfr-1,k);
			if((k-robj.dfr-1)>=0){
				displayKDistanceNodes(root.left, node, k-robj.dfr-1);
			}
		}
		
	}
	
	//print nodes v1
	public static void displayKDistanceNodes(BinaryTreeNode<Integer> root, int node, int distanceFromRoot) {
		if(root==null) {
			return;
		}
		
		if(distanceFromRoot==0) {
			System.out.println(root.data);
		}
		
		displayKDistanceNodes(root.left, node, distanceFromRoot-1);
		displayKDistanceNodes(root.right, node, distanceFromRoot-1);
		
	}
	
	//print nodes v2
	public static void displayFromRoot(BinaryTreeNode<Integer> root, int node, int distanceFromRoot, int k) {
		if(root==null || k<0) {
			return;
		}
		
//		if(root.data==node) {
//			return;
//		}
		
		if(root.data!=node && distanceFromRoot==0 && k%2==0) {
			System.out.println(root.data);
		}
		
		if(distanceFromRoot == k || distanceFromRoot==-k ) {
			System.out.println(root.data);
		}
		
		displayFromRoot(root.left, node, distanceFromRoot-1, k);
		displayFromRoot(root.right, node, distanceFromRoot-1, k);
	}
	
	//find node from root
	public static KDistanceNodeProblemReturnObj findNode(BinaryTreeNode<Integer> root, int findingno, int level) {
		
		if(root==null) {
			KDistanceNodeProblemReturnObj obj=new KDistanceNodeProblemReturnObj();
			obj.node=root;
			obj.dfr=level;
			return obj;
		}
		
		if(root.data==findingno) {
			KDistanceNodeProblemReturnObj obj=new KDistanceNodeProblemReturnObj();
			obj.node=root;
			obj.dfr=level;
			return obj;
		}
		
		KDistanceNodeProblemReturnObj leftcheck=findNode(root.left, findingno, level+1);
		KDistanceNodeProblemReturnObj rightcheck=findNode(root.right, findingno, level+1);
		
		if(leftcheck.node!=null) {
			return leftcheck;
		}
		else {
			return rightcheck;
		}
		
	}
	
	public static void main(String args[]) {
		BinaryTreeNode<Integer> root=new BinaryTreeNode<Integer>(5);
		BinaryTreeNode<Integer> leftnode=new BinaryTreeNode<Integer>(6);
		BinaryTreeNode<Integer> rightnode=new BinaryTreeNode<Integer>(10);
		
		root.left=leftnode;
		root.right=rightnode;
		
		BinaryTreeNode<Integer> lln=new BinaryTreeNode<Integer>(2);
		BinaryTreeNode<Integer> lrn=new BinaryTreeNode<Integer>(3);
		//BinaryTreeNode<Integer> rln=new BinaryTreeNode<Integer>(1);
		
		leftnode.left=lln;
		leftnode.right=lrn;
		//rightnode.right=rln;
		
		//BinaryTreeNode<Integer> l2ln=new BinaryTreeNode<Integer>(100);
		BinaryTreeNode<Integer> l2rn=new BinaryTreeNode<Integer>(9);
		
		//lln.left=l2ln;
		lrn.right=l2rn;
		
		BinaryTree.displayTree(root);
		findNodeLocation(root,3,2);
	}

}
