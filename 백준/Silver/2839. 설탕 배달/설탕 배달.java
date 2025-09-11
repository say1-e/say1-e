import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int cnt = 0;
		while(N >= 3) {
			if (N % 5 == 0) {
				cnt += N/5;
				break;
			}
			else {
				N -= 3;
				cnt++;
			}
		}
		
		System.out.println((N == 1 || N == 2) ? -1 : cnt);
	}

}
