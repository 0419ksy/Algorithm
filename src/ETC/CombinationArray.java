package ETC;

import java.util.Scanner;

public class CombinationArray {
	
	static int N;
	static int K;
	static int [] map;
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		K = in.nextInt();
		map = new int[N];
		
		for(int i = 0; i < N; i++)
		{
			map[i] = in.nextInt();
		}
		
		int[] copy = new int[N]; // ����� ���� ��� �迭
		makeComb(copy, 0, 0);		//index : ó������ 0�� ���� ���·� ���� , k : map�� �� ��° ���Ҹ� �ִ��� 
	}
	
	// copy: ����� ���� ��� �迭 , index : ������� ���� ����
	public static void makeComb(int[] copy, int index, int target) {
		if(index == K) {
			print(copy);// copy �迭 ���
			return;
		}
		else if(target == N){
			return;
		}
		else {
			copy[index] = map[target];
			makeComb(copy, index + 1, target + 1);
			makeComb(copy, index, target + 1);
		}
	}
	
	public static void print(int[] copy) {
		for(int i = 0; i < K; i++)
			System.out.print(copy[i]+" ");
		System.out.println();
	}

}
