package others;

/**
 * 基于链表实现的队列
 * @author liuzhuang
 *
 */
public class QueueBasedOnLinkedList {
	private static class Node {
		private String data;
		private Node next;

		public Node(String data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	private Node head, tail = null;

	public void enqueue(String value) {
		if (tail == null) {
			Node newNode = new Node(value, null);
			head = newNode;
			tail = newNode;
		} else {
			tail.next = new Node(value, null);
			tail = tail.next;
		}
	}

	public String dequeue() {
		if (head == null) {
			return null;
		}
		String ret = head.data;
		head = head.next;
		if (head == null) {
			tail = null;
		}
		return ret;
	}

	public static void main(String[] args) {
		QueueBasedOnLinkedList qLinkList = new QueueBasedOnLinkedList();
		qLinkList.enqueue("hello");
		qLinkList.dequeue();
	}
}
