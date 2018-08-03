package ETC;

import java.util.Scanner;

public class Main14888 {
	
	static int arr[];
	static int N ;
	static int a,b,c,d;
	static int min = 1000000000;
	static int max = -1000000000;
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		arr = new int[N];
		for(int i=0; i<N; i++)
			arr[i] = in.nextInt();
		
		a = in.nextInt();
		b = in.nextInt();
		c = in.nextInt();
		d = in.nextInt();
		dfs(1,0,0,0,0,arr[0]);
		
		System.out.println(max);
		System.out.println(min);
		
		in.close();
	}

	static void dfs(int index, int x, int y, int m, int n, int sum)
	{
		if(index == N)
		{
			min = Math.min(sum, min);
			max = Math.max(sum, max);
			return;
		}
		
		if(x<a)
			dfs(index+1, x+1, y, m, n, sum+arr[index]);
		if(y<b)
			dfs(index+1, x, y+1, m, n, sum-arr[index]);
		if(m<c)
			dfs(index+1, x, y, m+1, n, sum*arr[index]);
		if(n<d)
			dfs(index+1, x, y, m, n+1, sum/arr[index]);
	}
}















