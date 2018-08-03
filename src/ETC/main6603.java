package ETC;

import java.util.Scanner;

public class main6603 {

	static int K;
	static int [] lotto = new int[14];
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		while(true) {
			K = in.nextInt();
			if(K == 0)
				break;
		
			makeZero();
			for(int i = 0 ; i < K; i++) {
				lotto[i] = in.nextInt();
			}
			
			int[] maked = new int[6];
			makeLotto(maked, 0, 0);
			System.out.println();
		}
	}

	public static void makeZero() {
		for(int i = 0; i < 14; i++) {
			lotto[i] = 0;
		}
	}
	
	public static void printMaked(int [] maked) {
		for(int i = 0; i < 5; i++) {
			System.out.print(maked[i]+" ");
		}
		System.out.println(maked[5]);
	}
	
	/* input data
	 * maked - 최종 생성 데이터 배열
	 * current - lotto 의 index
	 * index - maked 의 index
	 */
	public static void makeLotto(int [] maked, int current, int index) {
		if(index >= 6) {
			printMaked(maked);//배열 출력
			return;
		}
		
		if(current >= K) {
			return;
		}
		
		maked[index] = lotto[current];
		makeLotto(maked, current+1, index+1);
		makeLotto(maked, current+1, index);
		
	}
	
}
