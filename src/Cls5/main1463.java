package Cls5;

import java.util.Scanner;

public class main1463 {
	
	public static void main(String[] args) {
		
		int arr[] = new int[1000001];
		arr[0] = arr[1] = 0;
		arr[2] = arr[3] = 1;
		
		Scanner in = new Scanner(System.in);
		int input = in.nextInt();
		
		for(int i=4; i<=input; i++)
		{
			//5가지 경우(2로 나뉘거나 아니거나, 3으로 나뉘거나 아니거나, 1은 무조건 빼기)
			if(i%2==0 && i%3==0) {
				arr[i] = Math.min(arr[i/2]+1, arr[i/3]+1);
			}
			else if(i%2==0 && i%3!=0) {
				arr[i] = Math.min(arr[i/2]+1, arr[i-1]+1);
			}
			else if(i%2!=0 && i%3==0) {
				arr[i] = Math.min(arr[i/3]+1, arr[i-1]+1);
			}
			else
				arr[i] = arr[i-1]+1;
		}
		
//		for(int i=0; i<=input; i++)
//		{
//			System.out.println("##"+i+"## "+arr[i]);
//		}
		System.out.println(arr[input]);
	}

}
