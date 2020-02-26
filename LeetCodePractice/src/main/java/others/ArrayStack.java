package others;

import com.alibaba.fastjson.JSON;

/**
 * 顺序栈
 * @author liuzhuang
 *
 */
public class ArrayStack {

	private String[] items;
	private int count;// 栈中数据大小
	private int n;// 栈大小

	// 初始化栈
	public ArrayStack(int n) {
		this.items = new String[n];
		this.n = n;
		this.count = 0;
	}

	// 入栈
	public boolean push(String item) {
		// 如果空间不足，返回false;
		if (count == n) {
			return false;
		}
		// item加到count位置，并且count自增
		items[count] = item;
		++count;
		return true;
	}

	// 出栈
	public String pop() {
		if (count == 0) {
			return null;
		}
		String s = items[count - 1];
		--count;
		return s;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayStack as = new ArrayStack(10);
		as.push("hello");
		as.push("world");
		System.out.println(JSON.toJSONString(as.items));
		System.out.println(JSON.toJSONString(as.count));
		System.out.println(as.pop());
		System.out.println(JSON.toJSONString(as.count));
		System.out.println(as.pop());
		System.out.println(JSON.toJSONString(as.count));
	}

}
