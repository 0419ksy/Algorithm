package ETC;

import java.util.Scanner;

public class main11052 {
	
	static int N;
	static int fish[];
	static int count[];

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		/* 0번째 방 사용 안함 */
		fish = new int[N + 1];
		count = new int[N + 1];
				
		for(int i = 1; i <= N; i++) {
			fish[i] = in.nextInt();
			count[i] = fish[i];
		}
		
		for(int i = 1; i <= N ; i++) {
			for(int j = i; j <= N; j++) {
				count[j] = Math.max(count[j], count[j-i] + count[i]);
				//System.out.print(count[j] + " ");
			}
			//System.out.println();
		}
		
		
		System.out.println(count[N]);
		
	}
}
