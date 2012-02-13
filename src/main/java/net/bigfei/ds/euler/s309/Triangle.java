package net.bigfei.ds.euler.s309;

public class Triangle {
	private int s1, s2, s3;

	public Triangle(int s1, int s2, int s3) {
		super();
		this.s1 = s1;
		this.s2 = s2;
		this.s3 = s3;
	}

	public String toString() {
		return "Triangle [s1=" + s1 + ", s2=" + s2 + ", s3=" + s3 + "]";
	}

	public int getOtherRectangleEdge(int s) {
		if ((s != s1) && (s != s2))
			throw new IllegalArgumentException("s must be s1 or s2");
		return s == s1 ? s2 : s1;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + s1;
		result = prime * result + s2;
		result = prime * result + s3;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Triangle other = (Triangle) obj;
		if (s1 != other.s1)
			return false;
		if (s2 != other.s2)
			return false;
		if (s3 != other.s3)
			return false;
		return true;
	}

	/**
	 * @return the s1
	 */
	public int getS1() {
		return s1;
	}

	/**
	 * @return the s2
	 */
	public int getS2() {
		return s2;
	}

	/**
	 * @return the s3
	 */
	public int getS3() {
		return s3;
	}

	/**
	 * @param s1
	 *            the s1 to set
	 */
	public void setS1(int s1) {
		this.s1 = s1;
	}

	/**
	 * @param s2
	 *            the s2 to set
	 */
	public void setS2(int s2) {
		this.s2 = s2;
	}

	/**
	 * @param s3
	 *            the s3 to set
	 */
	public void setS3(int s3) {
		this.s3 = s3;
	}

}
