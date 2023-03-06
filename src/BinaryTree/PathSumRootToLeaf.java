package BinaryTree;

public class PathSumRootToLeaf {
	
	public static void rootToLeafPathsSumToK(BinaryTreeNode<Integer> root, int k) {
		//Your code goes here
		
		int arr[]=new int[k];
		int ap=0;
		RTLsum(root, k, arr, ap);

	}

	public static void RTLsum(BinaryTreeNode<Integer> root, int k, int arr[], int ap){
		if(root==null){
			return;
		}

		int newk=k-root.data;
		arr[ap]=root.data;
		ap=ap+1;

		if(newk==0){
			if(root.left==null && root.right==null){
				for(int i=0;i<ap;i++){
					System.out.print(arr[i]+" ");
				}
				System.out.println();
			}
		}

		RTLsum(root.left, newk, arr, ap);
		RTLsum(root.right, newk, arr, ap);
	}


}
