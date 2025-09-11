import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String pointer = "666";
		int a = 666;
		while(N != 0) {
			String s = ""+a++;
			if (s.contains(pointer)) N--;
		}
		System.out.println(a-1);
	}
}
