//�ٽ� Ǯ��� ��
package ETC;

import java.util.Scanner;

public class Main2156 {
	
	static int cnt;
	static int arr[];
	
	public static void main(String[] args) {
	
		Scanner in = new Scanner(System.in);
		cnt = in.nextInt();
		arr = new int[cnt];
		
		for(int i=0; i<cnt; i++)
		{
			arr[i] = in.nextInt();
		}
		
		//--dp �迭 ����
		int dp[] = new int[cnt];
		dp[0] = arr[0];
		
		//--flag ���� (0: ���� ���� / 1: �����̶� ���� �Ұ�)
		int flag = 1;
		
		for(int i=1; i<cnt; i++)
		{
//			System.out.println("## flag ## : "+flag);
			if(flag < 2)
			{
				dp[i] = Math.max(dp[i-1],dp[i-1]+arr[i]);
				flag++;
			}
			else
			{
				dp[i] = dp[i-1];
				flag = 0;
			}
			
//			System.out.println("@@ i @@ : "+i+"@@ dp[i] @@ : "+dp[i]);
		}
		
	}

}
