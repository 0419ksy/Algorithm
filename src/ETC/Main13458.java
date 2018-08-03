package ETC;

import java.util.Scanner;

public class Main13458 {
	
	static int jung, bu;
	static int min = 1000000*1000000;
	static int arr[];
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		arr = new int[N];
		
		for(int i=0; i<N; i++)
		{
			arr[i] = in.nextInt();
		}
		jung = in.nextInt();
		bu = in.nextInt();
		
		long sum = 0;
		for(int i=0; i<N; i++)
		{
			sum += chk(arr[i]);
		}	
		System.out.println(sum);
	}
	
	static long chk(int total)
	{
		if(total-jung < 0)
			return 1;
		long sub = (total-jung)/bu;
		if((total-jung)%bu!=0)
			sub++;
		return sub+1;
	}

}
