import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		for (int i = 0 ; i < n ; i++) arr[i] = Integer.parseInt(br.readLine());
		int[] dp = new int[k+1];
		dp[0] = 1;
		for (int coin : arr) {
			for (int i = coin ; i <= k ; i++) {
				dp[i] += dp[i-coin];
			}
		}
		System.out.println(dp[k]);
	}
}
