import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for (int t = 0 ; t < N ; t++) {
			char[] str = br.readLine().toCharArray();
			int sum = 0;
			
			for (int i = 0 ; i < str.length ; i++) {
				for (int j = i+1 ; j < str.length ; j++) {
					if (str[i] == 'a') continue;
					if (str[i] == '(' && str[j] == ')') {
						str[j] = 'a';
						sum++;
						break;
					}
				}
			}
			
			if (str.length % 2 == 1) System.out.println("NO");
			else System.out.println(sum == str.length/2 ? "YES" : "NO");
		}
	}

}
