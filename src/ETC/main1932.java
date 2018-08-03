package ETC;

import java.util.Scanner;

public class main1932 {
	
	static int N;
	static int map[][];
	
	public static void main(String[] args) {
		//ù° �ٿ� �ﰢ���� ũ�� n(1 �� n �� 500)�� �־�����, ��° �ٺ��� n+1��° �ٱ��� ���� �ﰢ���� �־�����.
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < i+1; j++) {
				map[i][j] = in.nextInt();
			}
		}
		
		for(int i = 1; i < N; i++) {
			for(int j = 0; j <= i; j++) {
				//���� ���۰� ��, �׳� ���ؾ� ��
				if(j == 0) {
					map[i][j] += map[i-1][j];
				}
				else if(j == i) {
					map[i][j] += map[i-1][j-1];
				}
				//���ؾ���
				else {
					map[i][j] = Math.max(map[i][j] + map[i-1][j-1], map[i][j] + map[i-1][j]);
				}
//				System.out.println("-----------------------");
//				System.out.println("i : " + i + ", j : " + j);
//				printMap();
			}
		}
		
		findMap();
	}
	
	public static void printMap() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void findMap() {
		int max = map[N - 1][0];
		for(int i = 1; i < N; i++) {
			max = Math.max(max, map[N - 1][i]);
		}
		System.out.println(max);
	}
	
}
