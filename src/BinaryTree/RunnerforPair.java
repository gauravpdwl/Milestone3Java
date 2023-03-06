package BinaryTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


 class QueueUsingLL<T> {

	class Node<T> {
		T data;
		Node<T> next;
		Node(T data){
			this.data = data;
		}
	}
	
	private Node<T> head;
	private Node<T> tail;
	private int size = 0;

	public int size(){
		return size;
	}

	public boolean isEmpty(){
		if(size == 0){
			return true;
		}
		return false;
	}

	public T front() throws QueueEmptyException{
		if(size == 0){
			QueueEmptyException e = new QueueEmptyException();
			throw e;
		}

		return head.data;
	}


	public void enqueue(T element){
		Node<T> newNode = new Node<T>(element);

		if(head == null){
			head = newNode;
			tail = newNode;
		}
		else{
			tail.next = newNode;
			tail = newNode;
		}

		size++;
	}

	public T dequeue() throws QueueEmptyException{
		if(head == null){
			QueueEmptyException e = new QueueEmptyException();
			throw e;
		}
		if(head == tail){
			tail = null;
		}
		T temp = head.data;
		head = head.next;
		size--;
		return temp;
	}
}

//
//class BinaryTreeNode<T> {
//	T data;
//	BinaryTreeNode<T> left;
//	BinaryTreeNode<T> right;
//
//	public BinaryTreeNode(T data) {
//		this.data = data;
//		this.left = null;
//		this.right = null;
//	}
//}
//
//class Pair<T, U> {
//	T minimum;
//	U maximum;
//
//	public Pair(T minimum, U maximum) {
//		this.minimum = minimum;
//		this.maximum = maximum;
//	}
//
//}

public class RunnerforPair {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static BinaryTreeNode<Integer> takeInput() throws NumberFormatException, IOException {
		QueueUsingLL<BinaryTreeNode<Integer>>  pendingNodes = new QueueUsingLL<BinaryTreeNode<Integer>>(); 
		int start = 0;

		String[] nodeDatas = br.readLine().trim().split(" ");

		if (nodeDatas.length == 1) {
			return null;
		}

		int rootData = Integer.parseInt(nodeDatas[start]);
		start += 1;

		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		pendingNodes.enqueue(root);

		while(!pendingNodes.isEmpty()){
			BinaryTreeNode<Integer> currentNode;
			try {
				currentNode = pendingNodes.dequeue();
			} catch (QueueEmptyException e) {
				return null;
			}

			int leftChildData = Integer.parseInt(nodeDatas[start]);
			start += 1;

			if(leftChildData != -1){
				BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<Integer>(leftChildData);
				currentNode.left = leftChild;
				pendingNodes.enqueue(leftChild);
			}

			int rightChildData = Integer.parseInt(nodeDatas[start]);
			start += 1;

			if(rightChildData != -1){
				BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<Integer>(rightChildData);
				currentNode.right = rightChild;
				pendingNodes.enqueue(rightChild);
			}
		}

		return root;
	}


	private static void printLevelWise(BinaryTreeNode<Integer> root){
		QueueUsingLL<BinaryTreeNode<Integer>>  primary = new QueueUsingLL<>();
		QueueUsingLL<BinaryTreeNode<Integer>>  secondary = new QueueUsingLL<>();

		primary.enqueue(root);

		while(!primary.isEmpty()){
			BinaryTreeNode<Integer> current=null;
			try {
				current = primary.dequeue();
			} catch (QueueEmptyException e) {
				System.out.println("Not possible");
			}
			System.out.print(current.data + " ");
			if(current.left != null){
				secondary.enqueue(current.left);
			}
			if(current.right != null){
				secondary.enqueue(current.right);
			}
			if(primary.isEmpty()){
				QueueUsingLL<BinaryTreeNode<Integer>>  temp = secondary;
				secondary = primary;
				primary = temp;
				System.out.println();
			}
		}
	}
	
	public static Pair<Integer, Integer> getMinAndMax(BinaryTreeNode<Integer> root) {
		// Your code goes here
		if (root == null) {
			return new Pair<>(Integer.MAX_VALUE, Integer.MIN_VALUE);
		}


		Pair<Integer, Integer> p1 = getMinAndMax(root.left);
		Pair<Integer, Integer> p2 = getMinAndMax(root.right);

		if (p1.minimum > p2.minimum) {
			p1.minimum = p2.minimum;
		}
		if (p1.maximum < p2.maximum) {
			p1.maximum = p2.maximum;
		}
		if (p1.minimum > root.data) {
			p1.minimum = root.data;
		}
		if (p1.maximum < root.data) {
			p1.maximum = root.data;
		}
		
		return p1;
	}

	public static Pair<Integer, Integer> getLeftMinMax(BinaryTreeNode<Integer> root) {

		if (root == null) {
			return new Pair<>(Integer.MAX_VALUE, Integer.MIN_VALUE);
		}

		Pair<Integer, Integer> p = getLeftMinMax(root.left);

		if (p.minimum > root.data) {
			p.minimum = root.data;
		}
		if (p.maximum < root.data) {
			p.maximum = root.data;
		}
		System.out.println("Left P-" + p.minimum + " " + p.maximum);
		return p;
	}

	public static Pair<Integer, Integer> getRightMinMax(BinaryTreeNode<Integer> root) {

		if (root == null) {
			return new Pair<>(Integer.MAX_VALUE, Integer.MIN_VALUE);
		}

		Pair<Integer, Integer> p = getRightMinMax(root.right);

		
		if (p.minimum > root.data) {
			p.minimum = root.data;
		}
		if (p.maximum < root.data) {
			p.maximum = root.data;
		}

		System.out.println("Right P-" + p.minimum + " " + p.maximum);
		return p;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BinaryTreeNode<Integer> root = takeInput();
		printLevelWise(root);
		Pair<Integer, Integer> pair = getMinAndMax(root);
		System.out.println(pair.minimum + " " + pair.maximum);
		
	}
}