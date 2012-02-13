package net.bigfei.ds.euler.s002;

import org.apache.commons.lang.ArrayUtils;

public class Euler002 {

	public static void main(String[] args) {

		int N = 40, s = 0;
		int[] a = new int[N + 1];
		a[0] = 0;
		a[1] = 1;
		
		
		for (int i = 2; i <= N; i++) {
			a[i] = a[i - 2] + a[i - 1];
			if ((a[i] & 1) == 0 && (a[i] <= (4000 * 1000))) {
				System.out.println(i);
				s += a[i];
			}
		}
		System.out.println(ArrayUtils.toString(a));
		System.out.println(s);


	}

	public static int fibonacci(int n) {
		if (n == 0)
			return 0;
		else if (n == 1)
			return 1;
		else
			return fibonacci(n - 2) + fibonacci(n - 1);

	}

}
