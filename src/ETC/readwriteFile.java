package ETC;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class readwriteFile {

	public static void main(String[] args) {
		try {
			File folder = new File("C://qraft/");
			File[] listOfFiles = folder.listFiles();

			BufferedWriter out = new BufferedWriter(new FileWriter("C://readMore/out/out.txt"));

			for (File file : listOfFiles) {
				
				if (file.isFile()) {
					Scanner scan = new Scanner(file);
					int lineCnt = 0;
					while (scan.hasNextLine()) {
						String readLine = scan.nextLine();						
						if ((lineCnt >= 0 && lineCnt <= 3) || (lineCnt >= 8 && lineCnt <= 11)) {
							out.write(readLine);
							out.newLine();
						}
						lineCnt++;
					}
				}

			}
			out.close();
			////////////////////////////////////////////////////////////////
		} catch (IOException e) {
			System.err.println(e); // 에러가 있다면 메시지 출력
			System.exit(1);
		}
	}
}
