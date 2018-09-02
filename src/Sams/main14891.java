package Sams;

import java.util.ArrayList;
import java.util.Scanner;

public class main14891 {

	static Topni t1, t2, t3, t4;

	static class Topni {
		ArrayList<Integer> map = new ArrayList<Integer>();
		int dir = 0;

		public Topni(String input) {
			for (int i = 0; i < 8; i++) {
				int tmp = input.charAt(i) - 48;
				map.add(tmp);
			}
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		t1 = new Topni(in.next());
		t2 = new Topni(in.next());
		t3 = new Topni(in.next());
		t4 = new Topni(in.next());

		int cnt = in.nextInt();
		int topniNum, topniDir;
		for (int i = 0; i < cnt; i++) {
			topniNum = in.nextInt();
			topniDir = in.nextInt();
			rollTopni(topniNum, topniDir);
//			printTopni();
//			System.out.println("-------------------");
		}
		
		int sum = 0; 
		sum += t1.map.get(0) == 0? 0 : 1;
		sum += t2.map.get(0) == 0? 0 : 2;
		sum += t3.map.get(0) == 0? 0 : 4;
		sum += t4.map.get(0) == 0? 0 : 8;
		
		System.out.println(sum);
	}

	public static void rollTopni(int topniNum, int topniDir) {
		// 방향정보 초기화
		t1.dir = t2.dir = t3.dir = t4.dir = 0;

		char[] checkDir = new char[3];
		// 맞닿는 부분의 위치 비교
		checkDir[0] = t1.map.get(2) == t2.map.get(6) ? 'S' : 'D';
		checkDir[1] = t2.map.get(2) == t3.map.get(6) ? 'S' : 'D';
		checkDir[2] = t3.map.get(2) == t4.map.get(6) ? 'S' : 'D';

		switch (topniNum) {
		case 1:
			t1.dir = topniDir;
			t2.dir = checkDir[0] == 'S' ? 0 : t1.dir * (-1);
			t3.dir = t2.dir != 0 && checkDir[1] == 'S' ? 0 : t2.dir * (-1);
			t4.dir = t3.dir != 0 && checkDir[2] == 'S' ? 0 : t3.dir * (-1);
			break;
		case 2:
			t2.dir = topniDir;
			t1.dir = checkDir[0] == 'S' ? 0 : t2.dir * (-1);
			t3.dir = checkDir[1] == 'S' ? 0 : t2.dir * (-1);
			t4.dir = t3.dir != 0 && checkDir[2] == 'S' ? 0 : t3.dir * (-1);
			break;
		case 3:
			t3.dir = topniDir;
			t2.dir = checkDir[1] == 'S' ? 0 : t3.dir * (-1);
			t4.dir = checkDir[2] == 'S' ? 0 : t3.dir * (-1);
			t1.dir = t2.dir != 0 && checkDir[0] == 'S' ? 0 : t2.dir * (-1);
			break;
		case 4:
			t4.dir = topniDir;
			t3.dir = checkDir[2] == 'S' ? 0 : t4.dir * (-1);
			t2.dir = t3.dir != 0 && checkDir[1] == 'S' ? 0 : t3.dir * (-1);
			t1.dir = t2.dir != 0 && checkDir[0] == 'S' ? 0 : t2.dir * (-1);
			break;
		}

		// 실제 톱니바퀴 이동시키기
		moveTopni();

	}

	public static void moveTopni() {
		int tmp;
		// t1
		if (t1.dir == 1) {
			tmp = t1.map.get(7);
			t1.map.remove(7);
			t1.map.add(0, tmp);
		} else if (t1.dir == -1) {
			tmp = t1.map.get(0);
			t1.map.remove(0);
			t1.map.add(tmp);
		}

		// t2
		if (t2.dir == 1) {
			tmp = t2.map.get(7);
			t2.map.remove(7);
			t2.map.add(0, tmp);
		} else if (t2.dir == -1) {
			tmp = t2.map.get(0);
			t2.map.remove(0);
			t2.map.add(tmp);
		}

		// t3
		if (t3.dir == 1) {
			tmp = t3.map.get(7);
			t3.map.remove(7);
			t3.map.add(0, tmp);
		} else if (t3.dir == -1) {
			tmp = t3.map.get(0);
			t3.map.remove(0);
			t3.map.add(tmp);
		}

		// t4
		if (t4.dir == 1) {
			tmp = t4.map.get(7);
			t4.map.remove(7);
			t4.map.add(0, tmp);
		} else if (t4.dir == -1) {
			tmp = t4.map.get(0);
			t4.map.remove(0);
			t4.map.add(tmp);
		}
	}

	public static void printTopni() {
		System.out.println("t1_dir : " + t1.dir);
		for (int i = 0; i < 8; i++) {
			System.out.print(t1.map.get(i));
		}
		System.out.println();

		System.out.println("t2_dir : " + t2.dir);
		for (int i = 0; i < 8; i++) {
			System.out.print(t2.map.get(i));
		}
		System.out.println();

		System.out.println("t3_dir : " + t3.dir);
		for (int i = 0; i < 8; i++) {
			System.out.print(t3.map.get(i));
		}
		System.out.println();

		System.out.println("t4_dir : " + t4.dir);
		for (int i = 0; i < 8; i++) {
			System.out.print(t4.map.get(i));
		}
		System.out.println();
	}
}
