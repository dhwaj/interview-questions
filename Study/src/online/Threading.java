package online;

import algo.Tree;

public class Threading {
	public static Tree<Integer> insert(Tree<Integer> root, Integer val){
		if(root == null) return new Tree<Integer>(val);
		if(val < root.data){
			if(root.left == null){
				root.setLeft(val);
				return root;
			}
			return insert(root.left,val);
		}else{
			if(root.right == null){
				root.setRight(val);
				return root;
			}
			return insert(root.right,val);
		}
	}

	public static void main(String[] args) {

		
		Tree<Integer> root1 = new Tree<Integer>(9);
		insert(root1,10);
		insert(root1,8);
		insert(root1,6);
		insert(root1,7);
		insert(root1,5);
		insert(root1,3);
		insert(root1,1);
		insert(root1,2);
		insert(root1,4);
		Tree<Integer> root2 = new Tree<Integer>(9);
		insert(root2,7);
		insert(root2,3);
		insert(root2,10);
		insert(root2,8);
		insert(root2,6);
		insert(root2,4);
		insert(root2,5);
		insert(root2,2);
		insert(root2,1);
		CubbyHole c = new CubbyHole();
		Producer p1 = new Producer(c, 1, root1);
		Consumer c1 = new Consumer(c, 1, root2);
		p1.start(); 
		c1.start();
	}
}
class CubbyHole {
	private int contents;
	private boolean available = false;
	public synchronized int get() {
		while (available == false) {
			try {
				wait();
			}
			catch (InterruptedException e) {
			}
		}
		available = false;
		notifyAll();
		return contents;
	}
	public synchronized void put(int value) {
		while (available == true) {
			try {
				wait();
			}
			catch (InterruptedException e) { 
			} 
		}
		contents = value;
		available = true;
		notifyAll();
	}
}

class Consumer extends Thread {
	private CubbyHole cubbyhole;
	private int number;
	private Tree<Integer> r;
	public Consumer(CubbyHole c, int number, Tree<Integer> r) {
		cubbyhole = c;
		this.number = number;
		this.r = r;
	}
	public void inorder(Tree<Integer> r){
		if(r==null)return;
		if(r.left != null)inorder(r.left);
		int value = cubbyhole.get();
		if(value!=r.data){
			System.out.println("Expected " + r.data + " to be " + value);
		}else{
			System.out.println("Matched " + value);
		}
		if(r.right != null)inorder(r.right);
	}

	public void run() {
		inorder(r);
	}
}

class Producer extends Thread {
	private CubbyHole cubbyhole;
	private int number;

	private Tree<Integer> r;
	public Producer(CubbyHole c, int number, Tree<Integer> r) {
		cubbyhole = c;
		this.number = number;
		this.r = r;
	}

	public void inorder(Tree<Integer> r){
		if(r==null)return;
		if(r.left != null)inorder(r.left);
		cubbyhole.put(r.data);
		System.out.println("Producer #" + this.number
				+ " put: " + r.data);
		if(r.right != null)inorder(r.right);
	}
	
	public void run() {
		inorder(r);
	}
}