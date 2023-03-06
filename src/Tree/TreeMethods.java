package Tree;

public class TreeMethods {
	
	public static void displayTree(TreeNode<Integer> root) {
		
		//not base condition as it is only for root of the tree
		//rest will auto return from method
		if(root==null) {
			return;
		}
		
		System.out.println(root.data);
		for(int i=0;i<root.children.size();i++) {
			displayTree(root.children.get(i));
		}
	}
	
	public static void displayTreeBV(TreeNode<Integer> root) {
		
		//not base condition as it is only for root of the tree
		//rest will auto return from method
		if(root==null) {
			return;
		}
		
		System.out.print(root.data+" :");
		
		for(int i=0;i<root.children.size();i++) {
			System.out.print(" "+root.children.get(i).data);
		}
		
		System.out.println();
		
		for(int i=0;i<root.children.size();i++) {
			displayTreeBV(root.children.get(i));
		}
	}
	
	public static int numberOfNodes(TreeNode<Integer> root) {
		
		int count=1;
		for(int i=0;i<root.children.size();i++) {
			int rootcount=numberOfNodes(root.children.get(i));
			count=count+rootcount;
		}
		return count;
	}
	
}
