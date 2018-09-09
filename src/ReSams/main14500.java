package ReSams;

import java.util.ArrayList;
import java.util.Scanner;

public class main14500 {
	static int N, M;
	static int [][] map;
	static int max = 0;
	
	static int [] mx = {-1, 1, 0, 0};
	static int [] my = {0, 0, -1, 1};
	
	static ArrayList<Point> point = new ArrayList<Point>();
	static class Point {
		int x;
		int y;
		
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		M = in.nextInt();
		map = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				map[i][j] = in.nextInt();
			}
		}
		
		int [][] visited = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M ;j++) {
				visited[i][j] = 1;
				point.add(new Point(i, j));
				dfs(i, j, visited);
				point.clear();
				visited[i][j] = 0;
				
				checkRightLeft(i,j);
				checkUpDown(i, j);
			}
		}
		
		System.out.println(max);
	}
	
	//'ㅏ, ㅓ 체크'
	public static void checkRightLeft(int x, int y) {
		int nextX, nextY;
		int sum = 0;
		if(x >= N-2 || y >= M-1) {
			return;
		} else {
			for(int i = 2; i < 4; i++) {
				sum = map[x][y] + map[x+1][y] + map[x+2][y];
				nextX = x + 1 + mx[i];
				nextY = y + my[i];
				if(nextX >=0 && nextX < N && nextY >= 0 && nextY < M) {
					sum += map[nextX][nextY];
					//System.out.println("x : " + x + ", y : " + y + ": " +sum);
				}
				max = max < sum ? sum : max;
			}
		}
	}
	
	
	//'ㅗ, ㅜ 체크'
	public static void checkUpDown(int x, int y) {
		int nextX, nextY;
		int sum = 0;
		if(x >= N-1 || y >= M-2) {
			return;
		} else {
			for(int i = 0; i < 2; i++) {
				sum = map[x][y] + map[x][y+1] + map[x][y+2];
				nextX = x + mx[i];
				nextY = y + 1 + my[i];
				if(nextX >=0 && nextX < N && nextY >= 0 && nextY < M) {
					sum += map[nextX][nextY];
				}
				max = max < sum ? sum : max;
			}
		}
	}
	
	/* vmap은 이동체크를 위한 맵
	 * x, y는 현재 위치 
	*/
	public static void dfs(int x, int y, int[][] vmap) {
		if(point.size() >= 4) {			
			int sum = 0;
			for(Point p : point) {
				sum += map[p.x][p.y];
			}
			max = max < sum ? sum : max; 
			return;
		}		
		
		int nextX = 0, nextY = 0;
		for(int i = 0; i < 4; i++) {
			nextX = x + mx[i];
			nextY = y + my[i];
			
			if(nextX >=0 && nextX < N && nextY >= 0 && nextY < M && vmap[nextX][nextY] == 0) {
				vmap[nextX][nextY] = 1;
				point.add(new Point(nextX, nextY));
				dfs(nextX, nextY, vmap);
				vmap[nextX][nextY] = 0;
				point.remove(point.size()-1);
			}
		}
	}
}

