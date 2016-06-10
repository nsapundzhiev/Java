package naturalNumbers;

public class Succ extends Nat {

	private Nat n;

	public Succ(Nat n) {
		this.n = n;
	}

	@Override
	public boolean isZero() {
		return false;
	}

	@Override
	public Nat previous() {
		return n;
	}

	@Override
	public Nat add(Nat a) {
		if (a.isZero()) {
			return this;
		}
		return this.next().add(a.previous());
	}

	@Override
	public Nat minus(Nat a) {
		if (a.isZero()) {
			return this;
		}
		return this.previous().minus(a.previous());
	}

	@Override
	public Integer toInt() {
		return 1 + previous().toInt();
	}

	@Override
	public String toString() {
		return "Succ + " + previous().toString();
	}
}
