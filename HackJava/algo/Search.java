package algo;

import java.util.ArrayList;

public class Search {

	public static boolean binarySearch(ArrayList<Integer> list, int element) {
		int start = 0;
		int end = list.size() - 1;
		int middle = 0;

		while (start <= end) {
			middle = start + (end - start) / 2;

			if (list.get(middle) == element) {
				return true;
			} else {
				if (list.get(middle) < element) {
					start = middle + 1;
				} else {
					end = middle - 1;
				}
			}
		}
		return false;
	}

	public static boolean interpolationSearch(ArrayList<Integer> list, int element) {
		int start = 0;
		int end = list.size() - 1;
		int middle = 0;
		int coeff = 0;

		while (start <= end) {
			coeff = (element - list.get(start)) / (list.get(end) - list.get(start));
			middle = (int) (start + (end - start) * coeff);

			if (list.get(middle) == element) {
				return true;
			} else {
				if (list.get(middle) < element) {
					start = middle + 1;
				} else {
					end = middle - 1;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {

		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(5);
		list.add(9);
		list.add(13);
		list.add(17);
		list.add(21);
		list.add(25);
		list.add(29);
		list.add(33);
		list.add(37);
		list.add(41);
		System.out.println(interpolationSearch(list, 5));
		System.out.println(binarySearch(list, 5));
	}
}
