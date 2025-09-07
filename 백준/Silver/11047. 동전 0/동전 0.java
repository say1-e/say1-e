import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] num = new int[N];
		for (int i = 0 ; i < N ; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		int cnt = 0;
		for (int i = N-1 ; i >= 0 ; i--) {
			if (num[i] > K) continue;
			if (K == 0) break;
			for (int j = K / num[i] ; j > 0 ; j--) {
				K %= num[i];
				cnt++;
			}
		}
		System.out.println(cnt);
	}

}
