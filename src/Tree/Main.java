package Tree;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode<Integer> root=new TreeNode<>(1);
		
		TreeNode<Integer> node1=new TreeNode<>(2);
		TreeNode<Integer> node2=new TreeNode<>(3);
		TreeNode<Integer> node3=new TreeNode<>(4);
		TreeNode<Integer> node4=new TreeNode<>(5);
		TreeNode<Integer> node5=new TreeNode<>(6);
		TreeNode<Integer> node6=new TreeNode<>(7);
		
		root.children.add(node1);
		root.children.add(node2);
		root.children.add(node3);
		
		node2.children.add(node4);
		node2.children.add(node5);
		node2.children.add(node6);
		
		//TreeMethods.displayTree(root);
		TreeMethods.displayTreeBV(root);
		System.out.println("Number of Nodes in Tree: "+TreeMethods.numberOfNodes(root));
		
	}

}
