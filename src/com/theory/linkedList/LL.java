package com.theory.linkedList;

/**
 * @author RAGHAVENDRAN
 *
 */
public class LL {

	private Node head;
	private Node tail;
	private int size;

	// Linked List constructor
	public LL() {
		this.size = 0;
	}

	// Display method to print
	public void display() {
		Node temp = head;

		while (temp != null) {
			System.out.print(temp.value + " -> ");
			temp = temp.next;
		}
		System.out.println("END");
	}

	// method to insert first
	public void insertFirst(int value) {
		Node node = new Node(value);
		node.next = head;
		head = node;

		if (tail == null) {
			tail = head;
		}

		size++;

	}

	public void insertLastWithoutTail(int value) {
		Node node = new Node(value);
		Node temp = head;

		if (temp == null) {
			insertFirst(value);
			return;
		}

		while (temp != null) {
			if (temp.next == null) {
				temp.next = node;

				// declaring tail so that we wont get any errors while using withTail Method
				tail = node;
				size++;
				return;
			}
			temp = temp.next;
		}

	}

	public void insertLastWithTail(int value) {

		if (tail == null) {
			insertFirst(value);
			return;
		}

		Node node = new Node(value);
		tail.next = node;
		tail = node;
		size++;
	}

	public void insert(int value, int index) {
		if (index == 0) {
			insertFirst(value);
			return;
		}

		if (index == size) {
			insertLastWithTail(value);
		}

		Node temp = head; // 4,3,2,1,0,99,9
		for (int i = 1; i < index; i++) {
			temp = temp.next;
		}

		Node node = new Node(value, temp.next);
		temp.next = node;
		size++;
	}

	public int deleteFirst() {

		int value = head.value;
		head = head.next;

		if (head == null) {
			tail = null;
		}
		size--;
		return value;

	}

	// 1,2,3,4,5
	public Node get(int index) {// 4
		Node temp = head;// 1,2,3,4
		for (int i = 0; i < index; i++) {// 0,1,2,3
			temp = temp.next;// 2,3,4,5
		}
		return temp;
	}

	public Node find(int value) {// 4
		Node temp = head;// 1,2,3,4

		while (temp != null) {
			if (temp.value == value) {
				return temp;
			}
			temp = temp.next;
		}
		return temp;

	}

	public int deleteLast() {

		if (size <= 1) {
			return deleteFirst();
		}
		Node secondLast = get(size - 2);
		int val = tail.value;
		tail = secondLast;
		tail.next = null;
		return val;
	}

	public int delete(int index) {

		if (index == 0) {
			return deleteFirst();
		}

		if (index == size) {
			return deleteLast();
		}

		Node prev = get(index - 1);
//		Node node = get(index);
		int value = prev.next.value;
		prev.next = prev.next.next;
		return value;
	}

	// Node class
	private class Node {
		private int value;
		private Node next;

		public Node(int val) {
			super();
			this.value = val;
		}

		public Node(int val, Node next) {
			super();
			this.value = val;
			this.next = next;
		}

	}

	public static void main(String[] args) {

		LL list = new LL();
		list.insertFirst(0);
		list.insertFirst(1);
		list.insertFirst(2);
		list.insertFirst(3);
		list.insertFirst(4);
		list.insertLastWithoutTail(99);
		list.insertLastWithTail(9);
		list.insert(27, 3);
		list.display();
		System.out.println(list.deleteFirst());
		list.display();
		System.out.println(list.deleteLast());
		System.out.println(list.tail.value);
		System.out.println(list.delete(2));
		list.display();
	}

}
