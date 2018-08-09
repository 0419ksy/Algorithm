package ETC;

import java.util.Scanner;

public class main1347 {

	static int N;
	static int direction = 1; /* 상 : 0, 하 : 1, 좌 : 2, 우 : 3 */
	static char[][] map = new char[101][101];

	static int curX = 50;
	static int curY = 50;

	static int minX, minY, maxX, maxY;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();

		/* map 초기화 */
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				map[i][j] = ' ';
			}
		}

		/* 홍준이 위치 초기화 */
		map[curX][curY] = '.';
		minX = minY = maxX = maxY = 50;

		char inst;
		String inputString = in.next();
		for (int i = 0; i < inputString.length(); i++) {
			inst = inputString.charAt(i);
			/* direction 변경 필요 */
			if (inst != 'F') {
				changeDirection(inst);
			} else {
				gogoSing();
			}
		}

//		System.out.println("minX : " + minX + ", maxX : " + maxX);
//		System.out.println("minY : " + minY + ", maxY : " + maxY);

		printMap();
	}

	public static void printMap() {
		for (int i = minX; i <= maxX; i++) {
			for (int j = minY; j <= maxY; j++) {
				if (map[i][j] == ' ')
					map[i][j] = '#';
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}

	public static void gogoSing() {
		switch (direction) {
		case 0:
			curX -= 1;
			if (minX > curX) {
				minX = curX;
			}
			break;
		case 1:
			curX += 1;
			if (maxX < curX) {
				maxX = curX;
			}
			break;
		case 2:
			curY -= 1;
			if (minY > curY) {
				minY = curY;
			}
			break;
		case 3:
			curY += 1;
			if (maxY < curY) {
				maxY = curY;
			}
			break;
		default:
			break;
		}

		map[curX][curY] = '.';

	}

	public static void changeDirection(char inst) {
		if (inst == 'R') {
			switch (direction) {
			case 0:
				direction = 3;
				break;
			case 1:
				direction = 2;
				break;
			case 2:
				direction = 0;
				break;
			case 3:
				direction = 1;
				break;
			default:
				break;
			}
		}

		else {
			switch (direction) {
			case 0:
				direction = 2;
				break;
			case 1:
				direction = 3;
				break;
			case 2:
				direction = 1;
				break;
			case 3:
				direction = 0;
				break;
			default:
				break;
			}
		}

		// System.out.println("* " + direction);
	}
}
