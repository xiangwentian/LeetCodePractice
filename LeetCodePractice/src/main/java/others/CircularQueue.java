package others;

/**
 * 循环队列
 * @author liuzhuang
 *
 */
public class CircularQueue {
	private String[] items;
	private int n = 0;
	private int head = 0;
	private int tail = 0;

	public CircularQueue(int capacity) {
		this.n = capacity;
		items = new String[capacity];
	}

	public boolean enqueue(String value) {
		if ((tail + 1) % n == head) {
			return false;
		}
		items[tail] = value;
		tail = (tail + 1) % n;
		return true;
	}

	public String dequeue() {
		if (head == tail) {
			return null;
		}
		String ret = items[head];
		head = (head + 1) % n;
		return ret;
	}

	public static void main(String[] args) {
		CircularQueue cq = new CircularQueue(10);
		cq.enqueue("a");
		cq.enqueue("b");
		cq.dequeue();
		cq.dequeue();
	}
}
