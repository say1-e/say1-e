import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		List<Integer>[] farm = new ArrayList[N+1];
		for (int i = 0 ; i < N+1 ; i++) farm[i] = new ArrayList<>();
		for (int i = 0 ; i < M ; i++){
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			farm[a].add(b);
			farm[b].add(a);
		}
		int[] dist = new int[N+1];
		boolean[] visited = new boolean[N+1];
		Deque<Integer> q = new ArrayDeque<>();
		q.add(1);
		dist[1] = 0;
		visited[1] = true;
		
		int maxDist = 0;
		while(!q.isEmpty()) {
			int cur = q.poll();
			for (int i : farm[cur]) {
				if (visited[i]) continue;
				visited[i] = true;
				dist[i] = dist[cur] + 1;
				q.add(i);
				maxDist = Math.max(maxDist, dist[i]);
			}
		}
		List<Integer> list = new ArrayList<>();
		for (int i = 1 ; i <= N ; i++) {
			if (maxDist == dist[i]) list.add(i);
		}
		System.out.println(list.get(0)+" "+maxDist+" "+list.size());
	}

}
