package BinaryTree;

public class BinaryTreeMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		BinaryTreeNode<Integer> root=new BinaryTreeNode<Integer>(10);
//		BinaryTreeNode<Integer> leftnode=new BinaryTreeNode<Integer>(5);
//		BinaryTreeNode<Integer> rightnode=new BinaryTreeNode<Integer>(15);
//		
//		root.left=leftnode;
//		root.right=rightnode;
//		
//		BinaryTreeNode<Integer> lln=new BinaryTreeNode<Integer>(2);
//		BinaryTreeNode<Integer> lrn=new BinaryTreeNode<Integer>(3);
//		BinaryTreeNode<Integer> rln=new BinaryTreeNode<Integer>(1);
//		
//		leftnode.left=lln;
//		leftnode.right=lrn;
//		rightnode.left=rln;
		
		BinaryTreeNode<Integer> root=BinaryTree.enterTree(true,0,true);
		BinaryTree.displayTree(root);
		
		//root=BinaryTree.removeleafs(root);
		//System.out.println("After removing leafs of tree");
		//BinaryTree.displayTree(root);
		
		System.out.println("Tree Balanced? -" +BinaryTree.isTreeBalanced(root));
		
		
	}
}
