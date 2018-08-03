package ETC;

import java.util.ArrayList;
import java.util.Scanner;

public class bitstring {

	static int[] arr = {1, 2, 3, 4, 5};
	static int m = 3;
	
	public static void main(String[] args) {
		ArrayList<Integer> resultArr = new ArrayList();
		
		recursive(0, resultArr);
	}
	
	private static void recursive(int x, ArrayList resultArr) {
		if (resultArr.size() == m) {
			for (int i = 0 ; i < resultArr.size() ; ++i) {
				System.out.print(resultArr.get(i) + " ");
			}
			System.out.println();
		}
		
		for (int i = x, length = arr.length - m + 1 ; i < length ; ++i) {
			resultArr.add(arr[i]);
			recursive(i + 1, resultArr);
			resultArr.remove(arr[i]);
		}
	}
}

