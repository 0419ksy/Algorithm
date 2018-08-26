package ETC;

import java.util.Scanner;

public class main1520 {
	static int N, M;
	static int[][] map;
	static int count = 0;

	// 상 하 좌 우 순서
	static int[] mx = { -1, 1, 0, 0 };
	static int[] my = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		M = in.nextInt();
		map = new int[N][M];
		int[][] visited = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = in.nextInt();
			}
		}

		// 0,0에서부터 움직이기 시작
		visited[0][0] = 1;
		move(0, 0, visited);
		System.out.println(count);
	}

	public static void move(int x, int y, int[][] visited) {
		if (x == N - 1 && y == M - 1) {
//			System.out.println("----------");
//			for(int m = 0; m < N; m++) {
//				for(int n = 0; n < M; n++) {
//					System.out.print(visited[m][n] + " ");
//				}
//				System.out.println();
//			}
			count++;
			return;
		}

		int flag = 0;
		
		for (int i = 0; i < 4; i++) {
			int nx = x + mx[i];
			int ny = y + my[i];

			if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
				if (map[x][y] > map[nx][ny] && visited[nx][ny] == 0) {
					visited[nx][ny] = 1;
					flag = 1;
					move(nx, ny, visited);
					visited[nx][ny] = 0;
				}
			}
		}
		// 더 이상 움직일 수 없음
		if (flag == 0) {
			return;
		}
	}
}
