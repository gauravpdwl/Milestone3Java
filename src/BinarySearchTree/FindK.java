package BinarySearchTree;

public class FindK {
	
	public static boolean searchInBST(BinaryTreeNode<Integer> root, int k) {
		if(root == null){
			return false;
		}

		if(root.data==k){
			return true;
		}

		boolean left=searchInBST(root.left, k);
		boolean right=searchInBST(root.right, k);

		return (left || right);
	}
}
