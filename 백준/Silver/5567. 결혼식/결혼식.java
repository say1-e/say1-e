import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		List<Integer>[] friends = new ArrayList[N+1];
		for (int i = 0 ; i < N+1 ; i++) friends[i] = new ArrayList<>();
		for (int i = 0 ; i < M ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			friends[a].add(b);
			friends[b].add(a);
		}
		
		int[] dist = new int[N+1];
		Arrays.fill(dist, -1);
		
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		dist[1] = 0;
		
		int cnt = 0;
		while (!q.isEmpty()) {
			int cur = q.poll();
			if (dist[cur] == 2) continue;
			
			for (int next : friends[cur]) {
				if (dist[next] != -1) continue;
				dist[next] = dist[cur] +1 ;
				q.add(next);
				if (dist[next] >= 1 && dist[next] <= 2) cnt++;
			}
			
		}
		System.out.println(cnt);
	}

}
