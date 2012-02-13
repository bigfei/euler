package net.bigfei.ds.euler.problems.s323;

import java.util.Arrays;

import net.bigfei.ds.euler.annotation.Euler;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.math.RandomUtils;

@Euler(passed = false)
public class Euler323 {
	public static void main(String[] args) {
		/*
		 * int MAX=(1<<11)+100;
		 * 
		 * long[] a = new long[MAX]; long[] b = new long[MAX]; b[0] = 0; for(int
		 * i = 0; i < MAX; i++){ a[i] = RandomUtils.nextInt(MAX); }
		 * 
		 * for(int i = 1; i < MAX; i++){ b[i] = b[i-1] | a[i-1]; }
		 * System.out.println(a.length);
		 * System.out.println(ArrayUtils.toString(b));
		 */
		Euler323 e = new Euler323();
		int[] a = { 1, 12, 5, 26, 7, 14, 3, 7, 2 };
		e.quickSort(a, 0, 8);

	}

	int partition(int arr[], int left, int right) {
		int i = left, j = right;
		int tmp;
		int pivot = arr[(left + right) / 2];
		while (i <= j) {
			while (arr[i] < pivot)
				i++;
			while (arr[j] > pivot)
				j--;

			if (i <= j) {
				tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
				i++;
				j--;
			}
		}
		return i;
	}

	void quickSort(int arr[], int left, int right) {

		int index = partition(arr, left, right);
		if (left < index - 1)
			quickSort(arr, left, index - 1);

		if (index < right)
			quickSort(arr, index, right);

	}
}
