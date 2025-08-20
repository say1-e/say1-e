import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] graph;
	static boolean[] visited;
	static int N,M;
 	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N+1];
		visited = new boolean[N+1];
		for (int i = 1; i<=N; i++) graph[i] = new ArrayList<>();
		
		for (int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}
		
		int cnt = 0;
		for (int i = 1 ; i <= N; i++) {
			if (!visited[i]) {
				bfs(i);
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
	
	static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		visited[start] = true;
		q.add(start);
		
		while(!q.isEmpty()) {
			int v = q.poll();
			for (int next : graph[v]) {
				if (!visited[next]) {
					visited[next] = true;
					q.add(next);
				}
			}
		}
	}

}
