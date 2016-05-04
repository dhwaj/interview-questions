package algo;

public class Tree<T> {
	public T data;
	public Tree<T> parent;
	public Tree<T> left;
	public Tree<T> right;

	public Tree(T val){
		this.data = val;
		this.parent = null;
		this.left = null;
		this.right = null;
	}

	public Tree<T> setLeft(Tree<T> n){
		n.parent = this;
		this.left = n;
		return this;
	}
	
	public Tree<T> setRight(Tree<T> n){
		n.parent = this;
		this.left = n;
		return this;
	}
	
	public Tree<T> setLeft(T val){
		Tree<T> newTree = new Tree<T>(val);
		newTree.parent = this;
		this.left = newTree;
		return this;
	}
	
	public Tree<T> setRight(T val){
		Tree<T> newTree = new Tree<T>(val);
		newTree.parent = this;
		this.right = newTree;
		return this;
	}
	
	public void inorder(){
		if(this==null)return;
		if(this.left != null)this.left.inorder();
		System.out.println(this.data);
		if(this.right != null)this.right.inorder();
	}

}
