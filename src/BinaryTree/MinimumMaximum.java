package BinaryTree;

public class MinimumMaximum {
/*
	
	Following is the structure used to represent the Binary Tree Node

	class BinaryTreeNode<T> {
		T data;
		BinaryTreeNode<T> left;
		BinaryTreeNode<T> right;

		public BinaryTreeNode(T data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

*/



/*

	Representation of the Pair Class

	class Pair<T, U> {
		T minimum;
		U maximum;

		public Pair(T minimum, U maximum) {
			this.minimum = minimum;
			this.maximum = maximum;
		}

	}

*/

	public static Pair<Integer, Integer> getMinAndMax(BinaryTreeNode<Integer> root) {
		// Your code goes here
		if (root == null) {
			return new Pair<>(Integer.MAX_VALUE, Integer.MIN_VALUE);
		}

		Pair<Integer, Integer> p1 = getMinAndMax(root.left);
		Pair<Integer, Integer> p2 = getMinAndMax(root.right);

		if (p1.minimum > p2.minimum) {
			p1.minimum = p2.minimum;
		}
		if (p1.maximum < p2.maximum) {
			p1.maximum = p2.maximum;
		}
		if (p1.minimum > root.data) {
			p1.minimum = root.data;
		}
		if (p1.maximum < root.data) {
			p1.maximum = root.data;
		}

		return p1;
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BinaryTreeNode<Integer> root=new BinaryTreeNode<Integer>(10);
		BinaryTreeNode<Integer> leftnode=new BinaryTreeNode<Integer>(5);
		BinaryTreeNode<Integer> rightnode=new BinaryTreeNode<Integer>(15);
		
		root.left=leftnode;
		root.right=rightnode;
		
		BinaryTreeNode<Integer> lln=new BinaryTreeNode<Integer>(2);
		BinaryTreeNode<Integer> lrn=new BinaryTreeNode<Integer>(3);
		BinaryTreeNode<Integer> rln=new BinaryTreeNode<Integer>(1);
		
		leftnode.left=lln;
		leftnode.right=lrn;
		rightnode.left=rln;
		
		Pair<Integer, Integer> p=getMinAndMax(root);
		System.out.println("Minimum-"+p.minimum+" Maximum-"+p.maximum);
		
	}
}
