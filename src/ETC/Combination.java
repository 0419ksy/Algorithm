package ETC;

import java.util.Scanner;

public class Combination {

	static int N;
	static int K;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		K = in.nextInt();
		
		System.out.println(makeComb(N, K));
	}
	
	public static int makeComb(int n, int k) {
		
		if(k == 0)
			return 1;
		else if(n == k)
			return 1;
		return makeComb(n-1, k-1) + makeComb(n-1, k);
	}
}
