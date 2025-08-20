import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] graph;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		//그래프 초기화
		graph = new ArrayList[N+1];
		for (int i = 1 ; i <= N ; i++) graph[i] = new ArrayList<>();
		
		//간선 입력
		for (int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}
		
		//정점 번호가 작은 것부터 방문해야 하므로 정렬
		for (int i = 1 ; i <= N ; i++) {
			Collections.sort(graph[i]);
		}
		
		//DFS 실행
		visited = new boolean[N+1];
		dfs(V);
		sb.append("\n");
		
		//BFS 실행
		visited = new boolean[N+1];
		bfs(V);
		
		System.out.println(sb.toString().trim());
	}
	
	//DFS(재귀)
	static void dfs(int v) {
		visited[v] = true;
		sb.append(v).append(" ");
		
		for (int next : graph[v]) {
			if (!visited[next]) dfs(next);
		}
	}
	
	//BFS(큐)
	static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		visited[start] = true;
		q.offer(start);
		
		while (!q.isEmpty()) {
			int v = q.poll();
			sb.append(v).append(" ");
			
			for (int next : graph[v]) {
				if (!visited[next]) {
					visited[next] = true;
					q.offer(next);
				}
			}
		}
	}

}
