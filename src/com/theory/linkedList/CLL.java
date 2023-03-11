package com.theory.linkedList;

/**
 * @author RAGHAVENDRAN
 *
 */
public class CLL {

	private Node head;
	private Node tail;

	public CLL() {
		super();
	}

	public CLL(Node head, Node tail) {
		super();
		this.head = null;
		this.tail = null;
	}

	private class Node {
		private int value;
		private Node next;

		public Node(int value) {
			super();
			this.value = value;
		}
	}

//	public void display() {
//		Node temp = head;
//
//		if (temp.next != null) {
//			while (temp.next != head) {
//				System.out.print(temp.value + " -> ");
//				temp = temp.next;
//			}
//		}
//		System.out.println(temp.value);
//		System.out.println("HEAD");
//	}

	public void display() {
		Node temp = head;

		if (head != null) {
			do {
				System.out.print(temp.value + " -> ");
				temp = temp.next;
			} while (temp != head);
		}
		System.out.print("HEAD");
	}

	public void insertFirst(int value) {
		Node node = new Node(value);
		if (head == null) {
			head = node;
			tail = node;
			return;
		}

		tail.next = node;
		node.next = head;
		tail = node;
	}

	public void delete(int value) {
		Node node = head;
		if (node == null) {
			return;
		}
		if (node.value == value) {
			head = head.next;
			tail.next = head;
			return;
		}

		do {
			Node n = node.next;
			if (n.value == value) {
				node.next = n.next;
				break;
			}
			node = node.next;
		} while (node != head);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CLL list = new CLL();
		list.insertFirst(0);
		list.insertFirst(2);
		list.insertFirst(3);
		list.insertFirst(78);
		list.insertFirst(34);
		list.display();
		list.delete(78);
		list.display();

	}

}
