package com.devtalk.algorithm.linkedList;

public class FlattenListTest {
	
	private static MyFNode getList() {
		MyFNode root = new MyFNode(10);
		MyFNode five = new MyFNode(5);
		MyFNode twelve = new MyFNode(12);
		MyFNode seven = new MyFNode(7);
		MyFNode eleven = new MyFNode(11);

		root.next = five;
		five.next = twelve;
		twelve.next = seven;
		seven.next = eleven;

		MyFNode four = new MyFNode(4);
		MyFNode twenty = new MyFNode(20);
		MyFNode thirteen = new MyFNode(13);
		MyFNode seventeen = new MyFNode(17);
		MyFNode nine = new MyFNode(9);
		MyFNode nineteen = new MyFNode(19);

		root.down = four;
		four.next = twenty;
		twenty.down = new MyFNode(2);
		twenty.next = thirteen;
		thirteen.down = new MyFNode(16);
		thirteen.down.down = new MyFNode(3);

		seven.down = seventeen;
		seventeen.next = new MyFNode(6);
		seventeen.down = nine;
		nine.next = new MyFNode(8);
		nine.down = nineteen;
		nineteen.next = new MyFNode(15);
		return root;
	}

	public static void main(String[] args) {
		MyFNode root = getList();

		//MyFNode start = flattenList(root);
		MyFNode start = flattenListByLevel(root);
		while (start != null) {
			System.out.print(start.data + " ");
			start = start.next;
		}
		System.out.println("###########");
		root = getList();
		MyFNode dStart = flattenListByDepth(root);
		while (dStart != null) {
			System.out.print(dStart.data + " ");
			dStart = dStart.next;
		}

	}
	
	private static MyFNode flattenListByLevel(MyFNode root) {
		MyFNode curr = root;
		MyFNode last = getLastNode(curr);
		while(curr != null) {
			if(curr.down != null) {
				MyFNode temp = curr.down;
				curr.down = null;
				last.next = temp;
				last = getLastNode(temp);
			}
			curr = curr.next;
		}
		return root;
	}
	
	private static MyFNode flattenListByDepth(MyFNode root) {
		if(root == null) {
			return null;
		}
		
		MyFNode last = root;
		MyFNode next = root.next;
		
		if(root.down != null) {
			root.next = flattenListByDepth(root.down);
		}
		if(next != null) {
			last.next = flattenListByDepth(next);
		}
		return root;
	}


	private static MyFNode getLastNode(MyFNode curr) {
		MyFNode temp = curr;
		while(temp.next != null) {
			temp = temp.next;
		}
		return temp;
	}

	private static MyFNode flattenList(MyFNode root) {
		if (root == null || root.next == null) {
			return root;
		}
		return merge(root, flattenList(root.next));
	}

	private static MyFNode merge(MyFNode a, MyFNode b) {
		if (a == null) {
			return b;
		}
		if (b == null) {
			return a;
		}
		MyFNode start = null;
		MyFNode last = null;
		while (a != null && b != null) {
			if (a.data < b.data) {
				if (start == null) {
					start = new MyFNode(a.data);
					last = start;
				} else {
					last.next = new MyFNode(a.data);
					last = last.next;
				}
				a = a.down;
			} else if (b.data < a.data) {
				if (start == null) {
					start = new MyFNode(b.data);
					last = start;
				} else {
					last.next = new MyFNode(b.data);
					last = last.next;
				}
				b = b.down;

			} else {
				if (start == null) {
					start = new MyFNode(a.data);
					last = start;
					last.next = new MyFNode(b.data);
					last = last.next;
				} else {
					last.next = new MyFNode(a.data);
					last = last.next;
					last.next = new MyFNode(b.data);
					last = last.next;
				}
				a = a.down;
				b = b.down;
			}

		}

		while (a != null) {
			last.next = new MyFNode(a.data);
			last = last.next;
			a = a.down;
		}
		while (b != null) {
			last.next = new MyFNode(b.data);
			last = last.next;
			b = b.down;
		}
		return start;
	}

}

class MyFNode {
	int data;
	MyFNode next;
	MyFNode down;

	public MyFNode(int data) {
		this.data = data;
		this.next = null;
		this.down = null;
	}

}
