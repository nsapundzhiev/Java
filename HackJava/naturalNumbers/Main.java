package naturalNumbers;

public class Main {

	public static void main(String[] args) {
		Zero z = Zero.getInstance();
		Succ one = new Succ(z);
		Succ two = new Succ(one);

		System.out.println(two.toString());
		System.out.println(one.toInt());
		two.add(one);
		System.out.println(two.toString());
		System.out.println(two.toInt());
	}

}
