package ETC;

import java.util.Scanner;

public class main10942 {

	static int N;
	static int[] input;
	static int M;
	static int S, E;

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		input = new int[N];
		for (int i = 0; i < N; i++) {
			input[i] = in.nextInt();
		}
		
		M = in.nextInt();
		for(int i = 0; i < M; i++) {
			S = in.nextInt();
			E = in.nextInt();
			System.out.println(checkP(S-1, E-1));				
			
		}
	}

	public static int checkP(int s, int e) {
		//System.out.println("s : "+ s + ", e : " + e);
		int flag = 1;

		int length = e - s + 1;
		//System.out.println("length : " + length);
		int back = 0;
		for (int i = s; i <= length / 2; i++) {
			if (input[i] != input[e - back]) {
				flag = 0;
			}
			back ++;
		}

		return flag; 
	}

}
