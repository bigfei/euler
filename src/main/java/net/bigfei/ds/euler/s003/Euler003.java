package net.bigfei.ds.euler.s003;

public class Euler003 {

	public static void main(String[] args) {

		int N = 1000 * 1000;
		boolean[] a = new boolean[N + 1];
		for (int i = 3; i <= N; i++)
			a[i] = ((i % 2) == 0) ? false : true;

		int p = 2;
		while (p * p <= N) {
			if (a[p]) {
				for (int j = 2; j * p <= N; j++) {
					a[j * p] = false;
				}
			}
			p++;

		}

		long n = 600851475143l;

		int i = 2;
		while (n != 1) {
			if (a[i] && (n % i == 0)) {
				do {
					System.out.println("1n:" + n + "i: " + i);
					n /= i;
					System.out.println("2n:" + n + "i: " + i);
				} while (n % i == 0);

			}

			i++;
		}

	}

}
