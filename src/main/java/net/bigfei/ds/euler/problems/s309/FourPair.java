package net.bigfei.ds.euler.problems.s309;

public class FourPair {
	private long x, y, w, h;

	@Override
	public String toString() {
		return "FourPair [h=" + h + ", w=" + w + ", x=" + x + ", y=" + y + "]";
	}

	public FourPair(long x, long y, long w, long h) {
		super();
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}

	public long getX() {
		return x;
	}

	public long getY() {
		return y;
	}

	public long getW() {
		return w;
	}

	public long getH() {
		return h;
	}

	public void setX(long x) {
		this.x = x;
	}

	public void setY(long y) {
		this.y = y;
	}

	public void setW(long w) {
		this.w = w;
	}

	public void setH(long h) {
		this.h = h;
	}
}
