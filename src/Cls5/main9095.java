package Cls5;
import java.util.Scanner;

public class main9095 {
	
	public static void main(String[] args) {
		
		int userInput, userCnt;
		int arr[] = new int[12];
		arr[0] = 0;
		arr[1] = 1;
		arr[2] = 2;
		arr[3] = 4;
		
		Scanner in = new Scanner(System.in);
		userCnt = in.nextInt();
		
		while(userCnt>0) {
			userInput = in.nextInt();
			
			for(int i=4; i<=userInput; i++)
			{
				arr[i] = arr[i-3]+arr[i-2]+arr[i-1];
			}
			System.out.println(arr[userInput]);
			userCnt--;
		}
		
	}
}
