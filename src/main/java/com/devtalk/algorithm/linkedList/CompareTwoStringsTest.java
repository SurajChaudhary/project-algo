package com.devtalk.algorithm.linkedList;

public class CompareTwoStringsTest {

	public static void main(String[] args) {
		StringNode list1 = ListUtil.getList("a", "b", "c", "d", "f");
		ListUtil.print(list1);

		StringNode list2 = ListUtil.getList("a", "b", "c", "d", "e");
		ListUtil.print(list2);

		compare(list1, list2);

	}

	private static void compare(StringNode list1, StringNode list2) {
		if (list1 == null && list2 == null) {
			System.out.println("Equal : 0");
			return;
		}

		while (list1 != null && list2 != null && list1.data == list2.data) {
			list1 = list1.next;
			list2 = list2.next;
		}

		if (list1 != null && list2 != null) {
			int res = list1.data.compareTo(list2.data);
			System.out.println("Not equal1 : " + res);
			return;
		}

		if (list1 != null && list2 == null) {
			System.out.println("Not equal2 : " + 1);
			return;
		}

		if (list1 == null && list2 != null) {
			System.out.println("Not equal3 : " + -1);
			return;
		}
		System.out.println("Equal : 0");

	}

}
