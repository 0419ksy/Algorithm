package ETC;

import java.util.Scanner;

public class main11053 {
	static int N;
	static int[] map;
	static int[] dp;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		map = new int[N];
		dp = new int[N];

		for (int i = 0; i < N; i++) {
			map[i] = in.nextInt();
			dp[i] = 1;
		}

		for (int i = 1; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if (map[i] > map[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}

		int max = 0;
		for (int i = 0; i < N; i++) {
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(max);
	}
}
