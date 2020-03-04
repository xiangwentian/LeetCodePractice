package others.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.alibaba.fastjson.JSON;

/**
 * 前序遍历 （1）访问根节点； （2）采用先序递归遍历左子树； （3）采用先序递归遍历右子树；
 * 
 * @author liuzhuang
 *
 */
public class PreorderTraversal {

	//递归实现
	public void preTraversal(Node node) {
		if (node == null) {
			return;
		}
		System.out.print(node.getValue() + " ");
		preTraversal(node.getLeft());
		preTraversal(node.getRight());
	}

	//非递归实现
	public void preOrderTraversalbyLoop(Node node) {
		Stack<Node> stack = new Stack<Node>();
		Node p = node;
		while (p != null || !stack.isEmpty()) {
			while (p != null) {
				// 当p不为空时，就读取p的值，并不断更新p为其左子节点，即不断读取左子节点
				System.out.print(p.getValue() + " ");
				stack.push(p);// 将p入栈
				p = p.getLeft();
			}
			if (!stack.isEmpty()) {
				p = stack.pop();
				p = p.getRight();
			}
		}
	}

	public static void main(String[] args) {
		PreorderTraversal pt = new PreorderTraversal();
		int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		System.out.println(JSON.toJSONString(a));
		List<Node> list = new ArrayList<Node>();
		Array2BTree.create(a, list);

		// System.out.println("list size:" + list.size());
		// System.out.println("list nods:" + JSON.toJSONString(list.get(0)));
		// 使用递归
		// pt.preTraversal(list.get(0));
		// System.out.println();
		// 非递归
		pt.preOrderTraversalbyLoop(list.get(0));
	}
}
