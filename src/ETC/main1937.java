package ETC;

import java.util.Scanner;

public class main1937 {

	static int N;
	static int map[][];
	static int visited[][]; // 그 방의 최대 살아남는 일자가 담김 (0인 경우 아직 방문 안한거임)

	static int mx[] = { -1, +1, 0, 0 };
	static int my[] = { 0, 0, -1, +1 };

	static int max = 0;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		map = new int[N][N];
		visited = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = in.nextInt();
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i][j] == 0) {
//					System.out.println("*************************");
//					System.out.println(" i : " + i + ", j : " + j);
					dfs(i, j);
//					printMap();
				}
			}
		}

		System.out.println(max);

	}

	public static void dfs(int x, int y) {

//		System.out.println("* x, y : " + x + ", " + y);

		int value = 0;
		for (int i = 0; i < 4; i++) {
			int nx = x + mx[i];
			int ny = y + my[i];

			if (nx >= 0 && nx < N && ny >= 0 && ny < N) {

				if (map[nx][ny] < map[x][y]) {
					if (visited[nx][ny] == 0) {
						dfs(nx, ny);
					}

					if (value < visited[nx][ny]) {
						value = visited[nx][ny];
					}
				}
			}
		}

		visited[x][y] = value + 1;

		if (max < visited[x][y])
			max = visited[x][y];
	}

	public static void printMap() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(visited[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void makeZero() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				visited[i][j] = 0;
			}
		}
	}
}
