import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		List<int[]>[] graph = new ArrayList[V+1];
		int[] W = new int[V+1];
		for (int i = 1 ; i < V+1 ; i++) {
			graph[i] = new ArrayList<>();
			W[i] = Integer.MAX_VALUE;
		}
		int K = Integer.parseInt(br.readLine());
		for (int i = 0 ; i < E ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph[u].add(new int[] {v,w});
		}
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1] - b[1]);
		W[K] = 0;
		pq.offer(new int[] {K,0}); //간선 수, w값
		
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			int cv = cur[0];
			int cw = cur[1];
			if (cw != W[cv]) continue; // 오래된(더 긴) 후보면 스
			for (int[] next : graph[cv]) {
				int nv = next[0];
				int nw = next[1];
				int nextW = cw + nw;
				if (nextW < W[nv]) {
					W[nv] = nextW;
					pq.offer(new int[] {nv, nextW});
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= V ; i++) {
			if (W[i] == Integer.MAX_VALUE) sb.append("INF\n");
			else sb.append(W[i]).append("\n");
		}
		System.out.println(sb.toString());
	}

}
