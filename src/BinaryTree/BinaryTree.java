package BinaryTree;

import java.util.Scanner;

public class BinaryTree {
	static Scanner sc=new Scanner(System.in);
	public static BinaryTreeNode<Integer> enterTree(boolean isRoot, int parentData, boolean isLeft){
		if(isRoot) {
			System.out.println("Enter Root-");
		}else {
			if(isLeft) {
				System.out.println("Enter Left of Parent-"+parentData);
			}else {
				System.out.println("Enter Right of Parent-"+parentData);
			}
		}
		
		int data=sc.nextInt();
		
		if(data==-1) {
			return null;
		}
		
		BinaryTreeNode<Integer> root=new BinaryTreeNode<Integer>(data);
		BinaryTreeNode<Integer> leftnode=enterTree(false,data,true);
		BinaryTreeNode<Integer> rightnode=enterTree(false, data, false);
		root.left=leftnode;
		root.right=rightnode;
		
		return root;
	}
	
	public static void displayTree(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return;
		}
		
		System.out.print(root.data+":");
		if(root.left!=null) {
			System.out.print("L"+root.left.data);
		}
		if(root.right!=null) {
			System.out.print("R"+root.right.data);
		}
		System.out.println();
		
		displayTree(root.left);
		displayTree(root.right);
	}
	
	public static BinaryTreeNode<Integer> removeleafs(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return root;
		}
		
		if(root.left==null && root.right==null) {
			return null;
		}
		
		BinaryTreeNode<Integer> leftnode=removeleafs(root.left);
		BinaryTreeNode<Integer> rightnode=removeleafs(root.right);
		
		root.left=leftnode;
		root.right=rightnode;
		return root;
		
	}
	
	public static int treeHeight(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return 0;
		}
		
		int leftheight=treeHeight(root.left);
		int rightheight=treeHeight(root.right);
		
		return 1+Math.max(leftheight, rightheight);
	}
	
	public static boolean isTreeBalanced(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return true;
		}
		
		int leftheight=treeHeight(root.left);
		int rightheight=treeHeight(root.right);
		
		if(Math.abs(leftheight-rightheight)>1) {
			return false;
		}
		
		boolean leftnode=isTreeBalanced(root.left);
		boolean rightnode=isTreeBalanced(root.right);
		
		return leftnode&&rightnode;
	}
}


























