package com.devtalk.algorithm.circularLinkedList;

public class JosephusCircleTest {

	/*
	 * There are n people standing in a circle waiting to be executed. The counting
	 * out begins at some point in the circle and proceeds around the circle in a
	 * fixed direction. In each step, a certain number of people are skipped and the
	 * next person is executed. The elimination proceeds around the circle (which is
	 * becoming smaller and smaller as the executed people are removed), until only
	 * the last person remains, who is given freedom. Given the total number of
	 * persons n and a number m which indicates that m-1 persons are skipped and
	 * m-th person is killed in circle. The task is to choose the place in the
	 * initial circle so that you are the last one remaining and so survive.
	 */
	public static void main(String[] args) {
		/*
		 * Input : 
		 * Length of circle : n = 4 
		 * Count to choose next : m = 2 
		 * Output : 1
		 * 
		 * Input : 
		 * n = 5 
		 * m = 3 
		 * Output : 4
		 */
		
		Node root = ListUtil.getList(1,2,3,4);
		ListUtil.print(root);
		getJosephusPosition(root,2);
		
		int [] a = new int [100];
		for(int i =0; i<100;i++) {
			a[i] = i+1;
		}
		root = ListUtil.getList(a);
		ListUtil.print(root);
		getJosephusPosition(root,2);

	}

	private static void getJosephusPosition(Node root, int m) {
		Node curr = root;
		Node prev = root;
		
		while(curr.next != curr) {
			
			//Find mth node
			int count = 1;
			while(count != m) {
				prev = curr;
				curr = curr.next;
				count++;
			}
			//Remove mth node
			prev.next = curr.next;
			curr = prev.next;	
		}
		
		System.out.println ("Last person left standing " + 
                "(Josephus Position) is " + curr.data);
		
	}

}
