import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static boolean[] visited;
	private static ArrayList<Integer>[] friends;
	private static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		friends = new ArrayList[N+1];
		for (int i = 0 ; i < N+1 ; i++) friends[i] = new ArrayList<>();
		while(true){
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (a == -1 && b == -1) break;
			friends[a].add(b);
			friends[b].add(a);
		}
		
		int minCnt = Integer.MAX_VALUE;
		int[] result = new int[N+1];
		List<Integer> x = new ArrayList<>();
		int many = 0;
		for (int i = 1 ; i < N+1 ; i++) {
			result[i] = vote(i);
			if (result[i] < minCnt) {
				minCnt = result[i];
				many = 1;
			} else if (result[i] == minCnt) many++;
		}
		System.out.println(minCnt + " " + many);
		for (int i = 1 ; i < N+1 ; i++) {
			if (result[i] == minCnt) System.out.print(i + " ");
		}
		
	}
	public static int vote(int s) {
		int[] dist = new int[N+1];
		visited = new boolean[N+1];
		Queue<Integer> q = new LinkedList<>();
		q.offer(s);
		visited[s] = true;
		while(!q.isEmpty()) {
			int cur = q.poll();
			for (int i : friends[cur]) {
				if (visited[i]) continue;
				visited[i] = true;
				dist[i] = dist[cur]+1;
				q.offer(i);
			}
		}
		int cnt = N;
		for (int i = 1 ; i < N+1 ; i++) {
			boolean flag = true;
			for (int j = 1 ; j < N+1 ; j++) {
				if (j == s) continue;
				if (dist[j] > i) flag = false;
			}
			if (flag) {
				cnt = i;
				break;
			}
		}
		return cnt;
	}
}
