import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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
		boolean[] visited = new boolean[N+1];
		Queue<Integer> q = new LinkedList<>();
		int cnt = 0;
		q.offer(1);
		visited[1] = true;
		while(!q.isEmpty()) {
			int cur = q.poll();
			if (dist[cur] >= 2) continue;
			for (int i : friends[cur]) {
				if (visited[i]) continue;
				visited[i] = true;
				dist[i] = dist[cur]+1;
				q.offer(i);
				if (dist[i] >= 1 || dist[i] <= 2) cnt++;
			}
		}
		System.out.print(cnt);
	}

}
