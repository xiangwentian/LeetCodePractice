package others.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.alibaba.fastjson.JSON;

/**
 * 中序遍历 （1）采用中序遍历左子树； （2）访问根节点； （3）采用中序遍历右子树
 * 
 * @author liuzhuang
 *
 */
public class InorderTraversal {

	// 递归实现
	public void MidTraversal(Node node) {
		if (node == null) {
			return;
		}
		MidTraversal(node.getLeft());
		System.out.print(node.getValue() + " ");
		MidTraversal(node.getRight());
	}

	// 非递归实现
	public void inOrderTraversalbyLoop(Node node) {
		Stack<Node> stack = new Stack<Node>();
		Node p = node;
		while (p != null || !stack.isEmpty()) {
			while (p != null) {
				stack.push(p);
				p = p.getLeft();
			}
			if (!stack.isEmpty()) {
				p = stack.pop();
				System.out.print(p.getValue() + " ");
				p = p.getRight();
			}
		}

	}

	public static void main(String[] args) {
		InorderTraversal it = new InorderTraversal();
		int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		System.out.println(JSON.toJSONString(a));
		List<Node> list = new ArrayList<Node>();
		Array2BTree.create(a, list);
		// 递归遍历调用
		// it.MidTraversal(list.get(0));
		// 非递归遍历调用
		it.inOrderTraversalbyLoop(list.get(0));
	}

}
