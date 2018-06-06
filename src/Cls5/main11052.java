package Cls5;
import java.util.Scanner;
import java.lang.*;

public class main11052 {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int cnt = in.nextInt();
		int arr[] = new int[cnt+1];
		int tmp[] = new int[cnt+1];
		
		for(int i=1; i<=cnt; i++)
		{
			arr[i] = in.nextInt();
		}
		
		tmp[0] = 0;
		for(int i=1; i<=cnt; i++)
		{
			tmp[i] = cnt/i*arr[i]+arr[(cnt%i)];
		}
		
		
		int max= 0 ;
		for(int i=1; i<=cnt; i++)
		{
			max = Math.max(max, tmp[i]);
//			System.out.println(tmp[i]);
		}
		System.out.println(max);
		
	}

}
