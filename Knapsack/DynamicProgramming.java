package fmi.course_project.sda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DynamicProgramming {

	private static BufferedReader br;

	public static long solvingKnapsackProblem(int maxWeight) throws NumberFormatException, IOException {

		/*
		 * Opening text file and reading every line from it and adding weights
		 * and values of items in arrays
		 */

		br = new BufferedReader(new FileReader("D:/Programs/Eclipse/IndianaJones/src/fmi/course_project/sda/text"));
		List<Long> values = new ArrayList<>();
		List<Long> weight = new ArrayList<>();
		String line = null;
		int numberOfItems = 0;
		while ((line = br.readLine()) != null) {
			String[] splitted = line.split("\\s+");
			values.add(Long.parseLong(splitted[1]));
			weight.add(Long.parseLong(splitted[2]));
			numberOfItems++;
		}

		long[][] table = new long[numberOfItems + 1][maxWeight + 1];
		/*
		 * Initializing table which is going to keep results of problems which
		 * are solved
		 */

		for (int i = 1; i <= numberOfItems; i++) {
			for (int w = 1; w <= maxWeight; w++) {
				if (weight.get(i - 1) <= w) {
					table[i][w] = Math.max(values.get(i - 1) + table[i - 1][(int) (w - weight.get(i - 1))],
							table[i - 1][w]);
				} else {
					table[i][w] = table[i - 1][w];
				}
			}
		}

		return table[numberOfItems][maxWeight];
	}

	public static void main(String... args) throws IOException {

		int weight;
		weight = 25;
		long result;
		result = solvingKnapsackProblem(weight);
		System.out.println(result);
	}
}
