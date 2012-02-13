package net.bigfei.ds.euler.s309;


/**
 * use 512M heap size
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

	boolean[] primes = new boolean[1000];
	Map<Integer, List<Triangle>> shorts = new HashMap<Integer, List<Triangle>>(1000 * 1000);
	List<FourPair> result = new ArrayList<FourPair>(1000 * 1000);

	static int MAX = 1000 * 1000;

	public static void main(String[] args) {
		long t1 = System.currentTimeMillis();
		Solution l = new Solution();
		for (int m = 2; m <= 1000; m++) {
			for (int n = 1; n < m; n++) {
				if (gcd(m, n) == 1 && (((m & 1) != 1) || ((n & 1) != 1))) {
					int s1 = m * m - n * n, s2 = 2 * m * n, s3 = m * m + n * n;
					for (int i = 1; i * s3 < MAX; i++) {
						p(l, s1, s2, s3, i);
					}
				}
			}
		}

		l.scan();

		long t2 = System.currentTimeMillis();
		System.out.println(t2 - t1);
	}

	private void scan() {
		int c = 0;
		for (Map.Entry<Integer, List<Triangle>> s : shorts.entrySet()) {
			int edge = s.getKey().intValue();
			List<Triangle> list = s.getValue();

			for (int i = 0; i < list.size(); i++) {
				Triangle ti = list.get(i);

				for (int j = i + 1; j < list.size(); j++) {
					Triangle tj = list.get(j);
					int A = ti.getOtherRectangleEdge(edge);
					int B = tj.getOtherRectangleEdge(edge);

					long AB = (long) A * (long) B;
					long APB = A + B;

					if (AB % APB == 0) {

						long h = AB / APB;
						long w = edge;
						long x = ti.getS3();
						long y = tj.getS3();

						FourPair a = new FourPair(x, y, w, h);
						c++;
						// System.out.println(c + ":" + a);
					}
				}
			}

		}

		System.out.println(c);

	}

	private static void p(Solution l, int s1, int s2, int s3, int i) {
		Triangle t = null;
		if (s1 < s2) {
			t = new Triangle(i * s1, i * s2, i * s3);
			l.add(i * s1, l.shorts, t);
			l.add(i * s2, l.shorts, t);
		} else {
			t = new Triangle(i * s2, i * s1, i * s3);
			l.add(i * s2, l.shorts, t);
			l.add(i * s1, l.shorts, t);
		}

		// l.add(t);

	}

	public static int gcd(int a, int b) {
		while (b != 0) {
			int r = b;
			b = a % b;
			a = r;
		}
		return a;
	}

	public void add(Integer key, Map<Integer, List<Triangle>> map, Triangle t) {
		List<Triangle> triangles = (List<Triangle>) map.get(key);

		if (triangles == null) {
			triangles = new ArrayList<Triangle>(30);
		}
		triangles.add(t);

		map.put(key, triangles);
	}

	/**
	 * Return the greatest common divisor
	 */

	public static long gcd(long a, long b) {

		if (b == 0)
			return a;
		else
			return gcd(b, a % b);
	}

	public void fill() {
		Arrays.fill(primes, true); // assume all integers are prime.
		primes[0] = primes[1] = false; // we know 0 and 1 are not prime.
		for (int i = 2; i < primes.length; i++) {
			if (primes[i]) {// if the number is prime,
				// then go through all its multiples and make their values false.
				for (int j = 2; i * j < primes.length; j++) {
					primes[i * j] = false;
				}
			}
		}
	}

}
