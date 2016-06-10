package algo;

import java.util.Arrays;

public class Sorts {

	public static void countingSort(int[] list) {

		int max = Arrays.stream(list).max().getAsInt();

		int[] counts = new int[max + 1];

		for (int i = 0; i < list.length; i++) {
			int currentNumber = list[i];
			counts[currentNumber] += 1;
		}

		int[] sortedList = new int[list.length];
		int listIndex = 0;
		int sortedIndex = 0;
		int tmp = 0;

		while (listIndex <= max) {
			tmp = counts[listIndex];
			if (tmp > 0) {
				sortedList[sortedIndex] = listIndex;
				--counts[listIndex];
				++sortedIndex;
			} else {
				listIndex++;
			}
		}
		System.arraycopy(sortedList, 0, list, 0, list.length);
	}

	public static void main(String[] args) {

		int[] array = { 2, 27, 22, 8, 28, 1, 30, 8, 7, 1, 16, 25, 28, 23, 16, 24, 23, 17, 11, 4, 2, 2, 16, 29, 28 };
		countingSort(array);
		System.out.println(Arrays.toString(array));

	}
}