import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		if (K <= N) {
			System.out.println(N-K);
			return;
		}
		
		int[] map = new int[100001];
		ArrayDeque<Integer> q = new ArrayDeque<>();
		q.add(N);
		map[N] = 0;
		
		while(!q.isEmpty()) {
			int x = q.poll();
			if (x == K) {
				System.out.println(map[x]);
				return;
			}
			
			int nx = x-1;
			if (nx >= 0 && map[nx] == 0) {
				map[nx] = map[x] + 1;
				q.add(nx);
			}
			
			nx = x+1;
			if (nx < 100001 && map[nx] == 0) {
				map[nx] = map[x] + 1;
				q.add(nx);
			}
			
			nx = x*2;
			if (nx < 100001 && map[nx] == 0) {
				map[nx] = map[x] + 1;
				q.add(nx);
			}
		}
	}

}
