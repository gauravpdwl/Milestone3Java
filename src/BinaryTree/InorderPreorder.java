package BinaryTree;

public class InorderPreorder {
	
	public static BinaryTreeNode<Integer> buildTree(int[] preOrder, int[] inOrder) {
		
		//preOrder => root, left, right
		//inOrder => left, root, right
		//Your code goes here
		BinaryTreeNode<Integer> root=tree(preOrder, inOrder, 0, preOrder.length-1, 0, inOrder.length-1);
		return root;
	}
	
	public static BinaryTreeNode<Integer> tree(int[] preOrder, int[] inOrder, int ps, int pe, int is, int ie){
		if(pe<ps) {
			return null;
		}
		
		BinaryTreeNode<Integer> root=new BinaryTreeNode<Integer>(preOrder[ps]);
		
		int index=-1;
		for(int i=is; i<=ie;i++) {
			if(inOrder[i]==preOrder[ps]) {
				index=i;
			}
		}
		
		
		int lps=ps+1;
		//int lpe;
		int lis=is;
		int lie=index-1;
		//int rps;
		int rpe=pe;
		int ris=index+1;
		int rie=ie;
		int lpe=lps+(lie-lis);
		int rps=lpe+1;
		
		BinaryTreeNode<Integer> leftnode=tree(preOrder, inOrder, lps, lpe, lis, lie);
		BinaryTreeNode<Integer> rightnode=tree(preOrder, inOrder, rps, rpe, ris, rie);
		
		root.left=leftnode;
		root.right=rightnode;
		
		return root;
	}
}
