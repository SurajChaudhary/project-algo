package com.devtalk.algorithm.sorting;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		int[] arr = { 7, 6, 5, 4, 3, 2, 1, 0 ,10,99};

		System.out.println("### Before sorting ###");
		System.out.println(Arrays.toString(arr));

		QuickSort quickSort = new QuickSort();
		quickSort.sort(arr, 0, 7);

		System.out.println("### After sorting ###");
		System.out.println(Arrays.toString(arr));
	}

	/**
	 * Sorting the given array.
	 * 
	 * @param arr
	 * @param start
	 * @param end
	 */
	private void sort(int[] arr, int start, int end) {
		// No need to sort if array is null or empty.
		if (arr == null || arr.length == 0) {
			return;
		}

		// Base condition to come out of recursion.
		if (start >= end) {
			return;
		}

		// Getting partition Index.
		int partitionIndex = partition(arr, start, end);

		// Sorting array left to partition Index.
		sort(arr, start, partitionIndex - 1);
		// Sorting array right to partition Index.
		sort(arr, partitionIndex + 1, end);
	}

	/**
	 * Getting partitioning Index for given array.
	 * 
	 * @param arr
	 * @param start
	 * @param end
	 * @return
	 */
	private int partition(int[] arr, int start, int end) {
		int pivot = arr[end];

		int partitionIndex = start;

		for (int i = start; i < end; i++) {
			if (arr[i] < pivot) {
				swap(arr, i, partitionIndex);
				partitionIndex++;
			}
		}

		swap(arr, partitionIndex, end);
		return partitionIndex;
	}

	/**
	 * Swapping elements at ith and partitionIndex.
	 * 
	 * @param arr
	 * @param i
	 * @param partitionIndex
	 */
	private void swap(int[] arr, int i, int partitionIndex) {

		int temp = arr[i];
		arr[i] = arr[partitionIndex];
		arr[partitionIndex] = temp;

	}

}
