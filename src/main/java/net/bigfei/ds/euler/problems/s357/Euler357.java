package net.bigfei.ds.euler.problems.s357;


public class Euler357 {
	private static final int N = 10000000;
	private static boolean[] p = Euler357.primes(N);

	public static void main(String[] args) {
		long sum = 0;
		boolean[] a = new boolean[N + 1];

		long t1 = System.currentTimeMillis();

		for (int d = 1; d <= N; d++) {
			for (int k = 1; k * d <= N; k++) {
				if (!p[d + k] && !a[k * d]) {
					a[k * d] = true;
				}
			}
		}
		for (int i = 0; i < a.length; i++) {
			if (!a[i]) {
				sum += i;
			}
		}

		System.out.println("SUM: " + sum);
		long t2 = System.currentTimeMillis();
		System.out.println(t2 - t1);
		// System.out.println(primes(10000 * 10000).length);
	}

	public static boolean[] primes(int N) {

		boolean[] a = new boolean[N + 2];
		a[2] = true;
		for (int i = 3; i <= N; i++)
			a[i] = ((i & 1) == 0) ? false : true;

		int p = 2;
		while (p * p <= N) {
			if (a[p]) {
				for (int j = 2; j * p <= N; j++) {
					a[j * p] = false;
				}
			}
			p++;

		}

		return a;
	}

}
