package others.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.alibaba.fastjson.JSON;

/**
 * 后序遍历 （1）采用后序递归遍历左子树； （2）采用后序递归遍历右子树； （3）访问根节点；
 * 
 * @author liuzhuang
 */
public class PostorderTraversal {

	// 递归调用
	public void postTraversal(Node node) {
		if (node == null) {
			return;
		}
		postTraversal(node.getLeft());
		postTraversal(node.getRight());
		System.out.print(node.getValue() + " ");
	}

	// 非递归调用
	public void postOrderTraversalbyLoop(Node node) {
		Stack<Node> stack = new Stack<Node>();
		Node p = node, prev = node;
		while (p != null || !stack.isEmpty()) {
			while (p != null) {
				stack.push(p);
				p = p.getLeft();
			}
			if (!stack.isEmpty()) {
				Node temp = stack.peek().getRight();
				// 只是拿出来栈项这个值，并没有进行删除
				if (temp == null || temp == prev) {
					// 节点没有右子节点或都到达根节点【考虑到最后一种情况】
					p = stack.pop();
					System.out.print(p.getValue() + " ");
					prev = p;
					p = null;
				} else {
					p = temp;
				}
			}
		}
	}

	public static void main(String[] args) {
		PostorderTraversal pt = new PostorderTraversal();
		int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		System.out.println(JSON.toJSONString(a));
		List<Node> list = new ArrayList<Node>();
		Array2BTree.create(a, list);

		pt.postTraversal(list.get(0));
		System.out.println();
		pt.postOrderTraversalbyLoop(list.get(0));
	}

}
