package net.bigfei.ds.euler.s315;

public class Euler315 {
	static long[] hexDigit = { 0x7E, 0x30, 0x6D, 0x79, 0x33, 0x5B, 0x5F, 0x72, 0x7F, 0x7B };

	public static void main(String[] args) {
		long T = System.nanoTime();

		int N = 20 * 1000 * 1000;
		boolean[] a = new boolean[N + 1];
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

		int st = 0, s = 0;
		for (int i = N / 2; i <= N; i++) {
			if (a[i]) {
				int tr1 = 2 * t1(i);
				int tr2 = t1(i);

				int n = i;
				while (n >= 10) {
					int t = dr(n);
					tr1 += (2 * t1(t));
					tr2 += t2t(n, t);

					n = t;
				}
				st += (tr1 - (tr2 + t1(n)));
				s++;
			}

		}
		T = System.nanoTime() - T;

		System.out.println(st + "s: " + s);
		System.out.println("time = " + T * 1e-9 + "s");

	}

	private static long t2t(int n, int t) {
		int d1 = n, d2 = t;
		long h1 = 0, h2 = 0;

		int i = 0;
		while (d1 > 0) {

			h1 += (hexDigit[d1 % 10] << (8 * i));
			d1 /= 10;
			i++;
		}

		i = 0;
		while (d2 > 0) {

			h2 += (hexDigit[d2 % 10] << (8 * i));
			d2 /= 10;
			i++;
		}

		return Long.bitCount(h1 ^ h2);
	}

	private static int dr(int n) {
		int s = 0, d = n;
		while (d > 0) {

			s += (d % 10);
			d /= 10;
		}
		return s;
	}

	private static int t1(int i) {
		int s = 0, d = i;
		while (d > 0) {

			s += Long.bitCount(hexDigit[d % 10]);
			d /= 10;
		}

		return s;
	}

}
