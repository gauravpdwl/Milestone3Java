package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class printLevelWise {
	
	public static void printDataLevelWise(BinaryTreeNode<Integer> root) {
		//Your code goes here
		if(root==null) {
			return;
		}
		
		Queue<BinaryTreeNode<Integer>> first=new LinkedList<BinaryTreeNode<Integer>>();
		Queue<BinaryTreeNode<Integer>> second=new LinkedList<BinaryTreeNode<Integer>>();
		first.add(root);
		
		while(!first.isEmpty()) {
			while(!first.isEmpty()) {
				BinaryTreeNode<Integer> node=first.poll();
				System.out.print(node.data+" ");
				if(node.left!=null) {
					second.add(node.left);
				}
				if(node.right!=null) {
					second.add(node.right);
				}
			}
			
			System.out.println();
			
			while(!second.isEmpty()) {
				BinaryTreeNode<Integer> node=second.poll();
				first.add(node);
			}
		}
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
		
		printDataLevelWise(root);
		
	}
}
