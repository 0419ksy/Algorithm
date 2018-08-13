package ETC;

import java.util.Scanner;

public class main2309 {

	static int[] height = new int[9];

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		for (int i = 0; i < 9; i++) {
			height[i] = in.nextInt();
		}

		int[] selected = new int[7];
		calc(selected, 0, 0);
	}

	// pos : selected의 위치
	// index : height의 위치
	public static void calc(int[] selected, int pos, int index) {
		if (pos >= 7) {
			printValid(selected);
			return;
		}

		if (index >= 9) {
			return;
		}

		selected[pos] = height[index];
		calc(selected, pos + 1, index + 1);
		calc(selected, pos, index + 1);
	}

	public static void printValid(int[] selected) {
		int sum = 0;
		for (int i = 0; i < 7; i++) {
			sum += selected[i];
		}
		if (sum == 100) {
			for (int i = 0; i < 7; i++) {
				asc(selected);
				System.exit(0);
				// System.out.println(selected[i]);
			}
		}
	}

	public static void asc(int[] selected) {
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 6; j++) {
				if (selected[j] > selected[j + 1]) {
					int temp = selected[j];
					selected[j] = selected[j + 1];
					selected[j + 1] = temp;
				}
			}
		}
		for(int i = 0; i < 7; i++) {
			System.out.println(selected[i]);
		}
	}
}
