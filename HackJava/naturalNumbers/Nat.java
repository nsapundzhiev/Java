package naturalNumbers;

abstract class Nat {

	public abstract boolean isZero();

	public Nat next() {
		return new Succ(this);
	}

	public abstract Nat previous();

	public abstract Nat add(Nat a);

	public abstract Nat minus(Nat a);

	public abstract Integer toInt();

	public abstract String toString();
}
