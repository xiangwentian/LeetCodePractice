package others.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * 1、数组元素变Node类型节点 2、给N/2-1个节点设置子节点 3、给最后一个节点设置子节点【有可能只有左节点】
 * 
 * 参考：https://blog.csdn.net/weixin_42636552/article/details/82973190
 */
public class Array2BTree {

	/**
	 * arry to b-tree
	 * 
	 * @param datas
	 * @param list
	 */
	public static void create(int[] datas, List<Node> list) {

		// array to node
		for (int i = 0; i < datas.length; i++) {
			Node node = new Node(datas[i]);
			list.add(node);
		}

		// Nodes are associated as trees
		for (int index = 0; index < list.size() / 2 - 1; index++) {
			list.get(index).setLeft(list.get(index * 2 + 1));
			// 编号为n的节点他的左子节点编号为2*n 右子节点编号为2*n+1 但是因为list从0开始编号，所以还要+1
			list.get(index).setRight(list.get(index * 2 + 2));
			// With the same
		}

		// 单独处理最后一个父节点 ,list.size()/2-1进行设置，避免单孩子情况
		int index = list.size() / 2 - 1;
		list.get(index).setLeft(list.get(index * 2 + 1));
		if (list.size() % 2 == 1) { // 如果有奇数个节点，最后一个父节点才有右子节点
			list.get(index).setRight(list.get(index * 2 + 2));
		}

	}

	public static void main(String[] args) {
		int[] datas = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		List<Node> list = new ArrayList<Node>();
		create(datas, list);
	}
}
