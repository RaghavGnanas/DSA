package com.theory.linkedList;

/**
 * @author RAGHAVENDRAN
 *
 */
public class DLL {

	private Node head;
	private Node tail;
	private int size;

	public void insertFirst(int value) {
		Node node = new Node(value);

		node.next = head;
		node.prev = null;
		if (head != null) {
			head.prev = node;
		}
		head = node;

	}

	public void display() {
		Node temp = head;

		while (temp != null) {
			System.out.print(temp.value + " -> ");
			temp = temp.next;
		}
		System.out.println("End");
	}

	private class Node {
		int value;
		Node next;
		Node prev;

		public Node(int value) {
			super();
			this.value = value;
		}

		public Node(int value, Node next, Node prev) {
			super();
			this.value = value;
			this.next = next;
			this.prev = prev;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DLL dll = new DLL();
		dll.insertFirst(0);
		dll.insertFirst(1);
		dll.insertFirst(2);
		dll.display();

	}

}
