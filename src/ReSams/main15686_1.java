package ReSams;

import java.util.ArrayList;
import java.util.Scanner;

public class main15686_1 {

	static int N, M;
	static int[][] map;
	static ArrayList<Point> chicken = new ArrayList<Point>();
	static ArrayList<Point> home = new ArrayList<Point>();
	static int totalCnt = 0;
	static int totalSum = 9999999;

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		M = in.nextInt();
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = in.nextInt();
				// 치킨집 발견
				if (map[i][j] == 2) {
					totalCnt++;
					chicken.add(new Point(i, j));
				}
				// 집 발견
				else if (map[i][j] == 1) {
					home.add(new Point(i, j));
				}
			}
		}

		int[] chickenComb = new int[M];
		makeComb(chickenComb, 0, 0);
		System.out.println(totalSum);
	}

	// index는 chickenComb의 위치를 알기 위해
	// value는 실제 들어갈 값
	public static void makeComb(int[] chickenComb, int index, int value) {
		if (index >= M) {
			printComb(chickenComb);	// 집과 거리 구하기
			return;
		}

		if (value > totalCnt-1) {
			return;
		}
		chickenComb[index] = value;
		makeComb(chickenComb, index + 1, value + 1);
		makeComb(chickenComb, index, value + 1);
	}
	
	public static void printComb(int[] chickenComb) {
//		for(int i = 0; i < M; i++) {
//			System.out.print(chickenComb[i] + " ");
//		}
//		System.out.println();
		
		ArrayList<Point> chickenTmp = new ArrayList<Point>();
		for(int i = 0; i < M ; i++) {
			chickenTmp.add(chicken.get(chickenComb[i]));
		}
		
		int min;
		int sum = 0;
		// 집을 기준으로 치킨 집 거리 중 가장 짧은 거 체크하기
		for(Point hp : home) {
			min = 9999999;
			for(Point cp : chickenTmp) {
				min = Math.min(Math.abs(hp.x - cp.x) + Math.abs(hp.y - cp.y), min);
			}
			sum += min;
		}
		
		totalSum = Math.min(totalSum, sum);
		
	}

}
