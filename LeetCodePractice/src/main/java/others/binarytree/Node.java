package others.binarytree;

public class Node {
	private int value;// node value
	private Node node;// the node,type Node
	private Node left;// the node's left node,type Node
	private Node right;// the node's right node,type Node

	public Node(int value) {
		this.value = value;
		this.left = null;
		this.right = null;
	}

	/**
	 * define method toString,for output
	 */
	public String toString() {
		return this.value + "";
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Node getNode() {
		return node;
	}

	public void setNode(Node node) {
		this.node = node;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

}
