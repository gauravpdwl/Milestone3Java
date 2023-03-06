package BinaryTree;

public class InorderPostorder {
	
	public static BinaryTreeNode<Integer> buildTree(int[] postOrder, int[] inOrder) {
		
		//postOrder => left, right, root
		//inOrder => left, root, right
		//Your code goes here
		BinaryTreeNode<Integer> root=tree(postOrder, inOrder, 0, postOrder.length-1, 0, inOrder.length-1);
		return root;
	}
	
	public static BinaryTreeNode<Integer> tree(int[] postOrder, int[] inOrder, int ps, int pe, int is, int ie){
		if(pe<ps) {
			return null;
		}
		
		BinaryTreeNode<Integer> root=new BinaryTreeNode<Integer>(postOrder[pe]);
		
		int index=-1;
		for(int i=is; i<=ie;i++) {
			if(inOrder[i]==postOrder[pe]) {
				index=i;
			}
		}
		
		
		int lps=ps;
		//int lpe;
		int lis=is;
		int lie=index-1;
		//int rps;
		int rpe=pe-1;
		int ris=index+1;
		int rie=ie;
		int lpe=lps+(lie-lis);
		int rps=lpe+1;
		
		BinaryTreeNode<Integer> leftnode=tree(postOrder, inOrder, lps, lpe, lis, lie);
		BinaryTreeNode<Integer> rightnode=tree(postOrder, inOrder, rps, rpe, ris, rie);
		
		root.left=leftnode;
		root.right=rightnode;
		
		return root;
	}
}
