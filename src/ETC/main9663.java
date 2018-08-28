package ETC;

import java.util.Scanner;

public class main9663 {
	static int N;
	static int[] map;
	static int result = 0;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		map = new int[N];

		//���ʿ� 0�� ���� ������, 0~N���� �� �࿡ ������ ���� ��ġ �� ��
		move(0);
		System.out.println(result);
	}

	public static void move(int i) {
		if(i == N) {
			result += 1;
		} else {
			for(int j = 0; j < N; j++) {
				map[i] = j;
				if(promising(i) == 1) {
					move(i + 1);
				}	
			}
		}
	}
	
	public static int promising(int i) {
		for(int j = 0; j < i; j++) {
			if(map[j] == map[i] || Math.abs(map[i] - map[j]) == (i-j)) {
				return 0;
			}
		}
		return 1;
	}

}
