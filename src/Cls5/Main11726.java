package Cls5;
import java.util.Scanner;

public class Main11726 {

	public static void main(String[] args) {

		int arr[] = new int[1001];
		Scanner in = new Scanner(System.in);
		int input = in.nextInt();
		clac(arr, input);
		
		int res = arr[input];
		System.out.println(res);
	}
	
	public static void clac(int arr[], int cnt)
	{
		arr[1]=1;
		arr[2]=2;
		
		for(int i=3; i<=cnt; i++)
			arr[i] = (arr[i-1]+arr[i-2])%10007;
	}
	
}
