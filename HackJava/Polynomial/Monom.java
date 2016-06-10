package polynomial;

public class Monom {

	private String name;
	private int coefficient;
	private int degree;

	public Monom(String name) {
		this.name = name;
	}

	public Monom(String name, int coefficient, int degree) {
		this.name = name;
		this.degree = degree;
		this.coefficient = coefficient;
	}

	public String toString() {
		if (getDegree() == 0) {
			return String.format("%s", getCoefficient());
		}
		switch (this.getCoefficient()) {
		case 0:
			return "0";
		case 1:
			return getName() + "^" + getDegree();
		case -1:
			return "-" + getName() + "^" + getDegree();
		default:
			return getCoefficient() + getName() + "^" + getDegree();
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCoefficient() {
		return coefficient;
	}

	public void setCoefficient(int coefficient) {
		this.coefficient = coefficient;
	}

	public int getDegree() {
		return degree;
	}

	public void setDegree(int degree) {
		this.degree = degree;
	}

	public void add(Monom a) {
		if (this.getDegree() == a.getDegree()) {
			this.setCoefficient(this.getCoefficient() + a.getCoefficient());
		}
	}

	public void substract(Monom a) {
		if (this.getDegree() == a.getDegree()) {
			this.setCoefficient(this.getCoefficient() - a.getCoefficient());
		}
	}

	public void multiplicate(Monom a) {
		this.setCoefficient(this.getCoefficient() * a.getCoefficient());
		this.setDegree(this.getDegree() + a.getDegree());
	}

	public void multiplicateByConstant(int constant) {
		this.setCoefficient(this.getCoefficient() * constant);
	}

	public void derivative() {
		this.setCoefficient(this.getCoefficient() * this.getDegree());
		this.setDegree(this.getDegree() - 1);
	}

	public void fromString(String monom) {
		String degree;
		String[] parts = monom.split(getName());
		degree = parts[1].substring(1);
		setCoefficient(Integer.parseInt(parts[0]));
		setDegree(Integer.parseInt(degree));
	}
}
