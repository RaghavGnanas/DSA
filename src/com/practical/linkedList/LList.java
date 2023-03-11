package com.practical.linkedList;

/**
 * @author RAGHAVENDRAN
 *
 */
public class LList {

	private Node head;
	private Node tail;
	private int size;

	// Linked List constructor
	public LList() {
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

	// questions
	// https://leetcode.com/problems/remove-duplicates-from-sorted-list/
	public void duplicates() {
		Node temp = head;

		while (temp.next != null) {
			if (temp.value == temp.next.value) {
				temp.next = temp.next.next;
			} else {
				// temp.next=temp.next;
				temp = temp.next;
			}
		}
		tail = temp;
		tail.next = null;
//	        return head;
	}

	// https://leetcode.com/problems/merge-two-sorted-lists/description/
	public LList merge(LList list1, LList list2) {
		Node temp1 = list1.head;
		Node temp2 = list2.head;

		LList ans = new LList();

		while (temp1 != null && temp2 != null) {
			if (temp1.value <= temp2.value) {
				ans.insertLastWithTail(temp1.value);// 1,2,4
				temp1 = temp1.next;// 2,4,null
			} else {
				ans.insertLastWithTail(temp2.value);// 1,3
				temp2 = temp2.next;// 3,4
			}

		}

		// to add the 4 from list2 which is left on the initial iteration
		if (temp1 != null) {
			ans.insertLastWithTail(temp1.value);
			temp1 = temp1.next;
		} else if (temp2 != null) {
			ans.insertLastWithTail(temp2.value);
			temp2 = temp2.next;
		}
		return ans;
	}

	public static void main(String[] args) {

		LList list = new LList();
//		list.insertFirst(3);
//		list.insertFirst(3);
//		list.insertFirst(2);
//		list.insertFirst(1);
//		list.insertFirst(1);
//		list.insertLastWithoutTail(99);
//		list.insertLastWithTail(9);
//		list.insert(27, 3);
//		list.display();
//		System.out.println(list.deleteFirst());
//		list.display();
//		System.out.println(list.deleteLast());
//		System.out.println(list.tail.value);
//		System.out.println(list.delete(2));
//		list.display();
//		list.duplicates();
//		list.display();

		// For merge
		LList first = new LList();
		first.insertFirst(4);
		first.insertFirst(2);
		first.insertFirst(1);

		LList second = new LList();
		second.insertFirst(4);
		second.insertFirst(3);
		second.insertFirst(1);

		LList ans = list.merge(first, second);
		ans.display();
	}

}
