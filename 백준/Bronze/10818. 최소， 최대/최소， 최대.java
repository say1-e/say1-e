import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N];
		int mx = Integer.MIN_VALUE;
		int mn = Integer.MAX_VALUE;
		
		String[] input = br.readLine().split(" ");
		for (int i = 0 ; i < N ; i++) {
			num[i] = Integer.parseInt(input[i]);
			mx = Math.max(mx, num[i]);
			mn = Math.min(mn, num[i]);
		}
		
		bw.write(mn+" "+mx);
		
		bw.flush();
		br.close();
		bw.close();
	}
}
