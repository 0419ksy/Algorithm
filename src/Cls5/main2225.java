package Cls5;

import java.util.Scanner;

public class main2225 {
	
	static int arr[][] = new int[201][201];
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int K = in.nextInt();
		
		for(int i=0; i<N+1; i++)
			arr[i][1] = 1;
		for(int i=0; i<K+1; i++)
			arr[0][i] = 1;
		
		for(int i=1; i<N+1; i++)
		{
			for(int j=2; j<K+1; j++)
			{
				arr[i][j] = arr[i][j-1]+arr[i-1][j];
				arr[i][j] = arr[i][j]%1000000000; 
			}
		}
		
//		for(int i=1; i<N+1; i++)
//		{
//			for(int j=1; j<K+1; j++)
//			{
//				System.out.print(arr[i][j]+" ");
//			}
//			System.out.print("\n");
//		}
		
		System.out.print(arr[N][K]);
	}

}
