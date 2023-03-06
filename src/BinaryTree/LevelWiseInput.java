package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class LevelWiseInput {
	//BinaryTreeNode.java
	
	public static BinaryTreeNode<Integer> takeInputLevelWise(){
		
		Queue<BinaryTreeNode<Integer>> treeQueue=new LinkedList<BinaryTreeNode<Integer>>();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter root");
		int rootdata=sc.nextInt();
		BinaryTreeNode<Integer> root=new BinaryTreeNode<Integer>(rootdata);
		
		if(rootdata!=-1) {
			treeQueue.add(root);
		}
		
		while(treeQueue.isEmpty()==false) {
			BinaryTreeNode<Integer> rootele=treeQueue.poll();
			System.out.println("Enter left for -"+rootele.data);
			int leftdata=sc.nextInt();
			if(leftdata!=-1) {
				BinaryTreeNode<Integer> leftdatanode=new BinaryTreeNode<Integer>(leftdata);
				treeQueue.add(leftdatanode);
				rootele.left=leftdatanode;
			}
			System.out.println("Enter right for -"+rootele.data);
			int rightdata=sc.nextInt();
			if(rightdata!=-1) {
				BinaryTreeNode<Integer> rightdatanode=new BinaryTreeNode<Integer>(rightdata);
				treeQueue.add(rightdatanode);
				rootele.right=rightdatanode;
			}
		}
		
		return root;
	}
	
	public static void displayTreeLevelWise(BinaryTreeNode<Integer> root) {
		
		if(root==null) {
			return;
		}
			
		Queue<BinaryTreeNode<Integer>> treeQueue=new LinkedList<BinaryTreeNode<Integer>>();
		treeQueue.add(root);
		
		while(treeQueue.isEmpty()==false) {
			BinaryTreeNode<Integer> rootele=treeQueue.poll();
			System.out.print(rootele.data+":");
			
			if(rootele.left!=null) {
				System.out.print("L"+rootele.left.data);
			}else {
				System.out.print("L"+-1);
			}
			if(rootele.right!=null) {
				System.out.print(",R"+rootele.right.data);
			}else {
				System.out.print(",R"+-1);
			}
			System.out.println();
			
			if(rootele.left!=null) {
				treeQueue.add(rootele.left);
			}
			if(rootele.right!=null) {
				treeQueue.add(rootele.right);
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Level Wise Input
		BinaryTreeNode<Integer> root=LevelWiseInput.takeInputLevelWise();
		//Level Wise Output
		LevelWiseInput.displayTreeLevelWise(root);
		
	}
	
}
