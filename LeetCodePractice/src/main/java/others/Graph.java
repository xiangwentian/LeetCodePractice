package others;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 无向图
 * 
 * @author liuzhuang
 */
public class Graph {
	private int v;// 顶点个数
	private LinkedList<Integer> adj[];// 邻接表

	public Graph(int v) {
		this.v = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}

	public void addEdeg(int s, int t) {// 无向图一条边存两次
		adj[s].add(t);
		adj[t].add(s);
	}

	public static void main(String[] args) {
		Graph graph = new Graph(8);
		graph.addEdeg(0, 1);
		graph.addEdeg(0, 3);
		graph.addEdeg(1, 2);
		graph.addEdeg(1, 4);
		graph.addEdeg(2, 5);
		graph.addEdeg(3, 4);
		graph.addEdeg(4, 5);
		graph.addEdeg(4, 6);
		graph.addEdeg(5, 7);
		graph.addEdeg(6, 7);

		// graph.bfs(0, 6);
		graph.dfs(0, 6);
	}

	/**
	 * 广度搜索,三个重要的辅助变量:
	 * 
	 * visited:是用来记录已经被访问的顶点，用来避免顶点被重复访问。如果顶点 q 被访问，那相应的 visited[q]会被设置为 true
	 * 
	 * queue:queue 是一个队列，用来存储已经被访问、但相连的顶点还没有被访问的顶点
	 * 
	 * prev:用来记录搜索路径,路径是反向存储的.prev[w]存储的是，顶点 w 是从哪个前驱顶点遍历过来的。比如，我们通过顶点 2
	 * 的邻接表访问到顶点 3，那 prev[3]就等于 2
	 * 
	 * @param s
	 * @param t
	 */
	public void bfs(int s, int t) {
		if (s == t) {
			return;
		}
		boolean[] visited = new boolean[v];
		visited[s] = true;
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(s);
		int[] prev = new int[v];
		for (int i = 0; i < v; i++) {
			prev[i] = -1;
		}
		while (queue.size() != 0) {
			int w = queue.poll();// 检索并删除此队列的头，如果此队列为空，则返回 null
			for (int i = 0; i < adj[w].size(); i++) {
				int q = adj[w].get(i);
				if (!visited[q]) {
					prev[q] = w;
					if (q == t) {
						print(prev, s, t);
						return;
					}
					visited[q] = true;
					queue.add(q);
				}
			}
		}
	}

	private void print(int[] prev, int s, int t) {
		if (prev[t] != -1 && t != s) {
			print(prev, s, prev[t]);
		}
		System.out.print(t + " ");
	}

	// 深度优先算法
	boolean found = false;// 找到终止顶点时，停止递归

	public void dfs(int s, int t) {
		found = false;
		boolean[] visited = new boolean[v];
		int[] prev = new int[v];
		for (int i = 0; i < v; i++) {
			prev[i] = -1;
		}
		recurDfs(s, t, visited, prev);
		print(prev, s, t);
	}

	public void recurDfs(int w, int t, boolean[] visited, int[] prev) {
		if (found == true)
			return;
		visited[w] = true;
		if (w == t) {
			found = true;
			return;
		}
		for (int i = 0; i < adj[w].size(); i++) {
			int q = adj[w].get(i);
			if (!visited[q]) {
				prev[q] = w;
				recurDfs(q, t, visited, prev);
			}
		}
	}

}
