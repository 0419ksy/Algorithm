package ETC;

import java.util.Scanner;

public class main10026 {

	static int N;
	static String map[][];
	static int visit[][];

	// 상하 좌우 순서
	// static int[] dx = { -1, 1, 0, 0 };
	// static int[] dy = { 0, 0, -1, 1 };

	static int rex;
	static int rey;

	static int cnt = 0;

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		map = new String[N][N];
		visit = new int[N][N];

		String tmp = "";
		for (int i = 0; i < N; i++) {
			tmp = in.next();
			for (int j = 0; j < N; j++) {
				map[i][j] = tmp.charAt(j) + "";
			}
		}

		// for (int i = 0; i < N; i++) {
		// for (int j = 0; j < N; j++) {
		// System.out.print(map[i][j]);
		// }
		// System.out.println();
		// }

		findArea(0, 0);

		System.out.println(cnt);

	}

	public static void findArea(int x, int y) {

		// 상
		if (x - 1 >= 0 && visit[x - 1][y] != 1) // 갈 수 있음
		{
			if (map[x][y].equals(map[x - 1][y])) {
				visit[x - 1][y] = 1;
				findArea(x - 1, y);
			} 
		}
		// 하
		if (x + 1 < N && visit[x + 1][y] != 1) // 갈 수 있음
		{
			if (map[x][y].equals(map[x + 1][y])) {
				visit[x + 1][y] = 1;
				findArea(x + 1, y);
			}
		}

		// 좌
		if (y - 1 >= 0 && visit[x][y - 1] != 1) // 갈 수 있음
		{
			if (map[x][y].equals(map[x][y - 1])) {
				visit[x][y - 1] = 1;
				findArea(x, y - 1);
			}
		}

		// 우
		if (y + 1 < N && visit[x][y + 1] != 1) // 갈 수 있음
		{
			if (map[x][y].equals(map[x][y + 1])) {
				visit[x][y + 1] = 1;
				findArea(x, y + 1);
			}
		}

	
//			cnt++;
//			findRestart();
//			visit[rex][rey] = 1;
//			findArea(rex, rey);
		

		// for (int i = 0; i < 4; i++) {
		// int nx = dx[i] + x;
		// int ny = dy[i] + y;
		//
		// if ((nx < N) && (nx >= 0) && (ny < N) && (ny >= 0) && (visit[nx][ny] == 0)) {
		//
		// visit[nx][ny] = 1;
		// if (map[x][y].equals(map[nx][ny])) {
		// findArea(nx, ny, value);
		// }
		// else {
		// findRestart();
		// findArea(rex, rey, map[rex][rey]);
		// }
		// }
		// }
	}

	// 방문하지 않은 곳 찾기
	public static void findRestart() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visit[i][j] == 0) {
					rex = i;
					rey = j;
					return;
				}
			}
		}
	}
}
