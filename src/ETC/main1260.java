package ETC;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class main1260 {

	static int N, M, V;
	static int map[][];
	static int visited[];
	static Stack<Integer> stack = new Stack<Integer>();
	static Queue<Integer> queue = new LinkedList<>();

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		M = in.nextInt();
		V = in.nextInt();

		map = new int[N][N];
		visited = new int[N];

		int input1, input2;
		for (int i = 0; i < M; i++) {
			input1 = in.nextInt() - 1;
			input2 = in.nextInt() - 1;
			if (input1 < input2) {
				map[input1][input2] = 1;
			} else {
				map[input2][input1] = 1;
			}
		}
		// printMap();	
		
		//dfs
		stack.push(V-1);
		visited[V-1] = 1;
		System.out.print(V + " ");
		dfs();
		
		for(int i = 0; i < N; i++) {
			visited[i] = 0;
		}		
		
		System.out.println();
		
		//bfs
		queue.add(V-1);
		visited[V-1] = 1;
		System.out.print(V + " ");
		bfs();
	}
	
	public static void dfs() {
		while(!stack.isEmpty()) {
			int top = stack.peek();
			int flag = 0;
			for(int i = 0; i < N; i++) {
				if(map[top][i] == 1 || map[i][top] == 1) {
					if(visited[i] == 0) {
						stack.push(i);
						System.out.print((i+1) + " ");
						visited[i] = 1;
						flag = 1;
						break;
					}
				}
			}
			if(flag == 0) {
				stack.pop();
			}
		}
	}
	
	public static void bfs() {
		while(!queue.isEmpty()) {
			int top = queue.poll();
			for(int i = 0; i < N; i++) {
				if(map[top][i] == 1 || map[i][top] == 1) {
					if(visited[i] == 0) {
						queue.add(i);
						System.out.print((i+1) + " ");
						visited[i] = 1;
					}
				}
			}
		}
	}
	

	public static void printMap() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
