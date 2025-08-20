import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] graph;
	static boolean[] visited;
	static int N,M;
	static int cnt;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		graph = new ArrayList[N+1];
		visited = new boolean[N+1];
		for (int i = 1 ; i <= N ; i++) graph[i] = new ArrayList<>();
		
		for (int i = 0 ; i < M ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}
		
		dfs(1);
		System.out.println(cnt);
	}
	
	static void dfs(int v) {
		visited[v] = true;
		for (int next : graph[v]) {
			if (!visited[next]) {
				dfs(next);
				cnt++;
			}
		}
	}

}
