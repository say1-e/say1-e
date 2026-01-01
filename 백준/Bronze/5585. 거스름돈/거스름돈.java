import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int rest = 1000 - n;
		int answer = 0;
		int[] coin = {500, 100, 50, 10, 5, 1};
		int idx = 0;
		
		while (rest > 0) {
			answer += rest / (coin[idx]);
			rest %= coin[idx++];
		}
		
		System.out.println(answer);
	}
}