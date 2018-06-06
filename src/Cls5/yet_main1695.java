package Cls5;
import java.util.Scanner;

public class yet_main1695 {

	static int arr[];
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int size = in.nextInt();
		arr = new int[size];
		
		for(int i=0; i<size; i++)
			arr[i]=in.nextInt();
		
		int tmp[] = new int[size/2];
		int rev[] = new int[size/2];
		
		for(int i=0; i<(size/2); i++)
		{
			tmp[i] = arr[i];
			System.out.print(tmp[i]+" ");
		}
		for(int i=0; i<(size/2); i++)
		{
			rev[i] = arr[size-1-i];
			System.out.print(rev[i]+" ");
		}
		
		int a = 0;
		int b = 0;
		int cnt = 0;
		
		for(int i=0; i<size/2; i++)
		{
			if(tmp[i]==rev[i])
			{
				a++;
				b++;
			}
			else
			{
				//tmp±âÁØ rev Å½»ö
				for(int j=i; j<rev.length; j++)
				{
					if(tmp[i]==rev[j])
					{
						cnt += j-i;
						b = j;
						System.out.println("for-if-cnt : "+cnt);
						System.out.println("b : "+b);
					}
				}
				
				//rev±âÁØ tmp Å½»ö
				for(int j=i; j<rev.length; j++)
				{
					if(tmp[j]==rev[i])
					{
						cnt += j-i;
						a = j;
						System.out.println("for2-if-cnt : "+cnt);
						System.out.println("a : "+a);
					}
				}
			}
		}
	}		
}
