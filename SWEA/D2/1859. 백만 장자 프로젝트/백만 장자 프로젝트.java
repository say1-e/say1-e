import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1 ; tc <= T ; tc++) {
			int N = Integer.parseInt(br.readLine());
			long[] arr = new long[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for (int i = 0 ; i < N ; i++) {
				arr[i] = Long.parseLong(st.nextToken());
				}
			
			long maxCost = 0;
			long sum = 0;
			
			for (int i = N-1 ; i >= 0 ; i--) {
				if (arr[i] <= maxCost) sum += (maxCost - arr[i]);
				else maxCost = arr[i];
			}
			sb.append("#").append(tc).append(" ").append(sum).append("\n");
		}
		System.out.println(sb.toString().trim());
	}
}