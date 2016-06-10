package naturalNumbers;

public class Zero extends Nat {

	private static Zero instance = null;

	public static Zero getInstance() {
		if (instance == null) {
			instance = new Zero();
		}
		return instance;
	}

	@Override
	public boolean isZero() {
		return true;
	}

	@Override
	public Nat previous() {
		throw new ArithmeticException("Zero.prev()");
	}

	@Override
	public Nat add(Nat a) {
		return a;
	}

	@Override
	public Nat minus(Nat a) {
		if (a.isZero()) {
			return this;
		}
		throw new ArithmeticException("Zero.minus(b)");
	}

	@Override
	public Integer toInt() {
		return 0;
	}

	@Override
	public String toString() {
		return "Zero";
	}
}
